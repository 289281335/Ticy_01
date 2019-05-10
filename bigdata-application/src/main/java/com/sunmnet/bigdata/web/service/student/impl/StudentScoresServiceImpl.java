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
import com.sunmnet.bigdata.web.Constants;
import com.sunmnet.bigdata.web.dao.statics.IStatisStudentScoresDAO;
import com.sunmnet.bigdata.web.dao.statics.IStatisStudentScoresRecordDAO;
import com.sunmnet.bigdata.web.dao.student.IStudentInfoDAO;
import com.sunmnet.bigdata.web.dao.student.IStudentScoresDAO;
import com.sunmnet.bigdata.web.model.entity.student.StudentScores;
import com.sunmnet.bigdata.web.model.request.student.PageStudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.response.student.StudentInfoRES;
import com.sunmnet.bigdata.web.model.response.student.StudentScoresRES;
import com.sunmnet.bigdata.web.service.student.IStudentScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentScoresServiceImpl
 * @Description
 * @date 2018-01-30 09:48:59
 */
@Transactional
@Service("StudentScoresServiceImpl")
public class StudentScoresServiceImpl implements IStudentScoresService {
    @Autowired
    private IStudentInfoDAO studentInfoDAO;
    @Autowired
    private IStudentScoresDAO studentScoresDAO;

    @Autowired
    private IStatisStudentScoresRecordDAO statisStudentScoresRecordDAO;

    @Autowired
    private IStatisStudentScoresDAO statisStudentScoresDAO;

    @Override
    public List<StudentScoresRES> listScoresByStudentNo(String studentNo) {
        return studentScoresDAO.listScoresByStudentNo(studentNo);
    }


    @Override
    public PageRES<StudentScoresRES> pageStudentScores(PageStudentInfoREQ pageStudentInfoREQ) {
        Pageable pageable = pageStudentInfoREQ.getPageable();
        StudentInfoREQ studentInfoREQ = pageStudentInfoREQ.getStudentInfoREQ();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());

        List<StudentScoresRES> list = studentScoresDAO.listScoresByStudentNo(studentInfoREQ.getStudentNo());
        Page<StudentScoresRES> count = (Page<StudentScoresRES>)list;
        return new PageRES(list,pageable, count.getTotal());
    }

    /**
     * 查询学生历史成绩信息
     * @param studentNo
     * @return
     */
    @Override
    public Map<String, Object> queryHistoryScore(String studentNo) {
        Map<String, Object> map = new HashMap<String, Object>();
        //查询学生信息
        StudentInfoRES info = studentInfoDAO.getStudentByNo(studentNo);
        //查学生历史平均成绩
        List<Map<String, Object>> personList = statisStudentScoresRecordDAO.selectSemesterAverageScoreByStudentNo(studentNo);
        //查学期专业平均成绩
        List<Map<String, Object>> majorList = statisStudentScoresRecordDAO.selectSemesterAverageScoreByMajorCode(info.getMajorCode());
        map.put("personList", personList);
        map.put("majorList", dealMajorList(majorList, personList));//处理专业成绩列表
        return map;
    }


    /**
     * 处理专业成绩列表
     * @param majorList
     * @param personList
     */
    private List<Map<String, Object>> dealMajorList(List<Map<String, Object>> majorList, List<Map<String, Object>> personList) {
        List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
        for(Map<String, Object> personMap : personList) {
            for(Map<String, Object> majorMap : majorList) {
                if(majorMap.get(Constants.SEMESTER) != null && ((String)majorMap.get(Constants.SEMESTER)).equals((String)personMap.get(Constants.SEMESTER))) {//semester 学期
                    retList.add(majorMap);
                }
            }
        }
        return retList;
    }



    /**
     * 学生成绩分布
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> countStudentScore() {
        return studentScoresDAO.countStudentScore();
    }
}
