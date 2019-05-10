/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-19 09:55:56
 */
package com.sunmnet.bigdata.web.model.entity.alarm;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

import java.util.Date;

/**
 * @author wdong
 * @version 1.0
 * @ClassName AlarmStudent
 * @Description
 * @date 2018-01-19 09:55:56
 */
public class AlarmStudent extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "AlarmStudent";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_CODE = "student_code";
	public static final String ALIAS_TYPE = "type";
	public static final String ALIAS_KEY_VALUE = "key_value";
	public static final String ALIAS_DAY = "day";
	public static final String ALIAS_CREATE_TIME = "create_time";
	public static final String ALIAS_UPDATE_TIME = "update_time";
	public static final String ALIAS_FLAG = "flag";
	public static final String ALIAS_CYCLE_BEGIN = "cycle_begin";
	public static final String ALIAS_CYCLE_END = "cycle_end";
	public static final String ALIAS_STUDENT_NAME = "student_name";
	public static final String ALIAS_MAJOR_CODE = "major_code";
	public static final String ALIAS_MAJOR_NAME = "major_name";
	public static final String ALIAS_STUDENT_SEX = "student_sex";
	

	
    //
	private Long id;
    //学生学号
	private String studentCode;
    //1:一卡通预警，2:上网预警，3:夜归预警
	private Integer type;
    //统计值
	private Integer keyValue;
    //记录时间
	private Integer day;
    //创建时间
	private Date createTime;
    //更新时间
	private Date updateTime;
    //旗帜标志，0:没有旗帜，1:有旗帜
	private Integer flag;
    //预警周期开始时间
	private Date cycleBegin;
    //预警周期结束时间
	private Date cycleEnd;
    //学生姓名
	private String studentName;
    //专业代码
	private String majorCode;
    //专业名称
	private String majorName;
    //学生性别，1:男，2:女
	private String studentSex;

	public AlarmStudent(){
	}

	public void setId(Long value) {
		this.id = value;
	}
	public Long getId() {
		return this.id;
	}


	public void setStudentCode(String value) {
		this.studentCode = value;
	}
	public String getStudentCode() {
		return this.studentCode;
	}


	public void setType(Integer value) {
		this.type = value;
	}
	public Integer getType() {
		return this.type;
	}


	public void setKeyValue(Integer value) {
		this.keyValue = value;
	}
	public Integer getKeyValue() {
		return this.keyValue;
	}


	public void setDay(Integer value) {
		this.day = value;
	}
	public Integer getDay() {
		return this.day;
	}


	public void setStudentName(String value) {
		this.studentName = value;
	}
	public String getStudentName() {
		return this.studentName;
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


	public void setStudentSex(String value) {
		this.studentSex = value;
	}
	public String getStudentSex() {
		return this.studentSex;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Date getCycleBegin() {
		return cycleBegin;
	}

	public void setCycleBegin(Date cycleBegin) {
		this.cycleBegin = cycleBegin;
	}

	public Date getCycleEnd() {
		return cycleEnd;
	}

	public void setCycleEnd(Date cycleEnd) {
		this.cycleEnd = cycleEnd;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("StudentCode",getStudentCode())
			.append("Type",getType())
			.append("KeyValue",getKeyValue())
			.append("Day",getDay())
			.append("CreateTime",getCreateTime())
			.append("UpdateTime",getUpdateTime())
			.append("Flag",getFlag())
			.append("CycleBegin",getCycleBegin())
			.append("CycleEnd",getCycleEnd())
			.append("StudentName",getStudentName())
			.append("MajorCode",getMajorCode())
			.append("MajorName",getMajorName())
			.append("StudentSex",getStudentSex())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentCode())
			.append(getType())
			.append(getKeyValue())
			.append(getDay())
			.append(getCreateTime())
			.append(getUpdateTime())
			.append(getFlag())
			.append(getCycleBegin())
			.append(getCycleEnd())
			.append(getStudentName())
			.append(getMajorCode())
			.append(getMajorName())
			.append(getStudentSex())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AlarmStudent == false) return false;
		if(this == obj) return true;
		AlarmStudent other = (AlarmStudent)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentCode(),other.getStudentCode())
			.append(getType(),other.getType())
			.append(getKeyValue(),other.getKeyValue())
			.append(getDay(),other.getDay())
			.append(getCreateTime(),other.getCreateTime())
			.append(getUpdateTime(),other.getUpdateTime())
			.append(getFlag(),other.getFlag())
			.append(getCycleBegin(),other.getCycleBegin())
			.append(getCycleEnd(),other.getCycleEnd())
			.append(getStudentName(),other.getStudentName())
			.append(getMajorCode(),other.getMajorCode())
			.append(getMajorName(),other.getMajorName())
			.append(getStudentSex(),other.getStudentSex())
			.isEquals();
	}
}

