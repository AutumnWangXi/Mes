package com.jotime.web.domain.Apvl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 审批流程记录对象 apvl_process
 *
 * @author ruoyi
 * @date 2021-12-26
 */
public class ApvlProcess extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 流程节点编号，主键
     */
    private Long id;

    /**
     * 审批编号
     */
    @Excel(name = "审批编号")
    private String apvlNo;

    /**
     * 流程内码
     */
    @Excel(name = "流程内码")
    private Long moduleId;

    /**
     * 审批人内码
     */
    @Excel(name = "审批人内码")
    private Long approverId;

    /**
     * 审批人内码
     */
    @Excel(name = "审批人内码")
    private String approver;

    /**
     * 审批方式
     */
    @Excel(name = "审批方式")
    private Integer apvlMethod;


    /**
     * 审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审批时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date apvlTime;

    /**
     * 评论
     */
    @Excel(name = "评论")
    private String apvlComment;

    /**
     * 附件1
     */
    @Excel(name = "附件1")
    private String attachmentUrl1;

    /**
     * 附件2
     */
    @Excel(name = "附件2")
    private String attachmentUrl2;

    /**
     * 附件3
     */
    @Excel(name = "附件3")
    private String attachmentUrl3;

    /**
     * 附件4
     */
    @Excel(name = "附件4")
    private String attachmentUrl4;

    /**
     * 审批结果 1 保存 2 待审批 3 审批中 4已审批 9拒绝
     */
    @Excel(name = "审批结果 1 保存 2 待审批 3 审批中 4已审批 9拒绝")
    private Integer apvlResult;

    /**
     * 当前节点
     */
    @Excel(name = "当前节点")
    private Long curNodeId;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;

    /**
     * 创建者id
     */
    @Excel(name = "创建者id")
    private Integer creatorId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatorTime;

    /**
     * 更新者ID
     */
    @Excel(name = "更新者ID")
    private Integer modifiedId;


    /**
     * 流程名称
     */
    @TableField(exist = false)
    private String moduleName;
    /**
     * 创建者名称
     */
    @TableField(exist = false)
    private String creatorName;
    /**
     * 更新者名称
     */
    @TableField(exist = false)
    private String modifiedName;
    /**
     * 排除审批人
     */
    @TableField
    private Long notApproverId;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifiedTime;

    /**
     * 排除状态
     */
    @TableField(exist = false)
    private List<Integer> apvlResultList;

    public List<Integer> getApvlResultList() {
        return apvlResultList;
    }

    public void setApvlResultList(List<Integer> apvlResultList) {
        this.apvlResultList = apvlResultList;
    }

    public Long getNotApproverId() {
        return notApproverId;
    }

    public void setNotApproverId(Long notApproverId) {
        this.notApproverId = notApproverId;
    }

    public Integer getApvlMethod() {
        return apvlMethod;
    }

    public void setApvlMethod(Integer apvlMethod) {
        this.apvlMethod = apvlMethod;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setApvlNo(String apvlNo) {
        this.apvlNo = apvlNo;
    }

    public String getApvlNo() {
        return apvlNo;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setApproverId(Long approverId) {
        this.approverId = approverId;
    }

    public Long getApproverId() {
        return approverId;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getApprover() {
        return approver;
    }

    public void setApvlTime(Date apvlTime) {
        this.apvlTime = apvlTime;
    }

    public Date getApvlTime() {
        return apvlTime;
    }

    public void setApvlComment(String apvlComment) {
        this.apvlComment = apvlComment;
    }

    public String getApvlComment() {
        return apvlComment;
    }

    public void setAttachmentUrl1(String attachmentUrl1) {
        this.attachmentUrl1 = attachmentUrl1;
    }

    public String getAttachmentUrl1() {
        return attachmentUrl1;
    }

    public void setAttachmentUrl2(String attachmentUrl2) {
        this.attachmentUrl2 = attachmentUrl2;
    }

    public String getAttachmentUrl2() {
        return attachmentUrl2;
    }

    public void setAttachmentUrl3(String attachmentUrl3) {
        this.attachmentUrl3 = attachmentUrl3;
    }

    public String getAttachmentUrl3() {
        return attachmentUrl3;
    }

    public void setAttachmentUrl4(String attachmentUrl4) {
        this.attachmentUrl4 = attachmentUrl4;
    }

    public String getAttachmentUrl4() {
        return attachmentUrl4;
    }

    public void setApvlResult(Integer apvlResult) {
        this.apvlResult = apvlResult;
    }

    public Integer getApvlResult() {
        return apvlResult;
    }

    public void setCurNodeId(Long curNodeId) {
        this.curNodeId = curNodeId;
    }

    public Long getCurNodeId() {
        return curNodeId;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorTime(Date creatorTime) {
        this.creatorTime = creatorTime;
    }

    public Date getCreatorTime() {
        return creatorTime;
    }

    public void setModifiedId(Integer modifiedId) {
        this.modifiedId = modifiedId;
    }

    public Integer getModifiedId() {
        return modifiedId;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getModifiedName() {
        return modifiedName;
    }

    public void setModifiedName(String modifiedName) {
        this.modifiedName = modifiedName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("apvlNo", getApvlNo())
                .append("moduleId", getModuleId())
                .append("approverId", getApproverId())
                .append("approver", getApprover())
                .append("apvlTime", getApvlTime())
                .append("apvlComment", getApvlComment())
                .append("attachmentUrl1", getAttachmentUrl1())
                .append("attachmentUrl2", getAttachmentUrl2())
                .append("attachmentUrl3", getAttachmentUrl3())
                .append("attachmentUrl4", getAttachmentUrl4())
                .append("apvlResult", getApvlResult())
                .append("curNodeId", getCurNodeId())
                .append("note", getNote())
                .append("creatorId", getCreatorId())
                .append("creatorTime", getCreatorTime())
                .append("modifiedId", getModifiedId())
                .append("modifiedTime", getModifiedTime())
                .toString();
    }
}
