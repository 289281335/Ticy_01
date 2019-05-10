package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentReadSchoolInfo;

import java.util.List;

public interface IStudentReadSchoolInfoDAO {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(StudentReadSchoolInfo studentReadSchoolInfo);

    public StudentReadSchoolInfo selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(StudentReadSchoolInfo studentReadSchoolInfo);
    /**
	 * 读研类学校信息查询
	 * @return
	 */
	public List<StudentReadSchoolInfo> getAll();
	/**
	 * 读研类学校信息查询（全部）
	 * @return
	 */
	public List<StudentReadSchoolInfo> getByStudentNoAllInfo(String studentNo);

}