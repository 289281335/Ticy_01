package com.sunmnet.bigdata.web.service.statics.impl;

import com.sunmnet.bigdata.web.dao.statics.IReportDAO;
import com.sunmnet.bigdata.web.service.statics.IReportService;
import com.sunmnet.bigdata.web.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
@Transactional
@Service("ReportServiceImpl")
public class ReportServiceImpl implements IReportService {
    @Autowired
    private IReportDAO reportDAO;
    /**
     * 按月查询预警数量趋势
     * @return
     */
    @Override
    public Map<String, Object> countAlarmByMonth() {
        Map<String, Object> retMap = new HashMap<String, Object>();
        //行为预警数量月统计趋势
        List<Map<String, Object>> behaviorList = reportDAO.selectWarningMonthCount();
        //紧急预警数量月统计趋势
        List<Map<String, Object>> emerList = reportDAO.selectEmerWarningMonthCount();
        //学业预警数量月统计趋势
        List<Map<String, Object>> studyList = reportDAO.selectStudyWarningMonthCount();
        //查询未处理预警数量
        Integer noDealCount = reportDAO.selectWarningNoDealCount();
        //当天的预警数量
        Integer nowCount = reportDAO.selectWarningCountByWarningDate(DateUtils.formatDate(new Date()));
        //查询上月同期预警数量
        Integer lastMonthCount = reportDAO.selectWarningCountByWarningDate(DateUtils.formatDate(DateUtils.addMonths(new Date(), -1)));
        //环比增长率 （本次的数据与上次数据的差值，然后比上上次数据的值。）
        BigDecimal rate = new BigDecimal(nowCount).subtract(new BigDecimal(lastMonthCount)).divide(new BigDecimal(lastMonthCount), 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));

        List<String> monthList = this.getMonthList();
        retMap.put("behaviorList", this.dataProcessing(behaviorList, monthList));
        retMap.put("emerList", this.dataProcessing(emerList, monthList));
        retMap.put("studyList", this.dataProcessing(studyList, monthList));
        retMap.put("totalCount", noDealCount);
        retMap.put("lastMonthCount", lastMonthCount);
        retMap.put("growRate", rate);

        return retMap;
    }

    /**
     * 查询预警数量学院排名
     *
     * @return
     */
    @Override
    public Map<String, Object> queryAlarmCollegeRank() {
        return reportDAO.queryAlarmCollegeRank();
    }

    /**
     * 查询预警处理效率学院排名
     *
     * @return
     */
    @Override
    public Map<String, Object> queryAlarmDealRank() {
        return reportDAO.queryAlarmDealRank();
    }

    /**
     * 查询预警准确率
     * @return
     */
    @Override
    public Map<String, Object> queryAlarmAccuracyRate() {
        Map<String, Object> retMap = new HashMap<String, Object>();
        //查询总预警数量
        Integer warningCount = reportDAO.selectWarningCount();
        //查询未处理预警数量
        Integer noDealCount = reportDAO.selectWarningNoDealCount();
        //查询错误预警数量
        Integer errorCount = reportDAO.selectWarningErrorCount();
        //预警正确数量
        Integer correctCount = warningCount - noDealCount - errorCount;
        retMap.put("noDealCount", noDealCount);
        retMap.put("errorCount", errorCount);
        retMap.put("correctCount", correctCount);
        return retMap;
    }


    /**
     * 处理每月平均消费次数
     * @param dataList
     * @param monthList
     * @return
     */
    private List<Map<String, Object>> dataProcessing(List<Map<String, Object>> dataList, List<String> monthList) {
        List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
        if(dataList != null && !dataList.isEmpty()) {
            for(String month : monthList) {
                boolean flag = false;
                for(Map<String, Object> map : dataList) {
                    String consumeDate = (String)map.get("warningDate");
                    if(month.equals(consumeDate)) {
                        retList.add(map);
                        flag = true;
                    }
                }

                if(!flag) {
                    Map<String, Object> newMap = new HashMap<String, Object>();
                    newMap.put("warningDate", month);
                    newMap.put("warningCount", 0);
                    retList.add(newMap);
                }
            }
        }
        return retList;
    }

    /**
     * 获取查询年月
     * @return
     */
    private List<String> getMonthList() {
        ArrayList<String> retList = new ArrayList<String>();
        Calendar maxDate = Calendar.getInstance();
        Calendar minDate = Calendar.getInstance();
        minDate.add(Calendar.MONTH, -11);

        retList.add(DateUtils.dateToString(maxDate.getTime(), DateUtils.PATTERN_MONTH));
        while(maxDate.compareTo(minDate) > 0) {
            maxDate.add(Calendar.MONTH, -1);
            retList.add(DateUtils.dateToString(maxDate.getTime(), DateUtils.PATTERN_MONTH));
        }
        return retList;
    }
}
