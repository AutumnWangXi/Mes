package com.jotime.web.domainVo.excel;

import com.jotime.common.annotation.Excel;

/**
 * 配方成分EXCEL
 * @author hxh
 * @date 2022/4/20
 **/
public class BaseBomIngredients {
    private static final long serialVersionUID = 1L;
    /**
     * 原料序号
     */
    @Excel(name = "原料序号", sort = 1)
    private Long itemSort;

    /**
     * 标准中文名
     */
    @Excel(name = "标准中文名", sort = 2)
    private String inciNameCn;

    /**
     * 标准英文名
     */
    @Excel(name = "标准英文名", sort = 3)
    private String inciNameEn;

    /**
     * 原料含量
     */
    @Excel(name = "原料含量", sort = 4)
    private String rawMaterialContent;

    /**
     * 原料中成分含量
     */
    @Excel(name = "原料中成分含量", sort = 5)
    private String componentContent;

    /**
     * 实际成分含量
     */
    @Excel(name = "实际成分含量" , sort = 6)
    private String actualComponentContent;

    /**
     * 生产商
     */
    @Excel(name = "生产商" , sort = 7)
    private String mfrsName;

    /**
     * 主要使用目的（属性）
     */
    @Excel(name = "主要使用目的", sort = 8)
    private String property;

    /**
     * 备注
     */
    @Excel(name = "备注" , sort = 9)
    private String note;

    /**
     * 是否为新原料（默认0）
     */
    @Excel(name = "是否为新原料", sort = 10)
    private String isNewRawMaterial;

    /**
     * 注册号/备案号
     */
    @Excel(name = "注册号/备案号", sort = 11)
    private String serialNumber;

    /**
     * 配方编号
     */
    private Long bomId;
    /**
     * 配方编号
     */
    private String bomNo;
    /**
     * 版本号
     */
    private String version;
    /**
     * 客户id
     */
    private Long customerId;
    /**
     * 物料id
     */
    private Long faItemId;
    /**
     * 产品名称
     */
    private String faItemName;
    /**
     * 产品编号
     */
    private String faItemCode;
    /**
     * 含量
     */
    private String faContent;

    /**
     * 安全评估备注1
     */
        private String note1;

    /**
     * 安全评估危险原料
     */
    private String riskSubstances;

    /**
     * 安全评估危险备注
     */
    private String description;

    /**
     * 驻留类产品最高历史使用量
     */
    private String residentMaximumUsage;

    /**
     * 序号
     */
    private Integer num;

    /**
     * 权威机构评论结论
     */
    private String usedConclusionCn;

    /**
     * 配方组成详情
     */
    private String info;

    /**
     * 产品名称
     */
    private String itemName;

    /**
     * 产品编号
     */
    private String itemCode;

    /**
     * 产品报送码
     */
    private String submissionCode;

    public String getSubmissionCode() {
        return submissionCode;
    }

    public void setSubmissionCode(String submissionCode) {
        this.submissionCode = submissionCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUsedConclusionCn() {
        return usedConclusionCn;
    }

    public void setUsedConclusionCn(String usedConclusionCn) {
        this.usedConclusionCn = usedConclusionCn;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getFaContent() {
        return faContent;
    }

    public void setFaContent(String faContent) {
        this.faContent = faContent;
    }

    public Long getFaItemId() {
        return faItemId;
    }

    public void setFaItemId(Long faItemId) {
        this.faItemId = faItemId;
    }

    public String getResidentMaximumUsage() {
        return residentMaximumUsage;
    }

    public void setResidentMaximumUsage(String residentMaximumUsage) {
        this.residentMaximumUsage = residentMaximumUsage;
    }

    public String getRiskSubstances() {
        return riskSubstances;
    }

    public void setRiskSubstances(String riskSubstances) {
        this.riskSubstances = riskSubstances;
    }

    public String getNote1() {
        return note1;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
    }

    public Long getBomId() {
        return bomId;
    }

    public void setBomId(Long bomId) {
        this.bomId = bomId;
    }

    public String getFaItemName() {
        return faItemName;
    }

    public void setFaItemName(String faItemName) {
        this.faItemName = faItemName;
    }

    public String getFaItemCode() {
        return faItemCode;
    }

    public void setFaItemCode(String faItemCode) {
        this.faItemCode = faItemCode;
    }

    public String getBomNo() {
        return bomNo;
    }

    public void setBomNo(String bomNo) {
        this.bomNo = bomNo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getItemSort() {
        return itemSort;
    }

    public void setItemSort(Long itemSort) {
        this.itemSort = itemSort;
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

    public String getRawMaterialContent() {
        return rawMaterialContent;
    }

    public void setRawMaterialContent(String rawMaterialContent) {
        this.rawMaterialContent = rawMaterialContent;
    }

    public String getComponentContent() {
        return componentContent;
    }

    public void setComponentContent(String componentContent) {
        this.componentContent = componentContent;
    }

    public String getActualComponentContent() {
        return actualComponentContent;
    }

    public void setActualComponentContent(String actualComponentContent) {
        this.actualComponentContent = actualComponentContent;
    }

    public String getMfrsName() {
        return mfrsName;
    }

    public void setMfrsName(String mfrsName) {
        this.mfrsName = mfrsName;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getIsNewRawMaterial() {
        return isNewRawMaterial;
    }

    public void setIsNewRawMaterial(String isNewRawMaterial) {
        this.isNewRawMaterial = isNewRawMaterial;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
