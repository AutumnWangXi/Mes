package com.jotime.web.domainVo.basebom;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 描述：投料对象 base_bom_feeding
 *
 * @author ruoyi
 * @date 2021-12-26
 */
public class BaseBomFeedingVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 内码
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 工艺步骤内码
     */
    @Excel(name = "工艺步骤内码")
    private Long processstepId;

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
     * 投料方式 1 人工投料 2 自动投料
     */
    @Excel(name = "投料方式 1 人工投料 2 自动投料")
    private Integer feedingModel;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String node;
    /**
     * 物料编码
     */
    private String itemCode;
    /**
     * 物料名称
     */
    private String itemName;

    /**
     * 物料序号
     */
    private Integer itemSort;

    /**
     * 物料类型
     */
    private Integer itemType;
    /**
     * 上限值
     */
    private BigDecimal toplimitValue;
    /**
     * 下限值
     */
    private BigDecimal lowerlimitValue;


    public BigDecimal getToplimitValue() {
        return toplimitValue;
    }

    public void setToplimitValue(BigDecimal toplimitValue) {
        this.toplimitValue = toplimitValue;
    }

    public BigDecimal getLowerlimitValue() {
        return lowerlimitValue;
    }

    public void setLowerlimitValue(BigDecimal lowerlimitValue) {
        this.lowerlimitValue = lowerlimitValue;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setProcessstepId(Long processstepId) {
        this.processstepId = processstepId;
    }

    public Long getProcessstepId() {
        return processstepId;
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

    public void setFeedingModel(Integer feedingModel) {
        this.feedingModel = feedingModel;
    }

    public Integer getFeedingModel() {
        return feedingModel;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getNode() {
        return node;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("processstepId", getProcessstepId())
                .append("stepSort", getStepSort())
                .append("itemId", getItemId())
                .append("inventory", getInventory())
                .append("unit", getUnit())
                .append("feedingModel", getFeedingModel())
                .append("node", getNode())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
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

    public Integer getItemSort() {
        return itemSort;
    }

    public void setItemSort(Integer itemSort) {
        this.itemSort = itemSort;
    }
}
