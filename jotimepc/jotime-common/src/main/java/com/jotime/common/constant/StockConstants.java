package com.jotime.common.constant;

/**
 * 仓库常量
 *
 * @author zhangjun
 */
public class StockConstants
{
    /**
     * 品质类型常量 00不良品 01良品 02全部都可以 03 未知
     */
    public static final String KEEP_TYPE_DEFECT = "00";
    public static final String KEEP_TYPE_PASS = "01";
    public static final String KEEP_TYPE_ALL = "02";
    public static final String KEEP_TYPE_UN = "03";

    /**
     * 物料类型1：原料 2：包材 3预混料：4内料 ：5半成品 ：6成品
     */
    public static final int ITEMTYPE_1 = 1;
    public static final int ITEMTYPE_2 = 2;
    public static final int ITEMTYPE_3 = 3;
    public static final int ITEMTYPE_4 = 4;
    public static final int ITEMTYPE_5 = 5;
    public static final int ITEMTYPE_6 = 6;

    /**
     * 混放 1 不允许混放 2 混放
     *
     */
    public static final int MIX_NO = 1;
    public static final int MIX_YES = 2;

    /**
     * 数据类型
     *  CT  清点待质检  QC 已检待入库  SC已入库
     *
     */
    public static final String DATA_TYPE_CT = "CT";
    public static final String DATA_TYPE_QC = "QC";
    public static final String DATA_TYPE_SC = "SC";

    /**
     * 库位是否锁定
     *   2 锁定 1 不锁定
     *
     */
    public static final int DATA_TYPE_LOCK = 2;
    public static final int DATA_TYPE_NOTLOCK = 1;

    /*库位状态 1  禁用 2启用*/

    public static final int DATA_TYPE_STOP =1;
    public static final int DATA_TYPE_NOSTOP = 2;

    /** 入库订单类型 0 采购订单  1 备货采购   2 返工补料采购 3预处理料入库 4 内料入库 5 半成品入库 6 成品入库 7退料入库 8 退货入库 99其他入库*/
    public static final int STOCKIN_ORDER_TYPE_0 = 0;
    public static final int STOCKIN_ORDER_TYPE_1 = 1;
    public static final int STOCKIN_ORDER_TYPE_2 = 2;
    public static final int STOCKIN_ORDER_TYPE_3 = 3;
    public static final int STOCKIN_ORDER_TYPE_4 = 4;
    public static final int STOCKIN_ORDER_TYPE_5 = 5;
    public static final int STOCKIN_ORDER_TYPE_6 = 6;
    public static final int STOCKIN_ORDER_TYPE_7 = 7;
    public static final int STOCKIN_ORDER_TYPE_8 = 8;
    public static final int STOCKIN_ORDER_TYPE_99 = 99;

    /**入库通知表状态 1 待清点 2 清点中 3 已清点  9 入库取消*/
    public static final int INVENTORY_STATUS_1 = 1;
    public static final int INVENTORY_STATUS_2 = 2;
    public static final int INVENTORY_STATUS_3 = 3;
    public static final int INVENTORY_STATUS_9 = 9;

    /** 出库状态 -1 用作完成称重判断 0 待出库 1一次分拣 2 二次分拣 3 已出库  4 确定 99 取消出库*/
    public static final int WEIGHT_STATUS = -1;
    public static final int PREPARE_STOCK_OUT = 0;
    public static final int PRIMARY_SORTING = 1;
    public static final int SECONDARY_SORTING = 2;
    public static final int ALREADY_STOCK_OUT = 3;
    public static final int COMFIR_STOCK_OUT = 4;
    public static final int CANCEL_STOCK_OUT = 99;

    /**状态 1 待绑定 2 绑定中 3 绑定完了*/
    public static final int BIND_STATUS_WAIT = 1;
    public static final int BIND_STATUS_DOING = 2;
    public static final int BIND_STATUS_FINISH = 3;

    /**上架状态 1 未上架  2 已上架*/
    public static final int NO = 1;
    public static final int YES = 2;

    /**状态 1不需要扫码出库*/
    public static final int NEED_BARCODE_STOCKOUT_1 = 1;
    /**状态 2需要扫码出库*/
    public static final int NEED_BARCODE_STOCKOUT_2 = 2;

    /**称重状态 1 未称重*/
    public static final int WEIGHT_STATUS_1 = 1;
    /**称重状态 2 已称重*/
    public static final int WEIGHT_STATUS_2 = 2;


    /** 入库*/
    public static final int STOCK_IN = 1;
    /** 出库*/
    public static final int STOCK_OUT = 2;
    /** 待收货*/
    public static final int GOODS_RECEIVED = 1;
    /** 取消*/
    public static final int CANCEL = 9;

    /**
     * 清点 1 未清点 2 已清点
     *
     */
    public static final int PKG_STS_COUNT_N = 1;
    public static final int PKG_STS_COUNT_Y = 2;

    /**审核状态 1 待审核 2已审核*/
    public static final int CHECK_STATUS_WAIT = 1;
    public static final int CHECK_STATUS_FINISH = 2;

    /**审核状态 1 待质检 2 已指派 3 质检中 4待审核 5 审核中 6待评审 7评审中 8已检已审 9入库完了  99取消*/
    public static final int QUALITY_STATUS_1 = 1;
    public static final int QUALITY_STATUS_2 = 2;
    public static final int QUALITY_STATUS_3 = 3;
    public static final int QUALITY_STATUS_4 = 4;
    public static final int QUALITY_STATUS_5 = 5;
    public static final int QUALITY_STATUS_6 = 6;
    public static final int QUALITY_STATUS_7 = 7;
    public static final int QUALITY_STATUS_8 = 8;
    public static final int QUALITY_STATUS_9 = 9;
    public static final int QUALITY_STATUS_99 = 99;


    /**
     * 分拣区 FJ  仓库理货区LH 退货区TH 临期区LQDCL 清点区QD
     */
    public static final String AREA_TYPE_FJ = "FJ";
    public static final String AREA_TYPE_LH = "LH";
    public static final String AREA_TYPE_TH = "TH";
    public static final String AREA_TYPE_LQDCL = "LQDCL";
    public static final String AREA_TYPE_QD = "QD";

    /**
     * 产品放行状态（OK 放行  NG不放行   NE 未检查）
     */
    public static final String PRG_STATUS_OK = "OK";
    public static final String PRG_STATUS_NG = "NG";
    public static final String PRG_STATUS_NE = "NE";
}
