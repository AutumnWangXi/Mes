package com.jotime.common.constant;

/**
 * 审批常量
 *
 * @author zhangjun
 */
public class ApvlConstants
{
    /** 实际生产工序状态 未开始*/
    public static final int ACTUAL_PROCESS_STATUS1  = 1;
    /** 实际生产工序状态 生产中*/
    public static final int ACTUAL_PROCESS_STATUS2  = 2;
    /** 实际生产工序状态 完成*/
    public static final int ACTUAL_PROCESS_STATUS3  = 3;

    /** 是否已投料(Y 已投  N 未投)*/
    public static final String ACTUAL_FEEDING_FLAG_N  = "N";
    /** 是否已投料(Y 已投  N 未投)*/
    public static final String ACTUAL_FEEDING_FLAG_Y  = "Y";

    /**
     * 审批共同表(apvl_common)操作状态 状态  1 保存 2 待审批 3 审批中 4已审批 5撤销 6 办理中 9拒绝
     */
    public static final int COMMON_STS_APPLY  = 0;
    public static final int COMMON_STS_SAVE  = 1;
    public static final int COMMON_STS_WAIT  = 2;
    public static final int COMMON_STS_DOING  = 3;
    public static final int COMMON_STS_FINISH  = 4;
    public static final int COMMON_STS_CANCEL = 5;
    public static final int COMMON_STS_TRANSACT = 6;
    public static final int COMMON_STS_REJECT = 9;

    /**
     * 审批方式  1 单人审批方式 2 多人审批方式
     */
    public static final int APVL_MOETHOD_SINGLE  = 1;
    public static final int APVL_MOETHOD_DOUBLE  = 2;

    /**
     * 评论文件的table名
     */
    public static final String FILE_APVL_COMMENT = "apvlComment";

    /**
     * 办理人节点内码
     */
    public static final long CONDUCT_NODE_ID = 0L;

    /**
     * 办理人节点内码 1 待办理   2办理完成
     */
    public static final int CONDUCT_STS_WAIT = 1;

    public static final int CONDUCT_STS_FINISH = 2;
}
