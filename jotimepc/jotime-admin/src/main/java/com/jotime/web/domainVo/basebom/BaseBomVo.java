package com.jotime.web.domainVo.basebom;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 描述：bom管理对象 base_bom
 *
 * @author ruoyi
 * @date 2021-12-26
 */
@TableName("base_bom")
public class BaseBomVo extends BaseEntity {
    private static final long serialVersionUID = 1L;


    /**
     * 内码
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * bom编号
     */
    @Excel(name = "bom编号")
    private String bomNo;

    /**
     * 版本号
     */
    @Excel(name = "版本号")
    private String version;

    /**
     * 打样任务编号
     */
    @Excel(name = "打样任务编号")
    private String formulataskNo;

    /**
     * 开发背景 01、新客新品  02、老客新品 03、老品升级 04储备新品
     */
    @Excel(name = "开发背景 01、新客新品  02、老客新品 03、老品升级 04储备新品")
    @NotBlank(message = "请先选择开发背景!")
    private String devBackground;

    /**
     * 预计客户零售价
     */
    @Excel(name = "预计客户零售价")
    private String erpCustomer;

    /**
     * 内料单价
     */
    @Excel(name = "内料单价 元/KG")
    @NotBlank(message = "请先填写内料单价!")
    private String interMaterialsPrice;


    /**
     * 适用皮肤类型
     */
    @Excel(name = "适用皮肤类型")
    @NotBlank(message = "请先选择适用皮肤类型!")
    private String applSkinType;
    /**
     * 适用皮肤类型（其他）
     */
    @Excel(name = "适用皮肤类型（其他）")
    private String applSkinTypeNote;

    /**
     * 品牌
     */
    @Excel(name = "品牌")
    private String brand;

    /**
     * 适用人群 01、女性  02、男性 03、青少年 04 儿童（3-12岁）05 婴儿（0-3岁）99 其他
     */
    @Excel(name = "适用人群 01、女性  02、男性 03、青少年 04 儿童（3-12岁）05 婴儿（0-3岁）99 其他")
    @NotBlank(message = "请先选择适用人群!")
    private String applUser;

    /**
     * 适用人群（其他）
     */
    @Excel(name = "适用人群（其他）")
    private String applUserNote;

    /**
     * 颜色&香型
     */
    @Excel(name = "颜色&香型")
    @NotBlank(message = "请先选择颜色&香型!")
    private String colorAndFlavor;


    /**
     * 成品容量
     */
    @Excel(name = "成品容量")
    @NotBlank(message = "请先填写成品容量!")
    private String finishProductVolumes;

    /**
     * 容器类型
     */
    @Excel(name = "容器类型")
    @NotNull(message = "请先选择容器类型!")
    private String containerType;

    /**
     * 容器类型备注
     */
    @Excel(name = "容器类型备注")
    private String containerTypeNote;

    /**
     * 产品类型 1 一品一料 2 一品多料  3 套装
     */
    @Excel(name = "产品类型 1 一品一料 2 一品多料  3 套装")
    private Integer productType;

    /**
     * 配方编号
     */
    @Excel(name = "配方编号")
    @TableField(exist = false)
    private String formulationNo;

    /**
     * 打样类型
     */
    @Excel(name = "打样类型")
    @NotBlank(message = "请先选择打样类型")
    private String formulaMethod;

    /**
     * 颜色&香型(其他)
     */
    @Excel(name = "颜色&香型(其他)")
    private String colorAndFlavorNote;

    /**
     * 样品类型 01 水剂、乳化类 02 蜡基类 03 粉类 04 洗涤
     */
    @Excel(name = "样品类型 01 水剂、乳化类 02 蜡基类 03 粉类 04 洗涤")
    @NotBlank(message = "请先选择样品类型")
    private String formulaType;

    /**
     * 样品剂型 01 水剂 02 乳液 03 膏霜 04 油膏  05 粉类
     */
    @Excel(name = "样品剂型 01 水剂 02 乳液 03 膏霜 04 油膏  05 粉类")
    @NotBlank(message = "请先选择样品剂型")
    private String formulaDosage;

    /**
     * 销售地区 01 中国 02 美国 03 欧盟 04 东南亚 99 其他
     */
    @Excel(name = "销售地区 01 中国 02 美国 03 欧盟 04 东南亚 99 其他")
    @NotBlank(message = "请先选择销售地区")
    private String salesDistrict;

    /**
     * 销售地区(其他)
     */
    @Excel(name = "销售地区(其他)")
    private String salesDistrictNote;

    /**
     * 销售渠道 01 线上 02实体店、03 直销 04 院线     多个时，逗号隔开
     */
    @Excel(name = "销售渠道 01 线上 02实体店、03 直销 04 院线     多个时，逗号隔开")
    @NotBlank(message = "请先选择销售渠道")
    private String salesChannel;

    /**
     * 使用部位 01 面部 02眼部 03唇部 04 身体 05头发、须用
     */
    @Excel(name = "使用部位 01 面部 02眼部 03唇部 04 身体 05头发、须用")
    @NotBlank(message = "请先选择使用部位")
    private String usedPart;

    /**
     * 使用功效要求
     */
    @Excel(name = "使用功效要求")
    @NotBlank(message = "请先选择使用功效要求")
    private String usedEfficacyReq;

    /**
     * 配方特殊要求
     */
    @Excel(name = "配方特殊要求")
    @NotBlank(message = "请先选择配方特殊要求")
    private String specificaReq;

    /**
     * 1 打样配方一期 2 打样配方二期 3观察配方 4成熟配方
     */
    @Excel(name = " 1 打样配方一期 2 打样配方二期 3观察配方 4成熟配方")
    private Integer formulationRipeness;

    /**
     * 大生产数
     */
    @Excel(name = "大生产数")
    private Integer productionTimes;

    /**
     * 第一次生产时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "第一次生产时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date firstProductionTime;

    /**
     * 客户内码
     */
    @Excel(name = "客户内码")
    private Long customerId;

    /**
     * 合同订单编号
     */
    @Excel(name = "合同订单编号")
    private String contractorderNo;

    /**
     * 客户物料编码
     */
    @Excel(name = "客户物料编码")
    private String customerItemCode;

    /**
     * 物料id
     */
    @Excel(name = "物料id")
    private Long itemId;


    /**
     * 生产流程
     */
    @Excel(name = "生产流程")
    private Long moduleId;

    /**
     * 相容性测试要求
     */
    @Excel(name = "相容性测试要求")
    private String compatibilityTestReq;

    /**
     * 工序内码
     */
    @Excel(name = "工序内码")
    private Long processId;

    /**
     * 生化检验结果 1 不合格 2 合格
     */
    @Excel(name = "生化检验结果 1 不合格 2 合格")
    private Integer biochemicalTests;


    /**
     * 1 不合格 2 合格
     */
    @Excel(name = "1 不合格 2 合格")
    private Integer stabilityTests;


    /**
     * 审核人员内码
     */
    @Excel(name = "审核人员内码")
    private String checkId;

    /**
     * 审核人
     */
    @Excel(name = "审核人")
    private String checker;

    /**
     * 审核人编码
     */
    @Excel(name = "审核人编码")
    private String checkerCode;

    /**
     * 审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkTime;

    /**
     * 1 禁用  2 正常
     */
    @Excel(name = "1 禁用  2 正常")
    private Integer status;

    /**
     * 订单编号
     */
    @TableField(exist = false)
    private Long orderId;

    /**
     * 需求内码
     */
    @TableField(exist = false)
    private Long needId;

    /**
     * 生产订单编号
     */
    @TableField(exist = false)
    private String orderNo;

    /**
     * 数量
     */
    @TableField(exist = false)
    private BigDecimal count;
    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;
    private Integer deptId;
    private Long workshopId;
    /**
     * bom 投料表、明细表、工艺表等关联信息
     */
    private List<BaseBomdtlVo> bomdtlVos;
    private List<BaseBomProcessVo> bomProcessVos;
    private BaseBomProcessVo curBomProcessVo;
    private List<BaseBomFeedingVo> bomFeedingVos;
    private List<BaseBomProcessparmVo> bomProcessparmVos;

    @TableField(exist = false)
    private String itemName;

    @TableField(exist = false)
    private String itemCode;

    @TableField(exist = false)
    private String customerCode;

    @TableField(exist = false)
    private String customerName;

    @TableField(exist = false)
    private Integer itemType;

    @TableField(exist = false)
    private String productFormulaReq;

    @TableField(exist = false)
    private String formulaQty;

    @TableField(exist = false)
    private String samplingDate;
    @TableField(exist = false)
    private String deptName;
    @TableField(exist = false)
    private String workshopName;

    @TableField(exist = false)
    private String unit;
    @TableField(exist = false)
    private String whStockUnit;
    @TableField(exist = false)
    private BigDecimal discount;

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getNeedId() {
        return needId;
    }

    public void setNeedId(Long needId) {
        this.needId = needId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setBomNo(String bomNo) {
        this.bomNo = bomNo;
    }

    public String getBomNo() {
        return bomNo;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setFormulataskNo(String formulataskNo) {
        this.formulataskNo = formulataskNo;
    }

    public String getFormulataskNo() {
        return formulataskNo;
    }

    public void setFormulationRipeness(Integer formulationRipeness) {
        this.formulationRipeness = formulationRipeness;
    }

    public Integer getFormulationRipeness() {
        return formulationRipeness;
    }

    public void setProductionTimes(Integer productionTimes) {
        this.productionTimes = productionTimes;
    }

    public Integer getProductionTimes() {
        return productionTimes;
    }

    public void setFirstProductionTime(Date firstProductionTime) {
        this.firstProductionTime = firstProductionTime;
    }

    public Date getFirstProductionTime() {
        return firstProductionTime;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setContractorderNo(String contractorderNo) {
        this.contractorderNo = contractorderNo;
    }

    public String getContractorderNo() {
        return contractorderNo;
    }

    public void setCustomerItemCode(String customerItemCode) {
        this.customerItemCode = customerItemCode;
    }

    public String getCustomerItemCode() {
        return customerItemCode;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemId() {
        return itemId;
    }


    public void setCompatibilityTestReq(String compatibilityTestReq) {
        this.compatibilityTestReq = compatibilityTestReq;
    }

    public String getCompatibilityTestReq() {
        return compatibilityTestReq;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setBiochemicalTests(Integer biochemicalTests) {
        this.biochemicalTests = biochemicalTests;
    }

    public Integer getBiochemicalTests() {
        return biochemicalTests;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getChecker() {
        return checker;
    }

    public void setCheckerCode(String checkerCode) {
        this.checkerCode = checkerCode;
    }

    public String getCheckerCode() {
        return checkerCode;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public Integer getStabilityTests() {
        return stabilityTests;
    }

    public void setStabilityTests(Integer stabilityTests) {
        this.stabilityTests = stabilityTests;
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

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public String getProductFormulaReq() {
        return productFormulaReq;
    }

    public void setProductFormulaReq(String productFormulaReq) {
        this.productFormulaReq = productFormulaReq;
    }

    public String getFormulaQty() {
        return formulaQty;
    }

    public void setFormulaQty(String formulaQty) {
        this.formulaQty = formulaQty;
    }

    public String getSamplingDate() {
        return samplingDate;
    }

    public void setSamplingDate(String samplingDate) {
        this.samplingDate = samplingDate;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Long getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(Long workshopId) {
        this.workshopId = workshopId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public List<BaseBomdtlVo> getBomdtlVos() {
        return bomdtlVos;
    }

    public void setBomdtlVos(List<BaseBomdtlVo> bomdtlVos) {
        this.bomdtlVos = bomdtlVos;
    }

    public List<BaseBomProcessVo> getBomProcessVos() {
        return bomProcessVos;
    }

    public void setBomProcessVos(List<BaseBomProcessVo> bomProcessVos) {
        this.bomProcessVos = bomProcessVos;
    }

    public List<BaseBomFeedingVo> getBomFeedingVos() {
        return bomFeedingVos;
    }

    public void setBomFeedingVos(List<BaseBomFeedingVo> bomFeedingVos) {
        this.bomFeedingVos = bomFeedingVos;
    }

    public List<BaseBomProcessparmVo> getBomProcessparmVos() {
        return bomProcessparmVos;
    }

    public void setBomProcessparmVos(List<BaseBomProcessparmVo> bomProcessparmVos) {
        this.bomProcessparmVos = bomProcessparmVos;
    }

    public BaseBomProcessVo getCurBomProcessVo() {
        return curBomProcessVo;
    }

    public void setCurBomProcessVo(BaseBomProcessVo curBomProcessVo) {
        this.curBomProcessVo = curBomProcessVo;
    }

    public String getDevBackground() {
        return devBackground;
    }

    public void setDevBackground(String devBackground) {
        this.devBackground = devBackground;
    }

    public String getErpCustomer() {
        return erpCustomer;
    }

    public void setErpCustomer(String erpCustomer) {
        this.erpCustomer = erpCustomer;
    }

    public String getInterMaterialsPrice() {
        return interMaterialsPrice;
    }

    public void setInterMaterialsPrice(String interMaterialsPrice) {
        this.interMaterialsPrice = interMaterialsPrice;
    }

    public String getApplSkinType() {
        return applSkinType;
    }

    public void setApplSkinType(String applSkinType) {
        this.applSkinType = applSkinType;
    }

    public String getApplSkinTypeNote() {
        return applSkinTypeNote;
    }

    public void setApplSkinTypeNote(String applSkinTypeNote) {
        this.applSkinTypeNote = applSkinTypeNote;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getApplUser() {
        return applUser;
    }

    public void setApplUser(String applUser) {
        this.applUser = applUser;
    }

    public String getApplUserNote() {
        return applUserNote;
    }

    public void setApplUserNote(String applUserNote) {
        this.applUserNote = applUserNote;
    }

    public String getColorAndFlavor() {
        return colorAndFlavor;
    }

    public void setColorAndFlavor(String colorAndFlavor) {
        this.colorAndFlavor = colorAndFlavor;
    }


    public String getFinishProductVolumes() {
        return finishProductVolumes;
    }

    public void setFinishProductVolumes(String finishProductVolumes) {
        this.finishProductVolumes = finishProductVolumes;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public String getContainerTypeNote() {
        return containerTypeNote;
    }

    public void setContainerTypeNote(String containerTypeNote) {
        this.containerTypeNote = containerTypeNote;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getFormulationNo() {
        return formulationNo;
    }

    public void setFormulationNo(String formulationNo) {
        this.formulationNo = formulationNo;
    }

    public String getFormulaMethod() {
        return formulaMethod;
    }

    public void setFormulaMethod(String formulaMethod) {
        this.formulaMethod = formulaMethod;
    }

    public String getColorAndFlavorNote() {
        return colorAndFlavorNote;
    }

    public void setColorAndFlavorNote(String colorAndFlavorNote) {
        this.colorAndFlavorNote = colorAndFlavorNote;
    }

    public String getFormulaType() {
        return formulaType;
    }

    public void setFormulaType(String formulaType) {
        this.formulaType = formulaType;
    }

    public String getFormulaDosage() {
        return formulaDosage;
    }

    public void setFormulaDosage(String formulaDosage) {
        this.formulaDosage = formulaDosage;
    }

    public String getSalesDistrict() {
        return salesDistrict;
    }

    public void setSalesDistrict(String salesDistrict) {
        this.salesDistrict = salesDistrict;
    }

    public String getSalesDistrictNote() {
        return salesDistrictNote;
    }

    public void setSalesDistrictNote(String salesDistrictNote) {
        this.salesDistrictNote = salesDistrictNote;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

    public String getUsedPart() {
        return usedPart;
    }

    public void setUsedPart(String usedPart) {
        this.usedPart = usedPart;
    }

    public String getUsedEfficacyReq() {
        return usedEfficacyReq;
    }

    public void setUsedEfficacyReq(String usedEfficacyReq) {
        this.usedEfficacyReq = usedEfficacyReq;
    }

    public String getSpecificaReq() {
        return specificaReq;
    }

    public void setSpecificaReq(String specificaReq) {
        this.specificaReq = specificaReq;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
}
