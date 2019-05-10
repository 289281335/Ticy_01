/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.behavior.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunmnet.bigdata.commons.model.JsonResult;
import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.dao.behavior.IBehaviorStudentTracesDAO;
import com.sunmnet.bigdata.web.model.entity.behavior.BehaviorGroupLabel;
import com.sunmnet.bigdata.web.model.entity.behavior.BehaviorTrackPosition;
import com.sunmnet.bigdata.web.model.entity.student.StudentInfo;
import com.sunmnet.bigdata.web.model.request.behavior.*;
import com.sunmnet.bigdata.web.model.response.behavior.StudentTracesRES;
import com.sunmnet.bigdata.web.model.response.student.StudentInfoRES;
import com.sunmnet.bigdata.web.service.behavior.IBehaviorStudentTracesService;
import com.sunmnet.bigdata.web.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author wdong
 * @version 1.0
 * @ClassName BehaviorStudentTracesServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("BehaviorStudentTracesServiceImpl")
public class BehaviorStudentTracesServiceImpl implements IBehaviorStudentTracesService {
    @Autowired
    private IBehaviorStudentTracesDAO iBehaviorStudentTracesDAO;

    /***
     * 查询学生打卡详情
     * @param pageStudentTracesREQ
     * @return
     */
    @Override
    public PageRES<StudentTracesRES> pageTracesDetail(PageStudentTracesREQ pageStudentTracesREQ) {
        Pageable pageable = pageStudentTracesREQ.getPageable();
        StudentTracesREQ studentTracesREQ = pageStudentTracesREQ.getStudentTracesREQ();

        if(StringUtils.isEmpty(studentTracesREQ.getStartDate())) {
            studentTracesREQ.setStartDate(getFromDate());
        }
        if(StringUtils.isEmpty(studentTracesREQ.getEndDate())) {
            studentTracesREQ.setEndDate(DateUtils.dateToString(new Date(), DateUtils.PATTERN_DATE));
        }
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        Sort sort = pageable.getSort();
        if(pageable.getSort()==null){
            sort = new Sort(Sort.Direction.DESC, StudentTracesRES.ALIAS_CARD_DATE);
        }
        List<StudentTracesRES> list = iBehaviorStudentTracesDAO.listStudentTraces(studentTracesREQ, sort);
        Page<StudentTracesRES> count = (Page<StudentTracesRES>)list;
        return new PageRES(list,pageable, count.getTotal());
    }
    /**
     * 获取查询开始时间
     * @return
     */
    private String getFromDate() {
        String fromDate = null;
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int year =  Calendar.getInstance().get(Calendar.YEAR);
        if(month <= 2) {
            fromDate = (year - 1) + "-" + "09-01";
        }

        if(month > 2 && month < 9) {
            fromDate = year + "-02-01";
        }

        if(month >= 9) {
            fromDate = year + "-09-01";

        }
        return fromDate;
    }

    /***
     * 人群行为轨迹查询
     */
    public List<BehaviorTrackPosition> listBehaviorTrack(BehaviorStudentLabelREQ behaviorStudentLabelREQ){
        List<BehaviorTrackPosition> list = iBehaviorStudentTracesDAO.listBehaviorTrackByNet(behaviorStudentLabelREQ);
        return list;
    }

    /***
     * 重点人群管理--根据条件查询学生信息列表
     */
    public PageRES<StudentInfoRES> pageStudentInfoByCondition(PageBehaviorStudentLabelREQ pageBehaviorStudentLabelREQ){
          Pageable pageable = pageBehaviorStudentLabelREQ.getPageable();
          StudentInfo studentInfo = pageBehaviorStudentLabelREQ.getBehaviorStudentLabelREQ();
          PageHelper.startPage(pageable.getPageNumber(),pageable.getPageSize());

          List<StudentInfoRES> list = iBehaviorStudentTracesDAO.pageStudentInfoByCondition(pageBehaviorStudentLabelREQ);
          Page<StudentInfoRES> count = (Page<StudentInfoRES>)list;
          return new PageRES(list,pageable, count.getTotal());
    }

    /***
     * 重点人群管理--查询群体标签列表
     */
    public List<String> listGroupLabel(){
           List<String> list = iBehaviorStudentTracesDAO.listGroupLabel();
           return list;
    }

    /***
     * 重点人群管理--根据标签查询学生列表
     */
    public PageRES<StudentInfoRES> pageStudentInfoByLabel(PageBehaviorStudentLabelREQ pageBehaviorStudentLabelREQ){
            Pageable pageable = pageBehaviorStudentLabelREQ.getPageable();
            StudentInfo studentInfo = pageBehaviorStudentLabelREQ.getBehaviorStudentLabelREQ();
            PageHelper.startPage(pageable.getPageNumber(),pageable.getPageSize());

            List<StudentInfoRES> list = iBehaviorStudentTracesDAO.pageStudentInfoByLabel(pageBehaviorStudentLabelREQ.getBehaviorStudentLabelREQ().getLabelName());
            Page<StudentInfoRES> count = (Page<StudentInfoRES>)list;
            return new PageRES(list,pageable, count.getTotal());
    }

    /***
     * 重点人群管理--根据标签查询标签信息
     */
    public Map<String,String> getLabelInfoByLabel(String labelName){
           Map<String,String> map = new HashMap<>();
           map=iBehaviorStudentTracesDAO.getLabelInfoByLabel(labelName);
           return map;
    }

    /***
     * 重点人群管理--创建新群体标签并添加学生
     */
    public void saveGroupLabelAndStudent(BehaviorGroupLabel behaviorGroupLabel, List<String> list){
         //添加新标签信息
         iBehaviorStudentTracesDAO.saveGroupLabel(behaviorGroupLabel.getLabelName(),behaviorGroupLabel.getLabelDescribe());
         //添加新标签对应学生的学号
         iBehaviorStudentTracesDAO.saveStudent(behaviorGroupLabel.getLabelName(),list);
    }

    /***
     * 重点人群管理--修改群体标签和学生
     */
    public void updateGroupLabelAndStudent(BehaviorGroupLabel behaviorGroupLabel,List<String> list){
         //修改标签信息
         iBehaviorStudentTracesDAO.updateGroupLabel(behaviorGroupLabel.getLabelName(),behaviorGroupLabel.getLabelDescribe());
         //删除标签原来对应的学生学号
         iBehaviorStudentTracesDAO.deleteStudent(behaviorGroupLabel.getLabelName());
         //调用添加标签对应学生学号的方法 重新进行添加
         iBehaviorStudentTracesDAO.saveStudent(behaviorGroupLabel.getLabelName(),list);
    }

    /***
     * 重点人群管理--删除标签
     */
    public void deleteGroupLabel(BehaviorStudentLabelREQ behaviorStudentLabelREQ){
           iBehaviorStudentTracesDAO.deleteGroupLabel(behaviorStudentLabelREQ.getLabelName());

    }

}
