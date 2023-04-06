package com.jotime.common.constant;

/**
 * 供应商常量
 *
 * @author zhangjun
 */
public class SupplierConstants
{
    /** 供应商编码名称 */
    public final static String SYS_SUPPLIER_TYPE = "sys_supplier_type";
    /** 校验返回结果码 */
    public final static String UNIQUE = "0";
    public final static String NOT_UNIQUE = "1";

    /** 校验返回结果码
     *
     * CHECK_STATUS_WAITING 待审核
     * CHECK_STATUS_DODING  审核中
     * CHECK_STATUS_PASS     通过
     * CHECK_STATUS_REJECT   驳回
     *
     * */
    public final static String CHECK_STATUS_WAITING = "1";
    public final static String CHECK_STATUS_DODING = "2";
    public final static String CHECK_STATUS_PASS = "3";
    public final static String CHECK_STATUS_REJECT= "9";

    public final static Integer SUPPLIERID = 6325;
    /** 自身供应商代码 */
    public final static String SUPP_SELF_CODE = "2070";
}
