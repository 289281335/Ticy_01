package com.sunmnet.bigdata.web.model.entity.behavior;

import com.sunmnet.bigdata.commons.model.BaseModel;

public class BehaviorGroupLabel extends BaseModel{

    private int id;
    private  String labelName;  //标签名
    private  String labelCode;  //标签代码
    private  String labelDescribe;  //标签描述
    private  String createTime;  //创建时间
    private  String updateTime;  //修改时间
    private  String deleteTime;  //删除时间
    private  int status;  //状态 1启用 0停用

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getLabelCode() {
        return labelCode;
    }

    public void setLabelCode(String labelCode) {
        this.labelCode = labelCode;
    }

    public String getLabelDescribe() {
        return labelDescribe;
    }

    public void setLabelDescribe(String labelDescribe) {
        this.labelDescribe = labelDescribe;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
