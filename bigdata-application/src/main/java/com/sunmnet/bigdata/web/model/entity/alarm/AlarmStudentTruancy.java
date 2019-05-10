/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.model.entity.alarm;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName AlarmStudentTruancy
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class AlarmStudentTruancy extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "AlarmStudentTruancy";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_COLLECT_DATE = "collect_date";
	public static final String ALIAS_STUDENT_NAME = "student_name";
	public static final String ALIAS_COLLEGE_CODE = "college_code";
	public static final String ALIAS_COLLEGE_NAME = "college_name";
	public static final String ALIAS_MAJOR_CODE = "major_code";
	public static final String ALIAS_MAJOR_NAME = "major_name";
	public static final String ALIAS_GENDER = "gender";
	public static final String ALIAS_ACADEMY_NAME = "academy_name";
	public static final String ALIAS_CLASS_NAME = "class_name";
	public static final String ALIAS_NATION = "nation";
	public static final String ALIAS_STUDENT_PLACE = "student_place";
	public static final String ALIAS_WARNING_DATE = "warning_date";
	public static final String ALIAS_TRUANCY_TIMES = "truancy_times";
	public static final String ALIAS_DEAL_FLAG = "deal_flag";
	public static final String ALIAS_RESULT_WARNING = "result_warning";
	public static final String ALIAS_RESULT_COMMENT = "result_comment";
	public static final String ALIAS_WARNING_TYPE = "warning_type";
	public static final String ALIAS_DEAL_DATE = "deal_date";
	

	private String studentName;
	private String collegeCode;
	private String collegeName;
	private String majorCode;
	private String majorName;
	private String gender;
	private String academyName;
	private String className;
	private String nation;
	private String studentPlace;
	private String warningDate;
	private String truancyTimes;
	private String dealFlag;
	private String resultWarning;
	private String resultComment;
	private String warningType;
	private String dealDate;

	public AlarmStudentTruancy(){
	}



	public void setStudentName(String value) {
		this.studentName = value;
	}
	public String getStudentName() {
		return this.studentName;
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


	public void setGender(String value) {
		this.gender = value;
	}
	public String getGender() {
		return this.gender;
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


	public void setStudentPlace(String value) {
		this.studentPlace = value;
	}
	public String getStudentPlace() {
		return this.studentPlace;
	}


	public void setWarningDate(String value) {
		this.warningDate = value;
	}
	public String getWarningDate() {
		return this.warningDate;
	}


	public void setTruancyTimes(String value) {
		this.truancyTimes = value;
	}
	public String getTruancyTimes() {
		return this.truancyTimes;
	}


	public void setDealFlag(String value) {
		this.dealFlag = value;
	}
	public String getDealFlag() {
		return this.dealFlag;
	}


	public void setResultWarning(String value) {
		this.resultWarning = value;
	}
	public String getResultWarning() {
		return this.resultWarning;
	}


	public void setResultComment(String value) {
		this.resultComment = value;
	}
	public String getResultComment() {
		return this.resultComment;
	}


	public void setWarningType(String value) {
		this.warningType = value;
	}
	public String getWarningType() {
		return this.warningType;
	}


	public void setDealDate(String value) {
		this.dealDate = value;
	}
	public String getDealDate() {
		return this.dealDate;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AlarmStudentTruancy == false) return false;
		if(this == obj) return true;
		AlarmStudentTruancy other = (AlarmStudentTruancy)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

