package com.sunmnet.bigdata.web.model.enums;

import com.sunmnet.bigdata.web.model.entity.student.TradeTypeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 学习稳定性标签对用值
 */
public enum AchievementStatusValue {
	CJBWD("成绩不稳定", "1"),
	CJJBWD("成绩较不稳定", "2"),
	CJWDXYB("成绩稳定性一般", "3"),
	CJJWD("成绩较稳定", "4"),
	CJHWD("成绩很稳定", "5");

    AchievementStatusValue(String name, String value) {
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
	  /**
     * 获取枚举类型list集合
     * @author 
     * @return
     */
    public static List<TradeTypeModel>  getTradeTypeList(){
        List<TradeTypeModel> resultList = null;
        AchievementStatusValue[] exceptionMsg = AchievementStatusValue.values();

       if(exceptionMsg != null && exceptionMsg.length > 0){
           resultList = new ArrayList<TradeTypeModel>();
           TradeTypeModel typeModel = null;
           for(AchievementStatusValue typeEnum:exceptionMsg){
               typeModel = new TradeTypeModel();
               typeModel.setName(typeEnum.getName());
               typeModel.setValue(typeEnum.getValue());
               resultList.add(typeModel);
           }
        }
       return resultList;
   }
    
}
