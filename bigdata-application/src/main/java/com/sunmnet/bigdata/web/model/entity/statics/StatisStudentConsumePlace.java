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
 * @ClassName StatisStudentConsumePlace
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class StatisStudentConsumePlace extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StatisStudentConsumePlace";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_STUDENT_NAME = "student_name";
	public static final String ALIAS_CONSUME_START_DATE = "consume_start_date";
	public static final String ALIAS_CONSUME_END_DATE = "consume_end_date";
	public static final String ALIAS_CONSUME_PLACE = "consume_place";
	public static final String ALIAS_CONSUME_WINDOW = "consume_window";
	public static final String ALIAS_CONSUME_TYPE = "consume_type";
	public static final String ALIAS_CONSUME_TIMES = "consume_times";
	public static final String ALIAS_CONSUME_AMOUNT = "consume_amount";
	

	
    //主键
	private Integer id;
    //学号
	private String studentNo;
    //姓名
	private String studentName;
    //消费开始时间
	private String consumeStartDate;
    //消费结束时间
	private String consumeEndDate;
    //消费地点
	private String consumePlace;
    //消费窗口
	private String consumeWindow;
    //消费类型
	private String consumeType;
    //消费次数
	private Integer consumeTimes;
    //消费金额
	private Long consumeAmount;

	public StatisStudentConsumePlace(){
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


	public void setConsumeStartDate(String value) {
		this.consumeStartDate = value;
	}
	public String getConsumeStartDate() {
		return this.consumeStartDate;
	}


	public void setConsumeEndDate(String value) {
		this.consumeEndDate = value;
	}
	public String getConsumeEndDate() {
		return this.consumeEndDate;
	}


	public void setConsumePlace(String value) {
		this.consumePlace = value;
	}
	public String getConsumePlace() {
		return this.consumePlace;
	}


	public void setConsumeWindow(String value) {
		this.consumeWindow = value;
	}
	public String getConsumeWindow() {
		return this.consumeWindow;
	}


	public void setConsumeType(String value) {
		this.consumeType = value;
	}
	public String getConsumeType() {
		return this.consumeType;
	}


	public void setConsumeTimes(Integer value) {
		this.consumeTimes = value;
	}
	public Integer getConsumeTimes() {
		return this.consumeTimes;
	}


	public void setConsumeAmount(Long value) {
		this.consumeAmount = value;
	}
	public Long getConsumeAmount() {
		return this.consumeAmount;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("StudentNo",getStudentNo())
			.append("StudentName",getStudentName())
			.append("ConsumeStartDate",getConsumeStartDate())
			.append("ConsumeEndDate",getConsumeEndDate())
			.append("ConsumePlace",getConsumePlace())
			.append("ConsumeWindow",getConsumeWindow())
			.append("ConsumeType",getConsumeType())
			.append("ConsumeTimes",getConsumeTimes())
			.append("ConsumeAmount",getConsumeAmount())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentNo())
			.append(getStudentName())
			.append(getConsumeStartDate())
			.append(getConsumeEndDate())
			.append(getConsumePlace())
			.append(getConsumeWindow())
			.append(getConsumeType())
			.append(getConsumeTimes())
			.append(getConsumeAmount())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StatisStudentConsumePlace == false) return false;
		if(this == obj) return true;
		StatisStudentConsumePlace other = (StatisStudentConsumePlace)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentNo(),other.getStudentNo())
			.append(getStudentName(),other.getStudentName())
			.append(getConsumeStartDate(),other.getConsumeStartDate())
			.append(getConsumeEndDate(),other.getConsumeEndDate())
			.append(getConsumePlace(),other.getConsumePlace())
			.append(getConsumeWindow(),other.getConsumeWindow())
			.append(getConsumeType(),other.getConsumeType())
			.append(getConsumeTimes(),other.getConsumeTimes())
			.append(getConsumeAmount(),other.getConsumeAmount())
			.isEquals();
	}
}

