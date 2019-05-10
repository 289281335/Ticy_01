/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.model.entity.statics;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StatisStudentCourse
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class StatisStudentCourse extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StatisStudentCourse";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_COURSE_DATE = "course_date";
	public static final String ALIAS_SCHOOL_TERM = "school_term";
	public static final String ALIAS_TRUANCY_TIMES = "truancy_times";
	public static final String ALIAS_NORMAL_TIMES = "normal_times";
	public static final String ALIAS_LATE_TIMES = "late_times";
	public static final String ALIAS_LEFT_TIMES = "left_times";
	


	private Integer truancyTimes;
	private Integer normalTimes;
	private Integer lateTimes;
	private Integer leftTimes;

	public StatisStudentCourse(){
	}


	public void setTruancyTimes(Integer value) {
		this.truancyTimes = value;
	}
	public Integer getTruancyTimes() {
		return this.truancyTimes;
	}


	public void setNormalTimes(Integer value) {
		this.normalTimes = value;
	}
	public Integer getNormalTimes() {
		return this.normalTimes;
	}


	public void setLateTimes(Integer value) {
		this.lateTimes = value;
	}
	public Integer getLateTimes() {
		return this.lateTimes;
	}


	public void setLeftTimes(Integer value) {
		this.leftTimes = value;
	}
	public Integer getLeftTimes() {
		return this.leftTimes;
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
		if(obj instanceof StatisStudentCourse == false) return false;
		if(this == obj) return true;
		StatisStudentCourse other = (StatisStudentCourse)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

