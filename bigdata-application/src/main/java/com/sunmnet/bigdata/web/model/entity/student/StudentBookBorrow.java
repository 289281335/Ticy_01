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
 * @ClassName StudentBookBorrow
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class StudentBookBorrow extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StudentBookBorrow";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_STUDENT_NAME = "student_name";
	public static final String ALIAS_BORROW_TIME = "borrow_time";
	public static final String ALIAS_BORROW_COUNT = "borrow_count";
	

	
    //主键
	private Integer id;
    //学号
	private String studentNo;
    //姓名
	private String studentName;
    //借阅时间
	private String borrowTime;
    //借阅数量
	private Integer borrowCount;

	public StudentBookBorrow(){
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


	public void setBorrowTime(String value) {
		this.borrowTime = value;
	}
	public String getBorrowTime() {
		return this.borrowTime;
	}


	public void setBorrowCount(Integer value) {
		this.borrowCount = value;
	}
	public Integer getBorrowCount() {
		return this.borrowCount;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("StudentNo",getStudentNo())
			.append("StudentName",getStudentName())
			.append("BorrowTime",getBorrowTime())
			.append("BorrowCount",getBorrowCount())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentNo())
			.append(getStudentName())
			.append(getBorrowTime())
			.append(getBorrowCount())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StudentBookBorrow == false) return false;
		if(this == obj) return true;
		StudentBookBorrow other = (StudentBookBorrow)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentNo(),other.getStudentNo())
			.append(getStudentName(),other.getStudentName())
			.append(getBorrowTime(),other.getBorrowTime())
			.append(getBorrowCount(),other.getBorrowCount())
			.isEquals();
	}
}

