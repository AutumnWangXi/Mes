package com.jotime.common.enums;

public enum MsgErr {
    bom_err1(-1,"配方不存在"),
    bom_err2(-2,"巡检模板不存在"),
    bom_err3(-3,"巡检内容不能为空"),
    bom_err4(-4,"巡检记录插入失败"),
    bom_err5(-5,"巡检任务不存在"),

    file_err1(-6,"文件已存在"),
    file_err2(-7,"同文件夹下文件名称重复")

    ;

    MsgErr(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public static MsgErr getEnum(int code) {
        for (MsgErr ele : MsgErr.values()) {
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
