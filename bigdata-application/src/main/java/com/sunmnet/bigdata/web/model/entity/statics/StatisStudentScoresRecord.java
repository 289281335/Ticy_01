/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-02-07 09:39:11
 */
package com.sunmnet.bigdata.web.model.entity.statics;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StatisStudentScoresRecord
 * @Description
 * @date 2018-02-07 09:39:11
 */
public class StatisStudentScoresRecord extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StatisStudentScoresRecord";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_STUDENT_NAME = "student_name";
	public static final String ALIAS_COLLEGE_CODE = "college_code";
	public static final String ALIAS_MAJOR_CODE = "major_code";
	public static final String ALIAS_SEMESTER = "semester";
	public static final String ALIAS_AVERAGE_SCORE = "average_score";
	public static final String ALIAS_FAIL_TIMES = "fail_times";
	

	
    //主键
	private Integer id;
    //学号
	private String studentNo;
    //学生姓名
	private String studentName;
    //学院代码
	private String collegeCode;
    //专业代码
	private String majorCode;
    //学期
	private String semester;
    //平均成绩
	private Object averageScore;
    //失败次数
	private Integer failTimes;

	public StatisStudentScoresRecord(){
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


	public void setMajorCode(String value) {
		this.majorCode = value;
	}
	public String getMajorCode() {
		return this.majorCode;
	}


	public void setSemester(String value) {
		this.semester = value;
	}
	public String getSemester() {
		return this.semester;
	}


	public void setAverageScore(Object value) {
		this.averageScore = value;
	}
	public Object getAverageScore() {
		return this.averageScore;
	}


	public void setFailTimes(Integer value) {
		this.failTimes = value;
	}
	public Integer getFailTimes() {
		return this.failTimes;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("StudentNo",getStudentNo())
			.append("StudentName",getStudentName())
			.append("CollegeCode",getCollegeCode())
			.append("MajorCode",getMajorCode())
			.append("Semester",getSemester())
			.append("AverageScore",getAverageScore())
			.append("FailTimes",getFailTimes())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentNo())
			.append(getStudentName())
			.append(getCollegeCode())
			.append(getMajorCode())
			.append(getSemester())
			.append(getAverageScore())
			.append(getFailTimes())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StatisStudentScoresRecord == false) return false;
		if(this == obj) return true;
		StatisStudentScoresRecord other = (StatisStudentScoresRecord)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentNo(),other.getStudentNo())
			.append(getStudentName(),other.getStudentName())
			.append(getCollegeCode(),other.getCollegeCode())
			.append(getMajorCode(),other.getMajorCode())
			.append(getSemester(),other.getSemester())
			.append(getAverageScore(),other.getAverageScore())
			.append(getFailTimes(),other.getFailTimes())
			.isEquals();
	}
}

