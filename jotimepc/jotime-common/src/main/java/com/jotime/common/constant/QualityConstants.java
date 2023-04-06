package com.jotime.common.constant;

public class QualityConstants {
    /** 质检记录表审核状态（1 待审核  2 已审核）*/
    public final static Integer CHECK_STATUS_OK = 2;
    public final static Integer CHECK_STATUS_NO = 1;
    public final static Integer CHECK_STATUS_STAY = 0;


    /** 质检记录表评审状态(1 待评审  2 评审中 3 已评审） */
    public final static Integer REVIEW_STATUS_STAY = 1;
    public final static Integer REVIEW_STATUS_IN = 2;
    public final static Integer REVIEW_STATUS_OK = 3;

    /** 质检任务状态1 待质检 2 已指派 3 质检中 4待审核 5 审核中 6待评审 7评审中 8已检已审  99取消） */
    public final static Integer TASK_STATUS_1 = 1;
    public final static Integer TASK_STATUS_2 = 2;
    public final static Integer TASK_STATUS_3 = 3;
    public final static Integer TASK_STATUS_4 = 4;
    public final static Integer TASK_STATUS_5 = 5;
    public final static Integer TASK_STATUS_6 = 6;
    public final static Integer TASK_STATUS_7 = 7;
    public final static Integer TASK_STATUS_8 = 8;
    public final static Integer TASK_STATUS_99 = 99;

    /** 质检人员工作信息表 状态(1 待质检  2 质检中 3 已质检 4转移  9 取消)*/
    public final static Integer WORKINFO_STATUS_1 = 1;
    public final static Integer WORKINFO_STATUS_2 = 2;
    public final static Integer WORKINFO_STATUS_3 = 3;
    public final static Integer WORKINFO_STATUS_4 = 4;
    public final static Integer WORKINFO_STATUS_9 = 9;
    /**质检模板 1 禁用  2 正常*/
    public final static Integer qc_templates_ok = 2;
    public final static Integer qc_templates_no = 1;

    /**巡检模板 1 禁用  2 正常*/
    public final static Integer ipqc_templates_ok = 2;
    public final static Integer ipqc_templates_no = 1;

    /**物料巡检表 1 禁用  2 正常*/
    public final static Integer ipqc_item_bind_ok = 2;
    public final static Integer ipqc_item_bind_no = 1;

    /**质检审核结果 1 合格 2 退货 3 让步放行 4 特采 5返工 6报废 7 处理或者挑选99其他*/
    public final static int QC_RESULT_OK = 1;
    public final static int QC_RESULT_NG = 2;
    public final static int QC_RESULT_GIVE = 3;
    public final static int QC_RESULT_WAIVED = 4;
    public final static int QC_RESULT_RTW = 5;
    public final static int QC_RESULT_BU = 6;
    public final static int QC_RESULT_SEL = 7;
    public final static int QC_RESULT_OTHER = 99;

    /**
     * 质检管理状态 1 未质检 2 已检未审 3 已检已审 9 入库取消
     */
    public static final int QC_STATUS_1 = 1;
    public static final int QC_STATUS_2 = 2;
    public static final int QC_STATUS_3 = 3;
    public static final int QC_STATUS_9 = 9;

    /**质检来源 1 采购 2 生产 3 客供 9 其他 */
    public final static int QC_ORIGIN_PUR = 1;
    public final static int QC_ORIGIN_PD = 2;
    public final static int QC_ORIGIN_CUS = 3;
    public final static int QC_ORIGIN_OTHER = 9;

    /**
     * 检验状态 1 待检验 2 已检验
     */
    public static final int QC_TEST_STS_WAIT = 1;
    public static final int QC_TEST_STS_FINISH = 2;

    /**
     * 微生物检验结果
     */
    public static final int QC_TEST_RESULT_FAIL = 1;
    public static final int QC_TEST_RESULT_PASS = 2;
    public static final int QC_TEST_RESULT_IE = 3;

    /**
     * 生产
      */
    public static final int TASK_ORIGIN_1 = 1;
    /**
     * 制度规范巡检
     */
    public static final int TASK_ORIGIN_2 = 2;
    /**
     * 其他
     */
    public static final int TASK_ORIGIN_9 = 9;



    /**
     * 1待检验 2 已检验 3 免检
     */
    public static final int INSPECTION_STATUS_1 = 1;
    public static final int INSPECTION_STATUS_2 = 2;
    public static final int INSPECTION_STATUS_3 = 3;

    /**生产首检（QC 质检  FIRST 首检 RECHK复检 OTHER 其他）*/
    public final static String TASK_FIRST_TESTS_QC = "QC";
    public final static String TASK_FIRST_TESTS_FIRST = "FIRST";
    public final static String TASK_FIRST_TESTS_RECHK = "RECHK";
    public final static String TASK_FIRST_TESTS_OTHER = "OTHER";

    /**巡回检查 1 待巡检 2巡检中 3巡检完成 99取消*/
    public final static int PATROL_INSPECTION_STATUS_1 = 1;
    public final static int PATROL_INSPECTION_STATUS_2 = 2;
    public final static int PATROL_INSPECTION_STATUS_3 = 3;
    public final static int PATROL_INSPECTION_STATUS_99 = 99;

    /**检验项目类型（1 感官 2 微生物 3 理化 4 稳定）*/
    public final static int QC_TEST_TYPE_1 = 1;
    /**检验项目类型（1 感官 2 微生物 3 理化 4 稳定）*/
    public final static int QC_TEST_TYPE_2 = 2;
    /**检验项目类型（1 感官 2 微生物 3 理化 4 稳定）*/
    public final static int QC_TEST_TYPE_3 = 3;
    /**检验项目类型（1 感官 2 微生物 3 理化 4 稳定）*/
    public final static int QC_TEST_TYPE_4 = 4;

    public final static String QC_SUPPLIER_CODE = "2070";


}
