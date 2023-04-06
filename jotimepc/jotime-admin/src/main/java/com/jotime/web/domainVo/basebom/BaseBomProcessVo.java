package com.jotime.web.domainVo.basebom;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 描述：bom工序对象 base_bom_process
 *
 * @author ruoyi
 * @date 2021-12-26
 */
public class BaseBomProcessVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** bom内码 */
    @Excel(name = "bom内码")
    private String bomNo;

    /** bom内码 */
    @Excel(name = "bom内码")
    private Long bomId;

    /** bom编号 */
    @Excel(name = "bom编号")
    private String bomCode;

    /** 工艺顺序 */
    @Excel(name = "工艺顺序")
    private Integer stepSort;

    /** 工序名称 */
    @Excel(name = "工序名称")
    private String processName;

    /** 设备编码 */
    @Excel(name = "设备编码")
    private String deviceCode;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String deviceType;

    /** 设备id */
    @Excel(name = "设备id")
    private Integer deviceId;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 工艺描述 */
    @Excel(name = "工艺描述")
    private String processDesc;

    /** 设备分组 */
    @Excel(name = "设备类型")
    private String deviceGroup;

    /** bom内码 */
    @Excel(name = "bom内码")
    private Long customerId;
    /**
     * 版本号
     */
    @Excel(name = "版本号")
    private String version;

    /**
     * 设备类型名称
     */
    @Excel(name = "设备类型名称")
    private String deviceTypeName;

    /**
     * 设备组名称
     */
    @Excel(name = "设备组名称")
    private String deviceGroupName;

    /**
     * 设备名称
     */
    @Excel(name = "设备名称号")
    private String deviceName;

    private List<BaseBomFeedingVo> bomFeedingVos;
    private List<BaseBomProcessparmVo> bomProcessparmVos;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setBomNo(String bomNo)
    {
        this.bomNo = bomNo;
    }

    public String getBomNo()
    {
        return bomNo;
    }
    public void setBomCode(String bomCode)
    {
        this.bomCode = bomCode;
    }

    public String getBomCode()
    {
        return bomCode;
    }
    public void setStepSort(Integer stepSort)
    {
        this.stepSort = stepSort;
    }

    public Integer getStepSort()
    {
        return stepSort;
    }
    public void setProcessName(String processName)
    {
        this.processName = processName;
    }

    public String getProcessName()
    {
        return processName;
    }
    public void setDeviceCode(String deviceCode)
    {
        this.deviceCode = deviceCode;
    }

    public String getDeviceCode()
    {
        return deviceCode;
    }
    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }

    public String getDeviceType()
    {
        return deviceType;
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
            .append("bomNo", getBomNo())
            .append("bomCode", getBomCode())
            .append("stepSort", getStepSort())
            .append("processName", getProcessName())
            .append("deviceCode", getDeviceCode())
            .append("deviceGroup", getDeviceGroup())
            .append("deviceType", getDeviceType())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }

    public Long getBomId() {
        return bomId;
    }

    public void setBomId(Long bomId) {
        this.bomId = bomId;
    }

    public String getDeviceGroup() {
        return deviceGroup;
    }

    public void setDeviceGroup(String deviceGroup) {
        this.deviceGroup = deviceGroup;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getProcessDesc() {
        return processDesc;
    }

    public void setProcessDesc(String processDesc) {
        this.processDesc = processDesc;
    }

    public List<BaseBomFeedingVo> getBomFeedingVos() {
        return bomFeedingVos;
    }

    public void setBomFeedingVos(List<BaseBomFeedingVo> bomFeedingVos) {
        this.bomFeedingVos = bomFeedingVos;
    }

    public List<BaseBomProcessparmVo> getBomProcessparmVos() {
        return bomProcessparmVos;
    }

    public void setBomProcessparmVos(List<BaseBomProcessparmVo> bomProcessparmVos) {
        this.bomProcessparmVos = bomProcessparmVos;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceGroupName() {
        return deviceGroupName;
    }

    public void setDeviceGroupName(String deviceGroupName) {
        this.deviceGroupName = deviceGroupName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
