/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-02-07 09:39:11
 */
package com.sunmnet.bigdata.web.service.statics.impl;

import com.sunmnet.bigdata.web.dao.statics.IStatisStudentScoresRecordDAO;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.service.statics.IStatisStudentScoresRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StatisStudentScoresRecordServiceImpl
 * @Description
 * @date 2018-02-07 09:39:11
 */
@Transactional
@Service("StatisStudentScoresRecordServiceImpl")
public class StatisStudentScoresRecordServiceImpl implements IStatisStudentScoresRecordService {
    @Autowired
    private IStatisStudentScoresRecordDAO statisStudentScoresRecordDAO;

    @Override
    public Integer countFailSubject(StudentInfoREQ studentInfoREQ) {
        return null;
    }
}
