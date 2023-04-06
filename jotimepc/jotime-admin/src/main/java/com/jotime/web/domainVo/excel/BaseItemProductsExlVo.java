package com.jotime.web.domainVo.excel;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * @Description: 表格导入，半成品对象
 * @Author: YunFei
 * @Date: 2022/4/15 16:46
 */
public class BaseItemProductsExlVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 物料id
     */
    private Long id;

    /**
     * 物料代码
     */
    @Excel(name = "半成品编码")
    private String itemCode;


    /**
     * 物料名称
     */
    @Excel(name = "半成品名称")
    private String itemName;
    /**
     * 客户ID
     */
//    @Excel(name = "客户编码")
    private String customerCode;

    /**
     * 规格
     */
    @Excel(name = "规格")
    private String specifications;

    /**
     * 色号
     */
    @Excel(name = "色号")
    private String colourNumber;
    /**
     * 美观线净含量
     */
    @Excel(name = "美观线净含量")
    private String lineNetWeight;

    /**
     * 标识净含量
     */
    @Excel(name = "标识净含量")
    private String identificationNetWeight;

    /**
     * 灌装量上限
     */
    @Excel(name = "灌装量上限")
    private String fillingVolumeUpper;

    /**
     * 灌装量下限
     */
    @Excel(name = "灌装量下限")
    private String fillingVolumeLower;

    /**
     * 灌装量单位
     */
    @Excel(name = "灌装量单位")
    private String fillingUnit;
    /**
     * 密度
     */
    @Excel(name = "密度")
    private BigDecimal density;


    /**
     * 条形码
     */
    @Excel(name = "条形码")
    private String barCode;

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

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getColourNumber() {
        return colourNumber;
    }

    public void setColourNumber(String colourNumber) {
        this.colourNumber = colourNumber;
    }

    public String getLineNetWeight() {
        return lineNetWeight;
    }

    public void setLineNetWeight(String lineNetWeight) {
        this.lineNetWeight = lineNetWeight;
    }

    public String getIdentificationNetWeight() {
        return identificationNetWeight;
    }

    public void setIdentificationNetWeight(String identificationNetWeight) {
        this.identificationNetWeight = identificationNetWeight;
    }

    public String getFillingVolumeUpper() {
        return fillingVolumeUpper;
    }

    public void setFillingVolumeUpper(String fillingVolumeUpper) {
        this.fillingVolumeUpper = fillingVolumeUpper;
    }

    public String getFillingVolumeLower() {
        return fillingVolumeLower;
    }

    public void setFillingVolumeLower(String fillingVolumeLower) {
        this.fillingVolumeLower = fillingVolumeLower;
    }

    public String getFillingUnit() {
        return fillingUnit;
    }

    public void setFillingUnit(String fillingUnit) {
        this.fillingUnit = fillingUnit;
    }

    public void setDensity(BigDecimal density) {
        this.density = density;
    }

    public BigDecimal getDensity() {
        return density;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
