/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */

package com.sunmnet.bigdata.web.service.student;

import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.model.entity.student.StudentInfo;
import com.sunmnet.bigdata.web.model.request.student.PageStudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.WholePortraitREQ;
import com.sunmnet.bigdata.web.model.response.portrait.StudentsLabelRES;
import com.sunmnet.bigdata.web.model.response.student.StudentInfoRES;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentInfoService
 * @Description
 * @date 2018-01-30 09:48:59
 */
public interface IStudentInfoService {

    /***
     * 根据学号查询学生信息
     * @param studentNo
     * @return
     */
    public StudentInfo getStudentByNo(String studentNo);

    /***
     * 根据条件分页查询学生信息
     * @param pageStudentInfoREQ
     * @return
     */
    public PageRES<StudentInfoRES> pageStudentInfo(PageStudentInfoREQ pageStudentInfoREQ);


    /***
     * 学生群体的画像
     * @param studentInfoREQ
     * @return
     */
    StudentsLabelRES studentsInfo(StudentInfoREQ studentInfoREQ);


    /***
     * 统计各个维度的学生人数
     * @param studentInfoREQ
     * @return
     */
    List<Map<String, Object>> countStudentByCategory(StudentInfoREQ studentInfoREQ);

    /**
     * 根据性别和学位统计学生结构
     * @param studentInfoREQ
     * @return
     */
    List<Map<String,Object>> countStructureByDegreeAndGender(StudentInfoREQ studentInfoREQ);

    /**
     * 根据学位和生源地统计学生分布
     * @param studentInfoREQ
     * @return
     */
    List<Map<String,Object>>  countStructureByDegreeAndNativePlace(StudentInfoREQ studentInfoREQ);


}
