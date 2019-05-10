/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.model.entity.basedata;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName DictCourse
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class DictCourse extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "DictCourse";
	public static final String ALIAS_COURSE_CODE = "course_code";
	public static final String ALIAS_COURSE_NAME = "course_name";
	public static final String ALIAS_CREDITS = "credits";
	

	
    //
	private String courseCode;
    //
	private String courseName;
    //
	private String credits;

	public DictCourse(){
	}


	public void setCourseCode(String value) {
		this.courseCode = value;
	}
	public String getCourseCode() {
		return this.courseCode;
	}


	public void setCourseName(String value) {
		this.courseName = value;
	}
	public String getCourseName() {
		return this.courseName;
	}


	public void setCredits(String value) {
		this.credits = value;
	}
	public String getCredits() {
		return this.credits;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("CourseCode",getCourseCode())
			.append("CourseName",getCourseName())
			.append("Credits",getCredits())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCourseCode())
			.append(getCourseName())
			.append(getCredits())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof DictCourse == false) return false;
		if(this == obj) return true;
		DictCourse other = (DictCourse)obj;
		return new EqualsBuilder()
			.append(getCourseCode(),other.getCourseCode())
			.append(getCourseName(),other.getCourseName())
			.append(getCredits(),other.getCredits())
			.isEquals();
	}
}

