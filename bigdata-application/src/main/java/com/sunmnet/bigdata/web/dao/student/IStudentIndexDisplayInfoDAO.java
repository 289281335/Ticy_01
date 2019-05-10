package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentIndexDisplayInfo;

import java.util.List;

public interface IStudentIndexDisplayInfoDAO {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(StudentIndexDisplayInfo studentIndexDisplayInfo);

    public StudentIndexDisplayInfo selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(StudentIndexDisplayInfo studentIndexDisplayInfo);
    /**
     * 获取学生样本显示指标和权重
     * @return
     */
	public List<StudentIndexDisplayInfo> getAll();

}