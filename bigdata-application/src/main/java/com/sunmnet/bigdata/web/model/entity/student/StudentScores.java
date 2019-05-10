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
 * @ClassName StudentScores
 * @Description
 * @date 2018-01-30 09:48:59
 */
public class StudentScores extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StudentScores";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_STUDENT_NAME = "student_name";
	public static final String ALIAS_COURSE_TYPE = "course_type";
	public static final String ALIAS_CREDITS = "credits";
	public static final String ALIAS_COURSE_CODE = "course_code";
	public static final String ALIAS_COURSE_NAME = "course_name";
	public static final String ALIAS_COMMENT_GRADE = "comment_grade";
	public static final String ALIAS_CLASS_CODE = "class_code";
	public static final String ALIAS_SEMESTER = "semester";
	public static final String ALIAS_SCORE = "score";
	public static final String ALIAS_EXAMINATION_DATE = "examination_date";
	

	
    //学号
	private String studentNo;
    //姓名
	private String studentName;
    //课程类型
	private String courseType;
    //学分
	private String credits;
    //课程编号
	private String courseCode;
    //课程名称
	private String courseName;
    //课程评分
	private String commentGrade;
    //班级编号
	private String classCode;
    //考试学年学期
	private String semester;
    //考试成绩
	private String score;
    //考试日期
	private String examinationDate;

	public StudentScores(){
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


	public void setCourseType(String value) {
		this.courseType = value;
	}
	public String getCourseType() {
		return this.courseType;
	}


	public void setCredits(String value) {
		this.credits = value;
	}
	public String getCredits() {
		return this.credits;
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


	public void setCommentGrade(String value) {
		this.commentGrade = value;
	}
	public String getCommentGrade() {
		return this.commentGrade;
	}


	public void setClassCode(String value) {
		this.classCode = value;
	}
	public String getClassCode() {
		return this.classCode;
	}


	public void setSemester(String value) {
		this.semester = value;
	}
	public String getSemester() {
		return this.semester;
	}


	public void setScore(String value) {
		this.score = value;
	}
	public String getScore() {
		return this.score;
	}


	public void setExaminationDate(String value) {
		this.examinationDate = value;
	}
	public String getExaminationDate() {
		return this.examinationDate;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("StudentNo",getStudentNo())
			.append("StudentName",getStudentName())
			.append("CourseType",getCourseType())
			.append("Credits",getCredits())
			.append("CourseCode",getCourseCode())
			.append("CourseName",getCourseName())
			.append("CommentGrade",getCommentGrade())
			.append("ClassCode",getClassCode())
			.append("Semester",getSemester())
			.append("Score",getScore())
			.append("ExaminationDate",getExaminationDate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStudentNo())
			.append(getStudentName())
			.append(getCourseType())
			.append(getCredits())
			.append(getCourseCode())
			.append(getCourseName())
			.append(getCommentGrade())
			.append(getClassCode())
			.append(getSemester())
			.append(getScore())
			.append(getExaminationDate())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StudentScores == false) return false;
		if(this == obj) return true;
		StudentScores other = (StudentScores)obj;
		return new EqualsBuilder()
			.append(getStudentNo(),other.getStudentNo())
			.append(getStudentName(),other.getStudentName())
			.append(getCourseType(),other.getCourseType())
			.append(getCredits(),other.getCredits())
			.append(getCourseCode(),other.getCourseCode())
			.append(getCourseName(),other.getCourseName())
			.append(getCommentGrade(),other.getCommentGrade())
			.append(getClassCode(),other.getClassCode())
			.append(getSemester(),other.getSemester())
			.append(getScore(),other.getScore())
			.append(getExaminationDate(),other.getExaminationDate())
			.isEquals();
	}
}

