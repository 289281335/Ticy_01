/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */
package com.sunmnet.bigdata.web.service.student.impl;

import com.sunmnet.bigdata.web.dao.student.IStudentDormitoryDAO;
import com.sunmnet.bigdata.web.service.student.IStudentDormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentDormitoryServiceImpl
 * @Description
 * @date 2018-01-30 09:48:59
 */
@Transactional
@Service("StudentDormitoryServiceImpl")
public class StudentDormitoryServiceImpl  implements IStudentDormitoryService {
    @Autowired
    private IStudentDormitoryDAO studentDormitoryDAO;


}
