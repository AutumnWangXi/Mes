package com.jotime.web.domainVo.apvl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 审批共通对象 apvl_common
 *
 * @author ruoyi
 * @date 2021-12-13
 */
public class ApvlCommonVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 审批编号/模块关联ID
     */
    @Excel(name = "审批编号/模块关联ID")
    private String apvlNo;
    /**
     * 是否加急
     */
    @Excel(name = "是否加急")
    private Integer isUrgent;

    /**
     * 产品ID
     */
    @Excel(name = "产品ID")
    private Long itemId;

    /**
     * 产品名称
     */
    @Excel(name = "产品名称")
    private String itemName;

    /**
     * 产品编号
     */
    @TableField(exist = false)
    private String itemCode;

    /**
     * 客户内码
     */
    @Excel(name = "客户内码")
    private Long customerId;

    /**
     * 客户名称
     */
    @Excel(name = "客户名称")
    private String customerName;

    /**
     * 审批类型 1.打样申请 2。报价申请 3. 合同申请 4.生产申请 5.销售出货申请 6.订单采购7.备货采购 8. 返工报废
     */
    @Excel(name = "审批类型 1.打样申请 2。报价申请 3. 合同申请 4.生产申请 5.销售出货申请 6.订单采购7.备货采购 8. 返工报废")
    private String apvlType;

    /**
     * 申请人内码
     */
    @Excel(name = "申请人内码")
    private Long proposerId;

    /**
     * 申请人名称
     */
    @Excel(name = "申请人名称")
    private String proposer;

    /**
     * 申请时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date proposeTime;

    /**
     * 最新处理时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "最新处理时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date lastApvlTime;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;

    /**
     * 状态  1 保存 2 待审批 3 审批中 4已审批 9拒绝
     */
    @Excel(name = "状态  1 保存 2 待审批 3 审批中 4已审批 9拒绝")
    private Integer status;

    /**
     * 审批结果 通过 2 驳回 1
     */
    @Excel(name = "审批结果 通过 2 驳回 1")
    private Integer approvalResult;


    /**
     * 客户内码
     */
    @TableField(exist = false)
    private String customerCode;


    /**
     * 发单日期
     */
    @TableField(exist = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date issueDate;

    /**
     * 取样日期
     */
    @TableField(exist = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date samplingDate;



    /**
     * 需求特征
     */
    @TableField(exist = false)
    private String demandCharacteristics;

    /**
     * 头像url
     */
    @TableField(exist = false)
    private String filePath;

    /**
     * 审批部门
     */
    @TableField(exist = false)
    private String deptName;

    /**
     * 抄送人
     */
    @TableField(exist = false)
    private String employeeName;

    /**
     * 审批人
     */
    @TableField(exist = false)
    private String approvalerName;

    /**
     * 审批人
     */
    @TableField(exist = false)
    private Long approverId;

    /**
     * 审批人
     */
    @TableField(exist = false)
    private String approver;

    /**
     * 产品类型
     */
    @TableField(exist = false)
    private Integer itemType;

    /**
     * 评论表评论内容
     */
    @TableField(exist = false)
    private String commentNote;

    /**申请分组编号*/
    private String groupCode;


    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }


    /**
     * 审批编号
     */
    private List<String> apvlNoList;

    /**
     * 审批状态
     */
    private List<Integer> statusList;

    /**
     * 审批记录结果
     */
    private Integer apvlResult;

    /**
     * 单价
     */
    @TableField(exist = false)
    private String price;


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getApvlResult() {
        return apvlResult;
    }

    public void setApvlResult(Integer apvlResult) {
        this.apvlResult = apvlResult;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public List<Integer> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Integer> statusList) {
        this.statusList = statusList;
    }

    public List<String> getApvlNoList() {
        return apvlNoList;
    }

    public void setApvlNoList(List<String> apvlNoList) {
        this.apvlNoList = apvlNoList;
    }
    public String getCommentNote() {
        return commentNote;
    }

    public void setCommentNote(String commentNote) {
        this.commentNote = commentNote;
    }

    public Integer getApprovalResult() {
        return approvalResult;
    }

    public void setApprovalResult(Integer approvalResult) {
        this.approvalResult = approvalResult;
    }


    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getSamplingDate() {
        return samplingDate;
    }

    public void setSamplingDate(Date samplingDate) {
        this.samplingDate = samplingDate;
    }


    public String getDemandCharacteristics() {
        return demandCharacteristics;
    }

    public void setDemandCharacteristics(String demandCharacteristics) {
        this.demandCharacteristics = demandCharacteristics;
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

    public String getApvlNo() {
        return apvlNo;
    }

    public void setApvlNo(String apvlNo) {
        this.apvlNo = apvlNo;
    }

    public Integer getIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(Integer isUrgent) {
        this.isUrgent = isUrgent;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setApvlType(String apvlType) {
        this.apvlType = apvlType;
    }

    public String getApvlType() {
        return apvlType;
    }

    public void setProposerId(Long proposerId) {
        this.proposerId = proposerId;
    }

    public Long getProposerId() {
        return proposerId;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposeTime(Date proposeTime) {
        this.proposeTime = proposeTime;
    }

    public Date getProposeTime() {
        return proposeTime;
    }

    public void setLastApvlTime(Date lastApvlTime) {
        this.lastApvlTime = lastApvlTime;
    }

    public Date getLastApvlTime() {
        return lastApvlTime;
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


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getApprovalerName() {
        return approvalerName;
    }

    public void setApprovalerName(String approvalerName) {
        this.approvalerName = approvalerName;
    }

    public Long getApproverId() {
        return approverId;
    }

    public void setApproverId(Long approverId) {
        this.approverId = approverId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
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
