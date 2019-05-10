package com.sunmnet.bigdata.web.model.enums;

public enum RelationDormStatusEnum {
    RELATION_BEST("宿舍关系非常好",4),RELATION_GOOD("宿舍关系好" ,3 ),RELATION_BAD("宿舍边缘人物",0);

    RelationDormStatusEnum(String name ,int level) {
        this.name = name;
        this.level = level;
    }

    private String name;
    private int level;
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}
