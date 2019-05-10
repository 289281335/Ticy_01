package com.sunmnet.bigdata.web.model.enums;

/**
 * 设置成长目标分类
 */
public enum ArgetType {
	READ("读研", "READ"), 
	WORK("就业", "WORK");

    ArgetType(String name, String value) {
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
