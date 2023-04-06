package com.jotime.common.enums;

/**
 * @Classname EmployeeInfoExlVo
 * @Description
 * @Date 2022/6/28 14:51
 * @Created by 14812
 */
public enum EmployeeInfoExlVoEnum {
    //政治面貌
    EM_POLITICALSTATUS_ZGGCD("01","中国共产党"),
    EM_POLITICALSTATUS_ZGYBDY("02","中国预备党员"),
    EM_POLITICALSTATUS_GQTY("03","共青团员"),
    EM_POLITICALSTATUS_MGDY("04","民革党员"),
    EM_POLITICALSTATUS_MMMY("05","民盟盟员"),
    EM_POLITICALSTATUS_MJHY("06","民进会员"),
    EM_POLITICALSTATUS_MJHY2("07","男"),
    EM_POLITICALSTATUS_NGDDY("08","农工党党员"),
    EM_POLITICALSTATUS_ZGDDY("09","致公党党员"),
    EM_POLITICALSTATUS_JSXSSY("10","九三学社社员"),
    EM_POLITICALSTATUS_TMMY ("11","台盟盟员"),
    EM_POLITICALSTATUS_WDPRS("12","无党派人士"),
    EM_POLITICALSTATUS_QZ("13","群众"),
    //学历
    EM_EDUCATION_SHIXI("00","实习"),
    EM_EDUCATION_XIAOXUE("01","小学"),
    EM_EDUCATION_CHUZHONG("02","初中"),
    EM_EDUCATION_GAOZHONG("03","高中"),
    EM_EDUCATION_DAZHUAN("04","大专"),
    EM_EDUCATION_BENKE("05","本科"),
    EM_EDUCATION_SUOSHI("06","硕士"),
    EM_EDUCATION_BOSHI("07","博士"),
    EM_EDUCATION_ZHONGZHUAN("08","中专"),
    ;

    EmployeeInfoExlVoEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public static QcTaskErr getEnum(String code) {
        for (QcTaskErr ele : QcTaskErr.values()) {
            if (code.equals(ele.getCode())) {
                return ele;
            }
        }
        return null;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
