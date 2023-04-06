package com.jotime.web.domain.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 包材属性对象 base_packaging_attribute
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
public class BasePackagingAttribute extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 属性id */
    @Excel(name = "属性id")
    private String packagingId;

    /** 属性名称 */
    @Excel(name = "属性名称")
    private String attribute;

    /** 描述 */
    @Excel(name = "描述")
    private String describe;

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

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPackagingId(String packagingId) 
    {
        this.packagingId = packagingId;
    }

    public String getPackagingId() 
    {
        return packagingId;
    }
    public void setAttribute(String attribute) 
    {
        this.attribute = attribute;
    }

    public String getAttribute() 
    {
        return attribute;
    }
    public void setDescribe(String describe) 
    {
        this.describe = describe;
    }

    public String getDescribe() 
    {
        return describe;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("packagingId", getPackagingId())
            .append("attribute", getAttribute())
            .append("describe", getDescribe())
            .append("creator", getCreator())
            .append("creatorId", getCreatorId())
            .append("createDate", getCreateDate())
            .toString();
    }
}
