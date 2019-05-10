package com.sunmnet.bigdata.web.model.response.alarm;

import java.text.DecimalFormat;
import java.util.HashMap;

/***
 * 学业预警标签
 *
 */
public class AlarmStudentSubjectsLabelRES {
    /**
     * 总的逃课
     */
    private int totalSubjects;
    /**
     * 当月逃课
     */
    private String  monthSubjects;
    /**
     * 月环比逃课
     */
    private String  roseSubjects;
    /**
     * 当年逃课
     */
    private String  yearSubjects;
    /**
     * 最多逃课
     */
    private String  maxSubjects;

    public int getTotalSubjects() {
        return totalSubjects;
    }

    public void setTotalSubjects(int totalSubjects) {
        this.totalSubjects = totalSubjects;
    }

    public String getMonthSubjects() {
        return monthSubjects;
    }

    public void setMonthSubjects(String monthSubjects) {
        this.monthSubjects = monthSubjects;
    }

    public String getRoseSubjects() {
        return roseSubjects;
    }

    public void setRoseSubjects(String roseSubjects) {
        this.roseSubjects = roseSubjects;
    }

    public String getYearSubjects() {
        return yearSubjects;
    }

    public void setYearSubjects(String yearSubjects) {
        this.yearSubjects = yearSubjects;
    }

    public String getMaxSubjects() {
        return maxSubjects;
    }

    public void setMaxSubjects(String maxSubjects) {
        this.maxSubjects = maxSubjects;
    }
}
