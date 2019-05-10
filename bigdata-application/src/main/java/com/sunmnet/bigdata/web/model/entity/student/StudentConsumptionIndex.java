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

import java.math.BigDecimal;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentConsumptionIndex
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class StudentConsumptionIndex extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StudentConsumptionIndex";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_SCORE_INDEX = "score_index";
	public static final String ALIAS_DIET_INDEX = "diet_index";
	public static final String ALIAS_CONSUMPTION_INDEX = "consumption_index";
	public static final String ALIAS_WEEK_OUT_INDEX = "week_out_index";
	public static final String ALIAS_STATIS_CYCLE = "statis_cycle";
	

	
    //学号
	private String studentNo;
    //成绩指数
	private BigDecimal scoreIndex;
    //餐饮指数
	private BigDecimal dietIndex;
    //消费指数
	private BigDecimal consumptionIndex;
    //周末外出比例
	private BigDecimal weekOutIndex;
    //统计周期
	private String statisCycle;

	public StudentConsumptionIndex(){
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public BigDecimal getScoreIndex() {
		return scoreIndex;
	}

	public void setScoreIndex(BigDecimal scoreIndex) {
		this.scoreIndex = scoreIndex;
	}

	public BigDecimal getDietIndex() {
		return dietIndex;
	}

	public void setDietIndex(BigDecimal dietIndex) {
		this.dietIndex = dietIndex;
	}

	public BigDecimal getConsumptionIndex() {
		return consumptionIndex;
	}

	public void setConsumptionIndex(BigDecimal consumptionIndex) {
		this.consumptionIndex = consumptionIndex;
	}

	public BigDecimal getWeekOutIndex() {
		return weekOutIndex;
	}

	public void setWeekOutIndex(BigDecimal weekOutIndex) {
		this.weekOutIndex = weekOutIndex;
	}

	public String getStatisCycle() {
		return statisCycle;
	}

	public void setStatisCycle(String statisCycle) {
		this.statisCycle = statisCycle;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("StudentNo",getStudentNo())
			.append("ScoreIndex",getScoreIndex())
			.append("DietIndex",getDietIndex())
			.append("ConsumptionIndex",getConsumptionIndex())
			.append("WeekOutIndex",getWeekOutIndex())
			.append("StatisCycle",getStatisCycle())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStudentNo())
			.append(getScoreIndex())
			.append(getDietIndex())
			.append(getConsumptionIndex())
			.append(getWeekOutIndex())
			.append(getStatisCycle())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StudentConsumptionIndex == false) return false;
		if(this == obj) return true;
		StudentConsumptionIndex other = (StudentConsumptionIndex)obj;
		return new EqualsBuilder()
			.append(getStudentNo(),other.getStudentNo())
			.append(getScoreIndex(),other.getScoreIndex())
			.append(getDietIndex(),other.getDietIndex())
			.append(getConsumptionIndex(),other.getConsumptionIndex())
			.append(getWeekOutIndex(),other.getWeekOutIndex())
			.append(getStatisCycle(),other.getStatisCycle())
			.isEquals();
	}
}

