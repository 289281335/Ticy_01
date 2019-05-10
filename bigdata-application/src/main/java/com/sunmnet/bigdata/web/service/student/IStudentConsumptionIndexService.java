/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */

package com.sunmnet.bigdata.web.service.student;

import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;

import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentConsumptionIndexService
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IStudentConsumptionIndexService {
    Map<String, Object> studyState() ;

    Map<String, Object> socialState() ;

    Map<String, Object> eatState() ;

    Map<String, Object> poorPeople() ;

    Map<String, Integer> webState() ;

    Map<String, Integer> sleepState();

    /***
     * 查询学霸数量(综合画像)
     * @param studentInfoREQ
     * @return
     */
    Integer excellentStudents(StudentInfoREQ studentInfoREQ);

    /***
     * 查询学习水平比率(综合画像)
     * @param studentInfoREQ
     * @return
     */
    Map<String, Object> levelForTeam(StudentInfoREQ studentInfoREQ);


    /***
     * 三餐规律度
     * @param studentInfoREQ
     * @return
     */
    Map<String, Object> dietRegularRate(StudentInfoREQ studentInfoREQ);





}
