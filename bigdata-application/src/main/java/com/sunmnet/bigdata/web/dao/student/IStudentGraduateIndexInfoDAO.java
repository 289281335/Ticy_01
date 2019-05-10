package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentGraduateIndexInfo;

import java.util.List;

public interface IStudentGraduateIndexInfoDAO {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(StudentGraduateIndexInfo studentGraduateIndexInfo);

    public StudentGraduateIndexInfo selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(StudentGraduateIndexInfo studentGraduateIndexInfo);
	 /**
	  * 根据学号查询学生指标值前三
	  * @param studentNoList
	  * @return
	  */
	public List<StudentGraduateIndexInfo> getGraduateIndexInfoTopThree(List<String> studentNoList);
	/**
	  * 根据学号查询学生指标值求和
	  * @param studentNoList
	  * @return
	  */
	public StudentGraduateIndexInfo getGraduateIndexInfo(List<String> studentNoList);
	
	/**
	  * 查询总数
	  * @param studentNoList
	  * @return
	  */
	public long getGraduateIndexInfoCount(List<String> studentNoList);
	/**
	  * 查询学生指标信息根据学号
	  * @param studentNo
	  * @return
	  */
	public StudentGraduateIndexInfo getByStudentNo(String studentNo);
	/**
     * 查询有没有毕业生指标信息
     */
	public long getGraduateIndexInfoTotal();

}