package com.jotime.web.domainVo.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import com.jotime.web.domain.base.BaseItemContent;
import com.jotime.web.domain.base.BaseItemNetcontent;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 物料对象 base_item
 *
 * @author ruoyi
 * @date 2021-12-28
 */
public class BaseItemVo extends BaseEntity {
    private static final long serialVersionUID = 1L;



    /**
     * 物料id
     */
    private Long id;

    /**
     * 物料代码
     */
    @Excel(name = "物料代码")
    private String itemCode;

    /**
     * 物料编号
     */
    @Excel(name = "物料编号")
    private String itemNo;

    /**
     * 物料名称
     */
    @Excel(name = "物料名称")
    private String itemName;

    /**
     * 物料简称
     */
    @Excel(name = "物料简称")
    private String itemShortName;

    /**
     * 物料型号
     */
    @Excel(name = "物料型号")
    private String itemSpecification;

    /**
     * 物料类型 1原料 2包材 3预处理料 4 内料 5 半成品 6成品5
     */
    @Excel(name = "物料类型 1原料 2包材 3预处理料 4 内料 5 半成品 6成品5")
    private Integer itemType;
    /**
     * 化妆品使用方法分类(成品用)01 淋洗类 02 驻留类
     */
    @Excel(name = "化妆品使用方法分类(成品用)01 淋洗类 02 驻留类")
    private String productUseMethods;

    /**
     * 类别
     */
    @Excel(name = "类别")
    private String categoryType;

    /**
     * 客户物料编码
     */
    @Excel(name = "客户物料编码")
    private String customerItemCode;

    /**
     * 客户名称
     */
    @Excel(name = "客户名称")
    private String customerName;


    /**
     * 物料类型(中)
     */
    @Excel(name = "物料类型(中)")
    private Integer mItemType;

    /**
     * 物料类型(小)
     */
    @Excel(name = "物料类型(小)")
    private Integer sItemType;

    /**
     * 色号
     */
    @Excel(name = "色号")
    private String colourNumber;

    /** 表现 */
    @Excel(name = "表现")
    private String appearance;

    /**
     * 规格
     */
    @Excel(name = "规格")
    private String specifications;

    /**
     * 单位
     */
    @Excel(name = "单位")
    private String unit;
    /**
     * 仓库库存单位
     */
    @Excel(name = "仓库库存单位")
    private String whStockUnit;
    /**
     * 转换比例(物料->库存)
     */
    @Excel(name = "转换比例(物料->库存)")
    private BigDecimal discount;

    /**
     * 品牌
     */
    @Excel(name = "品牌")
    private String brand;

    /**
     * 自主/oem/其他  1:自主 2：OEM 3： 其他
     */
    @Excel(name = "自主/oem/其他  1:自主 2：OEM 3： 其他")
    private Integer brandOwn;

    /**
     * 单价
     */
    @Excel(name = "单价")
    private BigDecimal price;
    /**
     * 单价
     */
    @Excel(name = "毛重")
    private BigDecimal tareWeight;

    /**
     * 单价
     */
    @Excel(name = "皮重")
    private BigDecimal grossWeight;

    /**
     * 净重
     */
    @Excel(name = "净重")
    private BigDecimal netWeight;


    /**
     * 美观线净含量
     */
    @Excel(name = "美观线净含量")
    private String lineNetWeight;

    /**
     * 标识净含量
     */
    @Excel(name = "标识净含量")
    private String identificationNetWeight;

    /**
     * 灌装量上限
     */
    @Excel(name = "灌装量上限")
    private String fillingVolumeUpper;

    /**
     * 灌装量下限
     */
    @Excel(name = "灌装量下限")
    private String fillingVolumeLower;

    /**
     * 灌装量单位
     */
    @Excel(name = "灌装量单位")
    private String fillingUnit;

    /**
     * 图片
     */
    @Excel(name = "图片")
    private String imageUrl;

    /**
     * 密度
     */
    @Excel(name = "密度")
    private BigDecimal density;

    /**
     * 成分百分比
     */
    @Excel(name = "成分百分比")
    private BigDecimal percentage;
    /** image_url */
    @Excel(name = "image_url")
    private String imageUrl2;

    /** 内包装图 */
    @Excel(name = "内包装图")
    private String innerImageUrl;


    /** 内包装图 */
    @Excel(name = "内包装图")
    private String innerImageUrl2;


    /** 描述 */
    @Excel(name = "描述")
    private String description;


    /** 净含量 */
    @Excel(name = "净含量")
    private Long netContent;
    /**
     * 条形码
     */
    @Excel(name = "条形码")
    private String barCode;

    /**
     * 客户ID
     */
    @Excel(name = "客户ID")
    private Long customerId;

    /**
     * 属性
     */
    @Excel(name = "属性")
    private String property;

    /**
     * 供应商
     */
    @Excel(name = "供应商")
    private Long supplierId;

    /**
     * 供应商
     */
    @Excel(name = "供应商名称")
    private String supplierName;

    /**
     * 制造厂商id
     */
    @Excel(name = "制造厂商id")
    private Long manufacturerId;

    /**
     * 制造厂商
     */
    @TableField(exist = false)
    @Excel(name = "制造厂商")
    private String manufacturerName;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;

    /**
     * 预警上限阈值
     */
    @Excel(name = "预警上限阈值")
    private Long warnToplimit;

    /**
     * 预警下限阈值
     */
    @Excel(name = "预警下限阈值")
    private Long warnLowerlimit;

    /**
     * 含量
     */
    @Excel(name = "含量")
    private String content;

    /**
     * 储存条件
     */
    @Excel(name = "储存条件")
    private String storageCondition;

    /**
     * 原产地
     */
    @Excel(name = "原产地")
    private String placeOrigin;

    /**
     * 引入条件
     */
    @Excel(name = "引入条件")
    private String introductionConditions;

    /**
     * 引入日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "引入日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date introductionDate;

    /**
     * 有效期
     */
    @Excel(name = "有效天数")
    private Integer effectiveDay;

    /**
     * 是否需要质检 1 不需要  2 需要
     */
    @Excel(name = "是否需要质检 1 不需要  2 需要")
    private Integer needQuality;

    /**
     * 是否需要扫码出库 1 不需要  2 需要
     */
    @Excel(name = "是否需要扫码出库 1 不需要  2 需要")
    private Integer needBarcodeStockout;

    /**
     * 是否需要称重 1 不需要  2 需要
     */
    @Excel(name = "是否需要称重 1 不需要  2 需要")
    private Integer needWeigh;

    /**
     * 是否保密 1 不需要  2 需要
     */
    @Excel(name = "是否保密 1 不需要  2 需要")
    private Integer needConfidential;
    /** 俗称 */
    @Excel(name = "俗称")
    private String vulgo;

    /** 熔点 */
    @Excel(name = "熔点")
    private String meltingPoint;

    /** 粒径（µm） */
    @Excel(name = "粒径", readConverterExp = "µ=m")
    private String particleSize;

    /** 常规包装 */
    @Excel(name = "常规包装")
    private String conventionalPacking;

    /** MSDS */
    @Excel(name = "MSDS")
    private List<String> msds;

    /** SPEC/COA */
    @Excel(name = "SPEC/COA")
    private List<String> coa;

    /** TDS */
    @Excel(name = "TDS")
    private List<String> tds;

    /** IFRA证明文件 */
    @Excel(name = "IFRA证明文件")
    private List<String> ifraFile;

    /** 非动物检测证明 */
    @Excel(name = "非动物检测证明")
    private List<String> nonAnimalTest;

    /** 过敏源信息 */
    @Excel(name = "过敏源信息")
    private List<String> allergenInfo;

    /** 原料附件14 */
    @Excel(name = "原料附件14")
    private List<String> attachmentUrl14;

    /** 其他资料 */
    @Excel(name = "其他资料")
    private List<String> otherFile;

    /** 公司内部原料标准 */
    @Excel(name = "公司内部原料标准")
    private List<String> companyStandards;

    /** 原料报送码 */
    @Excel(name = "原料报送码")
    private String submissionCode;

    /** REACH号 */
    @Excel(name = "REACH号")
    private String reachNo;

    /** 来源 */
    @Excel(name = "来源")
    private String origin;
    /** 紧急处理 */
    @Excel(name = "紧急处理")
    private String firstAid;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Integer status;

    /**
     * 页面名称
     */
    @Excel(name = "页面名称")
    private String pageName;
    /**
     * 备注
     */
    @Excel(name = "配方备注")
    private String bomNote;
    /**
     * 审核状态
     */
    @Excel(name = "审核状态")
    private Integer checkStatus;
    /**
     * 产品类型 1 一品一料 2 一品多料  3 套装
     */
    @Excel(name = "产品类型 1 一品一料 2 一品多料  3 套装")
    private Integer productType;

    @TableField(exist = false)
    private List<BaseItemContent> baseItemContents;

    @TableField(exist = false)
    private List<BaseItemNetcontent> baseItemNetContents;

    @TableField(exist = false)
    private List<BaseItemSupplierVo> baseItemSupplierS;

    /**
     * bom物料序号
     */
    private Integer itemSort;

    /**
     * 关联表数据的id，查询时可通过表名 和 id拿到具体的文件数据
     */
    @Excel(name = "关联表数据的id，查询时可通过表名 和 id拿到具体的文件数据")
    private Long uuId;

    /**
     * SS 自主 CS 客供 OTHER 其他
     */
    @Excel(name = "SS 自主 CS 客供 OTHER 其他")
    private String itemOwn;
    /** N 不报送 S 报送中 C 完成*/
    private String  submissionCodeSts;

    public String getSubmissionCodeSts() {
        return submissionCodeSts;
    }

    public void setSubmissionCodeSts(String submissionCodeSts) {
        this.submissionCodeSts = submissionCodeSts;
    }

    public List<BaseItemNetcontent> getBaseItemNetContents() {
        return baseItemNetContents;
    }

    public void setBaseItemNetContents(List<BaseItemNetcontent> baseItemNetContents) {
        this.baseItemNetContents = baseItemNetContents;
    }


    public String getItemOwn() {
        return itemOwn;
    }

    public void setItemOwn(String itemOwn) {
        this.itemOwn = itemOwn;
    }

    @Override
    public Integer getNeedConfidential() {
        return needConfidential;
    }

    @Override
    public void setNeedConfidential(Integer needConfidential) {
        this.needConfidential = needConfidential;
    }

    public Integer getItemSort() {
        return itemSort;
    }

    public void setItemSort(Integer itemSort) {
        this.itemSort = itemSort;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }


    public void setItemShortName(String itemShortName) {
        this.itemShortName = itemShortName;
    }

    public String getItemShortName() {
        return itemShortName;
    }

    public void setItemSpecification(String itemSpecification) {
        this.itemSpecification = itemSpecification;
    }

    public String getItemSpecification() {
        return itemSpecification;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCustomerItemCode(String customerItemCode) {
        this.customerItemCode = customerItemCode;
    }

    public String getCustomerItemCode() {
        return customerItemCode;
    }

    public void setmItemType(Integer mItemType) {
        this.mItemType = mItemType;
    }

    public Integer getmItemType() {
        return mItemType;
    }

    public void setsItemType(Integer sItemType) {
        this.sItemType = sItemType;
    }

    public Integer getsItemType() {
        return sItemType;
    }

    public void setColourNumber(String colourNumber) {
        this.colourNumber = colourNumber;
    }

    public String getColourNumber() {
        return colourNumber;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrandOwn(Integer brandOwn) {
        this.brandOwn = brandOwn;
    }

    public Integer getBrandOwn() {
        return brandOwn;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setLineNetWeight(String lineNetWeight) {
        this.lineNetWeight = lineNetWeight;
    }

    public String getLineNetWeight() {
        return lineNetWeight;
    }

    public void setIdentificationNetWeight(String identificationNetWeight) {
        this.identificationNetWeight = identificationNetWeight;
    }

    public String getIdentificationNetWeight() {
        return identificationNetWeight;
    }

    public void setFillingVolumeUpper(String fillingVolumeUpper) {
        this.fillingVolumeUpper = fillingVolumeUpper;
    }

    public String getFillingVolumeUpper() {
        return fillingVolumeUpper;
    }

    public void setFillingVolumeLower(String fillingVolumeLower) {
        this.fillingVolumeLower = fillingVolumeLower;
    }

    public String getFillingVolumeLower() {
        return fillingVolumeLower;
    }

    public void setFillingUnit(String fillingUnit) {
        this.fillingUnit = fillingUnit;
    }

    public String getFillingUnit() {
        return fillingUnit;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public BigDecimal getDensity() {
        return density;
    }

    public void setDensity(BigDecimal density) {
        this.density = density;
    }

    public String getImageUrl2() {
        return imageUrl2;
    }

    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }

    public String getInnerImageUrl() {
        return innerImageUrl;
    }

    public void setInnerImageUrl(String innerImageUrl) {
        this.innerImageUrl = innerImageUrl;
    }

    public String getInnerImageUrl2() {
        return innerImageUrl2;
    }

    public void setInnerImageUrl2(String innerImageUrl2) {
        this.innerImageUrl2 = innerImageUrl2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNetContent() {
        return netContent;
    }

    public void setNetContent(Long netContent) {
        this.netContent = netContent;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setWarnToplimit(Long warnToplimit) {
        this.warnToplimit = warnToplimit;
    }

    public Long getWarnToplimit() {
        return warnToplimit;
    }

    public void setWarnLowerlimit(Long warnLowerlimit) {
        this.warnLowerlimit = warnLowerlimit;
    }

    public Long getWarnLowerlimit() {
        return warnLowerlimit;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setStorageCondition(String storageCondition) {
        this.storageCondition = storageCondition;
    }

    public String getStorageCondition() {
        return storageCondition;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setIntroductionConditions(String introductionConditions) {
        this.introductionConditions = introductionConditions;
    }

    public String getIntroductionConditions() {
        return introductionConditions;
    }

    public void setIntroductionDate(Date introductionDate) {
        this.introductionDate = introductionDate;
    }

    public Date getIntroductionDate() {
        return introductionDate;
    }

    public void setValidDate(Integer effectiveDay) {
        this.effectiveDay = effectiveDay;
    }

    public Integer getValidDate() {
        return effectiveDay;
    }

    public void setNeedQuality(Integer needQuality) {
        this.needQuality = needQuality;
    }

    public Integer getNeedQuality() {
        return needQuality;
    }

    public void setNeedBarcodeStockout(Integer needBarcodeStockout) {
        this.needBarcodeStockout = needBarcodeStockout;
    }

    public Integer getNeedBarcodeStockout() {
        return needBarcodeStockout;
    }

    public void setNeedWeigh(Integer needWeigh) {
        this.needWeigh = needWeigh;
    }

    public Integer getNeedWeigh() {
        return needWeigh;
    }

    public void setVulgo(String vulgo)
    {
        this.vulgo = vulgo;
    }

    public String getVulgo()
    {
        return vulgo;
    }
    public void setMeltingPoint(String meltingPoint)
    {
        this.meltingPoint = meltingPoint;
    }

    public String getMeltingPoint()
    {
        return meltingPoint;
    }
    public void setParticleSize(String particleSize)
    {
        this.particleSize = particleSize;
    }

    public String getParticleSize()
    {
        return particleSize;
    }
    public void setConventionalPacking(String conventionalPacking)
    {
        this.conventionalPacking = conventionalPacking;
    }

    public String getConventionalPacking()
    {
        return conventionalPacking;
    }

    public void setSubmissionCode(String submissionCode)
    {
        this.submissionCode = submissionCode;
    }

    public String getSubmissionCode()
    {
        return submissionCode;
    }
    public void setReachNo(String reachNo)
    {
        this.reachNo = reachNo;
    }

    public String getReachNo()
    {
        return reachNo;
    }
    public void setOrigin(String origin)
    {
        this.origin = origin;
    }

    public String getOrigin()
    {
        return origin;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getProductType() {
        return productType;
    }

    public Integer getEffectiveDay() {
        return effectiveDay;
    }

    public void setEffectiveDay(Integer effectiveDay) {
        this.effectiveDay = effectiveDay;
    }
    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public List<BaseItemContent> getBaseItemContents() {
        return baseItemContents;
    }

    public void setBaseItemContents(List<BaseItemContent> baseItemContents) {
        this.baseItemContents = baseItemContents;
    }

    public BigDecimal getTareWeight() {
        return tareWeight;
    }

    public void setTareWeight(BigDecimal tareWeight) {
        this.tareWeight = tareWeight;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public String getWhStockUnit() {
        return whStockUnit;
    }

    public void setWhStockUnit(String whStockUnit) {
        this.whStockUnit = whStockUnit;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getProductUseMethods() {
        return productUseMethods;
    }

    public void setProductUseMethods(String productUseMethods) {
        this.productUseMethods = productUseMethods;
    }

    public String getFirstAid() {
        return firstAid;
    }

    public void setFirstAid(String firstAid) {
        this.firstAid = firstAid;
    }

    public String getBomNote() {
        return bomNote;
    }

    public void setBomNote(String bomNote) {
        this.bomNote = bomNote;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public List<BaseItemSupplierVo> getBaseItemSupplierS() {
        return baseItemSupplierS;
    }

    public void setBaseItemSupplierS(List<BaseItemSupplierVo> baseItemSupplierS) {
        this.baseItemSupplierS = baseItemSupplierS;
    }

    public List<String> getMsds() {
        return msds;
    }

    public void setMsds(List<String> msds) {
        this.msds = msds;
    }

    public List<String> getCoa() {
        return coa;
    }

    public void setCoa(List<String> coa) {
        this.coa = coa;
    }

    public List<String> getTds() {
        return tds;
    }

    public void setTds(List<String> tds) {
        this.tds = tds;
    }

    public List<String> getIfraFile() {
        return ifraFile;
    }

    public void setIfraFile(List<String> ifraFile) {
        this.ifraFile = ifraFile;
    }

    public List<String> getNonAnimalTest() {
        return nonAnimalTest;
    }

    public void setNonAnimalTest(List<String> nonAnimalTest) {
        this.nonAnimalTest = nonAnimalTest;
    }

    public List<String> getAllergenInfo() {
        return allergenInfo;
    }

    public void setAllergenInfo(List<String> allergenInfo) {
        this.allergenInfo = allergenInfo;
    }

    public List<String> getAttachmentUrl14() {
        return attachmentUrl14;
    }

    public void setAttachmentUrl14(List<String> attachmentUrl14) {
        this.attachmentUrl14 = attachmentUrl14;
    }

    public List<String> getOtherFile() {
        return otherFile;
    }

    public void setOtherFile(List<String> otherFile) {
        this.otherFile = otherFile;
    }

    public List<String> getCompanyStandards() {
        return companyStandards;
    }

    public void setCompanyStandards(List<String> companyStandards) {
        this.companyStandards = companyStandards;
    }

    public Long getUuId() {
        return uuId;
    }

    public void setUuId(Long uuId) {
        this.uuId = uuId;
    }

    @Override
    public String toString() {
        return "BaseItemVo{" +
                "id=" + id +
                ", itemCode='" + itemCode + '\'' +
                ", itemNo='" + itemNo + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemShortName='" + itemShortName + '\'' +
                ", itemSpecification='" + itemSpecification + '\'' +
                ", itemType=" + itemType +
                ", productUseMethods='" + productUseMethods + '\'' +
                ", categoryType='" + categoryType + '\'' +
                ", customerItemCode='" + customerItemCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", mItemType=" + mItemType +
                ", sItemType=" + sItemType +
                ", colourNumber='" + colourNumber + '\'' +
                ", appearance='" + appearance + '\'' +
                ", specifications='" + specifications + '\'' +
                ", unit='" + unit + '\'' +
                ", whStockUnit='" + whStockUnit + '\'' +
                ", discount=" + discount +
                ", brand='" + brand + '\'' +
                ", brandOwn=" + brandOwn +
                ", price=" + price +
                ", tareWeight=" + tareWeight +
                ", grossWeight=" + grossWeight +
                ", netWeight=" + netWeight +
                ", lineNetWeight='" + lineNetWeight + '\'' +
                ", identificationNetWeight='" + identificationNetWeight + '\'' +
                ", fillingVolumeUpper='" + fillingVolumeUpper + '\'' +
                ", fillingVolumeLower='" + fillingVolumeLower + '\'' +
                ", fillingUnit='" + fillingUnit + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", density=" + density +
                ", percentage=" + percentage +
                ", imageUrl2='" + imageUrl2 + '\'' +
                ", innerImageUrl='" + innerImageUrl + '\'' +
                ", innerImageUrl2='" + innerImageUrl2 + '\'' +
                ", description='" + description + '\'' +
                ", netContent=" + netContent +
                ", barCode='" + barCode + '\'' +
                ", customerId=" + customerId +
                ", property='" + property + '\'' +
                ", supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", manufacturerId=" + manufacturerId +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", note='" + note + '\'' +
                ", warnToplimit=" + warnToplimit +
                ", warnLowerlimit=" + warnLowerlimit +
                ", content='" + content + '\'' +
                ", storageCondition='" + storageCondition + '\'' +
                ", placeOrigin='" + placeOrigin + '\'' +
                ", introductionConditions='" + introductionConditions + '\'' +
                ", introductionDate=" + introductionDate +
                ", effectiveDay=" + effectiveDay +
                ", needQuality=" + needQuality +
                ", needBarcodeStockout=" + needBarcodeStockout +
                ", needWeigh=" + needWeigh +
                ", needConfidential=" + needConfidential +
                ", vulgo='" + vulgo + '\'' +
                ", meltingPoint='" + meltingPoint + '\'' +
                ", particleSize='" + particleSize + '\'' +
                ", conventionalPacking='" + conventionalPacking + '\'' +
                ", msds='" + msds + '\'' +
                ", coa='" + coa + '\'' +
                ", tds='" + tds + '\'' +
                ", ifraFile='" + ifraFile + '\'' +
                ", nonAnimalTest='" + nonAnimalTest + '\'' +
                ", allergenInfo='" + allergenInfo + '\'' +
                ", attachmentUrl14='" + attachmentUrl14 + '\'' +
                ", otherFile='" + otherFile + '\'' +
                ", companyStandards='" + companyStandards + '\'' +
                ", submissionCode='" + submissionCode + '\'' +
                ", reachNo='" + reachNo + '\'' +
                ", origin='" + origin + '\'' +
                ", firstAid='" + firstAid + '\'' +
                ", status=" + status +
                ", pageName='" + pageName + '\'' +
                ", bomNote='" + bomNote + '\'' +
                ", checkStatus=" + checkStatus +
                ", productType=" + productType +
                ", baseItemContents=" + baseItemContents +
                ", baseItemSupplierS=" + baseItemSupplierS +
                ", itemSort=" + itemSort +
                '}';
    }
}
