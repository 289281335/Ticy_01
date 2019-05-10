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
 * @ClassName SchoolBuildingPosition
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class SchoolBuildingPosition extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "SchoolBuildingPosition";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_BUILDING_NAME = "building_name";
	public static final String ALIAS_WINDOW_NAME = "window_name";
	public static final String ALIAS_LONGITUDE = "longitude";
	public static final String ALIAS_LATITUDE = "latitude";
	

	
    //主键
	private Integer id;
    //建筑名称
	private String buildingName;
    //窗口名称
	private String windowName;
    //经度
	private String longitude;
    //纬度
	private String latitude;

	public SchoolBuildingPosition(){
	}

	public void setId(Integer value) {
		this.id = value;
	}
	public Integer getId() {
		return this.id;
	}


	public void setBuildingName(String value) {
		this.buildingName = value;
	}
	public String getBuildingName() {
		return this.buildingName;
	}


	public void setWindowName(String value) {
		this.windowName = value;
	}
	public String getWindowName() {
		return this.windowName;
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
			.append("BuildingName",getBuildingName())
			.append("WindowName",getWindowName())
			.append("Longitude",getLongitude())
			.append("Latitude",getLatitude())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getBuildingName())
			.append(getWindowName())
			.append(getLongitude())
			.append(getLatitude())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SchoolBuildingPosition == false) return false;
		if(this == obj) return true;
		SchoolBuildingPosition other = (SchoolBuildingPosition)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getBuildingName(),other.getBuildingName())
			.append(getWindowName(),other.getWindowName())
			.append(getLongitude(),other.getLongitude())
			.append(getLatitude(),other.getLatitude())
			.isEquals();
	}
}

