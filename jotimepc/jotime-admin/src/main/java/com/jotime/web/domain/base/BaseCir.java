package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 美国CIR审查安全使用的化妆品原料对象 base_cir
 *
 * @author yunmoqian
 * @date 2022-04-21
 */
public class BaseCir extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Long id;

    /** INCI名称/英文名称 */
    @Excel(name = "INCI名称/英文名称",width = 30)
    private String inciNameEn;

    /** 安全 */
    @Excel(name = "安全")
    private String safeNumber;

    /** 使用结论(中文) */
    @Excel(name = "使用结论(中文)",width = 50)
    private String usedConclusionCn;

    /** 使用结论(英文) */
    @Excel(name = "使用结论(英文)",width = 50)
    private String usedConclusionEn;



    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setInciNameEn(String inciNameEn)
    {
        this.inciNameEn = inciNameEn;
    }

    public String getInciNameEn()
    {
        return inciNameEn;
    }
    public void setUsedConclusionEn(String usedConclusionEn)
    {
        this.usedConclusionEn = usedConclusionEn;
    }

    public String getUsedConclusionEn()
    {
        return usedConclusionEn;
    }
    public void setUsedConclusionCn(String usedConclusionCn)
    {
        this.usedConclusionCn = usedConclusionCn;
    }

    public String getUsedConclusionCn()
    {
        return usedConclusionCn;
    }
    public void setSafeNumber(String safeNumber)
    {
        this.safeNumber = safeNumber;
    }

    public String getSafeNumber()
    {
        return safeNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("inciNameEn", getInciNameEn())
            .append("usedConclusionEn", getUsedConclusionEn())
            .append("usedConclusionCn", getUsedConclusionCn())
            .append("safeNumber", getSafeNumber())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
