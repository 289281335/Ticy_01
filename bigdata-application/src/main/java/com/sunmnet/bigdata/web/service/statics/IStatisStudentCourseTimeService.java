/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-31 10:45:21
 */

package com.sunmnet.bigdata.web.service.statics;

import com.sunmnet.bigdata.web.model.entity.statics.StatisStudentCourseTime;
import com.sunmnet.bigdata.web.model.request.statis.StatisStudentCourseTimeREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStatisStudentCourseTimeService
 * @Description
 * @date 2018-01-31 10:45:21
 */
public interface IStatisStudentCourseTimeService {

    /***
     * 查询学生的平均上课准点率
     * @param statisStudentCourseTimeREQ
     * @return
     */
    List<StatisStudentCourseTime> listStatisCourseTimeByStudentNo(StatisStudentCourseTimeREQ statisStudentCourseTimeREQ);


    /***
     * 群体画像(准时上课情况)
     * @param studentInfoREQ
     * @return
     */
    List<Map<String,Object>> onTimeForClass(StudentInfoREQ studentInfoREQ);
}
