/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.predict.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.dao.predict.IPredictStudentSubjectsDAO;
import com.sunmnet.bigdata.web.model.request.predict.PagePredictFailSubjectREQ;
import com.sunmnet.bigdata.web.model.request.predict.PredictFailSubjectREQ;
import com.sunmnet.bigdata.web.model.response.predict.PredictFailSubjectRES;
import com.sunmnet.bigdata.web.service.predict.IPredictStudentSubjectsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName PredictStudentSubjectsServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("PredictStudentSubjectsServiceImpl")
public class PredictStudentSubjectsServiceImpl implements IPredictStudentSubjectsService{
    @Autowired
    private IPredictStudentSubjectsDAO predictStudentSubjectsDAO;


    @Override
    public Map<String, Object> scorePrediction(String studentNo) {
        List<Map<String,Object>>  list = predictStudentSubjectsDAO.scorePrediction(studentNo);
        Integer count = predictStudentSubjectsDAO.failCourseCount(studentNo);
        HashMap<String, Object> maps = new HashMap<>();
        maps.put("grade", list);
        maps.put("count",count);
        return maps;
    }

    //根据条件查询每个院的挂科人数
    @Override
    public Integer countGradeByFailSubject(PredictFailSubjectREQ predictFailSubjectREQ){
        Integer count = predictStudentSubjectsDAO.countGradeByFailSubject(predictFailSubjectREQ);
        return count;
    }

    //根据条件查询每个院的挂科人数的详细信息
    @Override
    public PageRES<PredictFailSubjectRES> pageGradeDetailByFailSubject(@Param("pagePredictFailSubjectREQ")PagePredictFailSubjectREQ pagePredictFailSubjectREQ){
        Pageable pageable =  pagePredictFailSubjectREQ.getPageable();
        PredictFailSubjectREQ predictFailSubjectREQ = pagePredictFailSubjectREQ.getPredictFailSubjectREQ();
        PageHelper.startPage(pageable.getPageNumber(),pageable.getPageSize());

        List<PredictFailSubjectRES> list = predictStudentSubjectsDAO.pageGradeDetailByFailSubject(pagePredictFailSubjectREQ);
        Page<PredictFailSubjectRES> count = (Page<PredictFailSubjectRES>)list;
        return new PageRES(list,pageable, count.getTotal());
    }
}
