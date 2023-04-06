package com.jotime.web.domainVo.batch;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 描述：批次号对象 batch_no_info
 * 
 * @author yunmoqian
 * @date 2022-04-21
 */
public class BatchNoInfoVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 生产任务明细表内码 */
    private Long id;

    /** 批次号 */
    @Excel(name = "批次号")
    private String batchNo;

    /** 物料ID */
    @Excel(name = "物料ID")
    private Long itemId;

    /** 批次号类型 1 采购 2 生产 */
    @Excel(name = "批次号类型 1 采购 2 生产")
    private Integer batchNoType;

    /** 来源(采购单号/生产订单) */
    @Excel(name = "来源(采购单号/生产订单)")
    private String originOrder;

    /** 入库通知单号/任务单号 */
    @Excel(name = "入库通知单号/任务单号")
    private String originTaskOrder;

    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Long supplierId;

    /** 生产商ID */
    @Excel(name = "生产商ID")
    private Long mfrsId;

    /** 生成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creationDate;

    /** 1 禁用 2正常 */
    @Excel(name = "1 禁用 2正常")
    private Integer status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBatchNo(String batchNo) 
    {
        this.batchNo = batchNo;
    }

    public String getBatchNo() 
    {
        return batchNo;
    }
    public void setItemId(Long itemId) 
    {
        this.itemId = itemId;
    }

    public Long getItemId() 
    {
        return itemId;
    }
    public void setBatchNoType(Integer batchNoType) 
    {
        this.batchNoType = batchNoType;
    }

    public Integer getBatchNoType() 
    {
        return batchNoType;
    }
    public void setOriginOrder(String originOrder) 
    {
        this.originOrder = originOrder;
    }

    public String getOriginOrder() 
    {
        return originOrder;
    }
    public void setOriginTaskOrder(String originTaskOrder) 
    {
        this.originTaskOrder = originTaskOrder;
    }

    public String getOriginTaskOrder() 
    {
        return originTaskOrder;
    }
    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setMfrsId(Long mfrsId) 
    {
        this.mfrsId = mfrsId;
    }

    public Long getMfrsId() 
    {
        return mfrsId;
    }
    public void setCreationDate(Date creationDate) 
    {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() 
    {
        return creationDate;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("batchNo", getBatchNo())
            .append("itemId", getItemId())
            .append("batchNoType", getBatchNoType())
            .append("originOrder", getOriginOrder())
            .append("originTaskOrder", getOriginTaskOrder())
            .append("supplierId", getSupplierId())
            .append("mfrsId", getMfrsId())
            .append("creationDate", getCreationDate())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
