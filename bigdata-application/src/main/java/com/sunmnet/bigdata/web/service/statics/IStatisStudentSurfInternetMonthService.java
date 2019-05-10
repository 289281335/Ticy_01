/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-31 17:13:05
 */

package com.sunmnet.bigdata.web.service.statics;

import com.sunmnet.bigdata.web.model.entity.statics.StatisStudentSurfInternetMonth;
import com.sunmnet.bigdata.web.model.request.statis.StatisStudentSurfInternetMonthREQ;
import com.sunmnet.bigdata.web.model.response.statis.SurfInternetStatusRES;

import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStatisStudentSurfInternetMonthService
 * @Description
 * @date 2018-01-31 17:13:05
 */
public interface IStatisStudentSurfInternetMonthService {

    /**
     * 获得近七周的上网时长信息
     * @param studentNo
     * @return
     */
    StatisStudentSurfInternetMonth last7WeekSurfInternet(String studentNo);

    /**
     * 获得个人画像-综合画像个人选项卡上网信息
     * @return
     */
    SurfInternetStatusRES getStudentNetTag(String studentNo);


    /**
     * 学生近一月上网时长统计
     * @param statisStudentSurfInternetMonthREQ
     * @return
     */
    Map<String,Object> analyseNetTime(StatisStudentSurfInternetMonthREQ statisStudentSurfInternetMonthREQ);

    /**
     * 学生近一月上网时间段统计统计
     * @param statisStudentSurfInternetMonthREQ
     * @return
     */
    Map<String,Object> analysePeriodOfMonthNet(StatisStudentSurfInternetMonthREQ statisStudentSurfInternetMonthREQ);


    /**
     * 根据学号查询上网健康度
     */
    Map<String, Object> netHealthRatio(String studentNo);
}
