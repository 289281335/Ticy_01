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
 * @ClassName StudentConsumeStability
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class StudentConsumeStability extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StudentConsumeStability";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_STABILITY_FACTOR = "stability_factor";
	

	
    //主键
	private Integer id;
    //学号
	private String studentNo;
    //消费稳定系数
	private String stabilityFactor;

	public StudentConsumeStability(){
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


	public void setStabilityFactor(String value) {
		this.stabilityFactor = value;
	}
	public String getStabilityFactor() {
		return this.stabilityFactor;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("StudentNo",getStudentNo())
			.append("StabilityFactor",getStabilityFactor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentNo())
			.append(getStabilityFactor())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StudentConsumeStability == false) return false;
		if(this == obj) return true;
		StudentConsumeStability other = (StudentConsumeStability)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentNo(),other.getStudentNo())
			.append(getStabilityFactor(),other.getStabilityFactor())
			.isEquals();
	}
}

