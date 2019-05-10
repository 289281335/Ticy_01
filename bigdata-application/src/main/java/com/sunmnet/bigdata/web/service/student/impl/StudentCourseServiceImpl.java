/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */
package com.sunmnet.bigdata.web.service.student.impl;

import com.sunmnet.bigdata.web.dao.student.IStudentCourseDAO;
import com.sunmnet.bigdata.web.dao.student.IStudentCourseRecordDAO;
import com.sunmnet.bigdata.web.service.student.IStudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentCourseServiceImpl
 * @Description
 * @date 2018-01-30 09:48:59
 */
@Transactional
@Service("StudentCourseServiceImpl")
public class StudentCourseServiceImpl  implements IStudentCourseService {

    @Autowired
    private IStudentCourseDAO studentCourseDAO;
    @Autowired
    private IStudentCourseRecordDAO studentCourseRecordDAO;

    /**
     *疑似逃课
     * @param studentNo
     * @return
     */
    @Override
    public List<Map<String, Object>> querySuspectedTruancyInfo(String studentNo) {
       return studentCourseRecordDAO.selectTruancyRecordByStudentNo(studentNo);
    }
}
