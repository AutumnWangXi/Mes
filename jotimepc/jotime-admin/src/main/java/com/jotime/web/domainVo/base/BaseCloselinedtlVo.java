package com.jotime.web.domainVo.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 清线检查内容对象 base_closelinedtl
 *
 * @author ruoyi
 * @date 2022-03-04
 */
public class BaseCloselinedtlVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备清线信息明细内码 */
    private Long id;

    /** 清线检查信息内码 */
    @Excel(name = "清线检查信息内码")
    private Long closelineId;

    /** 判断方式 1 人工  2 自动 */
    @Excel(name = "判断方式 1 人工  2 自动")
    private Integer judgmentMode;

    /** 检查类型1 尺寸 2型号 性能 */
    @Excel(name = "检查类型1 尺寸 2型号 性能")
    private Integer inspectType;

    /** 标准值 */
    @Excel(name = "标准值")
    private BigDecimal standardValue;

    /** 上浮值 */
    @Excel(name = "上浮值")
    private BigDecimal upFloatingValue;

    /** 下浮值 */
    @Excel(name = "下浮值")
    private BigDecimal downFloatingValue;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

    /** 检查内容 */
    @Excel(name = "检查内容")
    private String inspectContent;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCloselineId(Long closelineId)
    {
        this.closelineId = closelineId;
    }

    public Long getCloselineId()
    {
        return closelineId;
    }
    public void setJudgmentMode(Integer judgmentMode)
    {
        this.judgmentMode = judgmentMode;
    }

    public Integer getJudgmentMode()
    {
        return judgmentMode;
    }
    public void setInspectType(Integer inspectType)
    {
        this.inspectType = inspectType;
    }

    public Integer getInspectType()
    {
        return inspectType;
    }
    public void setStandardValue(BigDecimal standardValue)
    {
        this.standardValue = standardValue;
    }

    public BigDecimal getStandardValue()
    {
        return standardValue;
    }
    public void setUpFloatingValue(BigDecimal upFloatingValue)
    {
        this.upFloatingValue = upFloatingValue;
    }

    public BigDecimal getUpFloatingValue()
    {
        return upFloatingValue;
    }
    public void setDownFloatingValue(BigDecimal downFloatingValue)
    {
        this.downFloatingValue = downFloatingValue;
    }

    public BigDecimal getDownFloatingValue()
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
    public void setInspectContent(String inspectContent)
    {
        this.inspectContent = inspectContent;
    }

    public String getInspectContent()
    {
        return inspectContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("closelineId", getCloselineId())
            .append("judgmentMode", getJudgmentMode())
            .append("inspectType", getInspectType())
            .append("standardValue", getStandardValue())
            .append("upFloatingValue", getUpFloatingValue())
            .append("downFloatingValue", getDownFloatingValue())
            .append("sort", getSort())
            .append("inspectContent", getInspectContent())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
