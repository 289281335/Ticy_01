package com.sunmnet.bigdata.web.model.entity.student;

import java.util.List;
import java.util.Map;

public class StudentNetTimeInfo {

    //学号
    private String studentNo;

    //上网时间点
    private String time;

    //状态
    private String status;
    
    private List<Map<String,Object>> timeSlot;

    public List<Map<String, Object>> getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(List<Map<String, Object>> timeSlot) {
		this.timeSlot = timeSlot;
	}

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}