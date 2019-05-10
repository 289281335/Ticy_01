/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */

package com.sunmnet.bigdata.web.service.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentRest;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentRestREQ;
import com.sunmnet.bigdata.web.model.response.student.StudentSleepLableRES;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentRestService
 * @Description
 * @date 2018-01-30 09:48:59
 */
public interface IStudentRestService {

    List<StudentRest> last7DaysRest(String studentNo);

    /**
     * 查询睡眠时长
     */
    Map<String, Object> sleepTime(String studentNo);

    /***
     * 查询睡眠规律度指数
     * @param studentNo
     * @return
     */
    Map<String, Object> sleepRegularity(String studentNo);

    /***
     * 查询作息标签
     * @param studentNo
     * @return
     */
    StudentSleepLableRES sleepLable(String studentNo);

    /***
     * 查询睡眠时长(综合画像)
     * @param studentRestREQ
     * @return
     */
    Map<String, Object> sleepTimeOfTeam(StudentRestREQ studentRestREQ);

    /***
     * 查询睡觉时间点比率(群体画像)
     * @param studentRestREQ
     * @return
     */
    Map<String, Object> sleepRateOfTeam(StudentRestREQ studentRestREQ);


    /***
     * 查询起床时间点比率(综合画像)
     * @param studentRestREQ
     * @return
     */
    Map<String, Object> getUpRateOfTeam(StudentRestREQ studentRestREQ);

    /**
     * 根据条件查询平均睡眠时长(整体画像)
     */
    double avgSleeptimeByCondition(StudentInfoREQ studentInfoREQ);

}
