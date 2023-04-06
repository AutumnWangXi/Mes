package com.jotime.web.domainVo.base;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
/**
 * 包入库第四阶段入库对象 base_checkpacking_fourth
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public class BaseCheckpackingFourthVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 包材编号 */
    @Excel(name = "包材编号")
    private String packingMaterialNumber;

    /** 包材名称 */
    @Excel(name = "包材名称")
    private String packingMaterialName;

    /** 供应商编号 */
    @Excel(name = "供应商编号")
    private String supplierCode;

    /** 批号 */
    @Excel(name = "批号")
    private String batchNumber;

    /** 供应商批号 */
    @Excel(name = "供应商批号")
    private String supplierLotNumber;

    /** 包装数 */
    @Excel(name = "包装数")
    private String numberOfPackages;

    /** 单位 */
    @Excel(name = "单位")
    private String brand;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private String inboundQuantity;

    /** 收货员 */
    @Excel(name = "收货员")
    private String receiving;

    /** 采购/业务 */
    @Excel(name = "采购/业务")
    private String procurementBusiness;

    /** 绑定库位 */
    @Excel(name = "绑定库位")
    private String bindings;

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

    /** 更新人 */
    @Excel(name = "更新人")
    private String modifiedUser;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setPackingMaterialNumber(String packingMaterialNumber)
    {
        this.packingMaterialNumber = packingMaterialNumber;
    }

    public String getPackingMaterialNumber()
    {
        return packingMaterialNumber;
    }
    public void setPackingMaterialName(String packingMaterialName)
    {
        this.packingMaterialName = packingMaterialName;
    }

    public String getPackingMaterialName()
    {
        return packingMaterialName;
    }
    public void setSupplierCode(String supplierCode)
    {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCode()
    {
        return supplierCode;
    }
    public void setBatchNumber(String batchNumber)
    {
        this.batchNumber = batchNumber;
    }

    public String getBatchNumber()
    {
        return batchNumber;
    }
    public void setSupplierLotNumber(String supplierLotNumber)
    {
        this.supplierLotNumber = supplierLotNumber;
    }

    public String getSupplierLotNumber()
    {
        return supplierLotNumber;
    }
    public void setNumberOfPackages(String numberOfPackages)
    {
        this.numberOfPackages = numberOfPackages;
    }

    public String getNumberOfPackages()
    {
        return numberOfPackages;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getBrand()
    {
        return brand;
    }
    public void setInboundQuantity(String inboundQuantity)
    {
        this.inboundQuantity = inboundQuantity;
    }

    public String getInboundQuantity()
    {
        return inboundQuantity;
    }
    public void setReceiving(String receiving)
    {
        this.receiving = receiving;
    }

    public String getReceiving()
    {
        return receiving;
    }
    public void setProcurementBusiness(String procurementBusiness)
    {
        this.procurementBusiness = procurementBusiness;
    }

    public String getProcurementBusiness()
    {
        return procurementBusiness;
    }
    public void setBindings(String bindings)
    {
        this.bindings = bindings;
    }

    public String getBindings()
    {
        return bindings;
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
                .append("packingMaterialNumber", getPackingMaterialNumber())
                .append("packingMaterialName", getPackingMaterialName())
                .append("supplierCode", getSupplierCode())
                .append("batchNumber", getBatchNumber())
                .append("supplierLotNumber", getSupplierLotNumber())
                .append("numberOfPackages", getNumberOfPackages())
                .append("brand", getBrand())
                .append("inboundQuantity", getInboundQuantity())
                .append("receiving", getReceiving())
                .append("procurementBusiness", getProcurementBusiness())
                .append("bindings", getBindings())
                .append("creator", getCreator())
                .append("creatorId", getCreatorId())
                .append("createDate", getCreateDate())
                .append("gmtModified", getGmtModified())
                .append("modifiedUser", getModifiedUser())
                .toString();
    }
}
