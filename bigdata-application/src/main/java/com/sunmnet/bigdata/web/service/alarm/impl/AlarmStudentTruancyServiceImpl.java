/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.alarm.impl;

import com.sunmnet.bigdata.web.dao.alarm.IAlarmStudentTruancyDAO;
import com.sunmnet.bigdata.web.service.alarm.IAlarmStudentTruancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName AlarmStudentTruancyServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("AlarmStudentTruancyServiceImpl")
public class AlarmStudentTruancyServiceImpl implements IAlarmStudentTruancyService{
    @Autowired
    private IAlarmStudentTruancyDAO alarmStudentTruancyDAO;


    @Override
    public List<Map<String, Object>> historyTruancy() {




        return alarmStudentTruancyDAO.historyTruancy();
    }
}
