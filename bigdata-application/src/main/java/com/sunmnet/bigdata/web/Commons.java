package com.sunmnet.bigdata.web;

import com.sunmnet.bigdata.web.model.request.statis.StatisStudentSurfInternetMonthREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import org.apache.commons.collections.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Commons {
    public static Map<String,Object> convertListMap2Map(List<Map<String,Object>> list){
        Map<String,Object> result = new HashMap<>();
        if(CollectionUtils.isEmpty(list)){
            return result;
        }
        for(Map<String,Object> map : list){
            result.putAll(map);
        }
        return result;
    }


    public static StatisStudentSurfInternetMonthREQ convertStudentInfoREQ2StatisStudentSurfInternetMonthREQ(StudentInfoREQ studentInfoREQ){

        StatisStudentSurfInternetMonthREQ statisStudentSurfInternetMonthREQ = new StatisStudentSurfInternetMonthREQ();
        if(studentInfoREQ==null){
            return null;
        }
        statisStudentSurfInternetMonthREQ.setAcademyName(studentInfoREQ.getAcademyName());
        statisStudentSurfInternetMonthREQ.setClassName(studentInfoREQ.getAcademyName());
        statisStudentSurfInternetMonthREQ.setCollegeCode(studentInfoREQ.getCollegeCode());
        statisStudentSurfInternetMonthREQ.setMajorCode(studentInfoREQ.getMajorCode());
        statisStudentSurfInternetMonthREQ.setNation(studentInfoREQ.getNation());
        statisStudentSurfInternetMonthREQ.setGender(studentInfoREQ.getGender());
        statisStudentSurfInternetMonthREQ.setPlace(studentInfoREQ.getNativePlace());
        return statisStudentSurfInternetMonthREQ;
    }

}
