package com.sunmnet.bigdata.web.model.enums;

public enum WarningTypeEnum {
    LATE_BACK_WARN("夜归预警"), LOST_WARN("失联预警"),
    TRUANCY_WARN("逃课预警"),SUBJECTS_WARN("挂科预警"),
    LOST_JOB_WARN("失业预警"),
    OTHER_WARN("其它");

    WarningTypeEnum(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
