package com.jotime.web.utils.wkhtmltopdf.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.net.InetAddress;


/**
 * @author luoYang
 */
public class ThisIpUtils {
    private static final Logger log = LoggerFactory.getLogger(ThisIpUtils.class);

    public static String getThisUrl(String service, String servicePath) {
        String ip = "";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            ip = addr.getHostAddress();
        } catch (Exception e) {
            log.error("无法获取到本机ip", e);
        }
        if (ObjectUtils.isEmpty(ip)) {
            ip = "127.0.0.1";
        }
        return ip + ":8080" + service + servicePath;
    }
}
