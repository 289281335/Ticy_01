/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentConsumptionIndex;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentConsumptionIndexDAO
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IStudentConsumptionIndexDAO {

    /***
     * 餐饮指标
     * @return
     */
    List<Map<String ,Object>> eatIndex();

    /***
     * 社交指标
     * @return
     */
    List<Map<String ,Object>> socialIndex();

    /***
     * 学习指标
     * @return
     */
    List<Map<String ,Object>> studyIndex();


    /***
     * 男女贫困指标
     * @return
     */
    List<Map<String ,Object>> poorIndex();

    /***
     * 查询外出指数
     * @return
     */
    String weekOutIndex(String studentNo);


    /***
     * 查询学生的学习水平
     * @param studentNo
     * @return
     */
    BigDecimal levelByStudentNo(String studentNo);

    /***
     * 统计总条数
     * @return
     */
    Integer countLevel();

    /***
     * 查询指定的行号学生的学习水平
     * @param index
     * @return
     */
    StudentConsumptionIndex levelByIndex(int index);

    /***
     * 条件查询统计
     * @param studentInfoREQ
     * @return
     */
    Integer countLevelByCondition(StudentInfoREQ studentInfoREQ);

    /***
     * 查询三餐规律度总条数
     * @return
     */
    Integer countDietRegular();


    /***
     * 查询学生的学习水平
     * @param index
     * @return
     */
    StudentConsumptionIndex dietRegularByIndex(int index);

    /***
     * 根据条件查询三餐规律度人数
     * @param studentInfoREQ
     * @return
     */
    Integer countDietRegularByCondition(StudentInfoREQ studentInfoREQ);

    /**
     * studentConsumptionIndexDAO
     * @param majorCode
     * @return
     */
    Integer selectStudentCountByMajorCode(String majorCode);

    Integer selectStabilityRankingByStudentNumberAndMajorCode(String studentNo, String majorCode);
}
