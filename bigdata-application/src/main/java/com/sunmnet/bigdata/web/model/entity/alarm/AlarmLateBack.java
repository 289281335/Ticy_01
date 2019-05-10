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
import java.util.Objects;

/**
 * @author wdong
 * @version 1.0
 * @ClassName AlarmLateBack
 * @Description
 * @date 2018-01-30 09:48:57
 */
public class AlarmLateBack extends BaseModel {

	//alias
	public static final String FORMAT_DEAL_DATE = "yyyy-MM-dd";
	public static final String TABLE_ALIAS = "AlarmLateBack";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_WARNING_TIME = "warning_time";
	public static final String ALIAS_WARNING_DATE = "warning_date";
	public static final String ALIAS_LATE_BACK_TIMES = "late_back_times";
	public static final String ALIAS_LATE_BACK_REASON = "late_back_reason";
	public static final String ALIAS_REMARK = "remark";
	public static final String ALIAS_DEAL_FLAG = "deal_flag";
	public static final String ALIAS_DEAL_DATE = "deal_date";
	


    private String warningDate;
    private Integer lateBackTimes;
    private String lateBackReason;
    private String remark;
    private String dealFlag;
    private Date dealDate;

	public AlarmLateBack(){
	}

    public String getWarningDate() {
        return warningDate;
    }

    public void setWarningDate(String warningDate) {
        this.warningDate = warningDate;
    }

    public Integer getLateBackTimes() {
        return lateBackTimes;
    }

    public void setLateBackTimes(Integer lateBackTimes) {
        this.lateBackTimes = lateBackTimes;
    }

    public String getLateBackReason() {
        return lateBackReason;
    }

    public void setLateBackReason(String lateBackReason) {
        this.lateBackReason = lateBackReason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDealFlag() {
        return dealFlag;
    }

    public void setDealFlag(String dealFlag) {
        this.dealFlag = dealFlag;
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlarmLateBack that = (AlarmLateBack) o;
        return Objects.equals(warningDate, that.warningDate) &&
                Objects.equals(lateBackTimes, that.lateBackTimes) &&
                Objects.equals(lateBackReason, that.lateBackReason) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(dealFlag, that.dealFlag) &&
                Objects.equals(dealDate, that.dealDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(warningDate, lateBackTimes, lateBackReason, remark, dealFlag, dealDate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .toString();
    }
}

