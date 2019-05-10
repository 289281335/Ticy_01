/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */
package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentSupportInfo;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.response.student.StudentInfoRES;

import java.util.List;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentSupportInfoDAO
 * @Description
 * @date 2018-01-30 09:48:59
 */
public interface IStudentSupportInfoDAO {

    /***
     * 根据条件查询贫困学生数
     * @param studentInfoREQ
     * @return
     */
    Integer countPoorStudent(StudentInfoREQ studentInfoREQ);

    /***
     * 根据条件查询学生的异常贫困生总人数
     * @param studentInfoREQ
     * @return
     */
    Integer countAbnormalPoorStudent(StudentInfoREQ studentInfoREQ);


    /***
     * 根据条件分页查询贫困生包括非贫困生
     * @param studentInfoREQ
     * @return
     */
    List<StudentInfoRES> listPoorStudent(StudentInfoREQ studentInfoREQ);


    /***
     * 根据条件分页查询贫困生
     * @param supportInfo
     * @return
     */
    List<StudentSupportInfo> listSupportStudent(StudentSupportInfo supportInfo);

    /***
     * 修改贫困生关注和原因
     * @param studentSupportInfo
     * @return
     */
    void updateStudentSupportFocus(StudentSupportInfo studentSupportInfo);

    /***
     * 根据学号查询贫困生资助信息
     */
    StudentSupportInfo getStudentSupportInfoByStudentNo(String studentNo);
}
