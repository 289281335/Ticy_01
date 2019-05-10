/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */
package com.sunmnet.bigdata.web.service.student.impl;

import com.sunmnet.bigdata.web.Constants;
import com.sunmnet.bigdata.web.dao.student.IStudentConsumptionIndexDAO;
import com.sunmnet.bigdata.web.dao.student.IStudentInfoDAO;
import com.sunmnet.bigdata.web.dao.student.IStudentRestDAO;
import com.sunmnet.bigdata.web.model.entity.student.StudentRest;
import com.sunmnet.bigdata.web.model.enums.GenderEnum;
import com.sunmnet.bigdata.web.model.enums.SleepLableEnum;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentRestREQ;
import com.sunmnet.bigdata.web.model.response.student.StudentInfoRES;
import com.sunmnet.bigdata.web.model.response.student.StudentSleepLableRES;
import com.sunmnet.bigdata.web.service.student.IStudentRestService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentRestServiceImpl
 * @Description
 * @date 2018-01-30 09:48:59
 */
@Transactional
@Service("StudentRestServiceImpl")
public class StudentRestServiceImpl implements IStudentRestService {

    @Autowired
    private IStudentRestDAO studentRestDAO;

    @Autowired
    private IStudentInfoDAO studentInfoDAO;

    @Autowired
    private IStudentConsumptionIndexDAO studentConsumptionIndexDAO;




    /**
     * 查询最近7天睡眠情况
     * Constants.LAST_7_DAYS
     */
    @Override
    public List<StudentRest> last7DaysRest(String studentNo) {
        return studentRestDAO.listRestByStudentNo(studentNo);
    }


    /**
     * 查询睡眠时长
     */
    @Override
    public Map<String, Object> sleepTime(String studentNo) {
        Map<String, Object> map = new HashMap<String, Object>();
        //查询学生各时间阶段睡觉次数
        List<Map<String, Object>> list = studentRestDAO.sleepTime(studentNo);
        Map<String, Object> restMap = new HashMap<>();
        for(Map<String, Object> sleepStageMap : list){
            restMap.putAll(sleepStageMap);
        }
        map.put("rest", restMap);
        //查询全校学生平均睡觉时长
        BigDecimal schoolAverage = studentRestDAO.avgSleepTimeOfSchool();

        map.put("schoolAverage", schoolAverage != null?schoolAverage.setScale(2,BigDecimal.ROUND_HALF_UP):"0");
        //查询学生平均睡觉时长
        BigDecimal personAverage = studentRestDAO.avgSleepTimeOfStudent(studentNo);
        map.put("personAverage", personAverage != null ? personAverage.setScale(2,BigDecimal.ROUND_HALF_UP) : "0");
        return map;
    }


    /**
     * 查询睡眠规律度
     */
    @Override
    public Map<String, Object> sleepRegularity(String studentNo) {
        Map<String, Object> map = new HashMap<String, Object>();
        BigDecimal regularity = studentRestDAO.sleepRegularity(studentNo);
        if(regularity != null) {
            if(regularity.compareTo(new BigDecimal(0)) < 0) {
                regularity = new BigDecimal(0);
            }
        }
        map.put("regularity",regularity== null? null:regularity.setScale(0, BigDecimal.ROUND_HALF_UP));

        return map;
    }



    /**
     * 查询作息标签
     */
    public StudentSleepLableRES sleepLable(String studentNo) {
        StudentSleepLableRES studentSleepLableRES = new StudentSleepLableRES();
        Map<String, Object> map = new HashMap<String, Object>();
        //查询学生信息
        StudentInfoRES info = studentInfoDAO.getStudentByNo(studentNo);
        StringBuffer sleepSitLable = new StringBuffer();
        //查询早睡次数
        Integer sleepEarlyTimes = studentRestDAO.earlySleepTimes(studentNo);
        //查询晚睡次数
        Integer sleepLateimes = studentRestDAO.lateSleepTimes(studentNo);
        //查询早起次数
        Integer getupEarlyTimes = studentRestDAO.earlyGetupTimes(studentNo);
        //查询晚期次数
        Integer getupLateTimes = studentRestDAO.lateGetupTimes(studentNo);
        if(sleepEarlyTimes > Constants.ZERO_VALUE_TOTAL
                || sleepLateimes > Constants.ZERO_VALUE_TOTAL) {
            if(sleepEarlyTimes >= sleepLateimes) {
                studentSleepLableRES.setSleepLabel(SleepLableEnum.SLEEP_EARLY.getName());
            }else {
                studentSleepLableRES.setSleepLabel(SleepLableEnum.SLEEP_LATE.getName());
            }
        }
        if(getupEarlyTimes > Constants.ZERO_VALUE_TOTAL
                || getupLateTimes > Constants.ZERO_VALUE_TOTAL ) {
            if(getupEarlyTimes >= getupLateTimes) {
                studentSleepLableRES.setGetupLabel(SleepLableEnum.GETUP_EARLY.getName());
            }else {
                studentSleepLableRES.setGetupLabel(SleepLableEnum.GETUP_LATE.getName());
            }
        }

        //查询日均睡眠时长
        StringBuffer sleepTimeLable = new StringBuffer();
        BigDecimal sleepTime = studentRestDAO.avgSleepTimeOfStudent(studentNo);
        if(sleepTime != null) {
            if(sleepTime.doubleValue() >= SleepLableEnum.DEEP_DROWSINESS.getLevel()) {
                studentSleepLableRES.setSleepTimeLabel(SleepLableEnum.DEEP_DROWSINESS.getName());
            }else if(sleepTime.doubleValue() >= SleepLableEnum.DEEP_ENOUGH.getLevel()) {
                studentSleepLableRES.setSleepTimeLabel(SleepLableEnum.DEEP_ENOUGH.getName());
            }else if(sleepTime.doubleValue() >= SleepLableEnum.DEEP_HYPOSOMNIA.getLevel()) {
                studentSleepLableRES.setSleepTimeLabel(SleepLableEnum.DEEP_HYPOSOMNIA.getName());
            }else {
                studentSleepLableRES.setSleepTimeLabel(SleepLableEnum.DEEP_LACK.getName());
            }
        }
        // 外出情况
        StringBuffer leaveSchoolLable = new StringBuffer();
        String weekOutIndex = studentConsumptionIndexDAO.weekOutIndex(studentNo);
        if(StringUtils.isNotEmpty(weekOutIndex)) {
            double index = Double.valueOf(weekOutIndex);
            if(index > SleepLableEnum.OUT_VERY_ACTIVE.getLevel()){
                studentSleepLableRES.setPersonalityLabel(SleepLableEnum.OUT_VERY_ACTIVE.getName());
            } else if(index >= SleepLableEnum.OUT_ACTIVE.getLevel()){
                studentSleepLableRES.setPersonalityLabel(SleepLableEnum.OUT_ACTIVE.getName());
            } else {
                if (info.getGender().equals(GenderEnum.MAN.getName())){
                    studentSleepLableRES.setPersonalityLabel(SleepLableEnum.OTAKU_MAN.getName());
                } else {
                    studentSleepLableRES.setPersonalityLabel(SleepLableEnum.OTAKU_WOMAN.getName());
                }

            }
        }
        return studentSleepLableRES;
    }

    @Override
    public Map<String, Object> sleepTimeOfTeam(StudentRestREQ studentRestREQ) {
        return studentRestDAO.sleepTimeOfTeam(studentRestREQ);
    }

    @Override
    public Map<String, Object> sleepRateOfTeam(StudentRestREQ studentRestREQ) {
        return studentRestDAO.sleepRateOfTeam(studentRestREQ);
    }

    @Override
    public Map<String, Object> getUpRateOfTeam(StudentRestREQ studentRestREQ) {
        return studentRestDAO.getUpRateOfTeam(studentRestREQ);
    }


    /**
     * 根据条件查询平均睡眠时长(整体画像)
     */
    @Override
    public double avgSleeptimeByCondition(StudentInfoREQ studentInfoREQ) {
        BigDecimal sleepTime = studentRestDAO.avgSleeptimeByCondition(studentInfoREQ);
        return sleepTime != null ? sleepTime.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() : 0d;
    }
}
