package com.jotime.web.domainVo.contract;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 描述：合同明细对象 t_contractdtl
 *
 * @author yunmoqian
 * @date 2022-04-12
 */
public class TContractdtlVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 内码
     */
    private Long id;

    /**
     * 合同审批编号内码
     */
    @Excel(name = "合同审批编号内码")
    private Long contractId;

    /**
     * 物料内码
     */
    @Excel(name = "物料内码")
    private Long itemId;

    /**
     * 物料编号
     */
    @TableField(exist = false)
    private String itemCode;

    /**
     * 物料类型
     */
    @TableField(exist = false)
    private Integer itemType;

    /** 物料序号 */
    @Excel(name = "物料序号")
    private Integer itemSort;

    /**
     * 物料规格
     */
    @TableField(exist = false)
    private String specifications;

    /**
     * 物料名称
     */
    @TableField(exist = false)
    private String itemName;

    /**
     * 物料数量
     */
    @Excel(name = "物料数量")
    private BigDecimal itemQty;

    /**
     * 已申请数量
     */
    @Excel(name = "已申请数量")
    private BigDecimal apvlPdItemQty;

    /**
     * 已排产数量
     */
    @Excel(name = "已排产数量")
    private BigDecimal schedulingPdQty;


    /**
     * 生产中数量
     */
    @Excel(name = "生产中数量")
    private BigDecimal inPdQty;


    /**
     * 已生产数量
     */
    @Excel(name = "已生产数量")
    private BigDecimal finishedPdQty;


    /**
     * 已出库数量
     */
    @Excel(name = "已出库数量")
    private BigDecimal outWarehouseQty;

    /**
     * 单价
     */
    @Excel(name = "单价")
    private String price;

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
     * 状态 1 未执行 2、执行中 3 部分完成  4完成 9、关闭
     */
    @Excel(name = "状态 1 未执行 2、执行中 3 部分完成  4完成 9、关闭")
    private Integer status;

    /**
     * bom编号
     */
    @TableField(exist = false)
    private String bomNo;

    /**
     * 版本号
     */
    private String version;

    /**
     * 是否客供包材
     */
    private Integer isCustPackage;

    /**
     * 是否客供原料
     */
    private Integer isCustMaterial;

    /**
     * 生产数量
     */
    private BigDecimal pdQty;

    public BigDecimal getPdQty() {
        return pdQty;
    }

    public void setPdQty(BigDecimal pdQty) {
        this.pdQty = pdQty;
    }

    public Integer getIsCustPackage() {
        return isCustPackage;
    }

    public void setIsCustPackage(Integer isCustPackage) {
        this.isCustPackage = isCustPackage;
    }

    public Integer getIsCustMaterial() {
        return isCustMaterial;
    }

    public void setIsCustMaterial(Integer isCustMaterial) {
        this.isCustMaterial = isCustMaterial;
    }

    public Integer getItemSort() {
        return itemSort;
    }

    public void setItemSort(Integer itemSort) {
        this.itemSort = itemSort;
    }

    public String getBomNo() {
        return bomNo;
    }

    public void setBomNo(String bomNo) {
        this.bomNo = bomNo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public BigDecimal getApvlPdItemQty() {
        return apvlPdItemQty;
    }

    public void setApvlPdItemQty(BigDecimal apvlPdItemQty) {
        this.apvlPdItemQty = apvlPdItemQty;
    }

    public BigDecimal getSchedulingPdQty() {
        return schedulingPdQty;
    }

    public void setSchedulingPdQty(BigDecimal schedulingPdQty) {
        this.schedulingPdQty = schedulingPdQty;
    }

    public BigDecimal getInPdQty() {
        return inPdQty;
    }

    public void setInPdQty(BigDecimal inPdQty) {
        this.inPdQty = inPdQty;
    }

    public BigDecimal getFinishedPdQty() {
        return finishedPdQty;
    }

    public void setFinishedPdQty(BigDecimal finishedPdQty) {
        this.finishedPdQty = finishedPdQty;
    }

    public BigDecimal getOutWarehouseQty() {
        return outWarehouseQty;
    }

    public void setOutWarehouseQty(BigDecimal outWarehouseQty) {
        this.outWarehouseQty = outWarehouseQty;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemQty(BigDecimal itemQty) {
        this.itemQty = itemQty;
    }

    public BigDecimal getItemQty() {
        return itemQty;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
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

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("contractId", getContractId())
                .append("itemId", getItemId())
                .append("itemQty", getItemQty())
                .append("price", getPrice())
                .append("unit", getUnit())
                .append("note", getNote())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
