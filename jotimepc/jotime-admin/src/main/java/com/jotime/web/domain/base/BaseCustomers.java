package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;


/**
 * 客户集合对象 base_customers
 *
 * @author ruoyi
 * @date 2021-12-27
 */
public class BaseCustomers extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户内码 */
    private Long id;

    /** 客户编号id */
    @Excel(name = "客户编号")
    private String customerCode;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 公司电话 */
    @Excel(name = "公司电话")
    private String companyTelephone;

    /** 纳税人识别号 */
    @Excel(name = "纳税人识别号")
    private String tin;

    /** 开户行 */
    @Excel(name = "开户行")
    private String bankName;

    /** 开户账号 */
    @Excel(name = "开户账号")
    private String caccountNumber;

    /** 收件地址 */
    @Excel(name = "收件地址")
    private String recipientAddress;

    /** 收货人 */
    @Excel(name = "收货人")
    private String consignee;

    /** 收货人联系电话 */
    @Excel(name = "收货人联系电话")
    private String consigneeTelephone;

    /** 收货地址 */
    @Excel(name = "收货地址")
    private String deliveryAddress;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contactPerson;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String contactTelephone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 付款方式 */
    @Excel(name = "付款方式")
    private Integer payType;

    /** 合作深度 */
    @Excel(name = "合作深度")
    private String cooperationDepth;

    /** 客户品牌 */
    @Excel(name = "客户品牌")
    private String customerBrand;

    /** 品牌地位 */
    @Excel(name = "品牌地位")
    private String brandStatus;

    /** 品类地位 */
    @Excel(name = "品类地位")
    private String categoryStatus;

    /** 客户等级 */
    @Excel(name = "客户等级")
    private Integer customerLevel;

    /**  销售模式 */
    @Excel(name = " 销售模式")
    private String salesModel;

    /** 天猫京东店铺链接 */
    @Excel(name = "天猫京东店铺链接")
    private String onlineShopAddress;

    /** 网上月销售表现 */
    @Excel(name = "网上月销售表现")
    private String onlineMonthlySales;

    /** 人员规模 */
    @Excel(name = "人员规模")
    private String staffSize;

    /** 销售规模 */
    @Excel(name = "销售规模")
    private String salesScale;

    /** 包材合作供应商,0:不是，1:是 */
    @Excel(name = "是否是包材合作供应商")
    private Integer packagingSupplier;

    /** 成品合作供应商，0 不是  1 是 */
    @Excel(name = "是否是成品合作供应商")
    private Integer completeSuppliers;

    /** 客户需求 */
    @Excel(name = "客户需求")
    private String customerDemand;

    /** 业务联系概况 */
    @Excel(name = "业务联系概况")
    private String businessContactOutline;

    /** 业务类型 */
    @Excel(name = "业务类型")
    private Integer businessType;

    /** 主营产品 */
    @Excel(name = "主营产品")
    private String mainProduct;

    /** 销售渠道 */
    @Excel(name = "销售渠道")
    private String distributionChannel;

    /** 主要国别市场 */
    @Excel(name = "主要国别市场")
    private String majorCountryMarkets;

    /** 年度销售额度(单位：美元） */
    @Excel(name = "年度销售额度(单位：美元）")
    private String salesYear;

    /** 客户星级评定 */
    @Excel(name = "客户星级评定")
    private Integer customerStarLevel;

    /** 1 国内客户  2 国外客户  9 不清楚 */
    @Excel(name = "客户类型")
    private Integer customerType;

    /** 1 新客户  2 重点老客户  3  非重点老客户 */
    @Excel(name = "客户种类")
    private Integer customerCategory;

    /** 创建人 */
    private String creator;


    /** 状态:0 禁用 1 正常 */
    @Excel(name = "状态")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCustomerCode(String customerCode)
    {
        this.customerCode = customerCode;
    }

    public String getCustomerCode()
    {
        return customerCode;
    }
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerName()
    {
        return customerName;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    public String getCompanyTelephone() {
        return companyTelephone;
    }

    public void setCompanyTelephone(String companyTelephone) {
        this.companyTelephone = companyTelephone;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCaccountNumber() {
        return caccountNumber;
    }

    public void setCaccountNumber(String caccountNumber) {
        this.caccountNumber = caccountNumber;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getConsigneeTelephone() {
        return consigneeTelephone;
    }

    public void setConsigneeTelephone(String consigneeTelephone) {
        this.consigneeTelephone = consigneeTelephone;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
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
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setPayType(Integer payType)
    {
        this.payType = payType;
    }

    public Integer getPayType()
    {
        return payType;
    }
    public void setCooperationDepth(String cooperationDepth)
    {
        this.cooperationDepth = cooperationDepth;
    }

    public String getCooperationDepth()
    {
        return cooperationDepth;
    }
    public void setCustomerBrand(String customerBrand)
    {
        this.customerBrand = customerBrand;
    }

    public String getCustomerBrand()
    {
        return customerBrand;
    }
    public void setBrandStatus(String brandStatus)
    {
        this.brandStatus = brandStatus;
    }

    public String getBrandStatus()
    {
        return brandStatus;
    }
    public void setCategoryStatus(String categoryStatus)
    {
        this.categoryStatus = categoryStatus;
    }

    public String getCategoryStatus()
    {
        return categoryStatus;
    }
    public void setCustomerLevel(Integer customerLevel)
    {
        this.customerLevel = customerLevel;
    }

    public Integer getCustomerLevel()
    {
        return customerLevel;
    }
    public void setSalesModel(String salesModel)
    {
        this.salesModel = salesModel;
    }

    public String getSalesModel()
    {
        return salesModel;
    }
    public void setOnlineShopAddress(String onlineShopAddress)
    {
        this.onlineShopAddress = onlineShopAddress;
    }

    public String getOnlineShopAddress()
    {
        return onlineShopAddress;
    }
    public void setOnlineMonthlySales(String onlineMonthlySales)
    {
        this.onlineMonthlySales = onlineMonthlySales;
    }

    public String getOnlineMonthlySales()
    {
        return onlineMonthlySales;
    }
    public void setStaffSize(String staffSize)
    {
        this.staffSize = staffSize;
    }

    public String getStaffSize()
    {
        return staffSize;
    }
    public void setSalesScale(String salesScale)
    {
        this.salesScale = salesScale;
    }

    public String getSalesScale()
    {
        return salesScale;
    }
    public void setPackagingSupplier(Integer packagingSupplier)
    {
        this.packagingSupplier = packagingSupplier;
    }

    public Integer getPackagingSupplier()
    {
        return packagingSupplier;
    }
    public void setCompleteSuppliers(Integer completeSuppliers)
    {
        this.completeSuppliers = completeSuppliers;
    }

    public Integer getCompleteSuppliers()
    {
        return completeSuppliers;
    }
    public void setCustomerDemand(String customerDemand)
    {
        this.customerDemand = customerDemand;
    }

    public String getCustomerDemand()
    {
        return customerDemand;
    }
    public void setBusinessContactOutline(String businessContactOutline)
    {
        this.businessContactOutline = businessContactOutline;
    }

    public String getBusinessContactOutline()
    {
        return businessContactOutline;
    }
    public void setBusinessType(Integer businessType)
    {
        this.businessType = businessType;
    }

    public Integer getBusinessType()
    {
        return businessType;
    }
    public void setMainProduct(String mainProduct)
    {
        this.mainProduct = mainProduct;
    }

    public String getMainProduct()
    {
        return mainProduct;
    }
    public void setDistributionChannel(String distributionChannel)
    {
        this.distributionChannel = distributionChannel;
    }

    public String getDistributionChannel()
    {
        return distributionChannel;
    }
    public void setMajorCountryMarkets(String majorCountryMarkets)
    {
        this.majorCountryMarkets = majorCountryMarkets;
    }

    public String getMajorCountryMarkets()
    {
        return majorCountryMarkets;
    }
    public void setSalesYear(String salesYear)
    {
        this.salesYear = salesYear;
    }

    public String getSalesYear()
    {
        return salesYear;
    }
    public void setCustomerStarLevel(Integer customerStarLevel)
    {
        this.customerStarLevel = customerStarLevel;
    }

    public Integer getCustomerStarLevel()
    {
        return customerStarLevel;
    }
    public void setCustomerType(Integer customerType)
    {
        this.customerType = customerType;
    }

    public Integer getCustomerType()
    {
        return customerType;
    }

    public Integer getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(Integer customerCategory) {
        this.customerCategory = customerCategory;
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
        return "BaseCustomers{" +
                "id=" + id +
                ", customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", companyTelephone='" + companyTelephone + '\'' +
                ", tin='" + tin + '\'' +
                ", bankName='" + bankName + '\'' +
                ", caccountNumber='" + caccountNumber + '\'' +
                ", recipientAddress='" + recipientAddress + '\'' +
                ", consignee='" + consignee + '\'' +
                ", consigneeTelephone='" + consigneeTelephone + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", contactTelephone='" + contactTelephone + '\'' +
                ", email='" + email + '\'' +
                ", payType=" + payType +
                ", cooperationDepth='" + cooperationDepth + '\'' +
                ", customerBrand='" + customerBrand + '\'' +
                ", brandStatus='" + brandStatus + '\'' +
                ", categoryStatus='" + categoryStatus + '\'' +
                ", customerLevel=" + customerLevel +
                ", salesModel='" + salesModel + '\'' +
                ", onlineShopAddress='" + onlineShopAddress + '\'' +
                ", onlineMonthlySales='" + onlineMonthlySales + '\'' +
                ", staffSize='" + staffSize + '\'' +
                ", salesScale='" + salesScale + '\'' +
                ", packagingSupplier=" + packagingSupplier +
                ", completeSuppliers=" + completeSuppliers +
                ", customerDemand='" + customerDemand + '\'' +
                ", businessContactOutline='" + businessContactOutline + '\'' +
                ", businessType=" + businessType +
                ", mainProduct='" + mainProduct + '\'' +
                ", distributionChannel='" + distributionChannel + '\'' +
                ", majorCountryMarkets='" + majorCountryMarkets + '\'' +
                ", salesYear='" + salesYear + '\'' +
                ", customerStarLevel=" + customerStarLevel +
                ", customerType=" + customerType +
                ", customerCategory='" + customerCategory + '\'' +
                ", creator='" + creator + '\'' +
                ", status=" + status +
                ", note='" + note + '\'' +
                '}';
    }
}
