package com.jotime.common.enums;

public enum QcTaskErr {
    ERR0(0,"参数错误"),
    ERR1(-1,"质检任务不存在"),
    ERR2(-2,"质检物料模板不存在"),
    ERR3(-3,"质检记录已经存在"),
    ERR4(-4,"客户不存在"),
    ERR5(-5,"物料不存在"),
    ERR6(-6,"质检模板详情不存在"),
    ERR7(-7,"质检记录创建失败"),
    ERR8(-8,"版本号不是最大"),
    ERR9(-9,"当前物料已经有使用中的模板"),
    ERR10(-10,"获取产品信息失败"),
    ;
    QcTaskErr(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public static QcTaskErr getEnum(int code) {
        for (QcTaskErr ele : QcTaskErr.values()) {
            if (ele.getCode() == code) {
                return ele;
            }
        }
        return null;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
