package com.sunmnet.bigdata.web.model.response.statis;

public class SurfInternetStatusRES {
    //沉迷网络程度
    private String netDegrees;
    //周末沉迷网络程度
    private String netWeekendDegrees;

    public String getNetDegrees() {
        return netDegrees;
    }

    public void setNetDegrees(String netDegrees) {
        this.netDegrees = netDegrees;
    }

    public String getNetWeekendDegrees() {
        return netWeekendDegrees;
    }

    public void setNetWeekendDegrees(String netWeekendDegrees) {
        this.netWeekendDegrees = netWeekendDegrees;
    }
}
