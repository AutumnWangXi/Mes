package com.jotime.web.domainVo.excel;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

/**
 * @Description: 预混料表格对象
 * @Author: YunFei
 * @Date: 2022/4/14 18:30
 */
public class BaseItemPremixExlVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 物料id
     */
    private Long id;

    /**
     * 物料代码
     */
    @Excel(name = "预混料编码")
    private String itemCode;

    /**
     * 物料编号
     */
//    @Excel(name = "物料编号")
    private String itemNo;

    /**
     * 物料名称
     */
    @Excel(name = "预混料名称")
    private String itemName;

    /**
     * 规格
     */
    @Excel(name = "规格")
    private String specifications;

    /**
     * 表现
     */
    @Excel(name = "表现")
    private String appearance;

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

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
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

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
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
