package com.sunmnet.bigdata.web.service.student;



import com.sunmnet.bigdata.web.model.entity.student.StudentConsumeRecord;
import com.sunmnet.bigdata.web.model.request.student.WholePortraitREQ;
import com.sunmnet.bigdata.web.model.response.student.WholePortraitRES;

import java.util.List;
import java.util.Map;

/**
 * 学生消费数据分析服务
 * @author
 *
 */
public interface IConsumeAnalysisService {

	/**
	 * 查询学生最近的就餐信息(三餐)
	 * @param studentNo
	 * @return
	 */
	public List<StudentConsumeRecord> listLatestDietSituation(String studentNo);
	
	/**
	 * 查询学生就餐地点信息(三餐)
	 * @param studentNo
	 * @return
	 */
	public Map<String, Object> getDietPlace(String studentNo);
	
	/**
	 * 查询学生三餐消费金额趋势信息(三餐)
	 * @param studentNo
	 * @return
	 */
	public Map<String, Object> getDietAmount(String studentNo);
	
	/**
	 * 查询学生三餐规律度(三餐)
	 * @param studentNo
	 * @return
	 */
	public Map<String, Object> getDietRegular(String studentNo);
	
	/**
	 * 查询学生平均每餐消费金额(贫困生)
	 * @param studentNo
	 * @return
	 */
	public Map<String, Object> getNeedyAverageDietData(String studentNo);
	
	/**
	 * 查询学生最近三月消费构成信息(消费)(贫困生)
	 * @param studentNo
	 * @return
	 */
	public Map<String, Object> getNeedyLatestConsumeStructure(String studentNo);
	
	/**
	 * 查询学生消费水平(贫困生)
	 * @param studentNo
	 * @return
	 */
	public Map<String, Object> getNeedyConsumeLevel(String studentNo);
	
	/**
	 * 查询月均金额消费趋势(贫困生)
	 * @param studentNo
	 * @return
	 */
	public Map<String, Object> getNeedyAverageConsumeAmountMonth(String studentNo);
	
	/**
	 * 查询学生全部消费地点信息(消费)
	 * @param studentNo
	 * @return
	 */
	public Map<String, Object> getAllConsumePlace(String studentNo);
	
	/**
	 * 查询学生消费金额趋势信息(消费)
	 * @param studentNo
	 * @return
	 */
	public Map<String, Object> getConsumeAmount(String studentNo);
	
	/**
	 * 查询消费指数(消费)
	 * @param studentNo
	 * @return
	 */
	public Map<String, Object> getConsumeIndex(String studentNo);
	
	/**
	 * 贫困生和非贫困生人均月消费金额
	 * @return
	 */
	public Map<String, Object> getNeedyAndGeneralAverageConsumeDataMonth();
	
	/**
	 * 贫困生和非贫困生人均每日三餐消费金额
	 * @return
	 */
	public Map<String, Object> getNeedyAndGeneralAverageDietDataDay();
	
	/**
	 * 贫困生和非贫困生人均每月三餐次数
	 * @return
	 */
	public Map<String, Object> countNeedyAndGeneralDietTimesMonth();
	
	/**
	 * 查询三餐标签
	 * @param studentNo
	 * @return
	 */
	public Map<String, Object> getDietLable(String studentNo);
	
	/**
	 * 查询消费标签
	 * @param studentNo
	 * @return
	 */
	public Map<String, Object> getConsumeLable(String studentNo);
	
	/**
	 * 平均月消费金额趋势(综合画像)
	 * @param wholePortraitREQ
	 * @return
	 */
	public Map<String, Object> getWholeAverageConsumeAmountMonth(WholePortraitREQ wholePortraitREQ);
	
	/**
	 * 三餐热门消费地点(综合画像)
	 * @param wholePortraitREQ
	 * @return
	 */
	public Map<String, Object> getWholeDietPlace(WholePortraitREQ wholePortraitREQ);
	
	/**
	 * 三餐就餐率(综合画像)
	 * @param wholePortraitREQ
	 * @return
	 */
	public Map<String, Object> getWholeDietRate(WholePortraitREQ wholePortraitREQ);
	
	/**
	 * 平均消费金额(综合画像)
	 * @param wholePortraitREQ
	 * @return
	 */
	public double getWholeAverageConsumeDate(WholePortraitREQ wholePortraitREQ);
	
	/**
	 * 三餐规律度百分比(综合画像)
	 * @param wholePortraitREQ
	 * @return
	 */
	public Map<String, Object> getWholeDietRegularRate(WholePortraitREQ wholePortraitREQ);
}
