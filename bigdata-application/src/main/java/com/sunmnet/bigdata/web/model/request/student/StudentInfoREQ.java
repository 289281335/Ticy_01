package com.sunmnet.bigdata.web.model.request.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentInfo;

public class StudentInfoREQ extends StudentInfo {

    private Integer category;

    private String eatIndex;

    private String scoreIndex;

    private String startDate;

    private String endDate;


    public String getEatIndex() {
        return eatIndex;
    }

    public void setEatIndex(String eatIndex) {
        this.eatIndex = eatIndex;
    }

    public String getScoreIndex() {
        return scoreIndex;
    }

    public void setScoreIndex(String scoreIndex) {
        this.scoreIndex = scoreIndex;
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

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}
