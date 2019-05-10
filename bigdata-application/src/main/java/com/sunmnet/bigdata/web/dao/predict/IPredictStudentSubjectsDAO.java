/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.dao.predict;

import com.sunmnet.bigdata.web.model.request.predict.PagePredictFailSubjectREQ;
import com.sunmnet.bigdata.web.model.request.predict.PredictFailSubjectREQ;
import com.sunmnet.bigdata.web.model.response.predict.PredictFailSubjectRES;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IPredictStudentSubjectsDAO
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IPredictStudentSubjectsDAO {

    /***
     * 根据学号查出该生某学年的每科成绩
     * @param studentNo
     * @return
     */
    List<Map<String,Object>> scorePrediction(String studentNo);

    /***
     * 根据学号查询挂科的门数
     * @param studentNo
     * @return
     */
    Integer failCourseCount(String studentNo);


    //根据条件查询每个院的挂科人数
    Integer countGradeByFailSubject(PredictFailSubjectREQ predictFailSubjectREQ);

    //根据条件查询每个院的挂科人数的详细信息
    List<PredictFailSubjectRES> pageGradeDetailByFailSubject(@Param("predictFailSubjectREQ")PagePredictFailSubjectREQ pagePredictFailSubjectREQ);
}
