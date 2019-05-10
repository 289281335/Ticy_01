package com.sunmnet.bigdata.web.model.entity.student;

public class StudentTruancyRecord {
    private Integer id;

    private String studentNo;

    private String courseName;

    private String courseStartDate;

    private String courseEndDate;

    private String truancyDate;

    private String truancyBehavior;

    private String truancyPlace;

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
        this.studentNo = studentNo == null ? null : studentNo.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseStartDate() {
        return courseStartDate;
    }

    public void setCourseStartDate(String courseStartDate) {
        this.courseStartDate = courseStartDate == null ? null : courseStartDate.trim();
    }

    public String getCourseEndDate() {
        return courseEndDate;
    }

    public void setCourseEndDate(String courseEndDate) {
        this.courseEndDate = courseEndDate == null ? null : courseEndDate.trim();
    }

    public String getTruancyDate() {
        return truancyDate;
    }

    public void setTruancyDate(String truancyDate) {
        this.truancyDate = truancyDate == null ? null : truancyDate.trim();
    }

    public String getTruancyBehavior() {
        return truancyBehavior;
    }

    public void setTruancyBehavior(String truancyBehavior) {
        this.truancyBehavior = truancyBehavior == null ? null : truancyBehavior.trim();
    }

    public String getTruancyPlace() {
        return truancyPlace;
    }

    public void setTruancyPlace(String truancyPlace) {
        this.truancyPlace = truancyPlace == null ? null : truancyPlace.trim();
    }
}