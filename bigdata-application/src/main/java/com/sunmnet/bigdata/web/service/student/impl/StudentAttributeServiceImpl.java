package com.sunmnet.bigdata.web.service.student.impl;


import com.sunmnet.bigdata.web.dao.student.*;
import com.sunmnet.bigdata.web.model.entity.student.StudentConsumptionIndex;
import com.sunmnet.bigdata.web.model.entity.student.StudentInfo;
import com.sunmnet.bigdata.web.model.enums.AchievementStatusValue;
import com.sunmnet.bigdata.web.model.enums.StudyLevelValue;
import com.sunmnet.bigdata.web.model.response.student.StudentClassRateRES;
import com.sunmnet.bigdata.web.model.response.student.StudentOnTimeRateRES;
import com.sunmnet.bigdata.web.model.response.student.StudentScoresRES;
import com.sunmnet.bigdata.web.service.student.IStudentAttributeService;
import com.sunmnet.bigdata.web.service.student.IStudentInfoService;
import com.sunmnet.bigdata.web.util.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * 成长推荐提供
 * @author niuliqiang
 *
 */
@Service
public class StudentAttributeServiceImpl implements IStudentAttributeService {
	
	@Resource
	private IStudentSchoolRecordDAO iStudentSchoolRecordDAO;
	@Resource
	private IStudentClassRecordDAO iStudentClassRecordDAO;
	@Resource
	private IStudentLearningLevelDAO iStudentLearningLevelDAO;
	@Resource
	private IStudentInfoDAO iStudentInfoDAO;
	
	@Resource
	private IStudentInfoService iStudentInfoService;
	/*@Resource
	private StudentRestMapper StudentRestMapper;
	*/
	/*@Resource
	private IStudentConsumeRegularDAO studentConsumeRegularMapper;
	*/
	/*@Resource
	private IStudentConsumeInfoDAO studentConsumeInfoMapper;
	*/
	@Resource
	private IStudentBookBorrowDAO iStudentBookBorrowDAO;

	/**
	 *查询分数
	 */
	public List<StudentScoresRES> getScoreData(String studentNo) {
		List<StudentScoresRES> list = new ArrayList<StudentScoresRES>();
		//查学生历史平均成绩
		List<Map<String, Object>> personList = iStudentSchoolRecordDAO.selectStudentSchoolRecordByStudentNo(studentNo);
		if(personList != null && !personList.isEmpty()) {
			for(Map<String, Object> map : personList) {
				StudentScoresRES studentScoresRES = new StudentScoresRES();
				studentScoresRES.setSchoolTerm((String)map.get("schoolTerm"));
				studentScoresRES.setAverageScore(((BigDecimal)map.get("averageScore")).toString());
				list.add(studentScoresRES);
			}
		}
		return list;
	}


	/**
	 * 查询到课率
	 */
	public List<StudentClassRateRES> getClassRate(String studentNo) {
		List<StudentClassRateRES> studentClassRateRESList = new ArrayList<StudentClassRateRES>();
		List<Map<String, Object>> personList = iStudentClassRecordDAO.selectClassRateByStudentNoAndTerm(studentNo);
		if(personList != null && !personList.isEmpty()) {
			for(Map<String, Object> map : personList) {
				StudentClassRateRES studentClassRateRES = new StudentClassRateRES();
				studentClassRateRES.setSchoolTerm((String)map.get("schoolTerm"));
				studentClassRateRES.setCourseRate(((BigDecimal)map.get("courseRate")).toString());
				studentClassRateRESList.add(studentClassRateRES);
			}
		}
		return studentClassRateRESList;
	}


	/**
	 * 查询 准点率
	 */
	public List<StudentOnTimeRateRES> getOnTimeRate(String studentNo) {
		List<StudentOnTimeRateRES> list = new ArrayList<StudentOnTimeRateRES>();
		List<Map<String, Object>> personList = iStudentClassRecordDAO.selectOnTimeRateByStudentNo(studentNo);
		if(personList != null && !personList.isEmpty()) {
			for(Map<String, Object> map : personList) {
				StudentOnTimeRateRES studentOnTimeRateRES = new StudentOnTimeRateRES();
				studentOnTimeRateRES.setSchoolTerm((String)map.get("schoolTerm"));
				studentOnTimeRateRES.setOnTimeRate(((BigDecimal)map.get("onTimeRate")).toString());
				list.add(studentOnTimeRateRES);
			}
		}
		return list;
	}


	/**
	 * 查询学习水平
	 */
	public StudyLevelValue getLearningLevel(String studentNo) {
		StudyLevelValue value = null;
		//查询学生信息
		StudentInfo studentInfo = iStudentInfoDAO.getStudentByNo(studentNo);
		//查询个人学习水平
		BigDecimal personLearningLevel = iStudentLearningLevelDAO.selectLearningLevelByStudentNo(studentNo);
		
		if(personLearningLevel == null || personLearningLevel.compareTo(new BigDecimal(0)) < 0) {
			//查询该学生所在专业的学生数量
			Integer count = iStudentSchoolRecordDAO.selectStudentCountByMajorCode(studentInfo.getMajorCode());
			//查询该学生在其专业的成绩排名
			Integer ranking = iStudentSchoolRecordDAO.selectScoreRankingByStudentNoAndMajorCode(studentNo, studentInfo.getMajorCode());
			double rate = (double)ranking/count;
			if(rate <= 0.1) {
				value = StudyLevelValue.XB;
			}
			if(rate > 0.1 && rate <= 0.3) {
				value = StudyLevelValue.XILH;
			}
			if(rate > 0.3 && rate <= 0.7) {
				value = StudyLevelValue.XIYB;
			}
			
			if(rate > 0.7 && rate <= 0.9) {
				value = StudyLevelValue.XIJC;
			}
			
			if(rate > 0.9 && rate <= 1) {
				value = StudyLevelValue.XZ;
			}
		}else {	
			//查询总记录数
			Integer count = iStudentLearningLevelDAO.countLearningLevel();
			StudentConsumptionIndex first = iStudentLearningLevelDAO.selectStudentLearningLevelByLineNo(0);
			StudentConsumptionIndex one = iStudentLearningLevelDAO.selectStudentLearningLevelByLineNo(new BigDecimal(count * 0.1).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
			StudentConsumptionIndex two = iStudentLearningLevelDAO.selectStudentLearningLevelByLineNo(new BigDecimal(count * 0.3).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
			StudentConsumptionIndex three = iStudentLearningLevelDAO.selectStudentLearningLevelByLineNo(new BigDecimal(count * 0.7).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
			StudentConsumptionIndex four = iStudentLearningLevelDAO.selectStudentLearningLevelByLineNo(new BigDecimal(count * 0.9).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
			StudentConsumptionIndex end = iStudentLearningLevelDAO.selectStudentLearningLevelByLineNo(count - 1);
			
			if(personLearningLevel.compareTo(first.getScoreIndex()) >= 0 && personLearningLevel.compareTo(one.getScoreIndex()) < 0) {
				value = StudyLevelValue.XZ;
			}
			
			if(personLearningLevel.compareTo(one.getScoreIndex()) >= 0 && personLearningLevel.compareTo(two.getScoreIndex()) < 0) {
				value = StudyLevelValue.XIJC;
			}
			
			if(personLearningLevel.compareTo(two.getScoreIndex()) >= 0 && personLearningLevel.compareTo(three.getScoreIndex()) < 0) {
				value = StudyLevelValue.XIYB;
			}
			
			if(personLearningLevel.compareTo(three.getScoreIndex()) >= 0 && personLearningLevel.compareTo(four.getScoreIndex()) < 0) {
				value = StudyLevelValue.XILH;
			}
			
			if(personLearningLevel.compareTo(four.getScoreIndex()) >= 0 && personLearningLevel.compareTo(end.getScoreIndex()) <= 0) {
				value = StudyLevelValue.XB;
			}
		}
		
		return value;
	}

	/**
	 * 查询学习稳定性
	 *  */
	public AchievementStatusValue getLearningStability(String studentNo) {
		AchievementStatusValue value = null;
		//查询学生信息
		StudentInfo info = iStudentInfoService.getStudentByNo(studentNo);
		//查询该学生所在专业的学生数量
		Integer count = iStudentSchoolRecordDAO.selectStudentCountByMajorCode(info.getMajorCode());
		//查询该学生在其专业的成绩排名
		Integer ranking = iStudentSchoolRecordDAO.selectStabilityRankingByStudentNoAndMajorCode(studentNo, info.getMajorCode());
		
		double rate = (double)ranking/count;
		if(rate <= 0.1) {
			value =AchievementStatusValue.CJHWD; 
		}
		if(rate > 0.1 && rate <= 0.3) {
			value = AchievementStatusValue.CJJWD;
		}
		if(rate > 0.3 && rate <= 0.7) {
			value = AchievementStatusValue.CJWDXYB;
		}
		if(rate > 0.7 && rate <= 0.9) {
			value = AchievementStatusValue.CJJBWD;
		}
		if(rate > 0.9 && rate <= 1) {
			value =AchievementStatusValue.CJBWD;
		}
		return value;
	}


	/**
	 * 查询外出标签

	public OutSituationValue getWeekOutLable(String studentN0) {
		OutSituationValue value = null;
		String weekOutIndex = StudentRestMapper.selectWeekOutIndex(studentNumber);
		if(StringUtils.isNotEmpty(weekOutIndex)) {
			double index = Double.valueOf(weekOutIndex);
			if(index >= 0.5 && index <= 0.75) {
				value = OutSituationValue.WCJHY;
			}
			
			if(index > 0.75) {
				value = OutSituationValue.WCHYX;
			}
			
			if(index < 0.5) {
				value = OutSituationValue.ZHAI;
			}			
		}
		
		return value;
	}
	 */

	/**
	 * 查询睡觉时长标签

	public SleepTimeValue getSleepTimeLable(String studentNo) {
		SleepTimeValue value = null;
		//查询日均睡眠时长
		BigDecimal sleepTime = StudentRestMapper.selectStudentAverageSleepTime(studentNumber);
		if(sleepTime != null) {
			if(sleepTime.doubleValue() >= 9) {
				value = SleepTimeValue.SS;
			}else if(sleepTime.doubleValue() < 9 && sleepTime.doubleValue() >= 8) {
				value = SleepTimeValue.SMCZ;
			}else if(sleepTime.doubleValue() < 8 && sleepTime.doubleValue() >= 6) {
				value = SleepTimeValue.SMCDBZ;
			}else if(sleepTime.doubleValue() < 6) {
				value = SleepTimeValue.SMYZBZ;
			}
		}
		return value;
	}
	 */

	/**
	 * 查询三餐规律度

	public ThreeMealsRegularityValue getDietRegularityLable(String studentNo) {
		ThreeMealsRegularityValue value = null;
		//查询个人三餐规律度
		BigDecimal personRegular = studentConsumeRegularMapper.selectDietRegularByStudentNumber(studentNumber);
		
		if(personRegular != null && personRegular.compareTo(new BigDecimal(0)) > 0) {
			//查询总记录数
			Integer count = studentConsumeRegularMapper.selectDietRegularCount();
			StudentConsumptionIndex first = studentConsumeRegularMapper.selectDietRegularByNumber(0);
			StudentConsumptionIndex one = studentConsumeRegularMapper.selectDietRegularByNumber(new BigDecimal(count * 0.1).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
			StudentConsumptionIndex two = studentConsumeRegularMapper.selectDietRegularByNumber(new BigDecimal(count * 0.3).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
			StudentConsumptionIndex three = studentConsumeRegularMapper.selectDietRegularByNumber(new BigDecimal(count * 0.7).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
			StudentConsumptionIndex four = studentConsumeRegularMapper.selectDietRegularByNumber(new BigDecimal(count * 0.9).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
			StudentConsumptionIndex end = studentConsumeRegularMapper.selectDietRegularByNumber(count - 1);
			
			if(personRegular.compareTo(first.getEatIndex()) >= 0 && personRegular.compareTo(one.getEatIndex()) < 0) {
				value = ThreeMealsRegularityValue.SCBGL;
			}
			
			if(personRegular.compareTo(one.getEatIndex()) >= 0 && personRegular.compareTo(two.getEatIndex()) < 0) {
				value = ThreeMealsRegularityValue.SCJBGL;
			}
			
			if(personRegular.compareTo(two.getEatIndex()) >= 0 && personRegular.compareTo(three.getEatIndex()) < 0) {
				value = ThreeMealsRegularityValue.SCGLYB;
			}
			
			if(personRegular.compareTo(three.getEatIndex()) >= 0 && personRegular.compareTo(four.getEatIndex()) < 0) {
				value = ThreeMealsRegularityValue.SCJGL;
			}
			
			if(personRegular.compareTo(four.getEatIndex()) >= 0 && personRegular.compareTo(end.getEatIndex()) <= 0) {
				value = ThreeMealsRegularityValue.SCHGL;
			}
		}
		return value;
	}
	 */

	/**
	 * 查询睡眠情况

	public SleepSituationValue getSleepSituationLable(String studentNo) {
		SleepSituationValue value = null;
		//查询学生信息
		StringBuffer sleepSitLable = new StringBuffer();
		//查询早睡次数
		Integer sleepEarlyTimes = StudentRestMapper.selectSleepEarlyTimes(studentNumber);
		//查询晚睡次数
		Integer sleepLateimes = StudentRestMapper.selectSleepLateTimes(studentNumber);
		//查询早起次数
		Integer getupEarlyTimes = StudentRestMapper.selectGetupEarlyTimes(studentNumber);
		//查询晚期次数
		Integer getupLateTimes = StudentRestMapper.selectGetupLateTimes(studentNumber);
		if(sleepEarlyTimes > 0 || sleepLateimes > 0) {
			if(sleepEarlyTimes >= sleepLateimes) {
				sleepSitLable.append("早睡");
			}else {
				sleepSitLable.append("晚睡");
			}
		}
		if(getupEarlyTimes > 0 || getupLateTimes > 0) {
			if(getupEarlyTimes >= getupLateTimes) {
				sleepSitLable.append("早起");
			}else {
				sleepSitLable.append("晚起");
			}
		}
		
		if(StringUtils.isNotEmpty(sleepSitLable)) {
			if(sleepSitLable.equals(SleepSituationValue.WSWQ.getName())) {
				value = SleepSituationValue.WSWQ;
			}
			if(sleepSitLable.equals(SleepSituationValue.WSZQ.getName())) {
				value = SleepSituationValue.WSZQ;
			}
			if(sleepSitLable.equals(SleepSituationValue.ZSWQ.getName())) {
				value = SleepSituationValue.ZSWQ;
			}
			if(sleepSitLable.equals(SleepSituationValue.ZSZQ.getName())) {
				value = SleepSituationValue.ZSZQ;
			}
		}
		
		return value;
	}
	 */

	/**
	 * 查询早餐情况

	public BreakfastSituationValue getBreakfastSituationLable(String studentNo) {
		BreakfastSituationValue value = null;
		//查询全校消费月份列表
		ArrayList<String> monthList  = this.parseToMonthList(studentConsumeInfoMapper.selectSchoolDietMonthList());
		//查询学生早餐和夜宵次数
		List<Map<String, Object>> list = studentConsumeInfoMapper.selectBreakfastCountAndSupperCount(studentNumber, monthList.get(1));

		if(list != null && !list.isEmpty()) {
			int planTimes = 0;
			int actualTimes = 0;
			for(Map<String, Object> map : list) {
				String consumeDate = (String)map.get("consumeDate");
				String month = consumeDate.substring(consumeDate.indexOf("-")+1);
				if(month.equals("03") || month.equals("04") || month.equals("05") || month.equals("06") ||
					month.equals("09") || month.equals("10") || month.equals("11") || month.equals("12")) {
					planTimes += 30;
					actualTimes += ((BigDecimal)map.get("breakfastCount")).intValue();
				}
				
				if(month.equals("01") || month.equals("02")) {
					planTimes += 15;
					actualTimes += ((BigDecimal)map.get("breakfastCount")).intValue();
				}
			}

			double result = (double)actualTimes/planTimes;
			if(result >= 0.71) {
				value = BreakfastSituationValue.ZCGL;
			}
			
			if(result < 0.71 && result >= 0.31) {
				value = BreakfastSituationValue.ZCGLDYB;
			}
			
			if(result < 0.31 && result >= 0.1) {
				value = BreakfastSituationValue.BACZC;
			}
			if(result < 0.1) {
				value = BreakfastSituationValue.ZCJYZ;
			}
		}
		
		return value;
	}
	 */
	
	/**
	 * 查询图书借阅数量
	 */
	public Integer CountBookBorrow(String studentNo) {
		Integer count = iStudentBookBorrowDAO.countBorrowByStudentNo(studentNo);
		return count == null ? 0 : count;
	}


	/**
	 * 转换成年月列表
	 * @param list
	 * @return

	private ArrayList<String> parseToMonthList(Map<String, Object> map) {
		ArrayList<String> retList = new ArrayList<String>();
		
		Calendar maxDate = Calendar.getInstance();  
		maxDate.setTime(DateUtils.parseDate((String)map.get("maxDate"), "yyyy-MM"));
		Calendar minDate = Calendar.getInstance();  
		minDate.setTime(DateUtils.parseDate((String)map.get("minDate"), "yyyy-MM"));
		
		retList.add(DateUtils.dateToString(maxDate.getTime(), "yyyy-MM"));
		while(maxDate.compareTo(minDate) > 0) {
			maxDate.add(Calendar.MONTH, -1);
			retList.add(DateUtils.dateToString(maxDate.getTime(), "yyyy-MM"));
		}

		return retList;
	}
	 */

}
