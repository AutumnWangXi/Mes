package com.jotime.common.utils.joTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间转换工具类
 *
 * @author yunmoqian
 */
public class DateUtil {
    public DateUtil() {
    }

    public static String format(Date dt) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(dt);
    }
    /**
     * 格式化日期
     * @return
     */
    public static Date formatDate(String date) {
        date = date.replace("年","-");
        date = date.replace("月","-");
        date = date.replace("日","");
        date = date.replaceAll("\\.","-");
        date = date.replaceAll("/", "-");
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Date format(String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date returnDate;
        Date errorDate = new Date();
        try {
            returnDate = sdf.parse(value);
            String error = "0000-00-00";
            errorDate = sdf.parse(error);
        } catch (ParseException e) {
            e.printStackTrace();
            return errorDate;
        }
        return returnDate;
    }

    /**
     * 月数转换具体日期
     *
     * @param months 月数
     * @return 具体Date
     */
    public static Date monthTime(String months) {
        String month = months.substring(0, months.length() - 1);
        GregorianCalendar now = new GregorianCalendar();
        //可以是天数或月数  数字自定
        now.add(GregorianCalendar.MONTH, Integer.parseInt(month));
        return now.getTime();
    }
}
