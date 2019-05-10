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
 * @ClassName StatisStudentScores
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class StatisStudentScores extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StatisStudentScores";
	public static final String ALIAS_EXAMINATION_COURSE_NAME = "examination_course_name";
	public static final String ALIAS_CREDITS = "credits";
	public static final String ALIAS_SEMESTER = "semester";
	public static final String ALIAS_AVERAGE_SCORES = "average_scores";
	

	
    //考试课程名称
	private String examinationCourseName;
    //学分
	private String credits;
    //考试学年学期代码
	private String semester;
    //平均成绩
	private String averageScores;

	public StatisStudentScores(){
	}


	public void setExaminationCourseName(String value) {
		this.examinationCourseName = value;
	}
	public String getExaminationCourseName() {
		return this.examinationCourseName;
	}


	public void setCredits(String value) {
		this.credits = value;
	}
	public String getCredits() {
		return this.credits;
	}


	public void setSemester(String value) {
		this.semester = value;
	}
	public String getSemester() {
		return this.semester;
	}


	public void setAverageScores(String value) {
		this.averageScores = value;
	}
	public String getAverageScores() {
		return this.averageScores;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("ExaminationCourseName",getExaminationCourseName())
			.append("Credits",getCredits())
			.append("Semester",getSemester())
			.append("AverageScores",getAverageScores())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getExaminationCourseName())
			.append(getCredits())
			.append(getSemester())
			.append(getAverageScores())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StatisStudentScores == false) return false;
		if(this == obj) return true;
		StatisStudentScores other = (StatisStudentScores)obj;
		return new EqualsBuilder()
			.append(getExaminationCourseName(),other.getExaminationCourseName())
			.append(getCredits(),other.getCredits())
			.append(getSemester(),other.getSemester())
			.append(getAverageScores(),other.getAverageScores())
			.isEquals();
	}
}

