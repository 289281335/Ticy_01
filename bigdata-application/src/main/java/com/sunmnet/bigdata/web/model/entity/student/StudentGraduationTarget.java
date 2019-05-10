package com.sunmnet.bigdata.web.model.entity.student;

import com.sunmnet.bigdata.commons.model.BaseModel;


/**
 * @ClassName StudentGraduationTarget
 * @Description 
 * @author android
 * @date 2017-12-07 14:59:13
 * @version 1.0 
 */
@SuppressWarnings("serial")
public class StudentGraduationTarget extends BaseModel{

    //主键
    private Long id;
    //学号
    private String StudentNo;
    //目标分类   读研 READ   就业 WORK
    private String argetType;
    //学校编码
    private String schoolCode;
    //行业编码
    private String industryCode;
    //职位编码
    private String positionCode;
    //创建时间 格式：yyyyMMddHHmmssSSS
    private String createTime;
    //最后修改时间 格式：yyyyMMddHHmmssSSS
    private String modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentNo() {
        return StudentNo;
    }

    public void setStudentNo(String studentNo) {
        StudentNo = studentNo;
    }

    public String getArgetType() {
        return argetType;
    }

    public void setArgetType(String argetType) {
        this.argetType = argetType;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}