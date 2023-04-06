package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 班组人员管理对象 base_groupuser
 * 
 * @author ruoyi
 * @date 2022-03-01
 */
public class BaseGroupuser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 班组id */
    @Excel(name = "班组id")
    private String groupId;

    /** 属于哪个车间：id */
    @Excel(name = "属于哪个车间：id")
    private String workshopId;

    /** 班组编码 */
    @Excel(name = "班组编码")
    private String groupCode;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 组员 */
    @Excel(name = "组员")
    private String userId;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setGroupId(String groupId) 
    {
        this.groupId = groupId;
    }

    public String getGroupId() 
    {
        return groupId;
    }
    public void setWorkshopId(String workshopId) 
    {
        this.workshopId = workshopId;
    }

    public String getWorkshopId() 
    {
        return workshopId;
    }
    public void setGroupCode(String groupCode) 
    {
        this.groupCode = groupCode;
    }

    public String getGroupCode() 
    {
        return groupCode;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
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
            .append("groupId", getGroupId())
            .append("workshopId", getWorkshopId())
            .append("groupCode", getGroupCode())
            .append("status", getStatus())
            .append("userId", getUserId())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
