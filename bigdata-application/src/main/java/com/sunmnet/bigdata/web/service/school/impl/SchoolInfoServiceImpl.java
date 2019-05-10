/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.school.impl;

import com.sunmnet.bigdata.web.dao.school.ISchoolInfoDAO;
import com.sunmnet.bigdata.web.model.entity.school.SchoolInfo;
import com.sunmnet.bigdata.web.service.school.ISchoolInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wdong
 * @version 1.0
 * @ClassName SchoolInfoServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("SchoolInfoServiceImpl")

public class SchoolInfoServiceImpl implements ISchoolInfoService{

    @Autowired
    private ISchoolInfoDAO schoolInfoDAO;

    @Override
    public List<SchoolInfo> listAllCollege() {
        return schoolInfoDAO.listAllCollege();
    }

    @Override
    public List<SchoolInfo> listMajorByCollege(String collegeCode) {
        return schoolInfoDAO.listMajorByCollege(collegeCode);
    }

    @Override
    public List<SchoolInfo> listClassByMajor(String majorCode) {
        return schoolInfoDAO.listClassByMajor(majorCode);
    }

    @Override
    public List<SchoolInfo> listAllMajor() {
        return schoolInfoDAO.listAllMajor();
    }
}
