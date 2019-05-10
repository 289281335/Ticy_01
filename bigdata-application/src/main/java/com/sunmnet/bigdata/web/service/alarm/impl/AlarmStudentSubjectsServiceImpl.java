/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.alarm.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.dao.alarm.IAlarmLateBackDAO;
import com.sunmnet.bigdata.web.dao.alarm.IAlarmStudentSubjectsDAO;
import com.sunmnet.bigdata.web.model.request.alarm.PageAlarmTruancySubjectsREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.response.alarm.AlarmStudentSubjectsLabelRES;
import com.sunmnet.bigdata.web.service.alarm.IAlarmStudentSubjectsService;
import com.sunmnet.bigdata.web.util.MasterUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName AlarmStudentSubjectsServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("AlarmStudentSubjectsServiceImpl")
public class AlarmStudentSubjectsServiceImpl implements IAlarmStudentSubjectsService{
    @Autowired
    private IAlarmStudentSubjectsDAO alarmStudentSubjectsDAO;

    @Autowired
    private IAlarmLateBackDAO alarmLateBackDAO;




    @Override
    public AlarmStudentSubjectsLabelRES subjects() {
        AlarmStudentSubjectsLabelRES alarmStudentSubjectsLabelRES =
                new AlarmStudentSubjectsLabelRES();
        /**
         * 查询待处理学业预警总数量
         * */
        int a = alarmStudentSubjectsDAO.recentlyTruancy();
        int b = alarmStudentSubjectsDAO.recentlyEarlyFailWarning();
        int total = a+b;
        alarmStudentSubjectsLabelRES.setTotalSubjects(total);
        /**
         * 查询本月预警数量
         * */
        String thisMonthSum = alarmStudentSubjectsDAO.failWarningOfMonth();
        alarmStudentSubjectsLabelRES.setMonthSubjects(StringUtils.isNotEmpty(thisMonthSum)?thisMonthSum:"0");

        /**
         * 查询上月预警数量
         * */
        String lastMonthSum = alarmStudentSubjectsDAO.failWarningOfLastMonth();
        /**
         * 计算环比增长
         * */
        int c = Integer.parseInt(thisMonthSum);
        int d = Integer.parseInt(lastMonthSum);
        float e =(float) ((c-d))/d;
        DecimalFormat df = new DecimalFormat("#.#");
        String increaseSum = df.format(e);
        alarmStudentSubjectsLabelRES.setRoseSubjects(increaseSum);
        /**
         * 查询学业预警月均条数
         * */
        String oneYearSum = alarmStudentSubjectsDAO.failWarningOfYear();
        alarmStudentSubjectsLabelRES.setYearSubjects(oneYearSum);
        /**
         * 查询预警数量达到最高日期
         * */
        String maxWarningName = alarmStudentSubjectsDAO.maxFailWarning();
        alarmStudentSubjectsLabelRES.setMaxSubjects(maxWarningName);
        return alarmStudentSubjectsLabelRES;
    }


    /***
     * 学业预警和行为预警总计
     * @param studentInfoREQ
     * @return
     */
    @Override
    public Integer countSubjectAndBehaviorWarning(StudentInfoREQ studentInfoREQ) {
        MasterUtil util = new MasterUtil();
        String startTime = util.getMaster();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
        String endTime = df.format(new Date());
        studentInfoREQ.setStartDate(startTime);
        studentInfoREQ.setEndDate(endTime);

        /**
         * 学业预警数量
         * */
        Integer studyNum = alarmStudentSubjectsDAO.countSubjectWarning(studentInfoREQ);
        /**
         * 行为预警数量
         * */
        Integer actionWarningCount = alarmLateBackDAO.countDealWarning(studentInfoREQ);

        return studyNum+actionWarningCount;
    }

    @Override
    /**
     * 挂科和逃课预警
     * @param pageAlarmTruancySubjectsREQ
     * @return
     */
    public PageRES<PageAlarmTruancySubjectsREQ> pageTruancySubjectsWaring(PageAlarmTruancySubjectsREQ pageAlarmTruancySubjectsREQ){
        Pageable pageable = pageAlarmTruancySubjectsREQ.getPageable();
        List list=alarmStudentSubjectsDAO.pageTruancySubjectsWaring(pageAlarmTruancySubjectsREQ);
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        Page count=(Page)list;
        return new PageRES(list,pageable,count.getTotal());
    }

}
