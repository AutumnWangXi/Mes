package com.jotime.web.domainVo.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * @Classname VItemVo
 * @Description
 * @Date 2022/7/27 18:30
 * @Created by 14812
 */
public class VItemVo extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @TableField(exist = false)
    private Long itemId;

    /**
     * 物料代码
     */
    @Excel(name = "物料代码")
    private String itemCode;

    @Excel(name = "物料名称")
    private String itemName;

    @Excel(name = "物料类型 1原料 2包材 3预处理料 4 内料 5 半成品 6成品5")
    private Integer itemType;


    /**
     * 产品类型 1 一品一料 2 一品多料  3 套装
     */
    @Excel(name = "产品类型 1 一品一料 2 一品多料  3 套装")
    private Integer productType;

    @Excel(name = "单位")
    private String unit;
    /**
     * 仓库库存单位
     */
    @Excel(name = "仓库库存单位")
    private String whStockUnit;

    @Excel(name = "条形码")
    private String barCode;

    @Excel(name = "物料编号")
    private String itemNo;

    @Excel(name = "库存转换")
    private BigDecimal discount;

    @Excel(name = "制造厂商ID")
    private Long manufacturerId;

    @Excel(name = "供应商ID")
    private Long supplierId;

    /**
     * 是否需要质检 1 不需要  2 需要
     */
    @Excel(name = "是否需要质检 1 不需要  2 需要")
    private Integer needQuality;

    /**
     * 是否需要扫码出库 1 不需要  2 需要
     */
    @Excel(name = "是否需要扫码出库 1 不需要  2 需要")
    private Integer needBarcodeStockout;

    /**
     * 是否需要称重 1 不需要  2 需要
     */
    @Excel(name = "是否需要称重 1 不需要  2 需要")
    private Integer needWeigh;

    /**
     * 是否保密 1 不需要  2 需要
     */
    @Excel(name = "是否保密 1 不需要  2 需要")
    private Integer needConfidential;

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getWhStockUnit() {
        return whStockUnit;
    }

    public void setWhStockUnit(String whStockUnit) {
        this.whStockUnit = whStockUnit;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public Integer getNeedQuality() {
        return needQuality;
    }

    public void setNeedQuality(Integer needQuality) {
        this.needQuality = needQuality;
    }

    public Integer getNeedBarcodeStockout() {
        return needBarcodeStockout;
    }

    public void setNeedBarcodeStockout(Integer needBarcodeStockout) {
        this.needBarcodeStockout = needBarcodeStockout;
    }

    public Integer getNeedWeigh() {
        return needWeigh;
    }

    public void setNeedWeigh(Integer needWeigh) {
        this.needWeigh = needWeigh;
    }

    @Override
    public Integer getNeedConfidential() {
        return needConfidential;
    }

    @Override
    public void setNeedConfidential(Integer needConfidential) {
        this.needConfidential = needConfidential;
    }

    @Override
    public String toString() {
        return "VItem{" +
                "itemId=" + itemId +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemType=" + itemType +
                ", productType=" + productType +
                ", unit='" + unit + '\'' +
                ", whStockUnit='" + whStockUnit + '\'' +
                ", barCode='" + barCode + '\'' +
                ", itemNo='" + itemNo + '\'' +
                '}';
    }

}
