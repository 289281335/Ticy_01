/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */
package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentRest;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentRestREQ;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentRestDAO
 * @Description
 * @date 2018-01-30 09:48:59
 */
public interface IStudentRestDAO {

    /***
     * 查询最近睡觉信息
     * @param
     * @param
     * @return
     */
    List<StudentRest> listRestByStudentNo(String studentNo);

    /***
     * 查询各睡眠时长次数
     * @param studentNo
     * @return
     */
    List<Map<String,Object>> sleepTime(String studentNo);

    /***
     * 查询全校学生平均睡眠时长
     * @return
     */
    BigDecimal avgSleepTimeOfSchool();

    /***
     *  查询学生平均睡眠时长
     * @param studentNo
     * @return
     */
    BigDecimal avgSleepTimeOfStudent(String studentNo);

    /***
     * 查询睡眠规律度指数
     * @param studentNo
     * @return
     */
    BigDecimal sleepRegularity(String studentNo);

    /**
     * 查询外出指数
     * @param studentNo
     * @return
     */
    public String getWeekOutIndex(String studentNo);


    /***
     * 查询早睡次数
     * @param studentNo
     * @return
     */
    Integer earlySleepTimes(String studentNo);

    /***
     * 查询晚睡次数
     * @param studentNo
     * @return
     */
    Integer lateSleepTimes(String studentNo);

    /***
     * 查询早起次数
     * @param studentNo
     * @return
     */
    Integer earlyGetupTimes(String studentNo);


    /***
     * 查询晚起次数
     * @param studentNo
     * @return
     */
    Integer lateGetupTimes(String studentNo);

    /***
     * 根据条件查询睡眠时长人数(综合画像)
     * @param studentRestREQ
     * @return
     */
    Map<String, Object> sleepTimeOfTeam(StudentRestREQ studentRestREQ);

    /***
     * 查询睡觉时间点比率(群体画像)
     * @param studentRestREQ
     * @return
     */
    Map<String, Object> sleepRateOfTeam(StudentRestREQ studentRestREQ);

    /***
     * 查询起床时间点比率(综合画像)
     * @param studentRestREQ
     * @return
     */
    Map<String, Object> getUpRateOfTeam(StudentRestREQ studentRestREQ);


    /***
     * 根据条件查询平均睡眠时长
     * @param studentInfoREQ
     * @return
     */
    BigDecimal avgSleeptimeByCondition(StudentInfoREQ studentInfoREQ);



}
