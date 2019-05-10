/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */

package com.sunmnet.bigdata.web.service.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentExtracurrCredits;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentExtracurrCreditsService
 * @Description
 * @date 2018-01-30 09:48:59
 */
public interface IStudentExtracurrCreditsService {


    /***
     * 根据学号查询学生课外八学分情况
     * @param studentNO
     * @return
     */
    List<StudentExtracurrCredits> class8creditsByStudentNo(String studentNO);

    /**
     * 根据学号查询参加活动数及竞赛数
     * @param studentNo
     * @return
     */
    Map<String,Long> countByStudentNo(String studentNo);

}
