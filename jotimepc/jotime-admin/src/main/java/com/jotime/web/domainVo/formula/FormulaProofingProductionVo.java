package com.jotime.web.domainVo.formula;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 成熟配方对象 formula_proofing_production
 * 
 * @author ruoyi
 * @date 2021-07-16
 */
public class FormulaProofingProductionVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 客户编号 */
    @Excel(name = "客户编号")
    private String customerNumber;

    /** 产品编号 */
    @Excel(name = "产品编号")
    private String productNumber;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 产品类型 */
    @Excel(name = "产品类型")
    private String productType;

    /** 成熟配方id */
    @Excel(name = "成熟配方id")
    private String formulaId;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private String department;

    /** 适用车间  (下拉选择) */
    @Excel(name = "适用车间  (下拉选择)")
    private String applicableWorkshop;

    /** 类型  0：内料 1：预处理 2：其他 */
    @Excel(name = "类型  0：内料 1：预处理 2：其他")
    private String type;

    /** 审核人 */
    @Excel(name = "审核人")
    private String approveUser;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date approveDate;

    /** 创建者 */
    @Excel(name = "创建者")
    private String creator;

    /** 配创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "配创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 更新者 */
    @Excel(name = "更新者")
    private String modifiedUser;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date gmtModified;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCustomerNumber(String customerNumber) 
    {
        this.customerNumber = customerNumber;
    }

    public String getCustomerNumber() 
    {
        return customerNumber;
    }
    public void setProductNumber(String productNumber) 
    {
        this.productNumber = productNumber;
    }

    public String getProductNumber() 
    {
        return productNumber;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setProductType(String productType) 
    {
        this.productType = productType;
    }

    public String getProductType() 
    {
        return productType;
    }
    public void setFormulaId(String formulaId) 
    {
        this.formulaId = formulaId;
    }

    public String getFormulaId() 
    {
        return formulaId;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setApplicableWorkshop(String applicableWorkshop) 
    {
        this.applicableWorkshop = applicableWorkshop;
    }

    public String getApplicableWorkshop() 
    {
        return applicableWorkshop;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setApproveUser(String approveUser) 
    {
        this.approveUser = approveUser;
    }

    public String getApproveUser() 
    {
        return approveUser;
    }
    public void setApproveDate(Date approveDate) 
    {
        this.approveDate = approveDate;
    }

    public Date getApproveDate() 
    {
        return approveDate;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setModifiedUser(String modifiedUser) 
    {
        this.modifiedUser = modifiedUser;
    }

    public String getModifiedUser() 
    {
        return modifiedUser;
    }
    public void setGmtModified(Date gmtModified) 
    {
        this.gmtModified = gmtModified;
    }

    public Date getGmtModified() 
    {
        return gmtModified;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("customerNumber", getCustomerNumber())
            .append("productNumber", getProductNumber())
            .append("productName", getProductName())
            .append("productType", getProductType())
            .append("formulaId", getFormulaId())
            .append("department", getDepartment())
            .append("applicableWorkshop", getApplicableWorkshop())
            .append("type", getType())
            .append("approveUser", getApproveUser())
            .append("approveDate", getApproveDate())
            .append("creator", getCreator())
            .append("createDate", getCreateDate())
            .append("modifiedUser", getModifiedUser())
            .append("gmtModified", getGmtModified())
            .toString();
    }
}
