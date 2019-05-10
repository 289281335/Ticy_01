/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.model.entity.predict;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName PredictStudentLost
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class PredictStudentLost extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "PredictStudentLost";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_TIME_SPAN = "time_span";
	public static final String ALIAS_SINGLE_SPAN = "single_span";
	public static final String ALIAS_COST_COUNT = "cost_count";
	public static final String ALIAS_COST_SPAN = "cost_span";
	public static final String ALIAS_COST_TIME = "cost_time";
	

	
    //主键
	private Integer id;
    //学号
	private String studentNo;
    //临界时间跨度
	private String timeSpan;
    //临界累计消费人次跨度
	private String singleSpan;
    //消费次数
	private String costCount;
    //消费跨度
	private String costSpan;
    //消费时间顶
	private String costTime;

	public PredictStudentLost(){
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


	public void setTimeSpan(String value) {
		this.timeSpan = value;
	}
	public String getTimeSpan() {
		return this.timeSpan;
	}


	public void setSingleSpan(String value) {
		this.singleSpan = value;
	}
	public String getSingleSpan() {
		return this.singleSpan;
	}


	public void setCostCount(String value) {
		this.costCount = value;
	}
	public String getCostCount() {
		return this.costCount;
	}


	public void setCostSpan(String value) {
		this.costSpan = value;
	}
	public String getCostSpan() {
		return this.costSpan;
	}


	public void setCostTime(String value) {
		this.costTime = value;
	}
	public String getCostTime() {
		return this.costTime;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("StudentNo",getStudentNo())
			.append("TimeSpan",getTimeSpan())
			.append("SingleSpan",getSingleSpan())
			.append("CostCount",getCostCount())
			.append("CostSpan",getCostSpan())
			.append("CostTime",getCostTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentNo())
			.append(getTimeSpan())
			.append(getSingleSpan())
			.append(getCostCount())
			.append(getCostSpan())
			.append(getCostTime())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof PredictStudentLost == false) return false;
		if(this == obj) return true;
		PredictStudentLost other = (PredictStudentLost)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentNo(),other.getStudentNo())
			.append(getTimeSpan(),other.getTimeSpan())
			.append(getSingleSpan(),other.getSingleSpan())
			.append(getCostCount(),other.getCostCount())
			.append(getCostSpan(),other.getCostSpan())
			.append(getCostTime(),other.getCostTime())
			.isEquals();
	}
}

