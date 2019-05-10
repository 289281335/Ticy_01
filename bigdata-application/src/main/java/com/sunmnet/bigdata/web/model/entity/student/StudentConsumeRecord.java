package com.sunmnet.bigdata.web.model.entity.student;

public class StudentConsumeRecord {

    private String studentNo;

    private String studentName;

    private String consumeDate;

    private Integer breakfastTimes;

    private Integer lunchTimes;

    private Integer dinnerTimes;

    private Integer supperTimes;

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

    public String getConsumeDate() {
        return consumeDate;
    }

    public void setConsumeDate(String consumeDate) {
        this.consumeDate = consumeDate;
    }

    public Integer getBreakfastTimes() {
        return breakfastTimes;
    }

    public void setBreakfastTimes(Integer breakfastTimes) {
        this.breakfastTimes = breakfastTimes;
    }

    public Integer getLunchTimes() {
        return lunchTimes;
    }

    public void setLunchTimes(Integer lunchTimes) {
        this.lunchTimes = lunchTimes;
    }

    public Integer getDinnerTimes() {
        return dinnerTimes;
    }

    public void setDinnerTimes(Integer dinnerTimes) {
        this.dinnerTimes = dinnerTimes;
    }

    public Integer getSupperTimes() {
        return supperTimes;
    }

    public void setSupperTimes(Integer supperTimes) {
        this.supperTimes = supperTimes;
    }
}