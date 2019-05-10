/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.student.impl;

import com.sunmnet.bigdata.web.dao.student.IStudentConsumeStabilityDAO;
import com.sunmnet.bigdata.web.service.student.IStudentConsumeStabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentConsumeStabilityServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("StudentConsumeStabilityServiceImpl")
public class StudentConsumeStabilityServiceImpl implements IStudentConsumeStabilityService {
    @Autowired
    private IStudentConsumeStabilityDAO studentConsumeStabilityDAO;


}
