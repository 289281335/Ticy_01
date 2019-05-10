/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */

package com.sunmnet.bigdata.web.service.student;

import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.model.entity.student.StudentSupportInfo;
import com.sunmnet.bigdata.web.model.request.student.PageStudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.PageStudentSupportREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.response.student.StudentInfoRES;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentSupportInfoService
 * @Description
 * @date 2018-01-30 09:48:59
 */
public interface IStudentSupportInfoService {

    /***
     * 群体画像(贫困生情况分析)
     * @param studentInfoREQ
     * @return
     */
    Map<String, Object> poorStudentsInfo(StudentInfoREQ studentInfoREQ) ;

    /***
     * 根据条件查询分页贫困生
     * @param pageStudentInfoREQ
     * @return
     */
    PageRES<StudentInfoRES> pageListPoorStudent(PageStudentInfoREQ pageStudentInfoREQ);

    PageRES<StudentSupportInfo> pageListSupportStudent(PageStudentSupportREQ pageStudentSupportREQ);




    /***
     * 修改贫困生关注和原因
     * @param studentSupportInfo
     * @return
     */
    void updateStudentSupportFocus(StudentSupportInfo studentSupportInfo);

}
