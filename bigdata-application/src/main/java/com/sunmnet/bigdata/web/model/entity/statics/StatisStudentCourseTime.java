/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-31 10:45:21
 */
package com.sunmnet.bigdata.web.model.entity.statics;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StatisStudentCourseTime
 * @Description
 * @date 2018-01-31 10:45:21
 */
public class StatisStudentCourseTime extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StatisStudentCourseTime";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_COURSE_TIME = "course_time";
	public static final String ALIAS_COURSE_CARD_TIME = "course_card_time";
	

	
    //学生编号
	private String studentNo;
    //月份
	private String courseTime;
    //打卡时间差
	private String courseCardTime;

	public StatisStudentCourseTime(){
	}


	public void setStudentNo(String value) {
		this.studentNo = value;
	}
	public String getStudentNo() {
		return this.studentNo;
	}


	public void setCourseTime(String value) {
		this.courseTime = value;
	}
	public String getCourseTime() {
		return this.courseTime;
	}


	public void setCourseCardTime(String value) {
		this.courseCardTime = value;
	}
	public String getCourseCardTime() {
		return this.courseCardTime;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("StudentNo",getStudentNo())
			.append("CourseTime",getCourseTime())
			.append("CourseCardTime",getCourseCardTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStudentNo())
			.append(getCourseTime())
			.append(getCourseCardTime())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StatisStudentCourseTime == false) return false;
		if(this == obj) return true;
		StatisStudentCourseTime other = (StatisStudentCourseTime)obj;
		return new EqualsBuilder()
			.append(getStudentNo(),other.getStudentNo())
			.append(getCourseTime(),other.getCourseTime())
			.append(getCourseCardTime(),other.getCourseCardTime())
			.isEquals();
	}
}

