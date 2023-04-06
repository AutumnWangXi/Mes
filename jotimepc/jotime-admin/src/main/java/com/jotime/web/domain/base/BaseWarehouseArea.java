package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 库区列对象 base_warehouse_area
 * 
 * @author ruoyi
 * @date 2022-01-16
 */
public class BaseWarehouseArea extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库区id */
    private Long id;

    /** 库区编码 */
    @Excel(name = "库区编码")
    private String areaCode;

    /** 库区名称 */
    @Excel(name = "库区名称")
    private String areaName;

    /** 库区类型 */
    @Excel(name = "库区类型")
    private String areaType;

    /** 本库位数量 */
    @Excel(name = "本库位数量")
    private Long areaLocationQty;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long whId;

    /** 状态0  禁用 1启用 */
    @Excel(name = "状态0  禁用 1启用")
    private String status;

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
    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode()
    {
        return areaCode;
    }
    public void setAreaName(String areaName) 
    {
        this.areaName = areaName;
    }

    public String getAreaName() 
    {
        return areaName;
    }
    public void setAreaType(String areaType) 
    {
        this.areaType = areaType;
    }

    public String getAreaType() 
    {
        return areaType;
    }
    public void setAreaLocationQty(Long areaLocationQty) 
    {
        this.areaLocationQty = areaLocationQty;
    }

    public Long getAreaLocationQty() 
    {
        return areaLocationQty;
    }
    public void setWhId(Long whId) 
    {
        this.whId = whId;
    }

    public Long getWhId() 
    {
        return whId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
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
            .append("areaCode", getAreaCode())
            .append("areaName", getAreaName())
            .append("areaType", getAreaType())
            .append("areaLocationQty", getAreaLocationQty())
            .append("whId", getWhId())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
