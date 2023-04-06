package com.jotime.web.domainVo.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import com.jotime.web.domain.base.BaseCodeRuledtl;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 编码规则明细对象 base_code_ruledtl
 * 
 * @author ruoyi
 * @date 2021-12-20
 */
public class BaseCodeRuledtlVo extends BaseCodeRuledtl
{
    private static final long serialVersionUID = 1L;

    /** 编码规则编号 */
    @Excel(name = "编码规则编号")
    private String ruleNo;

    /** 编码规则名称 */
    @Excel(name = "编码规则名称")
    private String ruleName;

    public String getRuleNo()
    {
        return ruleNo;
    }
    public void setRuleNo(String ruleNo)
    {
        this.ruleNo = ruleNo;
    }

    public String getRuleName()
    {
        return ruleName;
    }
    public void setRuleName(String ruleName)
    {
        this.ruleName = ruleName;
    }

}
