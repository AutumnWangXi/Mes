package com.jotime.web.domain.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.constant.SupplierConstants;
import com.jotime.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 供应商对象 base_supplier
 *
 * @author ruoyi
 * @date 2021-12-30
 */
public class BaseSupplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 供应商内码 */
    private Long id;

    /** 供应商编码 */
    @Excel(name = "供应商编码")
    private String supplierCode;

    /** 供应商名字 */
    @Excel(name = "公司名称")
    private String supplierName;

    /** 地址 */
    @Excel(name = "公司地址")
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
    @Excel(name = "开户帐号")
    private String caccountNumber;




    /** 联系人 */
    @Excel(name = "业务联系人")
    private String contactPerson;

    /** 联系人手机 */
    @Excel(name = "业务联系电话")
    private String contactTelephone;
    /** 收件地址 */
    @Excel(name = "收件地址")
    private String recipientAddress;
    /** 账期 */
    @Excel(name = "账期")
    private String terms;
    /** 供应商等级 */
    @Excel(name = "供应商等级")
    private Integer supplierLevel;

    /** 供应商类型 */
    @Excel(name = "供应商类型",dictType = SupplierConstants.SYS_SUPPLIER_TYPE)
    private String supplierItemType;



    /** 供应产品名称，多类型使用逗号隔开 */
    @Excel(name = "供应产品名称，多类型使用逗号隔开",width = 40)
    private String supplyItemName;

    /** 审核状态1 待审核 2审核中  3 通过  9 驳回 */
//    @Excel(name = "审核状态1 待审核 2审核中  3 通过  9 驳回")
    private String checkStatus;

    /** 审核人编号 */
//    @Excel(name = "审核人编号")
    private Long checkId;

    /** 审核人姓名 */
//    @Excel(name = "审核人姓名")
    private String checker;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkTime;

    /** 审核备注 */
//    @Excel(name = "审核备注")
    private String checkNote;

    /** 状态 1 禁用 2正常 */
//    @Excel(name = "状态 1 禁用 2正常")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 营业执照号码 */
    @Excel(name = "营业执照号码")
    private String businessLicense;

    /** 法人代表 */
    @Excel(name = "法人代表")
    private String legalRepresentative;

    /** 联系人邮箱 */
    @Excel(name = "联系人邮箱")
    private String contactMail;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setSupplierCode(String supplierCode)
    {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCode()
    {
        return supplierCode;
    }
    public void setSupplierName(String supplierName)
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName()
    {
        return supplierName;
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
    public void setSupplierItemType(String supplierItemType)
    {
        this.supplierItemType = supplierItemType;
    }

    public String getSupplierItemType()
    {
        return supplierItemType;
    }
    public void setSupplierLevel(Integer supplierLevel)
    {
        this.supplierLevel = supplierLevel;
    }

    public Integer getSupplierLevel()
    {
        return supplierLevel;
    }
    public void setSupplyItemName(String supplyItemName)
    {
        this.supplyItemName = supplyItemName;
    }

    public String getSupplyItemName()
    {
        return supplyItemName;
    }
    public void setCheckStatus(String checkStatus)
    {
        this.checkStatus = checkStatus;
    }

    public String getCheckStatus()
    {
        return checkStatus;
    }
    public void setCheckId(Long checkId)
    {
        this.checkId = checkId;
    }

    public Long getCheckId()
    {
        return checkId;
    }
    public void setChecker(String checker)
    {
        this.checker = checker;
    }

    public String getChecker()
    {
        return checker;
    }
    public void setCheckTime(Date checkTime)
    {
        this.checkTime = checkTime;
    }

    public Date getCheckTime()
    {
        return checkTime;
    }
    public void setCheckNote(String checkNote)
    {
        this.checkNote = checkNote;
    }

    public String getCheckNote()
    {
        return checkNote;
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

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    @Override
    public String toString() {
        return "BaseSupplier{" +
                "id=" + id +
                ", supplierCode='" + supplierCode + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", address='" + address + '\'' +
                ", companyTelephone='" + companyTelephone + '\'' +
                ", tin='" + tin + '\'' +
                ", bankName='" + bankName + '\'' +
                ", caccountNumber='" + caccountNumber + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", contactTelephone='" + contactTelephone + '\'' +
                ", recipientAddress='" + recipientAddress + '\'' +
                ", terms='" + terms + '\'' +
                ", supplierLevel=" + supplierLevel +
                ", supplierItemType='" + supplierItemType + '\'' +
                ", supplyItemName='" + supplyItemName + '\'' +
                ", checkStatus='" + checkStatus + '\'' +
                ", checkId=" + checkId +
                ", checker='" + checker + '\'' +
                ", checkTime=" + checkTime +
                ", checkNote='" + checkNote + '\'' +
                ", status=" + status +
                ", note='" + note + '\'' +
                ", businessLicense='" + businessLicense + '\'' +
                ", legalRepresentative='" + legalRepresentative + '\'' +
                ", contactMail='" + contactMail + '\'' +
                '}';
    }
}
