/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.model.entity.school;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName BehaviorTrackPosition
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class SchoolPosition extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "BehaviorTrackPosition";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_LOCALTION = "localtion";
	public static final String ALIAS_LONGITUDE = "longitude";
	public static final String ALIAS_LATITUDE = "latitude";
	

	
    //
	private Integer id;
    //地点名称
	private String localtion;
    //经度
	private String longitude;
    //纬度
	private String latitude;

	public SchoolPosition(){
	}

	public void setId(Integer value) {
		this.id = value;
	}
	public Integer getId() {
		return this.id;
	}


	public void setLocaltion(String value) {
		this.localtion = value;
	}
	public String getLocaltion() {
		return this.localtion;
	}


	public void setLongitude(String value) {
		this.longitude = value;
	}
	public String getLongitude() {
		return this.longitude;
	}


	public void setLatitude(String value) {
		this.latitude = value;
	}
	public String getLatitude() {
		return this.latitude;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Localtion",getLocaltion())
			.append("Longitude",getLongitude())
			.append("Latitude",getLatitude())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getLocaltion())
			.append(getLongitude())
			.append(getLatitude())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SchoolPosition == false) return false;
		if(this == obj) return true;
		SchoolPosition other = (SchoolPosition)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getLocaltion(),other.getLocaltion())
			.append(getLongitude(),other.getLongitude())
			.append(getLatitude(),other.getLatitude())
			.isEquals();
	}
}

