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
 * @ClassName StudentPosition
 * @Description
 * @date 2018-01-30 09:48:59
 */
public class StudentPosition extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StudentPosition";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_STUDENT_NAME = "student_name";
	public static final String ALIAS_MAJOR_NAME = "major_name";
	public static final String ALIAS_START_TIME = "start_time";
	public static final String ALIAS_END_TIME = "end_time";
	public static final String ALIAS_ORGNIZATION = "orgnization";
	public static final String ALIAS_POSITION_TYPE = "position_type";
	public static final String ALIAS_POZITION = "pozition";
	public static final String ALIAS_STATUS = "status";
	

	
    //
	private Integer id;
    //学号
	private String studentNo;
    //姓名
	private String studentName;
    //系名称
	private String majorName;
    //开始时间
	private String startTime;
    //结束时间
	private String endTime;
    //任职机构
	private String orgnization;
    //任职类别
	private String positionType;
    //任职职位
	private String pozition;
    //状态
	private String status;

	public StudentPosition(){
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


	public void setStartTime(String value) {
		this.startTime = value;
	}
	public String getStartTime() {
		return this.startTime;
	}


	public void setEndTime(String value) {
		this.endTime = value;
	}
	public String getEndTime() {
		return this.endTime;
	}


	public void setOrgnization(String value) {
		this.orgnization = value;
	}
	public String getOrgnization() {
		return this.orgnization;
	}


	public void setPositionType(String value) {
		this.positionType = value;
	}
	public String getPositionType() {
		return this.positionType;
	}


	public void setPozition(String value) {
		this.pozition = value;
	}
	public String getPozition() {
		return this.pozition;
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
			.append("StartTime",getStartTime())
			.append("EndTime",getEndTime())
			.append("Orgnization",getOrgnization())
			.append("PositionType",getPositionType())
			.append("Pozition",getPozition())
			.append("Status",getStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentNo())
			.append(getStudentName())
			.append(getMajorName())
			.append(getStartTime())
			.append(getEndTime())
			.append(getOrgnization())
			.append(getPositionType())
			.append(getPozition())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StudentPosition == false) return false;
		if(this == obj) return true;
		StudentPosition other = (StudentPosition)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentNo(),other.getStudentNo())
			.append(getStudentName(),other.getStudentName())
			.append(getMajorName(),other.getMajorName())
			.append(getStartTime(),other.getStartTime())
			.append(getEndTime(),other.getEndTime())
			.append(getOrgnization(),other.getOrgnization())
			.append(getPositionType(),other.getPositionType())
			.append(getPozition(),other.getPozition())
			.append(getStatus(),other.getStatus())
			.isEquals();
	}
}

