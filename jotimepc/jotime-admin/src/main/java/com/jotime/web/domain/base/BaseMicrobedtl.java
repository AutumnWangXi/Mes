package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 微生物检测内容对象 base_microbedtl
 * 
 * @author yunmoqian
 * @date 2022-06-16
 */
public class BaseMicrobedtl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 微生物检测内码 */
    @Excel(name = "微生物检测内码")
    private Long microbeId;

    /** 判断方式 */
    @Excel(name = "判断方式")
    private Long judgmentMode;

    /** 标准值 */
    @Excel(name = "标准值")
    private String standardValue;

    /** 上浮值 */
    @Excel(name = "上浮值")
    private String upFloatingValue;

    /** 下浮值 */
    @Excel(name = "下浮值")
    private String downFloatingValue;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

    /** 检查项目 */
    @Excel(name = "检查项目")
    private String inspectItems;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMicrobeId(Long microbeId) 
    {
        this.microbeId = microbeId;
    }

    public Long getMicrobeId() 
    {
        return microbeId;
    }
    public void setJudgmentMode(Long judgmentMode) 
    {
        this.judgmentMode = judgmentMode;
    }

    public Long getJudgmentMode() 
    {
        return judgmentMode;
    }
    public void setStandardValue(String standardValue) 
    {
        this.standardValue = standardValue;
    }

    public String getStandardValue() 
    {
        return standardValue;
    }
    public void setUpFloatingValue(String upFloatingValue) 
    {
        this.upFloatingValue = upFloatingValue;
    }

    public String getUpFloatingValue() 
    {
        return upFloatingValue;
    }
    public void setDownFloatingValue(String downFloatingValue) 
    {
        this.downFloatingValue = downFloatingValue;
    }

    public String getDownFloatingValue() 
    {
        return downFloatingValue;
    }
    public void setSort(Integer sort) 
    {
        this.sort = sort;
    }

    public Integer getSort() 
    {
        return sort;
    }
    public void setInspectItems(String inspectItems) 
    {
        this.inspectItems = inspectItems;
    }

    public String getInspectItems() 
    {
        return inspectItems;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("microbeId", getMicrobeId())
            .append("judgmentMode", getJudgmentMode())
            .append("standardValue", getStandardValue())
            .append("upFloatingValue", getUpFloatingValue())
            .append("downFloatingValue", getDownFloatingValue())
            .append("sort", getSort())
            .append("inspectItems", getInspectItems())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
