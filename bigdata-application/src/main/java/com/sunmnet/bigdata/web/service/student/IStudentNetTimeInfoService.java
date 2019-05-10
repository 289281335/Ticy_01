package com.sunmnet.bigdata.web.service.student;

import com.sunmnet.bigdata.web.exception.PlatformException;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface IStudentNetTimeInfoService {

	/**
	 * 个人画像-最近七上网时间
	 * @param studentNo
	 * @return
	 * @throws PlatformException
	 */
	public Map<String,Object> nearly7dayNetInfo(String studentNo);

	/**
	 * 获得个人画像-综合画像个人选项卡上网信息
	 * @return
	 */
	public Map<String,Object> studentCartNetTag(String studentNo);

	/**
	 * 获得综合画像近7周上网时长的分析
	 * @param studentNo
	 * @return
	 */
	public Map<String,Object> getNearly7WeekNetTimeAnalysisByStudentNo(String studentNo) throws ParseException ;

	/**
	 * 获得某段时间的天平均上网时长
	 * @param studentNo
	 * @param N
	 * @return
	 */
	public Double getNDaysNetTimeAverageDay(String studentNo, Integer N);

	/**
	 * 群体画像-上网时长分析
	 * @return
	 */
	public Map<String,Object> netTimeAnalyse(String collegeCode, String majorCode, String className, String nation,
                                             String gender, String studentPlace, String schoolYear, String academyName);

	/**
	 * 群体画像-上网时间段分析
	 * @param collegeCode
	 * @param majorCode
	 * @param className
	 * @param nation
	 * @param gender
	 * @param studentPlace
	 * @param schoolTerm
	 * @return
	 */
	public Map<String,Object> netTimeSlotAnalyse(String collegeCode, String majorCode, String className, String nation,
                                                 String gender, String studentPlace, String schoolTerm, String academyName);

	/**
	 * 查询特定时间段内学生的天平均上网时长
	 * @param collegeCode
	 * @param majorCode
	 * @param grade
	 * @param nation
	 * @param gender
	 * @param studentPlace
	 * @param schoolTerm
	 * @return
	 */
	public Double getTimeSlotAvgDayNetTime(String collegeCode, String majorCode, String className, String nation,
                                                String gender, String studentPlace, String schoolTerm, String academyName);
	
	/**
	 * 根据学号查询上网健康度
	 * @param studentNo
	 * @return
	 */
	public Map<String,Object> getNetHealthRatio(String studentNo);
	
	/**
	 * 获得近N天每天的上网时长
	 * @param studentNo
	 * @return
	 */
	public List<Map<String,Object>>  listNearlyNDaysNetTimeDay(String studentNo, Integer N);

}
