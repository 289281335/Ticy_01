package com.sunmnet.bigdata.web.model.entity.student;


import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * 相似度信息
 */
public class SimilarityDegree extends BaseModel implements Comparable<SimilarityDegree>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9113247732473680126L;
	//学期学年名称
    private String semestername;
    private String semester;
    //SEMESTER 学期 ;SCHOOLYEAR 学期
    private String type;
    //百分比
    private String percentage;
    
    private String semesterSecond;//奖励数对应学期
    
	public String getSemestername() {
		return semestername;
	}

	public void setSemestername(String semestername) {
		this.semestername = semestername;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public int compareTo(SimilarityDegree similarityDegree) {
	    return this.semester.compareTo(similarityDegree.getSemester());
	}


	public String getSemesterSecond() {
		return semesterSecond;
	}

	public void setSemesterSecond(String semesterSecond) {
		this.semesterSecond = semesterSecond;
	}

    
	
}
