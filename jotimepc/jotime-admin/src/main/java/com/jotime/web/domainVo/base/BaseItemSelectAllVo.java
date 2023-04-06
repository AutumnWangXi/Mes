package com.jotime.web.domainVo.base;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * @author hxh
 * @date 2022/5/23
 **/
public class BaseItemSelectAllVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 物料id
     */
    private Long id;

    /**
     * 物料代码
     */
    @Excel(name = "物料代码")
    private String itemCode;

    /**
     * 物料名称
     */
    @Excel(name = "物料名称")
    private String itemName;

    /**
     * 单价
     */
    @Excel(name = "单价")
    private BigDecimal price;

    /** N 不报送 S 报送中 C 完成*/
    private String  submissionCodeSts;


    public String getSubmissionCodeSts() {
        return submissionCodeSts;
    }

    public void setSubmissionCodeSts(String submissionCodeSts) {
        this.submissionCodeSts = submissionCodeSts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
