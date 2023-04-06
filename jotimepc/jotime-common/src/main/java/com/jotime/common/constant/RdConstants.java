package com.jotime.common.constant;

/**
 * 品牌常量
 * 
 * @author zhangjun
 */
public class RdConstants
{
    /** 研发打样状态(个人)
     *  1 待打样  2 打样中 3 已打样 4 转移 9取消
     *
     * */
    public final static int EEWORK_STS_WATING = 1;
    public final static int EEWORK_STS_DOING = 2;
    public final static int EEWORK_STS_FINISH = 3;
    public final static int EEWORK_STS_SHIFT = 4;
    public final static int EEWORK_STS_CANCEL = 9;


    /** 研发各配方研发状态(个人)
     *   0 开始 1 完成
     *
     * */
    public final static String FORMULATION_START = "0";
    public final static String FORMULATION_FINISH = "1";

    /** 研发各配方研发CODE
     *  攻关配方 attack  打样配方 formula 创新配方 innovative
     *
     * */
    public final static String FORMULATION_ATTACK = "planAttackFormulation";
    public final static String FORMULATION_ATTACK_NAME = "攻关配方";
    public final static String FORMULATION_FORMULA = "planFormulaFormulation";
    public final static String FORMULATION_FORMULA_NAME = "打样配方";
    public final static String FORMULATION_INNOVATIVE = "planInnovativeFormulation";
    public final static String FORMULATION_INNOVATIVE_NAME = "创新配方";

    /** 研发各配方研发开始按钮识别(个人)
     *   攻关配方 attack  打样配方 formula 创新配方 innovative 全部 all
     *
     * */
    public final static String START_BUT_ATTACK = "attack";
    public final static String START_BUT_FORMULA = "formula";
    public final static String START_INNOVATIVE = "innovative";
    public final static String START_BUT_ALL = "all";

    /** 查询/更新/删除标识
     *  sel 查询 up 更新  del 删除 插入 ins
     *
     *
     * */
    public final static String DATA_FLAG_SEL = "sel";
    public final static String DATA_FLAG_UP= "up";
    public final static String DATA_FLAG_DEL = "del";
    public final static String DATA_FLAG_INS = "ins";

    /** 研发部门打样状态(部门)
     *  1 待分配  2 已分配 3打样中 4实验室评估中 5业务评估中 6评估完成 99 取消
     *
     * */
    public final static int DEPT_STS_UNDISTRIBUTION = 1;
    public final static int DEPT_STS_DISTRIBUTION = 2;
    public final static int DEPT_STS_FORMULA = 3;
    public final static int DEPT_STS_LABORATORY = 4;
    public final static int DEPT_STS_BUSINESS = 5;
    public final static int DEPT_STS_EVALUATION_FINISH = 6;
    public final static int DEPT_STS_CANCEL = 99;

    /** 研发打样状态
     *  1 待评估  2待分配  3 已分配 4 打样中  6已打样  99取消
     *
     * */
    public final static int STS_UNASSESS = 1;
    public final static int STS_UNDISTRIBUTION = 2;
    public final static int STS_DISTRIBUTION = 3;
    public final static int STS_FORMULA = 4;
    public final static int STS_FORMULA_FINISH = 6;
    public final static int STS_CANCEL = 99;

    /** 研发评估结果
     *  1 不通过 2 通过
     *
     * */
    public final static int ASSESS_RESULT_PASS = 2;
    public final static int ASSESS_RESULT_FAIL = 1;

    /** 研发部代码
     *
     * */
    public final static String RD_DEPT_CODE = "RD";

    /** 权限标识
     *
     * */
    public final static String RD_PERMI_CODE = "rd";
    public final static String RD_PERMI_DEPT_CODE = "dept";
    public final static String RD_PERMI_EMP_CODE = "ee";

    /** 配方成熟度
     *
     *  1 一期配方 2 二期配方 3观察配方 4 成熟配方
     * */
    public final static int FORMULA_RIPENSS_ONE = 1;
    public final static int FORMULA_RIPENSS_TWO = 2;
    public final static int FORMULA_RIPENSS_WATCH = 3;
    public final static int FORMULA_RIPENSS_MUTURE = 4;

    /** 是否取样
     *
     * 是否取样配方 1 否 2 是
     * */
    public final static int RD_IS_SAMPLE_1 = 1;
    public final static int RD_IS_SAMPLE_2 = 2;
}
