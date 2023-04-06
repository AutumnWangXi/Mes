package com.jotime.web.domainVo.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 生产订单共通信息实体类
 *
 * @author ruoyi
 * @date 2022-03-02
 */
public class PdOrderCommonInfoVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 生产订单编号
     */
    @Excel(name = "生产订单编号")
    private String orderNo;

    /**
     * 订单类型 1：预混料  2：内料 3：半成品 4  成品
     */
    @Excel(name = "订单类型 1：预混料  2：内料 3：半成品 4  成品")
    private Integer orderType;

    /**
     * 客户内码
     */
    @Excel(name = "客户内码")
    private String customerId;

    /**
     * 客户编号
     */
    @TableField(exist = false)
    private String customerCode;
    /**
     * 客户名称
     */
    @TableField(exist = false)
    private String customerName;

    /**
     * 合同订单编号
     */
    @Excel(name = "合同订单编号")
    private String contractorderNo;

    /**
     * 合同签订日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date contractDate;


    /**
     * 订单交付日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String deliveryDate;

    /**
     * 产品内码
     */
    private Long itemId;

    /**
     * 产品内码
     */
    private String itemCode;

    /**
     * 产品内码
     */
    private String itemName;

    /**
     * 产品内码
     */
    private Integer itemType;

    /**
     * 单位
     */
    private String unit;
    /**
     * 规格
     */
    private String specifications;

    /**
     * 产品类型 1 一品一料 2 一品多料  3 套装
     */
    private Integer productType;

    /**
     * 订单生产数量
     */
    private BigDecimal orderPdQty;

    /**
     * bom编号
     */
    private String bomNo;

    /**
     * 版本号
     */
    private String version;

    /**
     * bom编号信息
     */
    List<VersionVo> bomNos;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public PdOrderCommonInfoVo() {
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setContractorderNo(String contractorderNo) {
        this.contractorderNo = contractorderNo;
    }

    public String getContractorderNo() {
        return contractorderNo;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public Date getContractDate() {
        return contractDate;
    }


    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setOrderPdQty(BigDecimal orderPdQty) {
        this.orderPdQty = orderPdQty;
    }

    public BigDecimal getOrderPdQty() {
        return orderPdQty;
    }

    public void setBomNo(String bomNo) {
        this.bomNo = bomNo;
    }

    public String getBomNo() {
        return bomNo;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<VersionVo> getBomNos() {
        return bomNos;
    }

    public void setBomNos(List<VersionVo> bomNos) {
        this.bomNos = bomNos;
    }
}
