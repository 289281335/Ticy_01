package com.sunmnet.bigdata.web.model.response.student;

public class StudentClassRateRES {
	/** 学期 **/
	private String schoolTerm;
	/** 到课率 **/
	private String courseRate;

	public String getSchoolTerm() {
		return schoolTerm;
	}

	public void setSchoolTerm(String schoolTerm) {
		this.schoolTerm = schoolTerm;
	}

	public String getCourseRate() {
		return courseRate;
	}

	public void setCourseRate(String courseRate) {
		this.courseRate = courseRate;
	}
}
