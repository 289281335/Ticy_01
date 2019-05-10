package com.sunmnet.bigdata.web.model.response.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentInfo;

public class StudentInfoRES extends StudentInfo {
    private String label ;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
