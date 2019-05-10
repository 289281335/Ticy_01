/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.school.impl;

import com.sunmnet.bigdata.web.dao.school.ISchoolBuildingPositionDAO;
import com.sunmnet.bigdata.web.service.school.ISchoolBuildingPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wdong
 * @version 1.0
 * @ClassName SchoolBuildingPositionServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("SchoolBuildingPositionServiceImpl")
public class SchoolBuildingPositionServiceImpl implements ISchoolBuildingPositionService{
    @Autowired
    private ISchoolBuildingPositionDAO schoolBuildingPositionDAO;


}
