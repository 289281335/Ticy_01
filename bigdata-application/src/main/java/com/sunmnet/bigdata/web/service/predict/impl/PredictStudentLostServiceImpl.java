/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.predict.impl;

import com.sunmnet.bigdata.web.dao.predict.IPredictStudentLostDAO;
import com.sunmnet.bigdata.web.service.predict.IPredictStudentLostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wdong
 * @version 1.0
 * @ClassName PredictStudentLostServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("PredictStudentLostServiceImpl")
public class PredictStudentLostServiceImpl implements IPredictStudentLostService{
    @Autowired
    private IPredictStudentLostDAO predictStudentLostDAO;


}
