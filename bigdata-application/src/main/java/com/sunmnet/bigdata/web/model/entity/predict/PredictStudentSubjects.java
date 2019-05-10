/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.model.entity.predict;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @author wdong
 * @version 1.0
 * @ClassName PredictStudentSubjects
 * @Description
 * @date 2018-01-30 09:48:58
 */
public class PredictStudentSubjects extends BaseModel {

	//alias
	public static final String TABLE_ALIAS = "PredictStudentSubjects";
	public static final String ALIAS_STUDENT_NO = "student_no";
	public static final String ALIAS_STUDENT_GRADE = "student_grade";
	public static final String ALIAS_ACADEMY_NAME = "academy_name";
	public static final String ALIAS_MAJOR_NAME = "major_name";
	public static final String ALIAS_SUBJECT = "subject";
	public static final String ALIAS_PREDICT_SCORES = "predict_scores";
	public static final String ALIAS_MODEL_CORRELATION_COEFFICIENT = "model_correlation_coefficient";
	public static final String ALIAS_ACCURACY_MODEL_POINTS = "accuracy_model_points";
	public static final String ALIAS_RATE_OF_EXAM = "rate_of_exam";
	public static final String ALIAS_RATE_OF_FAIL_EXAM = "rate_of_fail_exam";
	public static final String ALIAS_TRAINING_SAMPLE = "training_sample";
	public static final String ALIAS_STATUS = "status";
	

	
    //学号
	private String studentNo;
    //年级
	private String studentGrade;
    //学院
	private String academyName;
    //专业
	private String majorName;
    //预测学科
	private String subject;
    //预测得分
	private String predictScores;
    //模型相关系数
	private String modelCorrelationCoefficient;
    //模型正负8分准确率
	private String accuracyModelPoints;
    //模型挂科回取率
	private String rateOfExam;
    //模型挂科误报率
	private String rateOfFailExam;
    //模型训练样本
	private String trainingSample;
    //
	private String status;

	public PredictStudentSubjects(){
	}


	public void setStudentNo(String value) {
		this.studentNo = value;
	}
	public String getStudentNo() {
		return this.studentNo;
	}


	public void setStudentGrade(String value) {
		this.studentGrade = value;
	}
	public String getStudentGrade() {
		return this.studentGrade;
	}


	public void setAcademyName(String value) {
		this.academyName = value;
	}
	public String getAcademyName() {
		return this.academyName;
	}


	public void setMajorName(String value) {
		this.majorName = value;
	}
	public String getMajorName() {
		return this.majorName;
	}


	public void setSubject(String value) {
		this.subject = value;
	}
	public String getSubject() {
		return this.subject;
	}


	public void setPredictScores(String value) {
		this.predictScores = value;
	}
	public String getPredictScores() {
		return this.predictScores;
	}


	public void setModelCorrelationCoefficient(String value) {
		this.modelCorrelationCoefficient = value;
	}
	public String getModelCorrelationCoefficient() {
		return this.modelCorrelationCoefficient;
	}


	public void setAccuracyModelPoints(String value) {
		this.accuracyModelPoints = value;
	}
	public String getAccuracyModelPoints() {
		return this.accuracyModelPoints;
	}


	public void setRateOfExam(String value) {
		this.rateOfExam = value;
	}
	public String getRateOfExam() {
		return this.rateOfExam;
	}


	public void setRateOfFailExam(String value) {
		this.rateOfFailExam = value;
	}
	public String getRateOfFailExam() {
		return this.rateOfFailExam;
	}


	public void setTrainingSample(String value) {
		this.trainingSample = value;
	}
	public String getTrainingSample() {
		return this.trainingSample;
	}


	public void setStatus(String value) {
		this.status = value;
	}
	public String getStatus() {
		return this.status;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("StudentNo",getStudentNo())
			.append("StudentGrade",getStudentGrade())
			.append("AcademyName",getAcademyName())
			.append("MajorName",getMajorName())
			.append("Subject",getSubject())
			.append("PredictScores",getPredictScores())
			.append("ModelCorrelationCoefficient",getModelCorrelationCoefficient())
			.append("AccuracyModelPoints",getAccuracyModelPoints())
			.append("RateOfExam",getRateOfExam())
			.append("RateOfFailExam",getRateOfFailExam())
			.append("TrainingSample",getTrainingSample())
			.append("Status",getStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStudentNo())
			.append(getStudentGrade())
			.append(getAcademyName())
			.append(getMajorName())
			.append(getSubject())
			.append(getPredictScores())
			.append(getModelCorrelationCoefficient())
			.append(getAccuracyModelPoints())
			.append(getRateOfExam())
			.append(getRateOfFailExam())
			.append(getTrainingSample())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof PredictStudentSubjects == false) return false;
		if(this == obj) return true;
		PredictStudentSubjects other = (PredictStudentSubjects)obj;
		return new EqualsBuilder()
			.append(getStudentNo(),other.getStudentNo())
			.append(getStudentGrade(),other.getStudentGrade())
			.append(getAcademyName(),other.getAcademyName())
			.append(getMajorName(),other.getMajorName())
			.append(getSubject(),other.getSubject())
			.append(getPredictScores(),other.getPredictScores())
			.append(getModelCorrelationCoefficient(),other.getModelCorrelationCoefficient())
			.append(getAccuracyModelPoints(),other.getAccuracyModelPoints())
			.append(getRateOfExam(),other.getRateOfExam())
			.append(getRateOfFailExam(),other.getRateOfFailExam())
			.append(getTrainingSample(),other.getTrainingSample())
			.append(getStatus(),other.getStatus())
			.isEquals();
	}
}

