package com.sunmnet.bigdata.web.dao.student;


import com.sunmnet.bigdata.web.model.response.student.StudentNetTimeInfoRES;

import java.util.List;
import java.util.Map;

public interface IStudentNetTimeInfoDAO {

	/**
	 * 综合画像-上网选项卡
	 * @param map
	 * @return
	 */
	public List<StudentNetTimeInfoRES> nearlyNdayNetInfo(Map<String, Object> map);

	/**
	 * 根据群体画像统一条件查询学生学号列表(sql存在疑问)
	 * @param map
	 * @return
	 */
	public List<String> listStudentNoByCondition(Map<String, Object> map);
	
}