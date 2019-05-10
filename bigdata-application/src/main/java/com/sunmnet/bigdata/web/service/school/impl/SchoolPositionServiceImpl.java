/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.school.impl;

import com.sunmnet.bigdata.web.dao.school.ISchoolPositionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wdong
 * @version 1.0
 * @ClassName SchoolPositionServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("SchoolPositionServiceImpl")
public class SchoolPositionServiceImpl {
    @Autowired
    private ISchoolPositionDAO schoolPositionDAO;


}
