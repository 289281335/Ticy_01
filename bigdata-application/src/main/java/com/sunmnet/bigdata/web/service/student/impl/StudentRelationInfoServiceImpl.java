package com.sunmnet.bigdata.web.service.student.impl;

import com.sunmnet.bigdata.web.dao.student.ISocialRelationMapDAO;
import com.sunmnet.bigdata.web.dao.student.IStudentRelationInfoDAO;
import com.sunmnet.bigdata.web.model.entity.student.SocialRelationMap;
import com.sunmnet.bigdata.web.model.enums.FriendsUniversalityValue;
import com.sunmnet.bigdata.web.model.enums.SocialConnectionsValue;
import com.sunmnet.bigdata.web.model.enums.SuperScholarFriendsValue;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;

import com.sunmnet.bigdata.web.model.entity.student.StudentRelation;
import com.sunmnet.bigdata.web.model.response.student.StudentSocialRES;
import com.sunmnet.bigdata.web.service.student.IStudentRelationInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentRelationInfoServiceImpl implements IStudentRelationInfoService {

	@Resource
	private IStudentRelationInfoDAO iStudentRelationInfoDAO;

	@Resource
	private ISocialRelationMapDAO iSocialRelationMapDAO;

	/**
	 * 根据学号查询学生社交圈
	 */
	@Override
	public Map<String,Object> getStudentSocialMap(String studentNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SocialRelationMap> list = getStudentSocialMapByStuNo(studentNo);
		if (list != null) {
			map.put("list", list);
			map.put("friendCount", list.size());
			BigDecimal rate = iStudentRelationInfoDAO.getFriendCountVSclassTotal(studentNo);
			if (rate != null) {
				map.put("rate", rate);
			}
		}
		return map;
	}

	/**
	 * 获得个人画像-综合画像个人选项卡社交信息
	 */
	@Override
	public Map<String,Object> studentCartRelationTag(String studentNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SocialRelationMap> socialRelationMapList = getStudentSocialMapByStuNo(studentNo);
		Integer dormFriendCount = 0;
		if (socialRelationMapList != null && socialRelationMapList.size() > 3) {
			if ("男".equals(socialRelationMapList.get(0).getGender())) {
				map.put("social", "社交王子");
			} else {
				map.put("social", "社交公主");
			}
		}
		if (socialRelationMapList != null && (socialRelationMapList.size() > 1 && socialRelationMapList.size() <= 3)) {
			map.put("social", "社交圈子中等");
		}
		if (socialRelationMapList != null && socialRelationMapList.size() <= 1) {
			map.put("social", "社交圈子小");
		}
		for (SocialRelationMap socialRelationMap : socialRelationMapList) {
			if ("宿舍".equals(socialRelationMap.getRelationDetail())) {
				dormFriendCount += 1;
			}
		}
		if (dormFriendCount >= 3) {
			map.put("drom", "宿舍关系非常好");
		}
		if (dormFriendCount >= 1 && dormFriendCount <= 2) {
			map.put("drom", "宿舍关系好");
		}
		if (dormFriendCount == 0) {
			map.put("drom", "宿舍边缘人物");
		}
		return map;
	}

	/**
	 * 根据学号获取学生朋友圈列表优化
	 * @param studentNo
	 * @return
	 */
	private List<SocialRelationMap> getStudentSocialMapByStuNo(String studentNo) {
		List<SocialRelationMap> list = iSocialRelationMapDAO.listSocialRelationByStuNo(studentNo);
		for (SocialRelationMap socialRelationMap : list) {
			String dorm = socialRelationMap.getDorm();
			String friendDorm = socialRelationMap.getFriendDorm();
			if (socialRelationMap.getMajorCode().equals(socialRelationMap.getFriendMajor())) {
				socialRelationMap.setRelationDetail("专业");
			}
			if (socialRelationMap.getClassName().equals(socialRelationMap.getFriendClassName())) {
				socialRelationMap.setRelationDetail("班级");
			}
			if ((dorm != null && friendDorm != null) && dorm.substring(0, dorm.length() - 1)
					.equals(friendDorm.substring(0, friendDorm.length() - 1))) {
				socialRelationMap.setRelationDetail("宿舍");
			}
			if (socialRelationMap.getRelationDetail() == null) {;;
				socialRelationMap.setRelationDetail("其他");
			}
		}
		return list;
	}

	/**
	 * 社交群体关系优化接口
	 */
	@Override
	public Map<String,Object> listSocialRelation(StudentInfoREQ studentInfoREQ){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String collegeCode = (studentInfoREQ.getCollegeCode() == null && studentInfoREQ.getAcademyName() == null) ? "0200" : studentInfoREQ.getCollegeCode();
		paramMap.put("collegeCode", collegeCode);
		paramMap.put("majorCode", studentInfoREQ.getMajorCode());
		paramMap.put("className", studentInfoREQ.getClassName());
		paramMap.put("grade", studentInfoREQ.getGraduatedSchool());
		paramMap.put("nation", studentInfoREQ.getNation());
		paramMap.put("gender", studentInfoREQ.getGender());
		paramMap.put("studentPlace", studentInfoREQ.getNativePlace());
		paramMap.put("academyName", studentInfoREQ.getAcademyName());
		List<StudentRelation> relationList = new ArrayList<StudentRelation>();
		List<StudentSocialRES> nodeList = new ArrayList<StudentSocialRES>();
		List<SocialRelationMap> socialList = iSocialRelationMapDAO.listSocialRelation(paramMap);
		for (SocialRelationMap domain : socialList) {
			StudentRelation relation = new StudentRelation();
			StudentSocialRES node = new StudentSocialRES();
			relation.setStuName(domain.getStudentName());
			relation.setFriendStuName(domain.getFriendName());
			relation.setRelationDegree(domain.getRelationDegree());
			node.setStuName(domain.getStudentName());
			node.setStuNo(domain.getStudentNo());
			node.setSocialNo(domain.getSocialNo());
			relationList.add(relation);
			if(!nodeList.contains(node)) {
				nodeList.add(node);
			}
		}
		resultMap.put("nodes", nodeList);
		resultMap.put("links", relationList);
		return resultMap;
	}

	/**
	 * 根据学号查询社交广泛性，学霸交友数，社交圈子标签
	 */
	@Override
	public Map<String,Object> getSocialFriendTagInfo(String studentNo) {
		Map<String,Object> map = new HashMap<String,Object>();
		Integer socialCount = iStudentRelationInfoDAO.countSocialsByStudentNo(studentNo);
		BigDecimal socialEntropyCount = iStudentRelationInfoDAO.getSocialEntropyByStudentNo(studentNo);
		Integer xbCount = iStudentRelationInfoDAO.countXBFriendsByStudentNo(studentNo);
		SocialConnectionsValue socialConnection = null;
		FriendsUniversalityValue friendsUniversality = null;
		SuperScholarFriendsValue superScholarFriendsValue = null;
		if(socialCount != null && socialCount != 0) {
			if(socialCount == 1) {
				socialConnection = SocialConnectionsValue.SJQZX;
			}
			if(socialCount == 2 ) {
				socialConnection = SocialConnectionsValue.CJBWD;
			}
			if(socialCount > 2 ) {
				socialConnection = SocialConnectionsValue.SJQZZD;
			}
		}else{
			socialConnection = SocialConnectionsValue.SJQZX;
		}
		if(socialEntropyCount != null) {
			if(socialEntropyCount.doubleValue() <= 2.12) {
				friendsUniversality = FriendsUniversalityValue.PYDY;
			}
			if(socialEntropyCount.doubleValue() > 2.12 && socialEntropyCount.doubleValue() < 3.5) {
				friendsUniversality = FriendsUniversalityValue.PYJGF;
			}
			if(socialEntropyCount.doubleValue() > 3.5) {
				friendsUniversality = FriendsUniversalityValue.PYGF;
			}
		}else {
			friendsUniversality = FriendsUniversalityValue.PYDY;
		}
		if(xbCount != null) {
			if(xbCount < 1) {
				superScholarFriendsValue = SuperScholarFriendsValue.WXBPY;
			}
			if(xbCount >= 1 && xbCount < 3) {
				superScholarFriendsValue = SuperScholarFriendsValue.XBPYJD;
			}
			if(xbCount >= 3 && xbCount < 5) {
				superScholarFriendsValue = SuperScholarFriendsValue.XBPYD;
			}
			if(xbCount >= 5) {
				superScholarFriendsValue = SuperScholarFriendsValue.XBQZW;
			}
		}else {
			superScholarFriendsValue = SuperScholarFriendsValue.WXBPY;
		}
		map.put("socialConnection", socialConnection);
		map.put("friendsUniversality", friendsUniversality);
		map.put("superScholarFriendsValue", superScholarFriendsValue);
		return map;
	}

}
