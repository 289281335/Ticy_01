/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.dao.portrait;

import com.sunmnet.bigdata.web.model.request.student.PageStudentPovertyAnalyseREQ;
import com.sunmnet.bigdata.web.model.request.student.PageStudentPovertySupportREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentPovertyAnalyseREQ;

import java.util.List;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IPortraitStudentConsumeDAO
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IPortraitStudentConsumeDAO {
    //平困生总人数
    Integer povertyStudent();
    //查询虚假贫困生总人数
    Integer unPovertyStudent();
    //查询建议关爱总人数
    Integer supportPovertyStudent();
    //查询异常贫困学生列表
    List pageUnusualPovertyStudent(PageStudentPovertyAnalyseREQ pageStudentPovertyAnalyseREQ);
    //更改贫困学生关注状态
    Integer updatePovertyStudentFocusStatus(StudentPovertyAnalyseREQ studentPovertyAnalyseREQ);
    //查询关爱、扶贫学生列表
    List pageStudentPovertySupport(PageStudentPovertySupportREQ pageStudentPovertySupportREQ);

}
