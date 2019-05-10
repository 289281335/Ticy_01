package com.sunmnet.bigdata.web.model.entity.student;


import com.sunmnet.bigdata.commons.model.BaseModel;

public class SchoolYear extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4262326938113852525L;
	//学年 例如：入学2014   、2105
    private String schoolYear;
    //学年汉字 例如：入学2014为一 、2105为二
    private String chinese;
    private String second;
	public String getSchoolYear() {
		return schoolYear;
	}
	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
}
