/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:59
 */
package com.sunmnet.bigdata.web.model.entity.student;

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
 * @ClassName StudentInfo
 * @Description
 * @date 2018-01-30 09:48:59
 */
public class StudentInfo extends BaseModel {

	//alias
	public static final String FORMAT_BIRTHDAY = "yyyy-MM-dd";
	public static final String TABLE_ALIAS = "StudentInfo";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_IDENTITY_NO = "identity_no";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_GENDER = "gender";
	public static final String ALIAS_PHONE = "phone";
	public static final String ALIAS_EMAIL = "email";
	public static final String ALIAS_NATIVE_PLACE = "native_place";
	public static final String ALIAS_POLITICAL_LANDSCAPE = "political_landscape";
	public static final String ALIAS_EXAMINEE_NO = "examinee_no";
	public static final String ALIAS_SCHOOL_YEAR = "school_year";
	public static final String ALIAS_GRADUATED_SCHOOL = "graduated_school";
	public static final String ALIAS_ACADEMY_NAME = "academy_name";
	public static final String ALIAS_COLLEGE_NAME = "college_name";
	public static final String ALIAS_COLLEGE_CODE = "college_code";
	public static final String ALIAS_MAJOR_NAME = "major_name";
	public static final String ALIAS_MAJOR_CODE = "major_code";
	public static final String ALIAS_CLASS_NAME = "class_name";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_NATION = "nation";
	public static final String ALIAS_BIRTHDAY = "birthday";
	

	
	private String studentNo;
	private String identityNo;
	private String name;
	private String gender;
	private String phone;
	private String email;
	private String nativePlace;
	private String politicalLandscape;
	private String examineeNo;
	private Integer schoolYear;
	private String graduatedSchool;
	private String academyName;
	private String collegeName;
	private String collegeCode;
	private String majorName;
	private String majorCode;
	private String className;
	private String status;
	private String nation;
	private Date birthday;
	private String degree;


	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}



	public StudentInfo(){
	}


	public void setStudentNo(String value) {
		this.studentNo = value;
	}
	public String getStudentNo() {
		return this.studentNo;
	}


	public void setIdentityNo(String value) {
		this.identityNo = value;
	}
	public String getIdentityNo() {
		return this.identityNo;
	}


	public void setName(String value) {
		this.name = value;
	}
	public String getName() {
		return this.name;
	}


	public void setGender(String value) {
		this.gender = value;
	}
	public String getGender() {
		return this.gender;
	}


	public void setPhone(String value) {
		this.phone = value;
	}
	public String getPhone() {
		return this.phone;
	}


	public void setEmail(String value) {
		this.email = value;
	}
	public String getEmail() {
		return this.email;
	}


	public void setNativePlace(String value) {
		this.nativePlace = value;
	}
	public String getNativePlace() {
		return this.nativePlace;
	}


	public void setPoliticalLandscape(String value) {
		this.politicalLandscape = value;
	}
	public String getPoliticalLandscape() {
		return this.politicalLandscape;
	}


	public void setExamineeNo(String value) {
		this.examineeNo = value;
	}
	public String getExamineeNo() {
		return this.examineeNo;
	}


	public void setSchoolYear(Integer value) {
		this.schoolYear = value;
	}
	public Integer getSchoolYear() {
		return this.schoolYear;
	}


	public void setGraduatedSchool(String value) {
		this.graduatedSchool = value;
	}
	public String getGraduatedSchool() {
		return this.graduatedSchool;
	}


	public void setAcademyName(String value) {
		this.academyName = value;
	}
	public String getAcademyName() {
		return this.academyName;
	}


	public void setCollegeName(String value) {
		this.collegeName = value;
	}
	public String getCollegeName() {
		return this.collegeName;
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


	public void setStatus(String value) {
		this.status = value;
	}
	public String getStatus() {
		return this.status;
	}


	public void setNation(String value) {
		this.nation = value;
	}
	public String getNation() {
		return this.nation;
	}

	public String getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}

	@Transient
	public String getBirthdayString() {
		return DateUtils.dateToString(getBirthday(), FORMAT_BIRTHDAY);
	}
	public void setBirthdayString(String value) {
		setBirthday(DateUtils.parseDate(value, FORMAT_BIRTHDAY));
	}
	

	public void setBirthday(Date value) {
		this.birthday = value;
	}
	public Date getBirthday() {
		return this.birthday;
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
		if(obj instanceof StudentInfo == false) return false;
		if(this == obj) return true;
		StudentInfo other = (StudentInfo)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

