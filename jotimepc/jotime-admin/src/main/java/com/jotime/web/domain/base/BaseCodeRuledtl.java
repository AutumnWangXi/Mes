package com.jotime.web.domain.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 编码规则明细对象 base_code_ruledtl
 * 
 * @author ruoyi
 * @date 2021-12-20
 */
public class BaseCodeRuledtl extends BaseEntity
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

    /** 编码规则类型1、const 常量 2、numbering 计数 3、timestamp 时间戳 4、guid GUID 5、sql SQL文 6、class  自定义类 */
    @Excel(name = "编码规则类型1、const 常量 2、numbering 计数 3、timestamp 时间戳 4、guid GUID 5、sql SQL文 6、class  自定义类")
    private String ruleType;

    /** 编码规则参数(1、const 常量 2、numbering 计数 3、timestamp 时间戳 4、参数 5、sql SQL文 6、class 自定义类) */
    @Excel(name = "编码规则参数(1、const 常量 2、numbering 计数 3、timestamp 时间戳 4、参数 5、sql SQL文 6、class 自定义类)")
    private String ruleParam;

    /** 编码长度 */
    @Excel(name = "编码长度")
    private Integer paddingLength;

    /** 编码补位方式 left 左补 right 右补 */
    @Excel(name = "编码补位方式 left 左补 right 右补")
    private String paddingSide;

    /** 编码补位字符 */
    @Excel(name = "编码补位字符")
    private String paddingChar;

    /** 步长 */
    @Excel(name = "步长")
    private Integer step;

    /** 流水号初始值 */
    @Excel(name = "流水号初始值")
    private int initValue;

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
    public void setRuleType(String ruleType) 
    {
        this.ruleType = ruleType;
    }

    public String getRuleType() 
    {
        return ruleType;
    }
    public void setRuleParam(String ruleParam) 
    {
        this.ruleParam = ruleParam;
    }

    public String getRuleParam() 
    {
        return ruleParam;
    }
    public void setPaddingLength(Integer paddingLength) 
    {
        this.paddingLength = paddingLength;
    }

    public Integer getPaddingLength() 
    {
        return paddingLength;
    }
    public void setPaddingSide(String paddingSide) 
    {
        this.paddingSide = paddingSide;
    }

    public String getPaddingSide() 
    {
        return paddingSide;
    }
    public void setPaddingChar(String paddingChar) 
    {
        this.paddingChar = paddingChar;
    }

    public String getPaddingChar() 
    {
        return paddingChar;
    }
    public void setStep(Integer step) 
    {
        this.step = step;
    }

    public Integer getStep() 
    {
        return step;
    }
    public void setInitValue(int initValue)
    {
        this.initValue = initValue;
    }

    public int getInitValue()
    {
        return initValue;
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
            .append("ruleId", getRuleId())
            .append("ruleNumber", getRuleNumber())
            .append("ruleType", getRuleType())
            .append("ruleParam", getRuleParam())
            .append("paddingLength", getPaddingLength())
            .append("paddingSide", getPaddingSide())
            .append("paddingChar", getPaddingChar())
            .append("step", getStep())
            .append("initValue", getInitValue())
            .append("status", getStatus())
            .append("note", getNote())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
