package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentPositionTypeInfo;

import java.util.List;

public interface IStudentPositionTypeInfoDAO {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(StudentPositionTypeInfo studentPositionTypeInfo);

    public StudentPositionTypeInfo selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(StudentPositionTypeInfo studentPositionTypeInfo);
    /**
	 * 就业类职位类别信息
	 * @return
	 */
	public List<StudentPositionTypeInfo> getByIndustryCode(String industryCode);
	/**
	 * 就业类职位类别信息（全部信息）
	 * @return
	 */
	public List<StudentPositionTypeInfo> getByStudentNoAllInfo(String studentNo);

}