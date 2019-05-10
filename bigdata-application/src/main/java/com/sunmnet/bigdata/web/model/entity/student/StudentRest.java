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
 * @ClassName StudentRest
 * @Description
 * @date 2018-01-30 09:48:59
 */
public class StudentRest extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StudentRest";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_SLEEP_TIME = "sleep_time";
	public static final String ALIAS_GETUP_TIME = "getup_time";
	

	
    //主键
	private Integer id;
    //学号
	private String studentNo;
    //睡觉时间
	private String sleepTime;
    //起床时间
	private String getupTime;

	public StudentRest(){
	}

	public void setId(Integer value) {
		this.id = value;
	}
	public Integer getId() {
		return this.id;
	}


	public void setStudentNo(String value) {
		this.studentNo = value;
	}
	public String getStudentNo() {
		return this.studentNo;
	}


	public void setSleepTime(String value) {
		this.sleepTime = value;
	}
	public String getSleepTime() {
		return this.sleepTime;
	}


	public void setGetupTime(String value) {
		this.getupTime = value;
	}
	public String getGetupTime() {
		return this.getupTime;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("StudentNo",getStudentNo())
			.append("SleepTime",getSleepTime())
			.append("GetupTime",getGetupTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentNo())
			.append(getSleepTime())
			.append(getGetupTime())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StudentRest == false) return false;
		if(this == obj) return true;
		StudentRest other = (StudentRest)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentNo(),other.getStudentNo())
			.append(getSleepTime(),other.getSleepTime())
			.append(getGetupTime(),other.getGetupTime())
			.isEquals();
	}
}

