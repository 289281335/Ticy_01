package com.sunmnet.bigdata.web.model.enums;

public enum GenderEnum {

    MAN("男",1), WEMAN("nv",2), UNKNOW("未知",3);

    GenderEnum(String name,int code) {
        this.name = name;
        this.code = code;
    }

    private String name;
    private int code;

    public String getName() {
        return name;
    }


    public int getCode() {
        return code;
    }

}
