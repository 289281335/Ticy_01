package com.sunmnet.bigdata.web.model.enums;

public enum CrushNetEnum {

    SEVERE_ADDICTION("重度沉迷"), MILD_ADDICTION("轻度沉迷"), NONE_ADDICTION("不沉迷");

    CrushNetEnum(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
