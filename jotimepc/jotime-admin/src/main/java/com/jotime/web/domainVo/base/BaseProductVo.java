package com.jotime.web.domainVo.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品基础对象 base_product
 *
 * @author ruoyi
 * @date 2021-07-08
 */
public class BaseProductVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 产品id
     */
    @Excel(name = "产品id")
    private String productId;

    /**
     * 产品名称
     */
    @Excel(name = "产品名称")
    private String productName;

    /**
     * 产品类型
     */
    @Excel(name = "产品类型")
    private String productType;

    /**
     * 产品规格
     */
    @Excel(name = "产品规格")
    private String specification;

    /**
     * 包装规格
     */
    @Excel(name = "包装规格")
    private String packSpecifications;

    /**
     * 出售的单位（一盒，一支。。。）
     */
    @Excel(name = "出售的单位", readConverterExp = "一=盒，一支。。。")
    private String sellUnit;

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
     * 条形码
     */
    @Excel(name = " 条形码")
    private String barcode;

    /**
     * 创建人名称
     */
    @Excel(name = "创建人名称")
    private String creator;

    /**
     * 创建者id
     */
    @Excel(name = "创建者id")
    private String creatorId;

    //客户名称
    private String customerName;
    //内料Bom
    private String innerMaterialBom;
    //成品Bom
    private String finishedProductBom;

    /**
     * 数据写入时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "数据写入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatDate;

    /**
     * 更新者
     */
    @Excel(name = "更新者")
    private String modifiedUser;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date gmtModified;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductType() {
        return productType;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getSpecification() {
        return specification;
    }

    public String getInnerMaterialBom() {
        return innerMaterialBom;
    }

    public void setInnerMaterialBom(String innerMaterialBom) {
        this.innerMaterialBom = innerMaterialBom;
    }

    public String getFinishedProductBom() {
        return finishedProductBom;
    }

    public void setFinishedProductBom(String finishedProductBom) {
        this.finishedProductBom = finishedProductBom;
    }

    public void setPackSpecifications(String packSpecifications) {
        this.packSpecifications = packSpecifications;
    }

    public String getPackSpecifications() {
        return packSpecifications;
    }

    public void setSellUnit(String sellUnit) {
        this.sellUnit = sellUnit;
    }

    public String getSellUnit() {
        return sellUnit;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("productId", getProductId())
                .append("productName", getProductName())
                .append("productType", getProductType())
                .append("specification", getSpecification())
                .append("packSpecifications", getPackSpecifications())
                .append("sellUnit", getSellUnit())
                .append("brand", getBrand())
                .append("price", getPrice())
                .append("barcode", getBarcode())
                .append("creator", getCreator())
                .append("creatorId", getCreatorId())
                .append("creatDate", getCreatDate())
                .append("modifiedUser", getModifiedUser())
                .append("gmtModified", getGmtModified())
                .toString();
    }
}
