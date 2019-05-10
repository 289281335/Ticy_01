package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.PovertyStudentAnalyse;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface IPovertyStudentAnalyseDAO {
	/**
	 * 分页查询异常贫困学生列表
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	List<PovertyStudentAnalyse> pageUnusualPovertyStudent(Map<String, Object> map);

	int countUnusualPovertyStudent();

	/**
	 * 更改异常贫困学生关注状态
	 * @param id
	 * @param isfocus
	 * @param reason
	 * @return
	 */
	int updateUnusualPovertyStudentFocusStatus(PovertyStudentAnalyse povertyStudentAnalyse);

	/**
	 * 查询关爱学生列表
	 * @param pageNum
	 * @param pageSize
	 * @param handleResult
	 * @return
	 */
	List<PovertyStudentAnalyse> pageCareStudentInfo(Map<String, Object> map);

	int countCareStudentInfo(Map<String, Object> map);

	/**
	 * 更改关爱学生关注状态
	 * @param id
	 * @param isfocus
	 * @param reason
	 * @return
	 */
	int updateCareStudentInfoFocusStatus(PovertyStudentAnalyse povertyStudentAnalyse);

	/**
	 *  更改关爱学生处理结果
	 * @param id
	 * @param handleResult
	 * @return
	 */
	int updateCareStudentInfoHandleStatus(PovertyStudentAnalyse povertyStudentAnalyse);

	/**
	 * 查询特别关注学生列表
	 * @param pageNum
	 * @param pageSize
	 * @param isfocus
	 * @param reason
	 * @return
	 */
	List<PovertyStudentAnalyse> pageSpecialFocusStudentInfo(Map<String, Object> map);

	int countSpecialFocusStudentInfo(Map<String, Object> map);

	/**
	 * 更改特别关注学生关注状态
	 * @param id
	 * @param isfocus
	 * @param reason
	 * @return
	 */
	int updateSpecialFocusStudentInfoFocusStatus(PovertyStudentAnalyse povertyStudentAnalyse);

	/**
	 * 查询贫困生总人数
	 * @return
	 */
    public int countPovertyStudent();

    /**
     * 查询虚假贫困生总人数
     * @return
     */
    public int countUnPovertyStudent();

    /**
     * 查询建议关爱总人数
     * @return
     */
    public int countSupportPovertyStudent();

    /**
     * 根据学号查询虚假贫困生
     * @param studentNo
     * @return
     */
    public PovertyStudentAnalyse getUnPovertyByStudentNo(@Param("studentNo") String studentNo);

    /**
     * 根据学号查询建议关爱学生
     * @param studentNo
     * @return
     */
    public PovertyStudentAnalyse getSupportPovertyByStudentNo(@Param("studentNo") String studentNo);
    
    /**
     * 获得非贫困生月均消费中位数
     * @return
     */
    public BigDecimal getMonthAmountMiddle();
	
}