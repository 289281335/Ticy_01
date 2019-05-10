/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-31 10:45:21
 */
package com.sunmnet.bigdata.web.dao.statics;

import com.sunmnet.bigdata.web.model.entity.statics.StatisStudentCourseTime;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStatisStudentCourseTimeDAO
 * @Description
 * @date 2018-01-31 10:45:21
 */
public interface IStatisStudentCourseTimeDAO {

    /***
     * 查询学生的平均上课准点率
     * @param studentNo
     * @param startDate
     * @param endDate
     * @return
     */
    List<StatisStudentCourseTime> listStatisCourseTimeByStudentNo(@Param("studentNo") String studentNo,
                                 @Param("startDate") String startDate, @Param("endDate") String endDate);

    /***
     * 群体画像(准时上课情况)
     * @param studentInfoREQ
     * @return
     */
    List<Map<String,Object>> onTimeForClass(@Param("studentNo") StudentInfoREQ studentInfoREQ);
}
