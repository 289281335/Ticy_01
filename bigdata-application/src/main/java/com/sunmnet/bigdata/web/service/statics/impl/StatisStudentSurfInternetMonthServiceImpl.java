/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-31 17:13:05
 */
package com.sunmnet.bigdata.web.service.statics.impl;

import com.sunmnet.bigdata.web.Constants;
import com.sunmnet.bigdata.web.dao.statics.IStatisStudentSurfInternetMonthDAO;
import com.sunmnet.bigdata.web.model.entity.statics.StatisStudentSurfInternetMonth;
import com.sunmnet.bigdata.web.model.enums.CrushNetEnum;
import com.sunmnet.bigdata.web.model.enums.CrushNetOfWeekendEnum;
import com.sunmnet.bigdata.web.model.enums.RateNetHealthEnum;
import com.sunmnet.bigdata.web.model.request.statis.StatisStudentSurfInternetMonthREQ;
import com.sunmnet.bigdata.web.model.response.statis.SurfInternetStatusRES;
import com.sunmnet.bigdata.web.service.statics.IStatisStudentSurfInternetMonthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StatisStudentSurfInternetMonthServiceImpl
 * @Description
 * @date 2018-01-31 17:13:05
 */
@Transactional
@Service("StatisStudentSurfInternetMonthServiceImpl")
public class StatisStudentSurfInternetMonthServiceImpl implements IStatisStudentSurfInternetMonthService {
    @Autowired
    private IStatisStudentSurfInternetMonthDAO statisStudentSurfInternetMonthDAO;


    @Override
    public StatisStudentSurfInternetMonth last7WeekSurfInternet(String studentNo) {
        return statisStudentSurfInternetMonthDAO.getSurfInternetOfMonth(studentNo);
    }

    @Override
    public SurfInternetStatusRES getStudentNetTag(String studentNo) {
        StatisStudentSurfInternetMonth statisStudentSurfInternetMonth =
                statisStudentSurfInternetMonthDAO.getSurfInternetOfMonth(studentNo);
        SurfInternetStatusRES surfInternetStatusRES = new SurfInternetStatusRES();
        if(statisStudentSurfInternetMonth!=null){
            Integer AvgNetTime = statisStudentSurfInternetMonth.getAvgSurfNetTime();

            if(AvgNetTime> Constants.STATUS_OF_NET_SEVERE)
            {
                surfInternetStatusRES.setNetDegrees(CrushNetEnum.SEVERE_ADDICTION.getName());
            }
            else if(AvgNetTime < Constants.STATUS_OF_NET_SEVERE &&
                    AvgNetTime >= Constants.STATUS_OF_NET_MILD){
                surfInternetStatusRES.setNetDegrees(CrushNetEnum.MILD_ADDICTION.getName());
            }
            else {
                surfInternetStatusRES.setNetDegrees(CrushNetEnum.MILD_ADDICTION.getName());
            }
            String week1count = statisStudentSurfInternetMonth.getWeek1count();
            if(StringUtils.isNotEmpty(week1count)){
                Double weekendNetTime = Double.valueOf(week1count);
                if(weekendNetTime > Constants.HEALTH_OF_NET_WEEKEND) {
                    surfInternetStatusRES.setNetWeekendDegrees(CrushNetOfWeekendEnum.CRUSH_WEEKEND.getName());
                }else {
                    surfInternetStatusRES.setNetWeekendDegrees(CrushNetOfWeekendEnum.HEALTH_WEEKEND.getName());
                }
            }

        }
        if(StringUtils.isEmpty(surfInternetStatusRES.getNetDegrees())){
            surfInternetStatusRES.setNetDegrees(CrushNetEnum.NONE_ADDICTION.getName());
        }

        if(StringUtils.isEmpty(surfInternetStatusRES.getNetWeekendDegrees())){
            surfInternetStatusRES.setNetWeekendDegrees(CrushNetOfWeekendEnum.HEALTH_WEEKEND.getName());
        }

        return surfInternetStatusRES;
    }


    @Override
    public Map<String, Object> analyseNetTime(StatisStudentSurfInternetMonthREQ statisStudentSurfInternetMonthREQ) {
        List<Map<String, Object>> list = statisStudentSurfInternetMonthDAO.analyseNetTime(statisStudentSurfInternetMonthREQ);
        Map<String, Object> result  = new HashMap<>();
        for(Map<String, Object> objectMap : list){
            result.put(objectMap.get(Constants.CATEGARY_NET_FIELD).toString(),objectMap.get(Constants.TOTAL_NET_FIELD));
        }
        for(int i=1 ;i<=Constants.MAX_TIME_NET_FIELD;i++){
            if(!result.containsKey(String.valueOf(i))){
                result.put(String.valueOf(i),Constants.ZERO_VALUE_TOTAL);
            }
        }
        return result;
    }

    @Override
    public Map<String, Object> analysePeriodOfMonthNet(StatisStudentSurfInternetMonthREQ statisStudentSurfInternetMonthREQ) {
        List<Map<String, Object>> list = statisStudentSurfInternetMonthDAO.analyseNetTime(statisStudentSurfInternetMonthREQ);
        Map<String, Object> result  = new HashMap<>();
        for(Map<String, Object> objectMap : list){
            result.put(objectMap.get(Constants.CATEGARY_NET_FIELD).toString(),objectMap.get(Constants.TOTAL_NET_FIELD));
        }
        for(int i=1 ;i<=Constants.MAX_PERIOD_NET_FIELD;i++){
            if(!result.containsKey(String.valueOf(i))){
                result.put(String.valueOf(i),Constants.ZERO_VALUE_TOTAL);
            }
        }
        return result;
    }


    @Override
    public Map<String, Object> netHealthRatio(String studentNo) {
        StatisStudentSurfInternetMonth statisStudentSurfInternetMonth =
                statisStudentSurfInternetMonthDAO.getSurfInternetOfMonth(studentNo);

        Map<String, Object> map = new HashMap<String, Object>();
        if(statisStudentSurfInternetMonth!=null){
            Double nethealthrate = statisStudentSurfInternetMonth.getNethealthrate();
            if(nethealthrate!=null) {
                map.put(Constants.VALUE_NET_RATE_FIELD, nethealthrate);
                if (nethealthrate <= Constants.RATE_HEALTH_BEST_BAD_STATUS) {
                    map.put(Constants.HEALTH_NET_INFO_FIELD, RateNetHealthEnum.BEST_BAD_HEALTH);
                } else if (nethealthrate > Constants.RATE_HEALTH_BEST_BAD_STATUS
                        && nethealthrate <= Constants.RATE_HEALTH_BAD_STATUS) {
                    map.put(Constants.HEALTH_NET_INFO_FIELD, RateNetHealthEnum.BAD_HEALTH);
                } else if (nethealthrate > Constants.RATE_HEALTH_BAD_STATUS
                        && nethealthrate <= Constants.RATE_HEALTH_NORMAL_STATUS) {
                    map.put(Constants.HEALTH_NET_INFO_FIELD, RateNetHealthEnum.NORMAL_HEALTH);
                } else if (nethealthrate > Constants.RATE_HEALTH_NORMAL_STATUS
                        && nethealthrate <= Constants.RATE_HEALTH_GOOD_STATUS) {
                    map.put(Constants.HEALTH_NET_INFO_FIELD, RateNetHealthEnum.GOOD_HEALTH);
                }
            }

        }
        if(!map.containsKey(Constants.HEALTH_NET_INFO_FIELD)) {
            map.put(Constants.HEALTH_NET_INFO_FIELD, RateNetHealthEnum.BEST_GOOD_HEALTH);
        }
        if(!map.containsKey(Constants.VALUE_NET_RATE_FIELD)) {
            map.put(Constants.VALUE_NET_RATE_FIELD, Constants.ONE_VALUE_RATE);
        }
        return map;
    }




}
