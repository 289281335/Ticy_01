/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.model.entity.school;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName SchoolInfo
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class SchoolInfo extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "SchoolInfo";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_COLLEGE_NAME = "college_name";
	public static final String ALIAS_COLLEGE_CODE = "college_code";
	public static final String ALIAS_COLLEGE_ = "college_priority";
	public static final String ALIAS_MAJOR_NAME = "major_name";
	public static final String ALIAS_MAJOR_CODE = "major_code";
	public static final String ALIAS_MAJOR_PRIORITY = "major_priority";
	public static final String ALIAS_CLASS_NAME = "class_name";
	public static final String ALIAS_CLASS_PRIORITY = "class_priority";
	

	
    //主键
	private Integer id;
    //学院名称
	private String collegeName;
    //学院代码
	private String collegeCode;
    //学院排序
	private Integer collegePriority;
    //专业名称
	private String majorName;
    //专业代码
	private String majorCode;
    //专业排序
	private Integer majorPriority;
    //班级名称
	private String className;
    //班级排序
	private Integer classPriority;

	public SchoolInfo(){
	}

	public void setId(Integer value) {
		this.id = value;
	}
	public Integer getId() {
		return this.id;
	}


	public void setCollegeName(String value) {
		this.collegeName = value;
	}
	public String getCollegeName() {
		return this.collegeName;
	}


	public void setCollegeCode(String value) {
		this.collegeCode = value;
	}
	public String getCollegeCode() {
		return this.collegeCode;
	}


	public void setCollegePriority(Integer value) {
		this.collegePriority = value;
	}
	public Integer getCollegePriority() {
		return this.collegePriority;
	}


	public void setMajorName(String value) {
		this.majorName = value;
	}
	public String getMajorName() {
		return this.majorName;
	}


	public void setMajorCode(String value) {
		this.majorCode = value;
	}
	public String getMajorCode() {
		return this.majorCode;
	}


	public void setMajorPriority(Integer value) {
		this.majorPriority = value;
	}
	public Integer getMajorPriority() {
		return this.majorPriority;
	}


	public void setClassName(String value) {
		this.className = value;
	}
	public String getClassName() {
		return this.className;
	}


	public void setClassPriority(Integer value) {
		this.classPriority = value;
	}
	public Integer getClassPriority() {
		return this.classPriority;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("CollegeName",getCollegeName())
			.append("CollegeCode",getCollegeCode())
			.append("College",getCollegePriority())
			.append("MajorName",getMajorName())
			.append("MajorCode",getMajorCode())
			.append("MajorPriority",getMajorPriority())
			.append("ClassName",getClassName())
			.append("ClassPriority",getClassPriority())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCollegeName())
			.append(getCollegeCode())
			.append(getCollegePriority())
			.append(getMajorName())
			.append(getMajorCode())
			.append(getMajorPriority())
			.append(getClassName())
			.append(getClassPriority())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SchoolInfo == false) return false;
		if(this == obj) return true;
		SchoolInfo other = (SchoolInfo)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getCollegeName(),other.getCollegeName())
			.append(getCollegeCode(),other.getCollegeCode())
			.append(getCollegePriority(),other.getCollegePriority())
			.append(getMajorName(),other.getMajorName())
			.append(getMajorCode(),other.getMajorCode())
			.append(getMajorPriority(),other.getMajorPriority())
			.append(getClassName(),other.getClassName())
			.append(getClassPriority(),other.getClassPriority())
			.isEquals();
	}
}

