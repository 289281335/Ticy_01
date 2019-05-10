/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-02-01 12:10:03
 */

package com.sunmnet.bigdata.web.service.student;

import com.sunmnet.bigdata.web.model.request.student.StudentSocialFriendREQ;
import com.sunmnet.bigdata.web.model.response.student.RelationLabelRES;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentSocialFriendService
 * @Description
 * @date 2018-02-01 12:10:03
 */
public interface IStudentSocialFriendService {
    /**
     * 根据学号查询某个学生社交圈
     * @param studentNo
     * @return
     */
    RelationLabelRES studentRelationLabel(String studentNo);

//    /**
//     * 社交群体关系查询
//     * @param studentSocialFriendREQ
//     * @return
//     */
//    List<StudentSocialFriend> listSociaFriend(StudentSocialFriendREQ studentSocialFriendREQ );

    /**
     * 根据学号查询学生社交圈
     */
    Map<String, Object> studentRelations(String studentNo);

    /**
     * 社交群体关系优化接口
     */
    Map<String, Object> listSocialRelation(StudentSocialFriendREQ studentSocialFriendREQ);
}
