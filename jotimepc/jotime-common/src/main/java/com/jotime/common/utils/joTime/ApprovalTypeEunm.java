package com.jotime.common.utils.joTime;

import com.jotime.common.constant.ApvlStatusConstants;

/**
 * @author yunmoqian
 * 审批类型枚举工具类
 */
public enum ApprovalTypeEunm {
    TYPE_EUNM("0", 0), TYPE_打样申请(ApvlStatusConstants.APPLY_FORMULA, 1),
    TYPE_报价申请(ApvlStatusConstants.APPLY_QUOTE, 2),
    TYPE_合同申请(ApvlStatusConstants.APPLY_CONTRACT, 3),
    TYPE_生产申请(ApvlStatusConstants.APPLY_PRODUCT_ORDER, 4),
    TYPE_销售出货申请(ApvlStatusConstants.APPLY_SELL_STOCKOUT, 5),
    TYPE_订单采购申请(ApvlStatusConstants.APPLY_ORDER_PURCHASE, 6),
    TYPE_备货采购申请(ApvlStatusConstants.APPLY_STOCK_PURCHASE, 7),
    TYPE_返工报废申请(ApvlStatusConstants.APPLY_SUPPLEMENTARIES, 8),
    TYPE_缺陷评审(ApvlStatusConstants.APPLY_DEFECT_REVIEW, 9),
    TYPE_审批编号("11", 11),

    TYPE_采购订单("采购订单", 0),
    TYPE_备货采购("备货采购", 1),
    TYPE_返工补料采购("返工补料采购", 2),
    TYPE_预处理料入库("预处理料入库", 3),
    TYPE_内料入库("内料入库", 4),
    TYPE_半成品入库("半成品入库", 5),
    TYPE_成品入库("成品入库", 6),
    TYPE_其他入库("其他入库", 99),
    TYPE_null("404", 404);


    private String type;
    private int code;

    ApprovalTypeEunm(String type, int code) {
        this.type = type;
        this.code = code;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 匹配类型
     *
     * @param type 申请类型
     * @return 状态码
     */
    public static ApprovalTypeEunm matchOpType(String type) {
        for (ApprovalTypeEunm opCode : ApprovalTypeEunm.values()) {
            if (opCode.type.equals(type)) {
                return opCode;
            }
        }
        return ApprovalTypeEunm.TYPE_null;
    }

    /**
     * 匹配类型
     *
     * @param code value
     * @return 状态码
     */
    public static ApprovalTypeEunm matchOpCode(int code) {
        for (ApprovalTypeEunm opCode : ApprovalTypeEunm.values()) {
            if (opCode.code == code) {
                return opCode;
            }
        }
        return ApprovalTypeEunm.TYPE_null;
    }
}
