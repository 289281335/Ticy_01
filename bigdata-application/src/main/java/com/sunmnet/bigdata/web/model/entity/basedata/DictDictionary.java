/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.model.entity.basedata;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName DictDictionary
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class DictDictionary extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "DictDictionary";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_CODE = "code";
	public static final String ALIAS_KEY = "key";
	public static final String ALIAS_VALUE = "value";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_PRIORITY = "priority";
	

	private String name;
	private String value;
	private String status;
	private Integer priority;

	public DictDictionary(){
	}

	public void setName(String value) {
		this.name = value;
	}
	public String getName() {
		return this.name;
	}


	public void setValue(String value) {
		this.value = value;
	}
	public String getValue() {
		return this.value;
	}


	public void setStatus(String value) {
		this.status = value;
	}
	public String getStatus() {
		return this.status;
	}


	public void setPriority(Integer value) {
		this.priority = value;
	}
	public Integer getPriority() {
		return this.priority;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof DictDictionary == false) return false;
		if(this == obj) return true;
		DictDictionary other = (DictDictionary)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

