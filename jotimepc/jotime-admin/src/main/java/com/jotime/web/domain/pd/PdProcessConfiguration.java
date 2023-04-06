package com.jotime.web.domain.pd;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;

/**
 * 描述：生产流程配置对象 pd_process_configuration
 * 
 * @author yunmoqian
 * @date 2022-05-06
 */
public class PdProcessConfiguration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 流程内码 */
    private Long id;

    /** 流程名称 */
    @Excel(name = "流程名称")
    @NotNull(message = "流程不可为空")
    private Long moduleId;

    /** 流程名称 */
    @Excel(name = "流程名称")
    private String processStepName;

    /** 祖级列表 */
    @Excel(name = "祖级列表")
    private String ancestors;

    /** 流程上一个节点 */
    @Excel(name = "流程上一个节点")
    @NotNull(message = "流程上一个节点不可为空")
    private Long preNode;

    /** 流程下一个节点 */
    @Excel(name = "流程下一个节点")
    @NotNull(message = "流程下一个节点不可为空")
    private Long nextNode;

    /** 状态 1 删除 2 正常 */
    @Excel(name = "状态 1 删除 2 正常")
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
    public void setProcessStepName(String processStepName) 
    {
        this.processStepName = processStepName;
    }

    public String getProcessStepName() 
    {
        return processStepName;
    }
    public void setAncestors(String ancestors) 
    {
        this.ancestors = ancestors;
    }

    public String getAncestors() 
    {
        return ancestors;
    }
    public void setPreNode(Long preNode) 
    {
        this.preNode = preNode;
    }

    public Long getPreNode() 
    {
        return preNode;
    }
    public void setNextNode(Long nextNode) 
    {
        this.nextNode = nextNode;
    }

    public Long getNextNode() 
    {
        return nextNode;
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
            .append("processStepName", getProcessStepName())
            .append("ancestors", getAncestors())
            .append("preNode", getPreNode())
            .append("nextNode", getNextNode())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
