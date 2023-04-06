package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 安全性风险物质危害识别对象 base_risk_substances
 *
 * @author yunmoqian
 * @date 2022-04-21
 */
public class BaseRiskSubstances extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Long id;

    /** 中文名称 */
    @Excel(name = "中文名称",width = 24,height = 50)
    private String inciNameCn;

    /** INCI名称/英文名称 */
    @Excel(name = "INCI名称/英文名称",width = 24,height = 50)
    private String inciNameEn;

    /** 风险物质 */
    @Excel(name = "风险物质",width = 20,height = 50)
    private String riskSubstances;

    /** 描述说明 */
    @Excel(name = "描述说明",width = 130,height = 50,align = Excel.Align.CENTER)
    private String description;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setInciNameCn(String inciNameCn)
    {
        this.inciNameCn = inciNameCn;
    }

    public String getInciNameCn()
    {
        return inciNameCn;
    }
    public void setInciNameEn(String inciNameEn)
    {
        this.inciNameEn = inciNameEn;
    }

    public String getInciNameEn()
    {
        return inciNameEn;
    }
    public void setRiskSubstances(String riskSubstances)
    {
        this.riskSubstances = riskSubstances;
    }

    public String getRiskSubstances()
    {
        return riskSubstances;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("inciNameCn", getInciNameCn())
            .append("inciNameEn", getInciNameEn())
            .append("riskSubstances", getRiskSubstances())
            .append("description", getDescription())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
