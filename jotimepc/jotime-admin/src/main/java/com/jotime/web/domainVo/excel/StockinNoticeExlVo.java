package com.jotime.web.domainVo.excel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Classname StockinNoticeExlVo
 * @Description
 * @Date 2022/3/23 9:52
 * @Created by 14812
 */
public class StockinNoticeExlVo extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /** 采购单号 0*/
    @Excel(name = "采购单号")
    private String originOrderNo;

    /** 采购员编号1 */
    @Excel(name = "采购员编号")
    private String purchaserCode;

    /** 供应商编码 2*/
    @Excel(name = "供应商编码")
    private String supplierCode;

    /** 制造商批号 3*/
    @Excel(name = "制造商批号")
    private String mfrsBatchNo;

    /** 到货批号 4*/
    @Excel(name = "到货批号")
    private String batchNo;

    /** 到货日期 5*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date actualArrivalDate;

    /** 物流单号 6*/
    @Excel(name = "物流单号")
    private String logisticsNo;

    /** 原料编号 7*/
    @Excel(name = "原料编号")
    private String itemCode;

    /** 原料名称 8*/
    @Excel(name = "原料名称")
    private String itemName;

    /**
     * 生产商编号9
     */
    @Excel(name = "生产商编号")
    private String mfrsCode;

    /**
     * 采购数量10
     */
    @Excel(name = "采购数量")
    private BigDecimal purchaseQty;

    /** 收货数量 11*/
    @Excel(name = "收货数量")
    private BigDecimal actualArrivalQty;

    /** 单位 12*/
    @Excel(name = "单位")
    private String unit;

    /** 件数 13*/
    @Excel(name = "件数")
    private Integer packages;

    /** 收货员编号14*/
    @Excel(name = "收货员编号")
    private String creatorCode;

    /** 入库数量 15*/
    @Excel(name = "入库数量")
    private BigDecimal stockinQty;

    /** 入库日期 16*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入库日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date plannedArrivalDate;

    /** 有效日期 17*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "有效日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date validDate;

    /** 仓库编码 18*/
    @Excel(name = "仓库编码")
    private String whCode;

    /** 备注 19*/
    @Excel(name = "备注")
    private String note;

    /** 更新标识  U 更新  D 删除  I 插入 20*/
    @Excel(name = "更新标识 U 更新  D 删除  I 插入")
    private String updateFlag;

    /** 入库通知单号*/
    private String stockinNoticeNo;
    /** 物料内码*/
    private Long itemId;

    /** 客户内码*/
    private Long customerId;
    /** 客户名称*/
    private String customerName;
    /** 供应商内码*/
    private Long supplierId;
    /** 供应商名称*/
    private String supplierName;
    /** 采购员内码*/
    private Long purchaserId;
    /** 采购员名称*/
    private String purchaser;

    /** 入库通知单明细表内码*/
    private Long noticeDtlId;

    /** 仓库Id*/
    private Long whId;

    /** 物料类型*/
    private Integer itemType;

    public String getOriginOrderNo() {
        return originOrderNo;
    }

    public void setOriginOrderNo(String originOrderNo) {
        this.originOrderNo = originOrderNo;
    }

    public String getPurchaserCode() {
        return purchaserCode;
    }

    public void setPurchaserCode(String purchaserCode) {
        this.purchaserCode = purchaserCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getMfrsBatchNo() {
        return mfrsBatchNo;
    }

    public void setMfrsBatchNo(String mfrsBatchNo) {
        this.mfrsBatchNo = mfrsBatchNo;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Date getActualArrivalDate() {
        return actualArrivalDate;
    }

    public void setActualArrivalDate(Date actualArrivalDate) {
        this.actualArrivalDate = actualArrivalDate;
    }

    public String getLogisticsNo() {
        return logisticsNo;
    }

    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
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

    public String getMfrsCode() {
        return mfrsCode;
    }

    public void setMfrsCode(String mfrsCode) {
        this.mfrsCode = mfrsCode;
    }

    public BigDecimal getPurchaseQty() {
        return purchaseQty;
    }

    public void setPurchaseQty(BigDecimal purchaseQty) {
        this.purchaseQty = purchaseQty;
    }

    public BigDecimal getActualArrivalQty() {
        return actualArrivalQty;
    }

    public void setActualArrivalQty(BigDecimal actualArrivalQty) {
        this.actualArrivalQty = actualArrivalQty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getPackages() {
        return packages;
    }

    public void setPackages(Integer packages) {
        this.packages = packages;
    }

    public String getCreatorCode() {
        return creatorCode;
    }

    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    }

    public BigDecimal getStockinQty() {
        return stockinQty;
    }

    public void setStockinQty(BigDecimal stockinQty) {
        this.stockinQty = stockinQty;
    }

    public Date getPlannedArrivalDate() {
        return plannedArrivalDate;
    }

    public void setPlannedArrivalDate(Date plannedArrivalDate) {
        this.plannedArrivalDate = plannedArrivalDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUpdateFlag() {
        return updateFlag;
    }

    public void setUpdateFlag(String updateFlag) {
        this.updateFlag = updateFlag;
    }

    public String getStockinNoticeNo() {
        return stockinNoticeNo;
    }

    public void setStockinNoticeNo(String stockinNoticeNo) {
        this.stockinNoticeNo = stockinNoticeNo;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public Long getNoticeDtlId() {
        return noticeDtlId;
    }

    public void setNoticeDtlId(Long noticeDtlId) {
        this.noticeDtlId = noticeDtlId;
    }

    public Long getWhId() {
        return whId;
    }

    public void setWhId(Long whId) {
        this.whId = whId;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }
}
