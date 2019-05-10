/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.student.impl;

import com.sunmnet.bigdata.web.dao.student.IStudentConsumeDetailDAO;
import com.sunmnet.bigdata.web.service.student.IStudentConsumeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentConsumeDetailServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("StudentConsumeDetailServiceImpl")
public class StudentConsumeDetailServiceImpl implements IStudentConsumeDetailService {
    @Autowired
    private IStudentConsumeDetailDAO studentConsumeDetailDAO;

    /**
     * 综合画像 一卡通消费趋势分析
     *
     * @param gender
     * @param consumeTime
     * @return
     */
    @Override
    public Map<String, Object> countConsumeTrend(String gender, String consumeTime) {
        Map map=new HashMap();
        //男女各自平均消费
        List<Map<String, Object>> countConsumeTrendByGender= studentConsumeDetailDAO.countConsumeTrendByGender(gender,consumeTime);
        //校总体品均消费
        List<Map<String, Object>> countConsumeTrendAll= studentConsumeDetailDAO.countConsumeTrendAll(consumeTime);
        map.put("countConsumeTrendByGender",countConsumeTrendByGender);
        map.put("countConsumeTrendAll",countConsumeTrendAll);
        return map;
    }
}
