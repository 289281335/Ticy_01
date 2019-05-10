package com.sunmnet.bigdata.web.service.student;



import com.sunmnet.bigdata.web.model.enums.AchievementStatusValue;
import com.sunmnet.bigdata.web.model.enums.StudyLevelValue;
import com.sunmnet.bigdata.web.model.response.student.StudentClassRateRES;
import com.sunmnet.bigdata.web.model.response.student.StudentOnTimeRateRES;
import com.sunmnet.bigdata.web.model.response.student.StudentScoresRES;

import java.util.List;

/**
 * 学生学业相关服务(成长推荐使用)
 * @author niuliqiang
 *
 */
public interface IStudentAttributeService {

	/**
	 * 查询成绩信息
	 * @param studentNo
	 * @return
	 */
	public List<StudentScoresRES> getScoreData(String studentNo);
	
	/**
	 * 查询到课率
	 * @param studentNo
	 * @return
	 */
	public List<StudentClassRateRES> getClassRate(String studentNo);
	
	/**
	 * 查询准点率
	 * @param studentNo
	 * @return
	 */
	public List<StudentOnTimeRateRES> getOnTimeRate(String studentNo);
	
	/**
	 * 查询学习水平
	 * @param studentNo
	 * @return
	 */
	public StudyLevelValue getLearningLevel(String studentNo);
	
	/**
	 * 查询学习稳定性
	 * @param studentNo
	 * @return
	 */
	public AchievementStatusValue getLearningStability(String studentNo);
	
	/**
	 * 查询外出情况
	 * @param studentNo
	 * @return
	 */
	//public OutSituationValue getWeekOutLable(String studentNo);
	
	/**
	 * 查询睡觉时长
	 * @param studentNo
	 * @return
	 */
	//public SleepTimeValue getSleepTimeLable(String studentNo);
	
	/**
	 * 查询三餐规律度
	 * @param studentNo
	 * @return
	 */
	//public ThreeMealsRegularityValue getDietRegularityLable(String studentNo);
	
	/**
	 * 查询睡眠情况
	 * @param studentNo
	 * @return
	 */
	//public SleepSituationValue getSleepSituationLable(String studentNo);
	
	/**
	 * 查询早餐情况
	 * @param studentNo
	 * @return
	 */
	//public BreakfastSituationValue getBreakfastSituationLable(String studentNo);
	
	/**
	 * 查询图书借阅数量
	 * @param studentNo
	 * @return
	 */
	public Integer CountBookBorrow(String studentNo);
}
