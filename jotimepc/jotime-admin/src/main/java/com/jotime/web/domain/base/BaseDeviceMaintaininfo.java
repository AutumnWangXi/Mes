package com.jotime.web.domain.base;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 设备保养信息对象 base_device_maintaininfo
 *
 * @author ruoyi
 * @date 2021-12-30
 */
public class  BaseDeviceMaintaininfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备保养内码 */
    private Long id;

    /** 设备编码 */
    @Excel(name = "设备编码")
    private String deviceCode;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String deviceType;

    /** 车间名 */
    @Excel(name = "车间名")
    private String workshopName;

    /** 最新保养时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最新保养时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date latestMaintenanceTime;

    /** 保养人员是否公司员工 */
    @Excel(name = "保养人员是否公司员工")
    private Integer isEeInfo;

    /** 保养人内码 */
    @Excel(name = "保养人内码")
    private Long maintenanceId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String maintainer;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    public void setId(Long id) { this.id = id; }

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

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public String getWorkshopName()
    {
        return workshopName;
    }
    public void setLatestMaintenanceTime(Date latestMaintenanceTime)
    {
        this.latestMaintenanceTime = latestMaintenanceTime;
    }

    public Date getLatestMaintenanceTime()
    {
        return latestMaintenanceTime;
    }
    public void setIsEeInfo(Integer isEeInfo)
    {
        this.isEeInfo = isEeInfo;
    }

    public Integer getIsEeInfo()
    {
        return isEeInfo;
    }
    public void setMaintenanceId(Long maintenanceId)
    {
        this.maintenanceId = maintenanceId;
    }

    public Long getMaintenanceId()
    {
        return maintenanceId;
    }
    public void setMaintainer(String maintainer)
    {
        this.maintainer = maintainer;
    }

    public String getMaintainer()
    {
        return maintainer;
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
            .append("deviceCode", getDeviceCode())
            .append("deviceName", getDeviceName())
            .append("deviceType", getDeviceType())
            .append("workshopName", getWorkshopName())
            .append("latestMaintenanceTime", getLatestMaintenanceTime())
            .append("isEeInfo", getIsEeInfo())
            .append("maintenanceId", getMaintenanceId())
            .append("maintainer", getMaintainer())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
