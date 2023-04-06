package com.jotime.web.domainVo.contract;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 描述：合同对象 t_contract
 * 
 * @author yunmoqian
 * @date 2022-04-12
 */
public class TContractVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Long id;

    /** 审批编号 */
    @Excel(name = "审批编号")
    private String apvlNo;

    /** 客户内码 */
    @Excel(name = "客户内码")
    @NotNull(message = "客户信息不可为空!")
    private Long customerId;

    /** 客户编码 */
    @Excel(name = "客户编码")
    private String customerCode;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private String contractNo;

    /** 合同类型 01 年度合同 02 单一合同  03 订单合同  sys_contract_type */
    @Excel(name = "合同类型 01 年度合同 02 单一合同  03 订单合同  sys_contract_type")
    private String contractType;

    /** 合同生效日  劳动合同开始  年龄 */
    @Excel(name = "合同生效日  劳动合同开始  年龄")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date contractEffective;


    /** 合同失效日  劳动合同结束  婚姻 */
    @Excel(name = "合同失效日  劳动合同结束  婚姻")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date contractExpiration;

    /** 版本号 */
    @Excel(name = "版本号")
    private String version;

    /** 申请人内码 */
    @Excel(name = "申请人内码")
    private Long proposerId;

    /** 申请人名称 */
    @Excel(name = "申请人名称")
    private String proposer;

    /** 申请时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date proposeTime;

    /** 状态 1 未执行 2、执行中 3 部分完成  4完成 9、关闭  */
    @Excel(name = "状态 1 未执行 2、执行中 3 部分完成  4完成 9、关闭 ")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 创建者id */
    @Excel(name = "创建者id")
    private String creatorId;

    /** 更新者id */
    @Excel(name = "更新者id")
    private String modifiedId;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifiedTime;

    /** 内码 */
    @TableField(exist = false)
    private Long dtlId;

    /** 合同审批编号内码 */
    @TableField(exist = false)
    private Long contractId;

    /** 物料内码 */
    @TableField(exist = false)
    @NotNull(message = "产品信息不可为空!!")
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

    /** 物料数量 */
    @TableField(exist = false)
    private BigDecimal itemQty;

    /** 已申请数量 */
    @Excel(name = "已申请数量")
    private BigDecimal apvlPdItemQty;

    /** 已排产数量 */
    @Excel(name = "已排产数量")
    private BigDecimal schedulingPdQty;


    /** 生产中数量 */
    @Excel(name = "生产中数量")
    private BigDecimal inPdQty;


    /** 已生产数量 */
    @Excel(name = "已生产数量")
    private BigDecimal finishedPdQty;


    /** 已出库数量 */
    @Excel(name = "已出库数量")
    private BigDecimal outWarehouseQty;

    /** 单价 */
    @TableField(exist = false)
    private String price;

    /** 单位 */
    @TableField(exist = false)
    private String unit;

    /** 状态 1 未执行 2、执行中 3 部分完成  4完成 9、关闭 */
    @TableField(exist = false)
    private Integer dtlStatus;

    /**
     * 详情数据
     */
    private List<TContractdtlVo> tContractdtlVos;

    /**
     * 是否返回异常
     */
    @TableField
    private Boolean itAbnormali;

    /**
     * 费用结算方式
     */
    @Excel(name = "费用结算方式")
    private String settlementMethod;

    /**
     * 金额
     */
    @Excel(name = "金额")
    private BigDecimal totalCost;

    public String getSettlementMethod() {
        return settlementMethod;
    }

    public void setSettlementMethod(String settlementMethod) {
        this.settlementMethod = settlementMethod;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Boolean getItAbnormali() {
        return itAbnormali;
    }

    public void setItAbnormali(Boolean itAbnormali) {
        this.itAbnormali = itAbnormali;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Date getContractEffective() {
        return contractEffective;
    }

    public void setContractEffective(Date contractEffective) {
        this.contractEffective = contractEffective;
    }

    public Date getContractExpiration() {
        return contractExpiration;
    }

    public void setContractExpiration(Date contractExpiration) {
        this.contractExpiration = contractExpiration;
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

    public List<TContractdtlVo> gettContractdtlVos() {
        return tContractdtlVos;
    }

    public void settContractdtlVos(List<TContractdtlVo> tContractdtlVos) {
        this.tContractdtlVos = tContractdtlVos;
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

    public Long getDtlId() {
        return dtlId;
    }

    public void setDtlId(Long dtlId) {
        this.dtlId = dtlId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
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

    public BigDecimal getItemQty() {
        return itemQty;
    }

    public void setItemQty(BigDecimal itemQty) {
        this.itemQty = itemQty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getDtlStatus() {
        return dtlStatus;
    }

    public void setDtlStatus(Integer dtlStatus) {
        this.dtlStatus = dtlStatus;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setApvlNo(String apvlNo) 
    {
        this.apvlNo = apvlNo;
    }

    public String getApvlNo() 
    {
        return apvlNo;
    }
    public void setCustomerId(Long customerId) 
    {
        this.customerId = customerId;
    }

    public Long getCustomerId() 
    {
        return customerId;
    }
    public void setCustomerCode(String customerCode) 
    {
        this.customerCode = customerCode;
    }

    public String getCustomerCode() 
    {
        return customerCode;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setContractNo(String contractNo) 
    {
        this.contractNo = contractNo;
    }

    public String getContractNo() 
    {
        return contractNo;
    }
    public void setProposerId(Long proposerId) 
    {
        this.proposerId = proposerId;
    }

    public Long getProposerId() 
    {
        return proposerId;
    }
    public void setProposer(String proposer) 
    {
        this.proposer = proposer;
    }

    public String getProposer() 
    {
        return proposer;
    }
    public void setProposeTime(Date proposeTime) 
    {
        this.proposeTime = proposeTime;
    }

    public Date getProposeTime() 
    {
        return proposeTime;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }
    public void setCreatorId(String creatorId) 
    {
        this.creatorId = creatorId;
    }

    public String getCreatorId() 
    {
        return creatorId;
    }
    public void setModifiedId(String modifiedId) 
    {
        this.modifiedId = modifiedId;
    }

    public String getModifiedId() 
    {
        return modifiedId;
    }
    public void setModifiedTime(Date modifiedTime) 
    {
        this.modifiedTime = modifiedTime;
    }

    public Date getModifiedTime() 
    {
        return modifiedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("apvlNo", getApvlNo())
            .append("customerId", getCustomerId())
            .append("customerCode", getCustomerCode())
            .append("customerName", getCustomerName())
            .append("contractNo", getContractNo())
            .append("proposerId", getProposerId())
            .append("proposer", getProposer())
            .append("proposeTime", getProposeTime())
            .append("status", getStatus())
            .append("note", getNote())
            .append("creatorId", getCreatorId())
            .append("createTime", getCreateTime())
            .append("modifiedId", getModifiedId())
            .append("modifiedTime", getModifiedTime())
            .toString();
    }
}
