package com.sunmnet.bigdata.web.model.enums;

/**
 * 设置成长目标状态
 */
public enum ArgetStatus {
	YES("已设置", "YES"), 
	NO("未设置", "NO");

    ArgetStatus(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

    
}
