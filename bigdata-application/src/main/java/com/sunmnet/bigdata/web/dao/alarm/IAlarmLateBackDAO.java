/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:57
 */
package com.sunmnet.bigdata.web.dao.alarm;

import com.sunmnet.bigdata.web.model.entity.alarm.AlarmLateBack;
import com.sunmnet.bigdata.web.model.request.alarm.AlarmStudentREQ;
import com.sunmnet.bigdata.web.model.request.alarm.PageAlarmLateBackAndLostREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.response.student.StudentInfoRES;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IAlarmLateBackDAO
 * @Description
 * @date 2018-01-30 09:48:57
 */
public interface IAlarmLateBackDAO {
    Integer countDealWarning(StudentInfoREQ studentInfoREQ);

    /**
     * 学生迟归失联行为预警数量
     */
    List listWarningStudent(@Param("fromDate")String fromDate, @Param("toDate")String toDate) ;

    /**
     * 学生迟归失联行为预警列表
     */
    List<Map> listLateBackAndLostWarning(@Param(value="pageAlarmLateBackAndLostREQ")PageAlarmLateBackAndLostREQ pageAlarmLateBackAndLostREQ);

    /**
     * 学生行为预警月数量
     * @return
     */
    List listWarningMonthCount();

    /**
     * 晚归预警处理
     * @param studentNo
     * @param warningDate
     * @param reason
     * @param remark
     */
    void updateLateBackWarning(String studentNo, String warningDate, String reason, String remark);

    /**
     * 学生紧急预警数量Top5
     * @param fromDate
     * @param toDate
     * @return
     */
    List countEmerWarningStudent(@Param("fromDate")String fromDate, @Param("toDate")String toDate);
    /**
     * 查询每日紧急预警前15的数量
     * @return
     */
    List countEmerWarningDay();

    /**
     * 查询紧急待处理预警
     * @param studentInfoREQ
     * @return
     */
    Integer countDealEmerWarning(StudentInfoREQ studentInfoREQ);

    /**
     * 紧急预警分页列表
     * @param studentInfoREQ
     * @param sort
     * @return
     */
    List<StudentInfoRES> pageEmerWarning(StudentInfoREQ studentInfoREQ, Sort sort);


}
