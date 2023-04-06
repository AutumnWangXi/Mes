package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * @Description: 已使用化妆品原料对象 base_cosmetic_material
 * @Author: YunFei
 * @Date: 2022/4/20 17:31
 */
public class BaseCosmeticMaterial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Long id;

    /** 序号 */
    @Excel(name = "序号")
    private String serialNumber;

    /** 化学名(中文) */
    @Excel(name = "化学名(中文)")
    private String inciNameCn;

    /** 化学名(英文) */
    @Excel(name = "化学名(英文)")
    private String inciNameEn;

    /** 淋洗类产品最高历史使用量（%） */
    @Excel(name = "淋洗类产品最高历史使用量", readConverterExp = "%=")
    private BigDecimal rinsingMaximumUsage;

    /** 驻留类产品最高历史使用量（%） */
    @Excel(name = "驻留类产品最高历史使用量", readConverterExp = "%=")
    private BigDecimal residentMaximumUsage;

    /** 成分安全分 */
    @Excel(name = "成分安全分")
    private String safetyScore;

    /** 致痘风险 */
    @Excel(name = "致痘风险")
    private String acneRisk;


    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    public String getSafetyScore() {
        return safetyScore;
    }

    public void setSafetyScore(String safetyScore) {
        this.safetyScore = safetyScore;
    }

    public String getAcneRisk() {
        return acneRisk;
    }

    public void setAcneRisk(String acneRisk) {
        this.acneRisk = acneRisk;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber()
    {
        return serialNumber;
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
    public void setRinsingMaximumUsage(BigDecimal rinsingMaximumUsage)
    {
        this.rinsingMaximumUsage = rinsingMaximumUsage;
    }

    public BigDecimal getRinsingMaximumUsage()
    {
        return rinsingMaximumUsage;
    }
    public void setResidentMaximumUsage(BigDecimal residentMaximumUsage)
    {
        this.residentMaximumUsage = residentMaximumUsage;
    }

    public BigDecimal getResidentMaximumUsage()
    {
        return residentMaximumUsage;
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
            .append("serialNumber", getSerialNumber())
            .append("inciNameCn", getInciNameCn())
            .append("inciNameEn", getInciNameEn())
            .append("rinsingMaximumUsage", getRinsingMaximumUsage())
            .append("residentMaximumUsage", getResidentMaximumUsage())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
