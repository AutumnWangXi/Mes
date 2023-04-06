package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 base_categorydtl
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
public class BaseCategorydtl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Long id;

    /** 类别编码 */
    @Excel(name = "类别编码")
    private String categoryCode;

    /** 类别值 */
    @Excel(name = "类别值")
    private String categoryValue;

    /** 类别显示内容 */
    @Excel(name = "类别显示内容")
    private String categoryLable;

    /** 排序 */
    @Excel(name = "排序")
    private Integer categorySort;

    /** 状态 1 禁用 2 正常 */
    @Excel(name = "状态 1 禁用 2 正常")
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
    public void setCategoryCode(String categoryCode) 
    {
        this.categoryCode = categoryCode;
    }

    public String getCategoryCode() 
    {
        return categoryCode;
    }
    public void setCategoryValue(String categoryValue) 
    {
        this.categoryValue = categoryValue;
    }

    public String getCategoryValue() 
    {
        return categoryValue;
    }
    public void setCategoryLable(String categoryLable) 
    {
        this.categoryLable = categoryLable;
    }

    public String getCategoryLable() 
    {
        return categoryLable;
    }
    public void setCategorySort(Integer categorySort) 
    {
        this.categorySort = categorySort;
    }

    public Integer getCategorySort() 
    {
        return categorySort;
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
            .append("categoryCode", getCategoryCode())
            .append("categoryValue", getCategoryValue())
            .append("categoryLable", getCategoryLable())
            .append("categorySort", getCategorySort())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
