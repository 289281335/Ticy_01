package com.sunmnet.bigdata.web.model.request.predict;

import com.sunmnet.bigdata.web.model.entity.student.StudentInfo;

public class PredictFailSubjectREQ extends StudentInfo{

    /**
     * 学院挂科请求实体类
     */
    private String majorCode;
    private String className;
    private String nation;
    private String nativePlace;
    private String gender;
    private Integer schoolYear;
    private String academyName;

    public PredictFailSubjectREQ() {
    }

    @Override
    public String getMajorCode() {
        return majorCode;
    }

    @Override
    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String getNation() {
        return nation;
    }

    @Override
    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String getNativePlace() {
        return nativePlace;
    }

    @Override
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public Integer getSchoolYear() {
        return schoolYear;
    }

    @Override
    public void setSchoolYear(Integer schoolYear) {
        this.schoolYear = schoolYear;
    }

    @Override
    public String getAcademyName() {
        return academyName;
    }

    @Override
    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }
}
