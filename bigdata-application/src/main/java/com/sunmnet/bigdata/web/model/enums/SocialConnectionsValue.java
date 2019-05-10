package com.sunmnet.bigdata.web.model.enums;


import com.sunmnet.bigdata.web.model.entity.student.TradeTypeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 社交关系标签对用值
 */
public enum SocialConnectionsValue {

	SJQZX("社交圈子小", "1"),
	CJBWD("社交圈子较小", "2"),
	SJQZZD("社交圈子中等", "3"),
	SJDR("社交达人", "4"),
	SJW("社交王", "5");

    SocialConnectionsValue(String name, String value) {
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
        SocialConnectionsValue[] exceptionMsg = SocialConnectionsValue.values();

       if(exceptionMsg != null && exceptionMsg.length > 0){
           resultList = new ArrayList<TradeTypeModel>();
           TradeTypeModel typeModel = null;
           for(SocialConnectionsValue typeEnum:exceptionMsg){
               typeModel = new TradeTypeModel();
               typeModel.setName(typeEnum.getName());
               typeModel.setValue(typeEnum.getValue());
               resultList.add(typeModel);
           }
        }
       return resultList;
   }
    
}
