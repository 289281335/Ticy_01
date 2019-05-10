package com.sunmnet.bigdata.web.dao.student;


import com.sunmnet.bigdata.web.model.entity.student.StudentConsumptionIndex;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.response.student.WholePortraitRES;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface IStudentLearningLevelDAO {

	/**
	 * 根据学号查询学习水平
	 * @param studentNo
	 * @return
	 */
    public BigDecimal selectLearningLevelByStudentNo(String studentNo);

    /**
     * 查询学习水平总条数
     * @return
     */
    public Integer countLearningLevel();


    /**
     * 查询指定行号的学习水平
     * @param lineNo
     * @return
     */
    public StudentConsumptionIndex selectStudentLearningLevelByLineNo(@Param(value = "lineNo") int lineNo);


    /**
     * 根据条件查询对应学习水平人数量
     * @param wholePortraitRES
     * @return
     */
    public Integer countLearningLevelByCondition(StudentInfoREQ wholePortraitRES);


}
