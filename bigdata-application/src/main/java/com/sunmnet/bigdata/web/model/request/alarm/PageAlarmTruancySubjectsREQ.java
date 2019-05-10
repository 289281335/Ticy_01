package com.sunmnet.bigdata.web.model.request.alarm;

import com.sunmnet.bigdata.commons.model.request.PageREQ;


public class PageAlarmTruancySubjectsREQ extends PageREQ {

    AlarmStudentREQ alarmStudentREQ;
    AlarmStudentTruancyREQ alarmStudentTruancyREQ;

    public AlarmStudentREQ getAlarmStudentREQ() {
        return alarmStudentREQ;
    }

    public void setAlarmStudentREQ(AlarmStudentREQ alarmStudentREQ) {
        this.alarmStudentREQ = alarmStudentREQ;
    }

    public AlarmStudentTruancyREQ getAlarmStudentTruancyREQ() {
        return alarmStudentTruancyREQ;
    }

    public void setAlarmStudentTruancyREQ(AlarmStudentTruancyREQ alarmStudentTruancyREQ) {
        this.alarmStudentTruancyREQ = alarmStudentTruancyREQ;
    }
}
