package com.sunmnet.bigdata.web.model.response.student;

/**
 * 消费结构响应实体
 * @author
 *
 */
public class ConsumeStructureRES {
	/* 消费项目名称 */
	private String consumeName;
	/* 消费金额 */
	private String consumeAmount;
	/* 消费项目占比率 */
	private String consumeRate;

	public ConsumeStructureRES(String consumeName, String consumeAmount, String consumeRate) {
		super();
		this.consumeName = consumeName;
		this.consumeAmount = consumeAmount;
		this.consumeRate = consumeRate;
	}

	public String getConsumeName() {
		return consumeName;
	}

	public void setConsumeName(String consumeName) {
		this.consumeName = consumeName;
	}

	public String getConsumeAmount() {
		return consumeAmount;
	}

	public void setConsumeAmount(String consumeAmount) {
		this.consumeAmount = consumeAmount;
	}

	public String getConsumeRate() {
		return consumeRate;
	}

	public void setConsumeRate(String consumeRate) {
		this.consumeRate = consumeRate;
	}
}
