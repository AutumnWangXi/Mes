package com.jotime.web.domainVo.formula;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 配方原料对象 formula_material
 * 
 * @author ruoyi
 * @date 2021-07-15
 */
public class FormulaMaterialVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 配方编号 */
    @Excel(name = "配方编号")
    private String formulaId;

    /** 类型 0：预处理料  1：内料 */
    @Excel(name = "类型 0：预处理料  1：内料")
    private String type;

    /** 原料编号 */
    @Excel(name = "原料编号")
    private String materialId;

    /** 原料名称 */
    @Excel(name = "原料名称")
    private String materialName;

    /** 含量 */
    @Excel(name = "含量")
    private String component;

    /** 基准量 */
    @Excel(name = "基准量")
    private String baseCount;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 称量量 */
    @Excel(name = "称量量")
    private BigDecimal weighingCount;

    /** 创建者 */
    @Excel(name = "创建者")
    private String creator;

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
    public void setFormulaId(String formulaId) 
    {
        this.formulaId = formulaId;
    }

    public String getFormulaId() 
    {
        return formulaId;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setMaterialId(String materialId) 
    {
        this.materialId = materialId;
    }

    public String getMaterialId() 
    {
        return materialId;
    }
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setComponent(String component) 
    {
        this.component = component;
    }

    public String getComponent() 
    {
        return component;
    }
    public void setBaseCount(String baseCount) 
    {
        this.baseCount = baseCount;
    }

    public String getBaseCount() 
    {
        return baseCount;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
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

    public BigDecimal getWeighingCount() {
        return weighingCount;
    }

    public void setWeighingCount(BigDecimal weighingCount) {
        this.weighingCount = weighingCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("formulaId", getFormulaId())
            .append("type", getType())
            .append("materialId", getMaterialId())
            .append("materialName", getMaterialName())
            .append("component", getComponent())
            .append("baseCount", getBaseCount())
            .append("remarks", getRemarks())
             .append("weighingCount", getWeighingCount())
            .append("creator", getCreator())
            .append("createDate", getCreateDate())
            .append("gmtModified", getGmtModified())
            .append("modifiedUser", getModifiedUser())
            .toString();
    }
}
