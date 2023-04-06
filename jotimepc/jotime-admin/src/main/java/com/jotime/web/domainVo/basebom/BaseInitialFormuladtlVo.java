package com.jotime.web.domainVo.basebom;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 打样一期配方管理明细对象 base_initial_formuladtl
 *
 * @author ruoyi
 * @date 2022-01-16
 */
public class BaseInitialFormuladtlVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 内码
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * bom表内码
     */
    @Excel(name = "bom表内码")
    private Long formulaId;

    /**
     * 制造厂商ID
     */
    @Excel(name = "制造厂商ID")
    private Long itemId;

    /**
     * 客户编码
     */
    @Excel(name = "客户编码")
    private Long mfrsId;

    /**
     * 品牌
     */
    @Excel(name = "品牌")
    private String brand;

    /**
     * 含量
     */
    @Excel(name = "含量")
    private BigDecimal content;

    /**
     * 基准量
     */
    @Excel(name = "基准量")
    private BigDecimal standardQty;

    /**
     * 物料图片
     */
    @Excel(name = "物料图片")
    private String imageUrl;

    /**
     * 状态  1 禁用  2 正常
     */
    @Excel(name = "状态  1 禁用  2 正常")
    private Integer status;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;
    /**
     * 物料序号
     */
    @Excel(name = "物料序号")
    private Integer itemSort;
    /**
     * 生产厂商名称
     */
    @Excel(name = "生产厂商名称")
    private String mfrsName;

    @TableField(exist = false)
    private String itemType;

    @TableField(exist = false)
    private String itemCode;

    @TableField(exist = false)
    private String itemName;

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

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFormulaId(Long formulaId) {
        this.formulaId = formulaId;
    }

    public Long getFormulaId() {
        return formulaId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setMfrsId(Long mfrsId) {
        this.mfrsId = mfrsId;
    }

    public Long getMfrsId() {
        return mfrsId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setContent(BigDecimal content) {
        this.content = content;
    }

    public BigDecimal getContent() {
        return content;
    }

    public void setStandardQty(BigDecimal standardQty) {
        this.standardQty = standardQty;
    }

    public BigDecimal getStandardQty() {
        return standardQty;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public String getMfrsName() {
        return mfrsName;
    }

    public void setMfrsName(String mfrsName) {
        this.mfrsName = mfrsName;
    }

    public Integer getItemSort() {
        return itemSort;
    }

    public void setItemSort(Integer itemSort) {
        this.itemSort = itemSort;
    }
}
