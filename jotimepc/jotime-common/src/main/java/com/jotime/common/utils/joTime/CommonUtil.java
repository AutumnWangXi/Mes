package com.jotime.common.utils.joTime;

import com.jotime.common.utils.StringUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;

/**
 * @author yunmoqian
 * 通用工具类
 */
public class CommonUtil {
    /**
     * URL解码处理
     *
     * @param valueName URL中文字符串
     * @return 解码后字符
     */
    public static String URLDecoder(String valueName) {
        String name = "";
        try {
            name = URLDecoder.decode(valueName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            name = "URL解码异常,请稍后重试或联系管理员!";
        }
        return name;
    }

    /**
     * 统计转换
     *
     * @param count 统计次数
     * @return 转换结果
     */
    public static int mapCount(Long count) {
        if (count == null) {
            return 0;
        } else {
            return count.intValue();
        }
    }

    /**
     * 判断分割后循环的字符是否为空
     *
     * @param string 分割后的数据
     * @return 空字符
     */
    public static String arrayConversion(String string, Integer type) {
        if (type == 1) {
            if (StringUtils.isNotNull(string)) {
                return string;
            } else {
                return "";
            }
        } else {
            if (StringUtils.isNotNull(string)) {
                return string;
            } else {
                return "0";
            }
        }
    }

    public static Long arrayConversion(Long data, Integer type) {
        if (type == 1) {
            if (StringUtils.isNotNull(data)) {
                return data;
            } else {
                return null;
            }
        } else {
            return 0L;
        }
    }

    /**
     * 库存计算工具
     *
     * @param quantity    总数量
     * @param subQuantity 需要减去的数量
     * @return 计算后的数量
     */
    public static BigDecimal subPriceCalculation(BigDecimal quantity, BigDecimal subQuantity) {
        if (quantity.compareTo(subQuantity) > -1) {
            return quantity.subtract(subQuantity);
        } else {
            return BigDecimal.valueOf(0);
        }
    }


}
