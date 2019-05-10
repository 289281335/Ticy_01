package com.sunmnet.bigdata.web.model.entity.student;

public class StudentConsumePlace {
    private Integer id;

    private String studentNo;

    private String studentName;

    private String consumeStartDate;

    private String consumeEndDate;

    private String consumePlace;

    private String consumeWindow;

    private String consumeType;

    private Integer consumeTimes;

    private Long consumeAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getConsumeStartDate() {
        return consumeStartDate;
    }

    public void setConsumeStartDate(String consumeStartDate) {
        this.consumeStartDate = consumeStartDate == null ? null : consumeStartDate.trim();
    }

    public String getConsumeEndDate() {
        return consumeEndDate;
    }

    public void setConsumeEndDate(String consumeEndDate) {
        this.consumeEndDate = consumeEndDate == null ? null : consumeEndDate.trim();
    }

    public String getConsumePlace() {
        return consumePlace;
    }

    public void setConsumePlace(String consumePlace) {
        this.consumePlace = consumePlace;
    }

    public String getConsumeWindow() {
        return consumeWindow;
    }

    public void setConsumeWindow(String consumeWindow) {
        this.consumeWindow = consumeWindow == null ? null : consumeWindow.trim();
    }

    public String getConsumeType() {
        return consumeType;
    }

    public void setConsumeType(String consumeType) {
        this.consumeType = consumeType == null ? null : consumeType.trim();
    }

    public Integer getConsumeTimes() {
        return consumeTimes;
    }

    public void setConsumeTimes(Integer consumeTimes) {
        this.consumeTimes = consumeTimes;
    }

    public Long getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(Long consumeAmount) {
        this.consumeAmount = consumeAmount;
    }
}