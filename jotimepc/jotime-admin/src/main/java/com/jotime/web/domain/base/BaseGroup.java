package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 班组对象 base_group
 *
 * @author ruoyi
 * @date 2022-03-01
 */
public class BaseGroup extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 班组编码 */
    @Excel(name = "班组编码")
    private String groupCode;

    /** 班组名称 */
    @Excel(name = "班组名称")
    private String groupName;

    /** 班组负责人id */
    @Excel(name = "班组负责人id")
    private Long groupLeaderId;
    /** 部门内码 */
    @Excel(name = "部门内码")
    private Long deptId;

    /** 生产车间id */
    @Excel(name = "生产车间id")
    private Long workshopId;

    /** 状态 1 禁用  2 正常 */
    @Excel(name = "状态 1 禁用  2 正常")
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
    public void setGroupCode(String groupCode)
    {
        this.groupCode = groupCode;
    }

    public String getGroupCode()
    {
        return groupCode;
    }
    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    public String getGroupName()
    {
        return groupName;
    }
    public void setGroupLeaderId(Long groupLeaderId)
    {
        this.groupLeaderId = groupLeaderId;
    }

    public Long getGroupLeaderId()
    {
        return groupLeaderId;
    }
    public void setWorkshopId(Long workshopId)
    {
        this.workshopId = workshopId;
    }

    public Long getWorkshopId()
    {
        return workshopId;
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

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("groupCode", getGroupCode())
            .append("groupName", getGroupName())
            .append("groupLeaderId", getGroupLeaderId())
            .append("workshopId", getWorkshopId())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
