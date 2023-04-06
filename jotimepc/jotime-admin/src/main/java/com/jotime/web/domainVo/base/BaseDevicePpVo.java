package com.jotime.web.domainVo.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import com.jotime.web.domain.base.BaseDevicePpdtl;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 设备工艺参数对象 base_device_pp
 *
 * @author ruoyi
 * @date 2022-03-17
 */
public class BaseDevicePpVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Long id;

    /** 设备内码 */
    @Excel(name = "设备内码")
    private String deviceId;
    /** 设备内码 */
    @TableField(exist = false)
    private String deviceName;

    /** 工艺组名称 */
    @Excel(name = "工艺组名称")
    private String groupName;

    /** 排序 */
    @Excel(name = "排序")
    private Integer paramSort;
    @TableField(exist = false)
    private List<BaseDevicePpdtl> baseDevicePpdtls;

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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public List<BaseDevicePpdtl> getBaseDevicePpdtls() {
        return baseDevicePpdtls;
    }

    public void setBaseDevicePpdtls(List<BaseDevicePpdtl> baseDevicePpdtls) {
        this.baseDevicePpdtls = baseDevicePpdtls;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceId", getDeviceId())
            .append("groupName", getGroupName())
            .append("deviceSort", getParamSort())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
