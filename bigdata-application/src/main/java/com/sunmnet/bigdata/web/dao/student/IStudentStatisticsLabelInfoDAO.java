package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentStatisticsLabelInfo;

import java.util.List;

public interface IStudentStatisticsLabelInfoDAO {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(StudentStatisticsLabelInfo studentStatisticsLabelInfo);

    public StudentStatisticsLabelInfo selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(StudentStatisticsLabelInfo studentStatisticsLabelInfo);
    /**
     * 查询要统计的标签
     */
	public List<StudentStatisticsLabelInfo> queryByStatusForYes();

}