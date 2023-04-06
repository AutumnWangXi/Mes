package com.jotime.web.domainVo.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 库位列对象 base_warehouse_location
 *
 * @author ruoyi
 * @date 2022-01-16
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseWarehouseLocationVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库位id */
    private Long id;

    /** 库位编码 */
    @Excel(name = "库位编码")
    private String locationCode;

    /** 库位名称 */
    @Excel(name = "库位名称")
    private String locationNoView;

    /** DD 地堆 GB 隔板 GJ 高架 */
    @Excel(name = "DD 地堆 GB 隔板 GJ 高架")
    private String locationType;

    /** 是否允许混放 1 不允许混放  2允许混放 */
    @Excel(name = "是否允许混放 1 不允许混放  2允许混放")
    private Long isMix;

    /** 存放品质类型 1 不良品  2 良品  3 都可以  */
    @Excel(name = "存放品质类型 1 不良品  2 良品  3 都可以 ")
    private String keepType;

    /** 打印类型 1 简化  2完整 */
    @Excel(name = "打印类型 1 简化  2完整")
    private Integer printType;

    /** 库位分组 */
    @Excel(name = "库位分组")
    private String locationGroup;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long whId;
    /** 仓库id */
    @TableField(exist = false)
    private String whName;


    /** 库区id */
    @Excel(name = "库区id")
    private Long areaId;
    /** 库区id */
    @TableField(exist = false)
    private String areaName;

    /** 状态 0  禁用 1启用 */
    @Excel(name = "状态 0  禁用 1启用")
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
    public void setLocationCode(String locationCode)
    {
        this.locationCode = locationCode;
    }

    public String getLocationCode()
    {
        return locationCode;
    }
    public void setLocationNoView(String locationNoView)
    {
        this.locationNoView = locationNoView;
    }

    public String getLocationNoView()
    {
        return locationNoView;
    }
    public void setLocationType(String locationType)
    {
        this.locationType = locationType;
    }

    public String getLocationType()
    {
        return locationType;
    }
    public void setIsMix(Long isMix)
    {
        this.isMix = isMix;
    }

    public Long getIsMix()
    {
        return isMix;
    }
    public void setKeepType(String keepType)
    {
        this.keepType = keepType;
    }

    public String getKeepType()
    {
        return keepType;
    }
    public void setPrintType(Integer printType)
    {
        this.printType = printType;
    }

    public Integer getPrintType()
    {
        return printType;
    }
    public void setLocationGroup(String locationGroup)
    {
        this.locationGroup = locationGroup;
    }

    public String getLocationGroup()
    {
        return locationGroup;
    }
    public void setWhId(Long whId)
    {
        this.whId = whId;
    }

    public Long getWhId()
    {
        return whId;
    }
    public void setAreaId(Long areaId)
    {
        this.areaId = areaId;
    }

    public Long getAreaId()
    {
        return areaId;
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

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("locationCode", getLocationCode())
            .append("locationNoView", getLocationNoView())
            .append("locationType", getLocationType())
            .append("isMix", getIsMix())
            .append("keepType", getKeepType())
            .append("printType", getPrintType())
            .append("locationGroup", getLocationGroup())
            .append("whId", getWhId())
            .append("areaId", getAreaId())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
