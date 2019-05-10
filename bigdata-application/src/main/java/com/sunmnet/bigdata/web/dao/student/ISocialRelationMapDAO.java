package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.SocialRelationMap;

import java.util.List;
import java.util.Map;

public interface ISocialRelationMapDAO {

	/**
	 * 根据学号查询某个学生社交圈
	 * @param stuNo
	 * @return
	 */
	List<SocialRelationMap> listSocialRelationByStuNo(String stuNo);

	/**
	 * 社交群体关系查询
	 * @param map
	 * @return
	 */
	List<SocialRelationMap> listSocialRelation(Map<String, Object> map);
	
}