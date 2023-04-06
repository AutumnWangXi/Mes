package com.jotime.web.utils.wkhtmltopdf.utils;

import com.jotime.common.utils.StringUtils;

public class ComputingTools {


    /**
     * String 类型相加判断
     * @param a
     * @param b
     * @return
     */
   public static String  StringAdd(String a, String b){
       if (StringUtils.isNotBlank(a) && StringUtils.isNotBlank(b)){
           return a+b;
       }else {
            if (StringUtils.isNotBlank(a) || StringUtils.isNotBlank(b)){
                if (StringUtils.isNotBlank(a)){
                    return a;
                }else {
                    return b;
                }
            }else {
                return null;
            }
       }
   }


   //测试
    public static void main(String[] args) {
       String a = " ";
       String b  = " ";
       System.out.println(StringAdd(a,b));
    }




}
