/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */
package com.sunmnet.bigdata.web.model.entity.student;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentExcellentEmployment
 * @Description
 * @date 2018-01-30 09:48:59
 */
public class StudentExcellentEmployment extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StudentExcellentEmployment";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_ACADEMY_NAME = "academy_name";
	public static final String ALIAS_COLLEGE_NAME = "college_name";
	public static final String ALIAS_MAJOR_NAME = "major_name";
	public static final String ALIAS_STUDENT_NAME = "student_name";
	public static final String ALIAS_LENGTH_SCHOOLING = "length_schooling";
	public static final String ALIAS_GENDER = "gender";
	public static final String ALIAS_NATION = "nation";
	public static final String ALIAS_POLITICAL_OUTLOOK = "political_outlook";
	public static final String ALIAS_STUDENT_PLACE = "student_place";
	public static final String ALIAS_ENTERPRISE_OWNERSHIP = "enterprise_ownership";
	public static final String ALIAS_UNIT_NAME = "unit_name";
	public static final String ALIAS_UNIT_ADDRESS = "unit_address";
	public static final String ALIAS_ENTERPRISE_TYPE = "enterprise_type";
	public static final String ALIAS_UNIT_PROPERTIES = "unit_properties";
	public static final String ALIAS_UNIT_INDUSTRY = "unit_industry";
	public static final String ALIAS_GRADE = "grade";
	public static final String ALIAS_CREATE_TIME = "create_time";
	public static final String ALIAS_MODIFY_TIME = "modify_time";
	

	
    //
	private Long id;
    //学号
	private String studentNo;
    //书院名称
	private String academyName;
    //学院名称
	private String collegeName;
    //专业名称
	private String majorName;
    //姓名
	private String studentName;
    //学制
	private String lengthSchooling;
    //性别
	private String gender;
    //民族
	private String nation;
    //政治面貌
	private String politicalOutlook;
    //生源地
	private String studentPlace;
    //企业归属
	private String enterpriseOwnership;
    //单位名称
	private String unitName;
    //单位所在地
	private String unitAddress;
    //企业类型
	private String enterpriseType;
    //单位性质
	private String unitProperties;
    //单位行业
	private String unitIndustry;
    //年份
	private String grade;
    //创建时间 格式：yyyyMMddHHmmssSSS
	private String createTime;
    //最后修改时间 格式：yyyyMMddHHmmssSSS
	private String modifyTime;

	public StudentExcellentEmployment(){
	}

	public void setId(Long value) {
		this.id = value;
	}
	public Long getId() {
		return this.id;
	}


	public void setStudentNo(String value) {
		this.studentNo = value;
	}
	public String getStudentNo() {
		return this.studentNo;
	}


	public void setAcademyName(String value) {
		this.academyName = value;
	}
	public String getAcademyName() {
		return this.academyName;
	}


	public void setCollegeName(String value) {
		this.collegeName = value;
	}
	public String getCollegeName() {
		return this.collegeName;
	}


	public void setMajorName(String value) {
		this.majorName = value;
	}
	public String getMajorName() {
		return this.majorName;
	}


	public void setStudentName(String value) {
		this.studentName = value;
	}
	public String getStudentName() {
		return this.studentName;
	}


	public void setLengthSchooling(String value) {
		this.lengthSchooling = value;
	}
	public String getLengthSchooling() {
		return this.lengthSchooling;
	}


	public void setGender(String value) {
		this.gender = value;
	}
	public String getGender() {
		return this.gender;
	}


	public void setNation(String value) {
		this.nation = value;
	}
	public String getNation() {
		return this.nation;
	}


	public void setPoliticalOutlook(String value) {
		this.politicalOutlook = value;
	}
	public String getPoliticalOutlook() {
		return this.politicalOutlook;
	}


	public void setStudentPlace(String value) {
		this.studentPlace = value;
	}
	public String getStudentPlace() {
		return this.studentPlace;
	}


	public void setEnterpriseOwnership(String value) {
		this.enterpriseOwnership = value;
	}
	public String getEnterpriseOwnership() {
		return this.enterpriseOwnership;
	}


	public void setUnitName(String value) {
		this.unitName = value;
	}
	public String getUnitName() {
		return this.unitName;
	}


	public void setUnitAddress(String value) {
		this.unitAddress = value;
	}
	public String getUnitAddress() {
		return this.unitAddress;
	}


	public void setEnterpriseType(String value) {
		this.enterpriseType = value;
	}
	public String getEnterpriseType() {
		return this.enterpriseType;
	}


	public void setUnitProperties(String value) {
		this.unitProperties = value;
	}
	public String getUnitProperties() {
		return this.unitProperties;
	}


	public void setUnitIndustry(String value) {
		this.unitIndustry = value;
	}
	public String getUnitIndustry() {
		return this.unitIndustry;
	}


	public void setGrade(String value) {
		this.grade = value;
	}
	public String getGrade() {
		return this.grade;
	}


	public void setCreateTime(String value) {
		this.createTime = value;
	}
	public String getCreateTime() {
		return this.createTime;
	}


	public void setModifyTime(String value) {
		this.modifyTime = value;
	}
	public String getModifyTime() {
		return this.modifyTime;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("StudentNo",getStudentNo())
			.append("AcademyName",getAcademyName())
			.append("CollegeName",getCollegeName())
			.append("MajorName",getMajorName())
			.append("StudentName",getStudentName())
			.append("LengthSchooling",getLengthSchooling())
			.append("Gender",getGender())
			.append("Nation",getNation())
			.append("PoliticalOutlook",getPoliticalOutlook())
			.append("StudentPlace",getStudentPlace())
			.append("EnterpriseOwnership",getEnterpriseOwnership())
			.append("UnitName",getUnitName())
			.append("UnitAddress",getUnitAddress())
			.append("EnterpriseType",getEnterpriseType())
			.append("UnitProperties",getUnitProperties())
			.append("UnitIndustry",getUnitIndustry())
			.append("Grade",getGrade())
			.append("CreateTime",getCreateTime())
			.append("ModifyTime",getModifyTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentNo())
			.append(getAcademyName())
			.append(getCollegeName())
			.append(getMajorName())
			.append(getStudentName())
			.append(getLengthSchooling())
			.append(getGender())
			.append(getNation())
			.append(getPoliticalOutlook())
			.append(getStudentPlace())
			.append(getEnterpriseOwnership())
			.append(getUnitName())
			.append(getUnitAddress())
			.append(getEnterpriseType())
			.append(getUnitProperties())
			.append(getUnitIndustry())
			.append(getGrade())
			.append(getCreateTime())
			.append(getModifyTime())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StudentExcellentEmployment == false) return false;
		if(this == obj) return true;
		StudentExcellentEmployment other = (StudentExcellentEmployment)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentNo(),other.getStudentNo())
			.append(getAcademyName(),other.getAcademyName())
			.append(getCollegeName(),other.getCollegeName())
			.append(getMajorName(),other.getMajorName())
			.append(getStudentName(),other.getStudentName())
			.append(getLengthSchooling(),other.getLengthSchooling())
			.append(getGender(),other.getGender())
			.append(getNation(),other.getNation())
			.append(getPoliticalOutlook(),other.getPoliticalOutlook())
			.append(getStudentPlace(),other.getStudentPlace())
			.append(getEnterpriseOwnership(),other.getEnterpriseOwnership())
			.append(getUnitName(),other.getUnitName())
			.append(getUnitAddress(),other.getUnitAddress())
			.append(getEnterpriseType(),other.getEnterpriseType())
			.append(getUnitProperties(),other.getUnitProperties())
			.append(getUnitIndustry(),other.getUnitIndustry())
			.append(getGrade(),other.getGrade())
			.append(getCreateTime(),other.getCreateTime())
			.append(getModifyTime(),other.getModifyTime())
			.isEquals();
	}
}

