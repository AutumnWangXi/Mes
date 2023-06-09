package com.jotime.common.utils.joTime;

import com.baomidou.mybatisplus.core.toolkit.StringPool;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: chenkuo
 * @Date: 2022/04/21/17:46
 * @Description:
 */
public class AgileUtil {

    /**
     * 判断指定对象是否为空，支持：
     *
     * <pre>
     * 1. CharSequence
     * 2. Map
     * 3. Iterable
     * 4. Iterator
     * 5. Array
     * </pre>
     *
     * @param object 被判断的对象
     * @return 是否为空，如果类型不支持，返回false
     */
    public static Boolean isEmpty(final Object object) {
        if (null == object) {
            return Boolean.TRUE;
        }
        if (object instanceof CharSequence) {
            return 0 == object.toString().length();
        } else if (object instanceof Map) {
            return ((Map<?, ?>) object).isEmpty();
        } else if (object instanceof Iterable) {
            return !((Iterable<?>) object).iterator().hasNext();
        } else if (object instanceof Iterator) {
            return !((Iterator<?>) object).hasNext();
        } else if (object.getClass().isArray()) {
            return 0 == Array.getLength(object);
        }
        return Boolean.FALSE;
    }

    /**
     * 一次性判断多个或单个对象为空。
     *
     * @param objects - 最少一个对象
     * @return Boolean - 只要有一个元素为Empty，则返回true
     */
    public static Boolean isEmpty(Object... objects) {
        boolean result = false;
        for (Object object : objects) {
            if (isEmpty(object)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 判断指定对象是否为非空，支持：
     *
     * <pre>
     * 1. CharSequence
     * 2. Map
     * 3. Iterable
     * 4. Iterator
     * 5. Array
     * </pre>
     *
     * @param object 被判断的对象
     * @return 是否为空，如果类型不支持，返回true
     */
    public static Boolean isNotEmpty(final Object object) {
        return !isEmpty(object);
    }

    /**
     * 一次性判断多个或单个对象非空判断
     *
     * @param objects - 最少一个对象
     * @return Boolean
     */
    public static Boolean isNotEmpty(Object... objects) {
        return !isEmpty(objects);
    }

    /**
     * 判断对象是否为纯数字
     *
     * @param object - 最少一个对象
     * @return Boolean - true - 纯数字
     */
    public static Boolean isNumeric(final Object object) {
        return isNotEmpty(object) && object.toString().chars().allMatch(Character::isDigit);
    }

    /**
     * 删除 HTML 标签
     *
     * @param htmlStr - HTML
     * @return String - 字符串
     */
    public static String delHtmlTag(String htmlStr) {
        if (isEmpty(htmlStr)){
            return htmlStr;
        }
        // 定义script的正则表达式
        final String regExScript = "<script[^>]*?>[\\s\\S]*?<\\/script>";
        // 定义style的正则表达式
        final String regExStyle = "<style[^>]*?>[\\s\\S]*?<\\/style>";
        // 定义HTML标签的正则表达式
        final String regExHtml = "<[^>]+>";
        // 过滤script标签
        Pattern scriptPattern = Pattern.compile(regExScript, Pattern.CASE_INSENSITIVE);
        Matcher scriptMatcher = scriptPattern.matcher(htmlStr);
        htmlStr = scriptMatcher.replaceAll(StringPool.EMPTY);
        // 过滤style标签
        Pattern stylePattern = Pattern.compile(regExStyle, Pattern.CASE_INSENSITIVE);
        Matcher styleMatcher = stylePattern.matcher(htmlStr);
        htmlStr = styleMatcher.replaceAll(StringPool.EMPTY);
        // 过滤html标签
        Pattern htmlPattern = Pattern.compile(regExHtml, Pattern.CASE_INSENSITIVE);
        Matcher htmlMatcher = htmlPattern.matcher(htmlStr);
        htmlStr = htmlMatcher.replaceAll(StringPool.EMPTY);
        // 返回文本字符串
        return htmlStr.trim();
    }

}
