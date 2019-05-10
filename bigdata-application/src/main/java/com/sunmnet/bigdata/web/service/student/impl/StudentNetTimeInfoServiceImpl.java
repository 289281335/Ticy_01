package com.sunmnet.bigdata.web.service.student.impl;

import com.sunmnet.bigdata.web.dao.student.INearlyMonthNetStatisDAO;
import com.sunmnet.bigdata.web.dao.student.IStudentNetTimeInfoDAO;
import com.sunmnet.bigdata.web.model.entity.student.StudentNetTimeInfo;
import com.sunmnet.bigdata.web.model.response.student.StudentNetTimeInfoRES;
import com.sunmnet.bigdata.web.service.student.IStudentNetTimeInfoService;
import com.sunmnet.bigdata.web.util.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentNetTimeInfoServiceImpl implements IStudentNetTimeInfoService {

	@Resource
	private IStudentNetTimeInfoDAO iStudentNetTimeInfoDAO;

	@Resource
	private INearlyMonthNetStatisDAO iNearlyMonthNetStatisDAO;

	/**
	 * 个人画像-最近七上网时间
	 */
	@Override
	public Map<String, Object> nearly7dayNetInfo(String studentNo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("studentNo", studentNo);
		paramMap.put("days", 7);
		List<StudentNetTimeInfoRES> domains = iStudentNetTimeInfoDAO.nearlyNdayNetInfo(paramMap);
		Map<String, Object> result_map = new HashMap<String, Object>();
		result_map.put("stuNo", studentNo);
		List<String> days7 = DateUtils.getBeforeNDate(35);
		List<Map<String, Object>> daylist = new ArrayList<Map<String, Object>>();
		if (domains != null && domains.size() > 0) {
			for (String day : days7) {
				Map<String, Object> dayMap = new HashMap<String, Object>();
				List<Map<String, Object>> cellList = new ArrayList<Map<String, Object>>();
				// 目前每人每天上网时间段最多按5个算
				Map<String, Object> cellMap_1 = new HashMap<String, Object>();
				cellMap_1.put("date", day);
				Map<String, Object> cellMap_2 = new HashMap<String, Object>();
				cellMap_2.put("date", day);
				Map<String, Object> cellMap_3 = new HashMap<String, Object>();
				cellMap_3.put("date", day);
				Map<String, Object> cellMap_4 = new HashMap<String, Object>();
				cellMap_4.put("date", day);
				Map<String, Object> cellMap_5 = new HashMap<String, Object>();
				cellMap_5.put("date", day);
				for (StudentNetTimeInfo domain : domains) {
					if (domain.getTime().contains(day)) {
						if (!cellMap_1.containsKey("startTime") || !cellMap_1.containsKey("stopTime")) {
							if ("Start".equals(domain.getStatus())) {
								cellMap_1.put("startTime", domain.getTime());
							} else {
								cellMap_1.put("stopTime", domain.getTime());
							}
							continue;
						}
						if (!cellMap_2.containsKey("startTime") || !cellMap_2.containsKey("stopTime")) {
							if ("Start".equals(domain.getStatus())) {
								cellMap_2.put("startTime", domain.getTime());
							} else {
								cellMap_2.put("stopTime", domain.getTime());
							}
							continue;
						}
						if (!cellMap_3.containsKey("startTime") || !cellMap_3.containsKey("stopTime")) {
							if ("Start".equals(domain.getStatus())) {
								cellMap_3.put("startTime", domain.getTime());
							} else {
								cellMap_3.put("stopTime", domain.getTime());
							}
							continue;
						}
						if (!cellMap_4.containsKey("startTime") || !cellMap_4.containsKey("stopTime")) {
							if ("Start".equals(domain.getStatus())) {
								cellMap_4.put("startTime", domain.getTime());
							} else {
								cellMap_4.put("stopTime", domain.getTime());
							}
							continue;
						}
						if (!cellMap_5.containsKey("startTime") || !cellMap_5.containsKey("stopTime")) {
							if ("Start".equals(domain.getStatus())) {
								cellMap_5.put("startTime", domain.getTime());
							} else {
								cellMap_5.put("stopTime", domain.getTime());
							}
							continue;
						}
					}
				}
				if (cellMap_1.containsKey("startTime") || cellMap_1.containsKey("stopTime")) {
					if (cellMap_1.containsKey("startTime") && !cellMap_1.containsKey("stopTime")) {
						cellMap_1.put("endTime", cellMap_1.get("date") + " 24:00:00");
					}
					if (!cellMap_1.containsKey("startTime") && cellMap_1.containsKey("stopTime")) {
						cellMap_1.put("startTime", cellMap_1.get("date") + " 00:00:00");
					}
					cellList.add(cellMap_1);
				}
				if (cellMap_2.containsKey("startTime") || cellMap_2.containsKey("stopTime")) {
					if (cellMap_2.containsKey("startTime") && !cellMap_2.containsKey("stopTime")) {
						cellMap_2.put("endTime", cellMap_2.get("date") + " 24:00:00");
					}
					if (!cellMap_2.containsKey("startTime") && cellMap_2.containsKey("stopTime")) {
						cellMap_2.put("startTime", cellMap_2.get("date") + " 00:00:00");
					}
					cellList.add(cellMap_2);
				}
				if (cellMap_3.containsKey("startTime") || cellMap_3.containsKey("stopTime")) {
					if (cellMap_3.containsKey("startTime") && !cellMap_3.containsKey("stopTime")) {
						cellMap_3.put("endTime", cellMap_3.get("date") + " 24:00:00");
					}
					if (!cellMap_3.containsKey("startTime") && cellMap_3.containsKey("stopTime")) {
						cellMap_3.put("startTime", cellMap_3.get("date") + " 00:00:00");
					}
					cellList.add(cellMap_3);
				}
				if (cellMap_4.containsKey("startTime") || cellMap_4.containsKey("stopTime")) {
					if (cellMap_4.containsKey("startTime") && !cellMap_4.containsKey("stopTime")) {
						cellMap_4.put("endTime", cellMap_4.get("date") + " 24:00:00");
					}
					if (!cellMap_4.containsKey("startTime") && cellMap_4.containsKey("stopTime")) {
						cellMap_4.put("startTime", cellMap_4.get("date") + " 00:00:00");
					}
					cellList.add(cellMap_4);
				}
				if (cellMap_5.containsKey("startTime") || cellMap_5.containsKey("stopTime")) {
					if (cellMap_5.containsKey("startTime") && !cellMap_5.containsKey("stopTime")) {
						cellMap_5.put("endTime", cellMap_5.get("date") + " 24:00:00");
					}
					if (!cellMap_5.containsKey("startTime") && cellMap_5.containsKey("stopTime")) {
						cellMap_5.put("startTime", cellMap_5.get("date") + " 00:00:00");
					}
					cellList.add(cellMap_5);
				}
				dayMap.put("date", day);
				dayMap.put("day", cellList);
				daylist.add(dayMap);
			}
		}
		result_map.put("dayList", daylist);
		return result_map;
	}

	/**
	 * 获得个人画像-综合画像个人选项卡上网信息
	 */
	@Override
	public Map<String, Object> studentCartNetTag(String studentNo) {
		Map<String, Object> resulr_map = new HashMap<String, Object>();
		Integer dayAvgNetTime = iNearlyMonthNetStatisDAO.getMonthAverageNetTime(studentNo);
		if (dayAvgNetTime >= 8) {
			resulr_map.put("netFanDegrees", "重度沉迷");
		} else if (dayAvgNetTime >= 5 && dayAvgNetTime < 8) {
			resulr_map.put("netFanDegrees", "轻度沉迷");
		} else {
			resulr_map.put("netFanDegrees", "不沉迷");
		}
		Map<String, Object> monthMap = iNearlyMonthNetStatisDAO.getNearly7WeekNetTimeStatis(studentNo);
		if(monthMap.get("weekend_1_count") != null) {
			Double weekendNetTime = Double.valueOf(monthMap.get("weekend_1_count")+"");
			if(weekendNetTime > 20) {
				resulr_map.put("netTime", "周末疯狂当");
			}else {
				resulr_map.put("netTime", "上网时间点健康");
			}
		}
		return resulr_map;
	}

	/**
	 * 获得综合画像近7周上网时长的分析
	 */
	@Override
	public Map<String, Object> getNearly7WeekNetTimeAnalysisByStudentNo(String studentNo) throws ParseException {
		Map<String, Object> resulr_map = iNearlyMonthNetStatisDAO.getNearly7WeekNetTimeStatis(studentNo);
		return resulr_map;
	}

	/**
	 * 获得某段时间的天平均上网时长
	 */
	@Override
	public Double getNDaysNetTimeAverageDay(String studentNo, Integer N) {
		List<Map<String, Object>> dayList = nearlyNdayNetTimeInfo(studentNo, N);
		Double netTimeCount = 0D;
		for (Map<String, Object> map : dayList) {
			List<Map<String, Object>> cellList = (List<Map<String, Object>>) map.get("day");
			netTimeCount += dayNetTimeCount(cellList);
		}
		return netTimeCount / N;
	}

	/**
	 * 群体画像-上网时长分析
	 */
	@Override
	public Map<String, Object> netTimeAnalyse(String collegeCode, String majorCode, String className, String nation,
			String gender, String studentPlace, String schoolYear, String academyName) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("collegeCode", collegeCode);
		paramMap.put("majorCode", majorCode);
		paramMap.put("className", className);
		paramMap.put("nation", nation);
		paramMap.put("gender", gender);
		paramMap.put("studentPlace", studentPlace);
		paramMap.put("schoolYear", schoolYear);
		paramMap.put("academyName", academyName);
		return iNearlyMonthNetStatisDAO.getNearlyMonthNetTimeStatis(paramMap);
	}

	/**
	 * 群体画像-上网时间段分析
	 */
	@Override
	public Map<String, Object> netTimeSlotAnalyse(String collegeCode, String majorCode, String className, String nation,
			String gender, String studentPlace, String schoolYear, String academyName) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("collegeCode", collegeCode);
		paramMap.put("majorCode", majorCode);
		paramMap.put("className", className);
		paramMap.put("nation", nation);
		paramMap.put("gender", gender);
		paramMap.put("studentPlace", studentPlace);
		paramMap.put("schoolYear", schoolYear);
		paramMap.put("academyName", academyName);
		return iNearlyMonthNetStatisDAO.getNearlyMonthNetSlotStatis(paramMap);
	}

	/**
	 * 计算一天的上网时长
	 * @return
	 */
	private static Double dayNetTimeCount(List<Map<String, Object>> list) {
		Double dayCountSecond = 0d;
		for (Map<String, Object> cellMap : list) {
			String stopTime = (String) cellMap.get("stopTime");
			String startTime = (String) cellMap.get("startTime");
			Long stop = 0l;
			Long start = 0l;
			try {
				if (stopTime != null) {
					stop = DateUtils.strToTimeStamp(stopTime);
				}
				if (startTime != null) {
					start = DateUtils.strToTimeStamp(startTime);
				}
				if (stop > start) {
					dayCountSecond += (stop - start);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return dayCountSecond / 3600;
	}

	/**
	 * 获得近N天上网时间段信息
	 * @param studentNo
	 * @return
	 */
	private List<Map<String, Object>> nearlyNdayNetTimeInfo(String studentNo, Integer N) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("studentNo", studentNo);
		paramMap.put("days", N);
		List<StudentNetTimeInfoRES> domains = iStudentNetTimeInfoDAO.nearlyNdayNetInfo(paramMap);

		List<String> daysN = DateUtils.getBeforeNDate(N);
		List<Map<String, Object>> daylist = new ArrayList<Map<String, Object>>();
		if (domains != null && domains.size() > 0) {
			for (String day : daysN) {
				Map<String, Object> dayMap = new HashMap<String, Object>();
				List<Map<String, Object>> cellList = new ArrayList<Map<String, Object>>();
				// 目前每人每天上网时间段最多按5个算
				Map<String, Object> cellMap_1 = new HashMap<String, Object>();
				cellMap_1.put("date", day);
				Map<String, Object> cellMap_2 = new HashMap<String, Object>();
				cellMap_2.put("date", day);
				Map<String, Object> cellMap_3 = new HashMap<String, Object>();
				cellMap_3.put("date", day);
				Map<String, Object> cellMap_4 = new HashMap<String, Object>();
				cellMap_4.put("date", day);
				Map<String, Object> cellMap_5 = new HashMap<String, Object>();
				cellMap_5.put("date", day);
				for (StudentNetTimeInfo domain : domains) {
					if (domain.getTime().contains(day)) {
						if (!cellMap_1.containsKey("startTime") || !cellMap_1.containsKey("stopTime")) {
							if ("Start".equals(domain.getStatus())) {
								cellMap_1.put("startTime", domain.getTime());
							} else {
								cellMap_1.put("stopTime", domain.getTime());
							}
							continue;
						}
						if (!cellMap_2.containsKey("startTime") || !cellMap_2.containsKey("stopTime")) {
							if ("Start".equals(domain.getStatus())) {
								cellMap_2.put("startTime", domain.getTime());
							} else {
								cellMap_2.put("stopTime", domain.getTime());
							}
							continue;
						}
						if (!cellMap_3.containsKey("startTime") || !cellMap_3.containsKey("stopTime")) {
							if ("Start".equals(domain.getStatus())) {
								cellMap_3.put("startTime", domain.getTime());
							} else {
								cellMap_3.put("stopTime", domain.getTime());
							}
							continue;
						}
						if (!cellMap_4.containsKey("startTime") || !cellMap_4.containsKey("stopTime")) {
							if ("Start".equals(domain.getStatus())) {
								cellMap_4.put("startTime", domain.getTime());
							} else {
								cellMap_4.put("stopTime", domain.getTime());
							}
							continue;
						}
						if (!cellMap_5.containsKey("startTime") || !cellMap_5.containsKey("stopTime")) {
							if ("Start".equals(domain.getStatus())) {
								cellMap_5.put("startTime", domain.getTime());
							} else {
								cellMap_5.put("stopTime", domain.getTime());
							}
							continue;
						}
					}
				}
				if (cellMap_1.containsKey("startTime") || cellMap_1.containsKey("stopTime")) {
					if (cellMap_1.containsKey("startTime") && !cellMap_1.containsKey("stopTime")) {
						cellMap_1.put("endTime", cellMap_1.get("date") + " 24:00:00");
					}
					if (!cellMap_1.containsKey("startTime") && cellMap_1.containsKey("stopTime")) {
						cellMap_1.put("startTime", cellMap_1.get("date") + " 00:00:00");
					}
					cellList.add(cellMap_1);
				}
				if (cellMap_2.containsKey("startTime") || cellMap_2.containsKey("stopTime")) {
					if (cellMap_2.containsKey("startTime") && !cellMap_2.containsKey("stopTime")) {
						cellMap_2.put("endTime", cellMap_2.get("date") + " 24:00:00");
					}
					if (!cellMap_2.containsKey("startTime") && cellMap_2.containsKey("stopTime")) {
						cellMap_2.put("startTime", cellMap_2.get("date") + " 00:00:00");
					}
					cellList.add(cellMap_2);
				}
				if (cellMap_3.containsKey("startTime") || cellMap_3.containsKey("stopTime")) {
					if (cellMap_3.containsKey("startTime") && !cellMap_3.containsKey("stopTime")) {
						cellMap_3.put("endTime", cellMap_3.get("date") + " 24:00:00");
					}
					if (!cellMap_3.containsKey("startTime") && cellMap_3.containsKey("stopTime")) {
						cellMap_3.put("startTime", cellMap_3.get("date") + " 00:00:00");
					}
					cellList.add(cellMap_3);
				}
				if (cellMap_4.containsKey("startTime") || cellMap_4.containsKey("stopTime")) {
					if (cellMap_4.containsKey("startTime") && !cellMap_4.containsKey("stopTime")) {
						cellMap_4.put("endTime", cellMap_4.get("date") + " 24:00:00");
					}
					if (!cellMap_4.containsKey("startTime") && cellMap_4.containsKey("stopTime")) {
						cellMap_4.put("startTime", cellMap_4.get("date") + " 00:00:00");
					}
					cellList.add(cellMap_4);
				}
				if (cellMap_5.containsKey("startTime") || cellMap_5.containsKey("stopTime")) {
					if (cellMap_5.containsKey("startTime") && !cellMap_5.containsKey("stopTime")) {
						cellMap_5.put("endTime", cellMap_5.get("date") + " 24:00:00");
					}
					if (!cellMap_5.containsKey("startTime") && cellMap_5.containsKey("stopTime")) {
						cellMap_5.put("startTime", cellMap_5.get("date") + " 00:00:00");
					}
					cellList.add(cellMap_5);
				}
				dayMap.put("date", day);
				dayMap.put("day", cellList);
				daylist.add(dayMap);
			}
		}
		return daylist;
	}

	/**
	 * 查询特定时间段内学生的天平均上网时长
	 */
	@Override
	public Double getTimeSlotAvgDayNetTime(String collegeCode, String majorCode, String className, String nation,
			String gender, String studentPlace, String schoolYear, String academyName) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("collegeCode", collegeCode);
		paramMap.put("majorCode", majorCode);
		paramMap.put("className", className);
		paramMap.put("nation", nation);
		paramMap.put("gender", gender);
		paramMap.put("studentPlace", studentPlace);
		paramMap.put("schoolYear", schoolYear);
		paramMap.put("academyName", academyName);
		List<String> stuNoList = iStudentNetTimeInfoDAO.listStudentNoByCondition(paramMap);
		Double avgNetTime = 0D;
		if (stuNoList != null && stuNoList.size() > 0) {
			Double netTimeTotal = 0D;
			Integer studentCount = stuNoList.size();
			for (String stuNo : stuNoList) {
				Double netTime = getNDaysNetTimeAverageDay(stuNo, 35);
				netTimeTotal += netTime;
			}
			avgNetTime = netTimeTotal / studentCount;
		}
		return avgNetTime;
	}

	/**
	 * 根据学号查询上网健康度
	 */
	@Override
	public Map<String, Object> getNetHealthRatio(String studentNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		String healthInfo = "";
		Double floatNumber = iNearlyMonthNetStatisDAO.getNetHealthRate(studentNo);
		if (floatNumber <= 0.2) {
			healthInfo = "不健康";
		} else if (floatNumber > 0.2 && floatNumber <= 0.4) {
			healthInfo = "较不健康";
		} else if (floatNumber > 0.4 && floatNumber <= 0.6) {
			healthInfo = "一般";
		} else if (floatNumber > 0.6 && floatNumber <= 0.8) {
			healthInfo = "较健康";
		} else {
			healthInfo = "很健康";
		}
		map.put("ratioVale", floatNumber);
		map.put("healthInfo", healthInfo);
		return map;
	}

	/**
	 * 获得近N天每天的上网时长
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> listNearlyNDaysNetTimeDay(String studentNo, Integer N) {
		List<Map<String, Object>> dayList = nearlyNdayNetTimeInfo(studentNo, N);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map : dayList) {
			List<Map<String, Object>> cellList = (List<Map<String, Object>>) map.get("day");
			Map<String, Object> day_map = new HashMap<String, Object>();
			day_map.put("date", map.get("date"));
			day_map.put("dayNetTime", dayNetTimeCount(cellList));
			list.add(day_map);
		}
		return list;
	}

}
