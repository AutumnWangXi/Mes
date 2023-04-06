package com.jotime.web.domainVo.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 包材基础对象 base_packaging
 *
 * @author ruoyi
 * @date 2021-07-08
 */
public class BasePackagingVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 包材id
     */
    private String packagingId;

    /**
     * 包材现有名称
     */
    @Excel(name = "包材现有名称")
    private String packagingName;

    /**
     * 包材名称
     */
    @Excel(name = "包材名称")
    private String name;

    /**
     * 单位
     */
    @Excel(name = "单位")
    private String unit;

    /**
     * 规格
     */
    @Excel(name = "规格")
    private String specifications;


    /**
     * 包材属性
     */
    @Excel(name = "包材属性")
    private String packagingType;

    /**
     * 客户名称
     */
    @Excel(name = "客户名称")
    private String customerId;

    /**
     * 订单编号
     */
    @Excel(name = "订单编号")
    private String orderId;

    /**
     * 产品名称
     */
    @Excel(name = "产品名称")
    private String productsName;

    /**
     * 供应商
     */
    @Excel(name = "供应商")
    private String supplierName;

    /**
     * 生产商
     */
    @Excel(name = "生产商")
    private String manufacturerName;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String content;

    /**
     * 品牌
     */
    @Excel(name = "品牌")
    private String brand;

    /**
     * 预警设置
     */
    @Excel(name = "预警设置")
    private String warnSet;

    /**
     * 价格
     */
    @Excel(name = "价格")
    private BigDecimal price;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private String status;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /**
     * 创建者
     */
    @Excel(name = "创建者")
    private String creator;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date gmtModified;

    /**
     * 更新者
     */
    @Excel(name = "更新者")
    private String modifiedUser;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setPackagingId(String packagingId) {
        this.packagingId = packagingId;
    }

    public String getPackagingId() {
        return packagingId;
    }

    public void setPackagingName(String packagingName) {
        this.packagingName = packagingName;
    }

    public String getPackagingName() {
        return packagingName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPackagingType(String packagingType) {
        this.packagingType = packagingType;
    }

    public String getPackagingType() {
        return packagingType;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }

    public String getProductsName() {
        return productsName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setWarnSet(String warnSet) {
        this.warnSet = warnSet;
    }

    public String getWarnSet() {
        return warnSet;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreator() {
        return creator;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("packagingId", getPackagingId())
                .append("packagingName", getPackagingName())
                .append("name", getName())
                .append("packagingType", getPackagingType())
                .append("customerId", getCustomerId())
                .append("unit", getUnit())
                .append("specifications", getSpecifications())
                .append("orderId", getOrderId())
                .append("productsName", getProductsName())
                .append("supplierName", getSupplierName())
                .append("manufacturerName", getManufacturerName())
                .append("content", getContent())
                .append("brand", getBrand())
                .append("warnSet", getWarnSet())
                .append("price", getPrice())
                .append("status", getStatus())
                .append("createDate", getCreateDate())
                .append("creator", getCreator())
                .append("gmtModified", getGmtModified())
                .append("modifiedUser", getModifiedUser())
                .toString();
    }
}
