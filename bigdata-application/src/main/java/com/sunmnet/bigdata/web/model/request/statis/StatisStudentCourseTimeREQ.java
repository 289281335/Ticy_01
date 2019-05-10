package com.sunmnet.bigdata.web.model.request.statis;

public class StatisStudentCourseTimeREQ {

    //学生学号
    private String studentNo;
    //查询开始时间
    private String startDate;
    //查询结束时间
    private String endDate;

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
