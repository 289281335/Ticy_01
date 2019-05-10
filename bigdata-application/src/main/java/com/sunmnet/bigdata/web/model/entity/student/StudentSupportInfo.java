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
 * @ClassName StudentSupportInfo
 * @Description
 * @date 2018-01-30 09:48:59
 */
public class StudentSupportInfo extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StudentSupportInfo";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_STUDENT_NAME = "student_name";
	public static final String ALIAS_COLLEGE_NAME = "college_name";
	public static final String ALIAS_COLLEGE_CODE = "college_code";
	public static final String ALIAS_MAJOR_NAME = "major_name";
	public static final String ALIAS_MAJOR_CODE = "major_code";
	public static final String ALIAS_NATION = "nation";
	public static final String ALIAS_STUDENT_PLACE = "student_place";
	public static final String ALIAS_GENDER = "gender";
	public static final String ALIAS_SUPPORT_TYPE = "support_type";
	public static final String ALIAS_SUPPORT_AMOUNT = "support_amount";
	public static final String ALIAS_GRADE = "grade";
	public static final String ALIAS_SCHOOL_YEAR = "school_year";
	public static final String ALIAS_SCHOOL_TERM = "school_term";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_IS_FOCUS = "is_focus";
	public static final String ALIAS_REASON = "reason";
	

	
    //主键
	private Integer id;
    //学号
	private String studentNo;
    //学生姓名
	private String studentName;
    //学院名称
	private String collegeName;
    //学院代码
	private String collegeCode;
    //专业名称
	private String majorName;
    //专业代码
	private String majorCode;
    //民族
	private String nation;
    //生源地
	private String studentPlace;
    //性别
	private String gender;
    //资助类型
	private String supportType;
    //资助金额
	private Object supportAmount;
    //入学年级
	private Integer grade;
    //学年
	private String schoolYear;
    //学期
	private String schoolTerm;
    //在校状态
	private String status;
    //是否关注
	private String isFocus;
    //原因
	private String reason;

	public StudentSupportInfo(){
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


	public void setCollegeName(String value) {
		this.collegeName = value;
	}
	public String getCollegeName() {
		return this.collegeName;
	}


	public void setCollegeCode(String value) {
		this.collegeCode = value;
	}
	public String getCollegeCode() {
		return this.collegeCode;
	}


	public void setMajorName(String value) {
		this.majorName = value;
	}
	public String getMajorName() {
		return this.majorName;
	}


	public void setMajorCode(String value) {
		this.majorCode = value;
	}
	public String getMajorCode() {
		return this.majorCode;
	}


	public void setNation(String value) {
		this.nation = value;
	}
	public String getNation() {
		return this.nation;
	}


	public void setStudentPlace(String value) {
		this.studentPlace = value;
	}
	public String getStudentPlace() {
		return this.studentPlace;
	}


	public void setGender(String value) {
		this.gender = value;
	}
	public String getGender() {
		return this.gender;
	}


	public void setSupportType(String value) {
		this.supportType = value;
	}
	public String getSupportType() {
		return this.supportType;
	}


	public void setSupportAmount(Object value) {
		this.supportAmount = value;
	}
	public Object getSupportAmount() {
		return this.supportAmount;
	}


	public void setGrade(Integer value) {
		this.grade = value;
	}
	public Integer getGrade() {
		return this.grade;
	}


	public void setSchoolYear(String value) {
		this.schoolYear = value;
	}
	public String getSchoolYear() {
		return this.schoolYear;
	}


	public void setSchoolTerm(String value) {
		this.schoolTerm = value;
	}
	public String getSchoolTerm() {
		return this.schoolTerm;
	}


	public void setStatus(String value) {
		this.status = value;
	}
	public String getStatus() {
		return this.status;
	}


	public void setIsFocus(String value) {
		this.isFocus = value;
	}
	public String getIsFocus() {
		return this.isFocus;
	}


	public void setReason(String value) {
		this.reason = value;
	}
	public String getReason() {
		return this.reason;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("StudentNo",getStudentNo())
			.append("StudentName",getStudentName())
			.append("CollegeName",getCollegeName())
			.append("CollegeCode",getCollegeCode())
			.append("MajorName",getMajorName())
			.append("MajorCode",getMajorCode())
			.append("Nation",getNation())
			.append("StudentPlace",getStudentPlace())
			.append("Gender",getGender())
			.append("SupportType",getSupportType())
			.append("SupportAmount",getSupportAmount())
			.append("Grade",getGrade())
			.append("SchoolYear",getSchoolYear())
			.append("SchoolTerm",getSchoolTerm())
			.append("Status",getStatus())
			.append("IsFocus",getIsFocus())
			.append("Reason",getReason())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentNo())
			.append(getStudentName())
			.append(getCollegeName())
			.append(getCollegeCode())
			.append(getMajorName())
			.append(getMajorCode())
			.append(getNation())
			.append(getStudentPlace())
			.append(getGender())
			.append(getSupportType())
			.append(getSupportAmount())
			.append(getGrade())
			.append(getSchoolYear())
			.append(getSchoolTerm())
			.append(getStatus())
			.append(getIsFocus())
			.append(getReason())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StudentSupportInfo == false) return false;
		if(this == obj) return true;
		StudentSupportInfo other = (StudentSupportInfo)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentNo(),other.getStudentNo())
			.append(getStudentName(),other.getStudentName())
			.append(getCollegeName(),other.getCollegeName())
			.append(getCollegeCode(),other.getCollegeCode())
			.append(getMajorName(),other.getMajorName())
			.append(getMajorCode(),other.getMajorCode())
			.append(getNation(),other.getNation())
			.append(getStudentPlace(),other.getStudentPlace())
			.append(getGender(),other.getGender())
			.append(getSupportType(),other.getSupportType())
			.append(getSupportAmount(),other.getSupportAmount())
			.append(getGrade(),other.getGrade())
			.append(getSchoolYear(),other.getSchoolYear())
			.append(getSchoolTerm(),other.getSchoolTerm())
			.append(getStatus(),other.getStatus())
			.append(getIsFocus(),other.getIsFocus())
			.append(getReason(),other.getReason())
			.isEquals();
	}
}

