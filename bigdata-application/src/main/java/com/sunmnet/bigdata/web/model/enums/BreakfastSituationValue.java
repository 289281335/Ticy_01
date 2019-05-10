package com.sunmnet.bigdata.web.model.enums;


import com.sunmnet.bigdata.web.model.entity.student.TradeTypeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 早餐就餐情况标签对用值
 */
public enum BreakfastSituationValue {
	ZCJYZ("早餐绝缘者", "1"),
	BACZC("不爱吃早餐", "2"), 
	ZCGLDYB("早餐规律度一般", "3"),
	ZCGL("早餐规律", "4");

    BreakfastSituationValue(String name, String value) {
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
        BreakfastSituationValue[] exceptionMsg = BreakfastSituationValue.values();

       if(exceptionMsg != null && exceptionMsg.length > 0){
           resultList = new ArrayList<TradeTypeModel>();
           TradeTypeModel typeModel = null;
           for(BreakfastSituationValue typeEnum:exceptionMsg){
               typeModel = new TradeTypeModel();
               typeModel.setName(typeEnum.getName());
               typeModel.setValue(typeEnum.getValue());
               resultList.add(typeModel);
           }
        }
       return resultList;
   }
    
}
