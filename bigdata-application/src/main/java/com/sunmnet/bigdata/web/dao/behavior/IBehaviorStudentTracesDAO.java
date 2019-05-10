/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.dao.behavior;

import com.sunmnet.bigdata.web.model.entity.behavior.BehaviorTrackPosition;
import com.sunmnet.bigdata.web.model.request.behavior.BehaviorStudentLabelREQ;
import com.sunmnet.bigdata.web.model.request.behavior.PageBehaviorStudentLabelREQ;
import com.sunmnet.bigdata.web.model.request.behavior.StudentTracesREQ;
import com.sunmnet.bigdata.web.model.response.behavior.StudentTracesRES;
import com.sunmnet.bigdata.web.model.response.student.StudentInfoRES;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IBehaviorStudentTracesDAO
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IBehaviorStudentTracesDAO {

    /***
     * 根据条件分页查询学生一卡通信息
     * @param studentTracesREQ
     * @return
     */
    List<StudentTracesRES> listStudentTraces(@Param(value="studentTracesREQ")StudentTracesREQ studentTracesREQ, @Param(value="sort")Sort sort);

    /***
     * 人群行为轨迹查询-刷卡
     * 暂未启用
     */
    List<BehaviorTrackPosition> listBehaviorTrackByCard(BehaviorStudentLabelREQ behaviorStudentLabelREQ);

    /***
     * 人群行为轨迹查询-上网
     */
    List<BehaviorTrackPosition> listBehaviorTrackByNet(BehaviorStudentLabelREQ behaviorStudentLabelREQ);


    /***
     * 重点人群管理--根据条件查询学生信息列表
     */
    List<StudentInfoRES> pageStudentInfoByCondition(PageBehaviorStudentLabelREQ pageBehaviorStudentLabelREQ);

    /***
     * 重点人群管理--查询群体标签列表
     */
    List<String> listGroupLabel();

    /***
     * 重点人群管理--根据标签查询学生列表
     */
    List<StudentInfoRES> pageStudentInfoByLabel(String labelName);

    /***
     * 重点人群管理--根据标签查询标签信息
     */
    Map<String,String> getLabelInfoByLabel(String labelName);

    /***
     * 重点人群管理--创建新群体标签并添加学生--添加标签信息
     */
    void saveGroupLabel(@Param("labelName") String labelName,@Param("labelDescribe") String labelDescribe);

    /***
     * 重点人群管理--创建新群体标签并添加学生--添加标签对应学号
     */
    void saveStudent(@Param("labelName") String labelName ,@Param("list") List<String> list);

    /***
     * 重点人群管理--修改群体标签和学生--修改标签信息
     */
    void updateGroupLabel(@Param("labelName") String labelName,@Param("labelDescribe") String labelDescribe);

    /***
     * 重点人群管理--修改群体标签和学生--删除标签对应学号
     */
    void deleteStudent(String labelName);

    /***
     * 重点人群管理--删除标签
     */
    void deleteGroupLabel(String labelName);

}
