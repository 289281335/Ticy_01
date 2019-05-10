/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */

package com.sunmnet.bigdata.web.service.alarm;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IAlarmStudentTruancyService
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IAlarmStudentTruancyService {

    /**
     *  学业预警历史预警趋势
     *
     *  @return List<Map<String,Object>>
     * */
    List<Map<String,Object>> historyTruancy();

}
