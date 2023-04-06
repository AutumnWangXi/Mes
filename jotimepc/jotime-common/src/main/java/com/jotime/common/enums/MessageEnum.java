package com.jotime.common.enums;

public enum MessageEnum {
    qc_reviewer("质检结果","{0}质检结果{1}");

    MessageEnum(String msgTitle,String msgValue){
        this.msgTitle = msgTitle;
        this.msgValue = msgValue;
    }
    private String msgTitle;
    private String msgValue;

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgValue() {
        return msgValue;
    }

    public void setMsgValue(String msgValue) {
        this.msgValue = msgValue;
    }
}
