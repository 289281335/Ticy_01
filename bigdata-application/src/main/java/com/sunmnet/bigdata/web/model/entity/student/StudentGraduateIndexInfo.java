package com.sunmnet.bigdata.web.model.entity.student;


import com.sunmnet.bigdata.commons.model.BaseModel;

import java.math.BigDecimal;

/**
 * @ClassName GraduateIndexInfo
 * @Description 
 * @author wm
 * @date 2017-12-14 10:06:00
 * @version 1.0 
 */
public class StudentGraduateIndexInfo extends BaseModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4533301974054761679L;
	//主键  自增
    private Long id;
    //学号  唯一约束
    private String StudentNo;
    //平均成绩
    private BigDecimal averageAchievement;
    //学习水平
    private BigDecimal studyLevel;
    //学习稳定性
    private BigDecimal achievementStatus;
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
    private BigDecimal socialConnections;
    //朋友广泛性
    private BigDecimal friendsUniversality;
    //宿舍关系情况
    private BigDecimal dormitoryRelationship;
    //学霸交友数
    private BigDecimal superScholarFriends;
    //作息规律度
    private BigDecimal workRestRegularity;
    // 睡眠起床情况
    private BigDecimal sleepSituation;
    //平均睡眠时长
    private BigDecimal sleepTime;
    //外出情况
    private BigDecimal outSituation;
    //三餐规律度
    private BigDecimal threeMealsRegularity;
    //早餐就餐率
    private BigDecimal breakfastSituation;
    //上网健康度
    private BigDecimal internetHealth;
    //指标总和
    private BigDecimal indexTotal;
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
    public BigDecimal getAverageAchievement() {
        return averageAchievement;
    }
    public void setAverageAchievement(BigDecimal averageAchievement) {
        this.averageAchievement = averageAchievement;
    }
    public BigDecimal getStudyLevel() {
        return studyLevel;
    }
    public void setStudyLevel(BigDecimal studyLevel) {
        this.studyLevel = studyLevel;
    }
    public BigDecimal getAchievementStatus() {
        return achievementStatus;
    }
    public void setAchievementStatus(BigDecimal achievementStatus) {
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
    public BigDecimal getSocialConnections() {
        return socialConnections;
    }
    public void setSocialConnections(BigDecimal socialConnections) {
        this.socialConnections = socialConnections;
    }
    public BigDecimal getFriendsUniversality() {
        return friendsUniversality;
    }
    public void setFriendsUniversality(BigDecimal friendsUniversality) {
        this.friendsUniversality = friendsUniversality;
    }
    public BigDecimal getDormitoryRelationship() {
        return dormitoryRelationship;
    }
    public void setDormitoryRelationship(BigDecimal dormitoryRelationship) {
        this.dormitoryRelationship = dormitoryRelationship;
    }
    public BigDecimal getSuperScholarFriends() {
        return superScholarFriends;
    }
    public void setSuperScholarFriends(BigDecimal superScholarFriends) {
        this.superScholarFriends = superScholarFriends;
    }
    public BigDecimal getWorkRestRegularity() {
        return workRestRegularity;
    }
    public void setWorkRestRegularity(BigDecimal workRestRegularity) {
        this.workRestRegularity = workRestRegularity;
    }
    public BigDecimal getSleepSituation() {
        return sleepSituation;
    }
    public void setSleepSituation(BigDecimal sleepSituation) {
        this.sleepSituation = sleepSituation;
    }
    public BigDecimal getSleepTime() {
        return sleepTime;
    }
    public void setSleepTime(BigDecimal sleepTime) {
        this.sleepTime = sleepTime;
    }
    public BigDecimal getOutSituation() {
        return outSituation;
    }
    public void setOutSituation(BigDecimal outSituation) {
        this.outSituation = outSituation;
    }
    public BigDecimal getThreeMealsRegularity() {
        return threeMealsRegularity;
    }
    public void setThreeMealsRegularity(BigDecimal threeMealsRegularity) {
        this.threeMealsRegularity = threeMealsRegularity;
    }
    public BigDecimal getBreakfastSituation() {
        return breakfastSituation;
    }
    public void setBreakfastSituation(BigDecimal breakfastSituation) {
        this.breakfastSituation = breakfastSituation;
    }
    public BigDecimal getInternetHealth() {
        return internetHealth;
    }
    public void setInternetHealth(BigDecimal internetHealth) {
        this.internetHealth = internetHealth;
    }
    public BigDecimal getIndexTotal() {
        return indexTotal;
    }
    public void setIndexTotal(BigDecimal indexTotal) {
        this.indexTotal = indexTotal;
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