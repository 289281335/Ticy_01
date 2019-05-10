package com.sunmnet.bigdata.web.dao.statics;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IReportDAO {

    //行为预警数量月统计趋势
    List<Map<String,Object>> selectWarningMonthCount();
    //紧急预警数量月统计趋势
    List<Map<String,Object>> selectEmerWarningMonthCount();
    //学业预警数量月统计趋势
    List<Map<String,Object>> selectStudyWarningMonthCount();
    //查询未处理预警数量
    Integer selectWarningNoDealCount();
    //根据预警日期查询预警数量
    Integer selectWarningCountByWarningDate(@Param("fromDate") String fromDate);
    //查询预警数量学院排名
    Map<String,Object> queryAlarmCollegeRank();
    //查询预警处理效率学院排名
    Map<String,Object> queryAlarmDealRank();
    //查询预警准确率
    Map<String,Object> queryAlarmAccuracyRate();
    //查询预警总数量
    Integer selectWarningCount();
    //查询预警错误数量
    Integer selectWarningErrorCount();
}
