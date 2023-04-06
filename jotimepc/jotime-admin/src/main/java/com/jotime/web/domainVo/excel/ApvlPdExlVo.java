package com.jotime.web.domainVo.excel;

import com.jotime.common.annotation.Excel;
import com.jotime.web.domainVo.contract.TContractdtlVo;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

/**
 * 生产申请产品信息导入数据
 *
 * @author ck
 * @date 2022/06/16 13:39
 */
public class ApvlPdExlVo {

    private static final long serialVersionUID = 1L;

    /**
     * 物料编号
     */
    @Excel(name = "物料编号")
    private String itemCode;
    /**
     * 数量
     */
    @Excel(name = "数量")
    private BigDecimal itemQty;

    /**
     * 是否客供原料 1 不是  2 是
     */
    @Excel(name = "是否客供原料")
    private String isCustMaterial;

    /**
     * 是否客供包材 1 不是  2 是
     */
    @Excel(name = "是否客供包材 ")
    private String isCustPackage;

    private MultipartFile file;

    private List<TContractdtlVo> itemData;


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public List<TContractdtlVo> getItemData() {
        return itemData;
    }

    public void setItemData(List<TContractdtlVo> itemData) {
        this.itemData = itemData;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public BigDecimal getItemQty() {
        return itemQty;
    }

    public void setItemQty(BigDecimal itemQty) {
        this.itemQty = itemQty;
    }

    public String getIsCustMaterial() {
        return isCustMaterial;
    }

    public void setIsCustMaterial(String isCustMaterial) {
        this.isCustMaterial = isCustMaterial;
    }

    public String getIsCustPackage() {
        return isCustPackage;
    }

    public void setIsCustPackage(String isCustPackage) {
        this.isCustPackage = isCustPackage;
    }
}
