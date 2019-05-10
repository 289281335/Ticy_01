/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */
package com.sunmnet.bigdata.web.dao.student;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentCourseRecordDAO
 * @Description
 * @date 2018-01-30 09:48:59
 */
public interface IStudentCourseRecordDAO {
    /**
     * 学生逃课记录
     * @param studentNo
     * @return
     */
    List<Map<String,Object>> selectTruancyRecordByStudentNo(String studentNo);
}
