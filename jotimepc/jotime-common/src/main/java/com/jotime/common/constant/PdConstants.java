package com.jotime.common.constant;

/**
 * 生产常量
 *
 * @author zhangjun
 */
public class PdConstants
{
    /** 订单来源类型
     *  1 采购 2、 生产  3 销售9 其他
     *
     * */
    public final static int ORIGIN_TYPE_PUR = 1;
    public final static int ORIGIN_TYPE_PD = 2;
    public final static int ORIGIN_TYPE_SELL = 3;
    public final static int ORIGIN_TYPE_OTHER = 9;

    /** 班组生产任务状态
     *  1 待生产  2 领料中 3 待学习 4 学习中 5 待开线  6 开线中 7 生产中  8 待清线 9 清线中  10 生产完成 99 关闭
     *
     * */
    public final static int GROUP_ORDER_STATUS_1 = 1;
    public final static int GROUP_ORDER_STATUS_2 = 2;
    public final static int GROUP_ORDER_STATUS_3 = 3;
    public final static int GROUP_ORDER_STATUS_4 = 4;
    public final static int GROUP_ORDER_STATUS_5 = 5;
    public final static int GROUP_ORDER_STATUS_6 = 6;
    public final static int GROUP_ORDER_STATUS_7 = 7;
    public final static int GROUP_ORDER_STATUS_8 = 8;
    public final static int GROUP_ORDER_STATUS_9 = 9;
    public final static int GROUP_ORDER_STATUS_10 = 10;
    public final static int GROUP_ORDER_STATUS_99 = 99;

    /** 开线清线
     *   1 待开线/待清线/未审核 2 已开线/已清线/已审核  3 已完成 9 驳回
     *
     * */
    public final static int PD_LINE_CHECKINFO_1 = 1;
    public final static int PD_LINE_CHECKINFO_2 = 2;
    public final static int PD_LINE_CHECKINFO_3 = 3;
    public final static int PD_LINE_CHECKINFO_9 = 9;

    /** 是否流水线生产 是*/
    public static final String IS_FLOW_PD_Y = "Y";
    /** 是否流水线生产 否*/
    public static final String IS_FLOW_PD_N = "N";

    /** 班组生产任务明细状态
     *  1 待领料 2 领料中 3 领料完成 4关闭
     *
     * */
    public final static int GROUP_ORDER_DTL_STATUS_1 = 1;
    public final static int GROUP_ORDER_DTL_STATUS_2 = 2;
    public final static int GROUP_ORDER_DTL_STATUS_3 = 3;
    public final static int GROUP_ORDER_DTL_STATUS_4 = 4;
}
