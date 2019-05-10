/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.basedata.impl;

import com.sunmnet.bigdata.web.dao.basedata.IDictCourseDAO;
import com.sunmnet.bigdata.web.model.entity.basedata.DictCourse;
import com.sunmnet.bigdata.web.service.basedata.IDictCourseService;


import com.sunmnet.bigdata.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @author wdong
 * @version 1.0
 * @ClassName DictCourseServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("DictCourseServiceImpl")
public class DictCourseServiceImpl  implements IDictCourseService{
    @Autowired
    private IDictCourseDAO dictCourseDAO;


}
