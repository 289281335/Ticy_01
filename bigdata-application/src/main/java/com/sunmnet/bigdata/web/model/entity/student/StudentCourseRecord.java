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
 * @ClassName StudentCourseRecord
 * @Description
 * @date 2018-01-30 09:48:59
 */
public class StudentCourseRecord extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StudentCourseRecord";
	public static final String ALIAS_STUDENT_NUMBER = "student_number";
	public static final String ALIAS_COURSE_TIME = "course_time";
	public static final String ALIAS_COURSE_CARD_TIME = "course_card_time";
	

	
    //
	private String StudentNo;
    //
	private String courseTime;
    //
	private String courseCardTime;

	public StudentCourseRecord(){
	}


	public void setStudentNo(String value) {
		this.StudentNo = value;
	}
	public String getStudentNo() {
		return this.StudentNo;
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
		if(obj instanceof StudentCourseRecord == false) return false;
		if(this == obj) return true;
		StudentCourseRecord other = (StudentCourseRecord)obj;
		return new EqualsBuilder()
			.append(getStudentNo(),other.getStudentNo())
			.append(getCourseTime(),other.getCourseTime())
			.append(getCourseCardTime(),other.getCourseCardTime())
			.isEquals();
	}
}

