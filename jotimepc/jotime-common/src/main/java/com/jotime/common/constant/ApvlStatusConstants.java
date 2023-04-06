package com.jotime.common.constant;

import java.math.BigDecimal;

/**
 * 常用状态常量
 *
 * @author chenkuo
 */
public class ApvlStatusConstants {

    /**
     * 审批类型
     * 合同申请 apply_contract
     * 打样申请 apply_formula
     * 报价申请 apply_quote
     * 订单采购 apply_order_purchase
     * 生产订单 apply_product_order
     * 销售出货申请 apply_sell_stockout
     * 备货采购 apply_stock_purchase
     * 返工报废 apply_supplementaries
     * 缺料评审 apply_defect_review
     */
    public static final String APPLY_CONTRACT = "apply_contract";
    public static final String APPLY_FORMULA = "apply_formula";
    public static final String APPLY_QUOTE = "apply_quote";
    public static final String APPLY_ORDER_PURCHASE = "apply_order_purchase";
    public static final String APPLY_PRODUCT_ORDER = "apply_product_order";
    public static final String APPLY_STOCK_PURCHASE = "apply_stock_purchase";
    public static final String APPLY_SELL_STOCKOUT = "apply_sell_stockout";
    public static final String APPLY_SUPPLEMENTARIES = "apply_supplementaries";
    public static final String APPLY_DEFECT_REVIEW = "apply_defect_review";


    /**
     * 合同申请  LIST_CHECK_DATA_CONTRACT
     * 生产订单 LIST_CHECK_DATA_PD_ORDER
     * 半成品物料替换 LIST_CHECK_DATA_REPLACE
     * 返工报废 LIST_CHECK_DATA_SUPPLEMENTARIES
     */
    public final static int LIST_CHECK_DATA_PD_ORDER = 1;
    public final static int LIST_CHECK_DATA_REPLACE = 2;
    public final static int LIST_CHECK_DATA_CONTRACT = 3;
    public final static int LIST_CHECK_DATA_SUPPLEMENTARIES = 4;

    /**
     * 质检管理状态 1 未质检 2 已检未审 3 已检已审 9 入库取消
     */
    public static final int QUALITY_INSPECTION_STATUS_1 = 1;
    public static final int QUALITY_INSPECTION_STATUS_2 = 2;
    public static final int QUALITY_INSPECTION_STATUS_3 = 3;
    public static final int QUALITY_INSPECTION_STATUS_9 = 9;

    /**
     * 质检类型  QC 质检缺陷 IPQC 巡检缺陷
     */
    public static final String DEFECT_TYPE_QC = "QC";
    public static final String DEFECT_TYPE_IPQC = "IPQC";

    /**
     * 质检状态 1 待质检 2 已指派 3 质检中 4待审核 5 审核中 6待评审 7评审中 8已检已审  99取消
     */
    public static final int QC_TASK_STATUS_1 = 1;
    public static final int QC_TASK_STATUS_2 = 2;
    public static final int QC_TASK_STATUS_3 = 3;
    public static final int QC_TASK_STATUS_4 = 4;
    public static final int QC_TASK_STATUS_5 = 5;
    public static final int QC_TASK_STATUS_6 = 6;
    public static final int QC_TASK_STATUS_7 = 7;
    public static final int QC_TASK_STATUS_8 = 8;
    public static final int QC_TASK_STATUS_99 = 99;

    /**
     * 数据类型 CT  清点待质检  QC 已检待入库  SC 已入库',
     */
    public static final String TYPE_OF_DATA_CT = "CT";
    public static final String TYPE_OF_DATA_QC = "QC";
    public static final String TYPE_OF_DATA_SC = "SC";

    /**
     * 质检来源(1 采购 2 生产 9 其他
     */
    public static final int QUALITY_INSPECTION_SOURCE_1 = 1;
    public static final int QUALITY_INSPECTION_SOURCE_2 = 2;
    public static final int QUALITY_INSPECTION_SOURCE_9 = 9;


    /**
     * 清点状态  1 待清点 2 清点完成 9 入库取消
     * 盘点状态 1 未盘点 2：待审核 3：审核中 4：已审核 9：关闭
     */
    public static final int INVENTORY_STATUS_1 = 1;
    /**
     * 清点状态  1 待清点 2 清点完成 9 入库取消
     * 盘点状态 1 未盘点 2：待审核 3：审核中 4：已审核 9：关闭
     */
    public static final int INVENTORY_STATUS_2 = 2;
    /**
     * 清点状态  1 待清点 2 清点完成 9 入库取消
     * 盘点状态 1 未盘点 2：待审核 3：审核中 4：已审核 9：关闭
     */
    public static final int INVENTORY_STATUS_3 = 3;
    /**
     * 清点状态  1 待清点 2 清点完成 9 入库取消
     * 盘点状态 1 未盘点 2：待审核 3：审核中 4：已审核 9：关闭
     */
    public static final int INVENTORY_STATUS_4 = 4;
    /**
     * 清点状态  1 待清点 2 清点完成 9 入库取消
     * 盘点状态 1 未盘点 2：待审核 3：审核中 4：已审核 9：关闭
     */
    public static final int INVENTORY_STATUS_9 = 9;


    /**
     * 入库状态  1 未入库 2 已入库 9 入库取消
     */
    public static final int INBOUND_STATUS_1 = 1;
    /**
     * 入库状态  1 未入库 2 已入库 9 入库取消
     */
    public static final int INBOUND_STATUS_2 = 2;
    /**
     * 入库状态  1 未入库 2 已入库 9 入库取消
     */
    public static final int INBOUND_STATUS_9 = 9;

    /**
     * 出库状态  0 待出库
     */
    public static final int OUT_OF_STOCK_STATUS_0 = 0;
    /**
     * 出库状态   1一次分拣 /销售子订单状态 --待出库
     */
    public static final int OUT_OF_STOCK_STATUS_1 = 1;
    /**
     * 出库状态   2 二次分拣 /销售子订单状态 --出库中
     */
    public static final int OUT_OF_STOCK_STATUS_2 = 2;
    /**
     * 出库状态   3 已出库 /销售子订单状态 --已出库
     */
    public static final int OUT_OF_STOCK_STATUS_3 = 3;
    /**
     * 出库状态    99 取消出库'
     */
    public static final int OUT_OF_STOCK_STATUS_99 = 99;

    /**
     * 出库状态    4 已确认'
     */
    public static final int OUT_OF_STOCK_STATUS_4 = 4;


    /**
     * 是否禁用/是否锁定 状态 2 禁用 1启用 是否关闭 // 库存状态 2 充足 1 不足 //审批结果 2 同意 1驳回  审批方式 2 多人审批 1 单人审批
     */
    public static final int WHETHER_TO_DISABLE_YES = 2;
    /**
     * 是否禁用/是否锁定 状态 2 禁用 1启用  是否关闭 // 库存状态 2 充足 1 不足 //审批结果 2 同意 1驳回  审批方式 2 多人审批 1 单人审批
     */
    public static final int WHETHER_TO_DISABLE_NO = 1;
    /**
     * 是否禁用/是否锁定 状态 2 禁用 1启用  是否关闭 // 库存状态 2 充足 1 不足 //审批结果 2 同意 1驳回  审批方式 2 多人审批 1 单人审批 3办理
     */
    public static final int WHETHER_TO_DISABLE_HANDLE = 3;

    /**
     * 办理人特定节点
     */
    public static final Long HANDLE_NODE = 0L;

    /**
     * 办理人特定节点
     */
    public static final Integer CONDUCT_STATUS_WAIT = 1;
    /**
     * 办理人特定节点
     */
    public static final Integer CONDUCT_STATUS_OK = 2;


    /**
     * 审批结果 1 保存 2 待审批 3 审批中 4已审批 5已撤销 6 待办理 7 办理中 9拒绝
     */
    public static final int APPROVAL_RESULTS_1 = 1;
    public static final int APPROVAL_RESULTS_2 = 2;
    public static final int APPROVAL_RESULTS_3 = 3;
    public static final int APPROVAL_RESULTS_4 = 4;
    public static final int APPROVAL_RESULTS_5 = 5;
    public static final int APPROVAL_RESULTS_6 = 6;
    public static final int APPROVAL_RESULTS_7 = 7;
    public static final int APPROVAL_RESULTS_9 = 9;

    /**
     * 出库类型 1预混料出库
     */
    public static final int STOCK_OUT_BOUND_TYPE_1 = 1;
    /**
     * 出库类型 2 内料出库
     */
    public static final int STOCK_OUT_BOUND_TYPE_2 = 2;
    /**
     * 出库类型 3 半成品出库
     */
    public static final int STOCK_OUT_BOUND_TYPE_3 = 3;
    /**
     * 出库类型 4销售出库
     */
    public static final int STOCK_OUT_BOUND_TYPE_4 = 4;
    /**
     * 出库类型 5 补料出库
     */
    public static final int STOCK_OUT_BOUND_TYPE_5 = 5;
    /**
     * 出库类型 99其他出库库
     */
    public static final int STOCK_OUT_BOUND_TYPE_99 = 99;

    /**
     * 出库类型 6生产出库
     */
    public static final int STOCK_OUT_BOUND_TYPE_6 = 6;


    /**
     * 入库类型 0 采购订单
     */
    public static final int INBOUND_TYPE_0 = 0;
    /**
     * 入库类型 1 备货采购
     */
    public static final int INBOUND_TYPE_1 = 1;
    /**
     * 入库类型 2 返工补料采购
     */
    public static final int INBOUND_TYPE_2 = 2;
    /**
     * 入库类型 3预处理料入库
     */
    public static final int INBOUND_TYPE_3 = 3;
    /**
     * 入库类型 4 内料入库
     */
    public static final int INBOUND_TYPE_4 = 4;
    /**
     * 入库类型 5 半成品入库
     */
    public static final int INBOUND_TYPE_5 = 5;
    /**
     * 入库类型 6 成品入库
     */
    public static final int INBOUND_TYPE_6 = 6;
    /**
     * 入库类型 6 成品入库
     */
    public static final int INBOUND_TYPE_99 = 99;


    /**
     * 附件类型 销售申请
     */
    public static final String FILE_TYPE_APVL_SELL = "apvlSell";
    /**
     * 附件类型 合同申请
     */
    public static final String FILE_TYPE_APVL_CONTRACT_DTL = "apvlContractDtl";
    /**
     * 附件类型 合同申请
     */
    public static final String FILE_TYPE_APVL_CONTRACT = "apvlContract";
    /**
     * 附件类型 合同申请
     */
    public static final String FILE_TYPE_APVL_PD_ORDER_BOM = "apvlPdOrderBom";
    /**
     * 附件类型 报价申请
     */
    public static final String FILE_TYPE_APVL_QUOTE = "apvlQuote";

    /**
     * 附件类型 备货采购
     */
    public static final String FILE_TYPE_APVL_STOCK_PURCHASE = "apvlStockPurchase";

    /**
     * 附件类型 打样申请
     */
    public static final String FILE_TYPE_APVl_FORMULA = "apvlFormula";

    /**
     * 附件类型 返工报废
     */
    public static final String FILE_TYPE_APVL_SUPPLEMENTARIES = "apvlSupplementaries";

    /**
     * 附件类型 评论附件
     */
    public static final String FILE_TYPE_APVL_COMMENT = "apvlComment";

    /**
     * 附件类型 订单采购
     */
    public static final String FILE_TYPE_APVL_ORDER_PURCHASE = "apvlOrderPurchase";

    /**
     * 附件类型 缺陷评审附件
     */
    public static final String FILE_TYPE_APVL_DEFECT_REVIEW = "apvlDefectReview";


    /**
     * 车间生产状态  '状态 1 待排产 2 部分排产 3 全部排产 4 全部完成' 99 关闭,
     */

    public static final int ORDER_SCHEDULE_STATUS_1 = 1;
    public static final int ORDER_SCHEDULE_STATUS_2 = 2;
    public static final int ORDER_SCHEDULE_STATUS_3 = 3;
    public static final int ORDER_SCHEDULE_STATUS_4 = 4;
    public static final int ORDER_SCHEDULE_STATUS_99 = 99;


    /**
     * 提交类型
     */
    public static final int SUBMIT_TYPE_1 = 1;
    public static final int SUBMIT_TYPE_2 = 2;
    public static final int SUBMIT_TYPE_3 = 3;


    /**
     * '订单类型 1：预混料  2：内料 3：半成品 4  成品',
     */
    public static final int PD_ORDER_SCHEDULING_PREMIX = 1;
    public static final int PD_ORDER_SCHEDULING_INTERNAL_CHARGES = 2;
    public static final int PD_ORDER_SCHEDULING_SEMIFINISHED_PRODUCT = 3;
    public static final int PD_ORDER_SCHEDULING_PRODUCT = 4;

    /**
     * 订单审批状态 1 待审核  2 已审核
     */
    public static final int PD_ORDER_CHECK_STATUS_WAIT = 1;

    public static final int PD_ORDER_CHECK_STATUS_AUDITED = 2;

    /**
     * 库存状态 1 不足  2 满足
     */
    public static final int STOCK_MANAGE_STATUS_INSUFFICIENT = 1;

    public static final int STOCK_MANAGE_STATUS_SATISFY = 2;

    /**
     * 采购状态  1 待采购  2 部分采购 3  完全采购
     */
    public static final int PURCHASE_STATUS_1 = 1;

    public static final int PURCHASE_STATUS_2 = 2;
    public static final int PURCHASE_STATUS_3 = 3;

    /**
     * 数据查询常量
     */
    public static final String BASE_BOM = "baseBom";
    public static final String BASE_BOM_DTL = "baseBomDtl";
    public static final String BASE_BOM_PROCESS = "baseBomProcess";
    public static final String BASE_BOM_FEEDING = "baseBomFeeding";
    public static final String BASE_BOM_PROCESS_PARM = "baseBomProcessParm";
    public static final String PURCHASE_NEEDS = "purchaseNeeds";
    public static final String PD_ORDER = "pdOrder";


    /**
     * 物料类型  1原料 2包材 3预处理料 4 内料 5 半成品 6成品 7耗材 99 其他',
     */
    public static final int BASE_ITEM_1 = 1;
    public static final int BASE_ITEM_2 = 2;
    public static final int BASE_ITEM_3 = 3;
    public static final int BASE_ITEM_4 = 4;
    public static final int BASE_ITEM_5 = 5;
    public static final int BASE_ITEM_6 = 6;
    public static final int BASE_ITEM_7 = 7;

    /**
     * 产品类型 1 一品一料 2 一品多料  3 套装
     */
    public static final int BASE_ITEM_PRODUCT_TYPE_1 = 1;
    public static final int BASE_ITEM_PRODUCT_TYPE_2 = 2;
    public static final int BASE_ITEM_PRODUCT_TYPE_3 = 3;

    /**
     * 合同状态 状态 1 未执行 2、执行中 3 部分完成  4完成 9、关闭
     */
    public static final int T_CONTRACT_STATUS_NOT_PERFORMED = 1;
    public static final int T_CONTRACT_STATUS_IN_EXECUTION = 2;
    public static final int T_CONTRACT_STATUS_PARTIALLY_COMPLETED = 3;
    public static final int T_CONTRACT_STATUS_FINISH = 4;
    public static final int T_CONTRACT_STATUS_CLOSURE = 5;

    /**
     * 合同校验类型 状态 1 申请数量 2 排产数量 3 生产数量 4 生产中数量 5出库数量
     */
    public static final int T_CONTRACT_QTY_TYPE_1 = 1;
    public static final int T_CONTRACT_QTY_TYPE_2 = 2;
    public static final int T_CONTRACT_QTY_TYPE_3 = 3;
    public static final int T_CONTRACT_QTY_TYPE_4 = 4;
    public static final int T_CONTRACT_QTY_TYPE_5 = 5;

    /**
     * 合同校验结果  RESULT 结果 COUNT 超出数量
     */
    public static final String RESULT = "result";
    public static final String COUNT = "count";

    /**
     * 批次号类型 1 采购 2 生产
     */
    public static final int BATCH_NO_TYPE_PURCHASE = 1;
    public static final int BATCH_NO_TYPE_PRODUCTION = 2;

    /**
     * 数量转换类型 1 向上转换 2 向下转换
     */
    public static final int QUANTITY_CONVERSION_TYPE_SUPERIOR = 1;
    public static final int QUANTITY_CONVERSION_TYPE_DOWN = 2;

    /**
     * 配置状态 1 删除  2 正常
     */
    public static final int DELETE_STATUS = 1;
    public static final int NORMAL_STATUS = 2;

    /**
     * 字典信息
     */
    public static final String APPLY_FORMULA_FORMULA_METHOD = "05";
    public static final String APPLY_FORMULA_COMMON = "99";
    public static final String APPLY_FORMULA_COLOR = "04";


    /**
     * 办理人提交类型
     * APVL_DEFECT_REVIEW_SAVE 保存
     * APVL_DEFECT_REVIEW_SUBMIT 提交
     */
    public static final Integer APVL_DEFECT_REVIEW_SAVE = 0;
    public static final Integer APVL_DEFECT_REVIEW_SUBMIT = 1;

    /**
     * 合同类型 01 年度合同 02 单一合同  03 订单合同
     */
    public static final String CONTRACT_TYPE_01 = "01";
    public static final String CONTRACT_TYPE_02 = "02";
    public static final String CONTRACT_TYPE_03 = "03";


    /**
     * BigDecimal 判断，小数保留位数
     */
    public static final BigDecimal ONE = BigDecimal.valueOf(1);
    public static final BigDecimal ZERO = BigDecimal.valueOf(0);
    public static final BigDecimal MINUS_ONE = BigDecimal.valueOf(-1);
    public static final int SCALE = 6;

    /**
     * 采购类型  1 订单采购 2 备货采购  3 缺料补料
     */
    public static final String PURCHASE_NEEDS_TYPE_1 = "1";
    public static final String PURCHASE_NEEDS_TYPE_2 = "2";
    public static final String PURCHASE_NEEDS_TYPE_3 = "3";
    /**
     * 生产管理-任务分配-内料生产颜色判断 0 不可生产 1部分满足 2可生产
     */
    public static final int COLER_STATUS_TYPE_0 = 0;
    public static final int COLER_STATUS_TYPE_1 = 1;
    public static final int COLER_STATUS_TYPE_2 = 2;

    /**
     * 生产管理-任务分配-库存状态 1 不满足  2部分满足 3满足
     */
    public static final int STOCK_STATUS_1 = 1;
    public static final int STOCK_STATUS_2 = 2;
    public static final int STOCK_STATUS_3 = 3;
    /**
     * 半成品交付日期减去天数
     */
    public static final int BCP_DATE = 18;


    /**
     * 是否需要学习作业指导书 1 不学习 2 学习
     */
    public static final int IS_LEARN_SOP_NO = 1;
    public static final int IS_LEARN_SOP_TES = 2;

    /**
     * 班组生产详情状态  1 待领料 2 领料中 3 领料完成
     */
    public static final int PICKING_STATE_1 = 1;
    public static final int PICKING_STATE_2 = 2;
    public static final int PICKING_STATE_3 = 3;

    /**
     * 库存是否满足 MANAGE_CHECK_YES  满足  MANAGE_CHECK_NO  不满足
     */
    public static final int MANAGE_CHECK_YES = 1;
    public static final int MANAGE_CHECK_NO = 2;


    /**
     * 销售出库是否校验数量  CHECK_QUANTITY_YES  校验  CHECK_QUANTITY_NO  不校验
     */
    public static final int CHECK_QUANTITY_YES = 1;
    public static final int CHECK_QUANTITY_NO = 2;

    /**任务状态类型 NOR 正常*/
    public static final String ORDER_TYPE_NOR = "NOR";
    /**任务状态类型 RTW 返工*/
    public static final String ORDER_TYPE_RTW = "RTW";


    /** 报产状态 临时保存*/
    public static final int REPORT_N = 1;
    /** 报产状态 报产完成*/
    public static final int REPORT_Y = 2;



    /** 班组任务指导书学习状态 Y已学习  */
    public static final String IS_LEARN_SOP_STS_Y = "Y";
    /** 班组任务指导书学习状态 N未学习*/
    public static final String IS_LEARN_SOP_STS_N = "N";
    /** 班组任务指导书学习状态 S已审核*/
    public static final String IS_LEARN_SOP_STS_S = "S";

}
