package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentGraduateInfo;

import java.util.List;
import java.util.Map;

public interface IStudentGraduateInfoDAO {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(StudentGraduateInfo studentGraduateInfo);

    public StudentGraduateInfo selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(StudentGraduateInfo studentGraduateInfo);
    /**
     * 查询和自己设置读研目标相同的学长的学号，更具自己学号和学长毕业时间
     */
	public List<String> getReadStudentNo(Map<String, Object> param);
	/**
     * 查询和自己设置就业目标相同的学长的学号，更具自己学号和学长毕业时间
     */
	public List<String> getWorkStudentNo(Map<String, Object> param);
	/**
     * 查询毕业生信息根据毕业时间集合
     */
	public List<StudentGraduateInfo> getGraduateInfoByGraduationDateList(List<String> yearParam);
	/**
     * 查询毕业生信息根据毕业时间
     */
	public List<StudentGraduateInfo> getGraduateInfoByGraduationDate(String graduationDate);

}