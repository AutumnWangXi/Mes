package com.jotime.common.constant;

/**
 * 编码规则常量
 *
 * @author zhangjun
 */
public class CodeRuleConstants {
    /**
     * 常量
     */
    public static final String CONST = "const";

    /**
     * 计数
     */
    public static final String NUMBERING = "numbering";

    /**
     * 时间戳
     */
    public static final String TIMESTAMP = "timestamp";

    /**
     * 参数
     */
    public static final String PARAM = "param";

    /**
     * SQL
     */
    public static final String SQL = "sql";

    /**
     * 自定义文件
     */
    public static final String CLASS = "class";

    /**
     * 左补
     */
    public static final String LEFT = "left";

    /**
     * 右补
     */
    public static final String RIGHT = "right";

    /**
     * 默认补位字符
     */
    public static final String DEFAULT_PADDING_CHAR = "0";

    /**
     * 成功
     */
    public static final String SUCCESS = "success";

    /**
     * 失败
     */
    public static final String FAIL = "fail";

    /**
     * 操作状态 1 禁用 2 正常
     */
    public static final int STATUS_DISABLED = 1;
    public static final int STATUS_OK = 2;




    /**
     * 编码规则编号
     */
    /**
     * RULE_MFRS_CD		生产商
     * RULE_SUPPLIER_CD	供应商
     * RULE_PACKAGE_SUPPLIER_CD	包材供应商
     * RULE_MATERIAL_CD		原料编码
     * RULE_PACKAGE_CD		包材编码
     * RULE_PACKAGE_CATEGORY_CD	包材类别码
     * RULE_PREMIX_COMPOUND_CD		预混料编码
     * RULE_INNERMATERIAL_CD		内料编码
     * RULE_INNERMAT_CATEGORY_CD	内料类别码
     * RULE_SEMIFIN_CD			半成品编码
     * RULE_PRODUCT_CD			成品编码
     * RULE_PRODUCT_CATEGORY_CD	成品类别码
     * RULE_EMPLOYEE_CD		人员编码
     * RULE_AUXILIARY_CD		辅料编码
     * RULE_CUSTOMER_CD		客户编码
     * RULE_CONSUMABLE_CD   耗材编码
     * RULE_DEPT_FORMULA_CD 部门打样任务单
     * RULE_STOCK_PURCHASE_CD 备货采购
     * RULE_APVL_SUPPLEMENTARIES_CD 返工报废
     * RULE_TURNOVER_BOX_CD 周转箱编码
     */
    public static final String RULE_MFRS_CD = "rule_mfrs_cd";
    public static final String RULE_SUPPLIER_CD = "rule_supplier_cd";
    public static final String RULE_PACKAGE_SUPPLIER_CD = "rule_package_supplier_cd";
    public static final String RULE_MATERIAL_CD = "rule_material_cd";
    public static final String RULE_PACKAGE_CD = "rule_package_cd";
    public static final String RULE_PACKAGE_CATEGORY_CD = "rule_package_category_cd";
    public static final String RULE_PREMIX_COMPOUND_CD = "rule_premix_compound_cd";
    public static final String RULE_INNERMATERIAL_CD = "rule_innermaterial_cd";
    public static final String RULE_INNERMAT_CATEGORY_CD = "rule_innermat_category_cd";
    public static final String RULE_SEMIFIN_CD = "rule_semifin_cd";
    public static final String RULE_PRODUCT_CD = "rule_product_cd";
    public static final String RULE_PRODUCT_CATEGORY_CD = "rule_product_category_cd";
    public static final String RULE_EMPLOYEE_CD = "rule_employee_cd";
    public static final String RULE_AUXILIARY_CD = "rule_auxiliary_cd";
    public static final String RULE_CUSTOMER_CD = "rule_customer_cd";
    public static final String RULE_CONSUMABLE_MATERIAL_CD = "rule_consumes_material_cd";
    public static final String RULE_DEPT_FORMULA_CD = "rule_dept_formula_cd";
    public static final String RULE_STOCK_PURCHASE_CD = "rule_stock_purchase_cd";
    public static final String RULE_APVL_SUPPLEMENTARIES_CD = "rule_apvl_supplementaries_cd";
    public static final String RULE_TX_MATERIAL_CD = "rule_tx_material_cd";
    public static final String RULE_TURNOVER_BOX_CD = "rule_turnover_box_cd";


    /**
     * RULE_APVL_CD 审批编号
     */
    public static final String RULE_APVL_CD = "rule_apvl_cd";

    /**
     * RULE_FORMULA_CD 打样任务单号
     */
    public static final String RULE_FORMULA_CD = "rule_formula_cd";
    /**
     * RULE_STOCKIN_NOTICE_CD 入库通知单编号
     */
    public static final String RULE_STOCKIN_NOTICE_CD = "rule_stockin_notice_cd";
    /**
     * RULE_STOCKOUT_NOTICE_CD 出库通知单编号（领料单编号）不合并
     */
    public static final String RULE_STOCKOUT_NOTICE_CD = "rule_stockout_notice_cd";
    /**
     * RULE_MSTOCKOUT_NOTICE_CD 出库通知单编号（领料单编号）合并
     */
    public static final String RULE_MSTOCKOUT_NOTICE_CD = "rule_mstockout_notice_cd";

    /**
     * RULE_QC_TASK_CD 质检任务编号
     */
    public static final String RULE_QC_TASK_CD = "rule_qc_task_cd";

    /**
     * RULE_IPQC_TASK_CD 巡检任务编号
     */
    public static final String RULE_IPQC_TASK_CD = "rule_ipqc_task_cd";


    /**
     * RULE_PURCHASE_CD 采购单编号
     */
    public static final String RULE_PURCHASE_CD = "rule_purchase_cd";
    /**
     * RULE_SELL_CD 销售单号
     */
    public static final String RULE_SELL_CD = "rule_sell_cd";

    /**
     * RULE_SUB_SELL_CD 销售子单号
     */
    public static final String RULE_SUB_SELL_CD = "rule_sub_sell_cd";
    /**
     * RULE_INVENTORY_CD 盘点指示单号
     */
    public static final String RULE_INVENTORY_CD = "rule_inventory_cd";
    /**
     * RULE_SUPPLEMENTARIES_CD 缺料补料编号
     */
    public static final String RULE_SUPPLEMENTARIES_CD= "rule_supplementaries_cd";
    /**
     * RULE_TEMPLATESDTL_CD（质检任务编号）
     */
    public static final String RULE_TEMPLATESDTL_CD= "rule_templatesdtl_cd";

    public static final  String RULE_IPQC_TEST_CD = "rule_ipqc_test_cd";

    /**
     * RULE_DEVICE_CD（设备编号）
     */
    public static final String RULE_DEVICE_CD= "rule_device_cd";

    /**
     * RULE_PD_WHSKORDERTASK_CD（车间生产任务编号）
     */
    public static final String RULE_PD_WHSKORDERTASK_CD= "rule_pd_whskordertask_cd";
    /**
     * RULE_PD_REPORT_CD（报产编号）
     */
    public static final String RULE_PD_REPORT_CD= "rule_pd_report_cd";
    /**
     * RULE_PD_ORDER_CD（生产订单编号）
     */
    public static final String RULE_PD_ORDER_CD= "rule_pd_order_cd";
    /**
     * RULE_PD_ORDER_TASK_CD（生产任务编号）
     */
    public static final String RULE_PD_ORDER_TASK_CD= "rule_pd_order_task_cd";/**
     * RULE_PD_GROUP_CD（班组生产任务编号）
     */
    public static final String RULE_PD_GROUP_CD= "rule_pd_group_cd";

    /**
     * rule_product_bom_cd（成品bom编号）
     */
    public static final String RULE_PRODUCT_BOM_CD= "rule_product_bom_cd";

    /**
     * rule_innermat_bom_cd（内料bom编号）
     */
    public static final String RULE_INNERMAT_BOM_CD= "rule_innermat_bom_cd";
    /**
     * RULE_CONTRACT_NO_CD（合同订单编号）
     */
    public static final String RULE_CONTRACT_NO_CD= "rule_contract_no_cd";
    /**
     * rule_purchase_batch_cd  采购批次号的
     */
    public static final String RULE_PURCHASE_BATCH_CD = "rule_purchase_batch_cd";
    /**
    * 生产批次号 RULE_PD_BATCH_CD
    */
    public static final String RULE_PD_BATCH_CD = "rule_pd_batch_cd";
    /**
    * 排产批次号 RULE_PC_BATCH_CD
    */
    public static final String RULE_PC_BATCH_CD = "rule_pc_batch_cd";
    /**
     * 个人打样编号 RULE_EEFORMULA_CD
     */
    public static final String RULE_EEFORMULA_CD = "rule_eeformula_cd";
    /**
     * 其他入库 RULE_OTHER_STOCKIN_CD
     */
    public static final String RULE_OTHER_STOCKIN_CD = "rule_other_stockin_cd";
    /**
     * 其他出库 RULE_OTHER_STOCKOUT_CD
     */
    public static final String RULE_OTHER_STOCKOUT_CD = "rule_other_stockout_cd";


}
