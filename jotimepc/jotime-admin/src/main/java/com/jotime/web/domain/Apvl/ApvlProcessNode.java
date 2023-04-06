package com.jotime.web.domain.Apvl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 审批流程节点对象 apvl_process_node
 *
 * @author ruoyi
 * @date 2021-12-26
 */
public class ApvlProcessNode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 节点内码 */
    private Long id;

    /** 配置名称 */
    @Excel(name = "配置名称")
    private String nodeName;

    /** 流程名称 */
    @TableField(exist = false)
    private String moduleName;

    /** 流程内码 */
    @Excel(name = "流程内码")
    private Long moduleId;

    /** 是否申请人 1 不是 2是 */
    @Excel(name = "是否申请人 1 不是 2是")
    private Long isProposer;


    /** 状态 1 删除  2 正常 */
    @Excel(name = "状态 1 删除  2 正常")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setNodeName(String nodeName)
    {
        this.nodeName = nodeName;
    }

    public String getNodeName()
    {
        return nodeName;
    }
    public void setModuleId(Long moduleId)
    {
        this.moduleId = moduleId;
    }

    public Long getModuleId()
    {
        return moduleId;
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

    public Long getIsProposer() {
        return isProposer;
    }

    public void setIsProposer(Long isProposer) {
        this.isProposer = isProposer;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("nodeName", getNodeName())
            .append("moduleId", getModuleId())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
