package com.jotime.common.enums;

/**
 * @Author: 73628
 * @Date: 2022/11/16 10:47
 * @Description: 字典
 */
public enum DictEnum {
    SYS_JOTIME_ITEM_TYPE("sys_jotime_item_type","物料类型"),
    ORDER_DEVICE_STATUS("order_device_status","生产设备状态"),
    SYS_CONNETION_STATUS("sys_connetion_status","端口连接状态"),
    SYS_JOTIME_DATA_STATUS("sys_jotime_data_status","云陌仟系统状态"),
    SYS_BASE_DEVICE_STATUS("sys_base_device_status","设备状态"),
    SYS_MERGE_STATUS("sys_merge_status","订单出库状态"),
    SYS_ITEM_WEIGH("sys_item_weigh","物料是否称重"),

    ;
    DictEnum(String code, String name){
        this.code = code;
        this.name = name;
    }

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
