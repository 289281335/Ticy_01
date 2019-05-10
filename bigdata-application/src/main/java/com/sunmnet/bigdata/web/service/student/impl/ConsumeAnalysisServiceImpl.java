package com.sunmnet.bigdata.web.service.student.impl;

import com.sunmnet.bigdata.web.dao.student.*;
import com.sunmnet.bigdata.web.model.entity.student.*;
import com.sunmnet.bigdata.web.model.request.student.WholePortraitREQ;
import com.sunmnet.bigdata.web.model.response.student.*;
import com.sunmnet.bigdata.web.service.student.IConsumeAnalysisService;
import com.sunmnet.bigdata.web.service.student.IStudentInfoService;
import com.sunmnet.bigdata.web.util.BusinessUtils;
import com.sunmnet.bigdata.web.util.DateUtils;
import com.sunmnet.bigdata.web.util.MathUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * 学生消费数据分析服务
 * @author
 *
 */
@Service
public class ConsumeAnalysisServiceImpl implements IConsumeAnalysisService {

	@Resource
	private IStudentInfoService iStudentInfoService;

	@Resource
	private IStudentConsumeRecordDAO iStudentConsumeRecordDAO;

	@Resource
	private IStudentConsumePlaceDAO iStudentConsumePlaceDAO;

	@Resource
	private IStudentConsumeInfoDAO iStudentConsumeInfoDAO;

	@Resource
	private IStudentConsumeRegularDAO iStudentConsumeRegularDAO;

	@Resource
	private IStudentSupportInfoDAO iStudentSupportInfoDAO;

	@Resource
	private IPovertyStudentAnalyseDAO iPovertyStudentAnalyseDAO;

	@Resource
	private IStudentInfoDAO iStudentInfoDAO;

	/**
	 * 查询学生最近的就餐情况(三餐)
	 */
	@Override
	public List<StudentConsumeRecord> listLatestDietSituation(String studentNo){
		List<StudentConsumeRecord> retList = new ArrayList<StudentConsumeRecord>();
		//查询最新的消费日期
		String dietDate = iStudentConsumeRecordDAO.getLatestDietDate();
		//获取最近15天的日期列表
		List<String> dateList = new ArrayList<String>();
		Long time = DateUtils.parseDate(dietDate).getTime();
		Date currDate = new Date();
		for(int i = 0; i < 15; i++) {
			currDate.setTime(time - (i * 60 * 60 * 24 * 1000));
			dateList.add(DateUtils.dateToString(currDate, "yyyy-MM-dd"));
		}

		//查询最新的消费记录
		StudentConsumeRecord studentConsumeRecord = new StudentConsumeRecord();
		studentConsumeRecord.setStudentNo(studentNo);
		studentConsumeRecord.setConsumeDate(dietDate);
		List<StudentConsumeRecord> list = iStudentConsumeRecordDAO.listLatestDietSituation(studentConsumeRecord);
		for(String date : dateList) {
			StudentConsumeRecord newRecord = null;
			for(StudentConsumeRecord record : list) {
				if(date.equals(record.getConsumeDate())) {
					newRecord = record;
					break;
				}
			}

			if(newRecord == null) {
				newRecord = new StudentConsumeRecord();
				newRecord.setStudentNo(studentNo);
				newRecord.setConsumeDate(date);
				newRecord.setBreakfastTimes(0);
				newRecord.setLunchTimes(0);
				newRecord.setDinnerTimes(0);
				newRecord.setSupperTimes(0);
			}

			retList.add(newRecord);
		}
		return retList;
	}

	/**
	 * 查询学生就餐地点情况(三餐)
	 */
	@Override
	public Map<String, Object> getDietPlace(String studentNo){
		Map<String, Object> retMap = new HashMap<String, Object>();
		List<StudentConsumePlace> list = iStudentConsumePlaceDAO.getDietPlace(studentNo,
				BusinessUtils.getStartDateBySchoolYear(null),
				BusinessUtils.getEndDateBySchoolYear(null));
		retMap.put("drinkList", this.getConsumePlaceByType(list, "饮料"));
		retMap.put("drinkAmount", this.calculateFoodAmount(list, "饮料"));
		retMap.put("ethnicfoodList", this.getConsumePlaceByType(list, "民族特色"));
		retMap.put("ethnicfoodAmount", this.calculateFoodAmount(list, "民族特色"));
		retMap.put("europeanfoodList", this.getConsumePlaceByType(list, "西餐厅"));
		retMap.put("europeanfoodAmount", this.calculateFoodAmount(list, "西餐厅"));
		retMap.put("fruitList", this.getConsumePlaceByType(list, "水果"));
		retMap.put("fruitAmount", this.calculateFoodAmount(list, "水果"));
		retMap.put("noodleList", this.getConsumePlaceByType(list, "面食"));
		retMap.put("noodleAmount", this.calculateFoodAmount(list, "面食"));
		retMap.put("riceList", this.getConsumePlaceByType(list, "米饭"));
		retMap.put("riceAmount", this.calculateFoodAmount(list, "米饭"));
		retMap.put("snackList", this.getConsumePlaceByType(list, "小吃"));
		retMap.put("snackAmount", this.calculateFoodAmount(list, "小吃"));
		retMap.put("soupList", this.getConsumePlaceByType(list, "汤粉米线"));
		retMap.put("soupAmount", this.calculateFoodAmount(list, "汤粉米线"));
		return retMap;
	}

	/**
	 * 查询学生三餐消费金额趋势信息(三餐)
	 */
	@Override
	public Map<String, Object> getDietAmount(String studentNo){
		Map<String, Object> retMap = new HashMap<String, Object>();

		//查询学生信息
		StudentInfo info = iStudentInfoService.getStudentByNo(studentNo);
		//查询全校消费月份列表
		ArrayList<String> monthList  = this.getMonthList();
		//查询男生每月平均就餐金额列表
		if("男".equals(info.getGender())) {
			List<Map<String, Object>> maleList = iStudentConsumeInfoDAO.listMaleAverageDietDataMonth(monthList.get(0));
			retMap.put("maleList", dataProcessing(maleList, monthList));
		}

		//获取女生每月平均就餐金额列表
		if("女".equals(info.getGender())) {
			List<Map<String, Object>> femaleList = iStudentConsumeInfoDAO.listFemaleAverageDietDataMonth(monthList.get(0));
			retMap.put("femaleList", dataProcessing(femaleList, monthList));
		}

		//获取全校学生每月平均就餐金额列表
		List<Map<String, Object>> studentList = iStudentConsumeInfoDAO.listSchoolAverageDietDataMonth(monthList.get(0));
		retMap.put("schoolList", dataProcessing(studentList, monthList));
		retMap.put("schoolAverage", calculateAverage(studentList));


		//获取学生每月平均就餐金额列表
		List<Map<String, Object>> personList = iStudentConsumeInfoDAO.listStudentAverageDietDataMonth(studentNo, monthList.get(0));
		retMap.put("personList", dataProcessing(personList, monthList));
		retMap.put("personAverage", calculateAverage(personList));
		retMap.put("info", info.getName() + compareMonthAverage(new BigDecimal((String)retMap.get("personAverage")), new BigDecimal((String)retMap.get("schoolAverage"))));

		return retMap;
	}

	/**
	 * 查询学生三餐规律度(三餐)
	 */
	@Override
	public Map<String, Object> getDietRegular(String studentNo){
		Map<String, Object> map = new HashMap<String, Object>();
		//查询个人信息
		StudentInfo info = iStudentInfoService.getStudentByNo(studentNo);
		//查询个人三餐规律度
		BigDecimal personRegular = iStudentConsumeRegularDAO.getDietRegularByStudentNo(studentNo);
		//查询专业
		BigDecimal majorRegular = iStudentConsumeRegularDAO.getDietRegularByMajorCode(info.getMajorCode());

		//查询总记录数
		Integer count = iStudentConsumeRegularDAO.countDietRegular();

		//获取第一条记录
		StudentConsumptionIndex first = iStudentConsumeRegularDAO.getDietRegularByLineNo(0);
		//获取稳定性 较差稳定~差 的临界值
		StudentConsumptionIndex one = iStudentConsumeRegularDAO.getDietRegularByLineNo(new BigDecimal(count * 0.1).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
		//获取稳定性 一般稳定~较差的临界点
		StudentConsumptionIndex two = iStudentConsumeRegularDAO.getDietRegularByLineNo(new BigDecimal(count * 0.3).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
		//获取稳定性 比较稳定~一般稳定 稳定的临界点
		StudentConsumptionIndex three = iStudentConsumeRegularDAO.getDietRegularByLineNo(new BigDecimal(count * 0.7).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
		//获取稳定性 非常稳定~比较稳定的临界点
		StudentConsumptionIndex four = iStudentConsumeRegularDAO.getDietRegularByLineNo(new BigDecimal(count * 0.9).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
		//获取最后一条记录
		StudentConsumptionIndex end = iStudentConsumeRegularDAO.getDietRegularByLineNo(count - 1);

		map.put("one", end.getDietIndex().setScale(3, BigDecimal.ROUND_HALF_UP));
		map.put("two", four.getDietIndex().setScale(3, BigDecimal.ROUND_HALF_UP));
		map.put("three", three.getDietIndex().setScale(3, BigDecimal.ROUND_HALF_UP));
		map.put("four", two.getDietIndex().setScale(3, BigDecimal.ROUND_HALF_UP));
		map.put("five", one.getDietIndex().setScale(3, BigDecimal.ROUND_HALF_UP));
		map.put("six", first.getDietIndex().setScale(3, BigDecimal.ROUND_HALF_UP));
		map.put("personRegular", personRegular == null ? "" : personRegular.setScale(3, BigDecimal.ROUND_HALF_UP));
		map.put("majorRegular", majorRegular == null ? "" : majorRegular.setScale(3, BigDecimal.ROUND_HALF_UP));
		return map;
	}

	/**
	 * 查询学生平均每餐消费金额(贫困生)
	 */
	@Override
	public Map<String, Object> getNeedyAverageDietData(String studentNo){
		Map<String, Object> retMap = new HashMap<String, Object>();
		//查询学生信息
		StudentInfo info = iStudentInfoService.getStudentByNo(studentNo);
		//查询全校消费月份列表
		ArrayList<String> monthList  = this.getMonthList();
		//查询全校平均每餐消费金额
		Map<String, Object> schoolMap = iStudentConsumeInfoDAO.listSchoolAverageDietDataMeal(monthList.get(0));
		retMap.put("schoolInfo", schoolMap);
		//查询贫困生平均每餐消费金额
		Map<String, Object> needyMap = iStudentConsumeInfoDAO.listNeedyAverageDietDataMeal(monthList.get(0));
		retMap.put("needyInfo", needyMap);
		//查询学生平均每餐消费金额
		Map<String, Object> studentMap = iStudentConsumeInfoDAO.listStudentAverageDietDataMeal(studentNo, monthList.get(0));
		retMap.put("personInfo", studentMap);

		retMap.put("info", info.getName() + compareDayAverage(calculateEveryMealAverage(studentMap), calculateEveryMealAverage(schoolMap)));

		return retMap;
	}

	/**
	 * 查询学生最近三月消费构成信息(消费)(贫困生)
	 */
	@Override
	public Map<String, Object> getNeedyLatestConsumeStructure(String studentNo){
		Map<String, Object> retMap = new HashMap<String, Object>();
		BigDecimal totalAmount = new BigDecimal(0);
		BigDecimal dietAmount = new BigDecimal(0);
		BigDecimal supperAmount = new BigDecimal(0);
		BigDecimal internetAmount = new BigDecimal(0);
		BigDecimal marketAmount = new BigDecimal(0);
		BigDecimal bathAmount = new BigDecimal(0);
		BigDecimal hospitalAmount = new BigDecimal(0);
		BigDecimal otherAmount = new BigDecimal(0);
		BigDecimal foodAmount = new BigDecimal(0);
		BigDecimal fruitAmount = new BigDecimal(0);
		List<StudentConsumeInfo> consumeInfoList = iStudentConsumeInfoDAO.listStudentLatestThreeMonthConsumeInfo(studentNo);
		if(consumeInfoList != null && !consumeInfoList.isEmpty()) {
			for(StudentConsumeInfo info : consumeInfoList) {
				//三餐金额
				dietAmount = dietAmount.add(new BigDecimal(info.getBreakfastAmount()))
					.add(new BigDecimal(info.getLunchAmount()))
					.add(new BigDecimal(info.getDinnerAmount()));
				//夜宵金额
				supperAmount = supperAmount.add(new BigDecimal(info.getSupperAmount()));
				//水果
				fruitAmount = fruitAmount.add(new BigDecimal(info.getFruitAmount()));
				//上网金额
				internetAmount = internetAmount.add(new BigDecimal(info.getInternetAmount()));
				//超市金额
				marketAmount = marketAmount.add(new BigDecimal(info.getMarketAmount()));
				//洗澡金额
				bathAmount = bathAmount.add(new BigDecimal(info.getBathAmount()));
				//医保金额
				hospitalAmount = hospitalAmount.add(new BigDecimal(info.getHospitalAmount()));
				//其他金额
				otherAmount = otherAmount.add(new BigDecimal(info.getOtherAmount()));
			}
			//总共金额
			totalAmount = totalAmount.add(dietAmount).add(supperAmount).add(fruitAmount).add(internetAmount).add(marketAmount).add(bathAmount)
					.add(otherAmount);
			//三餐 + 夜宵 + 水果
			foodAmount = foodAmount.add(dietAmount).add(supperAmount).add(fruitAmount);

			List<ConsumeStructureRES> list = new ArrayList<ConsumeStructureRES>();
			list.add(new ConsumeStructureRES("三餐", dietAmount.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP).toString(), dietAmount.divide(totalAmount, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2).toString()));
			list.add(new ConsumeStructureRES("夜宵", supperAmount.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP).toString(), supperAmount.divide(totalAmount, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2).toString()));
			list.add(new ConsumeStructureRES("水果", fruitAmount.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP).toString(), fruitAmount.divide(totalAmount, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2).toString()));
			list.add(new ConsumeStructureRES("上网", internetAmount.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP).toString(), internetAmount.divide(totalAmount, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2).toString()));
			list.add(new ConsumeStructureRES("超市", marketAmount.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP).toString(), marketAmount.divide(totalAmount, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2).toString()));
			list.add(new ConsumeStructureRES("洗澡", bathAmount.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP).toString(), bathAmount.divide(totalAmount, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2).toString()));
			list.add(new ConsumeStructureRES("医保", hospitalAmount.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP).toString(), hospitalAmount.divide(totalAmount, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2).toString()));
			list.add(new ConsumeStructureRES("其他", otherAmount.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP).toString(), otherAmount.divide(totalAmount, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2).toString()));

			Collections.sort(list, new Comparator<ConsumeStructureRES>() {
				@Override
				public int compare(ConsumeStructureRES o1, ConsumeStructureRES o2) {
					BigDecimal b1 = new BigDecimal(o1.getConsumeRate());
					BigDecimal b2 = new BigDecimal(o2.getConsumeRate());
					return -b1.compareTo(b2);
				}
			});


			retMap.put("list", list);
			retMap.put("engel", foodAmount.divide(totalAmount, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2).toString());
		}
		return retMap;
	}

	/**
	 * 查询学生全部消费地点信息(消费)
	 */
	@Override
	public Map<String, Object> getAllConsumePlace(String studentNo){
		Map<String, Object> retMap = new HashMap<String, Object>();
		Long totalTimes = 0l;
		Long topTimes = 0l;
		List<ConsumePlaceRES> dtoList = new ArrayList<ConsumePlaceRES>();
		List<Map<String, Object>> list = iStudentConsumePlaceDAO.getAllConsumePlace(studentNo,
				BusinessUtils.getStartDateBySchoolYear(null),
				BusinessUtils.getEndDateBySchoolYear(null));
		if(list != null && !list.isEmpty()) {
			for(int i = 0; i < list.size(); i++) {
				Map<String, Object> map = list.get(i);
				ConsumePlaceRES dto = new ConsumePlaceRES();
				dto.setPlaceName((String)map.get("consumeCanteen"));
				dto.setConsumeTimes(((BigDecimal)map.get("consumeTimes")).intValue());
				dto.setConsumeAmount((BigDecimal)map.get("consumeAmount"));
				dto.setLatitude((String)map.get("latitude"));
				dto.setLongitude((String)map.get("longitude"));
				dtoList.add(dto);

				totalTimes += ((BigDecimal)map.get("consumeTimes")).intValue();
				if(i < 3) {
					topTimes += ((BigDecimal)map.get("consumeTimes")).intValue();
				}
			}
		}
		retMap.put("list", dtoList);

		if(totalTimes > 0) {
			if((double)topTimes/totalTimes < 0.6) {
				retMap.put("describe", "消费地点整体波动大，比较喜欢新鲜");
			}else {
				retMap.put("describe", "消费地点整体比较稳定");
			}
		}
		return retMap;
	}

	/**
	 * 查询学生消费金额趋势信息(消费)
	 */
	@Override
	public Map<String, Object> getConsumeAmount(String studentNo){
		Map<String, Object> retMap = new HashMap<String, Object>();

		//查询学生信息
		StudentInfo info = iStudentInfoService.getStudentByNo(studentNo);
		//查询全校消费月份列表
		ArrayList<String> monthList  = this.getMonthList();
		//查询男生每月平均消费金额列表
		if("男".equals(info.getGender())) {
			List<Map<String, Object>> maleList = iStudentConsumeInfoDAO.listMaleAverageConsumeDataMonth(monthList.get(0));
			retMap.put("maleList", dataProcessing(maleList, monthList));
		}

		//获取女生每月平均消费金额列表
		if("女".equals(info.getGender())) {
			List<Map<String, Object>> femaleList = iStudentConsumeInfoDAO.listFemaleAverageConsumeDataMonth(monthList.get(0));
			retMap.put("femaleList", dataProcessing(femaleList, monthList));
		}

		//获取全校学生每月平均消费金额列表
		List<Map<String, Object>> studentList = iStudentConsumeInfoDAO.listSchoolAverageConsumeDataMonth(monthList.get(0));
		retMap.put("schoolList", dataProcessing(studentList, monthList));
		retMap.put("schoolAverage", calculateAverage(studentList));


		//获取学生每月平均消费金额列表
		List<Map<String, Object>> personList = iStudentConsumeInfoDAO.listStudentAverageConsumeDataMonth(studentNo, monthList.get(0));
		retMap.put("personList", dataProcessing(personList, monthList));
		retMap.put("personAverage", calculateAverage(personList));

		//计算消费稳定性
		double personVariation = calculateCoefficientOfVariation(personList);
		double schoolVariation = calculateCoefficientOfVariation(studentList);
		if(personVariation > schoolVariation) {
			retMap.put("info", "月均消费金额" + retMap.get("personAverage") + ",消费金额波动大" );
		}else {
			retMap.put("info", "月均消费金额" + retMap.get("personAverage") + ",消费金额波动小" );
		}

		return retMap;
	}

	/**
	 * 查询消费指数(消费)
	 */
	@Override
	public Map<String, Object> getConsumeIndex(String studentNo){
		Map<String, Object> retMap = new HashMap<String, Object>();

		//查询全校消费月份列表
		ArrayList<String> monthList  = this.getMonthList();
		//获取全校学生每月平均消费金额列表
		List<Map<String, Object>> studentList = iStudentConsumeInfoDAO.listSchoolAverageConsumeDataMonth(monthList.get(0));
		retMap.put("schoolList", dataProcessingLevel(studentList, monthList));
		//获取学生每月平均消费金额列表
		List<Map<String, Object>> personList = iStudentConsumeInfoDAO.listStudentAverageConsumeDataMonth(studentNo, monthList.get(0));
		retMap.put("personList", dataProcessingLevel(personList, monthList));
		//个人平均得分
		double personAverage = Double.valueOf(calculateAverage(personList));
		retMap.put("personAverage", dataProcessingLevel(new BigDecimal(personAverage)));
		//全校平均得分
		double studentAverage = Double.valueOf(calculateAverage(studentList));
		retMap.put("schoolAverage", dataProcessingLevel(new BigDecimal(studentAverage)));

		return retMap;
	}

	/**
	 * 查询月均金额消费趋势(贫困生)
	 */
	@Override
	public Map<String, Object> getNeedyAverageConsumeAmountMonth(String studentNo) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		//查询全校消费月份列表
		ArrayList<String> monthList  = this.getMonthList();

		//获取全校学生每月平均消费金额列表
		List<Map<String, Object>> studentList = iStudentConsumeInfoDAO.listSchoolAverageConsumeDataMonth(monthList.get(0));
		retMap.put("schoolList", dataProcessing(studentList, monthList));

		//获取贫困生每月平均消费金额列表
		List<Map<String, Object>> needyList = iStudentConsumeInfoDAO.listNeedyAverageConsumeDataMonth(monthList.get(0));
		retMap.put("needyList", dataProcessing(needyList, monthList));

		//获取学生每月平均消费金额列表
		List<Map<String, Object>> personList = iStudentConsumeInfoDAO.listStudentAverageConsumeDataMonth(studentNo, monthList.get(0));
		retMap.put("personList", dataProcessing(personList, monthList));
		retMap.put("personAverage", calculateAverage(personList));

		//计算稳定性
		double personVariation = calculateCoefficientOfVariation(personList);
		double schoolVariation = calculateCoefficientOfVariation(studentList);
		if(personVariation > schoolVariation) {
			retMap.put("info", "月均消费金额" + retMap.get("personAverage") + ",消费金额波动大" );
		}else {
			retMap.put("info", "月均消费金额" + retMap.get("personAverage") + ",消费金额波动小" );
		}

		return retMap;
	}

	/**
	 * 查询消费水平(贫困生)
	 */
	@Override
	public Map<String, Object> getNeedyConsumeLevel(String studentNo){
		Map<String, Object> retMap = new HashMap<String, Object>();

		//查询学生信息
		StudentInfo info = iStudentInfoService.getStudentByNo(studentNo);
		//查询全校消费月份列表
		ArrayList<String> monthList  = this.getMonthList();
		//获取全校学生每月平均消费金额列表
		List<Map<String, Object>> studentList = iStudentConsumeInfoDAO.listSchoolAverageConsumeDataMonth(monthList.get(0));
		//获取贫困生每月平均消费金额列表
		List<Map<String, Object>> needyList = iStudentConsumeInfoDAO.listNeedyAverageConsumeDataMonth(monthList.get(0));

		//获取学生每月平均消费金额列表
		List<Map<String, Object>> personList = iStudentConsumeInfoDAO.listStudentAverageConsumeDataMonth(studentNo, monthList.get(0));
		retMap.put("personList", dataProcessingLevel(personList, monthList));

		double needyAverage = Double.valueOf(calculateAverage(needyList));
		double personAverage = Double.valueOf(calculateAverage(personList));
		retMap.put("needyAverage", dataProcessingLevel(new BigDecimal(needyAverage)));
		retMap.put("personAverage", dataProcessingLevel(new BigDecimal(personAverage)));

		StringBuffer retInfo = new StringBuffer(info.getName() + "消费水平");
		if(personAverage > needyAverage) {
			retInfo.append("高于全校贫困线,");
		}

		if(personAverage == needyAverage) {
			retInfo.append("等于全校贫困线,");
		}

		if(personAverage < needyAverage) {
			retInfo.append("低于全校贫困线,");
		}
		String consumeDate = (String)personList.get(personList.size() - 1).get("consumeDate");

		String currMonth = consumeDate.substring(consumeDate.indexOf("-") + 1);
		BigDecimal currPersonAverage = ((BigDecimal)personList.get(personList.size() - 1).get("averageAmount")).divide(new BigDecimal(100), 0, BigDecimal.ROUND_HALF_UP);
		BigDecimal currStudentAverage = this.getAverageAmountByConsumeDate(studentList, consumeDate).divide(new BigDecimal(100), 0, BigDecimal.ROUND_HALF_UP);
		BigDecimal result = currPersonAverage.divide(currStudentAverage, 2, BigDecimal.ROUND_HALF_UP);

		retInfo.append(currMonth.startsWith("0") == true ? currMonth.substring(1) : currMonth).append("月份消费金额").append(currPersonAverage.toString()).append("元，");
		if(result.compareTo(new BigDecimal(1)) > 0) {
			retInfo.append("高于全校均值").append(result.subtract(new BigDecimal(1)).multiply(new BigDecimal(100)).setScale(0)).append("%");
		}

		if(result.compareTo(new BigDecimal(1)) == 0) {
			retInfo.append("等于全校均值");
		}

		if(result.compareTo(new BigDecimal(1)) < 0) {
			retInfo.append("低于全校均值").append(new BigDecimal(1).subtract(result).multiply(new BigDecimal(100)).setScale(0)).append("%");
		}

		retMap.put("info", retInfo.toString());
		return retMap;
	}

	/**
	 * 查询贫困生和非贫困生消费数据
	 */
	@Override
	public Map<String, Object> getNeedyAndGeneralAverageConsumeDataMonth(){
		Map<String, Object> retMap = new HashMap<String, Object>();
		//查询全校消费月份列表
		ArrayList<String> monthList  = this.getMonthList();

		//查询贫困生平均每月消费金额
		List<Map<String, Object>> needyList = iStudentConsumeInfoDAO.listNeedyAverageConsumeDataMonth(monthList.get(0));
		retMap.put("needyList", dataProcessing(needyList, monthList));
		//贫困生月均消费金额
		retMap.put("needyAverage", calculateAverage(needyList));

		//查询非贫困生平均每月消费金额
		List<Map<String, Object>> generalList = iStudentConsumeInfoDAO.listGeneralAverageConsumeDataMonth(monthList.get(0));
		retMap.put("generalList", dataProcessing(generalList, monthList));
		//非贫困生月均消费金额
		retMap.put("generalAverage", calculateAverage(generalList));

		return retMap;
	}

	/**
	 * 贫困生和非贫困生人均每日三餐消费金额
	 */
	@Override
	public Map<String, Object> getNeedyAndGeneralAverageDietDataDay() {
		Map<String, Object> retMap = new HashMap<String, Object>();
		//查询全校消费月份列表
		ArrayList<String> monthList  = this.getMonthList();
		//查询非贫困平均每餐消费金额
		Map<String, Object> generalMap = iStudentConsumeInfoDAO.listGeneralAverageDietDataMeal(monthList.get(0));
		retMap.put("generalInfo", generalMap);

		BigDecimal generalTotalAmount = (generalMap.get("breakfastAmount") == null ? new BigDecimal(0) : (BigDecimal)generalMap.get("breakfastAmount")).
				add(generalMap.get("lunchAmount") == null ? new BigDecimal(0) : (BigDecimal)generalMap.get("lunchAmount")).
				add(generalMap.get("dinnerAmount") == null ? new BigDecimal(0) : (BigDecimal)generalMap.get("dinnerAmount"));
		retMap.put("generalAverage", generalTotalAmount);

		//查询贫困生平均每餐消费金额
		Map<String, Object> needyMap = iStudentConsumeInfoDAO.listNeedyAverageDietDataMeal(monthList.get(0));
		retMap.put("needyInfo", needyMap);

		BigDecimal needyTotalAmount = (needyMap.get("breakfastAmount") == null ? new BigDecimal(0) : (BigDecimal)needyMap.get("breakfastAmount")).
				add(needyMap.get("lunchAmount") == null ? new BigDecimal(0) : (BigDecimal)needyMap.get("lunchAmount")).
				add(needyMap.get("dinnerAmount") == null ? new BigDecimal(0) : (BigDecimal)needyMap.get("dinnerAmount"));
		retMap.put("generalAverage", generalTotalAmount);
		retMap.put("needyAverage", needyTotalAmount);

		return retMap;
	}

	/**
	 * 贫困生和非贫困生人均每月三餐次数
	 */
	@Override
	public Map<String, Object> countNeedyAndGeneralDietTimesMonth(){
		Map<String, Object> retMap = new HashMap<String, Object>();
		//查询全校消费月份列表
		ArrayList<String> monthList  = this.getMonthList();
		//查询非贫困平均每月三餐次数
		List<Map<String, Object>> generalList = iStudentConsumeInfoDAO.listGeneralAverageDietTimesMonth(monthList.get(0));
		retMap.put("generalList", dataCountProcessing(generalList, monthList));
		retMap.put("generalAverage", calculateAverageCount(generalList));
		//查询贫困生平均每月三餐次数
		List<Map<String, Object>> needyList = iStudentConsumeInfoDAO.listNeedyAverageDietTimesMonth(monthList.get(0));
		retMap.put("needyList", dataCountProcessing(needyList, monthList));
		retMap.put("needyAverage", calculateAverageCount(needyList));

		return retMap;
	}

	/**
	 * 查询三餐标签
	 */
	@Override
	public Map<String, Object> getDietLable(String studentNo){
		Map<String, Object> retMap = new HashMap<String, Object>();
		//查询全校消费月份列表
		ArrayList<String> monthList  = this.getMonthList();
		//查询学生早餐和夜宵次数
		List<Map<String, Object>> map = iStudentConsumeInfoDAO.listStudentBreakfastAndSupperTimes(studentNo, monthList.get(0));
		//三餐规律度
		String regularLable = calculateDiteRegularLable(studentNo);
		//三餐口味
		String tasteLable = calculateDiteTasteLable(studentNo);
		//早餐就餐情况
		String breakfastLabel = calculateDiteLable(map, "breakfastCount");
		//夜宵就餐情况
		String supperLabel = calculateDiteLable(map, "supperCount");

		retMap.put("label", regularLable + "," + tasteLable + "," + breakfastLabel + "," + supperLabel);
		return retMap;
	}

	/**
	 * 查询消费标签
	 */
	@Override
	public Map<String, Object> getConsumeLable(String studentNo){
		Map<String, Object> retMap = new HashMap<String, Object>();
		String consumeFeatureLable = "";
		Map<String, Object> map = (Map<String, Object>) this.listLatestDietSituation(studentNo);
		List<ConsumeStructureRES> list = (List<ConsumeStructureRES>)map.get("list");
		if(list != null && !list.isEmpty()) {
			for(ConsumeStructureRES consumeStructureRES : list) {
				if("上网".equals(consumeStructureRES.getConsumeName())) {
					consumeFeatureLable = "上网达人";
					break;
				}

				if("超市".equals(consumeStructureRES.getConsumeName())) {
					consumeFeatureLable = "超市购物狂";
					break;
				}

				if("水果".equals(consumeStructureRES.getConsumeName())) {
					consumeFeatureLable = "水果达人";
					break;
				}
				if("洗澡".equals(consumeStructureRES.getConsumeName())) {
					consumeFeatureLable = "洗浴狂";
					break;
				}
			}
		}
		//消费金额
		String consumeAmountLable = this.calculateConsumeLable(studentNo);

		//恩格尔系数标签
		String engelLable = "";
		BigDecimal totalAmount = new BigDecimal(0);
		BigDecimal foodAmount = new BigDecimal(0);
		List<StudentConsumeInfo> consumeInfoList = iStudentConsumeInfoDAO.listStudentLatestThreeMonthConsumeInfo(studentNo);
		if(consumeInfoList != null && !consumeInfoList.isEmpty()) {
			for(StudentConsumeInfo info : consumeInfoList) {
				//三餐金额
				foodAmount = foodAmount.add(new BigDecimal(info.getBreakfastAmount()))
					.add(new BigDecimal(info.getLunchAmount()))
					.add(new BigDecimal(info.getDinnerAmount()))
					.add(new BigDecimal(info.getSupperAmount()))
					.add(new BigDecimal(info.getFruitAmount()));

				totalAmount = totalAmount.add(foodAmount)
							.add(new BigDecimal(info.getBathAmount()))
							.add(new BigDecimal(info.getBookAmount()))
							.add(new BigDecimal(info.getInternetAmount()))
							.add(new BigDecimal(info.getMarketAmount()))
							.add(new BigDecimal(info.getOtherAmount()));

			}
			BigDecimal engel = foodAmount.divide(totalAmount, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2);
			if(engel.compareTo(new BigDecimal(70)) >= 0) {
				engelLable = "饮食消费高";
			}

			if(engel.compareTo(new BigDecimal(70)) < 0 && engel.compareTo(new BigDecimal(30)) >= 0) {
				engelLable = "饮食消费中等";
			}

			if(engel.compareTo(new BigDecimal(30)) < 0) {
				engelLable = "饮食消费低";
			}
		}

		String needyLable = "非贫困生";
		//贫困生
		StudentSupportInfo needyStudent = iStudentSupportInfoDAO.getStudentSupportInfoByStudentNo(studentNo);
		//建议关爱学生
		PovertyStudentAnalyse careStudent = iPovertyStudentAnalyseDAO.getSupportPovertyByStudentNo(studentNo);
		//虚假贫困生
		PovertyStudentAnalyse unPoverty = iPovertyStudentAnalyseDAO.getUnPovertyByStudentNo(studentNo);

		if(needyStudent != null) {
			if(unPoverty != null) {
				needyLable = "异常贫困生";
			}else {
				needyLable = "贫困生";
			}
		}

		if(careStudent != null) {
			needyLable = "建议关爱学生";
		}

		String label = consumeAmountLable + "," + consumeFeatureLable + "," + engelLable + "," + needyLable;
		retMap.put("label", label);
		return retMap;
	}

	/**
	 * 平均月消费金额趋势(综合画像)
	 */
	@Override
	public Map<String, Object> getWholeAverageConsumeAmountMonth(WholePortraitREQ wholePortraitREQ){
		Map<String, Object> retMap = new HashMap<String, Object>();
		wholePortraitREQ.setStartDate(BusinessUtils.getStartDateBySchoolYear(wholePortraitREQ.getSchoolYear()));
		wholePortraitREQ.setEndDate(BusinessUtils.getEndDateBySchoolYear(wholePortraitREQ.getSchoolYear()));
		//查询平均月均消费金额
		List<Map<String, Object>> schoolList = iStudentConsumeInfoDAO.listAverageConsumeDateMonthByCondition(wholePortraitREQ);
		//查询男生月均消费金额
		wholePortraitREQ.setGender("男");
		List<Map<String, Object>> maleList = iStudentConsumeInfoDAO.listAverageConsumeDateMonthByCondition(wholePortraitREQ);
		//查询女生月均消费金额
		wholePortraitREQ.setGender("女");
		List<Map<String, Object>> femaleList= iStudentConsumeInfoDAO.listAverageConsumeDateMonthByCondition(wholePortraitREQ);

		retMap.put("schoolList", schoolList);
		retMap.put("maleList", maleList);
		retMap.put("femaleList", femaleList);
		return retMap;
	}

	/**
	 * 三餐热门消费地点(综合画像)
	 */
	@Override
	public Map<String, Object> getWholeDietPlace(WholePortraitREQ wholePortraitREQ){
		Map<String, Object> retMap = new HashMap<String, Object>();
		wholePortraitREQ.setStartDate(BusinessUtils.getStartDateBySchoolYear(wholePortraitREQ.getSchoolYear()));
		wholePortraitREQ.setEndDate(BusinessUtils.getEndDateBySchoolYear(wholePortraitREQ.getSchoolYear()));
		List<Map<String, Object>> list = iStudentConsumePlaceDAO.getWholeDietPlaceByCondition(wholePortraitREQ);

		retMap.put("list", list);
		return retMap;
	}

	/**
	 * 三餐就餐率(综合画像)
	 */
	@Override
	public Map<String, Object> getWholeDietRate(WholePortraitREQ wholePortraitREQ){
		Map<String, Object> retMap = new HashMap<String, Object>();
		wholePortraitREQ.setStartDate(BusinessUtils.getStartDateBySchoolYear(wholePortraitREQ.getSchoolYear()));
		wholePortraitREQ.setEndDate(BusinessUtils.getEndDateBySchoolYear(wholePortraitREQ.getSchoolYear()));
		List<Map<String, Object>> list = iStudentConsumeInfoDAO.countAverageDietTimesMonthByCondition(wholePortraitREQ);
		retMap.put("breakfastRate", this.calculateDietRate(list, "breakfastCount"));
		retMap.put("lunchRate", this.calculateDietRate(list, "lunchCount"));
		retMap.put("dinnerRate", this.calculateDietRate(list, "dinnerCount"));
		return retMap;
	}

	/**
	 * 日均消费金额(综合画像)
	 */
	@Override
	public double getWholeAverageConsumeDate(WholePortraitREQ wholePortraitREQ){
		wholePortraitREQ.setStartDate(BusinessUtils.getStartDateBySchoolYear(wholePortraitREQ.getSchoolYear()));
		wholePortraitREQ.setEndDate(BusinessUtils.getEndDateBySchoolYear(wholePortraitREQ.getSchoolYear()));
		List<Map<String, Object>> list = iStudentConsumeInfoDAO.listAverageConsumeDateMonthByCondition(wholePortraitREQ);
		BigDecimal result = this.calculateAverageDayAmount(list);
		return result == null ? 0d : result.doubleValue();
	}

	/**
	 * 三餐规律百分比(综合画像)
	 */
	@Override
	public Map<String, Object> getWholeDietRegularRate(WholePortraitREQ wholePortraitREQ){
		Map<String, Object> map = new HashMap<String, Object>();
		//查询总记录数
		Integer count = iStudentConsumeRegularDAO.countDietRegular();
		//获取稳定性 较差稳定~差 的临界值
		StudentConsumptionIndex low = iStudentConsumeRegularDAO.getDietRegularByLineNo(new BigDecimal(count * 0.1).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
		//获取稳定性 非常稳定~比较稳定的临界点
		StudentConsumptionIndex high = iStudentConsumeRegularDAO.getDietRegularByLineNo(new BigDecimal(count * 0.9).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());

		BigDecimal lowRate = new BigDecimal(0.2);
		BigDecimal highRate = new BigDecimal(0.2);
		//根据条件查询学生数量
		Integer studentCount = iStudentInfoDAO.countStudentInfoByCondition(wholePortraitREQ);
		if(studentCount > 0) {
			//查询三餐不规律百分比
			wholePortraitREQ.setEatIndex(low.getDietIndex().toString());
			Integer lowCount = iStudentConsumeRegularDAO.countDietRegularByCondition(wholePortraitREQ);
			lowRate = new BigDecimal(1).subtract(new BigDecimal((double)lowCount/studentCount)).setScale(2, BigDecimal.ROUND_HALF_UP);
			//查询三餐规律百分比
			wholePortraitREQ.setEatIndex(high.getDietIndex().toString());
			Integer highCount = iStudentConsumeRegularDAO.countDietRegularByCondition(wholePortraitREQ);
			highRate = new BigDecimal((double)highCount/studentCount).setScale(2, BigDecimal.ROUND_HALF_UP);
		}

		map.put("lowRate", lowRate.toString());
		map.put("middleRate", new BigDecimal(1).subtract(lowRate).subtract(highRate).toString());
		map.put("highRate", highRate.toString());
		return map;
	}

	/**
	 * 获取查询年月
	 * @param
	 * @return
	 */
	private ArrayList<String> getMonthList() {
		ArrayList<String> retList = new ArrayList<String>();
		Calendar maxDate = Calendar.getInstance();
		Calendar minDate = Calendar.getInstance();
		minDate.add(Calendar.MONTH, -11);

		retList.add(DateUtils.dateToString(maxDate.getTime(), "yyyy-MM"));
		while(maxDate.compareTo(minDate) > 0) {
			maxDate.add(Calendar.MONTH, -1);
			retList.add(DateUtils.dateToString(maxDate.getTime(), "yyyy-MM"));
		}

		return retList;
	}

	/**
	 * 处理每月平均消费金额数据
	 * @param dataList
	 * @param monthList
	 * @return
	 */
	private List<ConsumeAmountRES> dataProcessing(List<Map<String, Object>> dataList, List<String> monthList) {
		List<ConsumeAmountRES> retList = new ArrayList<ConsumeAmountRES>();
		if(dataList != null && !dataList.isEmpty()) {
			for(String month : monthList) {
				ConsumeAmountRES consumeAmountRES = null;
				for(Map<String, Object> map : dataList) {
					String consumeDate = (String)map.get("consumeDate");
					if(month.equals(consumeDate)) {
						consumeAmountRES = new ConsumeAmountRES();
						consumeAmountRES.setConsumeDate(consumeDate);
						consumeAmountRES.setConsumeAmount(((BigDecimal)map.get("averageAmount")).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP));
					}
				}

				if(consumeAmountRES == null) {
					consumeAmountRES = new ConsumeAmountRES();
					consumeAmountRES.setConsumeAmount(new BigDecimal(0));
					consumeAmountRES.setConsumeDate(month);
				}
				retList.add(consumeAmountRES);
			}
		}
		return retList;
	}

	/**
	 * 处理每月平均消费次数
	 * @param dataList
	 * @param monthList
	 * @return
	 */
	private List<ConsumeCountRES> dataCountProcessing(List<Map<String, Object>> dataList, List<String> monthList) {
		List<ConsumeCountRES> retList = new ArrayList<ConsumeCountRES>();
		if(dataList != null && !dataList.isEmpty()) {
			for(String month : monthList) {
				ConsumeCountRES consumeCountRES = null;
				for(Map<String, Object> map : dataList) {
					String consumeDate = (String)map.get("consumeDate");
					if(month.equals(consumeDate)) {
						consumeCountRES = new ConsumeCountRES();
						consumeCountRES.setConsumeDate(consumeDate);
						consumeCountRES.setConsumeCount(((BigDecimal)map.get("averageCount")));
					}
				}

				if(consumeCountRES == null) {
					consumeCountRES = new ConsumeCountRES();
					consumeCountRES.setConsumeCount(new BigDecimal(0));
					consumeCountRES.setConsumeDate(month);
				}
				retList.add(consumeCountRES);
			}
		}
		return retList;
	}

	/**
	 * 计算月平均消费金额
	 * @param
	 * @param
	 * @return
	 */
	private String calculateAverage(List<Map<String, Object>> dataList) {
		BigDecimal averageAmount = new BigDecimal(0);
		if(dataList != null && !dataList.isEmpty()) {
			BigDecimal totalAmount = new BigDecimal(0);
			for(Map<String, Object> map : dataList) {
				totalAmount = totalAmount.add((BigDecimal)map.get("averageAmount"));
			}
			averageAmount = totalAmount.divide(new BigDecimal(dataList.size()), 4, BigDecimal.ROUND_HALF_UP).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);

		}

		return averageAmount.toString();
	}

	/**
	 * 计算月平均消费次数
	 * @param
	 * @param
	 * @return
	 */
	private String calculateAverageCount(List<Map<String, Object>> dataList) {
		BigDecimal averageCount = new BigDecimal(0);
		if(dataList != null && !dataList.isEmpty()) {
			BigDecimal totalCount = new BigDecimal(0);
			for(Map<String, Object> map : dataList) {
				totalCount = totalCount.add((BigDecimal)map.get("averageCount"));
			}
			averageCount = totalCount.divide(new BigDecimal(dataList.size()), 2, BigDecimal.ROUND_HALF_UP).setScale(0, BigDecimal.ROUND_HALF_UP);

		}

		return averageCount.toString();
	}

	/**
	 * 计算每餐平均消费金额
	 * @param
	 * @param
	 * @return
	 */
	private BigDecimal calculateEveryMealAverage(Map<String, Object> map) {
		if(map != null) {
			BigDecimal totalAmount = (map.get("breakfastAmount") == null ? new BigDecimal(0) : (BigDecimal)map.get("breakfastAmount")).
					add(map.get("lunchAmount") == null ? new BigDecimal(0) : (BigDecimal)map.get("lunchAmount")).
					add(map.get("dinnerAmount") == null ? new BigDecimal(0) : (BigDecimal)map.get("dinnerAmount"));
			BigDecimal averageAmount = totalAmount.divide(new BigDecimal(3), 4, BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);

			return averageAmount;
		}else {
			return new BigDecimal(0);
		}

	}

	/**
	 * 比较每月平均金额
	 * @param personAverage
	 * @param schoolAverage
	 * @return
	 */
	private String compareMonthAverage(BigDecimal personAverage, BigDecimal schoolAverage) {
		String retInfo = "";
		BigDecimal rate = personAverage.subtract(schoolAverage).divide(schoolAverage, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
		if(rate.compareTo(new BigDecimal(10)) >= 0) {
			retInfo = "月均三餐消费金额为" + personAverage.toString() + "，高于全校月均" + schoolAverage.toString();
		}

		if(rate.compareTo(new BigDecimal(10)) < 0 && rate.compareTo(new BigDecimal(0)) > 0) {
			retInfo = "月均三餐消费金额为" + personAverage.toString() + "，略高于全校月均" + schoolAverage.toString();
		}

		if(rate.compareTo(new BigDecimal(0)) == 0) {
			retInfo = "月均三餐消费金额为" + personAverage.toString() + "，等于全校月均" + schoolAverage.toString();
		}

		if(rate.compareTo(new BigDecimal(-10)) > 0 && rate.compareTo(new BigDecimal(0)) < 0) {
			retInfo = "月均三餐消费金额为" + personAverage.toString() + "，略低于全校月均" + schoolAverage.toString();
		}


		if(rate.compareTo(new BigDecimal(-10)) <= 0) {
			retInfo = "月均三餐消费金额为" + personAverage.toString() + "，低于全校月均" + schoolAverage.toString();
		}

		return retInfo;
	}

	/**
	 * 比较每天平均金额
	 * @param personAverage
	 * @param schoolAverage
	 * @return
	 */
	private String compareDayAverage(BigDecimal personAverage, BigDecimal schoolAverage) {
		String retInfo = "";
		BigDecimal rate = personAverage.subtract(schoolAverage).divide(schoolAverage, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
		if(rate.compareTo(new BigDecimal(10)) >= 0) {
			retInfo = "平均每天三餐消费" + personAverage.toString() + "，高于校平均" + schoolAverage.toString();
		}

		if(rate.compareTo(new BigDecimal(10)) < 0 && rate.compareTo(new BigDecimal(0)) > 0) {
			retInfo = "平均每天三餐消费" + personAverage.toString() + "，略高于校平均" + schoolAverage.toString();
		}

		if(rate.compareTo(new BigDecimal(0)) == 0) {
			retInfo = "平均每天三餐消费" + personAverage.toString() + "，等于校平均" + schoolAverage.toString();
		}

		if(rate.compareTo(new BigDecimal(-10)) > 0 && rate.compareTo(new BigDecimal(0)) < 0) {
			retInfo = "平均每天三餐消费" + personAverage.toString() + "，略低于校平均" + schoolAverage.toString();
		}


		if(rate.compareTo(new BigDecimal(-10)) <= 0) {
			retInfo = "平均每天三餐消费" + personAverage.toString() + "，低于校平均" + schoolAverage.toString();
		}

		return retInfo;
	}

	/**
	 * 获取指定消费月份的平均消费金额
	 * @param list
	 * @param consumeDate
	 * @return
	 */
	private BigDecimal getAverageAmountByConsumeDate(List<Map<String, Object>> list, String consumeDate) {
		if(list != null && !list.isEmpty()) {
			for(Map<String, Object> map : list) {
				if(consumeDate.equals((String)map.get("consumeDate"))) {
					return (BigDecimal)map.get("averageAmount");
				}
			}
		}
		return new BigDecimal(0);
	}

	/**
	 * 获取食物类型
	 * @param list
	 * @param type
	 * @return
	 */
	private List<StudentConsumePlace> getConsumePlaceByType(List<StudentConsumePlace> list, String type) {
		List<StudentConsumePlace> retList = new ArrayList<StudentConsumePlace>();

		if(list != null && !list.isEmpty()) {
			for(StudentConsumePlace place : list) {
				if(type.equals(place.getConsumeType())) {
					retList.add(place);
				}
			}
		}
		return retList;
	}

	/**
	 * 计算食物类型总金额
	 * @param list
	 * @param type
	 * @return
	 */
	private BigDecimal calculateFoodAmount(List<StudentConsumePlace> list, String type) {
		BigDecimal ret = new BigDecimal(0);
		if(list != null && !list.isEmpty()) {
			for(StudentConsumePlace place : list) {
				if(type.equals(place.getConsumeType())) {
					ret = ret.add(new BigDecimal(place.getConsumeAmount()));
				}
			}
		}
		return ret;
	}

	/**
	 * 求变异系数
	 * @param dataList
	 * @return
	 */
	private double calculateCoefficientOfVariation(List<Map<String, Object>> dataList) {
		double ret = 0d;
		if(dataList != null && !dataList.isEmpty()) {
			double [] inputData = new double[dataList.size()];
			int i = 0;
			for(Map<String, Object> map : dataList) {
				inputData[i++] = ((BigDecimal)map.get("averageAmount")).doubleValue();
			}
			double standard = MathUtils.getStandardDiviation(inputData);
			ret = standard/dataList.size();
		}

		return ret;
	}

	/**
	 * 计算三餐标签
	 * @param list
	 * @param dictType
	 * @return
	 */
	private String calculateDiteLable(List<Map<String, Object>> list, String dictType) {
		String retStr = "";

		if(list != null && !list.isEmpty()) {
			int planTimes = 0;
			int actualTimes = 0;
			for(Map<String, Object> map : list) {
				String consumeDate = (String)map.get("consumeDate");
				String month = consumeDate.substring(consumeDate.indexOf("-")+1);
				if(month.equals("03") || month.equals("04") || month.equals("05") || month.equals("06") ||
					month.equals("09") || month.equals("10") || month.equals("11") || month.equals("12")) {
					planTimes += 30;
					actualTimes += ((BigDecimal)map.get(dictType)).intValue();
				}

				if(month.equals("01") || month.equals("02")) {
					planTimes += 15;
					actualTimes += ((BigDecimal)map.get(dictType)).intValue();
				}
			}

			double result = (double)actualTimes/planTimes;
			if("breakfastCount".equals(dictType)) {
				if(result >= 0.71) {
					retStr = "早餐规律";
				}

				if(result < 0.71 && result >= 0.31) {
					retStr = "早餐规律度一般";
				}

				if(result < 0.31 && result >= 0.1) {
					retStr = "不爱吃早餐";
				}
				if(result < 0.1) {
					retStr = "早餐绝缘者";
				}
			}

			if("supperCount".equals(dictType)) {
				if(result >= 0.71) {
					retStr = "夜宵狂热者";
				}

				if(result < 0.71 && result >= 0.31) {
					retStr = "夜宵爱好者";
				}

				if(result < 0.31 && result >= 0.1) {
					retStr = "不爱吃夜宵";
				}
				if(result < 0.1) {
					retStr = "夜宵绝缘者";
				}
			}

		}
		return retStr;
	}

	/**
	 * 计算学生三餐规律度标签
	 * @param studentNo
	 * @return
	 */
	private String calculateDiteRegularLable(String studentNo) {
		String retStr = "";
		//查询个人三餐规律度
		BigDecimal personRegular = iStudentConsumeRegularDAO.getDietRegularByStudentNo(studentNo);

		if(personRegular == null || personRegular.compareTo(new BigDecimal(0)) < 0) {
			return "";
		}

		//查询总记录数
		Integer count = iStudentConsumeRegularDAO.countDietRegular();
		StudentConsumptionIndex first = iStudentConsumeRegularDAO.getDietRegularByLineNo(0);
		StudentConsumptionIndex one = iStudentConsumeRegularDAO.getDietRegularByLineNo(new BigDecimal(count * 0.1).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
		StudentConsumptionIndex two = iStudentConsumeRegularDAO.getDietRegularByLineNo(new BigDecimal(count * 0.3).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
		StudentConsumptionIndex three = iStudentConsumeRegularDAO.getDietRegularByLineNo(new BigDecimal(count * 0.7).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
		StudentConsumptionIndex four = iStudentConsumeRegularDAO.getDietRegularByLineNo(new BigDecimal(count * 0.9).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
		StudentConsumptionIndex end = iStudentConsumeRegularDAO.getDietRegularByLineNo(count - 1);

		if(personRegular.compareTo(first.getDietIndex()) >= 0 && personRegular.compareTo(one.getDietIndex()) < 0) {
			retStr = "三餐不规律";
		}

		if(personRegular.compareTo(one.getDietIndex()) >= 0 && personRegular.compareTo(two.getDietIndex()) < 0) {
			retStr = "三餐较不规律";
		}

		if(personRegular.compareTo(two.getDietIndex()) >= 0 && personRegular.compareTo(three.getDietIndex()) < 0) {
			retStr = "三餐规律一般";
		}

		if(personRegular.compareTo(three.getDietIndex()) >= 0 && personRegular.compareTo(four.getDietIndex()) < 0) {
			retStr = "三餐较规律";
		}

		if(personRegular.compareTo(four.getDietIndex()) >= 0 && personRegular.compareTo(end.getDietIndex()) <= 0) {
			retStr = "三餐很规律";
		}
		return retStr;
	}

	/**
	 * 获取用户三餐口味
	 * @param studentNo
	 * @return
	 */
	private String calculateDiteTasteLable(String studentNo) {
		String retStr = "";
		List<StudentConsumePlace> list = iStudentConsumePlaceDAO.getDietPlace(studentNo,
				BusinessUtils.getStartDateBySchoolYear(null),
				BusinessUtils.getEndDateBySchoolYear(null));

		if(list != null && !list.isEmpty()) {
			retStr = list.get(0).getConsumeType();
		}

		return retStr;
	}

	/**
	 * 计算消费标签
	 * @param studentNo
	 * @return
	 */
	private String calculateConsumeLable(String studentNo) {
		String retLable = "";
		//查询全校消费月份列表
		ArrayList<String> monthList  = this.getMonthList();
		//查询学生消费金额
		BigDecimal personConsume = iStudentConsumeInfoDAO.getStudentConsumeDataByStudentNoAndConsumeDate(studentNo, monthList.get(1));
		if(personConsume == null) {
			return retLable;
		}
		//查询总记录数
		Integer count = iStudentConsumeInfoDAO.countAllConsumeTimesByConsumeDate(monthList.get(1));
		//获取第一条记录
		BigDecimal first = iStudentConsumeInfoDAO.getConsumeDataByLineNoAndConsumeDate("0", monthList.get(1));
		//获取稳定性 非常稳定~比较稳定 的临界值
		BigDecimal one = iStudentConsumeInfoDAO.getConsumeDataByLineNoAndConsumeDate(new BigDecimal(count * 0.1).setScale(0, BigDecimal.ROUND_HALF_UP).toString(), monthList.get(1));
		//获取稳定性 比较稳定~一般稳定的临界点
		BigDecimal two = iStudentConsumeInfoDAO.getConsumeDataByLineNoAndConsumeDate(new BigDecimal(count * 0.3).setScale(0, BigDecimal.ROUND_HALF_UP).toString(), monthList.get(1));
		//获取稳定性 一般稳定~较差稳定的临界点
		BigDecimal three = iStudentConsumeInfoDAO.getConsumeDataByLineNoAndConsumeDate(new BigDecimal(count * 0.7).setScale(0, BigDecimal.ROUND_HALF_UP).toString(), monthList.get(1));
		//获取稳定性 较差稳定~差的临界点
		BigDecimal four = iStudentConsumeInfoDAO.getConsumeDataByLineNoAndConsumeDate(new BigDecimal(count * 0.9).setScale(0, BigDecimal.ROUND_HALF_UP).toString(), monthList.get(1));
		//获取最后一条记录
		BigDecimal end = iStudentConsumeInfoDAO.getConsumeDataByLineNoAndConsumeDate(Integer.toString(count -1), monthList.get(1));

		if(personConsume.compareTo(first) >= 0 && personConsume.compareTo(one) < 0) {
			retLable = "消费低";
		}

		if(personConsume.compareTo(one) >= 0 && personConsume.compareTo(two) < 0) {
			retLable = "消费较低";
		}

		if(personConsume.compareTo(two) >= 0 && personConsume.compareTo(three) < 0) {
			retLable = "消费中等";
		}

		if(personConsume.compareTo(three) >= 0 && personConsume.compareTo(four) < 0) {
			retLable = "消费较高";
		}

		if(personConsume.compareTo(four) >= 0 && personConsume.compareTo(end) <= 0) {
			retLable = "消费高";
		}
		return retLable;
	}

	/**
	 * 处理消费指数
	 * @param dataList
	 * @param monthList
	 * @return
	 */
	private List<ConsumeLevelRES> dataProcessingLevel(List<Map<String, Object>> dataList, List<String> monthList) {
			List<ConsumeLevelRES> retList = new ArrayList<ConsumeLevelRES>();
			if(dataList != null && !dataList.isEmpty()) {
				for(String month : monthList) {
					ConsumeLevelRES consumeLevelRES = null;
					for(Map<String, Object> map : dataList) {
						String consumeDate = (String)map.get("consumeDate");
						if(month.equals(consumeDate)) {
							consumeLevelRES = new ConsumeLevelRES();
							consumeLevelRES.setConsumeDate(consumeDate);
							BigDecimal consumeLevel = ((BigDecimal)map.get("averageAmount")).divide(new BigDecimal(83400.3), 2, BigDecimal.ROUND_HALF_UP);
							if(consumeLevel.compareTo(new BigDecimal(1)) > 0) {
								consumeLevel = new BigDecimal(1);
							}
							if(consumeLevel.compareTo(new BigDecimal(0)) < 0) {
								consumeLevel = new BigDecimal(0);
							}
							consumeLevelRES.setCosumeLevel(consumeLevel.multiply(new BigDecimal(100)).setScale(0).toString());
						}
					}

					if(consumeLevelRES == null) {
						consumeLevelRES = new ConsumeLevelRES();
						consumeLevelRES.setCosumeLevel("0");
						consumeLevelRES.setConsumeDate(month);
					}
					retList.add(consumeLevelRES);
				}
			}
			return retList;
	}

	/**
	 * 处理消费指数
	 * @param data
	 * @return
	 */
	private String dataProcessingLevel(BigDecimal data) {
		BigDecimal consumeLevel = data.divide(new BigDecimal(834.3), 2, BigDecimal.ROUND_HALF_UP);
		if(consumeLevel.compareTo(new BigDecimal(1)) > 0) {
			consumeLevel = new BigDecimal(1);
		}
		if(consumeLevel.compareTo(new BigDecimal(0)) < 0) {
			consumeLevel = new BigDecimal(0);
		}

		return consumeLevel.multiply(new BigDecimal(100)).setScale(0).toString();
	}

	/**
	 * 计算就餐率
	 * @param list
	 * @param dietType
	 * @return
	 */
	private String calculateDietRate(List<Map<String, Object>> list, String dietType) {
		String retStr = "";
		if(list != null && !list.isEmpty()) {
			BigDecimal planTimes = new BigDecimal(0);
			BigDecimal actualTimes = new BigDecimal(0);
			for(Map<String, Object> map : list) {
				String consumeDate = (String)map.get("consumeDate");
				String month = consumeDate.substring(consumeDate.indexOf("-")+1);
				if(month.equals("03") || month.equals("04") || month.equals("05") || month.equals("06") ||
					month.equals("09") || month.equals("10") || month.equals("11") || month.equals("12")) {
					planTimes = planTimes.add(new BigDecimal(30));
					actualTimes = actualTimes.add((BigDecimal)map.get(dietType));
				}

				if(month.equals("01") || month.equals("02")) {
					planTimes = planTimes.add(new BigDecimal(15));
					actualTimes = actualTimes.add((BigDecimal)map.get(dietType));
				}
			}

			retStr = actualTimes.divide(planTimes, 2, BigDecimal.ROUND_HALF_UP).toString();
		}
		return retStr;
	}

	/**
	 * 计算日均消费金额
	 * @param list
	 * @return
	 */
	private BigDecimal calculateAverageDayAmount(List<Map<String, Object>> list) {
		BigDecimal ret = new BigDecimal(0);
		if(list != null && !list.isEmpty()) {
			BigDecimal total = new BigDecimal(0);
			BigDecimal days = new BigDecimal(0);
			if(list.size() > 1) {
				list.remove(list.size()-1);
				for(Map<String, Object> map : list) {
					String consumeDate = (String)map.get("consumeDate");
					String month = consumeDate.substring(consumeDate.indexOf("-")+1);
					if(month.equals("03") || month.equals("04") || month.equals("05") || month.equals("06") ||
						month.equals("09") || month.equals("10") || month.equals("11") || month.equals("12")) {
						days = days.add(new BigDecimal(30));
						total = total.add((BigDecimal)map.get("averageAmount"));
					}
				}
				ret = total.divide(days, 2, BigDecimal.ROUND_HALF_UP);
			}else {
				ret = ((BigDecimal)list.get(0).get("averageAmount")).divide(new BigDecimal(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)), 2, BigDecimal.ROUND_HALF_UP);
			}
		}
		return ret;
	}
}
