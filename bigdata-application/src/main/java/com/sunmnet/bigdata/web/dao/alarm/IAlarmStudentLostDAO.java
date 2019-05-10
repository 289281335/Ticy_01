/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:57
 */
package com.sunmnet.bigdata.web.dao.alarm;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IAlarmStudentLostDAO
 * @Description
 * @date 2018-01-30 09:48:57
 */
public interface IAlarmStudentLostDAO {
    /**
     * 失联预警处理
     * @param studentNo
     * @param warningDate
     * @param reason
     * @param remark
     */
    void updateLostWarning(String studentNo, String warningDate, String reason, String remark);
}
