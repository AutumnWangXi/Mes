package com.jotime.web.domainVo.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 物料箱基础对象 base_materialbox
 * 
 * @author ruoyi
 * @date 2021-07-08
 */
public class BaseMaterialboxVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 物料箱id */
    @Excel(name = "物料箱id")
    private String materialId;

    /** 物料箱名称 */
    @Excel(name = "物料箱名称")
    private String materialBox;

    /** 容量 */
    @Excel(name = "容量")
    private String capacity;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 创建着姓名 */
    @Excel(name = "创建着姓名")
    private String creator;

    /** 创建人id */
    @Excel(name = "创建人id")
    private String creatorId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMaterialId(String materialId) 
    {
        this.materialId = materialId;
    }

    public String getMaterialId() 
    {
        return materialId;
    }
    public void setMaterialBox(String materialBox) 
    {
        this.materialBox = materialBox;
    }

    public String getMaterialBox() 
    {
        return materialBox;
    }
    public void setCapacity(String capacity)
    {
        this.capacity = capacity;
    }

    public String getCapacity()
    {
        return capacity;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("materialId", getMaterialId())
            .append("materialBox", getMaterialBox())
            .append("capacity", getCapacity())
            .append("note", getNote())
            .append("createDate", getCreateDate())
            .append("creator", getCreator())
            .append("creatorId", getCreatorId())
            .toString();
    }
}
