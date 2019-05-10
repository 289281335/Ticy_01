/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */
package com.sunmnet.bigdata.web.service.student.impl;

import com.sunmnet.bigdata.web.dao.student.IStudentPositionDAO;
import com.sunmnet.bigdata.web.model.entity.student.StudentPosition;
import com.sunmnet.bigdata.web.service.student.IStudentPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentPositionServiceImpl
 * @Description
 * @date 2018-01-30 09:48:59
 */
@Transactional
@Service("StudentPositionServiceImpl")
public class StudentPositionServiceImpl implements IStudentPositionService {
    @Autowired
    private IStudentPositionDAO studentPositionDAO;


    @Override
    public List<StudentPosition> listPosition(String studentNo) {
        return studentPositionDAO.listPosition(studentNo);
    }
}
