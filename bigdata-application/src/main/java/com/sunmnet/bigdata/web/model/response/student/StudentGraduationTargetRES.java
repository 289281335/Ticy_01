package com.sunmnet.bigdata.web.model.response.student;

import com.sunmnet.bigdata.commons.model.BaseModel;
import com.sunmnet.bigdata.web.model.enums.ArgetType;
import com.sunmnet.bigdata.web.model.enums.SimilarityDegreeQueryType;

import java.util.List;

public class StudentGraduationTargetRES extends BaseModel{

   private String studentNo;
   private ArgetType argetType;
   private List<String> schoolCode;//学校代码
   private String industryCode; //行业代码
   private List<String> positionCode;//职业编码
   private SimilarityDegreeQueryType similarityDegreeQueryType; //相似度查询类型

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public ArgetType getArgetType() {
        return argetType;
    }

    public void setArgetType(ArgetType argetType) {
        this.argetType = argetType;
    }

    public List<String> getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(List<String> schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public List<String> getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(List<String> positionCode) {
        this.positionCode = positionCode;
    }

    public SimilarityDegreeQueryType getSimilarityDegreeQueryType() {
        return similarityDegreeQueryType;
    }

    public void setSimilarityDegreeQueryType(SimilarityDegreeQueryType similarityDegreeQueryType) {
        this.similarityDegreeQueryType = similarityDegreeQueryType;
    }
}
