package com.jotime.web.domainVo.apvl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 审批人员对象 apvl_approver
 *
 * @author ruoyi
 * @date 2021-12-26
 */
public class ApvlApproverVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 审批人员内码 */
    private Long id;

    /** 流程内码 */
    @Excel(name = "流程内码")
    private Long moduleId;

    /** 流程名称 */
    @TableField(exist = false)
    private String moduleName;

    /** 节点内码 */
    @Excel(name = "节点内码")
    private Long nodeId;

    /** 节点名称 */
    @TableField(exist = false)
    private String nodeName;

    /** 审批人内码 */
    @Excel(name = "审批人内码")
    private String approverId;

    /** 审批人名称 */
    @Excel(name = "审批人名称")
    private String approver;

    /** 状态 1 删除  2 正常 */
    @Excel(name = "状态 1 删除  2 正常")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setModuleId(Long moduleId)
    {
        this.moduleId = moduleId;
    }

    public Long getModuleId()
    {
        return moduleId;
    }
    public void setNodeId(Long nodeId)
    {
        this.nodeId = nodeId;
    }

    public Long getNodeId()
    {
        return nodeId;
    }

    public String getApproverId() {
        return approverId;
    }

    public void setApproverId(String approverId) {
        this.approverId = approverId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void setApprover(String approver)
    {
        this.approver = approver;
    }

    public String getApprover()
    {
        return approver;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("moduleId", getModuleId())
            .append("nodeId", getNodeId())
            .append("approverId", getApproverId())
            .append("approver", getApprover())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
