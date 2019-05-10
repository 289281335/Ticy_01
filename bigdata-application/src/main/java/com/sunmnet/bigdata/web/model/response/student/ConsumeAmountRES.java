package com.sunmnet.bigdata.web.model.response.student;

import java.math.BigDecimal;

public class ConsumeAmountRES {
	/* 消费年月 */
	private String consumeDate;
	/* 消费金额 */
	private BigDecimal consumeAmount;

	public String getConsumeDate() {
		return consumeDate;
	}

	public void setConsumeDate(String consumeDate) {
		this.consumeDate = consumeDate;
	}

	public BigDecimal getConsumeAmount() {
		return consumeAmount;
	}

	public void setConsumeAmount(BigDecimal consumeAmount) {
		this.consumeAmount = consumeAmount;
	}

}
