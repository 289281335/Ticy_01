/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:57
 */

package com.sunmnet.bigdata.web.service.alarm;

import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.model.request.alarm.PageAlarmLateBackAndLostREQ;
import com.sunmnet.bigdata.web.model.request.student.PageStudentInfoREQ;
import com.sunmnet.bigdata.web.model.response.alarm.PageAlarmLateBackAndLostRES;
import com.sunmnet.bigdata.web.model.response.student.StudentInfoRES;
import com.sunmnet.bigdata.web.util.DateUtils;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IAlarmLateBackService
 * @Description
 * @date 2018-01-30 09:48:57
 */
public interface IAlarmLateBackService {

    /**
     * 学生迟归失联行为预警数量
     */
    List listWarningStudent() ;

    /**
     * listLateBackAndLostWarning
     * 学生晚归失联预警列表
     */
    PageRES<PageAlarmLateBackAndLostRES> listLateBackAndLostWarning(PageAlarmLateBackAndLostREQ pageAlarmLateBackAndLostREQ);

    /**
     * 查询行为预警每月数量
     * @return
     */
    List listWarningMonthCount();

    /**
     * 查询行为预警信息概要
     * @return
     */
    Map<String,Object> queryWarningGeneralInfo();

    /**
     * 处理预警信息
     * @param studentNo
     * @param warningType
     * @param warningDate
     * @param reason
     * @param remark
     */
    void dealWarningInfo(String studentNo, String warningType, String warningDate, String reason, String remark);

    /**
     * 学生紧急预警数量
     * @return
     */
    List countEmerWarningStudent();

    /**
     * 查询每日紧急预警前15的数量
     * @return
     */
    List countEmerWarningDay();

    /**
     * 查询紧急预警概要信息
     * @return
     */
    Map<String,Object> queryEmerWarningGeneralInfo();

    /**
     * @param pageStudentInfoREQ
     * @return
     */
    PageRES<StudentInfoRES> pageEmerWarning(PageStudentInfoREQ pageStudentInfoREQ);
}
