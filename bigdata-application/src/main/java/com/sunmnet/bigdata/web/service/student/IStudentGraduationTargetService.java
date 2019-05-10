package com.sunmnet.bigdata.web.service.student;

import com.sunmnet.bigdata.commons.model.JsonResult;
import com.sunmnet.bigdata.web.model.request.student.StudentGraduationTargetREQ;
import org.apache.ibatis.annotations.Param;


/**
 * 学生成长目标信息
 * @author wm
 */
public interface IStudentGraduationTargetService {
	/**
	 * 学生成长目标信息保存
	 * @return
	 */
	public JsonResult saveArgetInfo(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ);
	/**
	 * 根据学号查询学生有没有设置成长目标
	 * @return
	 */
	public String isArget(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ);
	/**
	 * 根据学号查询学生成长目标信息
	 * @return
	 */
	public JsonResult getArgetInfo(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ);
	/**
	 * 学生成长设置成长目标群体标签统计
	 * @return
	 * @throws Exception
	 */
	public JsonResult countGroupLabel(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ) throws Exception;
	/**
	 * 学生成长设置成长目优秀样本展示
	 * @return
	 */
	public JsonResult listExcellentSample(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ)throws Exception;
	/**
	 * 学生成长设置成长目群体平均展示
	 * @return
	 */
	public JsonResult getGroupAverage(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ);
	/**
	 * 学生成长设置成长目群体相似度
	 * @return
	 */
	public JsonResult groupSimilarityDegree(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ);
	/**
	 * 学生成长成长目标和群体指标展示
	 * @return
	 */
	public JsonResult argetGroupInfo(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ);
	/**
	 * 学生成长设置成长目群体超越、持平、 偏差大统计项
	 * @return
	 */
	public JsonResult detailedComparison(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ);
	/**
	 * 根据学号查询学生成长目标信息（代码和名称都显示）
	 * @return
	 */
	public JsonResult getArgetInfoAll(@Param("studentGraduationTargetREQ")StudentGraduationTargetREQ studentGraduationTargetREQ);

}
