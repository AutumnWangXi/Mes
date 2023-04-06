package com.jotime.common.utils.joTime;

import java.text.SimpleDateFormat;


public class OmsOrderIdUtil {
    /**
     * 20位末尾的数字id
     */
    private static volatile int Guid = 100;

    /**
     *
     */
    /**
     * 20位末尾的数字id
     */
    private static volatile int WareHouseCode = 0;
    /**
     * <获取唯一id>
     *
     * @return 结果
     * @throws
     */
    public static synchronized String getGuid() {
        OmsOrderIdUtil.Guid += 1;

        long now = System.currentTimeMillis();
        //获取4位年份数字
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        //获取时间戳
        String time = dateFormat.format(now);
//        String info = now + "";
        //获取三位随机数
        //int ran=(int) ((Math.random()*9+1)*100);
        //一段时间内的数据量过大会有重复的情况，所以做以下修改
//        int ran = 0;
//        if (GenerateUniqueIdUtil.Guid > 9999) {
//            GenerateUniqueIdUtil.Guid = 10000;
//        }
//        ran = GenerateUniqueIdUtil.Guid;

        return time + OmsOrderIdUtil.Guid;
    }

    /**
     * <获取11位唯一id>
     *
     * @return 结果
     * @throws
     */
    public static synchronized String getProdueTaskId() {
        OmsOrderIdUtil.Guid += 1;

        long now = System.currentTimeMillis();
        //获取4位年份数字
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        //获取时间戳
        String time = dateFormat.format(now);
        return time + OmsOrderIdUtil.Guid;
    }

    /**
     * <获取9位唯一id>
     *
     * @return 结果
     * @throws
     */
    public static synchronized String getCommonId() {
        OmsOrderIdUtil.Guid += 1;

        long now = System.currentTimeMillis();
        //获取4位年份数字
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        //获取时间戳
        String time = dateFormat.format(now);
        return time + OmsOrderIdUtil.Guid;
    }

    /**
     * 获取库位编号
     * @return
     */
    public static synchronized String getWareHouseCode() {
        OmsOrderIdUtil.WareHouseCode += 1;
        //需要生成几位
        int n = 1;
        //最终生成的字符串
        String str = "";
        for (int i = 0; i < n; i++) {
            str = str + (char) (Math.random() * 26 + 'A') + "-" + WareHouseCode;
        }
        return str;
    }

}

