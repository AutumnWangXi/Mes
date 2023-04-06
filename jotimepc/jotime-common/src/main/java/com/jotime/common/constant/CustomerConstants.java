package com.jotime.common.constant;

/**
 * 客户常量
 * 
 * @author zhangjun
 */
public class CustomerConstants
{
    /** 校验返回结果码 */
    public final static String CHECK_OK = "0";
    public final static String CHECK_NG = "1";

    /** 校验返回结果码 */
    public final static int CHECK_0 = 1;
    public final static int CHECK_1 = 2;

    /** 是/不是 */
    public final static String CHECK_Y = "是";
    public final static String CHECK_N = "不是";

    /** 客户付款导入页面
     *
     * CUSTOMER_advance预付款
     * CUSTOMER_FIRSTPARAGRAPH先款后付
     * CUSTOMER_GOODSFIRST先货后款
     *
     * */
    public final static String CUSTOMER_ADVANCE = "预付款";
    public final static String CUSTOMER_FIRSTPARAGRAPH = "先款后付";
    public final static String CUSTOMER_GOODSFIRST = "先货后款";

    /**
     * 客户付款导入 0预付款  1 先款后付  2先货后款
     */
    public static final int PAYTYPE_0  = 0;
    public static final int PAYTYPE_1  = 1;
    public static final int PAYTYPE_2  = 2;

    /** 客户导入页面类型
     *
     * CUSTOMER_IMPORT_HOME 国内客户
     * CUSTOMER_IMPORT_ABROAD 国外客户
     * CUSTOMER_PAGE_ELSE 不清楚
     *
     * */
    public final static String CUSTOMER_IMPORT_HOME = "国内客户";
    public final static String CUSTOMER_IMPORT_ABROAD = "国外客户";
    public final static String CUSTOMER_PAGE_ELSE = "不清楚";

    /** 客户导入页面类型
     *
     * CUSTOMER_IMPORT_Y 正常
     * CUSTOMER_IMPORT_N 禁止
     *
     * */
    public final static String CUSTOMER_IMPORT_Y = "正常";
    public final static String CUSTOMER_IMPORT_N = "禁用";

    /**
     * 操作状态 1 禁用 2 正常
     */
    public static final int STATUS_DISABLED  = 1;
    public static final int STATUS_OK  = 2;

    /** 客户类型值
     *
     * CUSTOMER_HOME_VAL 国内客户
     * CUSTOMER_ABROAD_VAL 国外客户
     * CUSTOMER_ELSE_VAL 其他
     * */
    public final static int CUSTOMER_HOME_VAL = 1;
    public final static int CUSTOMER_ABROAD_VAL = 2;
    public final static int CUSTOMER_ELSE_VAL = 9;

    /** 客户种类值
     *
     * CUSTOMER_REGULAR_1 新客户
     * CUSTOMER_KEYOLDCUSTOMERS_2 重点老客户
     * CUSTOMER_NONKEYACCOUNT_3 非重点客户
     * */
    public final static int CUSTOMER_REGULAR_1 = 1;
    public final static int CUSTOMER_KEYOLDCUSTOMERS_2 = 2;
    public final static int CUSTOMER_NONKEYACCOUNT_3 = 3;

    /** 客户种类值
     *
     * CUSTOMER_REGULAR 新客户
     * CUSTOMER_KEYOLDCUSTOMERS 重点老客户
     * CUSTOMER_NONKEYACCOUNT 非重点客户
     * */
    public final static String CUSTOMER_REGULAR = "新客户";
    public final static String CUSTOMER_KEYOLDCUSTOMERS = "重点老客户";
    public final static String CUSTOMER_NONKEYACCOUNT = "非重点客户";

    /** 客户页面类型
     *
     * CUSTOMER_PAGE_HOME 国内客户
     * CUSTOMER_PAGE_ABROAD 国外客户
     *
     * */
    public final static String CUSTOMER_PAGE_HOME = "home";
    public final static String CUSTOMER_PAGE_ABROAD = "abroad";

    /** 自身客户代码 */
    public final static String CUS_SELF_CODE = "8012";


}
