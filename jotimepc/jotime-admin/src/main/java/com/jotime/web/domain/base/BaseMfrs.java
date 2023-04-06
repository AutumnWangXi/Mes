package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 制造商对象 base_mfrs
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
public class BaseMfrs extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Long id;

    /** 制造厂商编码 */
    @Excel(name = "制造厂商编码")
    private String mfrsCode;

    /** 制造厂商名称 */
    @Excel(name = "制造厂商名称")
    private String mfrsName;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contactPerson;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactTelephone;

    /** 状态 1 禁用 2正常 */
    @Excel(name = "状态 1 禁用 2正常")
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
    public void setMfrsCode(String mfrsCode) 
    {
        this.mfrsCode = mfrsCode;
    }

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
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setContactPerson(String contactPerson) 
    {
        this.contactPerson = contactPerson;
    }

    public String getContactPerson() 
    {
        return contactPerson;
    }
    public void setContactTelephone(String contactTelephone) 
    {
        this.contactTelephone = contactTelephone;
    }

    public String getContactTelephone() 
    {
        return contactTelephone;
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
            .append("mfrsCode", getMfrsCode())
            .append("mfrsName", getMfrsName())
            .append("address", getAddress())
            .append("contactPerson", getContactPerson())
            .append("contactTelephone", getContactTelephone())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
