package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.SchoolLongitude;
import com.sunmnet.bigdata.web.model.entity.student.StudentInfo;
import com.sunmnet.bigdata.web.model.request.student.WholePortraitREQ;
import com.sunmnet.bigdata.web.model.response.student.WholePortraitRES;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface IStudentRelationInfoDAO {
	
	/**
	 * @param studentNo
	 * @return
	 */
	StudentInfo getStudentInfo(String studentNo);
	
	/**
	 * 根据学号获得宿舍地址信息
	 * @param studentNo
	 * @return
	 */
	List<SchoolLongitude> getNetTimeLocaltionbyStudentNo(String studentNo);
	
	/**
	 * 获得朋友数超过同专业人的百分比
	 * @param studentNo
	 * @return
	 */
	BigDecimal getFriendCountVSclassTotal(String studentNo);
	
	/**
	 * 群体整体画像-社交人数统计
	 * @param wholePortraitREQ
	 * @return
	 */
	Map<String,Object> countGroupTotal(WholePortraitREQ wholePortraitREQ);
	
	/**
	 * 获得男女生人数
	 * @param wholePortraitREQ
	 * @return
	 */
	Map<String,Object> countBoyAndGirl(WholePortraitREQ wholePortraitREQ);
	
	/**
	 * 根据学号统计学生社区号
	 * @param studentNo
	 * @return
	 */
	Integer countSocialsByStudentNo(String studentNo);
	
	/**
	 * 根据学号查询社交广泛度
	 * @param studentNo
	 * @return
	 */
	BigDecimal getSocialEntropyByStudentNo(String studentNo);
	
	/**
	 * 根据学号查询朋友中学霸数
	 * @param studentNo
	 * @return
	 */
	Integer countXBFriendsByStudentNo(String studentNo);
	
}