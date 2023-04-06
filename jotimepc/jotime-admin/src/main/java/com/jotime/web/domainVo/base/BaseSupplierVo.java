package com.jotime.web.domainVo.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 供应商对象 base_supplier
 * 
 * @author ruoyi
 * @date 2021-07-08
 */
public class BaseSupplierVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 供应商id */
    @Excel(name = "供应商id")
    private String supplierId;

    /** 供应商名字 */
    @Excel(name = "供应商名字")
    private String supplierName;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contacts;

    /** 联系人手机 */
    @Excel(name = "联系人手机")
    private String phone;

    /** 供应商类型 */
    @Excel(name = "供应商类型")
    private String supplierType;

    /** 供应商等级 */
    @Excel(name = "供应商等级")
    private String supplierLevel;

    /** 供应名称 */
    @Excel(name = "供应名称")
    private String materialType;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 审核状态 0:代审核  1：通过 2：驳回 */
    @Excel(name = "审核状态 0:代审核  1：通过 2：驳回")
    private String status;

    /** 审核人 */
    @Excel(name = "审核人")
    private String approveUser;

    /** 审核人姓名 */
    @Excel(name = "审核人姓名")
    private String approveUserName;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核人姓名", width = 30, dateFormat = "yyyy-MM-dd")
    private Date approveDate;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 创建人id */
    @Excel(name = "创建人id")
    private String creatorId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSupplierId(String supplierId) 
    {
        this.supplierId = supplierId;
    }

    public String getSupplierId() 
    {
        return supplierId;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setContacts(String contacts) 
    {
        this.contacts = contacts;
    }

    public String getContacts() 
    {
        return contacts;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setSupplierType(String supplierType) 
    {
        this.supplierType = supplierType;
    }

    public String getSupplierType() 
    {
        return supplierType;
    }
    public void setSupplierLevel(String supplierLevel) 
    {
        this.supplierLevel = supplierLevel;
    }

    public String getSupplierLevel() 
    {
        return supplierLevel;
    }
    public void setMaterialType(String materialType) 
    {
        this.materialType = materialType;
    }

    public String getMaterialType() 
    {
        return materialType;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setApproveUser(String approveUser) 
    {
        this.approveUser = approveUser;
    }

    public String getApproveUser() 
    {
        return approveUser;
    }
    public void setApproveUserName(String approveUserName) 
    {
        this.approveUserName = approveUserName;
    }

    public String getApproveUserName() 
    {
        return approveUserName;
    }
    public void setApproveDate(Date approveDate) 
    {
        this.approveDate = approveDate;
    }

    public Date getApproveDate() 
    {
        return approveDate;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setCreatorId(String creatorId) 
    {
        this.creatorId = creatorId;
    }

    public String getCreatorId() 
    {
        return creatorId;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("supplierId", getSupplierId())
            .append("supplierName", getSupplierName())
            .append("contacts", getContacts())
            .append("phone", getPhone())
            .append("supplierType", getSupplierType())
            .append("supplierLevel", getSupplierLevel())
            .append("materialType", getMaterialType())
            .append("creator", getCreator())
            .append("status", getStatus())
            .append("approveUser", getApproveUser())
            .append("approveUserName", getApproveUserName())
            .append("approveDate", getApproveDate())
            .append("remarks", getRemarks())
            .append("creatorId", getCreatorId())
            .append("createDate", getCreateDate())
            .toString();
    }
}
