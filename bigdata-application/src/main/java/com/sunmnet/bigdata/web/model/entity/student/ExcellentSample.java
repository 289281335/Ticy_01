package com.sunmnet.bigdata.web.model.entity.student;


import com.sunmnet.bigdata.commons.model.BaseModel;

import java.math.BigDecimal;

/**
 * 优秀样本信息
 */
public class ExcellentSample extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3525921875796410151L;
	
	private String flag;// group 群体  own 自己
	//平均成绩
    private BigDecimal averageAchievement;
    //学习水平
    private String studyLevel;
    //学习稳定性
    private String achievementStatus;
    //到课率
    private BigDecimal toClassRate;
    //准点率
    private BigDecimal punctualityRate;
    //奖励总数量
    private BigDecimal rewards;
    //国家级奖励总数量
    private BigDecimal countryRewards;
    //省级奖励总数量
    private BigDecimal provinceRewards;
    //校级奖励总数量
    private BigDecimal schoolRewards;
    //参与竞赛数
    private BigDecimal competition;
    //参与活动数
    private BigDecimal activity;
    //图书借阅数量
    private BigDecimal borrowBook;
    //社交关系
    private String socialConnections;
    //朋友广泛性
    private String friendsUniversality;
    //宿舍关系情况
    private String dormitoryRelationship;
    //学霸交友数
    private String superScholarFriends;
    //作息规律度
    private String workRestRegularity;
    // 睡眠起床情况
    private String sleepSituation;
    //平均睡眠时长
    private String sleepTime;
    //外出情况
    private String outSituation;
    //三餐规律度
    private String threeMealsRegularity;
    //早餐就餐率
    private String breakfastSituation;
    //上网健康度
    private String internetHealth;
    public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public BigDecimal getAverageAchievement() {
		return averageAchievement;
	}
	public void setAverageAchievement(BigDecimal averageAchievement) {
		this.averageAchievement = averageAchievement;
	}
	public String getStudyLevel() {
		return studyLevel;
	}
	public void setStudyLevel(String studyLevel) {
		this.studyLevel = studyLevel;
	}
	public String getAchievementStatus() {
		return achievementStatus;
	}
	public void setAchievementStatus(String achievementStatus) {
		this.achievementStatus = achievementStatus;
	}
	public BigDecimal getToClassRate() {
		return toClassRate;
	}
	public void setToClassRate(BigDecimal toClassRate) {
		this.toClassRate = toClassRate;
	}
	public BigDecimal getPunctualityRate() {
		return punctualityRate;
	}
	public void setPunctualityRate(BigDecimal punctualityRate) {
		this.punctualityRate = punctualityRate;
	}
	public BigDecimal getRewards() {
		return rewards;
	}
	public void setRewards(BigDecimal rewards) {
		this.rewards = rewards;
	}
	public BigDecimal getCountryRewards() {
		return countryRewards;
	}
	public void setCountryRewards(BigDecimal countryRewards) {
		this.countryRewards = countryRewards;
	}
	public BigDecimal getProvinceRewards() {
		return provinceRewards;
	}
	public void setProvinceRewards(BigDecimal provinceRewards) {
		this.provinceRewards = provinceRewards;
	}
	public BigDecimal getSchoolRewards() {
		return schoolRewards;
	}
	public void setSchoolRewards(BigDecimal schoolRewards) {
		this.schoolRewards = schoolRewards;
	}
	public BigDecimal getCompetition() {
		return competition;
	}
	public void setCompetition(BigDecimal competition) {
		this.competition = competition;
	}
	public BigDecimal getActivity() {
		return activity;
	}
	public void setActivity(BigDecimal activity) {
		this.activity = activity;
	}
	public BigDecimal getBorrowBook() {
		return borrowBook;
	}
	public void setBorrowBook(BigDecimal borrowBook) {
		this.borrowBook = borrowBook;
	}
	public String getSocialConnections() {
		return socialConnections;
	}
	public void setSocialConnections(String socialConnections) {
		this.socialConnections = socialConnections;
	}
	public String getFriendsUniversality() {
		return friendsUniversality;
	}
	public void setFriendsUniversality(String friendsUniversality) {
		this.friendsUniversality = friendsUniversality;
	}
	public String getDormitoryRelationship() {
		return dormitoryRelationship;
	}
	public void setDormitoryRelationship(String dormitoryRelationship) {
		this.dormitoryRelationship = dormitoryRelationship;
	}
	public String getSuperScholarFriends() {
		return superScholarFriends;
	}
	public void setSuperScholarFriends(String superScholarFriends) {
		this.superScholarFriends = superScholarFriends;
	}
	public String getWorkRestRegularity() {
		return workRestRegularity;
	}
	public void setWorkRestRegularity(String workRestRegularity) {
		this.workRestRegularity = workRestRegularity;
	}
	public String getSleepSituation() {
		return sleepSituation;
	}
	public void setSleepSituation(String sleepSituation) {
		this.sleepSituation = sleepSituation;
	}
	public String getSleepTime() {
		return sleepTime;
	}
	public void setSleepTime(String sleepTime) {
		this.sleepTime = sleepTime;
	}
	public String getOutSituation() {
		return outSituation;
	}
	public void setOutSituation(String outSituation) {
		this.outSituation = outSituation;
	}
	public String getThreeMealsRegularity() {
		return threeMealsRegularity;
	}
	public void setThreeMealsRegularity(String threeMealsRegularity) {
		this.threeMealsRegularity = threeMealsRegularity;
	}
	public String getBreakfastSituation() {
		return breakfastSituation;
	}
	public void setBreakfastSituation(String breakfastSituation) {
		this.breakfastSituation = breakfastSituation;
	}
	public String getInternetHealth() {
		return internetHealth;
	}
	public void setInternetHealth(String internetHealth) {
		this.internetHealth = internetHealth;
	}
	
}
