package com.jotime.common.constant;

/**
 * 品牌常量
 * 
 * @author zhangjun
 */
public class FormulaConstants
{
    /** 一期配方升级二期配方审核状态
     *  1 待申请  2 审核中 3 审核完成 4 检测报告上传
     *
     * */
    public final static int CHECK_STS_WATING = 1;
    public final static int CHECK_STS_DOING = 2;
    public final static int CHECK_STS_FINISH = 3;
    public final static int CHECK_STS_REPORT = 4;

    /** 审核结果
     *  1 不通过 2通过
     *
     * */
    public final static int CHECK_RESULT_PASS = 2;
    public final static int CHECK_RESULT_FAIL = 1;

    /** 文件类型
     *  1 理化检验报告 2 稳定性检验报告 3 微生物检验报告
     *
     * */
    public final static int TEST_FILE_BIOCHEMICAL = 1;
    public final static int TEST_FILE_STABILITY = 2;
    public final static int TEST_FILE_MICROBE = 3;

    /** 文件table名
     *
     *
     * */
    public final static String TABLE_NAME_FROMULA = "baseInitialFormula";
    public final static String TABLE_NAME_FROMULADTL = "baseInitialFormuladtl";

    /** 是否删除
     *  1 否  2 是
     *
     * */
    public final static int IS_DEL_YES = 2;
    public final static int IS_DEL_NO = 1;

    /** 类型
     *  I 插入 U 更新 D 删除
     *
     * */
    /**
     * I 插入
     */
    public final static String FORMULADTL_HIS_INSERT = "I";
    /**
     * U 更新
     */
    public final static String FORMULADTL_HIS_UPDATE = "U";
    /**
     * D 删除
     */
    public final static String FORMULADTL_HIS_DELETE = "D";

}
