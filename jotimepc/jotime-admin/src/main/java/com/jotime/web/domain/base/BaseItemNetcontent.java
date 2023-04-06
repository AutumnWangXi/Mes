package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 描述：成品净含量对象 base_item_netcontent
 *
 * @author yunmoqian
 * @date 2022-05-07
 */
public class BaseItemNetcontent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 物料内码 */
    @Excel(name = "物料内码")
    private String itemId;

    /** 套内物料内码 */
    @Excel(name = "套内物料内码")
    private Long innerItemId;


    /** 内料配方编号 */
    @Excel(name = "内料配方编号")
    private String bomNo;
    /** 版本号 */
    @Excel(name = "版本号")
    private String version;

    /** 密度(g/cm³) */
    @Excel(name = "密度(g/cm³)")
    private BigDecimal density;

    /** 净含量 */
    @Excel(name = "净含量")
    private BigDecimal netContent;

    /** 净量 */
    @Excel(name = "净量")
    private BigDecimal netWeight ;

    /** 产品数量 */
    @Excel(name = "产品数量")
    private BigDecimal productQty;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setItemId(String itemId)
    {
        this.itemId = itemId;
    }

    public String getItemId()
    {
        return itemId;
    }
    public void setDensity(BigDecimal density)
    {
        this.density = density;
    }

    public BigDecimal getDensity()
    {
        return density;
    }
    public void setNetContent(BigDecimal netContent)
    {
        this.netContent = netContent;
    }

    public BigDecimal getNetContent()
    {
        return netContent;
    }

    public Long getInnerItemId() {
        return innerItemId;
    }

    public void setInnerItemId(Long innerItemId) {
        this.innerItemId = innerItemId;
    }

    public String getBomNo() {
        return bomNo;
    }

    public void setBomNo(String bomNo) {
        this.bomNo = bomNo;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public BigDecimal getProductQty() {
        return productQty;
    }

    public void setProductQty(BigDecimal productQty) {
        this.productQty = productQty;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("itemId", getItemId())
            .append("density", getDensity())
            .append("netContent", getNetContent())
            .append("netWeight ", getNetWeight())
            .append("productQty", getProductQty())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
