package com.sunmnet.bigdata.web.model.enums;

public enum SocialSkillsEnum {
    RELATION_PRINCE("社交王子"),RELATION_PRINCESS("社交公主"),RELATION_MIDDLE("社交圈子中等"),RELATION_SMALL("社交圈子小");

    SocialSkillsEnum(String name) {
        this.name = name;
    }

    private String name;
    public String getName() {
        return name;
    }
}
