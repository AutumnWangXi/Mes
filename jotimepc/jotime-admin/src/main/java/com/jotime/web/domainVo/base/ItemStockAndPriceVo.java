package com.jotime.web.domainVo.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Classname ItemStockAndPriceVo
 * @Description
 * @Date 2022/7/27 18:30
 * @Created by 14812
 */
public class ItemStockAndPriceVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long itemId;

    /**
     * 物料代码
     */
    private String itemCode;

    /**
     * 物料名称
     */
    private String itemName;

    /**
     * 物料类型 1原料 2包材 3预处理料 4 内料 5 半成品 6成品5
     */
    private Integer itemType;

    /**
     * 可用库存量
     */
    private BigDecimal usageStockQty;

    /**
     * 采购中数量
     */
    private BigDecimal purchaseInQty;

    /**
     * 平均采购价
     */
    private BigDecimal avgPrice;

    /**
     * 最近一次采购价
     */
    private BigDecimal lastPrice;

    /**
     * 品质
     */
    private String keepType;

    /**
     * 状态
     */
    private Integer status;

    private List<Long> itemIds ;

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

    public BigDecimal getUsageStockQty() {
        return usageStockQty;
    }

    public void setUsageStockQty(BigDecimal usageStockQty) {
        this.usageStockQty = usageStockQty;
    }

    public BigDecimal getPurchaseInQty() {
        return purchaseInQty;
    }

    public void setPurchaseInQty(BigDecimal purchaseInQty) {
        this.purchaseInQty = purchaseInQty;
    }

    public BigDecimal getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(BigDecimal avgPrice) {
        this.avgPrice = avgPrice;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getKeepType() {
        return keepType;
    }

    public void setKeepType(String keepType) {
        this.keepType = keepType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }
}
