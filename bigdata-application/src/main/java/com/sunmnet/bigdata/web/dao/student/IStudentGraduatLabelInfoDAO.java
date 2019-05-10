package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentGraduatLabelInfo;

import java.util.List;

public interface IStudentGraduatLabelInfoDAO {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(StudentGraduatLabelInfo studentGraduatLabelInfo);

    public StudentGraduatLabelInfo selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(StudentGraduatLabelInfo studentGraduatLabelInfo);
    /**
     * 查询毕业生的标签信息（根据学号list）
     */
	public List<StudentGraduatLabelInfo> getGraduatLabelInfo(List<String> studentNoList);
	
	/**
     * 查询毕业生的标签信息（根据学号）
     */
	public StudentGraduatLabelInfo getByStudentNo(String studentNo);
	
	/**
     * 查询没有数据为第一次跑，跑今年前三年的，有数据只跑当年数据
     */
	public long getGraduatLabelInfoTotal();

}