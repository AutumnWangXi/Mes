package com.jotime.common.utils.joTime;

/**
 * @author yunmoqian
 */
public class JoTimeTypeConversionUtil {
    /**
     * 根据车间名转换类型
     *
     * @param type 车间名称
     * @return 物料类型
     */
    public static Boolean typeConversion(String type) {
        if (type.contains("内料库存正常")) {
            type = "内料库存正常";
        } else if (type.contains("半成品库存正常")) {
            type = "半成品库存正常";
        } else if (type.contains("成品库存正常")) {
            type = "成品库存正常";
        } else {
            type = "";
        }
        switch (type) {
            case "内料库存正常":
                return true;
            case "半成品库存正常":
                return true;
            case "成品库存正常":
                return true;
            default:
                return false;
        }
    }
}
