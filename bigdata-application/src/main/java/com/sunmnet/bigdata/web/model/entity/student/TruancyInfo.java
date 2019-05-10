package com.sunmnet.bigdata.web.model.entity.student;


import com.sunmnet.bigdata.web.model.entity.student.StudentTruancyRecord;

import java.util.List;

public class TruancyInfo {
	/* 课程名称 */
	private String courseName;
	/* 旷课次数 */
	private Integer truancyTimes;
	/* 旷课内容 */
	private List<StudentTruancyRecord> recordList;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getTruancyTimes() {
		return truancyTimes;
	}
	public void setTruancyTimes(Integer truancyTimes) {
		this.truancyTimes = truancyTimes;
	}
	public List<StudentTruancyRecord> getRecordList() {
		return recordList;
	}
	public void setRecordList(List<StudentTruancyRecord> recordList) {
		this.recordList = recordList;
	}
}
