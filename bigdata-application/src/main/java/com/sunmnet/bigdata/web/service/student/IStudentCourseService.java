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
 * @ClassName IStudentCourseService
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IStudentCourseService {
    /**
     * 疑似逃课
     * @param studentNo
     * @return
     */
    List<Map<String, Object>> querySuspectedTruancyInfo(String studentNo);
}
