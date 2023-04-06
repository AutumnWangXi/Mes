package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 微生物检测对象 base_microbe
 * 
 * @author yunmoqian
 * @date 2022-06-16
 */
public class BaseMicrobe extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 检测编码 */
    @Excel(name = "检测编码")
    private String testCode;

    /** 检测模板名称 */
    @Excel(name = "检测模板名称")
    private String testName;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 状态（1 禁用 2 正常） */
    @Excel(name = "状态", readConverterExp = "1=,禁=用,2=,正=常")
    private Integer status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTestCode(String testCode) 
    {
        this.testCode = testCode;
    }

    public String getTestCode() 
    {
        return testCode;
    }
    public void setTestName(String testName) 
    {
        this.testName = testName;
    }

    public String getTestName() 
    {
        return testName;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
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
            .append("testCode", getTestCode())
            .append("testName", getTestName())
            .append("note", getNote())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
