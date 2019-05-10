package com.sunmnet.bigdata.web.model.enums;

public enum RelationSchoolCategoryEnum {
    RELATION_MAJOR("专业"),RELATION_CLASS("班级"),RELATION_DORM("宿舍"),RELATION_OTHER("其他");

    RelationSchoolCategoryEnum(String name) {
        this.name = name;
    }

    private String name;
    public String getName() {
        return name;
    }
}

