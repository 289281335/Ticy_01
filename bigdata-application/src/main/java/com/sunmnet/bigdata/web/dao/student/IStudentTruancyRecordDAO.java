package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentTruancyRecord;
import com.sunmnet.bigdata.web.model.request.student.WholePortraitREQ;
import com.sunmnet.bigdata.web.model.response.student.WholePortraitRES;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 学生逃课
 * @author
 *
 */
public interface IStudentTruancyRecordDAO {

	/**
	 * 查询某学生逃课信息
	 * @param studentNo
	 * @return
	 */
    List<StudentTruancyRecord> selectTruancyRecordByStudentNo(@Param("studentNo") String studentNo);
    
    /**
     * 根据条件统计疑似逃课信息
     * @param wholePortraitREQ
     * @return
     */
    List<Map<String, Object>> countTruancyByCondition(WholePortraitREQ wholePortraitREQ);
    
    /**
     * 根据条件查询疑似逃课学生信息
     * @param wholePortraitREQ
     * @return
     */
    List<Map<String, Object>> selectTruancyStudentByCondition(WholePortraitREQ wholePortraitREQ);
}