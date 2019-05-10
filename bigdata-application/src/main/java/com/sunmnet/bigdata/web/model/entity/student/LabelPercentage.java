package com.sunmnet.bigdata.web.model.entity.student;

import com.sunmnet.bigdata.commons.model.BaseModel;

public class LabelPercentage extends BaseModel implements Comparable<LabelPercentage> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4262326938113852525L;
	//标签
    private String label;
    //百分比数
    private String percentage;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public int compareTo(LabelPercentage labelPercentage) {
	    return this.percentage.compareTo(labelPercentage.getPercentage());
	}
	
    
}
