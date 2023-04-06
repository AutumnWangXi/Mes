package com.jotime.web.domainVo.common;


import com.jotime.common.core.domain.BaseEntity;

/**
 * @author chenkuo
 * 出库指示子类Vo
 */
public class OutboundVo extends BaseEntity {


    /**
     * 子订单内码
     */
    private Long subOrderId;

    /**
     * 查询编号
     */
    private String orderNo;

    /**
     * 物料内码
     */
    private Long itemId;

    /**
     * 品质
     */
    private String keepType;

    /**
     * 状态
     */
    private Integer status;
    /**
     * 物料序号
     */
    private Integer itemSort;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getSubOrderId() {
        return subOrderId;
    }

    public void setSubOrderId(Long subOrderId) {
        this.subOrderId = subOrderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getKeepType() {
        return keepType;
    }

    public void setKeepType(String keepType) {
        this.keepType = keepType;
    }

    public Integer getItemSort() {
        return itemSort;
    }

    public void setItemSort(Integer itemSort) {
        this.itemSort = itemSort;
    }
}
