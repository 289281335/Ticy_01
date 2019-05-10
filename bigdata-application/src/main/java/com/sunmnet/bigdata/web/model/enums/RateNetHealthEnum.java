package com.sunmnet.bigdata.web.model.enums;

public enum RateNetHealthEnum {
    BEST_BAD_HEALTH("不健康"),BAD_HEALTH("较不健康"),NORMAL_HEALTH("一般"),
    GOOD_HEALTH("较健康"),BEST_GOOD_HEALTH("很健康");

    RateNetHealthEnum(String name) {
        this.name = name;
    }

    private String name;
    public String getName() {
        return name;
    }
}
