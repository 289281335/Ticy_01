package com.sunmnet.bigdata.web.model.request.student;

import com.sunmnet.bigdata.commons.model.request.PageREQ;
import com.sunmnet.bigdata.web.model.entity.student.StudentSupportInfo;

public class PageStudentSupportREQ extends PageREQ {

    private StudentSupportInfo studentSupportInfo;

    public StudentSupportInfo getStudentSupportInfo() {
        return studentSupportInfo;
    }

    public void setStudentSupportInfo(StudentSupportInfo studentSupportInfo) {
        this.studentSupportInfo = studentSupportInfo;
    }
}
