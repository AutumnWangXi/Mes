package com.jotime.web.domainVo.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 原料对象 base_rawmaterial
 * 
 * @author ruoyi
 * @date 2021-07-08
 */
public class BaseRawmaterialVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 原料编号 */
    private String rawmaterialId;

    /** 标准名称 */
    @Excel(name = "标准名称")
    private String standardName;

    /** 原料名称 */
    @Excel(name = "原料名称")
    private String rawmaterialName;

    /** 原料属性 */
    @Excel(name = "原料属性")
    private String attribute;

    /** INCI */
    @Excel(name = "INCI")
    private String inci;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 供应商id */
    @Excel(name = "供应商id")
    private String supplierId;

    /** 生产商名字 */
    @Excel(name = "生产商名字")
    private String supplierName;

    /** 生产商 */
    @Excel(name = "生产商")
    private String manufacturer;

    /** 规格 */
    @Excel(name = "规格")
    private String specification;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 含量 */
    @Excel(name = "含量")
    private String content;

    /** 储存条件 */
    @Excel(name = "储存条件")
    private String condition;

    /** 产地 */
    @Excel(name = "产地")
    private String origin;

    /** 引入日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "引入日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date includeDate;

    /** 引入条件 */
    @Excel(name = "引入条件")
    private String includeCondition;

    /** 有效期 */
    @Excel(name = "有效期")
    private String valDate;

    /** 有效期 */
    @Excel(name = "有效期")
    private BigDecimal price;

    /** 预警条件 */
    @Excel(name = "预警条件")
    private String warnSet;

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

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date gmtModified;

    /** 更新者 */
    @Excel(name = "更新者")
    private String modifiedUser;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRawmaterialId(String rawmaterialId) 
    {
        this.rawmaterialId = rawmaterialId;
    }

    public String getRawmaterialId() 
    {
        return rawmaterialId;
    }
    public void setStandardName(String standardName) 
    {
        this.standardName = standardName;
    }

    public String getStandardName() 
    {
        return standardName;
    }
    public void setRawmaterialName(String rawmaterialName) 
    {
        this.rawmaterialName = rawmaterialName;
    }

    public String getRawmaterialName() 
    {
        return rawmaterialName;
    }
    public void setAttribute(String attribute) 
    {
        this.attribute = attribute;
    }

    public String getAttribute() 
    {
        return attribute;
    }
    public void setInci(String inci) 
    {
        this.inci = inci;
    }

    public String getInci() 
    {
        return inci;
    }
    public void setBrand(String brand) 
    {
        this.brand = brand;
    }

    public String getBrand() 
    {
        return brand;
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
    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() 
    {
        return manufacturer;
    }
    public void setSpecification(String specification) 
    {
        this.specification = specification;
    }

    public String getSpecification() 
    {
        return specification;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setCondition(String condition) 
    {
        this.condition = condition;
    }

    public String getCondition() 
    {
        return condition;
    }
    public void setOrigin(String origin) 
    {
        this.origin = origin;
    }

    public String getOrigin() 
    {
        return origin;
    }
    public void setIncludeDate(Date includeDate) 
    {
        this.includeDate = includeDate;
    }

    public Date getIncludeDate() 
    {
        return includeDate;
    }
    public void setIncludeCondition(String includeCondition) 
    {
        this.includeCondition = includeCondition;
    }

    public String getIncludeCondition() 
    {
        return includeCondition;
    }
    public void setValDate(String valDate) 
    {
        this.valDate = valDate;
    }

    public String getValDate() 
    {
        return valDate;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setWarnSet(String warnSet) 
    {
        this.warnSet = warnSet;
    }

    public String getWarnSet() 
    {
        return warnSet;
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
    public void setGmtModified(Date gmtModified) 
    {
        this.gmtModified = gmtModified;
    }

    public Date getGmtModified() 
    {
        return gmtModified;
    }
    public void setModifiedUser(String modifiedUser) 
    {
        this.modifiedUser = modifiedUser;
    }

    public String getModifiedUser() 
    {
        return modifiedUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("rawmaterialId", getRawmaterialId())
            .append("standardName", getStandardName())
            .append("rawmaterialName", getRawmaterialName())
            .append("attribute", getAttribute())
            .append("inci", getInci())
            .append("brand", getBrand())
            .append("supplierId", getSupplierId())
            .append("supplierName", getSupplierName())
            .append("manufacturer", getManufacturer())
            .append("specification", getSpecification())
            .append("unit", getUnit())
            .append("content", getContent())
            .append("condition", getCondition())
            .append("origin", getOrigin())
            .append("includeDate", getIncludeDate())
            .append("includeCondition", getIncludeCondition())
            .append("valDate", getValDate())
            .append("price", getPrice())
            .append("warnSet", getWarnSet())
            .append("creator", getCreator())
            .append("creatorId", getCreatorId())
            .append("createDate", getCreateDate())
            .append("gmtModified", getGmtModified())
            .append("modifiedUser", getModifiedUser())
            .toString();
    }
}
