package com.sunmnet.bigdata.web.model.response.student;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/*
 * code:学号
 * datelist：学生最近几个月上网时长
 * map：map中存储两个值
 * 		值一： key  date(上网月份)
 * 		值二： key  netLength(上网时长)
 */

public class StudentNetDate implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private String code;
	private List<Map<String, Object>> dateList;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Map<String, Object>> getDateList() {
		return dateList;
	}
	public void setDateList(List<Map<String, Object>> dateList) {
		this.dateList = dateList;
	}
	@Override
	public String toString() {
		return "StudentNetDate [code=" + code + ", dateList=" + dateList + "]";
	}
	
	
	
	
}
