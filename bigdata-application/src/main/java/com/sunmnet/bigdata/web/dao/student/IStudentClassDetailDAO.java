package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentClassDetail;

import java.util.List;

public interface IStudentClassDetailDAO {

	/**
	 * 根据学号查询到课详情
	 * @param studentNo
	 * @return
	 */
	public List<StudentClassDetail> selectClassDetailByStudentNo(String studentNo);
	
}
