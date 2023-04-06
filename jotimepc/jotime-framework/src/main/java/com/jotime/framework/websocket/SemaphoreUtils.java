package com.jotime.framework.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

/**
 * 信号量相关处理
 * 
 * @author ruoyi
 */
public class SemaphoreUtils
{
    /**
     * SemaphoreUtils 日志控制器
     */
    private static final Logger log = LoggerFactory.getLogger(SemaphoreUtils.class);

    /**
     * 获取信号量
     * 
     * @param semaphore
     * @return
     */
    public static boolean tryAcquire(Semaphore semaphore) {
        boolean flag = false;

        try {
            flag = semaphore.tryAcquire();
        } catch (Exception e) {
            log.error("获取信号量异常", e);
        }

        return flag;
    }

    /**
     * 释放信号量
     * 
     * @param semaphore
     */
    public static void release(Semaphore semaphore) {

        try {
            semaphore.release();
        } catch (Exception e) {
            log.error("释放信号量异常", e);
        }
    }
}
