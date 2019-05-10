package com.sunmnet.bigdata.web.model.response.portrait;

public class StudentsLabelRES {

    //预警数量
    private Integer warnQuantity;
    //学霸数
    private Integer excellentStudents;
    //挂科数
    private Integer failSubjects;
    //日均上网时长
    private Double avgNetTime;
    //日均睡眠时长
    private Double avgSleepTime;
    //日均睡眠时长
    private Double avgConsum;


    private Integer loseWorkCount;

    public Integer getWarnQuantity() {
        return warnQuantity;
    }

    public void setWarnQuantity(Integer warnQuantity) {
        this.warnQuantity = warnQuantity;
    }

    public Integer getExcellentStudents() {
        return excellentStudents;
    }

    public void setExcellentStudents(Integer excellentStudents) {
        this.excellentStudents = excellentStudents;
    }

    public Integer getFailSubjects() {
        return failSubjects;
    }

    public void setFailSubjects(Integer failSubjects) {
        this.failSubjects = failSubjects;
    }

    public Double getAvgNetTime() {
        return avgNetTime;
    }

    public void setAvgNetTime(Double avgNetTime) {
        this.avgNetTime = avgNetTime;
    }

    public Double getAvgSleepTime() {
        return avgSleepTime;
    }

    public void setAvgSleepTime(Double avgSleepTime) {
        this.avgSleepTime = avgSleepTime;
    }

    public Double getAvgConsum() {
        return avgConsum;
    }

    public void setAvgConsum(Double avgConsum) {
        this.avgConsum = avgConsum;
    }

    public Integer getLoseWorkCount() {
        return loseWorkCount;
    }

    public void setLoseWorkCount(Integer loseWorkCount) {
        this.loseWorkCount = loseWorkCount;
    }
}
