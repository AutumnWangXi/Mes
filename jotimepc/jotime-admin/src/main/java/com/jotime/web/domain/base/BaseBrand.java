package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 base_brand
 * 
 * @author ruoyi
 * @date 2022-01-04
 */
public class BaseBrand extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 品牌内码 */
    private Long id;

    /** 品牌名 */
    @Excel(name = "品牌名")
    private String brandName;

    /** 生产商内码 */
    @Excel(name = "生产商内码")
    private Long mfrsId;

    /** 生产商内码 */
    @Excel(name = "生产商編碼")
    private String mfrsCode;

    /** 生产商内码 */
    @Excel(name = "生产商名")
    private String mfrsName;

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
    public void setBrandName(String brandName) 
    {
        this.brandName = brandName;
    }

    public String getBrandName() 
    {
        return brandName;
    }
    public void setMfrsCode(String mfrsCode) { this.mfrsCode = mfrsCode;}

    public String getMfrsCode()
    {
        return mfrsCode;
    }
    public void setMfrsName(String mfrsName)
    {
        this.mfrsName = mfrsName;
    }

    public String getMfrsName()
    {
        return mfrsName;
    }
    public void setMfrsId(Long mfrsId)
    {
        this.mfrsId = mfrsId;
    }

    public Long getMfrsId()
    {
        return mfrsId;
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
            .append("brandName", getBrandName())
            .append("mfrsId", getMfrsId())
            .append("mfrsId", getMfrsCode())
            .append("mfrsId", getMfrsName())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
