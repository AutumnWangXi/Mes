package com.jotime.common.utils.joTime;

/**
 * @author yunmoqian
 * 状态码枚举
 */

public enum StatusEunm {
    /**
     * 员工信息
     */
    webApp_员工信息("0"),
    webApp_部门("1"),
    webApp_职务("2"),
    webApp_车间("3"),
    webApp_设备信息("4"),
    webApp_设备维护("5"),
    webApp_国内客户("6"),
    webApp_国外客户("7"),
    webApp_供应商("8"),
    webApp_原料("9"),
    webApp_包材("10"),
    webApp_产品("11"),
    webApp_耗材("12"),
    webApp_物料箱("13"),
    webApp_成品bom("14"),
    webApp_内料bom("15"),
    webApp_原料入库("16"),
    webApp_包材入库("17"),
    webApp_内料入库("18"),
    webApp_半成品入库("19"),
    webApp_成品入库("20"),
    webApp_瓶管类灌装过程检("21"),
    webApp_质检报告模板("23"),
    webApp_Null("null");

    private String status;

    StatusEunm(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /*
     * 匹配状态码
     * */
    public static StatusEunm matchOpStatus(String status) {
        for (StatusEunm opCode : StatusEunm.values()) {
            if (opCode.status.equals(status)) {
                return opCode;
            }
        }
        return StatusEunm.webApp_Null;
    }

}
