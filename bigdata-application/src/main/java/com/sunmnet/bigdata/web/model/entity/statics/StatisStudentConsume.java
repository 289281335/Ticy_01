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
 * @ClassName StatisStudentConsume
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class StatisStudentConsume extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StatisStudentConsume";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_STUDENT_NAME = "student_name";
	public static final String ALIAS_GENDER = "gender";
	public static final String ALIAS_CONSUME_DATE = "consume_date";
	public static final String ALIAS_BREAKFAST_AMOUNT = "breakfast_amount";
	public static final String ALIAS_BREAKFAST_TIMES = "breakfast_times";
	public static final String ALIAS_LUNCH_AMOUNT = "lunch_amount";
	public static final String ALIAS_LUNCH_TIMES = "lunch_times";
	public static final String ALIAS_DINNER_AMOUNT = "dinner_amount";
	public static final String ALIAS_DINNER_TIMES = "dinner_times";
	public static final String ALIAS_SUPPER_AMOUNT = "supper_amount";
	public static final String ALIAS_SUPPER_TIMES = "supper_times";
	public static final String ALIAS_FRUIT_AMOUNT = "fruit_amount";
	public static final String ALIAS_FRUIT_TIMES = "fruit_times";
	public static final String ALIAS_INTERNET_AMOUNT = "internet_amount";
	public static final String ALIAS_MARKET_AMOUNT = "market_amount";
	public static final String ALIAS_BATH_AMOUNT = "bath_amount";
	public static final String ALIAS_BOOK_AMOUNT = "book_amount";
	public static final String ALIAS_HOSPITAL_AMOUNT = "hospital_amount";
	public static final String ALIAS_OTHER_AMOUNT = "other_amount";
	


	private String studentName;
	private String gender;
	private Long breakfastAmount;
	private Integer breakfastTimes;
	private Long lunchAmount;
	private Integer lunchTimes;
	private Long dinnerAmount;
	private Integer dinnerTimes;
	private Long supperAmount;
	private Integer supperTimes;
	private Long fruitAmount;
	private Integer fruitTimes;
	private Long internetAmount;
	private Long marketAmount;
	private Long bathAmount;
	private Long bookAmount;
	private Long hospitalAmount;
	private Long otherAmount;

	public StatisStudentConsume(){
	}



	public void setStudentName(String value) {
		this.studentName = value;
	}
	public String getStudentName() {
		return this.studentName;
	}


	public void setGender(String value) {
		this.gender = value;
	}
	public String getGender() {
		return this.gender;
	}


	public void setBreakfastAmount(Long value) {
		this.breakfastAmount = value;
	}
	public Long getBreakfastAmount() {
		return this.breakfastAmount;
	}


	public void setBreakfastTimes(Integer value) {
		this.breakfastTimes = value;
	}
	public Integer getBreakfastTimes() {
		return this.breakfastTimes;
	}


	public void setLunchAmount(Long value) {
		this.lunchAmount = value;
	}
	public Long getLunchAmount() {
		return this.lunchAmount;
	}


	public void setLunchTimes(Integer value) {
		this.lunchTimes = value;
	}
	public Integer getLunchTimes() {
		return this.lunchTimes;
	}


	public void setDinnerAmount(Long value) {
		this.dinnerAmount = value;
	}
	public Long getDinnerAmount() {
		return this.dinnerAmount;
	}


	public void setDinnerTimes(Integer value) {
		this.dinnerTimes = value;
	}
	public Integer getDinnerTimes() {
		return this.dinnerTimes;
	}


	public void setSupperAmount(Long value) {
		this.supperAmount = value;
	}
	public Long getSupperAmount() {
		return this.supperAmount;
	}


	public void setSupperTimes(Integer value) {
		this.supperTimes = value;
	}
	public Integer getSupperTimes() {
		return this.supperTimes;
	}


	public void setFruitAmount(Long value) {
		this.fruitAmount = value;
	}
	public Long getFruitAmount() {
		return this.fruitAmount;
	}


	public void setFruitTimes(Integer value) {
		this.fruitTimes = value;
	}
	public Integer getFruitTimes() {
		return this.fruitTimes;
	}


	public void setInternetAmount(Long value) {
		this.internetAmount = value;
	}
	public Long getInternetAmount() {
		return this.internetAmount;
	}


	public void setMarketAmount(Long value) {
		this.marketAmount = value;
	}
	public Long getMarketAmount() {
		return this.marketAmount;
	}


	public void setBathAmount(Long value) {
		this.bathAmount = value;
	}
	public Long getBathAmount() {
		return this.bathAmount;
	}


	public void setBookAmount(Long value) {
		this.bookAmount = value;
	}
	public Long getBookAmount() {
		return this.bookAmount;
	}


	public void setHospitalAmount(Long value) {
		this.hospitalAmount = value;
	}
	public Long getHospitalAmount() {
		return this.hospitalAmount;
	}


	public void setOtherAmount(Long value) {
		this.otherAmount = value;
	}
	public Long getOtherAmount() {
		return this.otherAmount;
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
		if(obj instanceof StatisStudentConsume == false) return false;
		if(this == obj) return true;
		StatisStudentConsume other = (StatisStudentConsume)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

