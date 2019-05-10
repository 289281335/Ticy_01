package com.sunmnet.bigdata.web.model.response.student;

/**
 * @author
 *
 * */

public class StudentGradePredictRES {

	/**
	 *	重新toString方法
	 * */
	@Override
	public String toString() {
		return "StudentGradePredictRES{" +
				"studentNo='" + studentNo + '\'' +
				", subject='" + subject + '\'' +
				", predictScores='" + predictScores + '\'' +
				", credits='" + credits + '\'' +
				", semester='" + semester + '\'' +
				", averageScores='" + averageScores + '\'' +
				'}';
	}

	/**
	 * 学号
	 * */
	private String studentNo;
	/**
	 * 课程名称
	 * */
	private String subject;
	/**
	 * 课程成绩
	 * */
	private String predictScores;
	/**
	 * 学分
	 * */
	private String credits;
	/**
	 * 学期
	 * */
	private String semester;
	/**
	 * 平均分
	 * */
	private String averageScores;


	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPredictScores() {
		return predictScores;
	}

	public void setPredictScores(String predictScores) {
		this.predictScores = predictScores;
	}

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getAverageScores() {
		return averageScores;
	}

	public void setAverageScores(String averageScores) {
		this.averageScores = averageScores;
	}
}
