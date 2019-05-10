/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-19 09:55:56
 */
package com.sunmnet.bigdata.web.model.request.alarm;

import com.sunmnet.bigdata.commons.model.request.PageREQ;
import org.springframework.data.domain.Pageable;

/**
 * @author wdong
 * @version 1.0
 * @ClassName AlarmStudent
 * @Description
 * @date 2018-01-19 09:55:56
 */
public class PageAlarmStudentREQ extends PageREQ {

    private Pageable pageable;
    private AlarmStudentREQ alarmStudentREQ ;

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public AlarmStudentREQ getAlarmStudentREQ() {
        return alarmStudentREQ;
    }

    public void setAlarmStudentREQ(AlarmStudentREQ alarmStudentREQ) {
        this.alarmStudentREQ = alarmStudentREQ;
    }
}

