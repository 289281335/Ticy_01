package com.sunmnet.bigdata.web.model.request.student;

import com.sunmnet.bigdata.commons.model.request.PageREQ;

public class PageStudentInfoREQ extends PageREQ {

    private StudentInfoREQ studentInfoREQ;

    public StudentInfoREQ getStudentInfoREQ() {
        return studentInfoREQ;
    }

    public void setStudentInfoREQ(StudentInfoREQ studentInfoREQ) {
        this.studentInfoREQ = studentInfoREQ;
    }
}
