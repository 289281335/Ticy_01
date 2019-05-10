/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-02-01 12:10:03
 */
package com.sunmnet.bigdata.web.service.student.impl;

import com.sunmnet.bigdata.web.dao.student.IStudentFriendDAO;
import com.sunmnet.bigdata.web.dao.student.IStudentSocialFriendDAO;
import com.sunmnet.bigdata.web.model.entity.student.StudentSocialFriend;
import com.sunmnet.bigdata.web.model.enums.GenderEnum;
import com.sunmnet.bigdata.web.model.enums.RelationDormStatusEnum;
import com.sunmnet.bigdata.web.model.enums.RelationSchoolCategoryEnum;
import com.sunmnet.bigdata.web.model.enums.SocialSkillsEnum;
import com.sunmnet.bigdata.web.model.request.student.StudentSocialFriendREQ;
import com.sunmnet.bigdata.web.model.response.student.RelationLabelRES;
import com.sunmnet.bigdata.web.model.entity.student.StudentRelationDegree;
import com.sunmnet.bigdata.web.model.response.student.StudentSocialFriendRES;
import com.sunmnet.bigdata.web.model.response.student.StudentSocialGroupRES;
import com.sunmnet.bigdata.web.service.student.IStudentSocialFriendService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentSocialFriendServiceImpl
 * @Description
 * @date 2018-02-01 12:10:03
 */
@Transactional
@Service("StudentSocialFriendServiceImpl")
public class StudentSocialFriendServiceImpl implements IStudentSocialFriendService {

    @Autowired
    private IStudentSocialFriendDAO studentSocialFriendDAO;


    @Autowired
    private IStudentFriendDAO studentFriendDAO;


    /**
     * 根据学号查询学生社交圈
     */
    @Override
    public Map<String, Object> studentRelations(String studentNo) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<StudentSocialFriendRES> list = studentSocialFriendDAO.listFriendsByStudentNo(studentNo);
        for (StudentSocialFriendRES studentSocialFriendRES : list) {
            if(StringUtils.isNotEmpty(studentSocialFriendRES.getDorm()) &&
                    studentSocialFriendRES.getDorm().equals(studentSocialFriendRES.getFriendDorm())){
                studentSocialFriendRES.setFriendRelation(RelationSchoolCategoryEnum.RELATION_DORM.getName());
            } else if(StringUtils.isNotEmpty(studentSocialFriendRES.getClassName()) &&
                    studentSocialFriendRES.getClassName().equals(studentSocialFriendRES.getClassName())){
                studentSocialFriendRES.setFriendRelation(RelationSchoolCategoryEnum.RELATION_CLASS.getName());
            } else if(StringUtils.isNotEmpty(studentSocialFriendRES.getMajorCode()) &&
                    studentSocialFriendRES.getMajorCode().equals(studentSocialFriendRES.getMajorCode())){
                studentSocialFriendRES.setFriendRelation(RelationSchoolCategoryEnum.RELATION_MAJOR.getName());
            } else {
                studentSocialFriendRES.setFriendRelation(RelationSchoolCategoryEnum.RELATION_OTHER.getName());
            }
        }
        if(CollectionUtils.isNotEmpty(list)){
            map.put("list", list);
            map.put("friendCount", list.size());
            Integer ranking = studentFriendDAO.getFriendRanking(studentNo);
            Integer maxFriendCount = studentFriendDAO.getMaxFriendCount(studentNo);
            if(maxFriendCount != null ) {
                if(maxFriendCount==0){
                    map.put("rate", "0.00");
                } else {
                    map.put("rate", ranking / maxFriendCount);
                }
            }
        }
        return map;
    }


    /**
     * 获得个人画像-综合画像个人选项卡社交信息
     */
    @Override
    public RelationLabelRES studentRelationLabel(String studentNo) {

        List<StudentSocialFriendRES> list = studentSocialFriendDAO.listFriendsByStudentNo(studentNo);
        int dormStudent = 0;
        for (StudentSocialFriendRES studentSocialFriendRES : list) {
            if(StringUtils.isNotEmpty(studentSocialFriendRES.getDorm()) &&
                    studentSocialFriendRES.getDorm().equals(studentSocialFriendRES.getFriendDorm())){
                ++dormStudent;
                studentSocialFriendRES.setFriendRelation(RelationSchoolCategoryEnum.RELATION_DORM.getName());
            } else if(StringUtils.isNotEmpty(studentSocialFriendRES.getClassName()) &&
                    studentSocialFriendRES.getClassName().equals(studentSocialFriendRES.getClassName())){
                studentSocialFriendRES.setFriendRelation(RelationSchoolCategoryEnum.RELATION_CLASS.getName());
            } else if(StringUtils.isNotEmpty(studentSocialFriendRES.getMajorCode()) &&
                    studentSocialFriendRES.getMajorCode().equals(studentSocialFriendRES.getMajorCode())){
                studentSocialFriendRES.setFriendRelation(RelationSchoolCategoryEnum.RELATION_MAJOR.getName());
            } else {
                studentSocialFriendRES.setFriendRelation(RelationSchoolCategoryEnum.RELATION_OTHER.getName());
            }
        }
        RelationLabelRES relationLabelRES = new RelationLabelRES();
        if(CollectionUtils.isNotEmpty(list)){
            if(list.size() > 3){
                if(GenderEnum.MAN.getName().equals(list.get(0).getGender()))
                {
                    relationLabelRES.setSocialSkills(SocialSkillsEnum.RELATION_PRINCE.getName());
                }
                else
                {
                    relationLabelRES.setSocialSkills(SocialSkillsEnum.RELATION_PRINCESS.getName());
                }
            }
            else if(list.size() < 3) {
                relationLabelRES.setSocialSkills(SocialSkillsEnum.RELATION_MIDDLE.getName());
            }
        }
        else {
            relationLabelRES.setSocialSkills(SocialSkillsEnum.RELATION_SMALL.getName());
        }

        if( dormStudent >= RelationDormStatusEnum.RELATION_BEST.getLevel() ) {
            relationLabelRES.setDormRelation(RelationDormStatusEnum.RELATION_BEST.getName());
        }
        else if(dormStudent ==  RelationDormStatusEnum.RELATION_BAD.getLevel()){
            relationLabelRES.setDormRelation(RelationDormStatusEnum.RELATION_BAD.getName());
        }
        else {
            relationLabelRES.setDormRelation(RelationDormStatusEnum.RELATION_GOOD.getName());
        }
        return relationLabelRES;
    }

    /**
     * 根据学号获取学生朋友圈列表优化
     * @param studengNO
     * @return
     */
    private List<StudentSocialFriendRES> listFriendsByStudentNo(String studengNO) {
        List<StudentSocialFriendRES> list = studentSocialFriendDAO.listFriendsByStudentNo(studengNO);
        for (StudentSocialFriendRES studentSocialFriendRES : list) {

            if(StringUtils.isNotEmpty(studentSocialFriendRES.getDorm()) &&
                    studentSocialFriendRES.getDorm().equals(studentSocialFriendRES.getFriendDorm())){
                studentSocialFriendRES.setFriendRelation(RelationSchoolCategoryEnum.RELATION_DORM.getName());
            } else if(StringUtils.isNotEmpty(studentSocialFriendRES.getClassName()) &&
                    studentSocialFriendRES.getClassName().equals(studentSocialFriendRES.getClassName())){
                studentSocialFriendRES.setFriendRelation(RelationSchoolCategoryEnum.RELATION_CLASS.getName());
            } else if(StringUtils.isNotEmpty(studentSocialFriendRES.getMajorCode()) &&
                    studentSocialFriendRES.getMajorCode().equals(studentSocialFriendRES.getMajorCode())){
                studentSocialFriendRES.setFriendRelation(RelationSchoolCategoryEnum.RELATION_MAJOR.getName());
            } else {
                studentSocialFriendRES.setFriendRelation(RelationSchoolCategoryEnum.RELATION_OTHER.getName());
            }
        }
        return list;
    }

    /**
     * 社交群体关系优化接口
     */
    @Override
    public Map<String, Object> listSocialRelation(StudentSocialFriendREQ studentSocialFriendREQ) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<StudentSocialFriend>  studentSocialFriends =
                studentSocialFriendDAO.listSociaFriend(studentSocialFriendREQ);
        List<StudentRelationDegree> relationList = new ArrayList<>();
        List<StudentSocialGroupRES> socialGroupList = new ArrayList<>();
        for (StudentSocialFriend studentSocialFriend : studentSocialFriends) {
            StudentRelationDegree relation = new StudentRelationDegree();
            StudentSocialGroupRES socialGroup = new StudentSocialGroupRES();
            relation.setStudentName(studentSocialFriend.getStudentName());
            relation.setStudentNo(studentSocialFriend.getStudentNo());
            relation.setRelationDegree(studentSocialFriend.getRelationDegree());

            socialGroup.setStudentName(studentSocialFriend.getStudentName());
            socialGroup.setStudentNo(studentSocialFriend.getStudentNo());
            socialGroup.setSocialNo(studentSocialFriend.getSocialNo());
            relationList.add(relation);
            if(!socialGroupList.contains(socialGroup)) {
                socialGroupList.add(socialGroup);
            }
        }
        resultMap.put("nodes", socialGroupList);
        resultMap.put("links", relationList);
        return resultMap;
    }

}
