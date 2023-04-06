package com.jotime.web.domain.Apvl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 审批共通对象 apvl_common
 *
 * @author ruoyi
 * @date 2021-12-13
 */
public class ApvlCommon extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 审批编号/模块关联ID */
    @Excel(name = "审批编号/模块关联ID")
    private String apvlNo;


    /** 是否加急 */
    @Excel(name = "是否加急")
    private Integer isUrgent;

    /** 产品ID */
    @Excel(name = "产品ID")
    private Long itemId;

    /** 产品编号 */
    @TableField(exist = false)
    private String itemCode;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String itemName;

    /** 客户内码 */
    @Excel(name = "客户内码")
    private Long customerId;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 审批类型 1.打样申请 2。报价申请 3. 合同申请 4.生产申请 5.销售出货申请 6.订单采购7.备货采购 8. 返工报废 */
    @Excel(name = "审批类型 1.打样申请 2。报价申请 3. 合同申请 4.生产申请 5.销售出货申请 6.订单采购7.备货采购 8. 返工报废")
    private String apvlType;

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

    /** 最新处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最新处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastApvlTime;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 状态  1 保存 2 待审批 3 审批中 4已审批 5已撤销 6 待办理 7 办理中 9拒绝 */
    @Excel(name = "状态  1 保存 2 待审批 3 审批中 4已审批 5已撤销 6 待办理 7 办理中 9拒绝")
    private Integer status;
    /**申请分组编号*/
    private String groupCode;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public String getApvlNo() {
        return apvlNo;
    }

    public void setApvlNo(String apvlNo) {
        this.apvlNo = apvlNo;
    }

    public void setItemId(Long itemId)
    {
        this.itemId = itemId;
    }

    public Long getItemId()
    {
        return itemId;
    }
    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }

    public String getItemName()
    {
        return itemName;
    }
    public void setCustomerId(Long customerId)
    {
        this.customerId = customerId;
    }

    public Long getCustomerId()
    {
        return customerId;
    }
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerName()
    {
        return customerName;
    }
    public void setApvlType(String apvlType)
    {
        this.apvlType = apvlType;
    }

    public String getApvlType()
    {
        return apvlType;
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
    public void setLastApvlTime(Date lastApvlTime)
    {
        this.lastApvlTime = lastApvlTime;
    }

    public Date getLastApvlTime()
    {
        return lastApvlTime;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }

    public Integer getIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(Integer isUrgent) {
        this.isUrgent = isUrgent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("apvlNo", getApvlNo())
            .append("isUrgent", getIsUrgent())
            .append("itemId", getItemId())
            .append("itemName", getItemName())
            .append("customerId", getCustomerId())
            .append("customerName", getCustomerName())
            .append("apvlType", getApvlType())
            .append("proposerId", getProposerId())
            .append("proposer", getProposer())
            .append("proposeTime", getProposeTime())
            .append("lastApvlTime", getLastApvlTime())
            .append("note", getNote())
            .append("status", getStatus())
            .toString();
    }
}
