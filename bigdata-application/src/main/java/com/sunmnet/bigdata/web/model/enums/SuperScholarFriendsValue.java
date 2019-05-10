package com.sunmnet.bigdata.web.model.enums;


import com.sunmnet.bigdata.web.model.entity.student.TradeTypeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 学霸交友数标签对用值
 */
public enum SuperScholarFriendsValue {
	WXBPY("无学霸朋友", "1"),
	XBPYJD("学霸朋友较多", "2"), 
	XBPYD("学霸朋友多", "3"), 
	XBQZW("学霸圈子王", "4");
	

    SuperScholarFriendsValue(String name, String value) {
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
        SuperScholarFriendsValue[] exceptionMsg = SuperScholarFriendsValue.values();

       if(exceptionMsg != null && exceptionMsg.length > 0){
           resultList = new ArrayList<TradeTypeModel>();
           TradeTypeModel typeModel = null;
           for(SuperScholarFriendsValue typeEnum:exceptionMsg){
               typeModel = new TradeTypeModel();
               typeModel.setName(typeEnum.getName());
               typeModel.setValue(typeEnum.getValue());
               resultList.add(typeModel);
           }
        }
       return resultList;
   }
    
}
