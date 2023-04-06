package com.jotime.web.domainVo.excel;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

/**
 * @Description: 表格导入，耗材对象
 * @Author: YunFei
 * @Date: 2022/4/15 17:31
 */
public class BaseItemConsumableExlVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 物料id
     */
    private Long id;

    /**
     * 物料代码
     */
    @Excel(name = "耗材编码")
    private String itemCode;


    /**
     * 物料名称
     */
    @Excel(name = "耗材名称")
    private String itemName;

    /**
     * 类别
     */
    @Excel(name = "耗材类别")
    private String categoryType;

    /**
     * 备注
     */
//    @Excel(name = "状态")
    private String status;
    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
