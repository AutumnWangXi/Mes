package com.jotime.web.domainVo.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 国外客户对象 base_customers_foreign
 * 
 * @author ruoyi
 * @date 2021-07-08
 */
public class BaseCustomersForeignVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 客户id */
    @Excel(name = "客户id")
    private String customerId;

    /** 客户名称（公司名称） */
    @Excel(name = "客户名称", readConverterExp = "公=司名称")
    private String customerName;

    /** 联系人姓名 */
    @Excel(name = "联系人姓名")
    private String contactsName;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String contactsPhone;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** $column.columnComment */
    @Excel(name = "地址")
    private String email;

    /** 客户类型 */
    @Excel(name = "客户类型")
    private String customerType;

    /** 付款方式 */
    @Excel(name = "付款方式")
    private String payMode;

    /** 客户需求 */
    @Excel(name = "客户需求")
    private String customerDemand;

    /** 业务联系概况 */
    @Excel(name = "业务联系概况")
    private String businessContactStatus;

    /** 业务类型 */
    @Excel(name = "业务类型")
    private String businessType;

    /** 客户品牌 */
    @Excel(name = "客户品牌")
    private String customerBrand;

    /** 主营产品 */
    @Excel(name = "主营产品")
    private String mainProducts;

    /** 销售渠道 */
    @Excel(name = "销售渠道")
    private String distributionChannel;

    /** 主要国别市场 */
    @Excel(name = "主要国别市场")
    private String bazaar;

    /** 年度销售额度(单位：美元） */
    @Excel(name = "年度销售额度(单位：美元）")
    private BigDecimal salesYear;

    /** 人员规模需求 */
    @Excel(name = "人员规模需求")
    private String staffSize;

    /** 客户等级 */
    @Excel(name = "客户等级")
    private String customerLevel;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 创建人id */
    @Excel(name = "创建人id")
    private String creatorId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
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
    public void setCustomerId(String customerId) 
    {
        this.customerId = customerId;
    }

    public String getCustomerId() 
    {
        return customerId;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setContactsName(String contactsName) 
    {
        this.contactsName = contactsName;
    }

    public String getContactsName() 
    {
        return contactsName;
    }
    public void setContactsPhone(String contactsPhone) 
    {
        this.contactsPhone = contactsPhone;
    }

    public String getContactsPhone() 
    {
        return contactsPhone;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setCustomerType(String customerType) 
    {
        this.customerType = customerType;
    }

    public String getCustomerType() 
    {
        return customerType;
    }
    public void setPayMode(String payMode) 
    {
        this.payMode = payMode;
    }

    public String getPayMode() 
    {
        return payMode;
    }
    public void setCustomerDemand(String customerDemand) 
    {
        this.customerDemand = customerDemand;
    }

    public String getCustomerDemand() 
    {
        return customerDemand;
    }
    public void setBusinessContactStatus(String businessContactStatus) 
    {
        this.businessContactStatus = businessContactStatus;
    }

    public String getBusinessContactStatus() 
    {
        return businessContactStatus;
    }
    public void setBusinessType(String businessType) 
    {
        this.businessType = businessType;
    }

    public String getBusinessType() 
    {
        return businessType;
    }
    public void setCustomerBrand(String customerBrand) 
    {
        this.customerBrand = customerBrand;
    }

    public String getCustomerBrand() 
    {
        return customerBrand;
    }
    public void setMainProducts(String mainProducts) 
    {
        this.mainProducts = mainProducts;
    }

    public String getMainProducts() 
    {
        return mainProducts;
    }
    public void setDistributionChannel(String distributionChannel) 
    {
        this.distributionChannel = distributionChannel;
    }

    public String getDistributionChannel() 
    {
        return distributionChannel;
    }
    public void setBazaar(String bazaar) 
    {
        this.bazaar = bazaar;
    }

    public String getBazaar() 
    {
        return bazaar;
    }
    public void setSalesYear(BigDecimal salesYear)
    {
        this.salesYear = salesYear;
    }

    public BigDecimal getSalesYear()
    {
        return salesYear;
    }
    public void setStaffSize(String staffSize) 
    {
        this.staffSize = staffSize;
    }

    public String getStaffSize() 
    {
        return staffSize;
    }
    public void setCustomerLevel(String customerLevel) 
    {
        this.customerLevel = customerLevel;
    }

    public String getCustomerLevel() 
    {
        return customerLevel;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
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
            .append("customerId", getCustomerId())
            .append("customerName", getCustomerName())
            .append("contactsName", getContactsName())
            .append("contactsPhone", getContactsPhone())
            .append("address", getAddress())
            .append("email", getEmail())
            .append("customerType", getCustomerType())
            .append("payMode", getPayMode())
            .append("customerDemand", getCustomerDemand())
            .append("businessContactStatus", getBusinessContactStatus())
            .append("businessType", getBusinessType())
            .append("customerBrand", getCustomerBrand())
            .append("mainProducts", getMainProducts())
            .append("distributionChannel", getDistributionChannel())
            .append("bazaar", getBazaar())
            .append("salesYear", getSalesYear())
            .append("staffSize", getStaffSize())
            .append("customerLevel", getCustomerLevel())
            .append("creator", getCreator())
            .append("creatorId", getCreatorId())
            .append("createDate", getCreateDate())
            .append("modifiedUser", getModifiedUser())
            .append("gmtModified", getGmtModified())
            .toString();
    }
}
