package com.sunmnet.bigdata.web.model.enums;

public enum CrushNetOfWeekendEnum {


    CRUSH_WEEKEND("周末疯狂当"), HEALTH_WEEKEND("上网时间点健康");

    CrushNetOfWeekendEnum(String name) {
        this.name = name;
    }

    private String name;
    public String getName() {
        return name;
    }

}
