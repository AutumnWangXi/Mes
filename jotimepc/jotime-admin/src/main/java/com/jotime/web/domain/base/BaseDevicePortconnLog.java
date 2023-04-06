package com.jotime.web.domain.base;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 设备端口连接日志对象 base_device_portconn_log
 *
 * @author yunmoqian
 * @date 2022-11-25
 */
public class BaseDevicePortconnLog extends BaseEntity
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

    /** 波特率 */
    @Excel(name = "波特率")
    private String baudRate;

    /** 数据位 */
    @Excel(name = "数据位")
    private String dataBit;

    /** 奇偶校验位 NONE：noe  EVEN：Even ODD：Odd MARK：Mark SPACE：Space */
    @Excel(name = "奇偶校验位 NONE：noe  EVEN：Even ODD：Odd MARK：Mark SPACE：Space")
    private String parityBit;

    /** 停止位 */
    @Excel(name = "停止位")
    private String stopBit;

    /** 流控 NONE:none RTS/CTS:RTS/CTS XON/XOFF:XON/XOFF */
    @Excel(name = "流控 NONE:none RTS/CTS:RTS/CTS XON/XOFF:XON/XOFF")
    private String fluidControl;

    /** 发送类型 hex 十六进制  text 文本  */
    @Excel(name = "发送类型 hex 十六进制  text 文本 ")
    private String sendType;

    /** 接收类型 hex 十六进制  text 文本  */
    @Excel(name = "接收类型 hex 十六进制  text 文本 ")
    private String receiveType;

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

    /** 连接时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "连接时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date connTime;

    /** 断开时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "断开时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date disconnTime;

    /** 连接状态 C 连接  DC 断开 */
    @Excel(name = "连接状态 C 连接  DC 断开")
    private String connStatus;

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
    public void setBaudRate(String baudRate)
    {
        this.baudRate = baudRate;
    }

    public String getBaudRate()
    {
        return baudRate;
    }
    public void setDataBit(String dataBit)
    {
        this.dataBit = dataBit;
    }

    public String getDataBit()
    {
        return dataBit;
    }
    public void setParityBit(String parityBit)
    {
        this.parityBit = parityBit;
    }

    public String getParityBit()
    {
        return parityBit;
    }
    public void setStopBit(String stopBit)
    {
        this.stopBit = stopBit;
    }

    public String getStopBit()
    {
        return stopBit;
    }
    public void setFluidControl(String fluidControl)
    {
        this.fluidControl = fluidControl;
    }

    public String getFluidControl()
    {
        return fluidControl;
    }
    public void setSendType(String sendType)
    {
        this.sendType = sendType;
    }

    public String getSendType()
    {
        return sendType;
    }
    public void setReceiveType(String receiveType)
    {
        this.receiveType = receiveType;
    }

    public String getReceiveType()
    {
        return receiveType;
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
    public void setConnTime(Date connTime)
    {
        this.connTime = connTime;
    }

    public Date getConnTime()
    {
        return connTime;
    }
    public void setDisconnTime(Date disconnTime)
    {
        this.disconnTime = disconnTime;
    }

    public Date getDisconnTime()
    {
        return disconnTime;
    }
    public void setConnStatus(String connStatus)
    {
        this.connStatus = connStatus;
    }

    public String getConnStatus()
    {
        return connStatus;
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
            .append("baudRate", getBaudRate())
            .append("dataBit", getDataBit())
            .append("parityBit", getParityBit())
            .append("stopBit", getStopBit())
            .append("fluidControl", getFluidControl())
            .append("sendType", getSendType())
            .append("receiveType", getReceiveType())
            .append("latestConnDeviceCode", getLatestConnDeviceCode())
            .append("latestConnDeviceMac", getLatestConnDeviceMac())
            .append("latestConnPortNo", getLatestConnPortNo())
            .append("latestConnPortName", getLatestConnPortName())
            .append("connTime", getConnTime())
            .append("disconnTime", getDisconnTime())
            .append("connStatus", getConnStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
