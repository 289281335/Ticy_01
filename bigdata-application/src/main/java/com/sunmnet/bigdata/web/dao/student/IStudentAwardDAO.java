/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentAward;
import com.sunmnet.bigdata.web.model.response.student.StudentAwardRES;

import java.util.List;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentAwardDAO
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IStudentAwardDAO {

    /**
     * 根据学号查询学生获奖情况
     * @param studentNo
     * @return
     */
    List<StudentAward> listAwardByStudentNo(String  studentNo);

    /**
     * 根据学号查询学生获奖分类数量
     * @param studentNo
     * @return
     */
    List<StudentAwardRES>  listAwardByStudentNoAndCategory(String  studentNo);

}
