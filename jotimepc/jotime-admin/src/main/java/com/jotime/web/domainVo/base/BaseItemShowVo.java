package com.jotime.web.domainVo.base;

import com.jotime.common.annotation.Excel;

import java.math.BigDecimal;

/**
 * @Classname BaseItemShowVo
 * @Description
 * @Date 2022/5/16 17:22
 * @Created by 14812
 */
public class BaseItemShowVo {
    /**
     * 物料id
     */
    private Long id;

    /**
     * 仓库库存单位
     */
    @Excel(name = "仓库库存单位")
    private String whStockUnit;

    /** 毛重 */
    @Excel(name = "毛重")
    private BigDecimal tareWeight;

    /** 皮重 */
    @Excel(name = "皮重")
    private BigDecimal grossWeight;

    /** 内料配方编号 */
    @Excel(name = "内料配方编号")
    private String bomNo;


    /** 净含量 */
    @Excel(name = "净含量")
    private BigDecimal netContent;

    /** 密度(g/cm³) */
    @Excel(name = "密度(g/cm³)")
    private BigDecimal density;

    /**
     * 转换比例(物料->库存)
     */
    @Excel(name = "转换比例(物料->库存)")
    private BigDecimal discount;

    /** 套内物料内码 */
    @Excel(name = "套内物料内码")
    private Long innerItemId;

    /** 版本号 */
    @Excel(name = "版本号")
    private String version;

    /** 净量 */
    @Excel(name = "净量")
    private BigDecimal netWeight ;

    /** 产品数量 */
    @Excel(name = "产品数量")
    private BigDecimal productQty;

    public Long getInnerItemId() {
        return innerItemId;
    }

    public void setInnerItemId(Long innerItemId) {
        this.innerItemId = innerItemId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public BigDecimal getProductQty() {
        return productQty;
    }

    public void setProductQty(BigDecimal productQty) {
        this.productQty = productQty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBomNo() {
        return bomNo;
    }

    public void setBomNo(String bomNo) {
        this.bomNo = bomNo;
    }

    public String getWhStockUnit() {
        return whStockUnit;
    }

    public void setWhStockUnit(String whStockUnit) {
        this.whStockUnit = whStockUnit;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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

    public BigDecimal getNetContent() {
        return netContent;
    }

    public void setNetContent(BigDecimal netContent) {
        this.netContent = netContent;
    }

    public BigDecimal getDensity() {
        return density;
    }

    public void setDensity(BigDecimal density) {
        this.density = density;
    }
}
