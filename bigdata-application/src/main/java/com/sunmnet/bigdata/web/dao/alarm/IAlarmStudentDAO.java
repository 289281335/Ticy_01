/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-19 09:55:56
 */
package com.sunmnet.bigdata.web.dao.alarm;

import com.sunmnet.bigdata.web.model.request.alarm.AlarmStudentREQ;
import com.sunmnet.bigdata.web.model.response.alarm.AlarmStudentRES;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IAlarmStudentDAO
 * @Description
 * @date 2018-01-19 09:55:56
 */
public interface IAlarmStudentDAO {

    Long countAlarmStudent(AlarmStudentREQ alarmStudentREQ);

    AlarmStudentRES getAlarmStudent(AlarmStudentREQ alarmStudentREQ );

    List<AlarmStudentRES> listAlarmStudent(@Param(value="alarmStudentREQ")AlarmStudentREQ alarmStudentREQ, @Param(value="sort")Sort sort);

    List<AlarmStudentRES> pageAlarmStudent(@Param(value="alarmStudentREQ")AlarmStudentREQ alarmStudentREQ, @Param(value="sort")Sort sort);
    //综合画像 待处理预警统计
    Map countUndisposedAlarm();
}
