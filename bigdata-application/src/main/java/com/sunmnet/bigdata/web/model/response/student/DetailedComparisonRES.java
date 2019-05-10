package com.sunmnet.bigdata.web.model.response.student;


import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * 学生成长设置成长目群体超越、持平、 偏差大统计项
 */
public class DetailedComparisonRES extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9113247732473680126L;
	private int transcend;//超越
	private int equal;//持平
	private int deviation;//偏差
	public int getTranscend() {
		return transcend;
	}
	public void setTranscend(int transcend) {
		this.transcend = transcend;
	}
	public int getEqual() {
		return equal;
	}
	public void setEqual(int equal) {
		this.equal = equal;
	}
	public int getDeviation() {
		return deviation;
	}
	public void setDeviation(int deviation) {
		this.deviation = deviation;
	}
	
}
