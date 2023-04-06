package com.jotime.web.domainVo.excel;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * @Description: 包材表格对象
 * @Author: YunFei
 * @Date: 2022/4/14 18:30
 */
public class BaseItemPackageExlVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 物料id
     */
    private Long id;

    /**
     * 物料代码
     */
    @Excel(name = "包材编码")
    private String itemCode;

//    /**
//     * 物料编号
//     */
//    @Excel(name = "物料编号")
//    private String itemNo;
    /**
     * 物料简称
     */
    @Excel(name = "现有名称")
    private String itemShortName;

    /**
     * 物料名称
     */
    @Excel(name = "包材名称")
    private String itemName;

    /**
     * 类别
     */
    @Excel(name = "包材类别")
    private String categoryType;

    /**
     * 客户物料编码
     */
    @Excel(name = "客户包材编码")
    private String customerItemCode;
    /**
     * 品牌
     */
    @Excel(name = "品牌")
    private String brand;

    /**
     * 单价
     */
    @Excel(name = "单价")
    private BigDecimal price;
    /**
     * 单位
     */
    @Excel(name = "单位")
    private String unit;


    /**
     * 属性
     */
    @Excel(name = "属性")
    private String property;

    /**
     * 客户IjD
     */
    @Excel(name = "客户名称")
    private String customerName;

    /**
     * 供应商名称
     */
    @Excel(name = "供应商名称")
    private String supplierName;

//    /**
//     * 是否质检
//     */
//
//    @Excel(name = "是否质检(1：不需要，2：需要)")
//    private Integer needQuality;
//    /**
//     * 是否称重
//     */
//    @Excel(name = "是否称重(1：不需要，2：需要)，默认不需要")
//    private Integer needWeigh;
    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }


    public String getItemShortName() {
        return itemShortName;
    }

    public void setItemShortName(String itemShortName) {
        this.itemShortName = itemShortName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getCustomerItemCode() {
        return customerItemCode;
    }

    public void setCustomerItemCode(String customerItemCode) {
        this.customerItemCode = customerItemCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
