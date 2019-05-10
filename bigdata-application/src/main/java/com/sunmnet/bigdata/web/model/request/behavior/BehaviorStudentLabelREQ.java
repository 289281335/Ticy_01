package com.sunmnet.bigdata.web.model.request.behavior;

import com.sunmnet.bigdata.web.model.entity.student.StudentInfo;

public class BehaviorStudentLabelREQ extends StudentInfo{
    private String labelName;  //群体标签名
    private String timePoint;  //时间点
    private String poolLevel;  //是否贫困

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(String timePoint) {
        this.timePoint = timePoint;
    }

    public String getPoolLevel() {
        return poolLevel;
    }

    public void setPoolLevel(String poolLevel) {
        this.poolLevel = poolLevel;
    }
}
