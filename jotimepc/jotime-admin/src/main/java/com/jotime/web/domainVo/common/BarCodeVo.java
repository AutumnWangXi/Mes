package com.jotime.web.domainVo.common;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 条形码查询Vo
 * @author chenkuo
 */
public class BarCodeVo {
    /**
     * 销售单号
     */
    private String orderNo;

    /**
     * 查询类型
     */
    @NotNull(message = "查询类型不可为空!")
    private Integer type;

    /**
     * 条形码
     */
    private String barCode;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}
