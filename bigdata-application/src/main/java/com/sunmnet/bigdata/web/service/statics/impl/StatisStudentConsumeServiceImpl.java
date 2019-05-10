/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.statics.impl;

import com.sunmnet.bigdata.web.dao.statics.IStatisStudentConsumeDAO;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.service.statics.IStatisStudentConsumeService;
import com.sunmnet.bigdata.web.util.BusinessUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StatisStudentConsumeServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("StatisStudentConsumeServiceImpl")
public class StatisStudentConsumeServiceImpl  implements IStatisStudentConsumeService {
    @Autowired
    private IStatisStudentConsumeDAO statisStudentConsumeDAO;


    @Override
    public List<Map<String, Object>> avgMonthConsume(StudentInfoREQ studentInfoREQ) {
        return statisStudentConsumeDAO.avgMonthConsume(studentInfoREQ);
    }


    /**
     * 日均消费金额(综合画像)
     */
    @Override
    public double avgDayConsume(StudentInfoREQ studentInfoREQ) {
        studentInfoREQ.setStartDate(BusinessUtils.getStartDateBySchoolYear(studentInfoREQ.getSchoolYear().toString()));
        studentInfoREQ.setEndDate(BusinessUtils.getEndDateBySchoolYear(studentInfoREQ.getSchoolYear().toString()));
        List<Map<String, Object>> list = statisStudentConsumeDAO.avgMonthConsume(studentInfoREQ);
        BigDecimal result = this.calculateAverageDayAmount(list);
        return result == null ? 0d : result.doubleValue();
    }

    /**
     * 计算日均消费金额
     * @param list
     * @return
     */
    private BigDecimal calculateAverageDayAmount(List<Map<String, Object>> list) {
        BigDecimal ret = new BigDecimal(0);
        if(list != null && !list.isEmpty()) {
            BigDecimal total = new BigDecimal(0);
            BigDecimal days = new BigDecimal(0);
            if(list.size() > 1) {
                list.remove(list.size()-1);
                for(Map<String, Object> map : list) {
                    String consumeDate = (String)map.get("consumeDate");
                    String month = consumeDate.substring(consumeDate.indexOf("-")+1);
                    if(month.equals("03") || month.equals("04") || month.equals("05") || month.equals("06") ||
                            month.equals("09") || month.equals("10") || month.equals("11") || month.equals("12")) {
                        days = days.add(new BigDecimal(30));
                        total = total.add((BigDecimal)map.get("averageAmount"));
                    }
                }
                ret = total.divide(days, 2, BigDecimal.ROUND_HALF_UP);
            }else {
                ret = ((BigDecimal)list.get(0).get("averageAmount")).divide(new BigDecimal(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)), 2, BigDecimal.ROUND_HALF_UP);
            }
        }
        return ret;
    }
}
