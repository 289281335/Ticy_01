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
 * @ClassName StudentExtracurrCredits
 * @Description
 * @date 2018-01-30 09:48:59
 */
public class StudentExtracurrCredits extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StudentExtracurrCredits";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_STUDENT_NAME = "student_name";
	public static final String ALIAS_MAJOR_NAME = "major_name";
	public static final String ALIAS_ACADEMY_NAME = "academy_name";
	public static final String ALIAS_CREDIT = "credit";
	public static final String ALIAS_PROJECT_NAME = "project_name";
	public static final String ALIAS_RESULT = "result";
	public static final String ALIAS_STATUS = "status";
	

	
    //
	private Integer id;
    //学号
	private String studentNo;
    //姓名
	private String studentName;
    //专业名称
	private String majorName;
    //书院
	private String academyName;
    //学分
	private String credit;
    //项目名称
	private String projectName;
    //结果
	private String result;
    //状态
	private String status;

	public StudentExtracurrCredits(){
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


	public void setMajorName(String value) {
		this.majorName = value;
	}
	public String getMajorName() {
		return this.majorName;
	}


	public void setAcademyName(String value) {
		this.academyName = value;
	}
	public String getAcademyName() {
		return this.academyName;
	}


	public void setCredit(String value) {
		this.credit = value;
	}
	public String getCredit() {
		return this.credit;
	}


	public void setProjectName(String value) {
		this.projectName = value;
	}
	public String getProjectName() {
		return this.projectName;
	}


	public void setResult(String value) {
		this.result = value;
	}
	public String getResult() {
		return this.result;
	}


	public void setStatus(String value) {
		this.status = value;
	}
	public String getStatus() {
		return this.status;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("StudentNo",getStudentNo())
			.append("StudentName",getStudentName())
			.append("MajorName",getMajorName())
			.append("AcademyName",getAcademyName())
			.append("Credit",getCredit())
			.append("ProjectName",getProjectName())
			.append("Result",getResult())
			.append("Status",getStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentNo())
			.append(getStudentName())
			.append(getMajorName())
			.append(getAcademyName())
			.append(getCredit())
			.append(getProjectName())
			.append(getResult())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StudentExtracurrCredits == false) return false;
		if(this == obj) return true;
		StudentExtracurrCredits other = (StudentExtracurrCredits)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentNo(),other.getStudentNo())
			.append(getStudentName(),other.getStudentName())
			.append(getMajorName(),other.getMajorName())
			.append(getAcademyName(),other.getAcademyName())
			.append(getCredit(),other.getCredit())
			.append(getProjectName(),other.getProjectName())
			.append(getResult(),other.getResult())
			.append(getStatus(),other.getStatus())
			.isEquals();
	}
}

