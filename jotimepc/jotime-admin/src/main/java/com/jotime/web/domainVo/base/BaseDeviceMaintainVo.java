package com.jotime.web.domainVo.base;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

/**
 * 设备保养对象 base_device_maintain
 * 
 * @author ruoyi
 * @date 2021-09-13
 */
public class BaseDeviceMaintainVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceId;

    /** 保养周期 */
    @Excel(name = "保养周期")
    private String maintenanceCycle;

    /** 最新保养时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最新保养时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date latestMaintenanceTime;

    /** 保养者 */
    @Excel(name = "保养者")
    private String maintainer;

    /** 创建者ID */
    @Excel(name = "创建者ID")
    private String creatorId;

    /** 创建者姓名 */
    @Excel(name = "创建者姓名")
    private String creatorName;

    /** 最新更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最新更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date gmtModified;

    /** 更新者 */
    @Excel(name = "更新者")
    private String modifiedUser;

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
    public void setMaintenanceCycle(String maintenanceCycle) 
    {
        this.maintenanceCycle = maintenanceCycle;
    }

    public String getMaintenanceCycle() 
    {
        return maintenanceCycle;
    }
    public void setLatestMaintenanceTime(Date latestMaintenanceTime) 
    {
        this.latestMaintenanceTime = latestMaintenanceTime;
    }

    public Date getLatestMaintenanceTime() 
    {
        return latestMaintenanceTime;
    }
    public void setMaintainer(String maintainer) 
    {
        this.maintainer = maintainer;
    }

    public String getMaintainer() 
    {
        return maintainer;
    }
    public void setCreatorId(String creatorId) 
    {
        this.creatorId = creatorId;
    }

    public String getCreatorId() 
    {
        return creatorId;
    }
    public void setCreatorName(String creatorName) 
    {
        this.creatorName = creatorName;
    }

    public String getCreatorName() 
    {
        return creatorName;
    }
    public void setGmtModified(Date gmtModified) 
    {
        this.gmtModified = gmtModified;
    }

    public Date getGmtModified() 
    {
        return gmtModified;
    }
    public void setModifiedUser(String modifiedUser) 
    {
        this.modifiedUser = modifiedUser;
    }

    public String getModifiedUser() 
    {
        return modifiedUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceId", getDeviceId())
            .append("maintenanceCycle", getMaintenanceCycle())
            .append("latestMaintenanceTime", getLatestMaintenanceTime())
            .append("maintainer", getMaintainer())
            .append("creatorId", getCreatorId())
            .append("creatorName", getCreatorName())
            .append("gmtModified", getGmtModified())
            .append("modifiedUser", getModifiedUser())
            .toString();
    }
}
