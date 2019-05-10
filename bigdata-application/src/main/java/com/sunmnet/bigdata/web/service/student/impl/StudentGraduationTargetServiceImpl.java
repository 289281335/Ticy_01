package com.sunmnet.bigdata.web.service.student.impl;

import com.sunmnet.bigdata.commons.model.JsonResult;
import com.sunmnet.bigdata.web.dao.student.*;
import com.sunmnet.bigdata.web.model.entity.student.*;
import com.sunmnet.bigdata.web.model.enums.*;
import com.sunmnet.bigdata.web.model.request.student.StudentGraduationTargetREQ;
import com.sunmnet.bigdata.web.model.response.student.*;
import com.sunmnet.bigdata.web.service.student.*;
import com.sunmnet.bigdata.web.util.DateUtils;
import com.sunmnet.bigdata.web.util.MathUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * 学生成长目标信息
 * @author wm
 */
@Service
public class StudentGraduationTargetServiceImpl implements IStudentGraduationTargetService {
	private static final Logger logger = LoggerFactory.getLogger(StudentGraduationTargetServiceImpl.class);
	@Resource
	private IStudentGraduationTargetDAO iStudentGraduationTargetDAO;
	@Resource
	private IStudentGraduateInfoDAO iStudentGraduateInfoDAO;
	@Resource
	private IStudentGraduatLabelInfoDAO iStudentGraduatLabelInfoDAO;
	@Resource
	private IStudentStatisticsLabelInfoDAO iStudentStatisticsLabelInfoDAO;
	@Resource
	private IStudentIndexDisplayInfoDAO iStudentIndexDisplayInfoDAO;
	@Resource
	private IStudentGraduateIndexInfoDAO iStudentGraduateIndexInfoDAO;
	@Resource
	private IStudentAttributeService iStudentAttributeService;
	@Resource
	private IStudiesAnalysisService iStudiesAnalysisService;
	@Resource
	private IStudentExtracurrCreditsService iStudentExtracurrCreditsService;
	@Resource
	private IStudentAwardService iStudentAwardService;
	@Resource
	private IStudentRelationInfoService iStudentRelationInfoService;
	@Resource
	private IStudentRestService iStudentRestService;
	@Resource
	private IConsumeAnalysisService iConsumeAnalysisService;
	@Resource
	private IStudentNetTimeInfoService iStudentNetTimeInfoService;
	@Resource
	private IStudentInfoDAO iStudentInfoDAO;
	@Resource
	private  IStudentReadSchoolInfoDAO iStudentReadSchoolInfoDAO;
	@Resource
	private  IStudentPositionTypeInfoDAO iStudentPositionTypeInfoDAO;
	@Resource
	private  IStudentIndustryTypeInfoDAO iStudentIndustryTypeInfoDAO;


	/**
	 * 学生成长目标信息保存
	 * @return
	 */
	@Override
	@Transactional
	public JsonResult saveArgetInfo(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ){
		JsonResult result = new JsonResult();
		logger.info("学生成长目标信息保存入参:StudentNo:"+ studentGraduationTargetREQ.getStudentNo()+"argetType:"+ studentGraduationTargetREQ.getArgetType()+
					"schoolCode:"+ studentGraduationTargetREQ.getSchoolCode()+"industryCode:"+ studentGraduationTargetREQ.getIndustryCode()+"positionCode:"+ studentGraduationTargetREQ.getPositionCode());
		String nowTime = DateUtils.getDateAndTimes();
		StudentGraduationTarget studentGraduationTarget = new StudentGraduationTarget();
		studentGraduationTarget.setArgetType(studentGraduationTargetREQ.getArgetType().getValue());
		studentGraduationTarget.setStudentNo(studentGraduationTargetREQ.getStudentNo());
		StudentGraduationTarget studentGraduationTargetCheck = iStudentGraduationTargetDAO.getStudentArgetInfoByStudentNo(studentGraduationTargetREQ.getStudentNo());
		if(studentGraduationTargetCheck ==null){//判断学生有没有设置过成长目标设置更新，没有添加
			studentGraduationTarget.setCreateTime(nowTime);
			if(iStudentGraduationTargetDAO.insertSelective(studentGraduationTarget)!=1){
				logger.info("学生成长目标信息保存失败:"+ studentGraduationTarget.toString());
				result.getErrorCode();
				result.setMsg("学生成长目标保存失败");
				return result;
			}
		}else{
			studentGraduationTarget.setId(studentGraduationTargetCheck.getId());
			studentGraduationTarget.setModifyTime(nowTime);
			if(iStudentGraduationTargetDAO.updateByPrimaryKeySelective(studentGraduationTarget)!=1){
				logger.info("学生成长目标信息修改失败:"+ studentGraduationTarget.toString());
				result.getErrorCode();
				result.setMsg("学生成长目标修改失败");
				return result;
			}
		}

		if(studentGraduationTargetCheck !=null){//修改前删除原有的目标标签，根据序学号
			iStudentGraduationTargetDAO.deleteByStudentNo(studentGraduationTarget.getStudentNo());
		}
		if(ArgetType.READ.equals(studentGraduationTarget.getArgetType())){
			//读研
			String [] schoolCodeArray = studentGraduationTargetREQ.getSchoolCode().split("#");
			for(int i = 0,j=schoolCodeArray.length; i < j; i++){
				StudentGraduationTarget studentGraduationTargetRead =  new StudentGraduationTarget();
				studentGraduationTargetRead.setStudentNo(studentGraduationTargetREQ.getStudentNo());
				studentGraduationTargetRead.setSchoolCode(schoolCodeArray[i]);
				studentGraduationTargetRead.setCreateTime(nowTime);
				iStudentGraduationTargetDAO.insertSelective(studentGraduationTargetRead);
			}
		}else if(ArgetType.WORK.equals(studentGraduationTarget.getArgetType())){
			//就业
			String [] positionCodeArray = studentGraduationTargetREQ.getPositionCode().split("#");
			for(int i = 0,j=positionCodeArray.length; i < j; i++){
				StudentGraduationTarget studentGraduationTargetWork = new StudentGraduationTarget();
				studentGraduationTargetWork.setStudentNo(studentGraduationTarget.getStudentNo());
				studentGraduationTargetWork.setIndustryCode(studentGraduationTarget.getIndustryCode());
				studentGraduationTargetWork.setPositionCode(positionCodeArray[i]);
				studentGraduationTargetWork.setCreateTime(nowTime);
				iStudentGraduationTargetDAO.insertSelective(studentGraduationTargetWork);
			}
		}
		result.getSuccess();
		return result;
	}


	/**
	 * 根据学号查询学生有没有设置成长目标
	 * @return
	 */
	@Override
	public String isArget(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ) {
		StudentGraduationTarget studentGraduationTarget = iStudentGraduationTargetDAO.getStudentArgetInfoByStudentNo(studentGraduationTargetREQ.getStudentNo());
		ArgetStatus argetStatus = ArgetStatus.NO;//默认未设置
		if(studentGraduationTarget !=null){
			argetStatus = ArgetStatus.YES;//已设置
		}
		return argetStatus.getValue();
	}

	/**
	 * 根据学号查询学生成长目标信息
	 * @return
	 */
	@Override
	public JsonResult getArgetInfo(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ){
		JsonResult result = new JsonResult();
		logger.info("查询学生成长目标信息入参:"+ studentGraduationTargetREQ.getStudentNo());
		StudentGraduationTarget studentGraduationTarget = iStudentGraduationTargetDAO.getStudentArgetInfoByStudentNo(studentGraduationTargetREQ.getStudentNo());
		if(studentGraduationTarget ==null){
			logger.info("查询学生成长目标信息,未设置成长目标，学号:"+ studentGraduationTargetREQ.getStudentNo());
			result.getErrorCode();
			result.setMsg("未设置成长目标");
			return result;
		}
	    String argetType = studentGraduationTarget.getArgetType();//目标分类   读研 READ   就业 WORK
	    StudentGraduationTargetRES studentGraduationTargetRES = new StudentGraduationTargetRES();
	    studentGraduationTargetRES.setStudentNo(studentGraduationTargetREQ.getStudentNo());
	    if(ArgetType.READ.getValue().equals(studentGraduationTargetREQ.getArgetType())){
			//读研
	    	studentGraduationTargetRES.setArgetType(ArgetType.READ);
	    	List<String> schoolCode = iStudentGraduationTargetDAO.getStudentArgetReadInfoByStudentNo(studentGraduationTargetREQ.getStudentNo());
	    	studentGraduationTargetRES.setSchoolCode(schoolCode);
		}else if(ArgetType.WORK.getValue().equals(argetType)){
			//就业
			studentGraduationTargetRES.setArgetType(ArgetType.WORK);
			List<String> argetWorkInfo = new ArrayList<String>();//行业编码#职业编码
			List<StudentGraduationTarget> list = iStudentGraduationTargetDAO.listStudentArgetInfoByStudentNo(studentGraduationTargetREQ.getStudentNo());

			String  industryCode ="";
			for(StudentGraduationTarget tempStudentGraduationTarget :list){
				String positionCode = tempStudentGraduationTarget.getPositionCode();
				argetWorkInfo.add(positionCode);
				industryCode = tempStudentGraduationTarget.getIndustryCode();
			}
			studentGraduationTargetRES.setIndustryCode(industryCode);
			studentGraduationTargetRES.setPositionCode(argetWorkInfo);
		}else{
			//其他
			logger.info("查询学生成长目标信息,无此目标分类，学号:"+ studentGraduationTargetREQ.getStudentNo());
			result.getErrorCode();
			result.setMsg("成长目标目标分类错误");
			return result;
		}
	    result.setObj(studentGraduationTargetRES);
		result.getSuccess();
		return result;
	}

	/**
	 * 学生成长设置成长目标群体标签统计
	 * @return
	 * @throws Exception
	 */
	@Override
	public JsonResult countGroupLabel(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ) throws Exception{
		logger.info("学生成长设置成长目标群体标签统计入参:"+ studentGraduationTargetREQ.getStudentNo());
		JsonResult result = new JsonResult();
		//1、查询学生有没有设置成长目标
		StudentGraduationTarget studentGraduationTarget = iStudentGraduationTargetDAO.getStudentArgetInfoByStudentNo(studentGraduationTargetREQ.getStudentNo());
		if(studentGraduationTarget ==null){
			logger.info("学生成长设置成长目标群体标签统计,未设置成长目标，学号:"+ studentGraduationTargetREQ.getStudentNo());
			result.getErrorCode();
			result.setMsg("未设置成长目标");
			return result;
		}
		//2、获取和自己设置相同目标的师哥师姐学号
		String argetType = studentGraduationTarget.getArgetType();
		List<String> StudentNoList = getStudentNoList(argetType, studentGraduationTargetREQ.getStudentNo());
		if(StudentNoList.size()<=0){
			logger.info("学生成长设置成长目标群体标签统计,未查询到学长学号，学号:"+studentGraduationTargetREQ.getStudentNo());
			result.getErrorCode();
			result.setMsg("没有与设置的目标相同的学长");
			return result;
		}
		//3、遍历师哥师姐的所有标签，统计标签的数量
		List<LabelPercentage> labelPercentageList = getLabelPercentage(StudentNoList);
		result.setObj(labelPercentageList);
		result.getSuccess();
		return result;
	}


	/**
	 *遍历师哥师姐的所有标签，统计标签的数量
	 * @param StudentNoList  学号
	 * @return
	 * @throws Exception
	 */
	public List<LabelPercentage> getLabelPercentage(List<String> StudentNoList) throws Exception {
		List<LabelPercentage> labelPercentageList = new ArrayList<LabelPercentage>();
		//查询学生的标签
		List<StudentGraduatLabelInfo> graduatLabelInfoList = iStudentGraduatLabelInfoDAO.getGraduatLabelInfo(StudentNoList);
		//查询要统计的标签
		List<StudentStatisticsLabelInfo> statisticsLabelInfoList = iStudentStatisticsLabelInfoDAO.queryByStatusForYes();
		int total = StudentNoList.size();//总人数
		for(StudentStatisticsLabelInfo studentStatisticsLabelInfo: statisticsLabelInfoList){//循环要统计的标签
			String label = studentStatisticsLabelInfo.getLabel();
			String labelField = studentStatisticsLabelInfo.getLabelField();
			int count = 0;
			for(StudentGraduatLabelInfo studentGraduatLabelInfo:graduatLabelInfoList){//循环学生
				String labelValue = (String) MathUtils.getFieldValueForFieldName(labelField,studentGraduatLabelInfo);
				if(label.equals(labelValue)){
					count++;
				}
			}
			double percentage = (double)count/total*100;
			LabelPercentage labelPercentage = new LabelPercentage();
			labelPercentage.setLabel(label);
			labelPercentage.setPercentage(String.format("%.2f", percentage ));
			labelPercentageList.add(labelPercentage);
		}
		Collections.sort(labelPercentageList,Collections.reverseOrder());//按照字段percentage排序
		logger.info("学生成长设置成长目标群体标签统计返回信息:"+labelPercentageList.toString());
		if(labelPercentageList.size()>16){//取前16个
			labelPercentageList = labelPercentageList.subList(0, 16);
		}
		return labelPercentageList;
	}

	/**
	 * 获取和自己设置相同目标的师哥师姐学号
	 * @param argetType  成长目标分类
	 * @param StudentNo  学号
	 * @return
	 */
	public List<String> getStudentNoList(String argetType,String StudentNo) {
		List<String> StudentNoList = new ArrayList<String>();
		//拿到年和月   9月后就有当年毕业的学生，之前没有当年毕业学生
		int year = Integer.parseInt(DateUtils.getYear());
		int month = Integer.parseInt(DateUtils.getMonth());
		List<String> yearParam  = new ArrayList<String>();
		if(month>=9){
			yearParam.add(year+"");
			yearParam.add(year-1+"");
			yearParam.add(year-2+"");
		}else{
			yearParam.add(year-1+"");
			yearParam.add(year-2+"");
			yearParam.add(year-3+"");
		}
		if(ArgetType.READ.getValue().equals(argetType)){//目标分类   读研 READ   就业 WORK
				Map<String, Object> param = new HashMap<String ,Object>();
				param.put("StudentNo", StudentNo);
				param.put("graduationDate", yearParam);
				StudentNoList = iStudentGraduateInfoDAO.getReadStudentNo(param);
		}else{
				Map<String, Object> param = new HashMap<String ,Object>();
				param.put("StudentNo", StudentNo);
				param.put("graduationDate", yearParam);
				StudentNoList = iStudentGraduateInfoDAO.getWorkStudentNo(param);
		}
		return StudentNoList;
	}

	/**
	 *  学生成长设置成长目优秀样本展示
	 * @return
	 */
	public JsonResult listExcellentSample(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ)throws Exception {
		logger.info("学生成长设置成长目优秀样本展示入参:"+studentGraduationTargetREQ.getStudentNo());
		JsonResult result = new JsonResult();
		//1、查询学生有没有设置成长目标
		StudentGraduationTarget studentGraduationTarget = iStudentGraduationTargetDAO.getStudentArgetInfoByStudentNo(studentGraduationTargetREQ.getStudentNo());
		if(studentGraduationTarget ==null){
			logger.info("学生成长设置成长目优秀样本展示,未设置成长目标，学号:"+studentGraduationTargetREQ.getStudentNo());
			result.getErrorCode();
			result.setMsg("未设置成长目标");
			return result;
		}
		//2、获取和自己设置相同目标的师哥师姐学号
		String argetType = studentGraduationTarget.getArgetType();
		List<String> StudentNoList = getStudentNoList(argetType, studentGraduationTargetREQ.getStudentNo());
		if(StudentNoList.size()<=0){
			logger.info("学生成长设置成长目优秀样本展示,未查询到学长学号，学号:"+studentGraduationTargetREQ.getStudentNo());
			result.getErrorCode();
			result.setMsg("没有与设置的目标相同的学长");
			return result;
		}
		//3、获取优秀样本
		List<ExcellentSample> excellentSampleList = getExcellentSample(StudentNoList);
		result.setObj(excellentSampleList);
		result.getSuccess();
		return result;
	}

	/**
	 * 获取优秀样本
	 * @param StudentNoList  学号
	 * @return
	 */
	public List<ExcellentSample> getExcellentSample(List<String> StudentNoList) {
		//根据学号查询学生指标值
		List<StudentGraduateIndexInfo> graduateIndexInfoList = iStudentGraduateIndexInfoDAO.getGraduateIndexInfoTopThree(StudentNoList);
		List<ExcellentSample> excellentSampleList = new ArrayList<ExcellentSample>();
		for(StudentGraduateIndexInfo studentGraduateIndexInfo:graduateIndexInfoList){
			String StudentNo = studentGraduateIndexInfo.getStudentNo();
			//查询学生标签信息
	    	StudentGraduatLabelInfo graduatLabelInfo = iStudentGraduatLabelInfoDAO.getByStudentNo(StudentNo);
			ExcellentSample excellentSample = new ExcellentSample();
			excellentSample.setAverageAchievement(studentGraduateIndexInfo.getAverageAchievement());//平均成绩
			//学习水平
			excellentSample.setStudyLevel(graduatLabelInfo.getStudyLevel());
		    //学习稳定性
			excellentSample.setAchievementStatus(graduatLabelInfo.getAchievementStatus());
		    //到课率
			excellentSample.setToClassRate(studentGraduateIndexInfo.getToClassRate());
		    //准点率
			excellentSample.setPunctualityRate(studentGraduateIndexInfo.getPunctualityRate());
		    //奖励总数量
			excellentSample.setRewards(studentGraduateIndexInfo.getRewards());
		    //国家级奖励总数量
			excellentSample.setCountryRewards(studentGraduateIndexInfo.getCountryRewards());
		    //省级奖励总数量
			excellentSample.setProvinceRewards(studentGraduateIndexInfo.getProvinceRewards());
		    //校级奖励总数量
			excellentSample.setSchoolRewards(studentGraduateIndexInfo.getSchoolRewards());
		    //竞赛数量
			excellentSample.setCompetition(studentGraduateIndexInfo.getCompetition());
		    //参与活动
			excellentSample.setActivity(studentGraduateIndexInfo.getActivity());
		    //图书借阅数量
			excellentSample.setBorrowBook(studentGraduateIndexInfo.getBorrowBook());
		    //社交关系
			excellentSample.setSocialConnections(graduatLabelInfo.getOverallSituation());
		    //朋友广泛性
			excellentSample.setFriendsUniversality(graduatLabelInfo.getFriendsUniversality());
		    //宿舍关系情况
			excellentSample.setDormitoryRelationship(graduatLabelInfo.getDormitoryRelationship());
		    //学霸交友数
			excellentSample.setSuperScholarFriends(graduatLabelInfo.getSuperScholarFriends());
		    //作息规律度
			excellentSample.setWorkRestRegularity(graduatLabelInfo.getWorkRestRegularity());
		    // 睡眠起床情况
			excellentSample.setSleepSituation(graduatLabelInfo.getSleepSituation());
		    //平均睡眠时长
			excellentSample.setSleepTime(graduatLabelInfo.getSleepTime());
		    //外出情况
			excellentSample.setOutSituation(graduatLabelInfo.getOutSituation());
		    //三餐规律度
			excellentSample.setThreeMealsRegularity(graduatLabelInfo.getThreeMealsRegularity());
		    //早餐就餐率
			excellentSample.setBreakfastSituation(graduatLabelInfo.getBreakfastSituation());
		    //上网健康度
			excellentSample.setInternetHealth(graduatLabelInfo.getInternetHealth());
			excellentSampleList.add(excellentSample);
		}
		return excellentSampleList;
	}

	/**
	 * 学生成长设置成长目群体平均展示
	 * @return
	 */
	@Override
	public JsonResult getGroupAverage(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ){
		logger.info("学生成长设置成长目群体平均展示入参:"+studentGraduationTargetREQ.getStudentNo());
		JsonResult result = new JsonResult();
		//1、查询学生有没有设置成长目标
		StudentGraduationTarget studentGraduationTarget = iStudentGraduationTargetDAO.getStudentArgetInfoByStudentNo(studentGraduationTargetREQ.getStudentNo());
		if(studentGraduationTarget ==null){
			logger.info("学生成长设置成长目群体平均展示,未设置成长目标，学号:"+studentGraduationTargetREQ.getStudentNo());
			result.getErrorCode();
			result.setMsg("未设置成长目标");
			return result;
		}
		//2、获取和自己设置相同目标的师哥师姐学号
		String argetType = studentGraduationTarget.getArgetType();
		List<String> StudentNoList = getStudentNoList(argetType, studentGraduationTargetREQ.getStudentNo());
		if(StudentNoList.size()<=0){
			logger.info("学生成长设置成长目群体平均展示,未查询到学长学号，学号:"+studentGraduationTargetREQ.getStudentNo());
			result.getErrorCode();
			result.setMsg("没有与设置的目标相同的学长");
			return result;
		}
		//3、群体平均
		long count = iStudentGraduateIndexInfoDAO.getGraduateIndexInfoCount(StudentNoList);
		if(count<=0){
			logger.info("学生成长设置成长目群体平均展示,未查询到学长指标信息，学号:"+studentGraduationTargetREQ.getStudentNo());
			result.getErrorCode();
			result.setMsg("未查询到学长指标信息");
			return result;
		}
		ExcellentSample excellentSample = getGroupAverage(StudentNoList,new BigDecimal(count));
		result.setObj(excellentSample);
		result.getSuccess();
		return result;
	}

	/**
	 * 获取群体平均
	 * @param StudentNoList  学号
	 * @return
	 */
	public ExcellentSample getGroupAverage(List<String> StudentNoList, BigDecimal count) {
		//根据学号查询学生指标值
		StudentGraduateIndexInfo studentGraduateIndexInfo = iStudentGraduateIndexInfoDAO.getGraduateIndexInfo(StudentNoList);
		ExcellentSample excellentSample = new ExcellentSample();
		//平均成绩
	    BigDecimal averageAchievement = studentGraduateIndexInfo.getAverageAchievement().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    excellentSample.setAverageAchievement(averageAchievement);
	    //学习水平
	    BigDecimal studyLevel = studentGraduateIndexInfo.getStudyLevel().divide(count,6, RoundingMode.HALF_UP).setScale(6,BigDecimal.ROUND_HALF_UP);
	    List<TradeTypeModel> studyLevelList = StudyLevelValue.getTradeTypeList();
		excellentSample.setStudyLevel(averageIndexName(studyLevel, studyLevelList));
	    //学习稳定性
	    BigDecimal achievementStatus  = studentGraduateIndexInfo.getAchievementStatus().divide(count,6, RoundingMode.HALF_UP).setScale(6,BigDecimal.ROUND_HALF_UP);
	    List<TradeTypeModel> achievementStatusList = AchievementStatusValue.getTradeTypeList();
		excellentSample.setAchievementStatus(averageIndexName(achievementStatus, achievementStatusList));
	    //到课率
	    BigDecimal toClassRate = studentGraduateIndexInfo.getToClassRate().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
		excellentSample.setToClassRate(toClassRate);
	    //准点率
	    BigDecimal punctualityRate = studentGraduateIndexInfo.getPunctualityRate().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
		excellentSample.setPunctualityRate(punctualityRate);
	    //奖励总数量
	    BigDecimal rewards = studentGraduateIndexInfo.getRewards().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
		excellentSample.setRewards(rewards);
	    //国家级奖励总数量
	    BigDecimal countryRewards = studentGraduateIndexInfo.getCountryRewards().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
		excellentSample.setCountryRewards(countryRewards);
	    //省级奖励总数量   交大无数据不显示
	    //BigDecimal provinceRewards;
	    //校级奖励总数量
	    BigDecimal schoolRewards  = studentGraduateIndexInfo.getSchoolRewards().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
		excellentSample.setSchoolRewards(schoolRewards);
	    //参与竞赛数
	    BigDecimal competition  = studentGraduateIndexInfo.getCompetition().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
		excellentSample.setCompetition(competition);
	    //参与活动数
	    BigDecimal activity  = studentGraduateIndexInfo.getActivity().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
		excellentSample.setActivity(activity);
	    //图书借阅数量
	    BigDecimal borrowBook = studentGraduateIndexInfo.getBorrowBook().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
		excellentSample.setBorrowBook(borrowBook);
	    //社交关系
	    BigDecimal socialConnections = studentGraduateIndexInfo.getSocialConnections().divide(count,6, RoundingMode.HALF_UP).setScale(6,BigDecimal.ROUND_HALF_UP);
	    List<TradeTypeModel> socialConnectionsList = SocialConnectionsValue.getTradeTypeList();
		excellentSample.setSocialConnections(averageIndexName(socialConnections, socialConnectionsList));
	    //朋友广泛性
	    BigDecimal friendsUniversality = studentGraduateIndexInfo.getFriendsUniversality().divide(count,6, RoundingMode.HALF_UP).setScale(6,BigDecimal.ROUND_HALF_UP);
	    List<TradeTypeModel> friendsUniversalityList = FriendsUniversalityValue.getTradeTypeList();
		excellentSample.setFriendsUniversality(averageIndexName(friendsUniversality,friendsUniversalityList));
	    //宿舍关系情况
	    BigDecimal dormitoryRelationship = studentGraduateIndexInfo.getDormitoryRelationship().divide(count,6, RoundingMode.HALF_UP).setScale(6,BigDecimal.ROUND_HALF_UP);
	    List<TradeTypeModel> dormitoryRelationshipList = DormitoryRelationshipValue.getTradeTypeList();
		excellentSample.setDormitoryRelationship(averageIndexName(dormitoryRelationship,dormitoryRelationshipList));
	    //学霸交友数
	    BigDecimal superScholarFriends = studentGraduateIndexInfo.getSuperScholarFriends().divide(count,6, RoundingMode.HALF_UP).setScale(6,BigDecimal.ROUND_HALF_UP);
	    List<TradeTypeModel> superScholarFriendsList = SuperScholarFriendsValue.getTradeTypeList();
		excellentSample.setSuperScholarFriends(averageIndexName(superScholarFriends,superScholarFriendsList));
	    //作息规律度
	    BigDecimal workRestRegularity = studentGraduateIndexInfo.getWorkRestRegularity().divide(count,6, RoundingMode.HALF_UP).setScale(6,BigDecimal.ROUND_HALF_UP);
	    List<TradeTypeModel> workRestRegularityList = WorkRestRegularityValue.getTradeTypeList();
		excellentSample.setWorkRestRegularity(averageIndexName(workRestRegularity,workRestRegularityList));
	    // 睡眠起床情况
	    BigDecimal sleepSituation = studentGraduateIndexInfo.getSleepSituation().divide(count,6, RoundingMode.HALF_UP).setScale(6,BigDecimal.ROUND_HALF_UP);
	    List<TradeTypeModel> sleepSituationList = SleepSituationValue.getTradeTypeList();
		excellentSample.setSleepSituation(averageIndexName(sleepSituation,sleepSituationList));
	    //平均睡眠时长
	    BigDecimal sleepTime = studentGraduateIndexInfo.getSleepTime().divide(count,6, RoundingMode.HALF_UP).setScale(6,BigDecimal.ROUND_HALF_UP);
	    List<TradeTypeModel> sleepTimeList = SleepTimeValue.getTradeTypeList();
		excellentSample.setSleepTime(averageIndexName(sleepTime,sleepTimeList));
	    //外出情况
	    BigDecimal outSituation = studentGraduateIndexInfo.getOutSituation().divide(count,6, RoundingMode.HALF_UP).setScale(6,BigDecimal.ROUND_HALF_UP);
	    List<TradeTypeModel> outSituationList = OutSituationValue.getTradeTypeList();
		excellentSample.setOutSituation(averageIndexName(outSituation,outSituationList));
	    //三餐规律度
	    BigDecimal threeMealsRegularity = studentGraduateIndexInfo.getThreeMealsRegularity().divide(count,6, RoundingMode.HALF_UP).setScale(6,BigDecimal.ROUND_HALF_UP);
	    List<TradeTypeModel> threeMealsRegularityList = ThreeMealsRegularityValue.getTradeTypeList();
		excellentSample.setThreeMealsRegularity(averageIndexName(threeMealsRegularity,threeMealsRegularityList));
	    //早餐就餐率
	    BigDecimal breakfastSituation = studentGraduateIndexInfo.getBreakfastSituation().divide(count,6, RoundingMode.HALF_UP).setScale(6,BigDecimal.ROUND_HALF_UP);
	    List<TradeTypeModel> breakfastSituationList = BreakfastSituationValue.getTradeTypeList();
		excellentSample.setBreakfastSituation(averageIndexName(breakfastSituation,breakfastSituationList));
	    //上网健康度
	    BigDecimal internetHealth = studentGraduateIndexInfo.getInternetHealth().divide(count,6, RoundingMode.HALF_UP).setScale(6,BigDecimal.ROUND_HALF_UP);
	    List<TradeTypeModel> internetHealthList = InternetHealthValue.getTradeTypeList();
		excellentSample.setInternetHealth(averageIndexName(internetHealth,internetHealthList));
		return excellentSample;
	}

	/**
	 * 拿到和枚举值最接近的name
	 * @param value
	 * @param list
	 * @return
	 */
	public  String averageIndexName(BigDecimal value , List<TradeTypeModel> list){
		String indexName ="";
	    List<ArageAverage> levelAverageList = new ArrayList<ArageAverage>();
	    for(TradeTypeModel model:list){
	    	ArageAverage arageAverage = new ArageAverage();
	    	arageAverage.setIndexName(model.getName());
	    	arageAverage.setAverage(value.subtract(new BigDecimal(model.getValue())).abs().toString());
	    	levelAverageList.add(arageAverage);
	    }
	    //按照字段average升序排序
	    Collections.sort(levelAverageList);
	    indexName = levelAverageList.get(0).getIndexName();
		return indexName;
	 }


	/**
	 * 学生成长设置成长目群体相似度
	 * @return
	 */
	public JsonResult groupSimilarityDegree(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ){
		logger.info("学生成长设置成长目群体相似度入参:"+studentGraduationTargetREQ.getStudentNo());
		JsonResult result = new JsonResult();
		//0、判断是不是大一学生，如果是大一学生第一学期（用第二年2月份划分），直接返回空
		StudentInfo studentInfo = iStudentInfoDAO.getStudentByNo(studentGraduationTargetREQ.getStudentNo());
		if(ObjectUtils.isEmpty(studentInfo)) {
			return result;
		}else {
			int schoolYear = studentInfo.getSchoolYear();
			int year = Integer.parseInt(DateUtils.getYear());//当年年份

			if (schoolYear == year) {
				logger.info("学生成长设置成长目群体相似度,大一学生暂无数据，学号:" + studentGraduationTargetREQ.getStudentNo());
				result.getErrorCode();
				result.setMsg("大一学生暂无数据");
				return result;
			}
			int month = Integer.parseInt(DateUtils.getMonth());//第二年2月前也算大一第一学期
			int newYear = schoolYear + 1;
			if (newYear == year && month <= 2) {
				logger.info("学生成长设置成长目群体相似度,大一学生暂无数据，学号:" + studentGraduationTargetREQ.getStudentNo());
				result.getErrorCode();
				result.setMsg("大一学生暂无数据");
				return result;
			}
			//1、查询学生有没有设置成长目标
			StudentGraduationTarget studentGraduationTarget = iStudentGraduationTargetDAO.getStudentArgetInfoByStudentNo(studentGraduationTargetREQ.getStudentNo());
			if (studentGraduationTarget == null) {
				logger.info("学生成长设置成长目群体相似度,未设置成长目标，学号:" + studentGraduationTargetREQ.getStudentNo());
				result.getErrorCode();
				result.setMsg("未设置成长目标");
				return result;
			}
			//2、获取和自己设置相同目标的师哥师姐学号
			String argetType = studentGraduationTarget.getArgetType();
			List<String> StudentNoList = getStudentNoList(argetType, studentGraduationTargetREQ.getStudentNo());
			if (StudentNoList.size() <= 0) {
				logger.info("学生成长设置成长目群体相似度,未查询到学长学号，学号:" + studentGraduationTargetREQ.getStudentNo());
				result.getErrorCode();
				result.setMsg("没有与设置的目标相同的学长");
				return result;
			}
			//3、群体平均
			long count = iStudentGraduateIndexInfoDAO.getGraduateIndexInfoCount(StudentNoList);
			if (count <= 0) {
				logger.info("学生成长设置成长目群体相似度,未查询到学长指标信息，学号:" + studentGraduationTargetREQ.getStudentNo());
				result.getErrorCode();
				result.setMsg("未查询到学长指标信息");
				return result;
			}
			List<SimilarityDegree> similarityDegreeList = getSimilarityDegree(studentInfo, StudentNoList, new BigDecimal(count), studentGraduationTargetREQ.getSimilarityDegreeQueryType(), studentGraduationTargetREQ.getStudentNo());
			result.setObj(similarityDegreeList);
			result.getSuccess();

		    return result;
		}
	}

	/**
	 * 获取相似度
	 * @param StudentNoList
	 * @param count
	 * @param similarityDegreeQueryType
	 * @param StudentNo
	 * @return
	 */
	public List<SimilarityDegree> getSimilarityDegree(StudentInfo studentInfo,List<String> StudentNoList, BigDecimal count,
			SimilarityDegreeQueryType similarityDegreeQueryType,String StudentNo) {
		List<SimilarityDegree> similarityDegreeList = new ArrayList<SimilarityDegree>();
		//1、获取群体指标对应值
		StudentGraduateIndexInfo graduateIndexInfoGruop = getGraduateIndexInfoGroup(StudentNoList, count);
		int schoolYear = studentInfo.getSchoolYear();
		int year = Integer.parseInt(DateUtils.getYear());//当年年份
		List<StudentIndexDisplayInfo> indexDisplayList = iStudentIndexDisplayInfoDAO.getAll();
		//2、获取自己指标值  注意：(一个学年分三个学期，yyyy1第一学期,yyyy2第二学期,yyyy3小学期),小学期不统计
		try {
			/*相似度的计算公式，计算每个指标和目标的差值百分比（保留一位小数），
			     譬如（我的平均成绩-目标群体平均成绩）/目标群体平均成绩
			    然后差值百分比乘以相应的权重，如平均成绩权重为1
			    最后再除以指标个数，保留2位小数在乘以100 最后再加100
			*/
			BigDecimal similarityTotalPublic  = new BigDecimal(0);
			int similaritycountPublic = 0	;
			try {
				//学习水平
   		        StudyLevelValue studyLevelValue = iStudentAttributeService.getLearningLevel(StudentNo);
			    BigDecimal studyLevel = new BigDecimal(studyLevelValue.getValue());
			    BigDecimal studyLevelGroup = graduateIndexInfoGruop.getStudyLevel();
				BigDecimal studyLevelWeight = getIndexDisplay(Index.STUDYLEVEL, indexDisplayList);
				BigDecimal studyLevelSimilarity = studyLevel.subtract(studyLevelGroup).divide(studyLevelGroup,6,RoundingMode.HALF_UP).multiply(studyLevelWeight);
				similarityTotalPublic = similarityTotalPublic.add(studyLevelSimilarity);
				similaritycountPublic = similaritycountPublic+1;
			} catch (Exception e) {
				logger.error("学生成长设置成长目群体相似度,查询学习水平异常：学号："+StudentNo,e);
			}
			try {
				//成绩稳定性
				AchievementStatusValue achievementStatusValue = iStudentAttributeService.getLearningStability(StudentNo);
				BigDecimal achievementStatus = new BigDecimal(achievementStatusValue.getValue());
				BigDecimal achievementStatusGroup = graduateIndexInfoGruop.getAchievementStatus();
				BigDecimal achievementStatusWeight = getIndexDisplay(Index.ACHIEVEMENTSTATUS, indexDisplayList);
				BigDecimal achievementStatusSimilarity = achievementStatus.subtract(achievementStatusGroup).divide(achievementStatusGroup,6,RoundingMode.HALF_UP).multiply(achievementStatusWeight);
				similarityTotalPublic = similarityTotalPublic.add(achievementStatusSimilarity);
				similaritycountPublic = similaritycountPublic+1;
			} catch (Exception e) {
				logger.error("学生成长设置成长目群体相似度,查询成绩稳定性异常：学号："+StudentNo,e);
			}

			try {
				Map<String,Long> secondClassroomCompetitionAndActivity = iStudentExtracurrCreditsService.countByStudentNo(StudentNo);
				BigDecimal  competition = new BigDecimal(secondClassroomCompetitionAndActivity.get(CompetitionAndActivityDataType.js_count.toString()));
				//参与竞赛数js_count
				BigDecimal competitionGroup = graduateIndexInfoGruop.getCompetition();
				BigDecimal competitionWeight = getIndexDisplay(Index.COMPETITION, indexDisplayList);
				BigDecimal competitionSimilarity = competition.subtract(competitionGroup).divide(competitionGroup,6,RoundingMode.HALF_UP).multiply(competitionWeight);
				similarityTotalPublic = similarityTotalPublic.add(competitionSimilarity);
				similaritycountPublic = similaritycountPublic+1;
				//参与活动数hd_count
				BigDecimal activity = new BigDecimal(secondClassroomCompetitionAndActivity.get(CompetitionAndActivityDataType.hd_count.toString()));
				BigDecimal activityGroup = graduateIndexInfoGruop.getActivity();
				BigDecimal activityWeight = getIndexDisplay(Index.COMPETITION, indexDisplayList);
				BigDecimal activitySimilarity = activity.subtract(activityGroup).divide(activityGroup,6,RoundingMode.HALF_UP).multiply(activityWeight);
				similarityTotalPublic = similarityTotalPublic.add(activitySimilarity);
				similaritycountPublic = similaritycountPublic+1;

			} catch (Exception e) {
				logger.error("学生成长设置成长目群体相似度参与活动、参与竞赛异常，学号："+StudentNo,e);
			}
			if(SimilarityDegreeQueryType.SEMESTER.equals(similarityDegreeQueryType)){
				// 获取学期
				BigDecimal similarityTotal  = new BigDecimal(0);
				int similaritycount = 0	;
				similarityDegreeList = getStudentSemester(schoolYear, year);
				for(SimilarityDegree similarityDegree:similarityDegreeList){
					String semester = similarityDegree.getSemester();//学期
					String semesterSecond = similarityDegree.getSemesterSecond();//奖励数对应学期
					try {
						//平均成绩
						List<StudentScoresRES> scoreList = iStudentAttributeService.getScoreData(StudentNo);
						BigDecimal averageScore = new BigDecimal(0);
						for(StudentScoresRES studentScoresRES:scoreList){
							if(semester.equals(studentScoresRES.getSchoolTerm())){
								averageScore = new BigDecimal(studentScoresRES.getAverageScore());
								break;
							}
						}
						BigDecimal averageAchievementGroup = graduateIndexInfoGruop.getAverageAchievement();
						BigDecimal averageAchievementWeight = getIndexDisplay(Index.ACHIEVEMENT, indexDisplayList);
						BigDecimal averageAchievementSimilarity = averageScore.subtract(averageAchievementGroup).divide(averageAchievementGroup,6,RoundingMode.HALF_UP).multiply(averageAchievementWeight);
						similarityTotal = similarityTotal.add(averageAchievementSimilarity);
						similaritycount = similaritycount+1;
					} catch (Exception e) {
						logger.error("学生成长设置成长目群体相似度,获取平均成绩异常：学号："+StudentNo+"学期："+semester,e);
					}
					//到课率
					try {
						List<StudentClassRateRES> studentClassRateRESList = iStudentAttributeService.getClassRate(StudentNo);
						BigDecimal toClassRate =  new BigDecimal(0);
						for(StudentClassRateRES studentClassRateRES: studentClassRateRESList){
						    if(semester.equals(studentClassRateRES.getSchoolTerm())){
						    	toClassRate = new BigDecimal(studentClassRateRES.getCourseRate());
						    	break;
						    }
						}
						BigDecimal toClassRateGroup = graduateIndexInfoGruop.getToClassRate();
						BigDecimal toClassRateWeight = getIndexDisplay(Index.TOCLASSRATE, indexDisplayList);
						BigDecimal toClassRateSimilarity = toClassRate.subtract(toClassRateGroup).divide(toClassRateGroup,6,RoundingMode.HALF_UP).multiply(toClassRateWeight);
						similarityTotal = similarityTotal.add(toClassRateSimilarity);
						similaritycount = similaritycount+1;

					} catch (Exception e) {
						logger.error("学生成长设置成长目群体相似度到课率异常，学号："+StudentNo+"学期："+semester,e);
					}
					//准点率
					try {
						List<StudentOnTimeRateRES> punctualityRateList = iStudentAttributeService.getOnTimeRate(StudentNo);
						BigDecimal punctualityRate = new BigDecimal(0);
						for(StudentOnTimeRateRES studentOnTimeRateRES:punctualityRateList){
							if(semester.equals(studentOnTimeRateRES.getSchoolTerm())){
								punctualityRate = new BigDecimal(studentOnTimeRateRES.getOnTimeRate());
								break;
						    }
						}
						BigDecimal punctualityRateGroup = graduateIndexInfoGruop.getPunctualityRate();
						BigDecimal punctualityRateWeight = getIndexDisplay(Index.PUNCTUALITYRATE, indexDisplayList);
						BigDecimal punctualityRateSimilarity = punctualityRate.subtract(punctualityRateGroup).divide(punctualityRateGroup,6,RoundingMode.HALF_UP).multiply(punctualityRateWeight);
						similarityTotal = similarityTotal.add(punctualityRateSimilarity);
						similaritycount = similaritycount+1;
					} catch (Exception e) {
						logger.error("学生成长设置成长目群体相似度准点率异常，学号："+StudentNo,e);
					}
					//第二课堂
					try {
						Map<String,Integer> secondClassroomReward = (Map<String, Integer>) iStudentAwardService.listAwardByStudentNoAndCategory(StudentNo);
						int countryRewards = secondClassroomReward.get(semesterSecond+"A");//国家级别
						BigDecimal countryRewardsGroup = graduateIndexInfoGruop.getCountryRewards();
						BigDecimal countryRewardsWeight = getIndexDisplay(Index.COUNTRYREWARDS, indexDisplayList);
						BigDecimal countryRewardsSimilarity = new BigDecimal(countryRewards).subtract(countryRewardsGroup).divide(countryRewardsGroup,6,RoundingMode.HALF_UP).multiply(countryRewardsWeight);
						similarityTotal = similarityTotal.add(countryRewardsSimilarity);
						similaritycount = similaritycount+1;
						int schoolRewards = secondClassroomReward.get(semesterSecond+"B");//学校级别
						BigDecimal schoolRewardsGroup = graduateIndexInfoGruop.getSchoolRewards();
						BigDecimal schoolRewardsWeight = getIndexDisplay(Index.SCHOOLREWARDS, indexDisplayList);
						BigDecimal schoolRewardsSimilarity = new BigDecimal(schoolRewards).subtract(schoolRewardsGroup).divide(schoolRewardsGroup,6,RoundingMode.HALF_UP).multiply(schoolRewardsWeight);
						similarityTotal = similarityTotal.add(schoolRewardsSimilarity);
						similaritycount = similaritycount+1;
						int rewards = countryRewards+schoolRewards;//奖励总数量
						BigDecimal rewardsGroup = graduateIndexInfoGruop.getRewards();
						BigDecimal rewardsWeight = getIndexDisplay(Index.REWARDS, indexDisplayList);
						BigDecimal rewardsSimilarity = new BigDecimal(rewards).subtract(rewardsGroup).divide(rewardsGroup,6,RoundingMode.HALF_UP).multiply(rewardsWeight);
						similarityTotal = similarityTotal.add(rewardsSimilarity);
						similaritycount = similaritycount+1;

					} catch (Exception e) {
						logger.error("学生成长设置成长目群体相似度奖励异常，学号："+StudentNo+"学期："+semester,e);
					}

					BigDecimal similarityTotalResult = similarityTotalPublic.add(similarityTotal);
					int similaritycountResult = similaritycountPublic+similaritycount;

					BigDecimal percentage = similarityTotalResult.divide(new BigDecimal(similaritycountResult),2,RoundingMode.HALF_UP).multiply(new BigDecimal(100));

					BigDecimal percentageNew = percentage.add(new BigDecimal(100));
					similarityDegree.setPercentage(percentageNew.toString());
				}

			}else{
				//学年
				BigDecimal similarityTotal  = new BigDecimal(0);
				int similaritycount = 0	;
				List<SchoolYear> schoolYearList = getSchoolYearChineseList(schoolYear, year);
				for(SchoolYear schoolYearNew:schoolYearList){
					SimilarityDegree similarityDegree = new SimilarityDegree();
					String NewSchoolYear = schoolYearNew.getSchoolYear();//学年
					similarityDegree.setSemester(NewSchoolYear);
					similarityDegree.setType(SimilarityDegreeQueryType.SCHOOLYEAR.toString());
					similarityDegree.setSemestername(schoolYearNew.getChinese());
				    String second = schoolYearNew.getSecond(); //奖励活动对应的学年
					similarityDegree.setSemesterSecond(second);
				    try {
				    	//平均成绩
						List<StudentScoresRES> scoreList = iStudentAttributeService.getScoreData(StudentNo);
						BigDecimal averageScore = new BigDecimal(0);
						int i=0;
						for(StudentScoresRES studentScoresRES:scoreList){
							if(studentScoresRES.getSchoolTerm().startsWith(NewSchoolYear)&&!studentScoresRES.getSchoolTerm().endsWith("3")){
								averageScore = averageScore.add(new BigDecimal(studentScoresRES.getAverageScore()));
								i = i+1;
							}
						}
						averageScore = averageScore.divide(new BigDecimal(i),2,RoundingMode.HALF_UP);
						BigDecimal averageAchievementGroup = graduateIndexInfoGruop.getAverageAchievement();
						BigDecimal averageAchievementWeight = getIndexDisplay(Index.ACHIEVEMENT, indexDisplayList);
						BigDecimal averageAchievementSimilarity = averageScore.subtract(averageAchievementGroup).divide(averageAchievementGroup,6,RoundingMode.HALF_UP).multiply(averageAchievementWeight);
						similarityTotal = similarityTotal.add(averageAchievementSimilarity);
						similaritycount = similaritycount+1;
					} catch (Exception e) {
						logger.error("学生成长设置成长目群体相似度,获取平均成绩异常：学号："+StudentNo+"学年："+schoolYear,e);
					}
				    //到课率
					try {
						List<StudentClassRateRES> toClassRateList = iStudentAttributeService.getClassRate(StudentNo);
						BigDecimal toClassRate =  new BigDecimal(0);
						int i=0;
						for(StudentClassRateRES studentClassRateRES: toClassRateList){
						    if(studentClassRateRES.getSchoolTerm().startsWith(NewSchoolYear)&&!studentClassRateRES.getSchoolTerm().endsWith("3")){
						    	toClassRate = new BigDecimal(studentClassRateRES.getCourseRate());
						    	i = i+1;
						    }
						}
						toClassRate = toClassRate.divide(new BigDecimal(i),2,RoundingMode.HALF_UP);
						BigDecimal toClassRateGroup = graduateIndexInfoGruop.getToClassRate();
						BigDecimal toClassRateWeight = getIndexDisplay(Index.TOCLASSRATE, indexDisplayList);
						BigDecimal toClassRateSimilarity = toClassRate.subtract(toClassRateGroup).divide(toClassRateGroup,6,RoundingMode.HALF_UP).multiply(toClassRateWeight);
						similarityTotal = similarityTotal.add(toClassRateSimilarity);
						similaritycount = similaritycount+1;

					} catch (Exception e) {
						logger.error("学生成长设置成长目群体相似度到课率异常，学号："+StudentNo+"学年："+schoolYear,e);
					}
					//准点率
					try {
						List<StudentOnTimeRateRES> punctualityRateList = iStudentAttributeService.getOnTimeRate(StudentNo);
						BigDecimal punctualityRate = new BigDecimal(0);

						int i=0;
						for(StudentOnTimeRateRES studentOnTimeRateRES:punctualityRateList){
							if(studentOnTimeRateRES.getSchoolTerm().startsWith(NewSchoolYear)&&!studentOnTimeRateRES.getSchoolTerm().endsWith("3")){
								punctualityRate = punctualityRate.add(new BigDecimal(studentOnTimeRateRES.getOnTimeRate()));
								i = i+1;
						    }
						}
						punctualityRate = punctualityRate.divide(new BigDecimal(i),2,RoundingMode.HALF_UP);
						BigDecimal punctualityRateGroup = graduateIndexInfoGruop.getPunctualityRate();
						BigDecimal punctualityRateWeight = getIndexDisplay(Index.PUNCTUALITYRATE, indexDisplayList);
						BigDecimal punctualityRateSimilarity = punctualityRate.subtract(punctualityRateGroup).divide(punctualityRateGroup,6,RoundingMode.HALF_UP).multiply(punctualityRateWeight);
						similarityTotal = similarityTotal.add(punctualityRateSimilarity);
						similaritycount = similaritycount+1;
					} catch (Exception e) {
						logger.error("学生成长设置成长目群体相似度准点率异常，学号："+StudentNo+"学年："+schoolYear,e);
					}

					//第二课堂
					try {
						Map<String,Integer> secondClassroomReward = (Map<String, Integer>) iStudentAwardService.listAwardByStudentNoAndCategory(StudentNo);
						BigDecimal countryRewards = new BigDecimal(0);
						BigDecimal schoolRewards = new BigDecimal(0);
						for (String key : secondClassroomReward.keySet()) {
							if(key.startsWith(second)&&key.endsWith("A")){
								countryRewards = countryRewards.add(new BigDecimal(secondClassroomReward.get(key)));
							}else if (key.startsWith(second)&&key.endsWith("B")){
								schoolRewards = schoolRewards.add(new BigDecimal(secondClassroomReward.get(key)));
							}
						}
						BigDecimal countryRewardsGroup = graduateIndexInfoGruop.getCountryRewards();
						BigDecimal countryRewardsWeight = getIndexDisplay(Index.COUNTRYREWARDS, indexDisplayList);
						BigDecimal countryRewardsSimilarity = countryRewards.subtract(countryRewardsGroup).divide(countryRewardsGroup,6,RoundingMode.HALF_UP).multiply(countryRewardsWeight);
						similarityTotal = similarityTotal.add(countryRewardsSimilarity);
						similaritycount = similaritycount+1;
						BigDecimal schoolRewardsGroup = graduateIndexInfoGruop.getSchoolRewards();
						BigDecimal schoolRewardsWeight = getIndexDisplay(Index.SCHOOLREWARDS, indexDisplayList);
						BigDecimal schoolRewardsSimilarity = schoolRewards.subtract(schoolRewardsGroup).divide(schoolRewardsGroup,6,RoundingMode.HALF_UP).multiply(schoolRewardsWeight);
						similarityTotal = similarityTotal.add(schoolRewardsSimilarity);
						similaritycount = similaritycount+1;
						BigDecimal rewards = countryRewards.add(schoolRewards);//奖励总数量
						BigDecimal rewardsGroup = graduateIndexInfoGruop.getRewards();
						BigDecimal rewardsWeight = getIndexDisplay(Index.REWARDS, indexDisplayList);
						BigDecimal rewardsSimilarity = rewards.subtract(rewardsGroup).divide(rewardsGroup,6,RoundingMode.HALF_UP).multiply(rewardsWeight);
						similarityTotal = similarityTotal.add(rewardsSimilarity);
						similaritycount = similaritycount+1;

					} catch (Exception e) {
						logger.error("学生成长设置成长目群体相似度奖励异常，学号："+StudentNo+"学年："+schoolYear,e);
					}

					BigDecimal similarityTotalResult = similarityTotalPublic.add(similarityTotal);
					int similaritycountResult = similaritycountPublic+similaritycount;
					BigDecimal percentage = similarityTotalResult.divide(new BigDecimal(similaritycountResult),2,RoundingMode.HALF_UP).multiply(new BigDecimal(100));
					BigDecimal percentageNew = percentage.add(new BigDecimal(100));
					similarityDegree.setPercentage(percentageNew.toString());
					similarityDegreeList.add(similarityDegree);
				}
			}
		} catch (Exception e) {
			logger.error("学生成长设置成长目群体相似度异常，学号："+StudentNo,e);
		}

	    return similarityDegreeList;
	}

	 /**
	  * 获取学生学期
	  * @param grade 入学年yyyy
	  * @param year  当前年yyyy
	  * @return
	  */
     private List<SimilarityDegree> getStudentSemester(int grade,int year) {
    	List<SimilarityDegree> semesterList = new ArrayList<SimilarityDegree>();

    	List<SchoolYear> schoolYearList  = getSchoolYearChineseList(grade, year);
		for(SchoolYear schoolYear:schoolYearList){
			SimilarityDegree temp1  = new SimilarityDegree();
			temp1.setSemester(schoolYear.getSchoolYear()+"1");
			temp1.setType(SimilarityDegreeQueryType.SEMESTER.toString());
			temp1.setSemestername(schoolYear.getChinese()+"第一学期");
			temp1.setSemesterSecond(schoolYear.getSecond()+"A_");
			temp1.setType(SimilarityDegreeQueryType.SEMESTER.toString());
			semesterList.add(temp1);
			SimilarityDegree temp2  = new SimilarityDegree();
			temp2.setSemester(schoolYear.getSchoolYear()+"2");
			temp2.setType(SimilarityDegreeQueryType.SEMESTER.toString());
			temp2.setSemestername(schoolYear.getChinese()+"第二学期");
			temp2.setSemesterSecond(schoolYear.getSecond()+"B_");
			temp2.setType(SimilarityDegreeQueryType.SEMESTER.toString());
			semesterList.add(temp2);
		}
		return semesterList;
	}





     /**
	  * 获取学生学年
	  * @param grade 入学年yyyy
	  * @param year  当前年yyyy
	  * @return
	  */

	private List<SchoolYear> getSchoolYearChineseList(int grade,int year) {
		List<SchoolYear> schoolYearList  = new ArrayList<SchoolYear>();
		for(int i =0 ;i<4;i++){
			if(i==0){
				SchoolYear schoolYear = new SchoolYear();
				schoolYear.setSchoolYear(grade+"");
				schoolYear.setChinese("大一");
				schoolYear.setSecond("D1");
				schoolYearList.add(schoolYear);
				continue;
			}
			int semester = grade+i;
			if(semester<year){
				SchoolYear schoolYearChinese = new SchoolYear();
				schoolYearChinese.setSchoolYear(semester+"");
				String chinese = "";
				String second = "";
				if(i==1){
					chinese = "大二";
					second = "D2";
				}else if(i==2){
					chinese = "大三";
					second = "D3";
				}else if(i==3){
					chinese = "大四";
					second = "D4";
				}
				schoolYearChinese.setChinese(chinese);
				schoolYearChinese.setSecond(second);
				schoolYearList.add(schoolYearChinese);
			}
		}
		return schoolYearList;
	}


	/**
      * 获取群体指标对应值
      * @param StudentNoList
      * @param count
      * @return
      */
	private StudentGraduateIndexInfo getGraduateIndexInfoGroup(List<String> StudentNoList, BigDecimal count) {
		StudentGraduateIndexInfo graduateIndexInfoGroup = new StudentGraduateIndexInfo();
		StudentGraduateIndexInfo graduateIndexInfo = iStudentGraduateIndexInfoDAO.getGraduateIndexInfo(StudentNoList);
		//平均成绩Index
	    BigDecimal averageAchievement = graduateIndexInfo.getAverageAchievement().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setAverageAchievement(averageAchievement);
	    //学习水平
	    BigDecimal studyLevel = graduateIndexInfo.getStudyLevel().divide(count,6, RoundingMode.HALF_UP).setScale(6,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setStudyLevel(studyLevel);
	    //学习稳定性
	    BigDecimal achievementStatus  = graduateIndexInfo.getAchievementStatus().divide(count,6, RoundingMode.HALF_UP).setScale(6,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setAchievementStatus(achievementStatus);
	    //到课率
	    BigDecimal toClassRate = graduateIndexInfo.getToClassRate().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setToClassRate(toClassRate);
	    //准点率
	    BigDecimal punctualityRate = graduateIndexInfo.getPunctualityRate().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setPunctualityRate(punctualityRate);
	    //奖励总数量
	    BigDecimal rewards = graduateIndexInfo.getRewards().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setRewards(rewards);
	    //国家级奖励总数量
	    BigDecimal countryRewards = graduateIndexInfo.getCountryRewards().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setCountryRewards(countryRewards);
	    //省级奖励总数量   交大无数据不显示
	    //BigDecimal provinceRewards;
	    //校级奖励总数量
	    BigDecimal schoolRewards  = graduateIndexInfo.getSchoolRewards().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setSchoolRewards(schoolRewards);
	    //参与竞赛数
	    BigDecimal competition  = graduateIndexInfo.getCompetition().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setCompetition(competition);
	    //参与活动数
	    BigDecimal activity  = graduateIndexInfo.getActivity().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setActivity(activity);
	    //图书借阅数量
	    BigDecimal borrowBook = graduateIndexInfo.getBorrowBook().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setBorrowBook(borrowBook);
	    //社交关系
	    BigDecimal socialConnections = graduateIndexInfo.getSocialConnections().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setSocialConnections(socialConnections);
	    //朋友广泛性
	    BigDecimal friendsUniversality = graduateIndexInfo.getFriendsUniversality().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setFriendsUniversality(friendsUniversality);
	    //宿舍关系情况
	    BigDecimal dormitoryRelationship = graduateIndexInfo.getDormitoryRelationship().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setDormitoryRelationship(dormitoryRelationship);
	    //学霸交友数
	    BigDecimal superScholarFriends = graduateIndexInfo.getSuperScholarFriends().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setSuperScholarFriends(superScholarFriends);
	    //作息规律度
	    BigDecimal workRestRegularity = graduateIndexInfo.getWorkRestRegularity().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setWorkRestRegularity(workRestRegularity);
	    // 睡眠起床情况
	    BigDecimal sleepSituation = graduateIndexInfo.getSleepSituation().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setSleepSituation(sleepSituation);
	    //平均睡眠时长
	    BigDecimal sleepTime= graduateIndexInfo.getSleepTime().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setSleepTime(sleepTime);
	    //外出情况
	    BigDecimal outSituation= graduateIndexInfo.getOutSituation().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setOutSituation(outSituation);
	    //三餐规律度
	    BigDecimal threeMealsRegularity= graduateIndexInfo.getThreeMealsRegularity().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setThreeMealsRegularity(threeMealsRegularity);
	    //早餐就餐率
	    BigDecimal breakfastSituation= graduateIndexInfo.getBreakfastSituation().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setBreakfastSituation(breakfastSituation);
	    //上网健康度
	    BigDecimal internetHealth= graduateIndexInfo.getInternetHealth().divide(count,6, RoundingMode.HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
	    graduateIndexInfoGroup.setInternetHealth(internetHealth);
	    return graduateIndexInfoGroup;
	}


	public BigDecimal getIndexDisplay(Index index,List<StudentIndexDisplayInfo> indexDisplayList){
		BigDecimal display = new BigDecimal(1);
		for(StudentIndexDisplayInfo studentIndexDisplayInfo:indexDisplayList){
			if(index.getValue().equals(studentIndexDisplayInfo.getIndexCode())){
				display = new BigDecimal(studentIndexDisplayInfo.getWeight()).setScale(2,BigDecimal.ROUND_HALF_UP);
				break;
			}
		}
		return display;
	}



	/**
	 * 学生成长成长目标和群体指标展示
	 * @return
	 */
	public JsonResult argetGroupInfo(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ){
		logger.info("学生成长成长目标和群体指标展示入参:"+studentGraduationTargetREQ.getStudentNo());
		JsonResult result = new JsonResult();
		//1、查询学生有没有设置成长目标
		StudentGraduationTarget studentGraduationTarget = iStudentGraduationTargetDAO.getStudentArgetInfoByStudentNo(studentGraduationTargetREQ.getStudentNo());
		if(studentGraduationTarget ==null){
			logger.info("学生成长成长目标和群体指标展示,未设置成长目标，学号:"+studentGraduationTargetREQ.getStudentNo());
			result.getErrorCode();
			result.setMsg("未设置成长目标");
			return result;
		}
		//2、获取和自己设置相同目标的师哥师姐学号
		String argetType = studentGraduationTarget.getArgetType();
		List<String> StudentNoList = getStudentNoList(argetType, studentGraduationTargetREQ.getStudentNo());
		if(StudentNoList.size()<=0){
			logger.info("学生成长成长目标和群体指标展示,未查询到学长学号，学号:"+studentGraduationTargetREQ.getStudentNo());
			result.getErrorCode();
			result.setMsg("没有与设置的目标相同的学长");
			return result;
		}
		//3、群体平均
		long count = iStudentGraduateIndexInfoDAO.getGraduateIndexInfoCount(StudentNoList);
		if(count<=0){
			logger.info("学生成长成长目标和群体指标展示,未查询到学长指标信息，学号:"+studentGraduationTargetREQ.getStudentNo());
			result.getErrorCode();
			result.setMsg("未查询到学长指标信息");
			return result;
		}
		//4、获取群体和自己的标签信息
		List<ExcellentSample> sampleDTOList = getArgetAndGroupInfo(studentGraduationTargetREQ.getStudentNo() ,StudentNoList,new BigDecimal(count));
		result.setObj(sampleDTOList);
		result.getSuccess();
		return result;
	}

	/**
	 * 学生成长成长目标和群体指标展示
	 * @return list
	 */
	private List<ExcellentSample> getArgetAndGroupInfo(String StudentNo, List<String> StudentNoList,BigDecimal count) {
		List<ExcellentSample> excellentSampleList = new ArrayList<ExcellentSample>();
		ExcellentSample excellentSample = getExcellentSample(StudentNo);
		excellentSample.setFlag("own");
		excellentSampleList.add(excellentSample);
		ExcellentSample excellentSampleGroup = getGroupAverage(StudentNoList, count);
		excellentSampleGroup.setFlag("group");// group 群体  own 自己
		excellentSampleList.add(excellentSampleGroup);
		return excellentSampleList;
	}

    public ExcellentSample getExcellentSample(String StudentNo){
		ExcellentSample excellentSample = new ExcellentSample();
    	//平均成绩
		try {
			BigDecimal averageAchievementTotal = new BigDecimal(0);
			List<StudentScoresRES> scoreList = iStudentAttributeService.getScoreData(StudentNo);
			for(StudentScoresRES studentScoresRES:scoreList){
				averageAchievementTotal = averageAchievementTotal.add(new BigDecimal(studentScoresRES.getAverageScore()));
			}
			BigDecimal averageAchievement = new BigDecimal(0);
			if(scoreList.size()>0){
				averageAchievement = averageAchievementTotal.divide(new BigDecimal(scoreList.size()),2, RoundingMode.HALF_UP);
			}
			excellentSample.setAverageAchievement(averageAchievement);
		} catch (Exception e) {
			logger.error("学生成长成长目标和群体指标展示异常，学号："+StudentNo,e);
		}
		/*
		  查询学生学习相关标签
		learningLeveLable 学习水平
		scoreLable 成绩稳定性
		classLable 上课纪律
		failLable  挂科次数
		forecastLable 成绩预测
		truancyLable  疑似逃课
		map.put("label", learningLeveLable + "," + scoreLable +  "," + classLable + "," + failLable + "," + forecastLable + "," + truancyLable);
		*/
		try {                         //studiesAnalysisService
			Map<String,Object> studiesLabelMap =  iStudiesAnalysisService.getStudiesLabel(StudentNo);
			String studiesLabel = (String)studiesLabelMap.get("label");
			studiesLabel = studiesLabel.replace(",", " ,")+" ,";
			String [] studiesLabelArray = studiesLabel.split(",");
			//学习水平
		    String studyLevel = studiesLabelArray[0].trim();
		    excellentSample.setStudyLevel(studyLevel);
		    //成绩稳定性
		    String achievementStatus = studiesLabelArray[1].trim();
			excellentSample.setAchievementStatus(achievementStatus);
		} catch (Exception e) {
			logger.error("学生成长成长目标和群体指标展示,查询学生学习相关标签异常：学号："+StudentNo,e);
		}
		//到课率
		try {
			BigDecimal toClassRateTotal = new BigDecimal(0);
			List<StudentClassRateRES> toClassRateList = iStudentAttributeService.getClassRate(StudentNo);
			for(StudentClassRateRES studentClassRateRES: toClassRateList){
				toClassRateTotal = toClassRateTotal.add(new BigDecimal(studentClassRateRES.getCourseRate()));
			}
			BigDecimal toClassRate =  new BigDecimal(0);
			if(toClassRateList.size()>0){
				toClassRate = toClassRateTotal.divide(new BigDecimal(toClassRateList.size()),2, RoundingMode.HALF_UP);
			}
			excellentSample.setToClassRate(toClassRate);
		} catch (Exception e) {
			logger.error("学生成长成长目标和群体指标展示到课率异常，学号："+StudentNo,e);
		}
		//准点率
		try {
			List<StudentOnTimeRateRES> punctualityRateList = iStudentAttributeService.getOnTimeRate(StudentNo);
			BigDecimal punctualityRatetotal = new BigDecimal(0);
			for(StudentOnTimeRateRES studentOnTimeRateRES:punctualityRateList){
				punctualityRatetotal = punctualityRatetotal.add(new BigDecimal(studentOnTimeRateRES.getOnTimeRate()));
			}
			BigDecimal punctualityRate = new BigDecimal(0);
			if(punctualityRateList.size()>0){
				punctualityRate = punctualityRatetotal.divide(new BigDecimal(punctualityRateList.size()),2, RoundingMode.HALF_UP);
			}
			excellentSample.setPunctualityRate(punctualityRate);
		} catch (Exception e) {
			logger.error("学生成长成长目标和群体指标展示准点率异常，学号："+StudentNo,e);
		}
		//第二课堂
		try {
			Map<String,Integer> secondClassroomReward = (Map<String, Integer>) iStudentAwardService.listAwardByStudentNoAndCategory(StudentNo);
			BigDecimal rewards = new BigDecimal(secondClassroomReward.get(RewardsDataType.totalAwardCount.toString()));
			excellentSample.setRewards(rewards);//奖励总数量
			BigDecimal countryRewards = new BigDecimal(secondClassroomReward.get(RewardsDataType.total_A.toString()));
			excellentSample.setCountryRewards(countryRewards);//国家级奖励总数量
			BigDecimal schoolRewards= new BigDecimal(secondClassroomReward.get(RewardsDataType.total_B.toString()));
			excellentSample.setSchoolRewards(schoolRewards); //校级奖励总数量
			Map<String,Long> secondClassroomCompetitionAndActivity = iStudentExtracurrCreditsService.countByStudentNo(StudentNo);
			BigDecimal competition = new BigDecimal(secondClassroomCompetitionAndActivity.get(CompetitionAndActivityDataType.js_count.toString()));
			excellentSample.setCompetition(competition); //参与竞赛数js_count
			BigDecimal activity = new BigDecimal(secondClassroomCompetitionAndActivity.get(CompetitionAndActivityDataType.hd_count.toString()));
			excellentSample.setActivity(activity); //参与活动数hd_count
		} catch (Exception e) {
			logger.error("学生成长成长目标和群体指标展示奖励、活动、竞赛异常，学号："+StudentNo,e);
		}
		//图书借阅数量
	    try {
			Integer borrowBook = iStudentAttributeService.CountBookBorrow(StudentNo);
			if(borrowBook!=null){
				excellentSample.setBorrowBook(new BigDecimal(borrowBook));
			}
		} catch (Exception e) {
			logger.error("学生成长成长目标和群体指标展示图书借阅数异常，学号："+StudentNo,e);
		}
	    try {
			Map<String,Object> studentCartRelationMap = iStudentRelationInfoService.studentCartRelationTag(StudentNo);
			//整体情况
			String overallSituation = (String)studentCartRelationMap.get("social");
			excellentSample.setSocialConnections(overallSituation);
			//宿舍关系情况
			String dormitoryRelationship = (String)studentCartRelationMap.get("drom");
			excellentSample.setDormitoryRelationship(dormitoryRelationship);
		} catch (Exception e) {
			logger.error("学生成长成长目标和群体指标展示,查询社交关系异常：学号："+StudentNo,e);
		}

	    try {
	    	/*
	    	 * friendsUniversality 朋友广泛性
	    	 * superScholarFriendsValue 学霸交友情况
	    	 */
	    	Map<String, Object> map = iStudentRelationInfoService.getSocialFriendTagInfo(StudentNo);
	    	FriendsUniversalityValue  friendsUniversalityValue = (FriendsUniversalityValue)map.get("friendsUniversality");
	    	SuperScholarFriendsValue  superScholarFriendsValue = (SuperScholarFriendsValue)map.get("superScholarFriendsValue");
		    //朋友广泛性
	    	excellentSample.setFriendsUniversality(friendsUniversalityValue.getName());
		    //学霸交友情况
			excellentSample.setSuperScholarFriends(superScholarFriendsValue.getName());
		} catch (Exception e) {
			logger.error("学生成长成长目标和群体指标展示,查询朋友广泛性、学霸交友情况标签异常：学号："+StudentNo,e);
		}
	    /*
	    //作息规律度
	    private String workRestRegularity;
	    */
	    /*
		  查询睡眠标签
		sleepSitLable 睡眠起床情况
		sleepTimeLable查询日均睡眠时长
		leaveSchoolLable外出情况
		map.put("lable", "," + sleepSitLable.toString() + "," + sleepTimeLable.toString() + "," + leaveSchoolLable.toString());
		*/
		try {
			Map<String, Object> sleepLableMap = (Map<String, Object>) iStudentRestService.sleepLable(StudentNo);
			String  sleepLable = (String)sleepLableMap.get("label");
			sleepLable = sleepLable.replace(",", " ,")+" ,";
			String [] sleepLableMapArray =  sleepLable.split(",");
			//睡眠起床情况
			String sleepSituation = sleepLableMapArray[0].trim();
			excellentSample.setSleepSituation(sleepSituation);
			//睡眠时长
			String sleepTime = sleepLableMapArray[1].trim();
			excellentSample.setSleepTime(sleepTime);
			//外出情况
			String outSituation = sleepLableMapArray[2].trim();
			excellentSample.setOutSituation(outSituation);
		} catch (Exception e) {
			logger.error("学生成长成长目标和群体指标展示,查询睡眠标签异常：学号："+StudentNo,e);
		}
	    /*
		 查询三餐标签
		regularLable三餐规律度
		tasteLable三餐口味
		breakfastLabel 早餐就餐情况
		supperLabel 夜宵就餐情况
		retMap.put("label", regularLable + "," + tasteLable + "," + breakfastLabel + "," + supperLabel);
		*/
		try {
			Map<String, Object> dietLableMap = iConsumeAnalysisService.getDietLable(StudentNo);
			String  dietLable = (String)dietLableMap.get("label");
			dietLable =dietLable.replace(",", " ,")+" ,";
			String [] dietLableMapArray =  dietLable.split(",");
			//三餐规律度
			String threeMealsRegularity = dietLableMapArray[0].trim();
			excellentSample.setThreeMealsRegularity(threeMealsRegularity);
			//早餐就餐情况
			String breakfastSituation = dietLableMapArray[2].trim();
			excellentSample.setBreakfastSituation(breakfastSituation);
		} catch (Exception e) {
			logger.error("学生成长成长目标和群体指标展示,查询三餐标签异常：学号："+StudentNo,e);
		}
		try {
			//上网健康度
			Map<String,Object> internetHealthMap = iStudentNetTimeInfoService.getNetHealthRatio(StudentNo);
			String internetHealth = (String)internetHealthMap.get("healthInfo");
			excellentSample.setInternetHealth(internetHealth);
		} catch (Exception e) {
			logger.error("学生成长成长目标和群体指标展示,上网健康度异常：学号："+StudentNo,e);
		}
		return excellentSample;
    }

    /**
	 * 学生成长设置成长目群体超越、持平、 偏差大统计项
	 * @return
	 */
	@Override
	public JsonResult detailedComparison(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ) {
		logger.info("学生成长设置成长目群体超越、持平、 偏差大统计项入参:"+studentGraduationTargetREQ.getStudentNo());
		JsonResult jsonResult = new JsonResult();
		//1、查询学生有没有设置成长目标
		StudentGraduationTarget studentGraduationTarget = iStudentGraduationTargetDAO.getStudentArgetInfoByStudentNo(studentGraduationTargetREQ.getStudentNo());
		if(studentGraduationTarget ==null){
			logger.info("学生成长设置成长目群体超越、持平、 偏差大统计项,未设置成长目标，学号:"+studentGraduationTargetREQ.getStudentNo());
			jsonResult.getErrorCode();
			jsonResult.setMsg("未设置成长目标");
			return jsonResult;
		}
		//2、获取和自己设置相同目标的师哥师姐学号
		String argetType = studentGraduationTarget.getArgetType();
		List<String> StudentNoList = getStudentNoList(argetType, studentGraduationTargetREQ.getStudentNo());
		if(StudentNoList.size()<=0){
			logger.info("学生成长设置成长目群体超越、持平、 偏差大统计项,未查询到学长学号，学号:"+studentGraduationTargetREQ.getStudentNo());
			jsonResult.getErrorCode();
			jsonResult.setMsg("没有与设置的目标相同的学长");
			return jsonResult;
		}
		//3、群体平均
		long count = iStudentGraduateIndexInfoDAO.getGraduateIndexInfoCount(StudentNoList);
		if(count<=0){
			logger.info("学生成长设置成长目群体超越、持平、 偏差大统计项,未查询到学长指标信息，学号:"+studentGraduationTargetREQ.getStudentNo());
			jsonResult.getErrorCode();
			jsonResult.setMsg("未查询到学长指标信息");
			return jsonResult;
		}
		DetailedComparisonRES detailedComparisonRES = getDetailedComparisonRES(StudentNoList, new BigDecimal(count),studentGraduationTargetREQ.getStudentNo());
		jsonResult.setObj(detailedComparisonRES);
		jsonResult.getSuccess();
		return jsonResult;
	}


	private DetailedComparisonRES getDetailedComparisonRES(List<String> StudentNoList, BigDecimal count,String StudentNo) {
		DetailedComparisonRES detailedComparisonDTO = new DetailedComparisonRES();
		//查询群体平均
		StudentGraduateIndexInfo graduateIndexInfoGruop = getGraduateIndexInfoGroup(StudentNoList, count);
		int transcend =0;//超越
		int equal = 0;//持平
		int deviation = 0;//偏差
		BigDecimal zero = new BigDecimal(0);
		BigDecimal equalValue = new BigDecimal(-0.05);
		BigDecimal deviationValue = new BigDecimal(-0.2);
		try {
			BigDecimal averageAchievementTotal = new BigDecimal(0);
			List<StudentScoresRES> scoreList = iStudentAttributeService.getScoreData(StudentNo);
			for(StudentScoresRES studentScoresRES:scoreList){
				averageAchievementTotal = averageAchievementTotal.add(new BigDecimal(studentScoresRES.getAverageScore()));
			}
			BigDecimal averageAchievement = new BigDecimal(0);
			if(scoreList.size()>0){
				averageAchievement = averageAchievementTotal.divide(new BigDecimal(scoreList.size()),2, RoundingMode.HALF_UP);
			}
			BigDecimal averageAchievementGruop = graduateIndexInfoGruop.getAverageAchievement();
			BigDecimal value = averageAchievement.subtract(averageAchievementGruop);
			BigDecimal valueCompare = value.divide(averageAchievementGruop,6,RoundingMode.HALF_UP);
			if(valueCompare.compareTo(zero)==1){
				transcend = transcend+1;
			}else if(valueCompare.compareTo(zero)<1&&valueCompare.compareTo(equalValue)!=-1){
				equal = equal+1;
			}else if(valueCompare.compareTo(deviationValue)<1){
				deviation = deviation+1;
			}else{
				equal = equal+1;
			}

		} catch (Exception e) {
			logger.error("学生成长设置成长目群体超越、持平、 偏差大统计项;平均成绩异常，学号："+StudentNo,e);
		}
	    /*
		  查询学生学习相关标签
		learningLeveLable 学习水平
		scoreLable 成绩稳定性
		classLable 上课纪律
		failLable  挂科次数
		forecastLable 成绩预测
		truancyLable  疑似逃课
		map.put("label", learningLeveLable + "," + scoreLable +  "," + classLable + "," + failLable + "," + forecastLable + "," + truancyLable);
		*/
		try {
			Map<String,Object> studiesLabelMap =  iStudiesAnalysisService.getStudiesLabel(StudentNo);
			String studiesLabel = (String)studiesLabelMap.get("label");
			studiesLabel = studiesLabel.replace(",", " ,")+" ,";
			String [] studiesLabelArray = studiesLabel.split(",");
			//学习水平
		    String studyLevel = studiesLabelArray[0].trim();
		    List<TradeTypeModel> studyLevelList = StudyLevelValue.getTradeTypeList();
			BigDecimal studyLevelValue = new BigDecimal(averageIndexValue(studyLevel, studyLevelList));
			BigDecimal studyLevelGruop = graduateIndexInfoGruop.getStudyLevel();
			BigDecimal value = studyLevelValue.subtract(studyLevelGruop);
			BigDecimal valueCompare = value.divide(studyLevelGruop,6,RoundingMode.HALF_UP);
			if(valueCompare.compareTo(zero)==1){
				transcend = transcend+1;
			}else if(valueCompare.compareTo(zero)<1&&valueCompare.compareTo(equalValue)!=-1){
				equal = equal+1;
			}else  if(valueCompare.compareTo(deviationValue)<1){
				deviation = deviation+1;
			}else{
				equal = equal+1;
			}
			//成绩稳定性
		    String achievementStatus = studiesLabelArray[1].trim();
		    List<TradeTypeModel> achievementStatusList = AchievementStatusValue.getTradeTypeList();
			BigDecimal achievementStatusValue = new BigDecimal(averageIndexValue(achievementStatus, achievementStatusList));
			BigDecimal achievementStatusGruop = graduateIndexInfoGruop.getAchievementStatus();
			BigDecimal valueAchievementStatus = achievementStatusValue.subtract(achievementStatusGruop);
			BigDecimal valueAchievementStatusGruopCompare = valueAchievementStatus.divide(achievementStatusGruop,6,RoundingMode.HALF_UP);
			if(valueAchievementStatusGruopCompare.compareTo(zero)==1){
				transcend = transcend+1;
			}else if(valueAchievementStatusGruopCompare.compareTo(zero)<1&&valueAchievementStatusGruopCompare.compareTo(equalValue)!=-1){
				equal = equal+1;
			}else if(valueAchievementStatusGruopCompare.compareTo(deviationValue)<1){
				deviation = deviation+1;
			}else{
				equal = equal+1;
			}
		} catch (Exception e) {
			logger.error("学生成长设置成长目群体超越、持平、 偏差大统计项,查询学生学习相关标签异常：学号："+StudentNo,e);
		}
		//到课率
		try {
			BigDecimal toClassRateTotal = new BigDecimal(0);
			List<StudentClassRateRES> toClassRateList = iStudentAttributeService.getClassRate(StudentNo);
			for(StudentClassRateRES studentClassRateRES: toClassRateList){
				toClassRateTotal = toClassRateTotal.add(new BigDecimal(studentClassRateRES.getCourseRate()));
			}
			BigDecimal toClassRate =  new BigDecimal(0);
			if(toClassRateList.size()>0){
				toClassRate = toClassRateTotal.divide(new BigDecimal(toClassRateList.size()),2, RoundingMode.HALF_UP);
			}
			BigDecimal toClassRateGruop = graduateIndexInfoGruop.getToClassRate();
			BigDecimal value = toClassRate.subtract(toClassRateGruop);
			BigDecimal valueCompare = value.divide(toClassRateGruop,6,RoundingMode.HALF_UP);
			if(valueCompare.compareTo(zero)==1){
				transcend = transcend+1;
			}else if(valueCompare.compareTo(zero)<1&&valueCompare.compareTo(equalValue)!=-1){
				equal = equal+1;
			}else if(valueCompare.compareTo(deviationValue)<1){
				deviation = deviation+1;
			}else{
				equal = equal+1;
			}
		} catch (Exception e) {
			logger.error("学生成长设置成长目群体超越、持平、 偏差大统计项到课率异常，学号："+StudentNo,e);
		}
		//准点率
		try {
			List<StudentOnTimeRateRES> punctualityRateList = iStudentAttributeService.getOnTimeRate(StudentNo);
			BigDecimal punctualityRatetotal = new BigDecimal(0);
			for(StudentOnTimeRateRES studentOnTimeRateRES:punctualityRateList){
				punctualityRatetotal = punctualityRatetotal.add(new BigDecimal(studentOnTimeRateRES.getOnTimeRate()));
			}
			BigDecimal punctualityRate = new BigDecimal(0);
			if(punctualityRateList.size()>0){
				punctualityRate = punctualityRatetotal.divide(new BigDecimal(punctualityRateList.size()),2, RoundingMode.HALF_UP);
			}
			BigDecimal punctualityRateGruop = graduateIndexInfoGruop.getPunctualityRate();
			BigDecimal value = punctualityRate.subtract(punctualityRateGruop);
			BigDecimal valueCompare = value.divide(punctualityRateGruop,6,RoundingMode.HALF_UP);
			if(valueCompare.compareTo(zero)==1){
				transcend = transcend+1;
			}else if(valueCompare.compareTo(zero)<1&&valueCompare.compareTo(equalValue)!=-1){
				equal = equal+1;
			}else if(valueCompare.compareTo(deviationValue)<1){
				deviation = deviation+1;
			}else{
				equal = equal+1;
			}
		} catch (Exception e) {
			logger.error("学生成长设置成长目群体超越、持平、 偏差大统计项准点率异常，学号："+StudentNo,e);
		}
		//第二课堂
		try {
			Map<String,Integer> secondClassroomReward = (Map<String, Integer>) iStudentAwardService.listAwardByStudentNo(StudentNo);
			BigDecimal rewards = new BigDecimal(secondClassroomReward.get(RewardsDataType.totalAwardCount.toString()));
			//奖励总数
			BigDecimal rewardsGruop = graduateIndexInfoGruop.getRewards();
			BigDecimal value = rewards.subtract(rewardsGruop);
			BigDecimal valueCompare = value.divide(rewardsGruop,6,RoundingMode.HALF_UP);
			if(valueCompare.compareTo(zero)==1){
				transcend = transcend+1;
			}else if(valueCompare.compareTo(zero)<1&&valueCompare.compareTo(equalValue)!=-1){
				equal = equal+1;
			}else if(valueCompare.compareTo(deviationValue)<1){
				deviation = deviation+1;
			}else{
				equal = equal+1;
			}
			BigDecimal countryRewards = new BigDecimal(secondClassroomReward.get(RewardsDataType.total_A.toString()));
			//国家级奖励总数量
			BigDecimal countryRewardsGruop = graduateIndexInfoGruop.getCountryRewards();
			BigDecimal valueCountryRewards = countryRewards.subtract(countryRewardsGruop);
			BigDecimal valueCountryRewardsCompare = valueCountryRewards.divide(countryRewardsGruop,6,RoundingMode.HALF_UP);
			if(valueCountryRewardsCompare.compareTo(zero)==1){
				transcend = transcend+1;
			}else if(valueCountryRewardsCompare.compareTo(zero)<1&&valueCountryRewardsCompare.compareTo(equalValue)!=-1){
				equal = equal+1;
			}else if(valueCountryRewardsCompare.compareTo(deviationValue)<1){
				deviation = deviation+1;
			}else {
				equal = equal+1;
			}
			BigDecimal schoolRewards= new BigDecimal(secondClassroomReward.get(RewardsDataType.total_B.toString()));
			//校级奖励总数量
			BigDecimal schoolRewardsGruop = graduateIndexInfoGruop.getSchoolRewards();
			BigDecimal valueSchoolRewards = schoolRewards.subtract(schoolRewardsGruop);
			BigDecimal valueSchoolRewardsCompare = valueSchoolRewards.divide(schoolRewardsGruop,6,RoundingMode.HALF_UP);
			if(valueSchoolRewardsCompare.compareTo(zero)==1){
				transcend = transcend+1;
			}else if(valueSchoolRewardsCompare.compareTo(zero)<1&&valueSchoolRewardsCompare.compareTo(equalValue)!=-1){
				equal = equal+1;
			}else if(valueSchoolRewardsCompare.compareTo(deviationValue)<1){
				deviation = deviation+1;
			}else {
				equal = equal+1;
			}

			Map<String,Long> secondClassroomCompetitionAndActivity = iStudentExtracurrCreditsService.countByStudentNo(StudentNo);
			BigDecimal competition = new BigDecimal(secondClassroomCompetitionAndActivity.get(CompetitionAndActivityDataType.js_count.toString()));
			//参与竞赛数js_count
			BigDecimal competitionGruop = graduateIndexInfoGruop.getCompetition();
			BigDecimal valueCompetition = competition.subtract(competitionGruop);
			BigDecimal valueCompetitionCompare = valueCompetition.divide(competitionGruop,6,RoundingMode.HALF_UP);
			if(valueCompetitionCompare.compareTo(zero)==1){
				transcend = transcend+1;
			}else if(valueCompetitionCompare.compareTo(zero)<1&&valueCompetitionCompare.compareTo(equalValue)!=-1){
				equal = equal+1;
			}else if(valueCompetitionCompare.compareTo(deviationValue)<1){
				deviation = deviation+1;
			}else {
				equal = equal+1;
			}
			BigDecimal activity = new BigDecimal(secondClassroomCompetitionAndActivity.get(CompetitionAndActivityDataType.hd_count.toString()));
			//参与活动数hd_count
			BigDecimal activityGruop = graduateIndexInfoGruop.getActivity();
			BigDecimal valueaActivity = activity.subtract(activityGruop);
			BigDecimal valueActivityCompare = valueaActivity.divide(activityGruop,6,RoundingMode.HALF_UP);
			if(valueActivityCompare.compareTo(zero)==1){
				transcend = transcend+1;
			}else if(valueActivityCompare.compareTo(zero)<1&&valueActivityCompare.compareTo(equalValue)!=-1){
				equal = equal+1;
			}else if(valueActivityCompare.compareTo(deviationValue)<1){
				deviation = deviation+1;
			}else{
				equal = equal+1;
			}
		} catch (Exception e) {
			logger.error("学生成长设置成长目群体超越、持平、 偏差大统计项奖励、活动、竞赛异常，学号："+StudentNo,e);
		}
		//图书借阅数量
	    try {
			Integer borrowBookCount = iStudentAttributeService.CountBookBorrow(StudentNo);
			if(borrowBookCount!=null){
				BigDecimal borrowBook = new BigDecimal(borrowBookCount);
				BigDecimal borrowBookGruop = graduateIndexInfoGruop.getBorrowBook();
				BigDecimal value = borrowBook.subtract(borrowBookGruop);
				BigDecimal valueCompare = value.divide(borrowBookGruop,6,RoundingMode.HALF_UP);
				if(valueCompare.compareTo(zero)==1){
					transcend = transcend+1;
				}else if(valueCompare.compareTo(zero)<1&&valueCompare.compareTo(equalValue)!=-1){
					equal = equal+1;
				}else if(valueCompare.compareTo(deviationValue)<1){
					deviation = deviation+1;
				}else{
					equal = equal+1;
				}
			}
		} catch (Exception e) {
			logger.error("学生成长设置成长目群体超越、持平、 偏差大统计项图书借阅数异常，学号："+StudentNo,e);
		}

	    /*
	    //朋友广泛性
	    private String friendsUniversality;
	   */
		try {
			Map<String,Object> studentCartRelationMap = iStudentRelationInfoService.studentCartRelationTag(StudentNo);
			//整体情况
			String overallSituation = (String)studentCartRelationMap.get("social");
			if("社交王子".equals(overallSituation)||"社交公主".equals(overallSituation)){
				overallSituation="社交王";
			}
			List<TradeTypeModel> socialConnectionsList = SocialConnectionsValue.getTradeTypeList();
			BigDecimal socialConnections = new BigDecimal(averageIndexValue(overallSituation, socialConnectionsList));
			BigDecimal socialConnectionsGruop = graduateIndexInfoGruop.getSocialConnections();
			BigDecimal valueSocialConnections = socialConnections.subtract(socialConnectionsGruop);
			BigDecimal valueSocialConnectionsCompare = valueSocialConnections.divide(socialConnectionsGruop,6,RoundingMode.HALF_UP);
			if(valueSocialConnectionsCompare.compareTo(zero)==1){
				transcend = transcend+1;
			}else if(valueSocialConnectionsCompare.compareTo(zero)<1&&valueSocialConnectionsCompare.compareTo(equalValue)!=-1){
				equal = equal+1;
			}else if(valueSocialConnectionsCompare.compareTo(deviationValue)<1){
				deviation = deviation+1;
			}else{
				equal = equal+1;
			}
			//宿舍关系情况
			String dormitoryRelationship = (String)studentCartRelationMap.get("drom");
			List<TradeTypeModel> dormitoryRelationshipList = DormitoryRelationshipValue.getTradeTypeList();
		    BigDecimal dormitoryRelationshipValue = new BigDecimal(averageIndexValue(dormitoryRelationship, dormitoryRelationshipList));
			BigDecimal dormitoryRelationshipGruop = graduateIndexInfoGruop.getDormitoryRelationship();
			BigDecimal valueDormitoryRelationship = dormitoryRelationshipValue.subtract(dormitoryRelationshipGruop);
			BigDecimal valueDormitoryRelationshipCompare = valueDormitoryRelationship.divide(dormitoryRelationshipGruop,6,RoundingMode.HALF_UP);
			if(valueDormitoryRelationshipCompare.compareTo(zero)==1){
				transcend = transcend+1;
			}else if(valueDormitoryRelationshipCompare.compareTo(zero)<1&&valueDormitoryRelationshipCompare.compareTo(equalValue)!=-1){
				equal = equal+1;
			}else if(valueDormitoryRelationshipCompare.compareTo(deviationValue)<1){
				deviation = deviation+1;
			}else{
				equal = equal+1;
			}
		} catch (Exception e) {
			logger.error("学生成长设置成长目群体超越、持平、 偏差大统计项,查询社交关系异常：学号："+StudentNo,e);
		}
	    /*
	    //学霸交友情况
	    private String superScholarFriends;
	    */
		/*
		        查询睡眠标签
		sleepSitLable 睡眠起床情况
		sleepTimeLable查询日均睡眠时长
		leaveSchoolLable外出情况
		map.put("lable", "," + sleepSitLable.toString() + "," + sleepTimeLable.toString() + "," + leaveSchoolLable.toString());
		*/
		/*try {
			Map<String, Object> sleepLableMap = IStudentRestAnalysisService.querySleepLable(StudentNo);
			String  sleepLable = (String)sleepLableMap.get("label");
			sleepLable = sleepLable.replace(",", " ,")+" ,";
			String [] sleepLableMapArray =  sleepLable.split(",");

			 //作息规律度
			private String workRestRegularity;
			//睡眠起床情况
			String sleepSituation = sleepLableMapArray[0].trim();
			List<TradeTypeModel> sleepSituationList = SleepSituationValue.getTradeTypeList();
		    BigDecimal sleepSituationValue = new BigDecimal(averageIndexValue(sleepSituation, sleepSituationList));
			BigDecimal sleepSituationGruop = graduateIndexInfoGruop.getSleepSituation();
			BigDecimal valueSleepSituation = sleepSituationValue.subtract(sleepSituationGruop);
			BigDecimal valueSleepSituationCompare = valueSleepSituation.divide(sleepSituationGruop,6,RoundingMode.HALF_UP);
			if(valueSleepSituationCompare.compareTo(zero)==1){
				transcend = transcend+1;
			}
			if(valueSleepSituationCompare.compareTo(zero)<1&&valueSleepSituationCompare.compareTo(equalValue)!=-1){
				equal = equal+1;
			}
			if(valueSleepSituationCompare.compareTo(deviationValue)<1){
				deviation = deviation+1;
			}
			//睡眠时长
			String sleepTime = sleepLableMapArray[1].trim();
			List<TradeTypeModel> sleepTimeList = SleepTimeValue.getTradeTypeList();
		    BigDecimal sleepTimeValue = new BigDecimal(averageIndexValue(sleepTime, sleepTimeList));
			BigDecimal sleepTimeGruop = graduateIndexInfoGruop.getSleepTime();
			BigDecimal valueSleepTime = sleepTimeValue.subtract(sleepTimeGruop);
			BigDecimal valueSleepTimeCompare = valueSleepTime.divide(sleepTimeGruop,6,RoundingMode.HALF_UP);
			if(valueSleepTimeCompare.compareTo(zero)==1){
				transcend = transcend+1;
			}
			if(valueSleepTimeCompare.compareTo(zero)<1&&valueSleepTimeCompare.compareTo(equalValue)!=-1){
				equal = equal+1;
			}
			if(valueSleepTimeCompare.compareTo(deviationValue)<1){
				deviation = deviation+1;
			}
			//外出情况
			String outSituation = sleepLableMapArray[2].trim();
			if("宅男".equals(outSituation)||"宅女".equals(outSituation)){
				outSituation="宅宿舍";
			}
			List<TradeTypeModel> outSituationList = OutSituationValue.getTradeTypeList();
		    BigDecimal outSituationValue = new BigDecimal(averageIndexValue(outSituation, outSituationList));
			BigDecimal outSituationGruop = graduateIndexInfoGruop.getOutSituation();
			BigDecimal valueOutSituation = outSituationValue.subtract(outSituationGruop);
			BigDecimal valueOutSituationCompare = valueOutSituation.divide(outSituationGruop,6,RoundingMode.HALF_UP);
			if(valueOutSituationCompare.compareTo(zero)==1){
				transcend = transcend+1;
			}
			if(valueOutSituationCompare.compareTo(zero)<1&&valueOutSituationCompare.compareTo(equalValue)!=-1){
				equal = equal+1;
			}
			if(valueOutSituationCompare.compareTo(deviationValue)<1){
				deviation = deviation+1;
			}
		} catch (Exception e) {
			logger.error("学生成长设置成长目群体超越、持平、 偏差大统计项,查询睡眠标签异常：学号："+StudentNo,e);
		}*/
		 try {
				//上网健康度
				Map<String,Object> internetHealthMap = iStudentNetTimeInfoService.getNetHealthRatio(StudentNo);
				String internetHealth = (String)internetHealthMap.get("healthInfo");
				List<TradeTypeModel> internetHealthList = InternetHealthValue.getTradeTypeList();
			    BigDecimal internetHealthValue = new BigDecimal(averageIndexValue(internetHealth, internetHealthList));
				BigDecimal internetHealthGruop = graduateIndexInfoGruop.getInternetHealth();
				BigDecimal valueInternetHealth = internetHealthValue.subtract(internetHealthGruop);
				BigDecimal valueInternetHealthCompare = valueInternetHealth.divide(internetHealthGruop,6,RoundingMode.HALF_UP);
				if(valueInternetHealthCompare.compareTo(zero)==1){
					transcend = transcend+1;
				}else if(valueInternetHealthCompare.compareTo(zero)<1&&valueInternetHealthCompare.compareTo(equalValue)!=-1){
					equal = equal+1;
				}else if(valueInternetHealthCompare.compareTo(deviationValue)<1){
					deviation = deviation+1;
				}else{
					equal = equal+1;
				}
			} catch (Exception e) {
				logger.error("学生成长设置成长目群体超越、持平、 偏差大统计项,上网健康度异常：学号："+StudentNo,e);
			}
		 /*
		        查询三餐标签
		regularLable三餐规律度
		tasteLable三餐口味
		breakfastLabel 早餐就餐情况
		supperLabel 夜宵就餐情况
		retMap.put("label", regularLable + "," + tasteLable + "," + breakfastLabel + "," + supperLabel);
		*/
		try {
			Map<String, Object> dietLableMap = iConsumeAnalysisService.getDietLable(StudentNo);
			String  dietLable = (String)dietLableMap.get("label");
			dietLable =dietLable.replace(",", " ,")+" ,";
			String [] dietLableMapArray =  dietLable.split(",");
			//三餐规律度
			String threeMealsRegularity = dietLableMapArray[0].trim();
			List<TradeTypeModel> threeMealsRegularityList = ThreeMealsRegularityValue.getTradeTypeList();
		    BigDecimal threeMealsRegularityValue = new BigDecimal(averageIndexValue(threeMealsRegularity, threeMealsRegularityList));
			BigDecimal threeMealsRegularityGruop = graduateIndexInfoGruop.getThreeMealsRegularity();
			BigDecimal valueThreeMealsRegularity = threeMealsRegularityValue.subtract(threeMealsRegularityGruop);
			BigDecimal valueThreeMealsRegularityCompare = valueThreeMealsRegularity.divide(threeMealsRegularityGruop,6,RoundingMode.HALF_UP);
			if(valueThreeMealsRegularityCompare.compareTo(zero)==1){
				transcend = transcend+1;
			}else if(valueThreeMealsRegularityCompare.compareTo(zero)<1&&valueThreeMealsRegularityCompare.compareTo(equalValue)!=-1){
				equal = equal+1;
			}else if(valueThreeMealsRegularityCompare.compareTo(deviationValue)<1){
				deviation = deviation+1;
			}else {
				equal = equal+1;
			}
			//早餐就餐情况
			String breakfastSituation = dietLableMapArray[2].trim();
			List<TradeTypeModel> breakfastSituationList = BreakfastSituationValue.getTradeTypeList();
		    BigDecimal breakfastSituationValue = new BigDecimal(averageIndexValue(breakfastSituation, breakfastSituationList));
			BigDecimal breakfastSituationGruop = graduateIndexInfoGruop.getBreakfastSituation();
			BigDecimal valueBreakfastSituation = breakfastSituationValue.subtract(breakfastSituationGruop);
			BigDecimal valueBreakfastSituationCompare = valueBreakfastSituation.divide(breakfastSituationGruop,6,RoundingMode.HALF_UP);
			if(valueBreakfastSituationCompare.compareTo(zero)==1){
				transcend = transcend+1;
			}else if(valueBreakfastSituationCompare.compareTo(zero)<1&&valueBreakfastSituationCompare.compareTo(equalValue)!=-1){
				equal = equal+1;
			}else if(valueBreakfastSituationCompare.compareTo(deviationValue)<1){
				deviation = deviation+1;
			}else {
				equal = equal+1;
			}
		} catch (Exception e) {
			logger.error("学生成长设置成长目群体超越、持平、 偏差大统计项,查询三餐标签异常：学号："+StudentNo,e);
		}
		detailedComparisonDTO.setTranscend(transcend);
		detailedComparisonDTO.setEqual(equal);
		detailedComparisonDTO.setDeviation(deviation);
		return detailedComparisonDTO;
	}
	/**
	 * 根据name拿到枚举的value
	 * @param name
	 * @param list
	 * @return
	 */
	public  String averageIndexValue(String name , List<TradeTypeModel> list){
		String indexValue ="0";
	    for(TradeTypeModel model:list){
	    	String indexName = model.getName();
	    	if(indexName.equals(name)){
	    		indexValue = model.getValue();
	    		break;
	    	}
	    }
		return indexValue;
	 }

	/**
	 * 根据学号查询学生成长目标信息（代码和名称都显示）
	 * @return
	 */
	@Override
	public JsonResult getArgetInfoAll(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ){
		JsonResult jsonResult = new JsonResult();
		logger.info("查询学生成长目标信息代码和名称都显示入参:"+studentGraduationTargetREQ.getStudentNo());
		StudentGraduationTarget studentGraduationTarget = iStudentGraduationTargetDAO.getStudentArgetInfoByStudentNo(studentGraduationTargetREQ.getStudentNo());
		if(studentGraduationTarget ==null){
			logger.info("查询学生成长目标信息代码和名称都显示,未设置成长目标，学号:"+studentGraduationTargetREQ.getStudentNo());
			jsonResult.getErrorCode();
			jsonResult.setMsg("未设置成长目标");
			return jsonResult;
		}
	    String argetType = studentGraduationTarget.getArgetType();//目标分类   读研 READ   就业 WORK
	    StudentArgetAllRES studentArgetAllRES = new StudentArgetAllRES();
		studentArgetAllRES.setStudentNo(studentGraduationTargetREQ.getStudentNo());
	    if(ArgetType.READ.getValue().equals(argetType)){
			//读研
			studentArgetAllRES.setArgetType(ArgetType.READ);
	    	List<StudentReadSchoolInfo> readSchoolInfoList = iStudentReadSchoolInfoDAO.getByStudentNoAllInfo(studentGraduationTargetREQ.getStudentNo());
	    	List<String>  list = new ArrayList<String>();
	    	for(StudentReadSchoolInfo studentReadSchoolInfo:readSchoolInfoList){
	    		list.add( studentReadSchoolInfo.getSchoolName());
	    	}
	    	studentArgetAllRES.setSchoolInfo(list);
	    }else if(ArgetType.WORK.getValue().equals(argetType)){
			//就业
	    	studentArgetAllRES.setArgetType(ArgetType.WORK);

			List<StudentPositionTypeInfo> positionTypeInfolist = iStudentPositionTypeInfoDAO.getByStudentNoAllInfo(studentGraduationTargetREQ.getStudentNo());

			StudentIndustryTypeInfo industryTypeInfo = iStudentIndustryTypeInfoDAO.getIndustryTypeInfo(studentGraduationTargetREQ.getStudentNo());
			studentArgetAllRES.setIndustryName(industryTypeInfo.getIndustryName());
			List<String>  list = new ArrayList<String>();
			for(StudentPositionTypeInfo positionTypeInfo:positionTypeInfolist){
				list.add(positionTypeInfo.getPositionName());
			}
			studentArgetAllRES.setArgetWorkInfo(list);
		}else{
			//其他
			logger.info("查询学生成长目标信息代码和名称都显示,无此目标分类，学号:"+studentGraduationTargetREQ.getStudentNo());
			jsonResult.getErrorCode();
			jsonResult.setMsg("成长目标目标分类错误");
			return jsonResult;
		}
	    jsonResult.setObj(studentArgetAllRES);
		jsonResult.getSuccess();
		return jsonResult;
	}
}
