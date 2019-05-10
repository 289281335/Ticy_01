package com.sunmnet.bigdata.web.model.response.behavior;

import com.sunmnet.bigdata.web.model.entity.behavior.BehaviorStudentTraces;
import org.apache.commons.lang3.StringUtils;

public class StudentTracesRES extends BehaviorStudentTraces {

    private String hasCourse;

    public String isHasCourse() {
        return StringUtils.isEmpty(this.getCourseName())?"无":"有";
    }
}
