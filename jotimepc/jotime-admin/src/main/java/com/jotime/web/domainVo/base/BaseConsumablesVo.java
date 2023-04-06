package com.jotime.web.domainVo.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 耗材基础对象 base_consumables
 * 
 * @author ruoyi
 * @date 2021-07-09
 */
public class BaseConsumablesVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 耗材编号 */
    private String consumableId;

    /** 耗材名称 */
    @Excel(name = "耗材名称")
    private String consumableName;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 耗材类别 */
    @Excel(name = "耗材类别")
    private String consumableType;

    /** 创建人姓名 */
    @Excel(name = "创建人姓名")
    private String creator;

    /** 创建人id */
    @Excel(name = "创建人id")
    private String creatorId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 创建者 */
    @Excel(name = "创建者")
    private String modifiedUser;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date gmtModified;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setConsumableId(String consumableId) 
    {
        this.consumableId = consumableId;
    }

    public String getConsumableId() 
    {
        return consumableId;
    }
    public void setConsumableName(String consumableName) 
    {
        this.consumableName = consumableName;
    }

    public String getConsumableName() 
    {
        return consumableName;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }
    public void setConsumableType(String consumableType) 
    {
        this.consumableType = consumableType;
    }

    public String getConsumableType() 
    {
        return consumableType;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setCreatorId(String creatorId) 
    {
        this.creatorId = creatorId;
    }

    public String getCreatorId() 
    {
        return creatorId;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setModifiedUser(String modifiedUser) 
    {
        this.modifiedUser = modifiedUser;
    }

    public String getModifiedUser() 
    {
        return modifiedUser;
    }
    public void setGmtModified(Date gmtModified) 
    {
        this.gmtModified = gmtModified;
    }

    public Date getGmtModified() 
    {
        return gmtModified;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("consumableId", getConsumableId())
            .append("consumableName", getConsumableName())
            .append("note", getNote())
            .append("consumableType", getConsumableType())
            .append("creator", getCreator())
            .append("creatorId", getCreatorId())
            .append("createDate", getCreateDate())
            .append("modifiedUser", getModifiedUser())
            .append("gmtModified", getGmtModified())
            .toString();
    }
}
