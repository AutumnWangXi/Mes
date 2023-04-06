package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 设备端口信息对象 base_device_port
 *
 * @author yunmoqian
 * @date 2022-11-25
 */
public class BaseDevicePort extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Long id;

    /** 设备编码 */
    @Excel(name = "设备编码")
    private String deviceCode;

    /** 物料地址 */
    @Excel(name = "物料地址")
    private String deviceMac;

    /** 端口编号 */
    @Excel(name = "端口编号")
    private String portNo;

    /** 端口名称 */
    @Excel(name = "端口名称")
    private String portName;

    /** 连接方式：RS232:RS-232  RS485 RS-485 RS422: RS-422, USB: USB TCP:TCP  BT：Bluetooth  ETHERNET:Ethernet */
    @Excel(name = "连接方式：RS232:RS-232  RS485 RS-485 RS422: RS-422, USB: USB TCP:TCP  BT：Bluetooth  ETHERNET:Ethernet")
    private String connType;

    /** ip地址 */
    @Excel(name = "ip地址")
    private String ipAddress;

    /** 最新连接设备编码 */
    @Excel(name = "最新连接设备编码")
    private String latestConnDeviceCode;

    /** 最新连接设备物理地址 */
    @Excel(name = "最新连接设备物理地址")
    private String latestConnDeviceMac;

    /** 最新连接设备端口编号 */
    @Excel(name = "最新连接设备端口编号")
    private String latestConnPortNo;

    /** 最新连接设备端口名称 */
    @Excel(name = "最新连接设备端口名称")
    private String latestConnPortName;

    /** 连接状态 C 连接  DC 断开 */
    @Excel(name = "连接状态 C 连接  DC 断开")
    private String connStatus;

    /** 状态 1 禁用 2启用 */
    @Excel(name = "状态 1 禁用 2启用")
    private Integer status;

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
    public void setDeviceMac(String deviceMac)
    {
        this.deviceMac = deviceMac;
    }

    public String getDeviceMac()
    {
        return deviceMac;
    }
    public void setPortNo(String portNo)
    {
        this.portNo = portNo;
    }

    public String getPortNo()
    {
        return portNo;
    }
    public void setPortName(String portName)
    {
        this.portName = portName;
    }

    public String getPortName()
    {
        return portName;
    }
    public void setConnType(String connType)
    {
        this.connType = connType;
    }

    public String getConnType()
    {
        return connType;
    }
    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress()
    {
        return ipAddress;
    }
    public void setLatestConnDeviceCode(String latestConnDeviceCode)
    {
        this.latestConnDeviceCode = latestConnDeviceCode;
    }

    public String getLatestConnDeviceCode()
    {
        return latestConnDeviceCode;
    }
    public void setLatestConnDeviceMac(String latestConnDeviceMac)
    {
        this.latestConnDeviceMac = latestConnDeviceMac;
    }

    public String getLatestConnDeviceMac()
    {
        return latestConnDeviceMac;
    }
    public void setLatestConnPortNo(String latestConnPortNo)
    {
        this.latestConnPortNo = latestConnPortNo;
    }

    public String getLatestConnPortNo()
    {
        return latestConnPortNo;
    }
    public void setLatestConnPortName(String latestConnPortName)
    {
        this.latestConnPortName = latestConnPortName;
    }

    public String getLatestConnPortName()
    {
        return latestConnPortName;
    }
    public void setConnStatus(String connStatus)
    {
        this.connStatus = connStatus;
    }

    public String getConnStatus()
    {
        return connStatus;
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
            .append("deviceCode", getDeviceCode())
            .append("deviceMac", getDeviceMac())
            .append("portNo", getPortNo())
            .append("portName", getPortName())
            .append("connType", getConnType())
            .append("ipAddress", getIpAddress())
            .append("latestConnDeviceCode", getLatestConnDeviceCode())
            .append("latestConnDeviceMac", getLatestConnDeviceMac())
            .append("latestConnPortNo", getLatestConnPortNo())
            .append("latestConnPortName", getLatestConnPortName())
            .append("connStatus", getConnStatus())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
