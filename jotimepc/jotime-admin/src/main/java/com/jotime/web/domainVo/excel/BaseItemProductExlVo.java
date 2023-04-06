package com.jotime.web.domainVo.excel;

import com.jotime.common.annotation.Excel;
import com.jotime.common.constant.ItemConstants;
import com.jotime.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * @Description: 表格导入，成品对象
 * @Author: YunFei
 * @Date: 2022/4/15 15:08
 */
public class BaseItemProductExlVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 物料id
     */
    private Long id;

    /**
     * 物料代码
     */
    @Excel(name = "成品编码")
    private String itemCode;

    @Excel(name = "配方编码")
    private String bomNo;
    /**
     * 物料名称
     */
    @Excel(name = "成品名称")
    private String itemName;
    /**
     * 品牌
     */
    @Excel(name = "品牌")
    private String brand;

    /**
     * 客户ID
     */
    @Excel(name = "客户编码")
    private String customerCode;


    /**
     * 类别
     */
    @Excel(name = "类别",dictType = ItemConstants.SYS_PRODUCT_USE_METHODS)
    private String productUseMethods;
    /**
     * 规格
     */
    @Excel(name = "规格")
    private String specifications;

    /**
     * 类别
     */
    @Excel(name = "品类",dictType = ItemConstants.SYS_PRODUCT_CATEGORY)
    private String categoryType;



    /**
     * 单价
     */
//    @Excel(name = "单价")
    private BigDecimal price;
    /**
     * 单位
     */
    @Excel(name = "单位")
    private String unit;

    /** 净含量 */
//    @Excel(name = "净含量")
    private Long netContent;

    /**
     * 毛重
     */
//    @Excel(name = "毛重")
    private BigDecimal tareWeight;

    /**
     * 皮重
     */
//    @Excel(name = "皮重")
    private BigDecimal grossWeight;

    /**
     * 净重
     */
    @Excel(name = "净含重")
    private BigDecimal netWeight;

    /**
     * 条形码
     */
    @Excel(name = "条形码")
    private String barCode;


    /**
     * 产品类型 1 一品一料 2 一品多料  3 套装
     */
    @Excel(name = "产品类型 1 一品一料 2 一品多料  3 套装",width = 40)
    private Integer productType;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 内包装图 */
//    @Excel(name = "内包装图")
    private String innerImageUrl;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBomNo() {
        return bomNo;
    }

    public void setBomNo(String bomNo) {
        this.bomNo = bomNo;
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

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
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

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
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

    public BigDecimal getTareWeight() {
        return tareWeight;
    }

    public void setTareWeight(BigDecimal tareWeight) {
        this.tareWeight = tareWeight;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Long getNetContent() {
        return netContent;
    }

    public void setNetContent(Long netContent) {
        this.netContent = netContent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInnerImageUrl() {
        return innerImageUrl;
    }

    public void setInnerImageUrl(String innerImageUrl) {
        this.innerImageUrl = innerImageUrl;
    }

    public String getProductUseMethods() {
        return productUseMethods;
    }

    public void setProductUseMethods(String productUseMethods) {
        this.productUseMethods = productUseMethods;
    }
}
