package com.sunmnet.bigdata.web.model.entity.student;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author songlin_xie_n22@126.com
 * @version 1.0
 * @Title:
 * @Package
 * @Description:
 * @date 2018/3/19 10:42
 */
public class StudentPovertyAnalyse extends BaseModel {

    private Integer id;//学号
    private String isFocus;//是否关注
    private String reason;//理由

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsFocus() {
        return isFocus;
    }

    public void setIsFocus(String isFocus) {
        this.isFocus = isFocus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
