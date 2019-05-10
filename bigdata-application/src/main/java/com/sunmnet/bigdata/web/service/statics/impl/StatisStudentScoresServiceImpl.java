/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.statics.impl;

import com.sunmnet.bigdata.web.dao.statics.IStatisStudentScoresDAO;
import com.sunmnet.bigdata.web.service.statics.IStatisStudentScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StatisStudentScoresServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("StatisStudentScoresServiceImpl")
public class StatisStudentScoresServiceImpl implements IStatisStudentScoresService{
    @Autowired
    private IStatisStudentScoresDAO statisStudentScoresDAO;


}
