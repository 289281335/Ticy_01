package com.sunmnet.bigdata.web.model.entity.student;

public class SchoolLongitude {
	
	//位置
	private String localtion;
	
	//经纬度
	private String longitude;

	public String getLocaltion() {
		return localtion;
	}

	public void setLocaltion(String localtion) {
		this.localtion = localtion;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return "SchoolLongitude [localtion=" + localtion + ", longitude=" + longitude + "]";
	}

}
