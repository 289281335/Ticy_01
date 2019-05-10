package com.sunmnet.bigdata.web.model.response.student;



import com.sunmnet.bigdata.commons.model.BaseModel;
import com.sunmnet.bigdata.web.model.enums.ArgetType;

import java.util.List;

/**
 * 学生成长目标信息（代码和名称都显示
 * @author wm
 */
public class StudentArgetAllRES extends BaseModel {
	/**
	 *
	 */
	private static final long serialVersionUID = -8659900106647244636L;
	private String studentNo;
	private ArgetType argetType;
	private List<String> schoolInfo;//学校信息
	private String industryName;//行业名称
	private List<String> argetWorkInfo;//职业信息

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public ArgetType getArgetType() {
		return argetType;
	}
	public void setArgetType(ArgetType argetType) {
		this.argetType = argetType;
	}
	public List<String> getSchoolInfo() {
		return schoolInfo;
	}
	public void setSchoolInfo(List<String> schoolInfo) {
		this.schoolInfo = schoolInfo;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public List<String> getArgetWorkInfo() {
		return argetWorkInfo;
	}
	public void setArgetWorkInfo(List<String> argetWorkInfo) {
		this.argetWorkInfo = argetWorkInfo;
	}
	
		
}
