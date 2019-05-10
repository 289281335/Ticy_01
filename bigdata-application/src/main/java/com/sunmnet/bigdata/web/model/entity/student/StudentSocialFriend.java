/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-02-01 12:10:03
 */
package com.sunmnet.bigdata.web.model.entity.student;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentSocialFriend
 * @Description
 * @date 2018-02-01 12:10:03
 */
public class StudentSocialFriend extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StudentSocialFriend";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_STUDENT_NAME = "student_name";
	public static final String ALIAS_GENDER = "gender";
	public static final String ALIAS_NATION = "nation";
	public static final String ALIAS_COLLEGE_NAME = "college_name";
	public static final String ALIAS_COLLEGE_CODE = "college_code";
	public static final String ALIAS_MAJOR_NAME = "major_name";
	public static final String ALIAS_MAJOR_CODE = "major_code";
	public static final String ALIAS_CLASS_NAME = "class_name";
	public static final String ALIAS_ACADEMY_NAME = "academy_name";
	public static final String ALIAS_DORM = "dorm";
	public static final String ALIAS_GRADE = "grade";
	public static final String ALIAS_PLACE = "place";
	public static final String ALIAS_FRIEND_STUDENT_NO = "friend_student_no";
	public static final String ALIAS_FRIEND_NAME = "friend_name";
	public static final String ALIAS_SOCIAL_NO = "social_no";
	public static final String ALIAS_RELATION_DEGREE = "relation_degree";
	public static final String ALIAS_FRIEND_COLLEGE_NAME = "friend_college_name";
	public static final String ALIAS_FRIEND_MAJOR_NAME = "friend_major_name";
	public static final String ALIAS_FRIEND_CLASS_NAME = "friend_class_name";
	public static final String ALIAS_FRIEND_DORM = "friend_dorm";
	public static final String ALIAS_FRIEND_GENDER = "friend_gender";
	public static final String ALIAS_FRIEND_IS_EXCELLENT_GRADES = "friend_is_excellent_grades";
	

	
    //
	private Integer id;
    //学号
	private String studentNo;
    //姓名
	private String studentName;
    //性别
	private String gender;
    //民族
	private String nation;
    //学院
	private String collegeName;
    //学院代码
	private String collegeCode;
    //专业
	private String majorName;
    //专业代码
	private String majorCode;
    //班级
	private String className;
    //书院
	private String academyName;
    //宿舍
	private String dorm;
    //年级
	private String grade;
    //生源地
	private String place;
    //朋友学号
	private String friendStudentNo;
    //朋友姓名
	private String friendName;
    //社区号
	private String socialNo;
    //关系度
	private String relationDegree;
    //朋友学院
	private String friendCollegeName;
    //朋友专业
	private String friendMajorName;
    //朋友班级
	private String friendClassName;
    //朋友宿舍
	private String friendDorm;
    //朋友性别
	private String friendGender;
    //朋友是否学霸
	private String friendIsExcellentGrades;

	public StudentSocialFriend(){
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


	public void setGender(String value) {
		this.gender = value;
	}
	public String getGender() {
		return this.gender;
	}


	public void setNation(String value) {
		this.nation = value;
	}
	public String getNation() {
		return this.nation;
	}


	public void setCollegeName(String value) {
		this.collegeName = value;
	}
	public String getCollegeName() {
		return this.collegeName;
	}


	public void setCollegeCode(String value) {
		this.collegeCode = value;
	}
	public String getCollegeCode() {
		return this.collegeCode;
	}


	public void setMajorName(String value) {
		this.majorName = value;
	}
	public String getMajorName() {
		return this.majorName;
	}


	public void setMajorCode(String value) {
		this.majorCode = value;
	}
	public String getMajorCode() {
		return this.majorCode;
	}


	public void setClassName(String value) {
		this.className = value;
	}
	public String getClassName() {
		return this.className;
	}


	public void setAcademyName(String value) {
		this.academyName = value;
	}
	public String getAcademyName() {
		return this.academyName;
	}


	public void setDorm(String value) {
		this.dorm = value;
	}
	public String getDorm() {
		return this.dorm;
	}


	public void setGrade(String value) {
		this.grade = value;
	}
	public String getGrade() {
		return this.grade;
	}


	public void setPlace(String value) {
		this.place = value;
	}
	public String getPlace() {
		return this.place;
	}


	public void setFriendStudentNo(String value) {
		this.friendStudentNo = value;
	}
	public String getFriendStudentNo() {
		return this.friendStudentNo;
	}


	public void setFriendName(String value) {
		this.friendName = value;
	}
	public String getFriendName() {
		return this.friendName;
	}


	public void setSocialNo(String value) {
		this.socialNo = value;
	}
	public String getSocialNo() {
		return this.socialNo;
	}


	public void setRelationDegree(String value) {
		this.relationDegree = value;
	}
	public String getRelationDegree() {
		return this.relationDegree;
	}


	public void setFriendCollegeName(String value) {
		this.friendCollegeName = value;
	}
	public String getFriendCollegeName() {
		return this.friendCollegeName;
	}


	public void setFriendMajorName(String value) {
		this.friendMajorName = value;
	}
	public String getFriendMajorName() {
		return this.friendMajorName;
	}


	public void setFriendClassName(String value) {
		this.friendClassName = value;
	}
	public String getFriendClassName() {
		return this.friendClassName;
	}


	public void setFriendDorm(String value) {
		this.friendDorm = value;
	}
	public String getFriendDorm() {
		return this.friendDorm;
	}


	public void setFriendGender(String value) {
		this.friendGender = value;
	}
	public String getFriendGender() {
		return this.friendGender;
	}


	public void setFriendIsExcellentGrades(String value) {
		this.friendIsExcellentGrades = value;
	}
	public String getFriendIsExcellentGrades() {
		return this.friendIsExcellentGrades;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("StudentNo",getStudentNo())
			.append("StudentName",getStudentName())
			.append("Gender",getGender())
			.append("Nation",getNation())
			.append("CollegeName",getCollegeName())
			.append("CollegeCode",getCollegeCode())
			.append("MajorName",getMajorName())
			.append("MajorCode",getMajorCode())
			.append("ClassName",getClassName())
			.append("AcademyName",getAcademyName())
			.append("Dorm",getDorm())
			.append("Grade",getGrade())
			.append("Place",getPlace())
			.append("FriendStudentNo",getFriendStudentNo())
			.append("FriendName",getFriendName())
			.append("SocialNo",getSocialNo())
			.append("RelationDegree",getRelationDegree())
			.append("FriendCollegeName",getFriendCollegeName())
			.append("FriendMajorName",getFriendMajorName())
			.append("FriendClassName",getFriendClassName())
			.append("FriendDorm",getFriendDorm())
			.append("FriendGender",getFriendGender())
			.append("FriendIsExcellentGrades",getFriendIsExcellentGrades())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getStudentNo())
			.append(getStudentName())
			.append(getGender())
			.append(getNation())
			.append(getCollegeName())
			.append(getCollegeCode())
			.append(getMajorName())
			.append(getMajorCode())
			.append(getClassName())
			.append(getAcademyName())
			.append(getDorm())
			.append(getGrade())
			.append(getPlace())
			.append(getFriendStudentNo())
			.append(getFriendName())
			.append(getSocialNo())
			.append(getRelationDegree())
			.append(getFriendCollegeName())
			.append(getFriendMajorName())
			.append(getFriendClassName())
			.append(getFriendDorm())
			.append(getFriendGender())
			.append(getFriendIsExcellentGrades())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StudentSocialFriend == false) return false;
		if(this == obj) return true;
		StudentSocialFriend other = (StudentSocialFriend)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getStudentNo(),other.getStudentNo())
			.append(getStudentName(),other.getStudentName())
			.append(getGender(),other.getGender())
			.append(getNation(),other.getNation())
			.append(getCollegeName(),other.getCollegeName())
			.append(getCollegeCode(),other.getCollegeCode())
			.append(getMajorName(),other.getMajorName())
			.append(getMajorCode(),other.getMajorCode())
			.append(getClassName(),other.getClassName())
			.append(getAcademyName(),other.getAcademyName())
			.append(getDorm(),other.getDorm())
			.append(getGrade(),other.getGrade())
			.append(getPlace(),other.getPlace())
			.append(getFriendStudentNo(),other.getFriendStudentNo())
			.append(getFriendName(),other.getFriendName())
			.append(getSocialNo(),other.getSocialNo())
			.append(getRelationDegree(),other.getRelationDegree())
			.append(getFriendCollegeName(),other.getFriendCollegeName())
			.append(getFriendMajorName(),other.getFriendMajorName())
			.append(getFriendClassName(),other.getFriendClassName())
			.append(getFriendDorm(),other.getFriendDorm())
			.append(getFriendGender(),other.getFriendGender())
			.append(getFriendIsExcellentGrades(),other.getFriendIsExcellentGrades())
			.isEquals();
	}
}

