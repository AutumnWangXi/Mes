package com.jotime.web.utils.wkhtmltopdf.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取请求头
 *
 * @author luoYang
 */
public class RequstHeaderUtils {
    private static final Logger log = LoggerFactory.getLogger(RequstHeaderUtils.class);

    public static Map<String, String> getHeaderMap(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String, String> map = new HashMap<>(16);
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

    public static String getData(HttpServletRequest request) {
        Map<String, String> headerMap = RequstHeaderUtils.getHeaderMap(request);
        if (ObjectUtils.isEmpty(headerMap)) {
            headerMap = new HashMap<>(1);
        }
        String headerData = headerMap.get("data");
        String data;
        try {
            //解析转义后的参数
            data = URLDecoder.decode(ObjectUtils.isEmpty(headerData) ? "" : headerData, "utf-8");
            return data;
        } catch (Exception e) {
            log.error("网络传输转义失败", e);
        }
        return "";
    }
}
