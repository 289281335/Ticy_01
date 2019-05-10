/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */
package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.response.student.StudentScoresRES;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentScoresDAO
 * @Description
 * @date 2018-01-30 09:48:59
 */
public interface IStudentScoresDAO {

    List<StudentScoresRES> listScoresByStudentNo(String studentNo);
    /**
     * 学生成绩分布
     * @return
     */
    List<Map<String,Object>> countStudentScore();
}
