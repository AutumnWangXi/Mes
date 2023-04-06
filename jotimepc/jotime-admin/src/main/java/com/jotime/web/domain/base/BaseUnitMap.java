package com.jotime.web.domain.base;

import java.math.BigDecimal;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 单位转换对象 base_unit_map
 * 
 * @author ruoyi
 * @date 2021-12-31
 */
public class BaseUnitMap extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Long id;

    /** 输入单位名称 */
    @Excel(name = "输入单位名称")
    private String fromUnitName;

    /** 输出单位内码 */
    @Excel(name = "输出单位内码")
    private Long toUnitId;

    /** 输出单位名称 */
    @Excel(name = "输出单位名称")
    private String toUnitName;

    /** 转换比例 */
    @Excel(name = "转换比例")
    private BigDecimal discount;

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
    public void setFromUnitName(String fromUnitName) 
    {
        this.fromUnitName = fromUnitName;
    }

    public String getFromUnitName() 
    {
        return fromUnitName;
    }
    public void setToUnitId(Long toUnitId) 
    {
        this.toUnitId = toUnitId;
    }

    public Long getToUnitId() 
    {
        return toUnitId;
    }
    public void setToUnitName(String toUnitName) 
    {
        this.toUnitName = toUnitName;
    }

    public String getToUnitName() 
    {
        return toUnitName;
    }
    public void setDiscount(BigDecimal discount) 
    {
        this.discount = discount;
    }

    public BigDecimal getDiscount() 
    {
        return discount;
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
            .append("fromUnitName", getFromUnitName())
            .append("toUnitId", getToUnitId())
            .append("toUnitName", getToUnitName())
            .append("discount", getDiscount())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
