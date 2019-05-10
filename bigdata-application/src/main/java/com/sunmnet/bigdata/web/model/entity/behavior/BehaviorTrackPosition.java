package com.sunmnet.bigdata.web.model.entity.behavior;


import com.sunmnet.bigdata.web.model.entity.school.SchoolPosition;

public class BehaviorTrackPosition extends SchoolPosition{
    private String studentNo;  //学号


    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }


}
