package com.jotime.web.domain.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 设备工艺参数对象 base_device_pp
 *
 * @author ruoyi
 * @date 2022-03-17
 */
public class BaseDevicePp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 设备内码 */
    @Excel(name = "设备内码")
    private String deviceId;

    /** 工艺组名称 */
    @Excel(name = "工艺组名称")
    private String groupName;

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
    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    public String getGroupName()
    {
        return groupName;
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
            .append("groupName", getGroupName())
            .append("paramSort", getParamSort())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
