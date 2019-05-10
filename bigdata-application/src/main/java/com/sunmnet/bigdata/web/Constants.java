package com.sunmnet.bigdata.web;

public class Constants {


    /* 过去7天 */
    public final static int LAST_7_DAYS = 7;
    /*每天最多统计5个时间段*/
    public final static int MAX_PERIOD_OF_TIME = 5;
    public final static String DAY_OF_START = " 00:00:00";
    public final static String DAY_OF_END = " 23:59:59";
    public final static String SURF_INTERNET_STATUS = "Start";

    //周末上网疯狂分割线
    public final static int HEALTH_OF_NET_WEEKEND = 20;
    //上网迷恋分割线
    public final static int STATUS_OF_NET_SEVERE = 8;
    public final static int STATUS_OF_NET_MILD = 5;

    //上网迷恋和统计字段
    public final static String TOTAL_NET_FIELD = "total";
    public final static String CATEGARY_NET_FIELD = "categary";
    public final static int MAX_TIME_NET_FIELD = 6;
    public final static int MAX_PERIOD_NET_FIELD = 8;
    public final static int ZERO_VALUE_TOTAL = 0;
    //上网健康率
    public final static double RATE_HEALTH_BEST_BAD_STATUS = 0.2;
    public final static double RATE_HEALTH_BAD_STATUS = 0.4;
    public final static double RATE_HEALTH_NORMAL_STATUS = 0.6;
    public final static double RATE_HEALTH_GOOD_STATUS = 0.8;

    public final static String VALUE_NET_RATE_FIELD = "ratioVale";
    public final static String HEALTH_NET_INFO_FIELD = "healthInfo";

    public final static int ONE_VALUE_RATE = 1;

    //预警
//    public final static String
    //学期
    public final static String SEMESTER="semester";




}
