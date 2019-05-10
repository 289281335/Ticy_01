/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */

package com.sunmnet.bigdata.web.service.student;

import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.model.request.student.PageStudentInfoREQ;
import com.sunmnet.bigdata.web.model.response.student.StudentScoresRES;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentScoresService
 * @Description
 * @date 2018-01-30 09:48:59
 */
public interface IStudentScoresService {

    /***
     *
     * 个人画像--成绩图
     *
     * 查询所有学生的成绩，查询参数：学号
     *
     * @param studentNo
     * @return
     */
    List<StudentScoresRES> listScoresByStudentNo(String studentNo);

    /***
     *
     * 个人画像--成绩图
     *
     * 分页查询学生的成绩，查询参数：学号
     *
     * @param pageStudentInfoREQ
     * @return
     */
    PageRES<StudentScoresRES> pageStudentScores(PageStudentInfoREQ pageStudentInfoREQ);

    /**
     * 查询学生历史成绩信息
     * @param studentNo
     * @return
     */
    Map<String,Object> queryHistoryScore(String studentNo);


    /**
     * 学生成绩分布
     * @return
     */
    List<Map<String,Object>> countStudentScore();

}
