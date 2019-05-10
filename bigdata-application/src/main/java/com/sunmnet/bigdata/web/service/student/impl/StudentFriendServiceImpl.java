/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-02-01 11:22:40
 */
package com.sunmnet.bigdata.web.service.student.impl;

import com.sunmnet.bigdata.web.dao.student.IStudentFriendDAO;
import com.sunmnet.bigdata.web.service.student.IStudentFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentFriendServiceImpl
 * @Description
 * @date 2018-02-01 11:22:40
 */
@Transactional
@Service("StudentFriendServiceImpl")
public class StudentFriendServiceImpl implements IStudentFriendService {

    @Autowired
    private IStudentFriendDAO studentFriendDAO;


}
