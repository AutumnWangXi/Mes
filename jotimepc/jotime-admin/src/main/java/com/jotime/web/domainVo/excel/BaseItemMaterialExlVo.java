package com.jotime.web.domainVo.excel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description: 表格导入，原料对象
 * @Author: YunFei
 * @Date: 2022/4/14 18:31
 */
public class BaseItemMaterialExlVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 物料id
     */
    private Long id;

    /**
     * 物料代码
     */
    @Excel(name = "原料编码")
    private String itemCode;

    /**
     * 物料名称
     */
    @Excel(name = "商品名")
    private String itemName;

    /**
     * 物料简称
     */
//    @Excel(name = "原料名")
    private String itemShortName;

//    /**
//     * 物料型号
//     */
//    @Excel(name = "物料型号")
//    private String itemSpecification;

    /**
     * 备注1
     */
    @Excel(name = "备注")
    private String note;

    /**
     * 配方备注配方用)
     */
    @Excel(name = "配方备注")
    private String bomNote;

    /**
     * 类别
     */
//    @Excel(name = "类别")
    private String categoryType;
    /** 俗称 */
//    @Excel(name = "俗称")
    private String vulgo;


    /**
     * 标准中文名
     */
    @Excel(name = "标准中文名")
    private String inciNameCn;

    /**
     * INCI名称（英文）
     */
    @Excel(name = "INCI名称（英文）")
    private String inciNameEn;
    /**
     * 含量%
     */
    @Excel(name = "含量%")
    private String content;

    /**
     * 属性
     */
    @Excel(name = "属性（原料使用目的）")
    private String property;

    /**
     * 属性
     */
    @Excel(name = "属性2（原料使用目的）")
    private String property2;

    /**
     * 生产商名称
     */
    @Excel(name = "生产商名称")
    private String manufacturerName;

    /**
     * 原料报送码
     */
    @Excel(name = "原料报送码")
    private String submissionCode;

    /**
     * CAS号
     */
    @Excel(name = "CAS号")
    private String casNo;
    /**
     * EINECS号
     */
    @Excel(name = "EINECS号")
    private String einecsNo;

    /**
     * 在2021年原料目录中的序号
     */
    @Excel(name = "在2021年原料目录中的序号",width = 30)
    private String serialNumber;

    /**
     * 供应商名称
     */
    @Excel(name = "供应商名称1")
    private String supplierName1;

    /**
     * 供应商名称
     */
    @Excel(name = "供应商名称2")
    private String supplierName2;

    /**
     * 供应商名称
     */
    @Excel(name = "供应商名称3")
    private String supplierName3;

    /**
     * 原产地
     */
    @Excel(name = "原产地")
    private String placeOrigin;

    /**
     * 有效期
     */
    @Excel(name = "有效期(单位：月)")
    private String effectiveMonth;


    /**
     * 储存条件
     */
    @Excel(name = "储存条件")
    private String storageCondition;
    /**
     * 紧急处理
     */
    @Excel(name = "紧急处理")
    private String firstAid;

    /**
     * 原料引入时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "原料引入时间(格式：yyyy-MM-dd)", width = 30, dateFormat = "yyyy-MM-dd")
    private Date IntroductionDate;
    /**
     * 熔点
     */
    @Excel(name = "熔点")
    private String meltingPoint;
    /**
     * 粒径（µm）
     */
    @Excel(name = "粒径（µm）")
    private String particleSize;
    /**
     * 常规包装
     */
    @Excel(name = "最小/常规包装")
    private String conventionalPacking;
    /**
     * 单价
     */
    @Excel(name = "单价")
    private BigDecimal price;
    /**
     * MSDS
     */
    @Excel(name = "MSDS")
    private String msds;
    /**
     * SPEC/COA
     */
    @Excel(name = "SPEC/COA")
    private String coa;
    /**
     * TDS
     */
    @Excel(name = "TDS")
    private String tds;
    /**
     * 非动物检测证明
     */
    @Excel(name = "非动物检测证明")
    private String nonAnimalTest;

    /** 过敏源信息 */
    @Excel(name = "过敏源信息")
    private String allergenInfo;
    /** IFRA证明文件 */
    @Excel(name = "IFRA证明文件")
    private String ifraFile;
    /** 其他资料 */
    @Excel(name = "其他资料")
    private String otherFile;
    /** 公司内部原料标准 */
    @Excel(name = "公司内部原料标准")
    private String companyStandards;

    /**
     * REACH号
     */
    @Excel(name = "REACH号")
    private String reachNo;
    /**
     * 来源
     */
    @Excel(name = "来源")
    private String origin;

    /**
     * 是否合并行
     */
    private boolean mergeFlag;


    /**
     * 供应商名称
     */
    private List<Long> supplierIds;
    private Long manufacturerId;

    public String getVulgo() {
        return vulgo;
    }

    public void setVulgo(String vulgo) {
        this.vulgo = vulgo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

//    public String getItemShortName() {
//        return itemShortName;
//    }
//
//    public void setItemShortName(String itemShortName) {
//        this.itemShortName = itemShortName;
//    }
//
    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getInciNameCn() {
        return inciNameCn;
    }

    public void setInciNameCn(String inciNameCn) {
        this.inciNameCn = inciNameCn;
    }

    public String getInciNameEn() {
        return inciNameEn;
    }

    public void setInciNameEn(String inciNameEn) {
        this.inciNameEn = inciNameEn;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCasNo() {
        return casNo;
    }

    public void setCasNo(String casNo) {
        this.casNo = casNo;
    }

    public String getEinecsNo() {
        return einecsNo;
    }

    public void setEinecsNo(String einecsNo) {
        this.einecsNo = einecsNo;
    }

    public String getItemShortName() {
        return itemShortName;
    }

    public void setItemShortName(String itemShortName) {
        this.itemShortName = itemShortName;
    }

    public String getBomNote() {
        return bomNote;
    }

    public void setBomNote(String bomNote) {
        this.bomNote = bomNote;
    }

    public String getSupplierName1() {
        return supplierName1;
    }

    public void setSupplierName1(String supplierName1) {
        this.supplierName1 = supplierName1;
    }

    public String getSupplierName2() {
        return supplierName2;
    }

    public void setSupplierName2(String supplierName2) {
        this.supplierName2 = supplierName2;
    }

    public String getSupplierName3() {
        return supplierName3;
    }

    public void setSupplierName3(String supplierName3) {
        this.supplierName3 = supplierName3;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

    public String getEffectiveMonth() {
        return effectiveMonth;
    }

    public void setEffectiveMonth(String effectiveMonth) {
        this.effectiveMonth = effectiveMonth;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public String getStorageCondition() {
        return storageCondition;
    }

    public void setStorageCondition(String storageCondition) {
        this.storageCondition = storageCondition;
    }

    public Date getIntroductionDate() {
        return IntroductionDate;
    }

    public void setIntroductionDate(Date introductionDate) {
        IntroductionDate = introductionDate;
    }

    public String getMeltingPoint() {
        return meltingPoint;
    }

    public void setMeltingPoint(String meltingPoint) {
        this.meltingPoint = meltingPoint;
    }

    public String getParticleSize() {
        return particleSize;
    }

    public void setParticleSize(String particleSize) {
        this.particleSize = particleSize;
    }

    public String getConventionalPacking() {
        return conventionalPacking;
    }

    public void setConventionalPacking(String conventionalPacking) {
        this.conventionalPacking = conventionalPacking;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getMsds() {
        return msds;
    }

    public void setMsds(String msds) {
        this.msds = msds;
    }

    public String getCoa() {
        return coa;
    }

    public void setCoa(String coa) {
        this.coa = coa;
    }

    public String getTds() {
        return tds;
    }

    public void setTds(String tds) {
        this.tds = tds;
    }

    public String getNonAnimalTest() {
        return nonAnimalTest;
    }

    public void setNonAnimalTest(String nonAnimalTest) {
        this.nonAnimalTest = nonAnimalTest;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSubmissionCode() {
        return submissionCode;
    }

    public void setSubmissionCode(String submissionCode) {
        this.submissionCode = submissionCode;
    }

    public String getReachNo() {
        return reachNo;
    }

    public void setReachNo(String reachNo) {
        this.reachNo = reachNo;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getFirstAid() {
        return firstAid;
    }

    public void setFirstAid(String firstAid) {
        this.firstAid = firstAid;
    }

    public String getAllergenInfo() {
        return allergenInfo;
    }

    public void setAllergenInfo(String allergenInfo) {
        this.allergenInfo = allergenInfo;
    }

    public String getIfraFile() {
        return ifraFile;
    }

    public void setIfraFile(String ifraFile) {
        this.ifraFile = ifraFile;
    }

    public String getOtherFile() {
        return otherFile;
    }

    public void setOtherFile(String otherFile) {
        this.otherFile = otherFile;
    }

    public String getCompanyStandards() {
        return companyStandards;
    }

    public void setCompanyStandards(String companyStandards) {
        this.companyStandards = companyStandards;
    }

    public List<Long> getSupplierIds() {
        return supplierIds;
    }

    public void setSupplierIds(List<Long> supplierIds) {
        this.supplierIds = supplierIds;
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public boolean getMergeFlag() {
        return mergeFlag;
    }

    public void setMergeFlag(boolean mergeFlag) {
        this.mergeFlag = mergeFlag;
    }
}
