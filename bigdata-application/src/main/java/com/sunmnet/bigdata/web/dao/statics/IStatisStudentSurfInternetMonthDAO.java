/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-31 17:13:05
 */
package com.sunmnet.bigdata.web.dao.statics;

import com.sunmnet.bigdata.web.model.entity.statics.StatisStudentSurfInternetMonth;
import com.sunmnet.bigdata.web.model.request.statis.StatisStudentSurfInternetMonthREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStatisStudentSurfInternetMonthDAO
 * @Description
 * @date 2018-01-31 17:13:05
 */
public interface IStatisStudentSurfInternetMonthDAO {



    /**
     * 获得近七周的上网时长信息
     * @param studentNo
     * @return
     */
    StatisStudentSurfInternetMonth getSurfInternetOfMonth(String studentNo);

    /**
     * 学生近一月上网时长统计
     * @param statisStudentSurfInternetMonthREQ
     * @return
     */
    List<Map<String, Object>> analyseNetTime(StatisStudentSurfInternetMonthREQ statisStudentSurfInternetMonthREQ);

    /**
     * 学生近一月上网时间段统计统计
     * @param statisStudentSurfInternetMonthREQ
     * @return
     */
    List<Map<String, Object>> statisPeriodOfMonthNet(StatisStudentSurfInternetMonthREQ statisStudentSurfInternetMonthREQ);


    /***
     * 日均上网时长
     * @param studentInfoREQ
     * @return
     */
    Double getAvgNetTime(StudentInfoREQ studentInfoREQ);
}
