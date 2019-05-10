/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */

package com.sunmnet.bigdata.web.service.statics;

import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStatisStudentConsumeService
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IStatisStudentConsumeService {

    List<Map<String, Object>> avgMonthConsume(StudentInfoREQ studentInfoREQ);

    /***
     * 日均消费金额(综合画像)
     * @param studentInfoREQ
     * @return
     */
    double avgDayConsume(StudentInfoREQ studentInfoREQ);
}
