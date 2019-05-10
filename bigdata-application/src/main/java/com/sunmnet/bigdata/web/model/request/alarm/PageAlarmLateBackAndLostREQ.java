package com.sunmnet.bigdata.web.model.request.alarm;

import com.sunmnet.bigdata.commons.model.request.PageREQ;
import com.sunmnet.bigdata.web.model.entity.alarm.AlarmLateBack;
import com.sunmnet.bigdata.web.model.entity.alarm.AlarmStudentLost;

public class PageAlarmLateBackAndLostREQ extends PageREQ {

    private AlarmLateBack alarmLateBack;
    private AlarmStudentLost alarmStudentLost;

    public AlarmLateBack getAlarmLateBack() {
        return alarmLateBack;
    }

    public void setAlarmLateBack(AlarmLateBack alarmLateBack) {
        this.alarmLateBack = alarmLateBack;
    }

    public AlarmStudentLost getAlarmStudentLost() {
        return alarmStudentLost;
    }

    public void setAlarmStudentLost(AlarmStudentLost alarmStudentLost) {
        this.alarmStudentLost = alarmStudentLost;
    }
}
