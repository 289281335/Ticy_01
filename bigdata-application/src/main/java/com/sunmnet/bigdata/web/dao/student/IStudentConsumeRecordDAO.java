package com.sunmnet.bigdata.web.dao.student;


import com.sunmnet.bigdata.web.model.entity.student.StudentConsumeRecord;

import java.util.List;

/**
 * 学生最近消费记录mapper
 * @author niuliqiang
 *
 */
public interface IStudentConsumeRecordDAO {

	/**
	 * 查询学生最近就餐情况
	 * @param studentConsumeRecord
	 * @return
	 */
    public List<StudentConsumeRecord> listLatestDietSituation(StudentConsumeRecord studentConsumeRecord);
    
    /**
     * 查询最新的就餐日期
     * @return
     */
    public String getLatestDietDate();

}