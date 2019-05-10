package com.sunmnet.bigdata.web.model.request.behavior;

import com.sunmnet.bigdata.commons.model.request.PageREQ;

public class PageStudentTracesREQ  extends PageREQ {

    private StudentTracesREQ studentTracesREQ;

    public StudentTracesREQ getStudentTracesREQ() {
        return studentTracesREQ;
    }

    public void setStudentTracesREQ(StudentTracesREQ studentTracesREQ) {
        this.studentTracesREQ = studentTracesREQ;
    }

}
