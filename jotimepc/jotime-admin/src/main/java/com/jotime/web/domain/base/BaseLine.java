package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 流水线信息对象 base_line
 *
 * @author ruoyi
 * @date 2022-03-16
 */
public class BaseLine extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Long id;

    /** 流水线编码 */
    @Excel(name = "流水线编码")
    private String lineCode;

    /** 流水线名称 */
    @Excel(name = "流水线名称")
    private String lineName;

    /** 所属车间id */
    @Excel(name = "所属车间id")
    private String workshopId;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setLineCode(String lineCode)
    {
        this.lineCode = lineCode;
    }

    public String getLineCode()
    {
        return lineCode;
    }
    public void setLineName(String lineName)
    {
        this.lineName = lineName;
    }

    public String getLineName()
    {
        return lineName;
    }
    public void setWorkshopId(String workshopId)
    {
        this.workshopId = workshopId;
    }

    public String getWorkshopId()
    {
        return workshopId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("lineCode", getLineCode())
            .append("lineName", getLineName())
            .append("workshopId", getWorkshopId())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
