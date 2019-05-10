/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-02-07 09:39:11
 */

package com.sunmnet.bigdata.web.service.statics;

import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStatisStudentScoresRecordService
 * @Description
 * @date 2018-02-07 09:39:11
 */
public interface IStatisStudentScoresRecordService {

    Integer countFailSubject(StudentInfoREQ studentInfoREQ);

}
