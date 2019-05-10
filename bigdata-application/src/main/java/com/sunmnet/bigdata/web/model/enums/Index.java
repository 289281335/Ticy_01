package com.sunmnet.bigdata.web.model.enums;

/**
 * 样本指标枚举
 */
public enum Index {
	ACHIEVEMENT("平均成绩", "ACHIEVEMENT"),
	STUDYLEVEL("学习水平", "STUDYLEVEL"),
	ACHIEVEMENTSTATUS("学习稳定性", "ACHIEVEMENTSTATUS"),
	TOCLASSRATE("到课率", "TOCLASSRATE"),
	PUNCTUALITYRATE("准点率", "PUNCTUALITYRATE"),
	REWARDS("奖励总数量", "REWARDS"),
	COUNTRYREWARDS("国家级奖励总数量", "COUNTRYREWARDS"),
	PROVINCEREWARDS("省级奖励总数量", "PROVINCEREWARDS"),
	SCHOOLREWARDS("校级奖励总数量", "SCHOOLREWARDS"),
	ACTIVITY("参与活动", "ACTIVITY"),
	COMPETITION("竞赛数量", "COMPETITION"),
	BORROWBOOK("图书借阅数量", "BORROWBOOK"),
	SOCIALCONNECTIONS("社交关系", "SOCIALCONNECTIONS"),
	FRIENDSUNIVERSALITY("朋友广泛性", "FRIENDSUNIVERSALITY"),
	DORMITORYRELATIONSHIP("宿舍关系情况", "DORMITORYRELATIONSHIP"),
	SUPERSCHOLARFRIENDS("学霸交友数", "SUPERSCHOLARFRIENDS"),
	WORKRESTREGULARITY("作息规律度", "WORKRESTREGULARITY"),
	SLEEPSITUATION("睡眠起床情况", "SLEEPSITUATION"),
	SLEEPTIME("平均睡眠时长", "SLEEPTIME"),
	OUTSITUATION("外出情况", "OUTSITUATION"),
	THREEMEALSREGULARITY("三餐规律度", "THREEMEALSREGULARITY"),
	BREAKFASTSITUATION("早餐就餐率", "BREAKFASTSITUATION"),
	INTERNETHEALTH("上网健康度", "INTERNETHEALTH");

    Index(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

    
}
