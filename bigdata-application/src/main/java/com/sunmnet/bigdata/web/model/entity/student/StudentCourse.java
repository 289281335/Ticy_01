/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.model.entity.student;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentCourse
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class StudentCourse extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StudentCourse";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_COURSE_NAME = "course_name";
	public static final String ALIAS_COURSE_DATE = "course_date";
	public static final String ALIAS_COURSE_STATUS = "course_status";
	

	
    //主键
	private Integer id;
    //学号
	private String studentNo;
    //课程名称
	private String courseName;
    //课程时间
	private String courseDate;
    //课程状态
	private String courseStatus;

	public StudentCourse(){
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


	public void setCourseName(String value) {
		this.courseName = value;
	}
	public String getCourseName() {
		return this.courseName;
	}


	public void setCourseDate(String value) {
		this.courseDate = value;
	}
	public String getCourseDate() {
		return this.courseDate;
	}


	public void setCourseStatus(String value) {
		this.courseStatus = value;
	}
	public String getCourseStatus() {
		return this.courseStatus;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("StudentNo",getStudentNo())
			.append("CourseName",getCourseName())
			.append("CourseDate",getCourseDate())
			.append("CourseStatus",getCourseStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentNo())
			.append(getCourseName())
			.append(getCourseDate())
			.append(getCourseStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StudentCourse == false) return false;
		if(this == obj) return true;
		StudentCourse other = (StudentCourse)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentNo(),other.getStudentNo())
			.append(getCourseName(),other.getCourseName())
			.append(getCourseDate(),other.getCourseDate())
			.append(getCourseStatus(),other.getCourseStatus())
			.isEquals();
	}
}

