package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentIndustryTypeInfo;

import java.util.List;

public interface IStudentIndustryTypeInfoDAO {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(StudentIndustryTypeInfo studentIndustryTypeInfo);

    public StudentIndustryTypeInfo selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(StudentIndustryTypeInfo studentIndustryTypeInfo);
    /**
	 * 就业类行业类型信息查询
	 * @return
	 */
	public List<StudentIndustryTypeInfo> getAll();

	public StudentIndustryTypeInfo getIndustryTypeInfo(String studentNo);

}