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
 * @ClassName StudentDormitory
 * @Description
 * @date 2018-01-30 09:48:59
 */
public class StudentDormitory extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StudentDormitory";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_DORMITORY = "dormitory";
	public static final String ALIAS_DORM_NAME = "dorm_name";
	public static final String ALIAS_BUILDING_CODE = "building_code";
	

	
    //学生宿舍关系id
	private Long id;
    //学号
	private String studentNo;
    //宿舍床位号
	private String dormitory;
    //宿舍名称
	private String dormName;
    //楼栋号
	private String buildingCode;

	public StudentDormitory(){
	}

	public void setId(Long value) {
		this.id = value;
	}
	public Long getId() {
		return this.id;
	}


	public void setStudentNo(String value) {
		this.studentNo = value;
	}
	public String getStudentNo() {
		return this.studentNo;
	}


	public void setDormitory(String value) {
		this.dormitory = value;
	}
	public String getDormitory() {
		return this.dormitory;
	}


	public void setDormName(String value) {
		this.dormName = value;
	}
	public String getDormName() {
		return this.dormName;
	}


	public void setBuildingCode(String value) {
		this.buildingCode = value;
	}
	public String getBuildingCode() {
		return this.buildingCode;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("StudentNo",getStudentNo())
			.append("Dormitory",getDormitory())
			.append("DormName",getDormName())
			.append("BuildingCode",getBuildingCode())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentNo())
			.append(getDormitory())
			.append(getDormName())
			.append(getBuildingCode())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StudentDormitory == false) return false;
		if(this == obj) return true;
		StudentDormitory other = (StudentDormitory)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentNo(),other.getStudentNo())
			.append(getDormitory(),other.getDormitory())
			.append(getDormName(),other.getDormName())
			.append(getBuildingCode(),other.getBuildingCode())
			.isEquals();
	}
}

