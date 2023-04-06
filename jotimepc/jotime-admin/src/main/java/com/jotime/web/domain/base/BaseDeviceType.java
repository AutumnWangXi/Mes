package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 设备类型对象 base_device_type
 *
 * @author ruoyi
 * @date 2022-03-02
 */
public class BaseDeviceType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备类型内码 */
    private Long id;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String deviceType;

    /** 设备类别名称 */
    @Excel(name = "设备类别名称")
    private String deviceTypeName;

    /** 状态（1禁用 2正常） */
    @Excel(name = "状态", readConverterExp = "1=禁用,2=正常")
    private Integer status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
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

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceType", getDeviceType())
            .append("deviceName", getDeviceTypeName())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
