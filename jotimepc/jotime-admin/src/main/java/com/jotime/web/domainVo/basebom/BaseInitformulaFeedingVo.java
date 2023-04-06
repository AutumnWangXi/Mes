package com.jotime.web.domainVo.basebom;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 一期配方投料对象 base_initformula_feeding
 *
 * @author ruoyi
 * @date 2022-01-16
 */
public class BaseInitformulaFeedingVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 内码
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 配方id
     */
    @Excel(name = "配方id")
    private Long formulaId;

    /**
     * 投料顺序
     */
    @Excel(name = "投料顺序")
    private Integer stepSort;

    /**
     * 物料内码
     */
    @Excel(name = "物料内码")
    private Long itemId;

    /**
     * 用量
     */
    @Excel(name = "用量")
    private BigDecimal inventory;

    /**
     * 单位
     */
    @Excel(name = "单位")
    private String unit;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;

    /**
     * 配方编号
     */
    @Excel(name = "配方编号")
    private String formulaNo;
    /**
     * 版本号
     */
    @Excel(name = "版本号")
    private String version;

    /**
     * 物料序号
     */
    @Excel(name = "物料序号")
    private String itemSort;

    private String itemCode;

    private String itemName;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getFormulaId() {
        return formulaId;
    }

    public void setFormulaId(Long formulaId) {
        this.formulaId = formulaId;
    }

    public void setStepSort(Integer stepSort) {
        this.stepSort = stepSort;
    }

    public Integer getStepSort() {
        return stepSort;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setInventory(BigDecimal inventory) {
        this.inventory = inventory;
    }

    public BigDecimal getInventory() {
        return inventory;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public String getFormulaNo() {
        return formulaNo;
    }

    public void setFormulaNo(String formulaNo) {
        this.formulaNo = formulaNo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public String getItemSort() {
        return itemSort;
    }

    public void setItemSort(String itemSort) {
        this.itemSort = itemSort;
    }
}
