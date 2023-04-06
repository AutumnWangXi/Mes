package com.jotime.web.domainVo.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import com.jotime.web.domain.base.BaseCloseline;
import com.jotime.web.domain.base.BaseCloselinedtl;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 清线检查对象 base_closeline
 *
 * @author ruoyi
 * @date 2022-03-04
 */
public class BaseCloselineVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 设备编号/流水线no */
    @Excel(name = "设备编号/流水线no")
    private String deviceCode;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 清场要求 */
    @Excel(name = "清场要求")
    private String requirement;

    /** 状态1 禁用 2 正常 */
    @Excel(name = "状态1 禁用 2 正常")
    private Integer status;
//    详情列表
    @TableField(exist = false)
    private List<BaseCloselinedtl> baseCloselinedtls;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setDeviceCode(String deviceCode)
    {
        this.deviceCode = deviceCode;
    }

    public String getDeviceCode()
    {
        return deviceCode;
    }
    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName()
    {
        return deviceName;
    }
    public void setRequirement(String requirement)
    {
        this.requirement = requirement;
    }

    public String getRequirement()
    {
        return requirement;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }

    public List<BaseCloselinedtl> getBaseCloselinedtls() {
        return baseCloselinedtls;
    }

    public void setBaseCloselinedtls(List<BaseCloselinedtl> baseCloselinedtls) {
        this.baseCloselinedtls = baseCloselinedtls;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceCode", getDeviceCode())
            .append("deviceName", getDeviceName())
            .append("requirement", getRequirement())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
