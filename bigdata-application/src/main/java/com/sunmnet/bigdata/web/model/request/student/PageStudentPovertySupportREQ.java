package com.sunmnet.bigdata.web.model.request.student;

import com.sunmnet.bigdata.commons.model.request.PageREQ;
import com.sunmnet.bigdata.web.model.entity.student.StudentInfo;
import com.sunmnet.bigdata.web.model.entity.student.StudentPovertyAnalyse;
import com.sunmnet.bigdata.web.model.entity.student.StudentPovertySupport;
import com.sunmnet.bigdata.web.model.entity.student.StudentSupportInfo;

/**
 * @author songlin_xie_n22@126.com
 * @version 1.0
 * @Title:
 * @Package
 * @Description:
 * @date 2018/3/19 14:27
 */
public class PageStudentPovertySupportREQ extends PageREQ {
    private StudentPovertyAnalyse studentPovertyAnalyse;
    private StudentInfo studentInfo;
    private StudentPovertySupport studentPovertySupport;

    public StudentPovertyAnalyse getStudentPovertyAnalyse() {
        return studentPovertyAnalyse;
    }

    public void setStudentPovertyAnalyse(StudentPovertyAnalyse studentPovertyAnalyse) {
        this.studentPovertyAnalyse = studentPovertyAnalyse;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public StudentPovertySupport getStudentPovertySupport() {
        return studentPovertySupport;
    }

    public void setStudentPovertySupport(StudentPovertySupport studentPovertySupport) {
        this.studentPovertySupport = studentPovertySupport;
    }
}
