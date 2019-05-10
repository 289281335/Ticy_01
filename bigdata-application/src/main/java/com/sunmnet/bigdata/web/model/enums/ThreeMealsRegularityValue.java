package com.sunmnet.bigdata.web.model.enums;


import com.sunmnet.bigdata.web.model.entity.student.TradeTypeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 三餐规律度标签对用值
 */
public enum ThreeMealsRegularityValue {
	
	SCBGL("三餐不规律", "1"),
	SCJBGL("三餐较不规律", "2"), 
	SCGLYB("三餐规律一般", "3"),
	SCJGL("三餐较规律", "4"),
	SCHGL("三餐很规律", "5");

    ThreeMealsRegularityValue(String name, String value) {
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
        ThreeMealsRegularityValue[] exceptionMsg = ThreeMealsRegularityValue.values();

       if(exceptionMsg != null && exceptionMsg.length > 0){
           resultList = new ArrayList<TradeTypeModel>();
           TradeTypeModel typeModel = null;
           for(ThreeMealsRegularityValue typeEnum:exceptionMsg){
               typeModel = new TradeTypeModel();
               typeModel.setName(typeEnum.getName());
               typeModel.setValue(typeEnum.getValue());
               resultList.add(typeModel);
           }
        }
       return resultList;
   }
    
}
