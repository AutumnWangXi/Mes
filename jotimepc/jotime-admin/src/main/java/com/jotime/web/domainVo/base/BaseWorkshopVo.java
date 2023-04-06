package com.jotime.web.domainVo.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 车间对象 base_workshop
 *
 * @author ruoyi
 * @date 2021-12-31
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseWorkshopVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Long id;

    /** 车间名称 */
    @Excel(name = "车间名称")
    private String workshopName;
    /** 车间编码 */
    @Excel(name = "车间编码")
    private String workshopCode;

    /** 部门内码 */
    @Excel(name = "部门内码")
    private Long deptId;

    /** 部门名称 */
    @TableField(exist = false)
    private String deptName;

    /**
     * 任务数量
     */
    @TableField(exist = false)
    private Integer taskCount;

    /** 负责人内码 */
    @Excel(name = "负责人内码")
    private Long leaderId;

    /** 负责人名称 */
    @TableField(exist = false)
    private String leaderName;

    /** 产能 */
    @Excel(name = "产能")
    private BigDecimal productivity;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 车间描述 */
    @Excel(name = "车间描述")
    private String description;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 角色id，多个逗号隔开 */
    private String roleId;

    /** 角色名字，多个逗号隔开 */
    private String roleName;

    /** 车间类型01内料生产车间 02半成品生产车间 99其他 */
    private String workshopType;

    public String getWorkshopType() {
        return workshopType;
    }

    public void setWorkshopType(String workshopType) {
        this.workshopType = workshopType;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(Integer taskCount) {
        this.taskCount = taskCount;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setWorkshopName(String workshopName)
    {
        this.workshopName = workshopName;
    }

    public String getWorkshopName()
    {
        return workshopName;
    }
    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public String getWorkshopCode() {
        return workshopCode;
    }

    public void setWorkshopCode(String workshopCode) {
        this.workshopCode = workshopCode;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setLeaderId(Long leaderId)
    {
        this.leaderId = leaderId;
    }

    public Long getLeaderId()
    {
        return leaderId;
    }
    public void setProductivity(BigDecimal productivity)
    {
        this.productivity = productivity;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public BigDecimal getProductivity()
    {
        return productivity;
    }
    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getUnit()
    {
        return unit;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("workshopName", getWorkshopName())
            .append("workshopCode", getWorkshopCode())
            .append("deptId", getDeptId())
            .append("leaderId", getLeaderId())
            .append("productivity", getProductivity())
            .append("unit", getUnit())
            .append("description", getDescription())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
