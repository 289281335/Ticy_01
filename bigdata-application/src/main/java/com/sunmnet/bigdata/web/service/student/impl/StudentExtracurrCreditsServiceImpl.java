/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */
package com.sunmnet.bigdata.web.service.student.impl;

import com.sunmnet.bigdata.web.dao.student.IStudentExtracurrCreditsDAO;
import com.sunmnet.bigdata.web.model.entity.student.StudentExtracurrCredits;
import com.sunmnet.bigdata.web.service.student.IStudentExtracurrCreditsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentExtracurrCreditsServiceImpl
 * @Description
 * @date 2018-01-30 09:48:59
 */
@Transactional
@Service("StudentExtracurrCreditsServiceImpl")
public class StudentExtracurrCreditsServiceImpl  implements IStudentExtracurrCreditsService {
    @Autowired
    private IStudentExtracurrCreditsDAO studentExtracurrCreditsDAO;


    @Override
    public List<StudentExtracurrCredits> class8creditsByStudentNo(String studentNO) {
        return studentExtracurrCreditsDAO.class8creditsByStudentNo(studentNO);
    }

    @Override
    public Map<String,Long> countByStudentNo(String studentNo){
        return studentExtracurrCreditsDAO.countByStudentNo(studentNo);
    }
}
