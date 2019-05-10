/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.dao.statics;

import com.sunmnet.bigdata.web.model.entity.statics.StatisStudentCourse;
import com.sunmnet.bigdata.web.model.request.student.PageStudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStatisStudentCourseDAO
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IStatisStudentCourseDAO {
    /**
     * 根据学号查询上课情况
     * @param studentNo
     * @param fromDate
     * @param toDate
     * @return
     */
    List<StatisStudentCourse> selectClassRecordByStudentNo(String studentNo, @Param("fromDate") String fromDate, @Param("toDate") String toDate);

    List<Map<String,Object>> selectClassRateByStudentNumberAndTerm(String studentNo);

    Map<String,Object> selectClassTimeByStudentNo(String studentNo, @Param("fromDate") String fromDate, @Param("toDate") String toDate);

    List selectClassDetailByStudentNo(StudentInfoREQ studentInfoREQ);

    List selectTruancyTimesByCondition(StudentInfoREQ studentInfoREQ);

    List selectTruancyStudentByCondition(StudentInfoREQ studentInfoREQ);

//    List<Map<String,Object>> selectSemesterAverageScoreByStudentNo(String studentNo);
}
