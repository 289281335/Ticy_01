package com.sunmnet.bigdata.web.model.response.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentAward;

public class StudentAwardRES extends StudentAward {
    private int awardCount;

    public int getAwardCount() {
        return awardCount;
    }

    public void setAwardCount(int awardCount) {
        this.awardCount = awardCount;
    }
}
