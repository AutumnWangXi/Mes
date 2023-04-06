package com.jotime.web.domain.Apvl;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 审批流程名称对象 apvl_module
 *
 * @author ruoyi
 * @date 2021-12-26
 */
public class ApvlModule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 流程内码 */
    private Long id;

    /** 流程编号 */
    @Excel(name = "流程编号")
    private String moduleNo;

    /** 流程名称 */
    @Excel(name = "流程名称")
    private String moduleName;

    /** 流程描述 */
    @Excel(name = "流程描述")
    private String moduleDescribe;

    /** 状态 1 删除  2 正常 */
    @Excel(name = "状态 1 删除  2 正常")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;
    /**分组编号*/
    private String groupCode;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setModuleNo(String moduleNo)
    {
        this.moduleNo = moduleNo;
    }

    public String getModuleNo()
    {
        return moduleNo;
    }
    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }

    public String getModuleName()
    {
        return moduleName;
    }
    public void setModuleDescribe(String moduleDescribe)
    {
        this.moduleDescribe = moduleDescribe;
    }

    public String getModuleDescribe()
    {
        return moduleDescribe;
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
            .append("moduleNo", getModuleNo())
            .append("moduleName", getModuleName())
            .append("moduleDescribe", getModuleDescribe())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
