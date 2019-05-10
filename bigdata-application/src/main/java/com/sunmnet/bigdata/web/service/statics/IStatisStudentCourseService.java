/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */

package com.sunmnet.bigdata.web.service.statics;

import com.sunmnet.bigdata.commons.model.PageResult;
import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.model.entity.statics.StatisStudentCourse;
import com.sunmnet.bigdata.web.model.request.student.PageStudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStatisStudentCourseService
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IStatisStudentCourseService  {
    /**
     * 查询学习相关标签
     * @param studentNo
     * @return
     */
     Map<String, Object> queryStudiesLabel(String studentNo);

    /**
     * 查询学生到课率
     * @param studentNo
     * @param queryType
     * @return
     */
    Map<String, Object> queryClassRate(String studentNo, String queryType);

    /**
     * 查询分析学生到课时间
     * @param studentNo
     * @return
     */
    Map<String ,Object> queryAnalysisClassRateTime(String studentNo);

    PageRES<PageStudentInfoREQ> pageClassAttendanceDetail(PageStudentInfoREQ pageStudentInfoREQ);

    Map<String, Object> queryAllSuspectedTruancyInfo(StudentInfoREQ studentInfoREQ);

    PageRES<Map<String,Object>> pageAllSuspectedTruancyInfo(PageStudentInfoREQ pageStudentInfoREQ);
}
