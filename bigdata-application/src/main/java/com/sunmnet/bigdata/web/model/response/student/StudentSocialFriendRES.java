package com.sunmnet.bigdata.web.model.response.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentSocialFriend;

public class StudentSocialFriendRES extends StudentSocialFriend {

    private String friendRelation;

    public String getFriendRelation() {
        return friendRelation;
    }

    public void setFriendRelation(String friendRelation) {
        this.friendRelation = friendRelation;
    }
}
