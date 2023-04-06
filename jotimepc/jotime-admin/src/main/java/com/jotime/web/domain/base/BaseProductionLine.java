package com.jotime.web.domain.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 生产线对象 base_production_line
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
public class BaseProductionLine extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 生产线id */
    @Excel(name = "生产线id")
    private String productionlineId;

    /**  生产线名称 */
    @Excel(name = " 生产线名称")
    private String productionlineName;

    /** 产量 */
    @Excel(name = "产量")
    private Long yield;

    /** 产线所属车间名称 */
    @Excel(name = "产线所属车间名称")
    private String workshop;

    /** 产线所属车间id */
    @Excel(name = "产线所属车间id")
    private String workshopId;

    /** 生产线状态 */
    @Excel(name = "生产线状态")
    private String status;

    /** 创建人 */
    @Excel(name = "创建人")
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
    public void setProductionlineId(String productionlineId) 
    {
        this.productionlineId = productionlineId;
    }

    public String getProductionlineId() 
    {
        return productionlineId;
    }
    public void setProductionlineName(String productionlineName) 
    {
        this.productionlineName = productionlineName;
    }

    public String getProductionlineName() 
    {
        return productionlineName;
    }
    public void setYield(Long yield) 
    {
        this.yield = yield;
    }

    public Long getYield() 
    {
        return yield;
    }
    public void setWorkshop(String workshop) 
    {
        this.workshop = workshop;
    }

    public String getWorkshop() 
    {
        return workshop;
    }
    public void setWorkshopId(String workshopId) 
    {
        this.workshopId = workshopId;
    }

    public String getWorkshopId() 
    {
        return workshopId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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
            .append("productionlineId", getProductionlineId())
            .append("productionlineName", getProductionlineName())
            .append("yield", getYield())
            .append("workshop", getWorkshop())
            .append("workshopId", getWorkshopId())
            .append("status", getStatus())
            .append("creator", getCreator())
            .append("creatorId", getCreatorId())
            .append("createDate", getCreateDate())
            .toString();
    }
}
