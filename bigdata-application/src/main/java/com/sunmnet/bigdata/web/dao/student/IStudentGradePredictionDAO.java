package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.response.student.StudentGradePredictRES;

import java.util.List;


/**
 *
 * @author
 *
 * 个人画像--学习（本学期成绩预测）
 *
 * */

public interface IStudentGradePredictionDAO {
    
	 /**
      *
      * 根据学号查出该生某学年的每科成绩
      *
      * @return 返回一个StudentGradePredictRES集合
      * @param studentNo 学号
      *
      * */
    public List<StudentGradePredictRES> gradePrediction(String studentNo);
    
    /**
     * 查询预测挂科数量
     * @param studentNo 学号
     * @return 返回一个int值
     */
    public int selectFailCourseCount(String studentNo);
    }