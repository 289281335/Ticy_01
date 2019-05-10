/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.dao.student;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentConsumeDetailDAO
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IStudentConsumeDetailDAO {
    //综合画像 一卡通消费趋势分析 男女月平均
    List<Map<String,Object>> countConsumeTrendByGender(@Param("gender")String gender, @Param("consumeTime")String consumeTime);
    //综合画像 一卡通消费趋势分析 校总体月平均
    List<Map<String,Object>> countConsumeTrendAll(@Param("consumeTime")String consumeTime);
}
