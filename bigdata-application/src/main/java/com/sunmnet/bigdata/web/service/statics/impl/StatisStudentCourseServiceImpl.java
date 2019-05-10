/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.statics.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunmnet.bigdata.commons.model.PageResult;
import com.sunmnet.bigdata.commons.model.response.PageRES;
import com.sunmnet.bigdata.web.dao.predict.IPredictStudentSubjectsDAO;
import com.sunmnet.bigdata.web.dao.statics.IStatisStudentCourseDAO;
import com.sunmnet.bigdata.web.dao.statics.IStatisStudentScoresRecordDAO;
import com.sunmnet.bigdata.web.dao.student.IStudentConsumptionIndexDAO;
import com.sunmnet.bigdata.web.dao.student.IStudentCourseDAO;
import com.sunmnet.bigdata.web.dao.student.IStudentCourseRecordDAO;
import com.sunmnet.bigdata.web.dao.student.IStudentInfoDAO;
import com.sunmnet.bigdata.web.model.entity.statics.StatisStudentCourse;
import com.sunmnet.bigdata.web.model.entity.student.StudentConsumptionIndex;
import com.sunmnet.bigdata.web.model.entity.student.StudentInfo;
import com.sunmnet.bigdata.web.model.request.student.PageStudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.service.statics.IStatisStudentCourseService;
import com.sunmnet.bigdata.web.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StatisStudentCourseServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("StatisStudentCourseServiceImpl")
public class StatisStudentCourseServiceImpl implements IStatisStudentCourseService {

    @Autowired
    private IStatisStudentCourseDAO statisStudentCourseDAO;
    @Autowired
    private IStudentInfoDAO studentInfoDAO;
    @Autowired
    private IStudentConsumptionIndexDAO studentConsumptionIndexDAO;
    @Autowired
    private IStatisStudentScoresRecordDAO statisStudentScoresRecordDAO;
    @Autowired
    private IPredictStudentSubjectsDAO predictStudentSubjectsDAO;
    @Autowired
    private IStudentCourseRecordDAO studentCourseRecordDAO;


    /**
     * 查询学习相关标签
     */
    @Override
    public Map<String, Object> queryStudiesLabel(String studentNo) {
        Map<String, Object> map = new HashMap<String, Object>();
        //查询学生信息
        StudentInfo info = studentInfoDAO.getStudentByNo(studentNo);
        //学习水平
//        String learningLeveLable = this.calculateLearningLeveLable(info);
//        BigDecimal level = studentConsumptionIndexDAO.levelByStudentNo(studentNo);
        //成绩稳定性
        String  scoreLable = "";
        //查询该学生所在专业的学生数量
        Integer count = studentConsumptionIndexDAO.selectStudentCountByMajorCode(info.getMajorCode());
        //查询该学生在其专业的成绩排名
        Integer ranking = studentConsumptionIndexDAO.selectStabilityRankingByStudentNumberAndMajorCode(studentNo, info.getMajorCode());
        if(count != null && ranking != null) {
            double rate = (double)ranking/count;
            if(rate <= 0.1) {
                scoreLable = "成绩很稳定";
            }
            if(rate > 0.1 && rate <= 0.3) {
                scoreLable = "成绩较稳定";
            }
            if(rate > 0.3 && rate <= 0.7) {
                scoreLable = "成绩稳定性一般";
            }
            if(rate > 0.7 && rate <= 0.9) {
                scoreLable = "成绩较不稳定";
            }
            if(rate > 0.9 && rate <= 1) {
                scoreLable = "成绩不稳定";
            }
        }

        //上课纪律
        String classLable = "";
        List<StatisStudentCourse> recordList = statisStudentCourseDAO.selectClassRecordByStudentNo(studentNo, getFromDate(),DateUtils.dateToString(new Date(), DateUtils.PATTERN_MONTH));
        if(recordList != null && !recordList.isEmpty()) {
            int badClassTimes = 0;
            int totalClassTimes = 0;
            for(StatisStudentCourse record : recordList) {
                badClassTimes += record.getLateTimes() + record.getLeftTimes() + record.getTruancyTimes();
                totalClassTimes += record.getLateTimes() + record.getLeftTimes() + record.getTruancyTimes() + record.getNormalTimes();
            }
            if(totalClassTimes != 0) {
                classLable = calculateDiscipline(badClassTimes, totalClassTimes);
            }
        }

        //挂科次数
        String failLable = "";
        List<Map<String, Object>> schoolRecordList = statisStudentScoresRecordDAO.selectSemesterAverageScoreByStudentNo(studentNo);//平均成绩
        if(schoolRecordList != null && !schoolRecordList.isEmpty()) {
            int totalFailTimes = 0;
            for(Map<String, Object> failMap : schoolRecordList) {
                totalFailTimes += (int)failMap.get("failTimes");
            }
            if(totalFailTimes > 0) {
                failLable = "挂科" + totalFailTimes + "门";
            }else {
                failLable = "无挂科";
            }
        }

        //成绩预测
        String forecastLable = "";
        int failCount = predictStudentSubjectsDAO.failCourseCount(studentNo);
        if(failCount > 0) {
            forecastLable = "有挂科风险";
        }

        //疑似逃课
        String truancyLable = "";
        List<Map<String,Object>> list = studentCourseRecordDAO.selectTruancyRecordByStudentNo(studentNo);
        if(list != null && list.size() > 10) {
            truancyLable = "逃课王";
        }
        map.put("label",scoreLable + "," + "7.8"  + "," + classLable + "," + failLable + "," + forecastLable + "," + truancyLable);
        return map;
    }

    /**查询学生到课率
     * statis_student_course
     * @param studentNo
     * @param queryType
     * @return
     */
    @Override
    public Map<String, Object> queryClassRate(String studentNo, String queryType) {
        Map<String, Object> map = new HashMap<String, Object>();

        //查询学生上课情况
        if("month".equals(queryType)) {
            List<StatisStudentCourse> list = statisStudentCourseDAO.selectClassRecordByStudentNo(studentNo, DateUtils.dateToString(DateUtils.addMonths(new Date(), -11), DateUtils.PATTERN_MONTH),
                    DateUtils.dateToString(new Date(), DateUtils.PATTERN_MONTH));
            map.put("list", list);
        }else {
            List<Map<String, Object>> list = statisStudentCourseDAO.selectClassRateByStudentNumberAndTerm(studentNo);
            map.put("list", list);
        }
        return map;
    }

    /**
     * 查询分析学生到课时间
     * @param studentNo
     * @return
     */
    @Override
    public Map<String, Object> queryAnalysisClassRateTime(String studentNo) {
        return statisStudentCourseDAO.selectClassTimeByStudentNo(studentNo, getFromDate(),DateUtils.dateToString(new Date(), DateUtils.PATTERN_MONTH));
    }
    public PageRES<PageStudentInfoREQ> pageClassAttendanceDetail(PageStudentInfoREQ pageStudentInfoREQ){

        Pageable pageable = pageStudentInfoREQ.getPageable();
        List list=statisStudentCourseDAO.selectClassDetailByStudentNo(pageStudentInfoREQ.getStudentInfoREQ());
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        Page count=(Page)list;
        return new PageRES(list,pageable,count.getTotal());
    }

    @Override
    public Map<String, Object> queryAllSuspectedTruancyInfo(StudentInfoREQ studentInfoREQ) {
        return (Map<String, Object>) statisStudentCourseDAO.selectTruancyTimesByCondition(studentInfoREQ);

    }

    @Override
    public PageRES<Map<String, Object>> pageAllSuspectedTruancyInfo(PageStudentInfoREQ pageStudentInfoREQ) {
        Pageable pageable = pageStudentInfoREQ.getPageable();
        List list=statisStudentCourseDAO.selectTruancyStudentByCondition(pageStudentInfoREQ.getStudentInfoREQ());
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        Page count=(Page)list;
        return new PageRES(list,pageable,count.getTotal());
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
     * 计算上课纪律性
     * @param badTimes
     * @param totalTimes
     * @return
     */
    private String calculateDiscipline(int badTimes, int totalTimes) {
        String retString = "";
        double result = new BigDecimal(1).subtract(new BigDecimal(badTimes).divide(new BigDecimal(totalTimes), 2, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100)).doubleValue();
        if(result <= 100 && result > 80) {
            retString = "上课纪律很好";
        }

        if(result <=80 && result > 60) {
            retString = "上课纪律良好";
        }

        if(result <=60 && result > 40) {
            retString = "上课纪律一般";
        }

        if(result <=40 && result > 20) {
            retString = "上课纪律较差";
        }

        if(result <=20 && result >= 0) {
            retString = "上课纪律很差";
        }
        return retString;
    }

//    /**
//     * 计算学生学习水平标签
//     * @param info
//     * @return
//     */
//    private String calculateLearningLeveLable(StudentInfo info) {
//        String retStr = "";
//        //查询个人学习水平
//        StudentConsumptionIndex personLearningLevel = studentConsumptionIndexDAO.levelByStudentNo(info.getStudentNo());
//
//        if(personLearningLevel == null ) {
//            //查询该学生所在专业的学生数量
//            Integer count = studentSchoolRecordMapper.selectStudentCountByMajorCode(info.getMajorCode());
//            //查询该学生在其专业的成绩排名
//            Integer ranking = studentSchoolRecordMapper.selectScoreRankingByStudentNumberAndMajorCode(info.getStudentNo(), info.getMajorCode());
//            if(ranking != null) {
//                double rate = (double)ranking/count;
//                if(rate <= 0.1) {
//                    retStr = "学霸";
//                }
//                if(rate > 0.1 && rate <= 0.3) {
//                    retStr = "学习良好";
//                }
//                if(rate > 0.3 && rate <= 0.7) {
//                    retStr = "学习一般";
//                }
//
//                if(rate > 0.7 && rate <= 0.9) {
//                    retStr = "学习较差";
//                }
//
//                if(rate > 0.9 && rate <= 1) {
//                    retStr = "学渣";
//                }
//            }
//        }else {
//            //查询总记录数
//            Integer count = studentLearningLevelMapper.selectLearningLevelCount();
//            StudentConsumptionIndex first = studentLearningLevelMapper.selectStudentLearningLevelByLineNumber(0);
//            StudentConsumptionIndex one = studentLearningLevelMapper.selectStudentLearningLevelByLineNumber(new BigDecimal(count * 0.1).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
//            StudentConsumptionIndex two = studentLearningLevelMapper.selectStudentLearningLevelByLineNumber(new BigDecimal(count * 0.3).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
//            StudentConsumptionIndex three = studentLearningLevelMapper.selectStudentLearningLevelByLineNumber(new BigDecimal(count * 0.7).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
//            StudentConsumptionIndex four = studentLearningLevelMapper.selectStudentLearningLevelByLineNumber(new BigDecimal(count * 0.9).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
//            StudentConsumptionIndex end = studentLearningLevelMapper.selectStudentLearningLevelByLineNumber(count - 1);
//
//            if(personLearningLevel.compareTo(first.getScoreIndex()) >= 0 && personLearningLevel.compareTo(one.getScoreIndex()) < 0) {
//                retStr = "学渣";
//            }
//
//            if(personLearningLevel.compareTo(one.getScoreIndex()) >= 0 && personLearningLevel.compareTo(two.getScoreIndex()) < 0) {
//                retStr = "学习较差";
//            }
//
//            if(personLearningLevel.compareTo(two.getScoreIndex()) >= 0 && personLearningLevel.compareTo(three.getScoreIndex()) < 0) {
//                retStr = "学习一般";
//            }
//
//            if(personLearningLevel.compareTo(three.getScoreIndex()) >= 0 && personLearningLevel.compareTo(four.getScoreIndex()) < 0) {
//                retStr = "学习良好";
//            }
//
//            if(personLearningLevel.compareTo(four.getScoreIndex()) >= 0 && personLearningLevel.compareTo(end.getScoreIndex()) <= 0) {
//                retStr = "学霸";
//            }
//        }
//
//        return retStr;
//    }
}
