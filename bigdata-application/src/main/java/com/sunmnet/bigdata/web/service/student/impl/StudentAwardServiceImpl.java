/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.student.impl;

import com.sunmnet.bigdata.web.dao.student.IStudentAwardDAO;
import com.sunmnet.bigdata.web.model.entity.student.StudentAward;
import com.sunmnet.bigdata.web.model.response.student.StudentAwardRES;
import com.sunmnet.bigdata.web.service.student.IStudentAwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentAwardServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("StudentAwardServiceImpl")
public class StudentAwardServiceImpl implements IStudentAwardService {
    @Autowired
    private IStudentAwardDAO studentAwardDAO;


    @Override
    public List<StudentAward> listAwardByStudentNo(String studentNo) {
        return studentAwardDAO.listAwardByStudentNo(studentNo);
    }

    @Override
    public List<StudentAwardRES> listAwardByStudentNoAndCategory(String studentNo) {
        return studentAwardDAO.listAwardByStudentNoAndCategory(studentNo);
    }
}
