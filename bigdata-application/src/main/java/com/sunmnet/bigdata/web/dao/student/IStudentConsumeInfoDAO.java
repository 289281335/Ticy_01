package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentConsumeInfo;
import com.sunmnet.bigdata.web.model.request.student.WholePortraitREQ;
import com.sunmnet.bigdata.web.model.response.student.WholePortraitRES;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 学生消费信息mapper
 * @author
 *
 */
public interface IStudentConsumeInfoDAO {
	
	/**
	 * 查询全校三餐消费月份
	 * @return
	 */
	public Map<String, Object> listSchoolDietMonth();

	/**
	 * 查询全校学生三餐每月平均消费金额
     * @param maxDate
	 * @return
	 */
    public List<Map<String, Object>> listSchoolAverageDietDataMonth(@Param(value = "maxDate") String maxDate);

    /**
     * 查询男生三餐每月平均消费金额
     * @param maxDate
     * @return
     */
    public List<Map<String, Object>> listMaleAverageDietDataMonth(@Param(value = "maxDate") String maxDate);

    /**
     * 查询女生三餐每月平均消费金额
     * @param maxDate
     * @return
     */
    public List<Map<String, Object>> listFemaleAverageDietDataMonth(@Param(value = "maxDate") String maxDate);

    /**
     * 查询某学生三餐每月平均消费金额
     * @param studentNo
     * @param maxDate
     * @return
     */
    public List<Map<String, Object>> listStudentAverageDietDataMonth(@Param(value = "studentNo") String studentNo, @Param(value = "maxDate") String maxDate);

	/**
	 * 查询全校全部消费月份
	 * @return
	 */
	public Map<String, Object> listSchoolConsumeMonthList();

    /**
     * 查询全校学生每月平均消费金额
     * @param maxDate
     * @return
     */
    public List<Map<String, Object>> listSchoolAverageConsumeDataMonth(@Param(value = "maxDate") String maxDate);

    /**
     * 查询男生每月平均消费金额
     * @param maxDate
     * @return
     */
    public List<Map<String, Object>> listMaleAverageConsumeDataMonth(@Param(value = "maxDate") String maxDate);

    /**
     * 查询女生每月平均消费金额
     * @param maxDate
     * @return
     */
    public List<Map<String, Object>> listFemaleAverageConsumeDataMonth(@Param(value = "maxDate") String maxDate);

    /**
     * 查询某学生每月平均消费金额
     * @param studentNo
     * @param maxDate
     * @return
     */
    public List<Map<String, Object>> listStudentAverageConsumeDataMonth(@Param(value = "studentNo") String studentNo, @Param(value = "maxDate") String maxDate);

    /**
     * 查询某学生平均每餐饭消费金额
     * @param studentNo
     * @param maxDate
     * @return
     */
    public Map<String, Object> listStudentAverageDietDataMeal(@Param(value = "studentNo") String studentNo, @Param(value = "maxDate") String maxDate);

    /**
     * 查询全校学生平均每餐饭消费金额
     * @param maxDate
     * @return
     */
    public Map<String, Object> listSchoolAverageDietDataMeal(@Param(value = "maxDate") String maxDate);

    /**
     * 查询贫困学生平均每餐饭消费金额
     * @param maxDate
     * @return
     */
    public Map<String, Object> listNeedyAverageDietDataMeal(@Param(value = "maxDate") String maxDate);

    /**
     * 查询非贫困学生平均每餐饭消费金额
     * @param maxDate
     * @return
     */
    public Map<String, Object> listGeneralAverageDietDataMeal(@Param(value = "maxDate") String maxDate);

    /**
     * 查询某学生最近三个月的消费构成
     * @param studentNo
     * @return
     */
    public List<StudentConsumeInfo> listStudentLatestThreeMonthConsumeInfo(@Param(value = "studentNo") String studentNo);

    /**
     * 查询贫困生月平均消费金额
     * @param maxDate
     * @return
     */
    public List<Map<String, Object>> listNeedyAverageConsumeDataMonth(@Param(value = "maxDate") String maxDate);

    /**
     * 查询非贫困生月平均消费金额
     * @param maxDate
     * @return
     */
    public List<Map<String, Object>> listGeneralAverageConsumeDataMonth(@Param(value = "maxDate") String maxDate);

    /**
     * 查询贫困生平均每月三餐次数
     * @param maxDate
     * @return
     */
    public List<Map<String, Object>> listNeedyAverageDietTimesMonth(@Param(value = "maxDate") String maxDate);

    /**
     * 查询非贫困生平均每月三餐次数
     * @param maxDate
     * @return
     */
    public List<Map<String, Object>> listGeneralAverageDietTimesMonth(@Param(value = "maxDate") String maxDate);

    /**
     * 查询某学生早餐和夜宵次数
     * @param studentNo
     * @param maxDate
     * @return
     */
    public List<Map<String, Object>> listStudentBreakfastAndSupperTimes(@Param(value = "studentNo") String studentNo, @Param(value = "maxDate") String maxDate);

    /**
     * 查询学生指定月消费金额
     * @param studentNo
     * @param consumeDate
     * @return
     */
    public BigDecimal getStudentConsumeDataByStudentNoAndConsumeDate(@Param(value = "studentNo") String studentNo, @Param(value = "consumeDate") String consumeDate);

    /**
     * 查询指定月所有消费人数
     * @param consumeDate
     * @return
     */
    public int countAllConsumeTimesByConsumeDate(@Param(value = "consumeDate") String consumeDate);

    /**
     * 根据行号查询指定月消费金额
     * @param lineNo
     * @param consumeDate
     * @return
     */
    public BigDecimal getConsumeDataByLineNoAndConsumeDate(@Param(value = "lineNo") String lineNo, @Param(value = "consumeDate") String consumeDate);
    
    /**
     * 根据条件查询平均每月消费金额
     * @param wholePortraitREQ
     * @return
     */
    public List<Map<String, Object>> listAverageConsumeDateMonthByCondition(WholePortraitREQ wholePortraitREQ);
    
    /**
     * 根据条件查询平均每月三餐次数
     * @param wholePortraitREQ
     * @return
     */                               
    public List<Map<String, Object>> countAverageDietTimesMonthByCondition(WholePortraitREQ wholePortraitREQ);
}