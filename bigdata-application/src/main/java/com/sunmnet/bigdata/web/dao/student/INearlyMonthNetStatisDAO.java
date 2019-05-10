package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.request.student.WholePortraitREQ;

import java.util.Map;

public interface INearlyMonthNetStatisDAO {

	/**
	 * 获得近七周的上网时长信息
	 * @param studentNo
	 * @return
	 */
	Map<String,Object> getNearly7WeekNetTimeStatis(String studentNo);

	/**
	 * 学生近一月上网时长统计
	 * @param map
	 * @return
	 */
	Map<String,Object> getNearlyMonthNetTimeStatis(Map<String, Object> map);

	/**
	 * 学生近一月上网时间段统计统计
	 * @param map
	 * @return
	 */
	Map<String,Object> getNearlyMonthNetSlotStatis(Map<String, Object> map);
	
	/**
	 * 查询月均上网时长统计
	 * @param studentNo
	 * @return
	 */
	Integer getMonthAverageNetTime(String studentNo);
	
	/**
	 * 获得最近一月上网日均上网时长
	 * @param wholePortraitREQ
	 * @return
	 */
	Double getNearlyMonthNetTimeAverage(WholePortraitREQ wholePortraitREQ);
	
	/**
	 * 获得上网健康度
	 * @param studentNo
	 * @return
	 */
	Double getNetHealthRate(String studentNo);
}