/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-31 10:45:21
 */
package com.sunmnet.bigdata.web.service.statics.impl;

import com.sunmnet.bigdata.web.dao.statics.IStatisStudentCourseTimeDAO;
import com.sunmnet.bigdata.web.model.entity.statics.StatisStudentCourseTime;
import com.sunmnet.bigdata.web.model.request.statis.StatisStudentCourseTimeREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.service.statics.IStatisStudentCourseTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StatisStudentCourseTimeServiceImpl
 * @Description
 * @date 2018-01-31 10:45:21
 */
@Transactional
@Service("StatisStudentCourseTimeServiceImpl")
public class StatisStudentCourseTimeServiceImpl implements IStatisStudentCourseTimeService {
    @Autowired
    private IStatisStudentCourseTimeDAO statisStudentCourseTimeDAO;


    @Override
    public List<StatisStudentCourseTime> listStatisCourseTimeByStudentNo(StatisStudentCourseTimeREQ statisStudentCourseTimeREQ) {
        return statisStudentCourseTimeDAO.listStatisCourseTimeByStudentNo(statisStudentCourseTimeREQ.getStudentNo(),
                statisStudentCourseTimeREQ.getStartDate(),statisStudentCourseTimeREQ.getEndDate());
    }

    @Override
    public List<Map<String, Object>> onTimeForClass(StudentInfoREQ studentInfoREQ) {
        return statisStudentCourseTimeDAO.onTimeForClass(studentInfoREQ);
    }


}
