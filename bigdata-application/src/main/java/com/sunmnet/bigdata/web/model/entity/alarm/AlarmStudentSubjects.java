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
 * @ClassName AlarmStudentSubjects
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class AlarmStudentSubjects extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "AlarmStudentSubjects";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_SUBJECTS_COUNT = "subjects_count";
	public static final String ALIAS_DEAL_FLAG = "deal_flag";
	public static final String ALIAS_ALARM_CONTENT = "alarm_content";
	public static final String ALIAS_ALARM_TYPE = "alarm_type";
	public static final String ALIAS_ALARM_DATE = "alarm_date";
	public static final String ALIAS_DEAL_RESULT = "deal_result";
	public static final String ALIAS_DEAL_DATE = "deal_date";
	


	private String subjectsCount;
	private String dealFlag;
	private String alarmContent;
	private String alarmType;
	private String dealResult;
	private String dealDate;

	public AlarmStudentSubjects(){
	}



	public void setSubjectsCount(String value) {
		this.subjectsCount = value;
	}
	public String getSubjectsCount() {
		return this.subjectsCount;
	}


	public void setDealFlag(String value) {
		this.dealFlag = value;
	}
	public String getDealFlag() {
		return this.dealFlag;
	}


	public void setAlarmContent(String value) {
		this.alarmContent = value;
	}
	public String getAlarmContent() {
		return this.alarmContent;
	}


	public void setAlarmType(String value) {
		this.alarmType = value;
	}
	public String getAlarmType() {
		return this.alarmType;
	}


	public void setDealResult(String value) {
		this.dealResult = value;
	}
	public String getDealResult() {
		return this.dealResult;
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
		if(obj instanceof AlarmStudentSubjects == false) return false;
		if(this == obj) return true;
		AlarmStudentSubjects other = (AlarmStudentSubjects)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

