package com.sunmnet.bigdata.web.model.enums;

public enum  SleepLableEnum {
    SLEEP_EARLY("早睡",6),SLEEP_LATE("晚睡" ,6 ),GETUP_EARLY("早起",7),GETUP_LATE("晚起",7)
    ,DEEP_DROWSINESS("嗜睡",9) ,DEEP_ENOUGH("睡眠充足",8),DEEP_HYPOSOMNIA("睡眠轻度不足",6)
    ,DEEP_LACK("睡眠严重不足",6),OUT_VERY_ACTIVE("外出活跃型",0.75),OUT_ACTIVE("外出较活跃",0.5)
    ,OTAKU_MAN("宅男",0.5),OTAKU_WOMAN("宅女",0.5);

    SleepLableEnum(String name ,double level) {
        this.name = name;
        this.level = level;
    }

    private String name;
    private double level;
    public String getName() {
        return name;
    }

    public double getLevel() {
        return level;
    }
}
