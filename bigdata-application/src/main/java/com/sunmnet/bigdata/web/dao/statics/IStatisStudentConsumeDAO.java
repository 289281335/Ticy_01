/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.dao.statics;

import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStatisStudentConsumeDAO
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IStatisStudentConsumeDAO {

    List<Map<String, Object>> avgMonthConsume(StudentInfoREQ studentInfoREQ);

}
