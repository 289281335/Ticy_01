/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-19 09:55:56
 */

package com.sunmnet.bigdata.web.service.alarm;

import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.model.request.alarm.AlarmStudentREQ;
import com.sunmnet.bigdata.web.model.request.alarm.PageAlarmStudentREQ;
import com.sunmnet.bigdata.web.model.response.alarm.AlarmStudentRES;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IAlarmStudentService
 * @Description
 * @date 2018-01-19 09:55:56
 */
public interface IAlarmStudentService {

    Long countAlarmStudent(AlarmStudentREQ alarmStudentREQ);

    AlarmStudentRES getAlarmStudent(AlarmStudentREQ alarmStudentREQ );

    List<AlarmStudentRES> listAlarmStudent(AlarmStudentREQ alarmStudentREQ);

    List<AlarmStudentRES> listAlarmStudent(AlarmStudentREQ alarmStudentREQ, Sort sort);

    PageRES<AlarmStudentRES> pageAlarmStudent(PageAlarmStudentREQ pageAlarmStudentREQ) ;
    //综合画像 待处理预警统计
    Map countUndisposedAlarm();
}
