/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */
package com.sunmnet.bigdata.web.service.student.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.Commons;
import com.sunmnet.bigdata.web.dao.statics.IStatisStudentSurfInternetMonthDAO;
import com.sunmnet.bigdata.web.dao.student.IStudentFriendDAO;
import com.sunmnet.bigdata.web.dao.student.IStudentInfoDAO;
import com.sunmnet.bigdata.web.model.entity.student.StudentInfo;
import com.sunmnet.bigdata.web.model.request.alarm.AlarmStudentREQ;
import com.sunmnet.bigdata.web.model.request.statis.StatisStudentSurfInternetMonthREQ;
import com.sunmnet.bigdata.web.model.request.student.PageStudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.response.alarm.AlarmStudentRES;
import com.sunmnet.bigdata.web.model.response.portrait.StudentsLabelRES;
import com.sunmnet.bigdata.web.model.response.student.StudentInfoRES;
import com.sunmnet.bigdata.web.service.alarm.IAlarmStudentSubjectsService;
import com.sunmnet.bigdata.web.service.statics.IStatisStudentConsumeService;
import com.sunmnet.bigdata.web.service.statics.IStatisStudentScoresRecordService;
import com.sunmnet.bigdata.web.service.statics.IStatisStudentSurfInternetMonthService;
import com.sunmnet.bigdata.web.service.student.IStudentConsumptionIndexService;
import com.sunmnet.bigdata.web.service.student.IStudentInfoService;
import com.sunmnet.bigdata.web.service.student.IStudentRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentInfoServiceImpl
 * @Description
 * @date 2018-01-30 09:48:59
 */
@Transactional
@Service("StudentInfoServiceImpl")
public class StudentInfoServiceImpl implements IStudentInfoService {
    @Autowired
    private IStudentInfoDAO studentInfoDAO;
    @Autowired
    private IStatisStudentSurfInternetMonthDAO statisStudentSurfInternetMonthDAO;
    @Autowired
    private IStudentConsumptionIndexService studentConsumptionIndexService;
    @Autowired
    private IStatisStudentScoresRecordService statisStudentScoresRecordService;
    @Autowired
    private IStatisStudentConsumeService statisStudentConsumeService;

    @Autowired
    private IStudentRestService studentRestService;


    @Autowired
    private IAlarmStudentSubjectsService alarmStudentSubjectsService;


    @Autowired
    private IStatisStudentSurfInternetMonthService statisStudentSurfInternetMonthService;





    @Autowired
    private IStudentFriendDAO studentFriendDAO;
















    @Override
    public StudentInfo getStudentByNo(String studentNo) {
        return studentInfoDAO.getStudentByNo(studentNo);
    }

    @Override
    public PageRES<StudentInfoRES> pageStudentInfo(PageStudentInfoREQ pageStudentInfoREQ) {
        Pageable pageable = pageStudentInfoREQ.getPageable();
        StudentInfoREQ studentInfoREQ = pageStudentInfoREQ.getStudentInfoREQ();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());

        List<StudentInfoRES> list = studentInfoDAO.listStudentInfo(studentInfoREQ, pageable.getSort());
        Page<StudentInfoRES> count = (Page<StudentInfoRES>)list;
        return new PageRES(list,pageable, count.getTotal());
    }


    /***
     * 学生群体的画像
     * @param studentInfoREQ
     * @return
     */
    @Override
    public StudentsLabelRES studentsInfo(StudentInfoREQ studentInfoREQ) {
        StudentsLabelRES studentsLabelRES = new StudentsLabelRES();

        // 日均上网时长
        Double avgNetTime = statisStudentSurfInternetMonthDAO.getAvgNetTime(studentInfoREQ);
        // 获得学霸数
        Integer xbCount = studentConsumptionIndexService.excellentStudents(studentInfoREQ);
        // 获得挂科人数
        Integer gkCount = statisStudentScoresRecordService.countFailSubject(studentInfoREQ);
        // 日均消费额
        double dayAvgAmount = statisStudentConsumeService.avgDayConsume(studentInfoREQ);
        // 日均睡眠时长
        double sleepTime = studentRestService.avgSleeptimeByCondition(studentInfoREQ);
        //获得预警数量
        Integer warnCount = alarmStudentSubjectsService.countSubjectAndBehaviorWarning(studentInfoREQ);

        studentsLabelRES.setWarnQuantity(warnCount);
        studentsLabelRES.setAvgNetTime(avgNetTime);
        studentsLabelRES.setExcellentStudents(xbCount);
        studentsLabelRES.setAvgConsum(dayAvgAmount);
        studentsLabelRES.setAvgSleepTime(sleepTime);
        studentsLabelRES.setFailSubjects(gkCount);
        studentsLabelRES.setLoseWorkCount(12);
        return studentsLabelRES;
    }


    /***
     * 统计各个维度的学生人数
     * @param studentInfoREQ
     * @return
     */
    @Override
    public List<Map<String, Object>> countStudentByCategory(StudentInfoREQ studentInfoREQ) {
        //获得男女生人数
        Map<String, Object> student = Commons.convertListMap2Map(studentInfoDAO.countCategoryByGender(studentInfoREQ));
        //获取社交人数
        Map<String, Object> social = Commons.convertListMap2Map(studentFriendDAO.countFriendByCategary(studentInfoREQ));
        //获取上网人数
        Map<String, Object> netTime = statisStudentSurfInternetMonthService.analyseNetTime
                (Commons.convertStudentInfoREQ2StatisStudentSurfInternetMonthREQ(studentInfoREQ));
        Long netTime_good = (Long) netTime.get("5") + (Long) netTime.get("6");
        Long netTime_normal = (Long) netTime.get("3") + (Long) netTime.get("4");
        Long netTime_bad = (Long) netTime.get("1") + (Long) netTime.get("2");
        Map<String, Object> net = new HashMap<String, Object>();
        net.put("netTime_bad", netTime_bad);
        net.put("netTime_normal", netTime_normal);
        net.put("netTime_good", netTime_good);
        //获取作息人数
        Map<String, Object> sleep = new HashMap<String,Object>();
        sleep.put("sleep_bad", 213);
        sleep.put("sleep_normal", 467);
        sleep.put("sleep_good", 216);
        //获取各学习水平人数
        Map<String, Object> raw_study = studentConsumptionIndexService.levelForTeam(studentInfoREQ);
        Map<String, Object> study = new HashMap<String, Object>();
        study.put("study_bad", raw_study.get("lowRate"));
        study.put("study_normal", raw_study.get("middleRate"));
        study.put("study_good", raw_study.get("highRate"));
        //三餐消费人数
        Map<String, Object> raw_eat = studentConsumptionIndexService.dietRegularRate(studentInfoREQ);
        Map<String, Object> eat = new HashMap<String, Object>();
        eat.put("eat_bad", raw_eat.get("lowRate"));
        eat.put("eat_normal", raw_eat.get("middleRate"));
        eat.put("eat_good", raw_eat.get("highRate"));
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(student);
        list.add(social);
        list.add(net);
        list.add(sleep);
        list.add(study);
        list.add(eat);
        return list;
    }

    /**
     * 根据性别和学位统计学生结构
     *
     * @param studentInfoREQ
     * @return
     */
    @Override
    public  List<Map<String,Object>> countStructureByDegreeAndGender(StudentInfoREQ studentInfoREQ) {
        return studentInfoDAO.countStructureByDegreeAndGender(studentInfoREQ);
    }

    /**
     * 根据学位和生源地统计学生分布
     *
     * @param studentInfoREQ
     * @return
     */
    @Override
    public  List<Map<String,Object>> countStructureByDegreeAndNativePlace(StudentInfoREQ studentInfoREQ) {
        return studentInfoDAO.countStructureByDegreeAndNativePlace(studentInfoREQ);
    }


}
