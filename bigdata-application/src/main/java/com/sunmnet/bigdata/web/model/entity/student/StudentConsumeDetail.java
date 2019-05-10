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
 * @ClassName StudentConsumeDetail
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class StudentConsumeDetail extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StudentConsumeDetail";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_STUDENT_NAME = "student_name";
	public static final String ALIAS_CONSUME_TIME = "consume_time";
	public static final String ALIAS_CONSUME_TYPE = "consume_type";
	public static final String ALIAS_AMOUNT = "amount";
	public static final String ALIAS_REMAINING_AMOUNT = "remaining_amount";
	public static final String ALIAS_MERCHANTS = "merchants";
	public static final String ALIAS_POS_NO = "pos_no";
	public static final String ALIAS_MERCHANTS_PLACE = "merchants_place";
	

	
    //
	private Integer id;
    //学号
	private String studentNo;
    //姓名
	private String studentName;
    //消费时间
	private String consumeTime;
    //数据类型
	private String consumeType;
    //交易额
	private Object amount;
    //卡内余额
	private Object remainingAmount;
    //商户
	private String merchants;
    //POS编号
	private String posNo;
    //商户位置
	private String merchantsPlace;

	public StudentConsumeDetail(){
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


	public void setConsumeTime(String value) {
		this.consumeTime = value;
	}
	public String getConsumeTime() {
		return this.consumeTime;
	}


	public void setConsumeType(String value) {
		this.consumeType = value;
	}
	public String getConsumeType() {
		return this.consumeType;
	}


	public void setAmount(Object value) {
		this.amount = value;
	}
	public Object getAmount() {
		return this.amount;
	}


	public void setRemainingAmount(Object value) {
		this.remainingAmount = value;
	}
	public Object getRemainingAmount() {
		return this.remainingAmount;
	}


	public void setMerchants(String value) {
		this.merchants = value;
	}
	public String getMerchants() {
		return this.merchants;
	}


	public void setPosNo(String value) {
		this.posNo = value;
	}
	public String getPosNo() {
		return this.posNo;
	}


	public void setMerchantsPlace(String value) {
		this.merchantsPlace = value;
	}
	public String getMerchantsPlace() {
		return this.merchantsPlace;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("StudentNo",getStudentNo())
			.append("StudentName",getStudentName())
			.append("ConsumeTime",getConsumeTime())
			.append("ConsumeType",getConsumeType())
			.append("Amount",getAmount())
			.append("RemainingAmount",getRemainingAmount())
			.append("Merchants",getMerchants())
			.append("PosNo",getPosNo())
			.append("MerchantsPlace",getMerchantsPlace())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentNo())
			.append(getStudentName())
			.append(getConsumeTime())
			.append(getConsumeType())
			.append(getAmount())
			.append(getRemainingAmount())
			.append(getMerchants())
			.append(getPosNo())
			.append(getMerchantsPlace())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StudentConsumeDetail == false) return false;
		if(this == obj) return true;
		StudentConsumeDetail other = (StudentConsumeDetail)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentNo(),other.getStudentNo())
			.append(getStudentName(),other.getStudentName())
			.append(getConsumeTime(),other.getConsumeTime())
			.append(getConsumeType(),other.getConsumeType())
			.append(getAmount(),other.getAmount())
			.append(getRemainingAmount(),other.getRemainingAmount())
			.append(getMerchants(),other.getMerchants())
			.append(getPosNo(),other.getPosNo())
			.append(getMerchantsPlace(),other.getMerchantsPlace())
			.isEquals();
	}
}

