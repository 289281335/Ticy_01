/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.student.impl;

import com.sunmnet.bigdata.web.dao.student.IStudentConsumptionIndexDAO;
import com.sunmnet.bigdata.web.dao.student.IStudentInfoDAO;
import com.sunmnet.bigdata.web.model.entity.student.StudentConsumptionIndex;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.service.student.IStudentConsumptionIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentConsumptionIndexServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("StudentConsumptionIndexServiceImpl")
public class StudentConsumptionIndexServiceImpl implements IStudentConsumptionIndexService {
    @Autowired
    private IStudentConsumptionIndexDAO studentConsumptionIndexDAO;
    @Autowired
    private IStudentInfoDAO studentInfoDAO;
    @Override
    public Map<String, Object> studyState() {
        List<Map<String, Object>> list = studentConsumptionIndexDAO.studyIndex();
        Map<String, Object> resultMap = new HashMap<>();
        for (Map<String, Object> map : list){
            resultMap.putAll(map);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> socialState() {
        List<Map<String, Object>> list = studentConsumptionIndexDAO.socialIndex();
        Map<String, Object> resultMap = new HashMap<>();
        for (Map<String, Object> map : list){
            resultMap.putAll(map);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> eatState() {
        List<Map<String, Object>> list = studentConsumptionIndexDAO.eatIndex();
        Map<String, Object> resultMap = new HashMap<>();
        for (Map<String, Object> map : list){
            resultMap.putAll(map);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> poorPeople() {
        List<Map<String, Object>> list = studentConsumptionIndexDAO.poorIndex();
        Map<String, Object> resultMap = new HashMap<>();
        for (Map<String, Object> map : list){
            resultMap.putAll(map);
        }
        return resultMap;
    }

    @Override
    public Map<String, Integer> sleepState() {
        Map<String, Integer> map5 = new HashMap<>();
        map5.put("badSleep", 650);
        map5.put("commomSleep", 780);
        map5.put("goodSleep", 210);
        return map5;
    }

    /***
     * 查询学霸数量(综合画像)
     * @param studentInfoREQ
     * @return
     */
    @Override
    public Integer excellentStudents(StudentInfoREQ studentInfoREQ) {
        //查询总记录数
        Integer count = studentConsumptionIndexDAO.countLevel();
        StudentConsumptionIndex four = studentConsumptionIndexDAO.levelByIndex(new BigDecimal(count * 0.9).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
        studentInfoREQ.setScoreIndex(four.getScoreIndex().toString());
        Integer highGradesCount = studentConsumptionIndexDAO.countLevelByCondition(studentInfoREQ);
        return highGradesCount == null ? 0 : highGradesCount;
    }


    /**
     * 查询学习水平比率(综合画像)
     */
    @Override
    public Map<String, Object> levelForTeam(StudentInfoREQ studentInfoREQ) {
        Map<String, Object> map = new HashMap<String, Object>();
        //查询总记录数
        Integer count = studentConsumptionIndexDAO.countLevel();
        StudentConsumptionIndex low = studentConsumptionIndexDAO.levelByIndex(new BigDecimal(count * 0.1).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
        StudentConsumptionIndex high = studentConsumptionIndexDAO.levelByIndex(new BigDecimal(count * 0.9).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());

        //根据条件查询学生数量
        Integer studentCount = studentInfoDAO.countStudentInfo(studentInfoREQ);
        BigDecimal lowRate = new BigDecimal(0.2);
        BigDecimal highRate = new BigDecimal(0.2);
        if(studentCount > 0) {
            //查询学渣百分比
            studentInfoREQ.setScoreIndex(low.getScoreIndex().toString());
            Integer lowCount = studentConsumptionIndexDAO.countLevelByCondition(studentInfoREQ);
            lowRate = new BigDecimal(1).subtract(new BigDecimal((double)lowCount/studentCount)).setScale(2, BigDecimal.ROUND_HALF_UP);
            //查询学霸百分比
            studentInfoREQ.setScoreIndex(high.getScoreIndex().toString());
            Integer highCount = studentConsumptionIndexDAO.countLevelByCondition(studentInfoREQ);
            highRate = new BigDecimal((double)highCount/studentCount).setScale(2, BigDecimal.ROUND_HALF_UP);
        }

        map.put("lowRate", lowRate.toString());
        map.put("middleRate", new BigDecimal(1).subtract(lowRate).subtract(highRate).toString());
        map.put("highRate", highRate.toString());
        return map;
    }

    @Override
    public Map<String, Object> dietRegularRate(StudentInfoREQ studentInfoREQ) {
        Map<String, Object> map = new HashMap<String, Object>();
        //查询总记录数
        Integer count = studentConsumptionIndexDAO.countDietRegular();
        //获取稳定性 较差稳定~差 的临界值
        StudentConsumptionIndex low = studentConsumptionIndexDAO.dietRegularByIndex(new BigDecimal(count * 0.1).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
        //获取稳定性 非常稳定~比较稳定的临界点
        StudentConsumptionIndex high = studentConsumptionIndexDAO.dietRegularByIndex(new BigDecimal(count * 0.9).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());

        BigDecimal lowRate = new BigDecimal(0.2);
        BigDecimal highRate = new BigDecimal(0.2);
        //根据条件查询学生数量
        Integer studentCount = studentInfoDAO.countStudentInfo(studentInfoREQ);
        if(studentCount > 0) {
            //查询三餐不规律百分比
            studentInfoREQ.setEatIndex(low.getDietIndex().toString());
            Integer lowCount = studentConsumptionIndexDAO.countDietRegularByCondition(studentInfoREQ);
            lowRate = new BigDecimal(1).subtract(new BigDecimal((double)lowCount/studentCount)).setScale(2, BigDecimal.ROUND_HALF_UP);
            //查询三餐规律百分比
            studentInfoREQ.setEatIndex(high.getDietIndex().toString());
            Integer highCount = studentConsumptionIndexDAO.countDietRegularByCondition(studentInfoREQ);
            highRate = new BigDecimal((double)highCount/studentCount).setScale(2, BigDecimal.ROUND_HALF_UP);
        }

        map.put("lowRate", lowRate.toString());
        map.put("middleRate", new BigDecimal(1).subtract(lowRate).subtract(highRate).toString());
        map.put("highRate", highRate.toString());
        return map;
    }


    @Override
    public Map<String, Integer> webState() {

        Map<String, Integer> map6 = new HashMap<>();
        map6.put("badWeb", 650);
        map6.put("commomWeb", 780);
        map6.put("goodWeb", 210);
        return map6;
    }

}
