package com.jotime.common.utils.joTime;

/**
 * @author yunmoqian
 * 订单采购确认选择枚举工具类
 */
public enum PurchaseOrderTypeEunm {
    /**
     * 根据生产订单
     */
    DATA_TYPE_PD_ORDER("data_type_pd_order", 1),
    /**
     * 根据物料
     */
    DATA_TYPE_ITEM("data_type_item", 2),
    /**
     * 根据客户
     */
    DATA_TYPE_CUSTOMER("data_type_customer", 3),
    /**
     * 根据产品
     */
    DATA_TYPE_PRODUCT("data_type_product", 4),

    TYPE_null("404", 404);


    private String type;
    private int code;

    PurchaseOrderTypeEunm(String type, int code) {
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
    public static PurchaseOrderTypeEunm matchOpType(String type) {
        for (PurchaseOrderTypeEunm opCode : PurchaseOrderTypeEunm.values()) {
            if (opCode.type.equals(type)) {
                return opCode;
            }
        }
        return PurchaseOrderTypeEunm.TYPE_null;
    }

    /**
     * 匹配类型
     *
     * @param code value
     * @return 状态码
     */
    public static PurchaseOrderTypeEunm matchOpCode(int code) {
        for (PurchaseOrderTypeEunm opCode : PurchaseOrderTypeEunm.values()) {
            if (opCode.code == code) {
                return opCode;
            }
        }
        return PurchaseOrderTypeEunm.TYPE_null;
    }
}
