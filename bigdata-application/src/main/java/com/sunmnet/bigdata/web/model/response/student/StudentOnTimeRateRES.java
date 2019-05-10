package com.sunmnet.bigdata.web.model.response.student;

public class StudentOnTimeRateRES {
	/** 学期 **/
	private String schoolTerm;
	/** 准点率 **/
	private String onTimeRate;
	
	public String getSchoolTerm() {
		return schoolTerm;
	}
	public void setSchoolTerm(String schoolTerm) {
		this.schoolTerm = schoolTerm;
	}
	public String getOnTimeRate() {
		return onTimeRate;
	}
	public void setOnTimeRate(String onTimeRate) {
		this.onTimeRate = onTimeRate;
	}
}
