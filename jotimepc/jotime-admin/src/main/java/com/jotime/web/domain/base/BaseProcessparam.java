package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 设备工艺参数对象 base_processparam
 *
 * @author ruoyi
 * @date 2022-03-18
 */
public class BaseProcessparam extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Integer id;

    /** 工艺参数值 */
    @Excel(name = "工艺参数值")
    private String paramValue;

    /** 工艺参数名称 */
    @Excel(name = "工艺参数名称")
    private String paramName;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 排序 */
    @Excel(name = "排序")
    private Integer paramSort;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setParamValue(String paramValue)
    {
        this.paramValue = paramValue;
    }

    public String getParamValue()
    {
        return paramValue;
    }
    public void setParamName(String paramName)
    {
        this.paramName = paramName;
    }

    public String getParamName()
    {
        return paramName;
    }
    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getUnit()
    {
        return unit;
    }
    public void setParamSort(Integer paramSort)
    {
        this.paramSort = paramSort;
    }

    public Integer getParamSort()
    {
        return paramSort;
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
            .append("paramValue", getParamValue())
            .append("paramName", getParamName())
            .append("unit", getUnit())
            .append("paramSort", getParamSort())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
