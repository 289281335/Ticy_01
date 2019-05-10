/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */
package com.sunmnet.bigdata.web.service.student.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.dao.student.IStudentInfoDAO;
import com.sunmnet.bigdata.web.dao.student.IStudentSupportInfoDAO;
import com.sunmnet.bigdata.web.model.entity.student.StudentSupportInfo;
import com.sunmnet.bigdata.web.model.request.student.PageStudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.PageStudentSupportREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.response.student.StudentInfoRES;
import com.sunmnet.bigdata.web.service.student.IStudentSupportInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentSupportInfoServiceImpl
 * @Description
 * @date 2018-01-30 09:48:59
 */
@Transactional
@Service("StudentSupportInfoServiceImpl")
public class StudentSupportInfoServiceImpl implements IStudentSupportInfoService {
    @Autowired
    private IStudentSupportInfoDAO studentSupportInfoDAO;

    @Autowired
    private IStudentInfoDAO studentInfoDAO;


    /***
     * 群体画像(贫困生情况分析)
     * @param studentInfoREQ
     * @return
     */
    @Override
    public Map<String, Object> poorStudentsInfo(StudentInfoREQ studentInfoREQ) {
        int totalNum = studentInfoDAO.countStudentInfo(studentInfoREQ);
        int poorStudent = studentSupportInfoDAO.countPoorStudent(studentInfoREQ);
        int unpoorStudent = totalNum - poorStudent;
        studentInfoREQ.setCategory(2);
        int abnormalStudent = studentSupportInfoDAO.countAbnormalPoorStudent(studentInfoREQ);
        studentInfoREQ.setCategory(1);
        int suspectedStudent = studentSupportInfoDAO.countAbnormalPoorStudent(studentInfoREQ);
        HashMap<String, Object> maps = new HashMap<>();
        maps.put("poorStudent", poorStudent);
        maps.put("unpoorStudent", unpoorStudent);
        maps.put("abnormalStudent", abnormalStudent);
        maps.put("suspectedStudent", suspectedStudent);
        return maps;
    }


    /***
     * 根据条件查询分页贫困生
     * @param pageStudentInfoREQ
     * @return
     */
    @Override
    public PageRES<StudentInfoRES> pageListPoorStudent(PageStudentInfoREQ pageStudentInfoREQ) {
        Pageable pageable = pageStudentInfoREQ.getPageable();
        StudentInfoREQ studentInfoREQ = pageStudentInfoREQ.getStudentInfoREQ();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());

        List<StudentInfoRES> list = studentSupportInfoDAO.listPoorStudent(studentInfoREQ);
        Page<StudentInfoRES> count = (Page<StudentInfoRES>)list;
        return new PageRES(list,pageable, count.getTotal());
    }

    /***
     * 根据条件查询分页贫困生
     * @param pageStudentSupportREQ
     * @return
     */
    @Override
    public PageRES<StudentSupportInfo> pageListSupportStudent(PageStudentSupportREQ pageStudentSupportREQ) {
        Pageable pageable = pageStudentSupportREQ.getPageable();
        StudentSupportInfo studentSupportInfo = pageStudentSupportREQ.getStudentSupportInfo();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());

        List<StudentSupportInfo> list = studentSupportInfoDAO.listSupportStudent(studentSupportInfo);
        Page<StudentSupportInfo> count = (Page<StudentSupportInfo>)list;
        return new PageRES(list,pageable, count.getTotal());
    }

    @Override
    public void updateStudentSupportFocus(StudentSupportInfo studentSupportInfo) {
        studentSupportInfoDAO.updateStudentSupportFocus(studentSupportInfo);
    }


}
