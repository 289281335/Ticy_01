/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-02-07 09:39:11
 */
package com.sunmnet.bigdata.web.dao.statics;

import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStatisStudentScoresRecordDAO
 * @Description
 * @date 2018-02-07 09:39:11
 */
public interface IStatisStudentScoresRecordDAO {

    Integer countFailSubject(StudentInfoREQ studentInfoREQ);

    /**
     * 查询学期的平均成绩
     * @param studentNo
     * @return
     */
    List<Map<String,Object>> selectSemesterAverageScoreByStudentNo(String studentNo);
    /**
     * 查询专业的平均成绩
     * @param majorCode
     * @return
     */
    List<Map<String,Object>> selectSemesterAverageScoreByMajorCode(String majorCode);
}
