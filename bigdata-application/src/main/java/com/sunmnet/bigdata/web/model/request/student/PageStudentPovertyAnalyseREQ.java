package com.sunmnet.bigdata.web.model.request.student;

import com.sunmnet.bigdata.commons.model.request.PageREQ;
import com.sunmnet.bigdata.web.model.entity.student.StudentSupportInfo;

/**
 * @author songlin_xie_n22@126.com
 * @version 1.0
 * @Title:
 * @Package
 * @Description:
 * @date 2018/3/1911:31
 */
public class PageStudentPovertyAnalyseREQ extends PageREQ {

    private StudentPovertyAnalyseREQ studentPovertyAnalyseREQ;
    private StudentSupportInfo studentSupportInfo;
    public StudentPovertyAnalyseREQ getStudentPovertyAnalyseREQ() {
        return studentPovertyAnalyseREQ;
    }

    public void setStudentPovertyAnalyseREQ(StudentPovertyAnalyseREQ studentPovertyAnalyseREQ) {
        this.studentPovertyAnalyseREQ = studentPovertyAnalyseREQ;
    }

    public StudentSupportInfo getStudentSupportInfo() {
        return studentSupportInfo;
    }

    public void setStudentSupportInfo(StudentSupportInfo studentSupportInfo) {
        this.studentSupportInfo = studentSupportInfo;
    }
}
