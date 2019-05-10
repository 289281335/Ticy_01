/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */
package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.WholePortraitREQ;
import com.sunmnet.bigdata.web.model.response.student.StudentInfoRES;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentInfoDAO
 * @Description
 * @date 2018-01-30 09:48:59
 */
public interface IStudentInfoDAO {

    /***
     * 根据学号查询学生信息
     * @param studentNo
     * @return
     */
    StudentInfoRES getStudentByNo(String studentNo);

    /***
     * 根据条件分页查询学生信息
     * @param studentInfoREQ
     * @return
     */
    List<StudentInfoRES> listStudentInfo(@Param(value="studentInfoREQ")StudentInfoREQ studentInfoREQ, @Param(value="sort")Sort sort);

    /***
     * 分性别统计人数
     * @param studentInfoREQ
     * @return
     */
    List<Map<String,Object>> countCategoryByGender(StudentInfoREQ studentInfoREQ);

    /***
     * 根据条件查询学生数
     * @param studentInfoREQ
     * @return
     */
    Integer countStudentInfo(StudentInfoREQ studentInfoREQ);

    /***
     * 根据条件查询学生数  --
     * @param wholePortraitREQ
     * @return
     */
    Integer countStudentInfoByCondition(WholePortraitREQ wholePortraitREQ);

    /**
     * 根据性别和学位统计学生结构
     * @param studentInfoREQ
     * @return
     */
    List<Map<String,Object>> countStructureByDegreeAndGender(StudentInfoREQ studentInfoREQ);    /**

     /* 根据学位和生源地统计学生分布
     * @param studentInfoREQ
     * @return
     */
    List<Map<String,Object>> countStructureByDegreeAndNativePlace(StudentInfoREQ studentInfoREQ);


}
