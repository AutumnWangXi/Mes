package com.jotime.common.constant;

/**
 * @author hxh
 * @date 2022/3/2
 **/
public class PdEeWorkinfoConstants {
    /** 生产订单表状态 */
    //待排产
    public final static String WAIT_PRODUCTION_SCHEDULING = "1";
    //部分排产
    public final static String PART_PRODUCTION_SCHEDULING = "2";
    //全部排产
    public final static String ALL_PRODUCTION_SCHEDULING = "3";
    //全部完成
    public final static String ALL_COMPLETED = "4";



    /** 订单生产人员 费用结算方式 */
    //计件
    public final static String PRICE = "price";
    //计时
    public final static String TIME = "time";
}
