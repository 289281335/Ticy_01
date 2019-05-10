/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-31 17:13:05
 */
package com.sunmnet.bigdata.web.model.entity.statics;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StatisStudentSurfInternetMonth
 * @Description
 * @date 2018-01-31 17:13:05
 */
public class StatisStudentSurfInternetMonth extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "StatisStudentSurfInternetMonth";
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
	public static final String ALIAS_GRADE = "grade";
	public static final String ALIAS_PLACE = "place";
	public static final String ALIAS_AVG_SURF_NET_TIME = "avg_surf_net_time";
	public static final String ALIAS_PERIOD_OF_MONTH_NET = "period_of_month_net";
	public static final String ALIAS_WEEK_1_COUNT = "week_1_count";
	public static final String ALIAS_WEEKEND_1_COUNT = "weekend_1_count";
	public static final String ALIAS_WEEK_2_COUNT = "week_2_count";
	public static final String ALIAS_WEEKEND_2_COUNT = "weekend_2_count";
	public static final String ALIAS_WEEK_3_COUNT = "week_3_count";
	public static final String ALIAS_WEEKEND_3_COUNT = "weekend_3_count";
	public static final String ALIAS_WEEK_4_COUNT = "week_4_count";
	public static final String ALIAS_WEEKEND_4_COUNT = "weekend_4_count";
	public static final String ALIAS_WEEK_5_COUNT = "week_5_count";
	public static final String ALIAS_WEEKEND_5_COUNT = "weekend_5_count";
	public static final String ALIAS_WEEK_6_COUNT = "week_6_count";
	public static final String ALIAS_WEEKEND_6_COUNT = "weekend_6_count";
	public static final String ALIAS_WEEK_7_COUNT = "week_7_count";
	public static final String ALIAS_WEEKEND_7_COUNT = "weekend_7_count";
	public static final String ALIAS_NETHEALTHRATE = "netHealthRate";
	

	
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
    //年级
	private String grade;
    //生源地
	private String place;
    //月均上网时长统计
	private Integer avgSurfNetTime;
    //经常上网时间段
	private Integer periodOfMonthNet;
    //第一周周内上网总时长
	private String week1count;
    //第一周周末上网总时长
	private String weekend1count;
    //第二周周内上网总时长
	private String week2count;
    //第二周周末上网总时长
	private String weekend2count;
    //第三周周内上网总时长
	private String week3count;
    //第三周周末上网总时长
	private String weekend3count;
    //第四周周内上网总时长
	private String week4count;
    //第四周周末上网总时长
	private String weekend4count;
    //第五周周内上网总时长
	private String week5count;
    //第五周周末上网总时长
	private String weekend5count;
    //第六周周内上网总时长
	private String week6count;
    //第六周周末上网总时长
	private String weekend6count;
    //第七周周内上网总时长
	private String week7count;
    //第七周周末上网总时长
	private String weekend7count;
    //上网健康度
	private Double nethealthrate;

	public StatisStudentSurfInternetMonth(){
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


	public void setAvgSurfNetTime(Integer value) {
		this.avgSurfNetTime = value;
	}
	public Integer getAvgSurfNetTime() {
		return this.avgSurfNetTime;
	}


	public void setPeriodOfMonthNet(Integer value) {
		this.periodOfMonthNet = value;
	}
	public Integer getPeriodOfMonthNet() {
		return this.periodOfMonthNet;
	}


	public void setWeek1count(String value) {
		this.week1count = value;
	}
	public String getWeek1count() {
		return this.week1count;
	}


	public void setWeekend1count(String value) {
		this.weekend1count = value;
	}
	public String getWeekend1count() {
		return this.weekend1count;
	}


	public void setWeek2count(String value) {
		this.week2count = value;
	}
	public String getWeek2count() {
		return this.week2count;
	}


	public void setWeekend2count(String value) {
		this.weekend2count = value;
	}
	public String getWeekend2count() {
		return this.weekend2count;
	}


	public void setWeek3count(String value) {
		this.week3count = value;
	}
	public String getWeek3count() {
		return this.week3count;
	}


	public void setWeekend3count(String value) {
		this.weekend3count = value;
	}
	public String getWeekend3count() {
		return this.weekend3count;
	}


	public void setWeek4count(String value) {
		this.week4count = value;
	}
	public String getWeek4count() {
		return this.week4count;
	}


	public void setWeekend4count(String value) {
		this.weekend4count = value;
	}
	public String getWeekend4count() {
		return this.weekend4count;
	}


	public void setWeek5count(String value) {
		this.week5count = value;
	}
	public String getWeek5count() {
		return this.week5count;
	}


	public void setWeekend5count(String value) {
		this.weekend5count = value;
	}
	public String getWeekend5count() {
		return this.weekend5count;
	}


	public void setWeek6count(String value) {
		this.week6count = value;
	}
	public String getWeek6count() {
		return this.week6count;
	}


	public void setWeekend6count(String value) {
		this.weekend6count = value;
	}
	public String getWeekend6count() {
		return this.weekend6count;
	}


	public void setWeek7count(String value) {
		this.week7count = value;
	}
	public String getWeek7count() {
		return this.week7count;
	}


	public void setWeekend7count(String value) {
		this.weekend7count = value;
	}
	public String getWeekend7count() {
		return this.weekend7count;
	}


	public void setNethealthrate(Double value) {
		this.nethealthrate = value;
	}
	public Double getNethealthrate() {
		return this.nethealthrate;
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
			.append("Grade",getGrade())
			.append("Place",getPlace())
			.append("AvgSurfNetTime",getAvgSurfNetTime())
			.append("PeperiodOfMonthNet",getPeriodOfMonthNet())
			.append("Week1count",getWeek1count())
			.append("Weekend1count",getWeekend1count())
			.append("Week2count",getWeek2count())
			.append("Weekend2count",getWeekend2count())
			.append("Week3count",getWeek3count())
			.append("Weekend3count",getWeekend3count())
			.append("Week4count",getWeek4count())
			.append("Weekend4count",getWeekend4count())
			.append("Week5count",getWeek5count())
			.append("Weekend5count",getWeekend5count())
			.append("Week6count",getWeek6count())
			.append("Weekend6count",getWeekend6count())
			.append("Week7count",getWeek7count())
			.append("Weekend7count",getWeekend7count())
			.append("Nethealthrate",getNethealthrate())
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
			.append(getGrade())
			.append(getPlace())
			.append(getAvgSurfNetTime())
			.append(getPeriodOfMonthNet())
			.append(getWeek1count())
			.append(getWeekend1count())
			.append(getWeek2count())
			.append(getWeekend2count())
			.append(getWeek3count())
			.append(getWeekend3count())
			.append(getWeek4count())
			.append(getWeekend4count())
			.append(getWeek5count())
			.append(getWeekend5count())
			.append(getWeek6count())
			.append(getWeekend6count())
			.append(getWeek7count())
			.append(getWeekend7count())
			.append(getNethealthrate())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StatisStudentSurfInternetMonth == false) return false;
		if(this == obj) return true;
		StatisStudentSurfInternetMonth other = (StatisStudentSurfInternetMonth)obj;
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
			.append(getGrade(),other.getGrade())
			.append(getPlace(),other.getPlace())
			.append(getAvgSurfNetTime(),other.getAvgSurfNetTime())
			.append(getPeriodOfMonthNet(),other.getPeriodOfMonthNet())
			.append(getWeek1count(),other.getWeek1count())
			.append(getWeekend1count(),other.getWeekend1count())
			.append(getWeek2count(),other.getWeek2count())
			.append(getWeekend2count(),other.getWeekend2count())
			.append(getWeek3count(),other.getWeek3count())
			.append(getWeekend3count(),other.getWeekend3count())
			.append(getWeek4count(),other.getWeek4count())
			.append(getWeekend4count(),other.getWeekend4count())
			.append(getWeek5count(),other.getWeek5count())
			.append(getWeekend5count(),other.getWeekend5count())
			.append(getWeek6count(),other.getWeek6count())
			.append(getWeekend6count(),other.getWeekend6count())
			.append(getWeek7count(),other.getWeek7count())
			.append(getWeekend7count(),other.getWeekend7count())
			.append(getNethealthrate(),other.getNethealthrate())
			.isEquals();
	}
}

