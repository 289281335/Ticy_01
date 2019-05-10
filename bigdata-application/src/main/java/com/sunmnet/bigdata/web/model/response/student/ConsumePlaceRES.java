package com.sunmnet.bigdata.web.model.response.student;

import java.math.BigDecimal;

public class ConsumePlaceRES {
	/* 消费地点 */
	private String placeName;
	/* 消费次数 */
	private Integer consumeTimes;
	/* 消费金额 */
	private BigDecimal consumeAmount;
	/* 经度 */
	private String longitude;
	/* 纬度 */
	private String latitude;
		
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public Integer getConsumeTimes() {
		return consumeTimes;
	}
	public void setConsumeTimes(Integer consumeTimes) {
		this.consumeTimes = consumeTimes;
	}
	public BigDecimal getConsumeAmount() {
		return consumeAmount;
	}
	public void setConsumeAmount(BigDecimal consumeAmount) {
		this.consumeAmount = consumeAmount;
	}
}
