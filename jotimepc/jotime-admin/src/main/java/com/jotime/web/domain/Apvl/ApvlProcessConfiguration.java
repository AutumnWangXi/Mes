package com.jotime.web.domain.Apvl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 审批流程配置对象 apvl_process_configuration
 *
 * @author ruoyi
 * @date 2021-12-26
 */
public class ApvlProcessConfiguration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 配置内码 */
    private Long id;

    /** 流程名称 */
    @Excel(name = "配置名称")
    private String processStepName;

    /** 流程内码 */
    @Excel(name = "流程内码")
    private Long moduleId;

    /** 流程名称 非直接数据库查询*/

    @TableField(exist = false)
    private String moduleName;

    /** 审批方式 1 单人审批；2 多人审批 */
    @Excel(name = "审批方式 1 单人审批；2 多人审批")
    private Integer apvlMethod;

    /** 流程上一个节点 */
    @Excel(name = "流程上一个节点")
    private Long preNode;

    /** 流程上一个节点名称 非直接数据库查询*/
    @TableField(exist = false)
    private String preNodeName;

    /** 祖级列表*/
    @Excel(name = "祖级列表")
    private String ancestors;

    /** 正常流程下一个节点 */
    @Excel(name = "正常流程下一个节点")
    private Long nextNode;

    /** 正常流程下一个节点名称 非直接数据库查询*/
    @TableField(exist = false)
    private String nextNodeName;


    /** 驳回流程下一个节点 */
    @Excel(name = "驳回流程下一个节点")
    private Long rejectNextNode;

    /** 驳回流程下一个节点名称 非直接数据库查询*/
    @TableField(exist = false)
    private String rejectNextNodeName;

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
    public void setProcessStepName(String processStepName)
    {
        this.processStepName = processStepName;
    }

    public String getProcessStepName()
    {
        return processStepName;
    }
    public void setModuleId(Long moduleId)
    {
        this.moduleId = moduleId;
    }

    public Long getModuleId()
    {
        return moduleId;
    }
    public void setApvlMethod(Integer apvlMethod)
    {
        this.apvlMethod = apvlMethod;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getAncestors() {
        return ancestors;
    }

    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    public String getPreNodeName() {
        return preNodeName;
    }

    public void setPreNodeName(String preNodeName) {
        this.preNodeName = preNodeName;
    }

    public String getNextNodeName() {
        return nextNodeName;
    }

    public void setNextNodeName(String nextNodeName) {
        this.nextNodeName = nextNodeName;
    }

    public String getRejectNextNodeName() {
        return rejectNextNodeName;
    }

    public void setRejectNextNodeName(String rejectNextNodeName) {
        this.rejectNextNodeName = rejectNextNodeName;
    }

    public Integer getApvlMethod()
    {
        return apvlMethod;
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
    public void setRejectNextNode(Long rejectNextNode)
    {
        this.rejectNextNode = rejectNextNode;
    }

    public Long getRejectNextNode()
    {
        return rejectNextNode;
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
            .append("processStepName", getProcessStepName())
            .append("moduleId", getModuleId())
            .append("apvlMethod", getApvlMethod())
            .append("ancestors", getAncestors())
            .append("preNode", getPreNode())
            .append("nextNode", getNextNode())
            .append("rejectNextNode", getRejectNextNode())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
