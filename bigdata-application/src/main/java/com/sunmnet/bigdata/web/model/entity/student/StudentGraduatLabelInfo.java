package com.sunmnet.bigdata.web.model.entity.student;


import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @ClassName GraduatLabelInfo
 * @Description 
 * @author wm
 * @date 2017-12-12 14:30:34
 * @version 1.0 
 */
public class StudentGraduatLabelInfo extends BaseModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8776909063334045546L;
	//主键，自增
    private Long id;
    //学号  唯一约束
    private String StudentNo;
    //学习水平
    private String studyLevel;
    //成绩稳定性
    private String achievementStatus;
    //上课纪律
    private String classDiscipline;
    //挂科次数
    private String failNum;
    //上网沉迷度
    private String internetAddiction;
    //上网时间点
    private String internetTime;
    //上网健康度
    private String internetHealth;
    //消费金额
    private String consumptionAmount;
    //消费特点
    private String consumptionCharacteristic;
    //恩格尔系数
    private String engelCoefficient;
    //贫困生
    private String poorStudents;
    //三餐规律度
    private String threeMealsRegularity;
    //三餐口味
    private String threeMealsTaste;
    //早餐就餐情况
    private String breakfastSituation;
    //夜宵就餐情况
    private String supperSituation;
    //整体情况
    private String overallSituation;
    //朋友广泛性
    private String friendsUniversality;
    //宿舍关系情况
    private String dormitoryRelationship;
    //学霸交友情况
    private String superScholarFriends;
    //作息规律度
    private String workRestRegularity;
    //睡眠起床情况
    private String sleepSituation;
    //睡眠时长
    private String sleepTime;
    //外出情况
    private String outSituation;
    //创建时间 格式：yyyyMMddHHmmssSSS 
    private String createTime;
    //最后修改时间 格式：yyyyMMddHHmmssSSS
    private String modifyTime;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStudentNo() {
        return StudentNo;
    }
    public void setStudentNo(String StudentNo) {
        this.StudentNo = StudentNo == null ? null : StudentNo.trim();
    }
    public String getStudyLevel() {
        return studyLevel;
    }
    public void setStudyLevel(String studyLevel) {
        this.studyLevel = studyLevel == null ? null : studyLevel.trim();
    }
    public String getAchievementStatus() {
        return achievementStatus;
    }
    public void setAchievementStatus(String achievementStatus) {
        this.achievementStatus = achievementStatus == null ? null : achievementStatus.trim();
    }
    public String getClassDiscipline() {
        return classDiscipline;
    }
    public void setClassDiscipline(String classDiscipline) {
        this.classDiscipline = classDiscipline == null ? null : classDiscipline.trim();
    }
    public String getFailNum() {
        return failNum;
    }
    public void setFailNum(String failNum) {
        this.failNum = failNum == null ? null : failNum.trim();
    }
    public String getInternetAddiction() {
        return internetAddiction;
    }
    public void setInternetAddiction(String internetAddiction) {
        this.internetAddiction = internetAddiction == null ? null : internetAddiction.trim();
    }
    public String getInternetTime() {
        return internetTime;
    }
    public void setInternetTime(String internetTime) {
        this.internetTime = internetTime == null ? null : internetTime.trim();
    }
    public String getInternetHealth() {
		return internetHealth;
	}
	public void setInternetHealth(String internetHealth) {
		this.internetHealth = internetHealth;
	}
	public String getConsumptionAmount() {
        return consumptionAmount;
    }
    public void setConsumptionAmount(String consumptionAmount) {
        this.consumptionAmount = consumptionAmount == null ? null : consumptionAmount.trim();
    }
    public String getConsumptionCharacteristic() {
        return consumptionCharacteristic;
    }
    public void setConsumptionCharacteristic(String consumptionCharacteristic) {
        this.consumptionCharacteristic = consumptionCharacteristic == null ? null : consumptionCharacteristic.trim();
    }
    public String getEngelCoefficient() {
        return engelCoefficient;
    }
    public void setEngelCoefficient(String engelCoefficient) {
        this.engelCoefficient = engelCoefficient == null ? null : engelCoefficient.trim();
    }
    public String getPoorStudents() {
        return poorStudents;
    }
    public void setPoorStudents(String poorStudents) {
        this.poorStudents = poorStudents == null ? null : poorStudents.trim();
    }
    public String getThreeMealsRegularity() {
        return threeMealsRegularity;
    }
    public void setThreeMealsRegularity(String threeMealsRegularity) {
        this.threeMealsRegularity = threeMealsRegularity == null ? null : threeMealsRegularity.trim();
    }
    public String getThreeMealsTaste() {
        return threeMealsTaste;
    }
    public void setThreeMealsTaste(String threeMealsTaste) {
        this.threeMealsTaste = threeMealsTaste == null ? null : threeMealsTaste.trim();
    }
    public String getBreakfastSituation() {
        return breakfastSituation;
    }
    public void setBreakfastSituation(String breakfastSituation) {
        this.breakfastSituation = breakfastSituation == null ? null : breakfastSituation.trim();
    }
    public String getSupperSituation() {
        return supperSituation;
    }
    public void setSupperSituation(String supperSituation) {
        this.supperSituation = supperSituation == null ? null : supperSituation.trim();
    }
    public String getOverallSituation() {
        return overallSituation;
    }
    public void setOverallSituation(String overallSituation) {
        this.overallSituation = overallSituation == null ? null : overallSituation.trim();
    }
    public String getFriendsUniversality() {
        return friendsUniversality;
    }
    public void setFriendsUniversality(String friendsUniversality) {
        this.friendsUniversality = friendsUniversality == null ? null : friendsUniversality.trim();
    }
    public String getDormitoryRelationship() {
        return dormitoryRelationship;
    }
    public void setDormitoryRelationship(String dormitoryRelationship) {
        this.dormitoryRelationship = dormitoryRelationship == null ? null : dormitoryRelationship.trim();
    }
    public String getSuperScholarFriends() {
        return superScholarFriends;
    }
    public void setSuperScholarFriends(String superScholarFriends) {
        this.superScholarFriends = superScholarFriends == null ? null : superScholarFriends.trim();
    }
    public String getWorkRestRegularity() {
        return workRestRegularity;
    }
    public void setWorkRestRegularity(String workRestRegularity) {
        this.workRestRegularity = workRestRegularity == null ? null : workRestRegularity.trim();
    }
    public String getSleepSituation() {
        return sleepSituation;
    }
    public void setSleepSituation(String sleepSituation) {
        this.sleepSituation = sleepSituation == null ? null : sleepSituation.trim();
    }
    public String getSleepTime() {
        return sleepTime;
    }
    public void setSleepTime(String sleepTime) {
        this.sleepTime = sleepTime == null ? null : sleepTime.trim();
    }
    public String getOutSituation() {
        return outSituation;
    }
    public void setOutSituation(String outSituation) {
        this.outSituation = outSituation == null ? null : outSituation.trim();
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
    public String getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

}