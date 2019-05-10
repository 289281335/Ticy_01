/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.dao.alarm;

import com.sunmnet.bigdata.web.model.request.alarm.PageAlarmTruancySubjectsREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;

import java.util.List;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IAlarmStudentSubjectsDAO
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IAlarmStudentSubjectsDAO {

    /***
     * 查询旷课预警近一个月的总数量
     * @return
     */
    Integer recentlyTruancy();


    /***
     * 查询挂科预警近一个月的总数量
     * @return
     */
    Integer recentlyEarlyFailWarning();

    /**
     * 查询本月预警数量
     * @return String
     * */
    String failWarningOfMonth();

    /**
     * 查询上月预警数量
     * @return String
     * */
    String failWarningOfLastMonth();
    /**
     * 学业预警一年平均数
     * @return String
     * */
    String failWarningOfYear();
    /**
     * 学业预警最高
     * @return String
     * */
    String maxFailWarning();

    /***
     * 学业预警数量
     * @param studentInfoREQ
     * @return
     */
    Integer countSubjectWarning(StudentInfoREQ studentInfoREQ);

    /**
     * 挂科和逃课预警
     * @param pageAlarmTruancySubjectsREQ
     * @return
     */
    List pageTruancySubjectsWaring(PageAlarmTruancySubjectsREQ pageAlarmTruancySubjectsREQ);
    /**
     * 挂科预警处理
     * @param studentNo
     * @param warningDate
     * @param reason
     * @param remark
     */
    void updateSubjectsWarning(String studentNo, String warningDate, String reason, String remark);
}
