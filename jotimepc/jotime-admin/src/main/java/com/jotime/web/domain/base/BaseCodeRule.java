package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 编码规则对象 base_code_rule
 * 
 * @author ruoyi
 * @date 2021-12-20
 */
public class BaseCodeRule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编码规则内码 */
    private Integer id;

    /** 编码规则编号 */
    @Excel(name = "编码规则编号")
    private String ruleNo;

    /** 编码规则名称 */
    @Excel(name = "编码规则名称")
    private String ruleName;

    /** 重置依赖 */
    @Excel(name = "重置依赖")
    private String resetRule;

    /** 当前编码 */
    @Excel(name = "当前编码")
    private String curCode;

    /** 状态 1 禁用  2 正常 */
    @Excel(name = "状态 1 禁用  2 正常")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setRuleNo(String ruleNo) 
    {
        this.ruleNo = ruleNo;
    }

    public String getRuleNo() 
    {
        return ruleNo;
    }
    public void setRuleName(String ruleName) 
    {
        this.ruleName = ruleName;
    }

    public String getRuleName() 
    {
        return ruleName;
    }
    public void setResetRule(String resetRule) 
    {
        this.resetRule = resetRule;
    }

    public String getResetRule() 
    {
        return resetRule;
    }
    public void setCurCode(String curCode) 
    {
        this.curCode = curCode;
    }

    public String getCurCode() 
    {
        return curCode;
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
            .append("ruleNo", getRuleNo())
            .append("ruleName", getRuleName())
            .append("resetRule", getResetRule())
            .append("curCode", getCurCode())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
