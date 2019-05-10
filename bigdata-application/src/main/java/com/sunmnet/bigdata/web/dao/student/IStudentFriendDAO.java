/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-02-01 11:22:40
 */
package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentFriendDAO
 * @Description
 * @date 2018-02-01 11:22:40
 */
public interface IStudentFriendDAO {

    /**
     * 获得朋友数超过同专业人的百分比
     * @param stuNo
     * @return
     */
    Integer getFriendRanking(String stuNo);

    /**
     * 获得朋友数超过同专业人的百分比
     * @param stuNo
     * @return
     */
    Integer getMaxFriendCount(String stuNo);

    /***
     * 按照朋友数分类
     * @param studentInfoREQ
     * @return
     */
    List<Map<String,Object>> countFriendByCategary(StudentInfoREQ studentInfoREQ);
}
