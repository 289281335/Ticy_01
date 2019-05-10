package com.sunmnet.bigdata.web.service.student;

import com.sunmnet.bigdata.commons.model.PageResult;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.WholePortraitREQ;
import com.sunmnet.bigdata.web.model.response.student.StudentInfoRES;
import com.sunmnet.bigdata.web.model.response.student.WholePortraitRES;

import java.util.Map;

public interface IStudiesAnalysisService {

	/**
	 * 查询学生历史成绩
	 * @param studentNo
	 * @return
	 */
	public Map<String, Object> getHistoryScore(String studentNo);
	
	/**
	 * 查询学生疑似逃课信息
	 * @param studentNo
	 * @return
	 */
	public Map<String, Object> getTruancyInfo(String studentNo);
	
	/**
	 * 查询学生学习相关标签
	 * @param studentNo
	 * @return
	 */
	public Map<String, Object> getStudiesLabel(String studentNo);
	
	/**
	 * 查询学生到课率
	 * @param studentNo
	 * @return
	 */
	public Map<String, Object> getClassRate(String studentNo, String queryType);
	
	/**
	 * 查询学生到课时间分析
	 * @param studentNo
	 * @return
	 */
	public Map<String, Object> getClassTime(String studentNo);
	
	/**
	 * 查询学生本学期考勤明细
	 * @param studentNo
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageResult pageClassAttendanceDetail(String studentNo, Integer pageNum, Integer pageSize);
	
	/**
	 * 疑似逃课情况(整体画像)
	 * @param wholePortraitREQ
	 * @return
	 */
	public Map<String, Object> WholeTruancyTimesData(WholePortraitREQ wholePortraitREQ);
	
	/**
	 * 查询疑似逃课学生信息(整体画像)
	 * @param wholePortraitREQ
	 * @return
	 */
	public PageResult pageWholeTruancyStudentData(WholePortraitREQ wholePortraitREQ, Integer pageNum, Integer pageSize);
	
	/**
	 * 查询学霸数量(整体画像)
	 * @param studentInfoREQ
	 * @return
	 */
	public Integer countWholeHighGrades(StudentInfoREQ studentInfoREQ);
	
	/**
	 * 查询挂科学生数量(整体画像)
	 * @return
	 */
	public Integer countWholeFailGrades(WholePortraitREQ wholePortraitREQ);

	/**
	 * 查询学习水平比率(整体画像)
	 * @param studentInfoREQ
	 * @return
	 */
	public Map<String, Object> WholeLearningLevel(StudentInfoREQ studentInfoREQ);
}
