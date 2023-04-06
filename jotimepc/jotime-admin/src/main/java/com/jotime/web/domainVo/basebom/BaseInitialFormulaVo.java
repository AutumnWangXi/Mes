package com.jotime.web.domainVo.basebom;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * 打样一期配方管理对象 base_initial_formula
 *
 * @author ruoyi
 * @date 2022-01-16
 */
public class BaseInitialFormulaVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 内码
     */
    @TableId(type = IdType.AUTO)
    private Long id;

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
     * 打样任务编码
     */
    @Excel(name = "打样任务编码")
    private String formulataskNo;

    /**
     * 客户内码
     */
    @Excel(name = "客户内码")
    private Long customerId;

    /**
     * 合同订单编号
     */
    @Excel(name = "合同订单编号")
    private String contractorderNo;

    /**
     * 物料id
     */
    @Excel(name = "物料id")
    private Long itemId;

    /**
     * 物料编号
     */
    @Excel(name = "物料编号")
    private String itemNo;

    /**
     * 打样物品名称
     */
    @Excel(name = "打样物品名称")
    private String itemName;

    /**
     * 系列名称
     */
    @Excel(name = "系列名称")
    private String seriesName;

    /**
     * 工序内码
     */
    @Excel(name = "工序内码")
    private Long processId;

    /** 生化检验结果 1 不合格 2 合格 */
    @Excel(name = "理化检验结果 1 不合格 2 合格")
    private Integer biochemicalTests;

    /** 稳定性验证结果  1 不合格 2 合格 */
    @Excel(name = "稳定性验证结果  1 不合格 2 合格")
    private Integer stabilityTests;

    /** 微生物检验结果  1 不合格 2 合格 */
    @Excel(name = "微生物检验结果  1 不合格 2 合格")
    private Integer microbeTests;

    /** 关键点 */
    @Excel(name = "关键点")
    private String keypoint;

    /**
     * 审核人编码
     */
    @Excel(name = "审核人编码")
    private String checkId;

    /**
     * 状态 1 禁用  2 正常
     */
    @Excel(name = "状态 1 禁用  2 正常")
    private Integer status;

    /**
     * 审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkTime;
    /** 申请人内码 */
    @Excel(name = "申请人内码")
    private Long proposerId;

    /** 申请时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date proposeTime;

    /** 申请人名称 */
    @Excel(name = "申请人名称")
    private String proposer;
    /** 审核人编码 */
    @Excel(name = "审核人编码")
    private String checkerCode;

    /** 审核人 */
    @Excel(name = "审核人")
    private String checker;

    /** 审核结果 1 不通过 2 通过 */
    @Excel(name = "审核结果 1 不通过 2 通过")
    private Integer checkResult;

    /** 审核状态 1 待申请 2 审核中 3审核完成 */
    @Excel(name = "审核状态 1 待申请 2 审核中 3审核完成")
    private Integer checkStatus;

    /** 申请理由 */
    @Excel(name = "申请理由")
    private String proposeReason;

    /** 审核备注 */
    @Excel(name = "审核备注")
    private String checkNote;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;
    @TableField(exist = false)
    private String customerName;
    @TableField(exist = false)
    private String customerCode;
    private String productFormulaReq;
    private String formulaQty;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date samplingDate;
    private Integer evaluationResult;
    /**
     * 配方组成
     */
    List<BaseInitialFormuladtlVo> dtlVos;

    /**
     * 投料明细
     */
    List<BaseInitformulaFeedingVo> feedingVos;

    /**
     * 步骤明细
     */
    List<BaseInitformulaProcessstepVo> processstepVos;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public Integer getMicrobeTests() {
        return microbeTests;
    }

    public void setMicrobeTests(Integer microbeTests) {
        this.microbeTests = microbeTests;
    }

    public String getKeypoint() {
        return keypoint;
    }

    public void setKeypoint(String keypoint) {
        this.keypoint = keypoint;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductFormulaReq() {
        return productFormulaReq;
    }

    public void setProductFormulaReq(String productFormulaReq) {
        this.productFormulaReq = productFormulaReq;
    }

    public String getFormulaQty() {
        return formulaQty;
    }

    public void setFormulaQty(String formulaQty) {
        this.formulaQty = formulaQty;
    }

    public Date getSamplingDate() {
        return samplingDate;
    }

    public void setSamplingDate(Date samplingDate) {
        this.samplingDate = samplingDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFormulaNo(String formulaNo) {
        this.formulaNo = formulaNo;
    }

    public String getFormulaNo() {
        return formulaNo;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setFormulataskNo(String formulataskNo) {
        this.formulataskNo = formulataskNo;
    }

    public String getFormulataskNo() {
        return formulataskNo;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setContractorderNo(String contractorderNo) {
        this.contractorderNo = contractorderNo;
    }

    public String getContractorderNo() {
        return contractorderNo;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setStabilityTests(Integer stabilityTests) {
        this.stabilityTests = stabilityTests;
    }

    public Integer getStabilityTests() {
        return stabilityTests;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public Integer getBiochemicalTests() {
        return biochemicalTests;
    }

    public void setBiochemicalTests(Integer biochemicalTests) {
        this.biochemicalTests = biochemicalTests;
    }

    public Long getProposerId() {
        return proposerId;
    }

    public void setProposerId(Long proposerId) {
        this.proposerId = proposerId;
    }

    public Date getProposeTime() {
        return proposeTime;
    }

    public void setProposeTime(Date proposeTime) {
        this.proposeTime = proposeTime;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public String getCheckerCode() {
        return checkerCode;
    }

    public void setCheckerCode(String checkerCode) {
        this.checkerCode = checkerCode;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public Integer getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(Integer checkResult) {
        this.checkResult = checkResult;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public List<BaseInitialFormuladtlVo> getDtlVos() {
        return dtlVos;
    }

    public void setDtlVos(List<BaseInitialFormuladtlVo> dtlVos) {
        this.dtlVos = dtlVos;
    }

    public List<BaseInitformulaFeedingVo> getFeedingVos() {
        return feedingVos;
    }

    public void setFeedingVos(List<BaseInitformulaFeedingVo> feedingVos) {
        this.feedingVos = feedingVos;
    }

    public List<BaseInitformulaProcessstepVo> getProcessstepVos() {
        return processstepVos;
    }

    public void setProcessstepVos(List<BaseInitformulaProcessstepVo> processstepVos) {
        this.processstepVos = processstepVos;
    }

    public String getProposeReason() {
        return proposeReason;
    }

    public void setProposeReason(String proposeReason) {
        this.proposeReason = proposeReason;
    }

    public String getCheckNote() {
        return checkNote;
    }

    public void setCheckNote(String checkNote) {
        this.checkNote = checkNote;
    }

    public Integer getEvaluationResult() {
        return evaluationResult;
    }

    public void setEvaluationResult(Integer evaluationResult) {
        this.evaluationResult = evaluationResult;
    }
}
