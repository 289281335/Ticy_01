package com.sunmnet.bigdata.web.service.student.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunmnet.bigdata.commons.model.PageResult;
import com.sunmnet.bigdata.web.dao.student.*;
import com.sunmnet.bigdata.web.model.entity.student.*;
import com.sunmnet.bigdata.web.model.entity.student.TruancyInfo;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.WholePortraitREQ;
import com.sunmnet.bigdata.web.model.response.student.WholePortraitRES;
import com.sunmnet.bigdata.web.service.student.IStudentInfoService;
import com.sunmnet.bigdata.web.service.student.IStudiesAnalysisService;
import com.sunmnet.bigdata.web.util.BusinessUtils;
import com.sunmnet.bigdata.web.util.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * 学业分析
 * @author
 *
 */
@Service
public class StudiesAnalysisServiceImpl implements IStudiesAnalysisService{

	@Resource
	private IStudentSchoolRecordDAO iStudentSchoolRecordDAO;
	
	@Resource
	private IStudentTruancyRecordDAO iStudentTruancyRecordDAO;
	
	@Resource
	private IStudentClassRecordDAO iStudentClassRecordDAO;
	
	@Resource
	private IStudentLearningLevelDAO iStudentLearningLevelDAO;
	
	@Resource
	private IStudentGradePredictionDAO iStudentGradePredictionDAO;
	
	@Resource
	private IStudentClassDetailDAO iStudentClassDetailDAO;
	
	@Resource
	private IStudentInfoService iStudentInfoService;
	
	@Resource
	private IStudentInfoDAO iStudentInfoDAO;
	
	/**
	 * 查询学生历史成绩
	 */
	@Override
	public Map<String, Object> getHistoryScore(String studentNo){
		Map<String, Object> map = new HashMap<String, Object>();
		//查询学生信息
		StudentInfo studentInfo = iStudentInfoDAO.getStudentByNo(studentNo);
		
		//查学生历史平均成绩
		List<Map<String, Object>> personList = iStudentSchoolRecordDAO.selectStudentSchoolRecordByStudentNo(studentNo);
		
		//查学生所在专业平均成绩
		List<Map<String, Object>> majorList = iStudentSchoolRecordDAO.selectStudentSchoolRecordByMajorCode(studentInfo.getMajorCode());
		
		map.put("personList", personList);
		map.put("majorList", dealMajorList(majorList, personList));
		return map;
	}
	
	/**
	 * 查询学生疑似逃课信息
	 */
	@Override
	public Map<String, Object> getTruancyInfo(String studentNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StudentTruancyRecord> list = iStudentTruancyRecordDAO.selectTruancyRecordByStudentNo(studentNo);
		
		//计算累计逃课次数
		long totalTimes = 0;
		List<TruancyInfo> truancyInfoList = new ArrayList<TruancyInfo>();
		if(list != null && !list.isEmpty()) {
			totalTimes = list.size();
			TruancyInfo truancyInfo = new TruancyInfo();
			for(StudentTruancyRecord studentTruancyRecord : list) {
				if(studentTruancyRecord.getCourseName().equals(truancyInfo.getCourseName())) {
					truancyInfo.setTruancyTimes(truancyInfo.getTruancyTimes() + 1);
					List<StudentTruancyRecord> recordList = truancyInfo.getRecordList();
					recordList.add(studentTruancyRecord);
					truancyInfo.setRecordList(recordList);
				}else {
					truancyInfo = new TruancyInfo();
					truancyInfo.setCourseName(studentTruancyRecord.getCourseName());
					truancyInfo.setTruancyTimes(1);
					List<StudentTruancyRecord> recordList = new ArrayList<StudentTruancyRecord>();
					recordList.add(studentTruancyRecord);
					truancyInfo.setRecordList(recordList);
					truancyInfoList.add(truancyInfo);
				}
			}
		}
		map.put("list", truancyInfoList);
		map.put("totalTruancyTimes", totalTimes);
		return map;
	}
	
	/**
	 * 查询学习相关标签
	 */
	@Override
	public Map<String, Object> getStudiesLabel(String studentNo){
		Map<String, Object> map = new HashMap<String, Object>();
		//查询学生信息
		StudentInfo studentInfo = iStudentInfoService.getStudentByNo(studentNo);
		
		//学习水平
		String learningLeveLable = this.calculateLearningLeveLable(studentInfo);
		
		//成绩稳定性
		String  scoreLable = "";
		//查询该学生所在专业的学生数量
		Integer count = iStudentSchoolRecordDAO.selectStudentCountByMajorCode(studentInfo.getMajorCode());
		//查询该学生在其专业的成绩排名
		Integer ranking = iStudentSchoolRecordDAO.selectStabilityRankingByStudentNoAndMajorCode(studentNo, studentInfo.getMajorCode());
		if(count != null && ranking != null) {
			double rate = (double)ranking/count;
			if(rate <= 0.1) {
				scoreLable = "成绩很稳定";
			}
			if(rate > 0.1 && rate <= 0.3) {
				scoreLable = "成绩较稳定";
			}
			if(rate > 0.3 && rate <= 0.7) {
				scoreLable = "成绩稳定性一般";
			}
			if(rate > 0.7 && rate <= 0.9) {
				scoreLable = "成绩较不稳定";
			}
			if(rate > 0.9 && rate <= 1) {
				scoreLable = "成绩不稳定";
			}
		}
		
		//上课纪律
		String classLable = "";
		List<StudentClassRecord> recordList = iStudentClassRecordDAO.selectClassRecordByStudentNo(studentNo, getFromDate(),
				DateUtils.dateToString(new Date(), "yyyy-MM"));
		if(recordList != null && !recordList.isEmpty()) {
			int badClassTimes = 0;
			int totalClassTimes = 0;
			for(StudentClassRecord record : recordList) {
				badClassTimes += record.getLateTimes() + record.getLeftTimes() + record.getTruancyTimes();
				totalClassTimes += record.getLateTimes() + record.getLeftTimes() + record.getTruancyTimes() + record.getNormalTimes();
			}
			if(totalClassTimes != 0) {
				classLable = calculateDiscipline(badClassTimes, totalClassTimes);
			}
		}
		
		//挂科次数
		String failLable = "";
		List<Map<String, Object>> schoolRecordList = iStudentSchoolRecordDAO.selectStudentSchoolRecordByStudentNo(studentNo);
		if(schoolRecordList != null && !schoolRecordList.isEmpty()) {
			int totalFailTimes = 0;
			for(Map<String, Object> failMap : schoolRecordList) {
				totalFailTimes += (int)failMap.get("failTimes");
			}
			
			if(totalFailTimes > 0) {
				failLable = "挂科" + totalFailTimes + "门";
			}else {
				failLable = "无挂科";
			}
		}
		
		//成绩预测
		String forecastLable = "";
		int failCount = iStudentGradePredictionDAO.selectFailCourseCount(studentNo);
		if(failCount > 0) {
			forecastLable = "有挂科风险";
		}

		//疑似逃课
		String truancyLable = "";
		List<StudentTruancyRecord> list = iStudentTruancyRecordDAO.selectTruancyRecordByStudentNo(studentNo);
		if(list != null && list.size() > 10) {
			truancyLable = "逃课王";
		}
		map.put("label",scoreLable + "," + learningLeveLable  + "," + classLable + "," + failLable + "," + forecastLable + "," + truancyLable);
		return map;
	}
	
	/**
	 * 查询学生到课率
	 */
	@Override
	public Map<String, Object> getClassRate(String studentNo, String queryType) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		//查询学生上课情况
		if("month".equals(queryType)) {
			List<Map<String, Object>> list = iStudentClassRecordDAO.selectClassRateByStudentNoAndMonth(studentNo, DateUtils.dateToString(DateUtils.addMonths(new Date(), -11), "yyyy-MM"),
					DateUtils.dateToString(new Date(), "yyyy-MM"));
			map.put("list", list);
		}else {
			List<Map<String, Object>> list = iStudentClassRecordDAO.selectClassRateByStudentNoAndTerm(studentNo);
			map.put("list", list);
		}
		return map;
	}
	
	/**
	 * 查询学生到课时间
	 */
	@Override
	public Map<String, Object> getClassTime(String studentNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		//查询学生上课情况
		Map<String, Object> timeMap = iStudentClassRecordDAO.selectClassTimeByStudentNo(studentNo, getFromDate(),
				DateUtils.dateToString(new Date(), "yyyy-MM"));
		map.put("timeRate", timeMap);
		return map;
	}
	
	/**
	 * 查询学生本学期考勤明细
	 */
	@Override
	public PageResult pageClassAttendanceDetail(String studentNo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		List<StudentClassDetail> list = iStudentClassDetailDAO.selectClassDetailByStudentNo(studentNo);
		Page<StudentClassDetail> count = (Page<StudentClassDetail>)list;
		
		return new PageResult(list, count.getTotal(), pageNum, pageSize);
	}
	
	/**
	 * 查询学生疑似逃课统计信息(整体画像)
	 */
	@Override
	public Map<String, Object> WholeTruancyTimesData(WholePortraitREQ wholePortraitREQ) {
		Map<String, Object> map = new HashMap<String, Object>();
		wholePortraitREQ.setStartDate(BusinessUtils.getStartDateBySchoolYear(wholePortraitREQ.getSchoolYear()));
		wholePortraitREQ.setEndDate(BusinessUtils.getEndDateBySchoolYear(wholePortraitREQ.getSchoolYear()));
		List<Map<String, Object>> list = iStudentTruancyRecordDAO.countTruancyByCondition(wholePortraitREQ);
		map.put("list", list);
		return map;
	}
	
	/**
	 * 查询疑似逃课学生信息(综合画像)
	 */
	@Override
	public PageResult pageWholeTruancyStudentData(WholePortraitREQ wholePortraitREQ, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		wholePortraitREQ.setStartDate(BusinessUtils.getStartDateBySchoolYear(wholePortraitREQ.getSchoolYear()));
		wholePortraitREQ.setEndDate(BusinessUtils.getEndDateBySchoolYear(wholePortraitREQ.getSchoolYear()));
		List<Map<String, Object>> list = iStudentTruancyRecordDAO.selectTruancyStudentByCondition(wholePortraitREQ);
		
		Page<Map<String, Object>> count = (Page<Map<String, Object>>)list;
		
		return new PageResult(list, count.getTotal(), pageNum, pageSize);
	}
	
	/**
	 * 查询学霸数量(综合画像)
	 */
	@Override
	public Integer countWholeHighGrades(StudentInfoREQ studentInfoREQ) {
		//查询总记录数
		Integer count = iStudentLearningLevelDAO.countLearningLevel();
		StudentConsumptionIndex four = iStudentLearningLevelDAO.selectStudentLearningLevelByLineNo(new BigDecimal(count * 0.9).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
		studentInfoREQ.setScoreIndex(four.getScoreIndex().toString());
		Integer highGradesCount = iStudentLearningLevelDAO.countLearningLevelByCondition(studentInfoREQ);
		return highGradesCount == null ? 0 : highGradesCount;
	}
	
	/**
	 * 查询挂科学生数量(综合画像)
	 */
	@Override
	public Integer countWholeFailGrades(WholePortraitREQ wholePortraitREQ){
		Integer count = iStudentSchoolRecordDAO.countFailGradesStudent(wholePortraitREQ);
		return count == null ? 0 : count;
	}
	
	/**
	 * 查询学习水平比率(综合画像)
	 */
	@Override
	public Map<String, Object> WholeLearningLevel(StudentInfoREQ studentInfoREQ) {
		Map<String, Object> map = new HashMap<String, Object>();
		//查询总记录数
		Integer count = iStudentLearningLevelDAO.countLearningLevel();
		StudentConsumptionIndex low = iStudentLearningLevelDAO.selectStudentLearningLevelByLineNo(new BigDecimal(count * 0.1).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
		StudentConsumptionIndex high = iStudentLearningLevelDAO.selectStudentLearningLevelByLineNo(new BigDecimal(count * 0.9).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
		
		//根据条件查询学生数量
		Integer studentCount = iStudentInfoDAO.countStudentInfo(studentInfoREQ);
		BigDecimal lowRate = new BigDecimal(0.2);
		BigDecimal highRate = new BigDecimal(0.2);
		if(studentCount > 0) {
			//查询学渣百分比
			studentInfoREQ.setScoreIndex(low.getScoreIndex().toString());
			Integer lowCount = iStudentLearningLevelDAO.countLearningLevelByCondition(studentInfoREQ);
			lowRate = new BigDecimal(1).subtract(new BigDecimal((double)lowCount/studentCount)).setScale(2, BigDecimal.ROUND_HALF_UP);
			//查询学霸百分比
			studentInfoREQ.setScoreIndex(high.getScoreIndex().toString());
			Integer highCount = iStudentLearningLevelDAO.countLearningLevelByCondition(studentInfoREQ);
			highRate = new BigDecimal((double)highCount/studentCount).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		
		map.put("lowRate", lowRate.toString());
		map.put("middleRate", new BigDecimal(1).subtract(lowRate).subtract(highRate).toString());
		map.put("highRate", highRate.toString());
		return map;
	}
	/**
	 * 获取学期开始日期
	 * @return
	 */
	private String getFromDate() {
		String fromDate = null;
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int year =  Calendar.getInstance().get(Calendar.YEAR);
		if(month <= 2) {
			fromDate = (year - 1) + "-" + "09";
		}
		
		if(month > 2 && month < 9) {
			fromDate = year + "-02";
		}
		
		if(month >= 9) {
			fromDate = year + "-09";
			
		}
		return fromDate;
	}

	/**
	 * 处理专业成绩列表
	 * @param majorList
	 * @param personList
	 */
	private List<Map<String, Object>> dealMajorList(List<Map<String, Object>> majorList, List<Map<String, Object>> personList) {
		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
		
		for(Map<String, Object> personMap : personList) {
			for(Map<String, Object> majorMap : majorList) {
				if(majorMap.get("schoolTerm") != null && ((String)majorMap.get("schoolTerm")).equals((String)personMap.get("schoolTerm"))) {
					retList.add(majorMap);
				}
			}
		}
		
		return retList;
	}
	
	/**
	 * 计算上课纪律性
	 * @param badTimes
	 * @param totalTimes
	 * @return
	 */
	private String calculateDiscipline(int badTimes, int totalTimes) {
		String retString = "";
		double result = new BigDecimal(1).subtract(new BigDecimal(badTimes).divide(new BigDecimal(totalTimes), 2, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100)).doubleValue();
		if(result <= 100 && result > 80) {
			retString = "上课纪律很好";
		}
		
		if(result <=80 && result > 60) {
			retString = "上课纪律良好";
		}
		
		if(result <=60 && result > 40) {
			retString = "上课纪律一般";
		}
		
		if(result <=40 && result > 20) {
			retString = "上课纪律较差";
		}
		
		if(result <=20 && result >= 0) {
			retString = "上课纪律很差";
		}
		return retString;
	}
	
	/**
	 * 计算学生学习水平标签
	 * @param
	 * @return
	 */
	private String calculateLearningLeveLable(StudentInfo studentInfo) {
		String retStr = "";
		//查询个人学习水平
		BigDecimal personLearningLevel = iStudentLearningLevelDAO.selectLearningLevelByStudentNo(studentInfo.getStudentNo());
		
		if(personLearningLevel == null || personLearningLevel.compareTo(new BigDecimal(0)) < 0) {
			//查询该学生所在专业的学生数量
			Integer count = iStudentSchoolRecordDAO.selectStudentCountByMajorCode(studentInfo.getMajorCode());
			//查询该学生在其专业的成绩排名
			Integer ranking = iStudentSchoolRecordDAO.selectScoreRankingByStudentNoAndMajorCode(studentInfo.getStudentNo(), studentInfo.getMajorCode());
			if(ranking != null) {
				double rate = (double)ranking/count;
				if(rate <= 0.1) {
					retStr = "学霸";
				}
				if(rate > 0.1 && rate <= 0.3) {
					retStr = "学习良好";
				}
				if(rate > 0.3 && rate <= 0.7) {
					retStr = "学习一般";
				}
				
				if(rate > 0.7 && rate <= 0.9) {
					retStr = "学习较差";
				}
				
				if(rate > 0.9 && rate <= 1) {
					retStr = "学渣";
				}
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
				retStr = "学渣";
			}
			
			if(personLearningLevel.compareTo(one.getScoreIndex()) >= 0 && personLearningLevel.compareTo(two.getScoreIndex()) < 0) {
				retStr = "学习较差";
			}
			
			if(personLearningLevel.compareTo(two.getScoreIndex()) >= 0 && personLearningLevel.compareTo(three.getScoreIndex()) < 0) {
				retStr = "学习一般";
			}
			
			if(personLearningLevel.compareTo(three.getScoreIndex()) >= 0 && personLearningLevel.compareTo(four.getScoreIndex()) < 0) {
				retStr = "学习良好";
			}
			
			if(personLearningLevel.compareTo(four.getScoreIndex()) >= 0 && personLearningLevel.compareTo(end.getScoreIndex()) <= 0) {
				retStr = "学霸";
			}
		}
		
		return retStr;
	}
}
