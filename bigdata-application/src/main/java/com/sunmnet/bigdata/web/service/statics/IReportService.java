/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */

package com.sunmnet.bigdata.web.service.statics;

import java.util.Map;

/**
 *统计服务类
 */
public interface IReportService {

    /**
     * 按月查询预警数量趋势
     * @return
     */
    Map<String, Object> countAlarmByMonth();

    /**
     * 查询预警数量学院排名
     * @return
     */
    Map<String,Object> queryAlarmCollegeRank();

    /**
     * 查询预警处理效率学院排名
     * @return
     */
    Map<String,Object> queryAlarmDealRank();

    /**
     * 查询预警准确率
     * @return
     */
    Map<String,Object> queryAlarmAccuracyRate();
}
