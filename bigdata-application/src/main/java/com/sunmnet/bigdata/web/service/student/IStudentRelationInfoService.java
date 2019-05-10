package com.sunmnet.bigdata.web.service.student;

import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;

import java.util.Map;

public interface IStudentRelationInfoService {

	/**
	 * 根据学号查询学生社交圈
	 * @param studentNo
	 * @return
	 */
	Map<String,Object> getStudentSocialMap(String studentNo);

	/**
	 * 获得个人画像-综合画像个人选项卡社交信息
	 * @param studentNo
	 * @return
	 */
	Map<String,Object> studentCartRelationTag(String studentNo);

	/**
	 * 社交群体关系优化接口
	 * @return
	 */
	Map<String,Object> listSocialRelation(StudentInfoREQ studentInfoREQ);
	
	/**
	 * 根据学号查询社交广泛性，学霸交友数，社交圈子标签
	 * @param studentNo
	 * @return
	 */
	Map<String,Object> getSocialFriendTagInfo(String studentNo);

}
