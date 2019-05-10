/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */

package com.sunmnet.bigdata.web.service.alarm;

import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.model.request.alarm.PageAlarmTruancySubjectsREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.response.alarm.AlarmStudentSubjectsLabelRES;
import com.sunmnet.bigdata.web.model.response.alarm.PageAlarmLateBackAndLostRES;

import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IAlarmStudentSubjectsService
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IAlarmStudentSubjectsService {

    /***
     * 统计学业预警数量
     * @return
     */
    AlarmStudentSubjectsLabelRES subjects();

    /***
     * 学业预警和行为预警总计
     * @param studentInfoREQ
     * @return
     */
    Integer countSubjectAndBehaviorWarning(StudentInfoREQ studentInfoREQ);

    /**
     * 挂科和逃课预警
     * @param pageAlarmTruancySubjectsREQ
     * @return
     */
    PageRES<PageAlarmTruancySubjectsREQ> pageTruancySubjectsWaring(PageAlarmTruancySubjectsREQ pageAlarmTruancySubjectsREQ);
}
