package com.sunmnet.bigdata.web.model.entity.student;

import com.sunmnet.bigdata.commons.model.BaseModel;

public class ArageAverage extends BaseModel implements Comparable<ArageAverage> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4262326938113852525L;
	//指标名称
    private String indexName;
    //平均值
    private String average;
	
	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getAverage() {
		return average;
	}

	public void setAverage(String average) {
		this.average = average;
	}

	public int compareTo(ArageAverage arageAverage) {
	    return this.average.compareTo(arageAverage.getAverage());
	}
	
    
}
