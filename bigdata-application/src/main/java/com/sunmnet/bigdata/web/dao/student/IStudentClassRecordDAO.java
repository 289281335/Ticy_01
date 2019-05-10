package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentClassRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IStudentClassRecordDAO {

	/**
	 * 根据学号查询上课情况
	 * @param studentNo
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
    public List<StudentClassRecord> selectClassRecordByStudentNo(
            @Param("studentNo") String studentNo,
            @Param("fromDate") String fromDate,
            @Param("toDate") String toDate);

    /**
     * 根据学号和月份查询到课率
     * @param studentNo
     * @param fromDate
     * @param toDate
     * @return
     */
    public List<Map<String, Object>> selectClassRateByStudentNoAndMonth(
            @Param("studentNo") String studentNo,
            @Param("fromDate") String fromDate,
            @Param("toDate") String toDate);

    /**
     * 根据学号和学期查询到课率
     * @param studentNo
     * @return
     */
    public List<Map<String, Object>> selectClassRateByStudentNoAndTerm(
            @Param("studentNo") String studentNo);

    /**
     * 根据学号查询到课时间
     * @param studentNo
     * @param fromDate
     * @param toDate
     * @return
     */
    public Map<String,Object> selectClassTimeByStudentNo(
            @Param("studentNo") String studentNo,
            @Param("fromDate") String fromDate,
            @Param("toDate") String toDate);

    /**
     * 根据学号查询准点上课率
     * @param studentNo
     * @return
     */
    public List<Map<String, Object>> selectOnTimeRateByStudentNo(
            @Param("studentNo") String studentNo);
    		
}