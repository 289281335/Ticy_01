/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:57
 */
package com.sunmnet.bigdata.web.service.alarm.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.dao.alarm.IAlarmLateBackDAO;
import com.sunmnet.bigdata.web.dao.alarm.IAlarmStudentLostDAO;
import com.sunmnet.bigdata.web.dao.alarm.IAlarmStudentSubjectsDAO;
import com.sunmnet.bigdata.web.dao.alarm.IAlarmStudentTruancyDAO;
import com.sunmnet.bigdata.web.model.enums.WarningTypeEnum;
import com.sunmnet.bigdata.web.model.request.alarm.AlarmStudentREQ;
import com.sunmnet.bigdata.web.model.request.alarm.PageAlarmLateBackAndLostREQ;
import com.sunmnet.bigdata.web.model.request.alarm.PageAlarmStudentREQ;
import com.sunmnet.bigdata.web.model.request.student.PageStudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.response.alarm.AlarmStudentRES;
import com.sunmnet.bigdata.web.model.response.alarm.PageAlarmLateBackAndLostRES;
import com.sunmnet.bigdata.web.model.response.student.StudentInfoRES;
import com.sunmnet.bigdata.web.service.alarm.IAlarmLateBackService;
import com.sunmnet.bigdata.web.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.*;

/**
 * @author wdong
 * @version 1.0
 * @ClassName AlarmLateBackServiceImpl
 * @Description
 * @date 2018-01-30 09:48:57
 */
@Transactional
@Service("AlarmLateBackServiceImpl")
public class AlarmLateBackServiceImpl implements IAlarmLateBackService{

    @Autowired
    private IAlarmLateBackDAO alarmLateBackDAO;
    @Autowired
    private IAlarmStudentLostDAO alarmStudentLostDAO;
    @Autowired
    private IAlarmStudentTruancyDAO alarmStudentTruancyDAO;
    @Autowired
    private IAlarmStudentSubjectsDAO alarmStudentSubjectsDAO;

    private final String DATE_PATTERN = "yyyy-MM";


    @Override
    public List listWarningStudent() {
        return alarmLateBackDAO.listWarningStudent(getFromDate(), DateUtils.dateToString(new Date(), DATE_PATTERN));
    }

    /**
     * listLateBackAndLostWarning
     * 学生晚归失联预警列表
     * @return
     */
    @Override
    public PageRES<PageAlarmLateBackAndLostRES> listLateBackAndLostWarning(PageAlarmLateBackAndLostREQ pageAlarmLateBackAndLostREQ) {
        Pageable pageable = pageAlarmLateBackAndLostREQ.getPageable();
        List list=alarmLateBackDAO.listLateBackAndLostWarning(pageAlarmLateBackAndLostREQ);
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        Page count=(Page)list;
        return new PageRES(list,pageable,count.getTotal());
    }

    /**
     * 查询行为预警每月数量
     * @return
     */
    @Override
    public List listWarningMonthCount() {
        return alarmLateBackDAO.listWarningMonthCount();
    }

    /**
     * 查询行为预警信息概要
     * @return
     */
    public Map<String,Object> queryWarningGeneralInfo(){
        Map<String, Object> map = new HashMap<String, Object>();
        Integer count = alarmLateBackDAO.countDealWarning(new StudentInfoREQ());//待处理预警
        map.put("dealCount", count);
        List<Map<String, Object>> list = alarmLateBackDAO.listWarningMonthCount();//月预警
        map.put("currMonthCount", ObjectUtils.isEmpty(list)?0:(Long)list.get(0).get("warningCount"));
        map.put("monthAverageCount", this.getMonthAverageCount(list));//月平均
        map.put("highMonth", this.getHighCountMonth(list));//月最高
        return map;
    }

    /**
     * 处理预警标识信息
     * @param studentNo
     * @param warningType
     * @param warningDate
     * @param reason
     * @param remark
     */
    public void dealWarningInfo(String studentNo, String warningType, String warningDate, String reason, String remark){
        //晚归
        if(WarningTypeEnum.LATE_BACK_WARN.getName().equals(warningType)) {
            alarmLateBackDAO.updateLateBackWarning(studentNo, warningDate, reason, remark);
        }
        //失联
        if(WarningTypeEnum.LOST_WARN.getName().equals(warningType)) {
            alarmStudentLostDAO.updateLostWarning(studentNo, warningDate, reason, remark);
        }
        //挂科
        if(WarningTypeEnum.SUBJECTS_WARN.getName().equals(warningType)) {
            alarmStudentSubjectsDAO.updateSubjectsWarning(studentNo, warningDate, reason, remark);
        }
        //逃课
        if(WarningTypeEnum.TRUANCY_WARN.getName().equals(warningType)) {
            alarmStudentTruancyDAO.updateTruancyWarning(studentNo, warningDate, reason, remark);
        }
        //其它
        if(WarningTypeEnum.OTHER_WARN.getName().equals(warningType)) {
//            alarmStudentLostDAO.updateLostJobWarning(studentNo, warningDate, reason, remark);
        }
    }

    /**
     * 学生紧急预警数量
     * @return
     */
    public List countEmerWarningStudent(){
        return alarmLateBackDAO.countEmerWarningStudent(getFromDate(), DateUtils.dateToString(new Date(), DATE_PATTERN));
    }
    /**
     * 查询每日紧急预警前15的数量
     * @return
     */
    public List countEmerWarningDay(){
        return alarmLateBackDAO.countEmerWarningDay();
    }

    /**
     * 查询紧急预警概要信息
     * @return
     */
    public Map<String,Object> queryEmerWarningGeneralInfo() {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer count = alarmLateBackDAO.countDealEmerWarning(new StudentInfoREQ());
        map.put("dealCount", count);//待处理紧急预警数
        List<Map<String, Object>> list = alarmLateBackDAO.countEmerWarningDay();
        map.put("currDayCount", (Long) list.get(0).get("warningCount"));
        map.put("dayAverageCount", this.getDayAverageCount(list));
        map.put("highDay", this.getHighCountDay(list));
        map.put("growRate", this.getGrowRate(list));
        return map;
    }
    /**
     * 查询紧急预警列表
     * @param pageStudentInfoREQ
     * @return
     */
   public PageRES<StudentInfoRES> pageEmerWarning(PageStudentInfoREQ pageStudentInfoREQ){
        Pageable pageable = pageStudentInfoREQ.getPageable();
        StudentInfoREQ studentInfoREQ = pageStudentInfoREQ.getStudentInfoREQ();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<StudentInfoRES> list = alarmLateBackDAO.pageEmerWarning(studentInfoREQ, pageable.getSort());
        Page<StudentInfoRES> count = (Page<StudentInfoRES>)list;
        return new PageRES(list,pageable, count.getTotal());
    }


    /**
     * 计算月均行为预警数量
     * @param list
     * @return
     */
    private Long getMonthAverageCount(List<Map<String, Object>> list) {
        long ret = 0;
        if(list != null && !list.isEmpty()) {
            long totalCount = 0;
            for(Map<String, Object> map : list) {
                totalCount = totalCount +  (Long)map.get("warningCount");
            }
            ret = totalCount/list.size();
        }
        return ret;
    }

    /**
     * 计算最高月份
     * @param list
     * @return
     */
    private String getHighCountMonth(List<Map<String, Object>> list) {
        String highMonth = "";
        if(list != null && !list.isEmpty()) {
            long count = 0;
            for(Map<String, Object> map : list) {
                long currCount = (Long)map.get("warningCount");
                if(currCount > count) {
                    highMonth = (String)map.get("warningDate");
                    count = currCount;
                }
            }
        }
        return highMonth;
    }
    /**
     * 获取学期开始日期
     * @return
     */
    private String getFromDate() {
        String fromDate = null;
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int year =  Calendar.getInstance().get(Calendar.YEAR);
        if(month <= 2) {
            fromDate = (year - 1) + "-" + "09";
        }

        if(month > 2 && month < 9) {
            fromDate = year + "-02";
        }

        if(month >= 9) {
            fromDate = year + "-09";

        }
        return fromDate;
    }

    /**
     * 计算日均紧急预警数量
     * @param list
     * @return
     */
    private Long getDayAverageCount(List<Map<String, Object>> list) {
        long ret = 0;
        if(list != null && !list.isEmpty()) {
            long totalCount = 0;
            for(Map<String, Object> map : list) {
                totalCount = totalCount +  (Long)map.get("warningCount");
            }
            ret = totalCount/list.size();
        }
        return ret;
    }

    /**
     * 计算最高日紧急预警量
     * @param list
     * @return
     */
    private String getHighCountDay(List<Map<String, Object>> list) {
        String highMonth = "";
        if(list != null && !list.isEmpty()) {
            long count = 0;
            for(Map<String, Object> map : list) {
                long currCount = (Long)map.get("warningCount");
                if(currCount > count) {
                    highMonth = (String)map.get("warningDate");
                    count = currCount;
                }
            }
        }
        return highMonth;
    }

    /**
     * 获取增长率
     * @param list
     * @return
     */
    private String getGrowRate(List<Map<String, Object>> list) {
        String growRate = "";
        if(list != null && !list.isEmpty()) {
            long currCount = (Long)list.get(0).get("warningCount");
            long yestCount = 0;
            if(list.size() >= 2) {
                yestCount = (Long)list.get(1).get("warningCount");
            }
            if(yestCount == 0) {
                growRate = currCount + "条";
            }else {
                growRate = (currCount - yestCount) * 100/yestCount + "%";

            }
        }
        return growRate;
    }
}
