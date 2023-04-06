package com.jotime.web.domainVo.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 班组人员管理对象 base_groupuser
 *
 * @author ruoyi
 * @date 2022-03-01
 */
public class BaseGroupuserVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 班组id */
    @Excel(name = "班组id")
    private String groupId;
    /** 班组名称 */
    @TableField(exist = false)
    private String groupName;
    /** 属于哪个车间：id */
    @Excel(name = "属于哪个车间：id")
    private String workshopId;
    /** 属于哪个车间：id */
    @TableField(exist = false)
    private String workshopName;

    /** 班组编码 */
    @Excel(name = "班组编码")
    private String groupCode;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 组员 */
    @Excel(name = "组员")
    private String userId;
    /** 组员名称 */
    @TableField(exist = false)
    private String userName;
    /** 组员编码 */
    @TableField(exist = false)
    private String userCode;
    /** 备注 */
    @Excel(name = "备注")
    private String note;


    /** 工作时长(H) */
    @Excel(name = "工作时长(H)")
    private BigDecimal workTime;
    /** 生产数量 */
    @Excel(name = "生产数量")
    private BigDecimal pdQty;

    public BigDecimal getWorkTime() {
        return workTime;
    }

    public void setWorkTime(BigDecimal workTime) {
        this.workTime = workTime;
    }

    public BigDecimal getPdQty() {
        return pdQty;
    }

    public void setPdQty(BigDecimal pdQty) {
        this.pdQty = pdQty;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }

    public String getGroupId()
    {
        return groupId;
    }
    public void setWorkshopId(String workshopId)
    {
        this.workshopId = workshopId;
    }

    public String getWorkshopId()
    {
        return workshopId;
    }
    public void setGroupCode(String groupCode)
    {
        this.groupCode = groupCode;
    }

    public String getGroupCode()
    {
        return groupCode;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserId()
    {
        return userId;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("groupId", getGroupId())
            .append("workshopId", getWorkshopId())
            .append("groupCode", getGroupCode())
            .append("status", getStatus())
            .append("userId", getUserId())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
