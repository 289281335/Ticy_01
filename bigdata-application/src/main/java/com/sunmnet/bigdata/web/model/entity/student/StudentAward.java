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
 * @ClassName StudentAward
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class StudentAward extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StudentAward";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_STUDENT_NAME = "student_name";
	public static final String ALIAS_AWARD_CATEGORY = "award_category";
	public static final String ALIAS_AWARD_LEVEL = "award_level";
	public static final String ALIAS_AWARD_TIME = "award_time";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_AUDIT_ADVICE = "audit_advice";
	public static final String ALIAS_MAJOR_CODE = "major_code";
	public static final String ALIAS_MAJOR_NAME = "major_name";
	

	
    //获奖id
	private Integer id;
    //学号
	private String studentNo;
    //姓名
	private String studentName;
    //类别
	private String awardCategory;
    //级别
	private String awardLevel;
    //时间
	private String awardTime;
    //状态
	private String status;
    //审核意见
	private String auditAdvice;
    //专业代码
	private String majorCode;
    //专业名称
	private String majorName;

	public StudentAward(){
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


	public void setAwardCategory(String value) {
		this.awardCategory = value;
	}
	public String getAwardCategory() {
		return this.awardCategory;
	}


	public void setAwardLevel(String value) {
		this.awardLevel = value;
	}
	public String getAwardLevel() {
		return this.awardLevel;
	}


	public void setAwardTime(String value) {
		this.awardTime = value;
	}
	public String getAwardTime() {
		return this.awardTime;
	}


	public void setStatus(String value) {
		this.status = value;
	}
	public String getStatus() {
		return this.status;
	}


	public void setAuditAdvice(String value) {
		this.auditAdvice = value;
	}
	public String getAuditAdvice() {
		return this.auditAdvice;
	}


	public void setMajorCode(String value) {
		this.majorCode = value;
	}
	public String getMajorCode() {
		return this.majorCode;
	}


	public void setMajorName(String value) {
		this.majorName = value;
	}
	public String getMajorName() {
		return this.majorName;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("StudentNo",getStudentNo())
			.append("StudentName",getStudentName())
			.append("AwardCategory",getAwardCategory())
			.append("AwardLevel",getAwardLevel())
			.append("AwardTime",getAwardTime())
			.append("Status",getStatus())
			.append("AuditAdvice",getAuditAdvice())
			.append("MajorCode",getMajorCode())
			.append("MajorName",getMajorName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentNo())
			.append(getStudentName())
			.append(getAwardCategory())
			.append(getAwardLevel())
			.append(getAwardTime())
			.append(getStatus())
			.append(getAuditAdvice())
			.append(getMajorCode())
			.append(getMajorName())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StudentAward == false) return false;
		if(this == obj) return true;
		StudentAward other = (StudentAward)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentNo(),other.getStudentNo())
			.append(getStudentName(),other.getStudentName())
			.append(getAwardCategory(),other.getAwardCategory())
			.append(getAwardLevel(),other.getAwardLevel())
			.append(getAwardTime(),other.getAwardTime())
			.append(getStatus(),other.getStatus())
			.append(getAuditAdvice(),other.getAuditAdvice())
			.append(getMajorCode(),other.getMajorCode())
			.append(getMajorName(),other.getMajorName())
			.isEquals();
	}
}

