package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 仓库列对象 base_warehouse
 * 
 * @author ruoyi
 * @date 2022-01-16
 */
public class BaseWarehouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 仓库id */
    private Long id;

    /** 仓库编码 */
    @Excel(name = "仓库编码")
    private String whCode;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String whName;

    /** 仓库地址 */
    @Excel(name = "仓库地址")
    private String whAddress;

    /** 仓库管理员 */
    @Excel(name = "仓库管理员")
    private String storekeeper;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contactPerson;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private Long contactTelephone;

    /** 状态 0  禁用 1启用 */
    @Excel(name = "状态 0  禁用 1启用")
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
    public void setWhCode(String whCode) 
    {
        this.whCode = whCode;
    }

    public String getWhCode() 
    {
        return whCode;
    }
    public void setWhName(String whName) 
    {
        this.whName = whName;
    }

    public String getWhName() 
    {
        return whName;
    }
    public void setWhAddress(String whAddress) 
    {
        this.whAddress = whAddress;
    }

    public String getWhAddress() 
    {
        return whAddress;
    }
    public void setStorekeeper(String storekeeper) 
    {
        this.storekeeper = storekeeper;
    }

    public String getStorekeeper() 
    {
        return storekeeper;
    }
    public void setContactPerson(String contactPerson) 
    {
        this.contactPerson = contactPerson;
    }

    public String getContactPerson() 
    {
        return contactPerson;
    }
    public void setContactTelephone(Long contactTelephone) 
    {
        this.contactTelephone = contactTelephone;
    }

    public Long getContactTelephone() 
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
            .append("whCode", getWhCode())
            .append("whName", getWhName())
            .append("whAddress", getWhAddress())
            .append("storekeeper", getStorekeeper())
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
