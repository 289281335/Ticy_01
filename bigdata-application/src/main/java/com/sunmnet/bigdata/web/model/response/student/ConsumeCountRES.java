package com.sunmnet.bigdata.web.model.response.student;

import java.math.BigDecimal;

public class ConsumeCountRES {
	/* 消费年月 */
	private String consumeDate;
	/* 消费次数 */
	private BigDecimal consumeCount;

	public String getConsumeDate() {
		return consumeDate;
	}

	public void setConsumeDate(String consumeDate) {
		this.consumeDate = consumeDate;
	}

	public BigDecimal getConsumeCount() {
		return consumeCount;
	}

	public void setConsumeCount(BigDecimal consumeCount) {
		this.consumeCount = consumeCount;
	}
}
