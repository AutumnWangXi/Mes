package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 描述：物料含量对象 base_item_content
 *
 * @author yunmoqian
 * @date 2022-03-28
 */
public class BaseItemContent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 物料内码 */
    @Excel(name = "物料内码")
    private String itemId;



    /** 化学名(英文) */
    @Excel(name = "化学名(英文)")
    private String inciNameEn;

    /** 化学名(中文) */
    @Excel(name = "化学名(中文)")
    private String inciNameCn;
    /** 俗称 */
    @Excel(name = "俗称")
    private String vulgo;

    /** CAS编号 */
    @Excel(name = "CAS编号")
    private String casNo;

    /** 含量 */
    @Excel(name = "含量")
    private String content;

    /** EINECS号 */
    @Excel(name = "EINECS号")
    private String einecsNo;

    /** FEMA编号 */
    @Excel(name = "FEMA编号")
    private String femaNo;
    /** 化妆品适用原料序号(原料) */
    @Excel(name = "化妆品适用原料序号(原料)")
    private String serialNumber;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    public String getVulgo() {
        return vulgo;
    }

    public void setVulgo(String vulgo) {
        this.vulgo = vulgo;
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
    public void setInciNameEn(String inciNameEn)
    {
        this.inciNameEn = inciNameEn;
    }

    public String getInciNameEn()
    {
        return inciNameEn;
    }
    public void setInciNameCn(String inciNameCn)
    {
        this.inciNameCn = inciNameCn;
    }

    public String getInciNameCn()
    {
        return inciNameCn;
    }
    public void setCasNo(String casNo)
    {
        this.casNo = casNo;
    }

    public String getCasNo()
    {
        return casNo;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setEinecsNo(String einecsNo)
    {
        this.einecsNo = einecsNo;
    }

    public String getEinecsNo()
    {
        return einecsNo;
    }
    public void setFemaNo(String femaNo)
    {
        this.femaNo = femaNo;
    }

    public String getFemaNo()
    {
        return femaNo;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("itemId", getItemId())
            .append("inciNameEn", getInciNameEn())
            .append("inciNameCn", getInciNameCn())
            .append("casNo", getCasNo())
            .append("content", getContent())
            .append("einecsNo", getEinecsNo())
            .append("femaNo", getFemaNo())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
