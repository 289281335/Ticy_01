package com.sunmnet.bigdata.web.model.entity.student;

public class StudentClassRecord {
    private Integer id;

    private String studentNumber;

    private String courseDate;

    private String schoolTerm;

    private Integer truancyTimes;

    private Integer normalTimes;

    private Integer lateTimes;

    private Integer leftTimes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber == null ? null : studentNumber.trim();
    }

    public String getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(String courseDate) {
        this.courseDate = courseDate == null ? null : courseDate.trim();
    }

    public String getSchoolTerm() {
        return schoolTerm;
    }

    public void setSchoolTerm(String schoolTerm) {
        this.schoolTerm = schoolTerm == null ? null : schoolTerm.trim();
    }

    public Integer getTruancyTimes() {
        return truancyTimes;
    }

    public void setTruancyTimes(Integer truancyTimes) {
        this.truancyTimes = truancyTimes;
    }

    public Integer getNormalTimes() {
        return normalTimes;
    }

    public void setNormalTimes(Integer normalTimes) {
        this.normalTimes = normalTimes;
    }

    public Integer getLateTimes() {
        return lateTimes;
    }

    public void setLateTimes(Integer lateTimes) {
        this.lateTimes = lateTimes;
    }

    public Integer getLeftTimes() {
        return leftTimes;
    }

    public void setLeftTimes(Integer leftTimes) {
        this.leftTimes = leftTimes;
    }
}