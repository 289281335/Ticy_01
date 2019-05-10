/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.model.entity.behavior;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName BehaviorStudentTraces
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class BehaviorStudentTraces extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "BehaviorStudentTraces";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_CARD_DATE = "card_date";
	public static final String ALIAS_CARD_PLACE = "card_place";
	public static final String ALIAS_CARD_BEHAVIOR = "card_behavior";
	public static final String ALIAS_COURSE_NAME = "course_name";
	public static final String ALIAS_COURSE_START_DATE = "course_start_date";
	public static final String ALIAS_COURSE_END_DATE = "course_end_date";
	

	
    //主键
	private Integer id;
    //学号
	private String studentNo;
    //刷卡时间
	private String cardDate;
    //刷卡地点
	private String cardPlace;
    //刷卡行为
	private String cardBehavior;
    //课程名称
	private String courseName;
    //课程开始时间
	private String courseStartDate;
    //课程结束时间
	private String courseEndDate;

	public BehaviorStudentTraces(){
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


	public void setCardDate(String value) {
		this.cardDate = value;
	}
	public String getCardDate() {
		return this.cardDate;
	}


	public void setCardPlace(String value) {
		this.cardPlace = value;
	}
	public String getCardPlace() {
		return this.cardPlace;
	}


	public void setCardBehavior(String value) {
		this.cardBehavior = value;
	}
	public String getCardBehavior() {
		return this.cardBehavior;
	}


	public void setCourseName(String value) {
		this.courseName = value;
	}
	public String getCourseName() {
		return this.courseName;
	}


	public void setCourseStartDate(String value) {
		this.courseStartDate = value;
	}
	public String getCourseStartDate() {
		return this.courseStartDate;
	}


	public void setCourseEndDate(String value) {
		this.courseEndDate = value;
	}
	public String getCourseEndDate() {
		return this.courseEndDate;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("StudentNo",getStudentNo())
			.append("CardDate",getCardDate())
			.append("CardPlace",getCardPlace())
			.append("CardBehavior",getCardBehavior())
			.append("CourseName",getCourseName())
			.append("CourseStartDate",getCourseStartDate())
			.append("CourseEndDate",getCourseEndDate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentNo())
			.append(getCardDate())
			.append(getCardPlace())
			.append(getCardBehavior())
			.append(getCourseName())
			.append(getCourseStartDate())
			.append(getCourseEndDate())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BehaviorStudentTraces == false) return false;
		if(this == obj) return true;
		BehaviorStudentTraces other = (BehaviorStudentTraces)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentNo(),other.getStudentNo())
			.append(getCardDate(),other.getCardDate())
			.append(getCardPlace(),other.getCardPlace())
			.append(getCardBehavior(),other.getCardBehavior())
			.append(getCourseName(),other.getCourseName())
			.append(getCourseStartDate(),other.getCourseStartDate())
			.append(getCourseEndDate(),other.getCourseEndDate())
			.isEquals();
	}
}

