package com.jotime.web.domainVo.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 设备信息对象 base_device
 *
 * @author ruoyi
 * @date 2021-07-08
 */
public class BaseDeviceVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 设备id */
    @Excel(name = "设备id")
    private String deviceId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String name;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String type;

    /** 创建人员姓名 */
    @TableField(exist = false)
    private String creator;

    /** 维护周期 */
    @Excel(name = "维护周期")
    private String maintenanceCycle;

    /** 设备说明书 */
    @Excel(name = "设备说明书")
    private String content;

    /** 车间 */
    @TableField(exist = false)
    private String workshop;

    /** 保养日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "保养日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date maintenanceDate;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /**  创建人员id */
    @Excel(name = " 创建人员id")
    private String creatorId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
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
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setCreator(String creator)
    {
        this.creator = creator;
    }

    public String getCreator()
    {
        return creator;
    }
    public void setMaintenanceCycle(String maintenanceCycle)
    {
        this.maintenanceCycle = maintenanceCycle;
    }

    public String getMaintenanceCycle()
    {
        return maintenanceCycle;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setWorkshop(String workshop)
    {
        this.workshop = workshop;
    }

    public String getWorkshop()
    {
        return workshop;
    }
    public void setMaintenanceDate(Date maintenanceDate)
    {
        this.maintenanceDate = maintenanceDate;
    }

    public Date getMaintenanceDate()
    {
        return maintenanceDate;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setCreatorId(String creatorId)
    {
        this.creatorId = creatorId;
    }

    public String getCreatorId()
    {
        return creatorId;
    }
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public Date getCreateDate()
    {
        return createDate;
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
            .append("name", getName())
            .append("type", getType())
            .append("creator", getCreator())
            .append("maintenanceCycle", getMaintenanceCycle())
            .append("content", getContent())
            .append("workshop", getWorkshop())
            .append("maintenanceDate", getMaintenanceDate())
            .append("status", getStatus())
            .append("creatorId", getCreatorId())
            .append("createDate", getCreateDate())
            .append("gmtModified", getGmtModified())
            .append("modifiedUser", getModifiedUser())
            .toString();
    }
}
