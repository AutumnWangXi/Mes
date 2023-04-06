package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 周转箱对象 base_turnover_box
 *
 * @author ruoyi
 * @date 2022-01-13
 */
public class BaseTurnoverBox extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 物料箱编号 */
    @Excel(name = "物料箱编号")
    private String boxNo;

    /** 物料箱名称 */
    @Excel(name = "物料箱名称")
    private String boxName;

    /** 物料箱类型 */
    @Excel(name = "物料箱类型")
    private String boxType;

    /** 条形码 */
    @Excel(name = "条形码")
    private String barCode;

    /** 容量 */
    @Excel(name = "容量")
    private String capacity;

    /** 状态  1 禁用 2 正常 */
    @Excel(name = "状态  1 禁用 2 正常")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    public Long getId()
    {
        return id;
    }
    public void setBoxName(String boxName)
    {
        this.boxName = boxName;
    }

    public String getBoxName()
    {
        return boxName;
    }
    public void setBoxType(String boxType)
    {
        this.boxType = boxType;
    }

    public String getBoxType()
    {
        return boxType;
    }
    public void setBarCode(String barCode)
    {
        this.barCode = barCode;
    }

    public String getBarCode()
    {
        return barCode;
    }
    public void setCapacity(String capacity)
    {
        this.capacity = capacity;
    }

    public String getCapacity()
    {
        return capacity;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("boxName", getBoxName())
            .append("boxType", getBoxType())
            .append("barCode", getBarCode())
            .append("capacity", getCapacity())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
