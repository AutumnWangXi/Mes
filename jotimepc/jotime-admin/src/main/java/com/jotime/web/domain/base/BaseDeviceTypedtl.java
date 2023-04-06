package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 设备类型详细对象 base_device_typedtl
 *
 * @author ruoyi
 * @date 2022-03-02
 */
public class BaseDeviceTypedtl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备信息内码 */
    private Integer id;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String deviceType;

    /** 类型排序 */
    @Excel(name = "类型排序")
    private Integer typeSort;

    /** 类型标签 */
    @Excel(name = "类型标签")
    private String typeLabel;

    /** 类型键值 */
    @Excel(name = "类型键值")
    private String typeValue;

    /** 状态（1禁用 2正常） */
    @Excel(name = "状态", readConverterExp = "1=禁用,2=正常")
    private Integer status;

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
    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }

    public String getDeviceType()
    {
        return deviceType;
    }
    public void setTypeSort(Integer typeSort)
    {
        this.typeSort = typeSort;
    }

    public Integer getTypeSort()
    {
        return typeSort;
    }
    public void setTypeLabel(String typeLabel)
    {
        this.typeLabel = typeLabel;
    }

    public String getTypeLabel()
    {
        return typeLabel;
    }
    public void setTypeValue(String typeValue)
    {
        this.typeValue = typeValue;
    }

    public String getTypeValue()
    {
        return typeValue;
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
            .append("deviceType", getDeviceType())
            .append("typeSort", getTypeSort())
            .append("typeLabel", getTypeLabel())
            .append("typeValue", getTypeValue())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
