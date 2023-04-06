package com.jotime.common.utils.joTime;

/**
 * @author yunmoqian
 * 出库类型枚举工具类
 */
public enum OutboundTypeEunm {
    /**
     * 销售出库
     */
    TYPE_APVL_SELL("apvl_sell", 4),
    /**
     * 缺料补料出库
     */
    TYPE_SUPPLEMENTARIES("supplementaries", 5),
    /**
     * 预混料入库
     */
    TYPE_预处理料出库("预混料入库", 1),
    /**
     * 内料出库
     */
    TYPE_内料出库("内料入库", 2),
    /**
     * 半成品出库
     */
    TYPE_半成品出库("半成品入库", 3),

    /**
     * 生产
     */
    TYPE_PRODUCTION("production", 6),

    /**
     * 其他出库
     */
    TYPE_OTHER_ORDER("other_order", 99),
    TYPE_null("404", 404);


    private String type;
    private int code;

    OutboundTypeEunm(String type, int code) {
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
    public static OutboundTypeEunm matchOpType(String type) {
        for (OutboundTypeEunm opCode : OutboundTypeEunm.values()) {
            if (opCode.type.equals(type)) {
                return opCode;
            }
        }
        return OutboundTypeEunm.TYPE_null;
    }

    /**
     * 匹配类型
     *
     * @param code value
     * @return 状态码
     */
    public static OutboundTypeEunm matchOpCode(int code) {
        for (OutboundTypeEunm opCode : OutboundTypeEunm.values()) {
            if (opCode.code == code) {
                return opCode;
            }
        }
        return OutboundTypeEunm.TYPE_null;
    }
}
