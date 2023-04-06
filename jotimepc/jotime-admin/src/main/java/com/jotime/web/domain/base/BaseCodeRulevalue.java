package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 编码规则当前值对象 base_code_rulevalue
 *
 * @author ruoyi
 * @date 2021-12-23
 */
public class BaseCodeRulevalue extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编码规则明细内码 */
    private Integer id;

    /** 编码规则内码 */
    @Excel(name = "编码规则内码")
    private Integer ruleId;

    /** 编码规则序号 */
    @Excel(name = "编码规则序号")
    private Integer ruleNumber;

    /** 前缀 */
    @Excel(name = "前缀")
    private String prefix;

    /** 当前流水号值 */
    @Excel(name = "当前流水号值")
    private Long curValue;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setRuleId(Integer ruleId)
    {
        this.ruleId = ruleId;
    }

    public Integer getRuleId()
    {
        return ruleId;
    }
    public void setRuleNumber(Integer ruleNumber)
    {
        this.ruleNumber = ruleNumber;
    }

    public Integer getRuleNumber()
    {
        return ruleNumber;
    }
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }

    public String getPrefix()
    {
        return prefix;
    }
    public void setCurValue(Long curValue)
    {
        this.curValue = curValue;
    }

    public Long getCurValue()
    {
        return curValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("ruleId", getRuleId())
                .append("ruleNumber", getRuleNumber())
                .append("prefix", getPrefix())
                .append("curValue", getCurValue())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
