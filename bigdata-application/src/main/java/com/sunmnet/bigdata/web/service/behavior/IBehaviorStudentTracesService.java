/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */

package com.sunmnet.bigdata.web.service.behavior;

import com.sunmnet.bigdata.commons.model.JsonResult;
import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.model.entity.behavior.BehaviorGroupLabel;
import com.sunmnet.bigdata.web.model.entity.behavior.BehaviorTrackPosition;
import com.sunmnet.bigdata.web.model.entity.student.StudentInfo;
import com.sunmnet.bigdata.web.model.request.behavior.BehaviorStudentLabelREQ;
import com.sunmnet.bigdata.web.model.request.behavior.PageBehaviorStudentLabelREQ;
import com.sunmnet.bigdata.web.model.request.behavior.PageStudentTracesREQ;
import com.sunmnet.bigdata.web.model.response.behavior.StudentTracesRES;
import com.sunmnet.bigdata.web.model.response.student.StudentInfoRES;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IBehaviorStudentTracesService
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IBehaviorStudentTracesService {

    /***
     * 查询学生打卡详情
     * @param pageStudentTracesREQ
     * @return
     */
    PageRES<StudentTracesRES> pageTracesDetail(PageStudentTracesREQ pageStudentTracesREQ);

    /***
     * 人群行为轨迹查询
     */
    List<BehaviorTrackPosition> listBehaviorTrack(BehaviorStudentLabelREQ behaviorStudentLabelREQ);

    /***
     * 重点人群管理--根据条件查询学生信息列表
     */
    PageRES<StudentInfoRES> pageStudentInfoByCondition(PageBehaviorStudentLabelREQ pageBehaviorStudentLabelREQ);

    /***
     * 重点人群管理--查询群体标签列表
     */
    List<String> listGroupLabel();

    /***
     * 重点人群管理--根据标签查询学生列表
     */
    public PageRES<StudentInfoRES> pageStudentInfoByLabel(PageBehaviorStudentLabelREQ pageBehaviorStudentLabelREQ);

    /***
     * 重点人群管理--根据标签查询标签信息
     */
    Map<String,String> getLabelInfoByLabel(String labelName);

    /***
     * 重点人群管理--创建新群体标签并添加学生
     */
    void saveGroupLabelAndStudent(BehaviorGroupLabel behaviorGroupLabel,List<String> list);

    /***
     * 重点人群管理--修改群体标签和学生
     */
    void updateGroupLabelAndStudent(BehaviorGroupLabel behaviorGroupLabel,List<String> list);

    /***
     * 重点人群管理--删除标签
     */
    void deleteGroupLabel(BehaviorStudentLabelREQ behaviorStudentLabelREQ);
}
