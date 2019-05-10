package com.sunmnet.bigdata.web.model.response.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentScores;

public class StudentScoresRES extends StudentScores {

    /** 学期 **/
    private String schoolTerm;
    /** 平均成绩  **/
    private String averageScore;

    public String getSchoolTerm() {
        return schoolTerm;
    }

    public void setSchoolTerm(String schoolTerm) {
        this.schoolTerm = schoolTerm;
    }

    public String getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(String averageScore) {
        this.averageScore = averageScore;
    }
}
