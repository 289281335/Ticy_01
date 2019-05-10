/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */

package com.sunmnet.bigdata.web.service.predict;

import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.model.request.predict.PagePredictFailSubjectREQ;
import com.sunmnet.bigdata.web.model.request.predict.PredictFailSubjectREQ;
import com.sunmnet.bigdata.web.model.response.predict.PredictFailSubjectRES;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IPredictStudentSubjectsService
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IPredictStudentSubjectsService {

    /***
     * 获取过往的成绩预测挂科的科目
     * @param studentNo
     * @return
     */
    Map<String,Object> scorePrediction(@Param("studentNo") String studentNo);

    //根据条件查询每个院的挂科人数
    Integer countGradeByFailSubject(PredictFailSubjectREQ predictFailSubjectREQ);

    //根据条件查询每个院的挂科人数的详细信息
    PageRES<PredictFailSubjectRES> pageGradeDetailByFailSubject(@Param("pagePredictFailSubjectREQ")PagePredictFailSubjectREQ pagePredictFailSubjectREQ);
}
