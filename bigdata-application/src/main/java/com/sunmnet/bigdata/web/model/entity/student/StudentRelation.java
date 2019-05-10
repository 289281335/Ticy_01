package com.sunmnet.bigdata.web.model.entity.student;

import java.io.Serializable;

public class StudentRelation implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String stuName;
	
	private String friendStuName;
	
	private String relationDegree;

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getFriendStuName() {
		return friendStuName;
	}

	public void setFriendStuName(String friendStuName) {
		this.friendStuName = friendStuName;
	}

	public String getRelationDegree() {
		return relationDegree;
	}

	public void setRelationDegree(String relationDegree) {
		this.relationDegree = relationDegree;
	}

}
