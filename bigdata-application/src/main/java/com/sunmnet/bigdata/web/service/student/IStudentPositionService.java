/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */

package com.sunmnet.bigdata.web.service.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentPosition;

import java.util.List;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentPositionService
 * @Description
 * @date 2018-01-30 09:48:59
 */
public interface IStudentPositionService {

    /**
     * 根据学号查询学生任职情况
     * @param studentNo
     * @return
     */
    List<StudentPosition> listPosition(String studentNo);

}
