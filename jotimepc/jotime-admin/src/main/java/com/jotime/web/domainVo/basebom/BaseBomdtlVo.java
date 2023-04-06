package com.jotime.web.domainVo.basebom;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.List;

/**
 * 描述：bom管理明细对象 base_bomdtl
 *
 * @author ruoyi
 * @date 2021-12-26
 */
public class BaseBomdtlVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 内码
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * bom表内码
     */
    @Excel(name = "bom表内码")
    private Long bomId;

    /**
     * 版本号
     */
    @Excel(name = "版本号")
    private String version;

    /**
     * 物料id
     */
    @Excel(name = "物料id")
    private Long itemId;

    /**
     * 制造厂商id
     */
    @Excel(name = "制造厂商id")
    private Long mfrsId;

    /**
     * 品牌
     */
    @Excel(name = "品牌")
    private String brand;

    /**
     * 含量
     */
    @Excel(name = "含量")
    private BigDecimal content;

    /**
     * 物料图片
     */
    @Excel(name = "物料图片")
    private String imageUrl;

    /**
     * 基准量
     */
    @Excel(name = "基准量")
    private BigDecimal standardQty;

    /**
     * 美观线净含量  半成品
     */
    @Excel(name = "美观线净含量  半成品")
    private String lineNetWeight;

    /**
     * 标识净含量  半成品
     */
    @Excel(name = "标识净含量  半成品")
    private String identificationNetWeight;

    /**
     * 灌装量上下限  半成品
     */
    @Excel(name = "灌装量上下限  半成品")
    private String fillingVolumeRange;

    /**
     * 密度  半成品
     */
    @Excel(name = "密度  半成品")
    private String density;

    /**
     * 包材标样 包材
     */
    @Excel(name = "包材标样 包材")
    private String packageStandard;

    /**
     * 包材配比 包材
     */
    @Excel(name = "包材配比 包材")
    private BigDecimal packageProportioning;

    /**
     * 1 禁用  2 正常
     */
    @Excel(name = "1 禁用  2 正常")
    private Integer status;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;
    /**
     * 物料序号
     */
    @Excel(name = "物料序号")
    private Integer itemSort;


    private int packages;
    private String unit;
    private String fillingVolumeUpper;
    private String fillingVolumeLower;
    private String fillingUnit;

    private List<BaseBomdtlVo> baseBomdtlVos;

    @TableField(exist = false)
    public Integer itemType;
    @TableField(exist = false)
    public String itemNo;
    @TableField(exist = false)
    public String itemName;
    @TableField(exist = false)
    public String bomNo;
    @TableField(exist = false)
    public String itemCode;

    /**
     * 套内物料内码
     */
    @TableId(type = IdType.AUTO)
    private Long innerItemId;

    /**
     * 套内物料名字
     */
    @TableId(type = IdType.AUTO)
    private String innerItemName;

    @TableField(exist = false)
    public Long selfBomId;

    @TableField(exist = false)
    private String whStockUnit;
    @TableField(exist = false)
    private BigDecimal discount;

    public Long getInnerItemId() {
        return innerItemId;
    }

    public void setInnerItemId(Long innerItemId) {
        this.innerItemId = innerItemId;
    }

    public String getInnerItemName() {
        return innerItemName;
    }

    public void setInnerItemName(String innerItemName) {
        this.innerItemName = innerItemName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setBomId(Long bomId) {
        this.bomId = bomId;
    }

    public Long getBomId() {
        return bomId;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setMfrsId(Long mfrsId) {
        this.mfrsId = mfrsId;
    }

    public Long getMfrsId() {
        return mfrsId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setContent(BigDecimal content) {
        this.content = content;
    }

    public BigDecimal getContent() {
        return content;
    }

    public void setStandardQty(BigDecimal standardQty) {
        this.standardQty = standardQty;
    }

    public BigDecimal getStandardQty() {
        return standardQty;
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

    public void setFillingVolumeRange(String fillingVolumeRange) {
        this.fillingVolumeRange = fillingVolumeRange;
    }

    public String getFillingVolumeRange() {
        return fillingVolumeRange;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getDensity() {
        return density;
    }

    public void setPackageStandard(String packageStandard) {
        this.packageStandard = packageStandard;
    }

    public String getPackageStandard() {
        return packageStandard;
    }

    public void setPackageProportioning(BigDecimal packageProportioning) {
        this.packageProportioning = packageProportioning;
    }

    public BigDecimal getPackageProportioning() {
        return packageProportioning;
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

    public Long getSelfBomId() {
        return selfBomId;
    }

    public void setSelfBomId(Long selfBomId) {
        this.selfBomId = selfBomId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("bomId", getBomId())
                .append("version", getVersion())
                .append("itemId", getItemId())
                .append("mfrsId", getMfrsId())
                .append("brand", getBrand())
                .append("content", getContent())
                .append("standardQty", getStandardQty())
                .append("lineNetWeight", getLineNetWeight())
                .append("identificationNetWeight", getIdentificationNetWeight())
                .append("fillingVolumeRange", getFillingVolumeRange())
                .append("density", getDensity())
                .append("packageStandard", getPackageStandard())
                .append("packageProportioning", getPackageProportioning())
                .append("status", getStatus())
                .append("note", getNote())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }

    public int getPackages() {
        return packages;
    }

    public void setPackages(int packages) {
        this.packages = packages;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFillingVolumeUpper() {
        return fillingVolumeUpper;
    }

    public void setFillingVolumeUpper(String fillingVolumeUpper) {
        this.fillingVolumeUpper = fillingVolumeUpper;
    }

    public String getFillingVolumeLower() {
        return fillingVolumeLower;
    }

    public void setFillingVolumeLower(String fillingVolumeLower) {
        this.fillingVolumeLower = fillingVolumeLower;
    }

    public String getFillingUnit() {
        return fillingUnit;
    }

    public void setFillingUnit(String fillingUnit) {
        this.fillingUnit = fillingUnit;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBomNo() {
        return bomNo;
    }

    public void setBomNo(String bomNo) {
        this.bomNo = bomNo;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public List<BaseBomdtlVo> getBaseBomdtlVos() {
        return baseBomdtlVos;
    }

    public void setBaseBomdtlVos(List<BaseBomdtlVo> baseBomdtlVos) {
        this.baseBomdtlVos = baseBomdtlVos;
    }

    public Integer getItemSort() {
        return itemSort;
    }

    public void setItemSort(Integer itemSort) {
        this.itemSort = itemSort;
    }
}
