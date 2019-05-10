package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.request.student.WholePortraitREQ;
import com.sunmnet.bigdata.web.model.response.student.WholePortraitRES;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IStudentSchoolRecordDAO {

	/**
	 * 根据学号查询学生成绩列表
	 * @param studentNo
	 * @return
     */
    public List<Map<String, Object>> selectStudentSchoolRecordByStudentNo(String studentNo);


    /**
     * 根据专业查询专业平均成绩
     * @param majorCode
     * @return
     */
    public List<Map<String, Object>> selectStudentSchoolRecordByMajorCode(String majorCode);


    /**
     * 根据条件查询挂科学生数量
     * @param wholePortraitREQ
     * @return
     */
    public Integer countFailGradesStudent(WholePortraitREQ wholePortraitREQ);


    /**
     * 查询专业人数
     * @param majorCode
     * @return
     */
    public Integer selectStudentCountByMajorCode(String majorCode);

    /**
     * 查询学生所在专业成绩排名
     * @param studentNo
     * @param majorCode
     * @return
     */
    public Integer selectScoreRankingByStudentNoAndMajorCode(@Param("studentNo") String studentNo, @Param("majorCode") String majorCode);


    /**
     * 查询学生成绩稳定性排名
     * @param studentNo
     * @param majorCode
     * @return
     */
    public Integer selectStabilityRankingByStudentNoAndMajorCode(@Param("studentNo") String studentNo, @Param("majorCode") String majorCode);

}