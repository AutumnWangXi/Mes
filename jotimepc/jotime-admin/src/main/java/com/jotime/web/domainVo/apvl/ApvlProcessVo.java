package com.jotime.web.domainVo.apvl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import com.jotime.common.core.domain.entity.SysUser;

import java.util.Date;
import java.util.List;

/**
 * 审批流程配置对象 apvl_process
 *
 * @author ruoyi
 * @date 2021-12-13
 */
public class ApvlProcessVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 流程节点编号，主键 */
    private Long id;

    /** 审批编号 */
    @Excel(name = "审批编号")
    private String apvlNo;

    /** 流程内码 */
    @Excel(name = "流程内码")
    private Long moduleId;

    /** 流程名称 */
    @TableField(exist = false)
    private String moduleName;

    /** 审批人内码 */
    @Excel(name = "审批人内码")
    private Long approverId;

    /** 审批人 */
    @Excel(name = "审批人")
    private String approver;

    /** 审批方式 */
    @Excel(name = "审批方式")
    private Integer apvlMethod;


    /** 审批时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "审批时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date apvlTime;

    /** 评论 */
    @Excel(name = "评论")
    private String apvlComment;

    /** 附件1 */
    @Excel(name = "附件1")
    private String attachmentUrl1;

    /** 附件2 */
    @Excel(name = "附件2")
    private String attachmentUrl2;

    /** 附件3 */
    @Excel(name = "附件3")
    private String attachmentUrl3;

    /** 附件4 */
    @Excel(name = "附件4")
    private String attachmentUrl4;

    /** 审批结果 1 保存 2 待审批 3 审批中 4已审批 9拒绝 */
    @Excel(name = "审批结果 1 保存 2 待审批 3 审批中 4已审批 9拒绝")
    private Integer apvlResult;

    /** 当前节点 */
    @Excel(name = "当前节点")
    private Long curNodeId;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 创建者id */
    @Excel(name = "创建者id")
    private Integer creatorId;

    /** 创建者名称 */
    @TableField(exist = false)
    private String creatorName;
    /** 更新者名称 */
    @TableField(exist = false)
    private String modifiedName;
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatorTime;

    /** 更新者ID */
    @Excel(name = "更新者ID")
    private Integer modifiedId;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifiedTime;


    /** 节点内码 */
    @TableField(exist = false)
    private Long nodeId;

    /** 部门名称 */
    @TableField(exist = false)
    private String nodeName;

    /** 状态 */
    @TableField(exist = false)
    private Integer status;

    /** 审核人List */
    @TableField(exist = false)
    private List<SysUser> users;

    /** 头像 */
    @TableField(exist = false)
    private String avatar;

    /** 当前审批节点 */
    @TableField(exist = false)
    private int nodeStatus;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApvlNo() {
        return apvlNo;
    }

    public void setApvlNo(String apvlNo) {
        this.apvlNo = apvlNo;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Long getApproverId() {
        return approverId;
    }

    public void setApproverId(Long approverId) {
        this.approverId = approverId;
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

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public Integer getApvlMethod() {
        return apvlMethod;
    }

    public void setApvlMethod(Integer apvlMethod) {
        this.apvlMethod = apvlMethod;
    }

    public Date getApvlTime() {
        return apvlTime;
    }

    public void setApvlTime(Date apvlTime) {
        this.apvlTime = apvlTime;
    }

    public String getApvlComment() {
        return apvlComment;
    }

    public void setApvlComment(String apvlComment) {
        this.apvlComment = apvlComment;
    }

    public String getAttachmentUrl1() {
        return attachmentUrl1;
    }

    public void setAttachmentUrl1(String attachmentUrl1) {
        this.attachmentUrl1 = attachmentUrl1;
    }

    public String getAttachmentUrl2() {
        return attachmentUrl2;
    }

    public void setAttachmentUrl2(String attachmentUrl2) {
        this.attachmentUrl2 = attachmentUrl2;
    }

    public String getAttachmentUrl3() {
        return attachmentUrl3;
    }

    public void setAttachmentUrl3(String attachmentUrl3) {
        this.attachmentUrl3 = attachmentUrl3;
    }

    public String getAttachmentUrl4() {
        return attachmentUrl4;
    }

    public void setAttachmentUrl4(String attachmentUrl4) {
        this.attachmentUrl4 = attachmentUrl4;
    }

    public Integer getApvlResult() {
        return apvlResult;
    }

    public void setApvlResult(Integer apvlResult) {
        this.apvlResult = apvlResult;
    }

    public Long getCurNodeId() {
        return curNodeId;
    }

    public void setCurNodeId(Long curNodeId) {
        this.curNodeId = curNodeId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreatorTime() {
        return creatorTime;
    }

    public void setCreatorTime(Date creatorTime) {
        this.creatorTime = creatorTime;
    }

    public Integer getModifiedId() {
        return modifiedId;
    }

    public void setModifiedId(Integer modifiedId) {
        this.modifiedId = modifiedId;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }

    public List<SysUser> getUsers() {
        return users;
    }
    public void setUsers(List<SysUser> users) { this.users = users;}

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getNodeStatus() {
        return nodeStatus;
    }

    public void setNodeStatus(int nodeStatus) {
        this.nodeStatus = nodeStatus;
    }

}
