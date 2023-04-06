package com.jotime.web.domainVo.excel;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

/**
 * @Description: 表格导入，内料对象
 * @Author: YunFei
 * @Date: 2022/4/15 15:08
 */
public class BaseItemInnerMaterialExlVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 物料id
     */
    private Long id;

    /**
     * 物料代码
     */
    @Excel(name = "内料编码")
    private String itemCode;

//    /**
//     * 物料编号
//     */
//    @Excel(name = "物料编号")
//    private String itemNo;

    /**
     * 物料名称
     */
    @Excel(name = "内料名称")
    private String itemName;

    /**
     * 类别
     */
    @Excel(name = "类别")
    private String categoryType;


    /**
     * 规格
     */
    @Excel(name = "规格")
    private String specifications;


    /**
     * 色号
     */
    @Excel(name = "实验室编号")
    private String colourNumber;

    /**
     * 表现
     */
    @Excel(name = "表现")
    private String appearance;


    /**
     * 含量
     */
    @Excel(name = "含量")
    private String content;
    /**
     * 条形码
     */
    @Excel(name = "条形码")
    private String barCode;

    /**
     * 是否需要质检 1 不需要  2 需要
     */
    @Excel(name = "是否需要质检 1 不需要  2 需要",width = 30)
    private Integer needQuality;

    /**
     * 是否需要称重 1 不需要  2 需要
     */
    @Excel(name = "是否需要称重 1 不需要  2 需要",width = 30)
    private Integer needWeigh;

    /**
     * 是否保密 1 不需要  2 需要
     */
    @Excel(name = "是否控制内料 1 不需要  2 需要",width = 30)
    private Integer needConfidential;
    /**
     * 是否保密 1 不需要  2 需要
     */
    @Excel(name = "备注")
    private String Note;

    /**
     * 状态
     */
//    @Excel(name = "状态")
    private Integer status;

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

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
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

    public String getColourNumber() {
        return colourNumber;
    }

    public void setColourNumber(String colourNumber) {
        this.colourNumber = colourNumber;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Integer getNeedQuality() {
        return needQuality;
    }

    public void setNeedQuality(Integer needQuality) {
        this.needQuality = needQuality;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
