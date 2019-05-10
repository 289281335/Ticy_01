/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-19 09:55:56
 */
package com.sunmnet.bigdata.web.service.alarm.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.dao.alarm.IAlarmStudentDAO;
import com.sunmnet.bigdata.web.model.request.alarm.AlarmStudentREQ;
import com.sunmnet.bigdata.web.model.request.alarm.PageAlarmStudentREQ;
import com.sunmnet.bigdata.web.model.response.alarm.AlarmStudentRES;
import com.sunmnet.bigdata.web.service.alarm.IAlarmStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName AlarmStudentServiceImpl
 * @Description
 * @date 2018-01-19 09:55:56
 */
@Transactional
@Service("AlarmStudentServiceImpl")
public class AlarmStudentServiceImpl implements IAlarmStudentService {
    @Autowired
    private IAlarmStudentDAO alarmStudentDAO;


    @Override
    public Long countAlarmStudent(AlarmStudentREQ alarmStudentREQ) {
        return alarmStudentDAO.countAlarmStudent(alarmStudentREQ);
    }

    @Override
    public AlarmStudentRES getAlarmStudent(AlarmStudentREQ alarmStudentREQ) {
        return alarmStudentDAO.getAlarmStudent(alarmStudentREQ);
    }

    @Override
    public List<AlarmStudentRES> listAlarmStudent(AlarmStudentREQ alarmStudentREQ) {
        return this.listAlarmStudent(alarmStudentREQ,null);
    }

    @Override
    public List<AlarmStudentRES> listAlarmStudent(AlarmStudentREQ alarmStudentREQ, Sort sort) {
        return alarmStudentDAO.listAlarmStudent(alarmStudentREQ,sort);
    }


    @Override
    public PageRES<AlarmStudentRES> pageAlarmStudent(PageAlarmStudentREQ pageAlarmStudentREQ) {
        Pageable pageable = pageAlarmStudentREQ.getPageable();
        AlarmStudentREQ alarmStudentREQ = pageAlarmStudentREQ.getAlarmStudentREQ();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());

        List<AlarmStudentRES> list = alarmStudentDAO.pageAlarmStudent(alarmStudentREQ, pageable.getSort());
        Page<AlarmStudentRES> count = (Page<AlarmStudentRES>)list;

        return new PageRES(list,pageable, count.getTotal());
    }
    //综合画像 待处理预警统计
    @Override
    public Map countUndisposedAlarm() {
        return alarmStudentDAO.countUndisposedAlarm();
    }
}
