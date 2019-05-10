/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.model.entity.predict;

import io.swagger.models.auth.In;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName PredictSuspectedStudent
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class PredictSuspectedStudent extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "PredictSuspectedStudent";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_POVERTY_LEVEL = "poverty_level";
	public static final String ALIAS_ANY_RESULT = "any_result";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_CATEGORY = "category";


	
    //学号
	private String studentNo;
    //贫困等级
	private String povertyLevel;
    //预测结果
	private String anyResult;
    //
	private String status;
	//分类1疑似贫困，2特别贫困
	private Integer category;

	public PredictSuspectedStudent(){
	}


	public void setStudentNo(String value) {
		this.studentNo = value;
	}
	public String getStudentNo() {
		return this.studentNo;
	}


	public void setPovertyLevel(String value) {
		this.povertyLevel = value;
	}
	public String getPovertyLevel() {
		return this.povertyLevel;
	}


	public void setAnyResult(String value) {
		this.anyResult = value;
	}
	public String getAnyResult() {
		return this.anyResult;
	}


	public void setStatus(String value) {
		this.status = value;
	}
	public String getStatus() {
		return this.status;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("StudentNo",getStudentNo())
			.append("PovertyLevel",getPovertyLevel())
			.append("AnyResult",getAnyResult())
			.append("Status",getStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStudentNo())
			.append(getPovertyLevel())
			.append(getAnyResult())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof PredictSuspectedStudent == false) return false;
		if(this == obj) return true;
		PredictSuspectedStudent other = (PredictSuspectedStudent)obj;
		return new EqualsBuilder()
			.append(getStudentNo(),other.getStudentNo())
			.append(getPovertyLevel(),other.getPovertyLevel())
			.append(getAnyResult(),other.getAnyResult())
			.append(getStatus(),other.getStatus())
			.isEquals();
	}
}

