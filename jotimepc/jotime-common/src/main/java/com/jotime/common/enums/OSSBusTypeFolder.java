package com.jotime.common.enums;

import com.jotime.common.utils.StringUtils;

/**
 * OSS业务文件目录
 * 
 * @author ruoyi
 */
public enum OSSBusTypeFolder
{
    /**
     * 申请--打样
     */
    APVL_FORMULA("A01","apply/formula"),
    /**
     * 申请--合同
     */
    APVL_CONTRACT("A02","apply/contract"),
    /**
     * 申请--生产
     */
    APVL_PRODUCE("A03","apply/produce"),
    /**
     * 申请--销售出库
     */
    APVL_SELL("A04","apply/sell"),
    /**
     * 申请--订单采购
     */
    APVL_PURCHASE("A05","apply/purChase"),
    /**
     * 申请--打印
     */
    APVL_PRINT("A06","apply/print"),
    /**
     * 申请--报价申请
     */
    APVL_QUOTE("A07","apply/quote"),
    /**
     * 申请--评论附件
     */
    APVL_COMMENT("A08","apply/comment"),
    /**
     * 申请--备货采购
     */
    APVL_STOCKPUR("A09","apply/stockPurChase"),
    /**
     * 申请--缺陷评审
     */
    APVL_DEFECT("A10","apply/defect"),
    /**
     * 申请--其他
     */
    APVL_OTHER("A99","apply/other"),

    /**
     * 研发--评估表(打样评估表、实验室评估表、业务评估表)
     */
    RD_FORMULA("B01","rd/evaluation"),
    /**
     * 研发--检验结果(生化、理化检验等)
     */
    RD_OTHER("B99","rd/other"),
    /**
     * 质检模板
     */
    QC_TEMPLATE("C01","qc/template"),
    /**
     * 质检记录文件
     */
    QC_TEST("C02","qc/test"),
    /**
     * 质检打印文件
     */
    QC_PRINT("C03","qc/print"),
    /**
     * 质检打印文件
     */
    QC_IPQC("C04","qc/ipqc"),
    /**
     * 质检打印文件
     */
    QC_OTHER("C99","qc/other"),
    /**
     * COA文件
     */
    QC_COA("COA","qc/coa"),
    /**
     * 生产
     */
    PD_PROCESS("D01","pd/process"),
    /**
     * 基础表(物料表关联)
     */
    BASE_ITEM("E01","base/item"),
    /**
     * 基础表(设备表关联)
     */
    BASE_DEVICE("E02","base/device"),
    /**
     * 基础表(设备表关联)
     */
    BASE_EMP("E03","base/employee"),
    /**
     * 基础表(其他)
     */
    BASE_OTHER("E99","base/other"),
    /**
     * 配方(bom物料关联)
     */
    BOM_ITEM("F01","bom/bomItem"),
    /**
     * 配方--检验结果(生化、理化检验等)
     */
    BOM_TEST("F02","bom/test"),
    /**
     * 配方--关联工艺文档(生化、理化检验等)
     */
    BOM_PROCESS("F03","bom/process"),
    /**
     * 配方--打印
     */
    BOM_PRINT("F04","bom/print"),
    /**
     * 配方--其他
     */
    BOM_OTHER("F99","bom/other"),
    /**
     * 仓库-入库通知（供应商原料质检报告等）
     */
    STOCK_NOTICE("G01","stock/notice"),
    /**
     * 仓库-标签打印文件等
     */
    STOCK_PRINT("G02","stock"),
    /**
     * 仓库-其他
     */
    STOCK_OTHER("G99","stock/other"),
    RECORD("record","record"),
    /**
     * 文件--文件清单
     */
    FILE_LIST("J01","file/fileList"),
    /**
     * 文件--文件记录
     */
    FILE_RECORD("J02","file/record"),
    /**
     * 文件--文件清单pdf
     */
    FILE_LIST_R("J03","file/fileListPdf"),
    /**
     * 文件--文件记录pdf
     */
    FILE_RECORD_R("J04","file/recordPdf"),
    /**
     * 文件--文件其他
     */
    FILE_OTHER("J99","file/other"),
    OTHER("other", "other");

    private final String code;
    private final String ossFolder;

    OSSBusTypeFolder(String code, String ossFolder)
    {
        this.code = code;
        this.ossFolder = ossFolder;
    }

    public static OSSBusTypeFolder getEnum(String code) {
        for (OSSBusTypeFolder ele : OSSBusTypeFolder.values()) {
            if (StringUtils.strEquals(ele.getCode(), code)) {
                return ele;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getOssFolder() {
        return ossFolder;
    }
}
