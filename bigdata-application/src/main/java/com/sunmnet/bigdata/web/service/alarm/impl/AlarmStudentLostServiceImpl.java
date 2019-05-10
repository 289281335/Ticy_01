/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:57
 */
package com.sunmnet.bigdata.web.service.alarm.impl;

import com.sunmnet.bigdata.web.dao.alarm.IAlarmStudentLostDAO;
import com.sunmnet.bigdata.web.service.alarm.IAlarmStudentLostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wdong
 * @version 1.0
 * @ClassName AlarmStudentLostServiceImpl
 * @Description
 * @date 2018-01-30 09:48:57
 */
@Transactional
@Service("AlarmStudentLostServiceImpl")
public class AlarmStudentLostServiceImpl implements IAlarmStudentLostService{
    @Autowired
    private IAlarmStudentLostDAO alarmStudentLostDAO;


}
