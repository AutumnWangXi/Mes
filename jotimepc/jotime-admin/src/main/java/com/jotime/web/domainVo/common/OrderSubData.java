package com.jotime.web.domainVo.common;

/**
 * 接收参数子级数据
 */
public class OrderSubData {

    /**
     * 物料编号----根据物料选择的时候回传此字段
     */
    private Long itemId;


    /**
     * 物料编号 -- 根据客户选择时请回传此字段
     */
    private String itemCode;

    /**
     * 客户内码  ---- 根据客户选择时请回传此字段
     */
    private Long customerId;

    /**
     * 根据产品采购时请回传此字段
     */
    private Long needId;


    /**
     * 生产订单编号 -- 根据生产订单选择时请回传此字段
     */
    private String orderNo;


    public Long getNeedId() {
        return needId;
    }

    public void setNeedId(Long needId) {
        this.needId = needId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
