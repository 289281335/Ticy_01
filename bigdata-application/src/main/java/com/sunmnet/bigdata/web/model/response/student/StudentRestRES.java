package com.sunmnet.bigdata.web.model.response.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentInfo;

public class StudentRestRES extends StudentInfo {
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
