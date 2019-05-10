/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-02-01 11:22:40
 */
package com.sunmnet.bigdata.web.model.entity.student;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentFriend
 * @Description
 * @date 2018-02-01 11:22:40
 */
public class StudentFriend extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StudentFriend";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_FRIEND_STUDENT_NO = "friend_student_no";
	public static final String ALIAS_TYPE = "type";
	public static final String ALIAS_RELATION_DEGREE = "relation_degree";
	

	
    //朋友关系主键
	private Integer id;
    //学号
	private String studentNo;
    //朋友学号
	private String friendStudentNo;
    //类别
	private String type;
    //关系度
	private String relationDegree;

	public StudentFriend(){
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


	public void setFriendStudentNo(String value) {
		this.friendStudentNo = value;
	}
	public String getFriendStudentNo() {
		return this.friendStudentNo;
	}


	public void setType(String value) {
		this.type = value;
	}
	public String getType() {
		return this.type;
	}


	public void setRelationDegree(String value) {
		this.relationDegree = value;
	}
	public String getRelationDegree() {
		return this.relationDegree;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("StudentNo",getStudentNo())
			.append("FriendStudentNo",getFriendStudentNo())
			.append("Type",getType())
			.append("RelationDegree",getRelationDegree())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentNo())
			.append(getFriendStudentNo())
			.append(getType())
			.append(getRelationDegree())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StudentFriend == false) return false;
		if(this == obj) return true;
		StudentFriend other = (StudentFriend)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentNo(),other.getStudentNo())
			.append(getFriendStudentNo(),other.getFriendStudentNo())
			.append(getType(),other.getType())
			.append(getRelationDegree(),other.getRelationDegree())
			.isEquals();
	}
}

