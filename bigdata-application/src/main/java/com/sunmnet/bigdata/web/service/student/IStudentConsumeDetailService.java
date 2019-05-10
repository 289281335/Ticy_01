/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */

package com.sunmnet.bigdata.web.service.student;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentConsumeDetailService
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IStudentConsumeDetailService {
    /**
     * 综合画像 一卡通消费趋势分析
     * @param gender
     * @param consumeTime
     * @return
     */
    Map<String,Object> countConsumeTrend(String gender, String consumeTime);
}
