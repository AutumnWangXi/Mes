package com.jotime.web.domainVo.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

/**
 * 物料供应商对象 base_item_supplier
 * 
 * @author yunmoqian
 * @date 2022-05-22
 */
public class BaseItemSupplierVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Long id;

    /** 物料内码 */
    @Excel(name = "物料内码")
    private Long itemId;

    /** 供应商内码 */
    @Excel(name = "供应商内码")
    private Long supplierId;

    /** 供应商编码 */
    @Excel(name = "供应商编码")
    private String supplierCode;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 状态 1 禁用 2正常 */
    @Excel(name = "状态 1 禁用 2正常")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setItemId(Long itemId) 
    {
        this.itemId = itemId;
    }

    public Long getItemId() 
    {
        return itemId;
    }
    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
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

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Override
    public String toString() {
        return "BaseItemSupplierVo{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", supplierId=" + supplierId +
                ", supplierCode=" + supplierCode +
                ", supplierName=" + supplierName +
                ", status=" + status +
                ", note='" + note + '\'' +
                '}';
    }
}
