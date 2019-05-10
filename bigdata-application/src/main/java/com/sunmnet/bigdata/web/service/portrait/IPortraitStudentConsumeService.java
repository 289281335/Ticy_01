/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */

package com.sunmnet.bigdata.web.service.portrait;

import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.model.entity.student.StudentPovertyAnalyse;
import com.sunmnet.bigdata.web.model.request.student.PageStudentPovertyAnalyseREQ;
import com.sunmnet.bigdata.web.model.request.student.PageStudentPovertySupportREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentPovertyAnalyseREQ;
import com.sunmnet.bigdata.web.model.response.student.StudentInfoRES;
import com.sunmnet.bigdata.web.model.response.student.StudentPovertyAnalyseRES;
import com.sunmnet.bigdata.web.model.response.student.StudentPovertySupportRES;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IPortraitStudentConsumeService
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IPortraitStudentConsumeService {
    /**
　　* @Description: ${查询贫困生总人数}
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author songlin_xie_n22@126.com
　　* @date 2018/3/19 10:04
　　*/
    Integer povertyStudent();
    /**
　　* @Description: ${查询虚假贫困生总人数}
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author songlin_xie_n22@126.com
　　* @date 2018/3/19 10:04
　　*/
    Integer unPovertyStudent();
    /**
　　* @Description: ${查询建议关爱总人数}
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author songlin_xie_n22@126.com
　　* @date 2018/3/19 10:04
　　*/
    Integer supportPovertyStudent();
    /**
　　* @Description: ${查询异常贫困学生列表}
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author songlin_xie_n22@126.com
　　* @date 2018/3/19 11:46
　　*/
    public PageRES<StudentPovertyAnalyseRES> pageUnusualPovertyStudent(PageStudentPovertyAnalyseREQ pageStudentPovertyAnalyseREQ);
    /**
    * @Description: ${更改贫困学生关注状态}
    * @param ${studentPovertyAnalyseREQ}
    * @return ${Integer}
    * @throws
    * @author songlin_xie_n22@126.com
    * @date 2018/3/19 13:14
    */
    Integer updatePovertyStudentFocusStatus(StudentPovertyAnalyseREQ studentPovertyAnalyseREQ);
    /**
    * @Description: ${查询关爱学生列表}
    * @param ${tags} 
    * @return ${return_type} 
    * @throws
    * @author songlin_xie_n22@126.com
    * @date 2018/3/19 14:26
    */
    public PageRES<StudentPovertySupportRES>  pageStudentPovertySupport(PageStudentPovertySupportREQ pageStudentPovertySupportREQ);

}
