package com.sunmnet.bigdata.web.model.entity.student;

public class NearlyMonthNetStatis {
    private Integer id;

    //学号
    private String studentNo;

    //姓名
    private String studentName;

    //性别
    private String gender;

    //民族
    private String nation;

    //学院名称
    private String collegeName;

    //学院代码
    private String collegeCode;

    //专业
    private String majorName;

    //专业代码
    private String majorCode;

    //班级
    private String className;

    //书院
    private String academyName;

    //年级
    private String grade;

    //生源地
    private String place;

    //月平均上网时长
    private Integer avgSurfNetTime;

    //上网时间段
    private Integer periodOfMonthNet;

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
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeCode() {
        return collegeCode;
    }

    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getAvgSurfNetTime() {
        return avgSurfNetTime;
    }

    public void setAvgSurfNetTime(Integer avgSurfNetTime) {
        this.avgSurfNetTime = avgSurfNetTime;
    }

    public Integer getPeriodOfMonthNet() {
        return periodOfMonthNet;
    }

    public void setPeriodOfMonthNet(Integer periodOfMonthNet) {
        this.periodOfMonthNet = periodOfMonthNet;
    }
}