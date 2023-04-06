package com.jotime.common.constant;

/**
 * 物料常量
 *
 * @author zhangjun
 */
public class ItemConstants
{
    /** 校验返回结果码 */
    public final static String CHECK_OK = "0";
    public final static String CHECK_NG = "1";

    /** 是否  1 否 2 是*/
    public final static int NEED_YES = 2;
    public final static int NEED_NO = 1;

    /** 物料类型值
     *
     * ITEM_TYPE_MATERIAL 原料
     * ITEM_TYPE_PACKAGE 包材
     * ITEM_TYPE_PREMIX 预处理料
     * ITEM_TYPE_INNERMATERIAL 内料
     * ITEM_TYPE_PRODUCT 成品
     * ITEM_TYPE_PRODUCTS 半成品
     * ITEM_TYPE_CONSUMABLE 耗材
     *
     * */
    public final static int ITEM_TYPE_MATERIAL = 1;
    public final static int ITEM_TYPE_PACKAGE = 2;
    public final static int ITEM_TYPE_PREMIX = 3;
    public final static int ITEM_TYPE_INNERMATERIAL = 4;
    public final static int ITEM_TYPE_PRODUCTS = 5;
    public final static int ITEM_TYPE_PRODUCT = 6;
    public final static int ITEM_TYPE_CONSUMABLE = 7;
    public final static int ITEM_TYPE_ORTHER = 99;

    /** 客户页面类型
     *
     * PAGE_MATERIAL 原料
     * PAGE_PACKAGE  包材
     * PAGE_PREMIX 预处理
     * PAGE_PRODUCT 产品
     *PAGE_CONSUMABLE 耗材
     * ITEM_TYPE_INNERMATERIAL 内料
     * PAGE_PRODUCTS 半成品
     *
     * */
    public final static String PAGE_MATERIAL = "material";
    public final static String PAGE_PACKAGE = "package";
    public final static String PAGE_PREMIX = "premix";
    public final static String PAGE_PRODUCT = "product";
    public final static String PAGE_INNERMATERIAL = "innerMaterial";
    public final static String PAGE_PRODUCTS = "products";
    public final static String PAGE_CONSUMABLE = "consumable";
    public final static String PAGE_TEMPORARYMATERIAL = "temporaryMaterial";

    /**物料字典类型
     *
     * SYS_PRODUCT_CATEGORY成品
     */
    public static final String SYS_PRODUCT_CATEGORY = "sys_product_category";
    public static final String SYS_PRODUCT_USE_METHODS = "sys_product_use_methods";

    /** 审核状态 1 待审核 2已审核 */
    public final static int CHECK_STS_WATING = 1;
    public final static int CHECK_STS_FINISH = 2;

    /** 物料所属 SS 自主 CS 客供 OTHER 其他 */
    public final static String ITEM_OWN_SELF = "SS";
    public final static String ITEM_OWN_CUS = "CS";
    public final static String ITEM_OWN_OTHER = "OTHER";
    /** 原料报送码状态 N 不报送 S 报送中 C 完成 */
    public final static String SUBMISSION_CODE_STS_N = "N";
    public final static String SUBMISSION_CODE_STS_S = "S";
    public final static String SUBMISSION_CODE_STS_C = "C";
}
