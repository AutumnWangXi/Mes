package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 设备工艺参数对象 base_device_ppdtl
 *
 * @author ruoyi
 * @date 2022-03-17
 */
public class BaseDevicePpdtl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Long id;

    /** 设备内码 */
    @Excel(name = "设备内码")
    private String deviceId;

    /** 工艺组内码 */
    @Excel(name = "工艺组内码")
    private String groupId;

    /** 工艺参数值 */
    @Excel(name = "工艺参数值")
    private String paramValue;

    /** 工艺参数名称 */
    @Excel(name = "工艺参数名称")
    private String paramName;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 排序 */
    @Excel(name = "排序")
    private Integer paramSort;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }

    public String getDeviceId()
    {
        return deviceId;
    }
    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }

    public String getGroupId()
    {
        return groupId;
    }
    public void setParamValue(String paramValue)
    {
        this.paramValue = paramValue;
    }

    public String getParamValue()
    {
        return paramValue;
    }
    public void setParamName(String paramName)
    {
        this.paramName = paramName;
    }

    public String getParamName()
    {
        return paramName;
    }
    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getUnit()
    {
        return unit;
    }

    public Integer getParamSort() {
        return paramSort;
    }

    public void setParamSort(Integer paramSort) {
        this.paramSort = paramSort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceId", getDeviceId())
            .append("groupId", getGroupId())
            .append("paramValue", getParamValue())
            .append("paramName", getParamName())
            .append("unit", getUnit())
            .append("paramSort", getParamSort())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
