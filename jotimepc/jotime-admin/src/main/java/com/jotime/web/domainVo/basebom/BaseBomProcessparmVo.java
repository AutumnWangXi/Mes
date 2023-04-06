package com.jotime.web.domainVo.basebom;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 描述：工艺参数对象 base_bom_processparm
 *
 * @author ruoyi
 * @date 2021-12-26
 */
public class BaseBomProcessparmVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 内码
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 工序id
     */
    @Excel(name = "工序id")
    private Long processstepId;

    /**
     * bom编号
     */
    @Excel(name = "bom编号")
    private String bomNo;

    /**
     * 工序顺序
     */
    @Excel(name = "工序顺序")
    private Integer stepSort;

    /**
     * 工艺组参数名称
     */
    @Excel(name = "工艺组参数名称")
    private String groupName;

    /**
     * 工艺参数名称
     */
    @Excel(name = "工艺参数名称")
    private String parmName;

    /**
     * 工艺参数标准值
     */
    @Excel(name = "工艺参数标准值")
    private BigDecimal standardValue;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;

    private BigDecimal toplimitValue;
    private BigDecimal lowerlimitValue;

    public BigDecimal getToplimitValue() {
        return toplimitValue;
    }

    public void setToplimitValue(BigDecimal toplimitValue) {
        this.toplimitValue = toplimitValue;
    }

    public BigDecimal getLowerlimitValue() {
        return lowerlimitValue;
    }

    public void setLowerlimitValue(BigDecimal lowerlimitValue) {
        this.lowerlimitValue = lowerlimitValue;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setBomNo(String bomNo) {
        this.bomNo = bomNo;
    }

    public String getBomNo() {
        return bomNo;
    }

    public void setStepSort(Integer stepSort) {
        this.stepSort = stepSort;
    }

    public Integer getStepSort() {
        return stepSort;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setParmName(String parmName) {
        this.parmName = parmName;
    }

    public String getParmName() {
        return parmName;
    }

    public void setStandardValue(BigDecimal standardValue) {
        this.standardValue = standardValue;
    }

    public BigDecimal getStandardValue() {
        return standardValue;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public Long getProcessstepId() {
        return processstepId;
    }

    public void setProcessstepId(Long processstepId) {
        this.processstepId = processstepId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("bomNo", getBomNo())
                .append("stepSort", getStepSort())
                .append("groupName", getGroupName())
                .append("parmName", getParmName())
                .append("standardValue", getStandardValue())
                .append("note", getNote())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
