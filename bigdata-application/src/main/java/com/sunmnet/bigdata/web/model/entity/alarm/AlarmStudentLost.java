/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:57
 */
package com.sunmnet.bigdata.web.model.entity.alarm;

import com.sunmnet.bigdata.web.util.DateUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

import javax.persistence.Transient;
import java.util.Date;

/**
 * @author wdong
 * @version 1.0
 * @ClassName AlarmStudentLost
 * @Description
 * @date 2018-01-30 09:48:57
 */
public class AlarmStudentLost extends BaseModel {

	//alias
	public static final String FORMAT_DATE = "yyyy-MM-dd";
	public static final String TABLE_ALIAS = "AlarmStudentLost";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_LAST_DATE = "last_date";
	public static final String ALIAS_UPDATE_DATE = "update_date";
	public static final String ALIAS_WARNING_DATE = "warning_date";
	public static final String ALIAS_LOST_REASON = "lost_reason";
	public static final String ALIAS_REMARK = "remark";
	public static final String ALIAS_DEAL_FLAG = "deal_flag";
	public static final String ALIAS_DEAL_DATE = "deal_date";
	

	
	private String updateDate;
	private Date warningDate;
	private String lostReason;
	private String remark;
	private String dealFlag;
	private Date dealDate;

	public AlarmStudentLost(){
	}



	public void setUpdateDate(String value) {
		this.updateDate = value;
	}
	public String getUpdateDate() {
		return this.updateDate;
	}


	public void setWarningDate(Date value) {
		this.warningDate = value;
	}
	public Date getWarningDate() {
		return this.warningDate;
	}


	public void setLostReason(String value) {
		this.lostReason = value;
	}
	public String getLostReason() {
		return this.lostReason;
	}


	public void setRemark(String value) {
		this.remark = value;
	}
	public String getRemark() {
		return this.remark;
	}


	public void setDealFlag(String value) {
		this.dealFlag = value;
	}
	public String getDealFlag() {
		return this.dealFlag;
	}


	public void setDealDate(Date value) {
		this.dealDate = value;
	}
	public Date getDealDate() {
		return this.dealDate;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AlarmStudentLost == false) return false;
		if(this == obj) return true;
		AlarmStudentLost other = (AlarmStudentLost)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

