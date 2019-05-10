/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.model.entity.portrait;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName PortraitStudentConsume
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class PortraitStudentConsume extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "PortraitStudentConsume";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_COLLEGE_CODE = "college_code";
	public static final String ALIAS_COLLEGE_NAME = "college_name";
	public static final String ALIAS_MAJOR_CODE = "major_code";
	public static final String ALIAS_MAJOR_NAME = "major_name";
	public static final String ALIAS_ACADEMY_NAME = "academy_name";
	public static final String ALIAS_CLASS_NAME = "class_name";
	public static final String ALIAS_NATION = "nation";
	public static final String ALIAS_GENDER = "gender";
	public static final String ALIAS_STUDENT_PLACE = "student_place";
	public static final String ALIAS_CONSUME_START_DATE = "consume_start_date";
	public static final String ALIAS_CONSUME_END_DATE = "consume_end_date";
	public static final String ALIAS_CONSUME_WINDOW = "consume_window";
	public static final String ALIAS_CONSUME_TIMES = "consume_times";
	public static final String ALIAS_CONSUME_AMOUNT = "consume_amount";
	

	
    //主键
	private Integer id;
    //学院代码
	private String collegeCode;
    //学院名称
	private String collegeName;
    //专业代码
	private String majorCode;
    //专业名称
	private String majorName;
    //书院名称
	private String academyName;
    //班级名称
	private String className;
    //民族
	private String nation;
    //性别
	private String gender;
    //生源地
	private String studentPlace;
    //消费开始时间
	private String consumeStartDate;
    //消费截止时间
	private String consumeEndDate;
    //消费窗口
	private String consumeWindow;
    //消费次数
	private String consumeTimes;
    //消费金额
	private Long consumeAmount;

	public PortraitStudentConsume(){
	}

	public void setId(Integer value) {
		this.id = value;
	}
	public Integer getId() {
		return this.id;
	}


	public void setCollegeCode(String value) {
		this.collegeCode = value;
	}
	public String getCollegeCode() {
		return this.collegeCode;
	}


	public void setCollegeName(String value) {
		this.collegeName = value;
	}
	public String getCollegeName() {
		return this.collegeName;
	}


	public void setMajorCode(String value) {
		this.majorCode = value;
	}
	public String getMajorCode() {
		return this.majorCode;
	}


	public void setMajorName(String value) {
		this.majorName = value;
	}
	public String getMajorName() {
		return this.majorName;
	}


	public void setAcademyName(String value) {
		this.academyName = value;
	}
	public String getAcademyName() {
		return this.academyName;
	}


	public void setClassName(String value) {
		this.className = value;
	}
	public String getClassName() {
		return this.className;
	}


	public void setNation(String value) {
		this.nation = value;
	}
	public String getNation() {
		return this.nation;
	}


	public void setGender(String value) {
		this.gender = value;
	}
	public String getGender() {
		return this.gender;
	}


	public void setStudentPlace(String value) {
		this.studentPlace = value;
	}
	public String getStudentPlace() {
		return this.studentPlace;
	}


	public void setConsumeStartDate(String value) {
		this.consumeStartDate = value;
	}
	public String getConsumeStartDate() {
		return this.consumeStartDate;
	}


	public void setConsumeEndDate(String value) {
		this.consumeEndDate = value;
	}
	public String getConsumeEndDate() {
		return this.consumeEndDate;
	}


	public void setConsumeWindow(String value) {
		this.consumeWindow = value;
	}
	public String getConsumeWindow() {
		return this.consumeWindow;
	}


	public void setConsumeTimes(String value) {
		this.consumeTimes = value;
	}
	public String getConsumeTimes() {
		return this.consumeTimes;
	}


	public void setConsumeAmount(Long value) {
		this.consumeAmount = value;
	}
	public Long getConsumeAmount() {
		return this.consumeAmount;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("CollegeCode",getCollegeCode())
			.append("CollegeName",getCollegeName())
			.append("MajorCode",getMajorCode())
			.append("MajorName",getMajorName())
			.append("AcademyName",getAcademyName())
			.append("ClassName",getClassName())
			.append("Nation",getNation())
			.append("Gender",getGender())
			.append("StudentPlace",getStudentPlace())
			.append("ConsumeStartDate",getConsumeStartDate())
			.append("ConsumeEndDate",getConsumeEndDate())
			.append("ConsumeWindow",getConsumeWindow())
			.append("ConsumeTimes",getConsumeTimes())
			.append("ConsumeAmount",getConsumeAmount())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCollegeCode())
			.append(getCollegeName())
			.append(getMajorCode())
			.append(getMajorName())
			.append(getAcademyName())
			.append(getClassName())
			.append(getNation())
			.append(getGender())
			.append(getStudentPlace())
			.append(getConsumeStartDate())
			.append(getConsumeEndDate())
			.append(getConsumeWindow())
			.append(getConsumeTimes())
			.append(getConsumeAmount())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof PortraitStudentConsume == false) return false;
		if(this == obj) return true;
		PortraitStudentConsume other = (PortraitStudentConsume)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getCollegeCode(),other.getCollegeCode())
			.append(getCollegeName(),other.getCollegeName())
			.append(getMajorCode(),other.getMajorCode())
			.append(getMajorName(),other.getMajorName())
			.append(getAcademyName(),other.getAcademyName())
			.append(getClassName(),other.getClassName())
			.append(getNation(),other.getNation())
			.append(getGender(),other.getGender())
			.append(getStudentPlace(),other.getStudentPlace())
			.append(getConsumeStartDate(),other.getConsumeStartDate())
			.append(getConsumeEndDate(),other.getConsumeEndDate())
			.append(getConsumeWindow(),other.getConsumeWindow())
			.append(getConsumeTimes(),other.getConsumeTimes())
			.append(getConsumeAmount(),other.getConsumeAmount())
			.isEquals();
	}
}

