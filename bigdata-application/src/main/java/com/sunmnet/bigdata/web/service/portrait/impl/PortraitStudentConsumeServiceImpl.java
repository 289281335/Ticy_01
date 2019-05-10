/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.portrait.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.dao.portrait.IPortraitStudentConsumeDAO;
import com.sunmnet.bigdata.web.model.request.student.PageStudentPovertyAnalyseREQ;
import com.sunmnet.bigdata.web.model.request.student.PageStudentPovertySupportREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentPovertyAnalyseREQ;
import com.sunmnet.bigdata.web.model.response.student.StudentPovertyAnalyseRES;
import com.sunmnet.bigdata.web.model.response.student.StudentPovertySupportRES;
import com.sunmnet.bigdata.web.service.portrait.IPortraitStudentConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wdong
 * @version 1.0
 * @ClassName PortraitStudentConsumeServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("PortraitStudentConsumeServiceImpl")
public class PortraitStudentConsumeServiceImpl implements IPortraitStudentConsumeService{
    @Autowired
    private IPortraitStudentConsumeDAO portraitStudentConsumeDAO;


    /**
     * 　　* @Description: ${查询贫困生总人数}
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author songlin_xie_n22@126.com
     * 　　* @date 2018/3/19 10:04
     *
     */
    @Override
    public Integer povertyStudent() {
        return portraitStudentConsumeDAO.povertyStudent();
    }

    /**
     * 　　* @Description: ${查询虚假贫困生总人数}
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author songlin_xie_n22@126.com
     * 　　* @date 2018/3/19 10:04
     *
     */
    @Override
    public Integer unPovertyStudent() {
        return portraitStudentConsumeDAO.unPovertyStudent();
    }


    /**
     * 　　* @Description: ${查询建议关爱总人数}
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author songlin_xie_n22@126.com
     * 　　* @date 2018/3/19 10:04
     *
     */
    @Override
    public Integer supportPovertyStudent() {
        return portraitStudentConsumeDAO.supportPovertyStudent();
    }


    /**
    * @Description: ${查询异常贫困学生列表}
    * @return ${return_type}
    * @throws
    * @author songlin_xie_n22@126.com
    * @date 2018/3/19 13:14
    */
    @Override
    public PageRES<StudentPovertyAnalyseRES> pageUnusualPovertyStudent(PageStudentPovertyAnalyseREQ pageStudentPovertyAnalyseREQ) {
        Pageable pageable = pageStudentPovertyAnalyseREQ.getPageable();
        List list=portraitStudentConsumeDAO.pageUnusualPovertyStudent(pageStudentPovertyAnalyseREQ);
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        Page count=(Page)list;
        return new PageRES(list,pageable,count.getTotal());
    }

    /**
    * @Description: ${更改贫困学生关注状态}
    * @return ${return_type}
    * @throws
    * @author songlin_xie_n22@126.com
    * @date 2018/3/19 13:17
    */
    @Override
    public Integer updatePovertyStudentFocusStatus(StudentPovertyAnalyseREQ studentPovertyAnalyseREQ) {
        return portraitStudentConsumeDAO.updatePovertyStudentFocusStatus(studentPovertyAnalyseREQ);
    }

    /**
     * @param pageStudentPovertySupportREQ
     * @return ${return_type}
     * @throws
     * @Description: ${查询关爱学生列表}
     * @author songlin_xie_n22@126.com
     * @date 2018/3/19 14:26
     */
    @Override
    public PageRES<StudentPovertySupportRES> pageStudentPovertySupport(PageStudentPovertySupportREQ pageStudentPovertySupportREQ) {
        Pageable pageable = pageStudentPovertySupportREQ.getPageable();
        List list=portraitStudentConsumeDAO.pageStudentPovertySupport(pageStudentPovertySupportREQ);
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        Page count=(Page)list;
        return new PageRES(list,pageable,count.getTotal());
    }


}
