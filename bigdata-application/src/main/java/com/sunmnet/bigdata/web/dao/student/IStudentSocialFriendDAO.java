/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-02-01 12:10:03
 */
package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentSocialFriend;
import com.sunmnet.bigdata.web.model.request.student.StudentSocialFriendREQ;
import com.sunmnet.bigdata.web.model.response.student.StudentSocialFriendRES;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentSocialFriendDAO
 * @Description
 * @date 2018-02-01 12:10:03
 */
public interface IStudentSocialFriendDAO {
    /**
     * 根据学号查询某个学生社交圈
     * @param studentNo
     * @return
     */
    List<StudentSocialFriendRES> listFriendsByStudentNo(String studentNo);

    /**
     * 社交群体关系查询
     * @param studentSocialFriendREQ
     * @return
     */
    List<StudentSocialFriend> listSociaFriend(StudentSocialFriendREQ studentSocialFriendREQ );
}
