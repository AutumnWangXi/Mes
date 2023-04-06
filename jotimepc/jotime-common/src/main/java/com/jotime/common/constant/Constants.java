package com.jotime.common.constant;

import io.jsonwebtoken.Claims;

import java.math.BigDecimal;

/**
 * 通用常量信息
 *
 * @author ruoyi
 */
public class Constants
{
    public static final String LOCATION_CODE = "B0004";
    /**
     * O
     */
    public static final Integer ZERO = 0;

    /**
     * 1
     */
    public static final Integer ONE = 1;

    /**
     * 2
     */
    public static final Integer TWO = 2;


    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 注册
     */
    public static final String REGISTER = "Register";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 防重提交 redis key
     */
    public static final String REPEAT_SUBMIT_KEY = "repeat_submit:";

    /**
     * 限流 redis key
     */
    public static final String RATE_LIMIT_KEY = "rate_limit:";

    /**
     * 验证码有效期（分钟）
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 令牌前缀
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

    /**
     * 用户ID
     */
    public static final String JWT_USERID = "userid";

    /**
     * 用户名称
     */
    public static final String JWT_USERNAME = Claims.SUBJECT;

    /**
     * 用户头像
     */
    public static final String JWT_AVATAR = "avatar";

    /**
     * 创建时间
     */
    public static final String JWT_CREATED = "created";

    /**
     * 用户权限
     */
    public static final String JWT_AUTHORITIES = "authorities";

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * RMI 远程方法调用
     */
    public static final String LOOKUP_RMI = "rmi://";

    /**
     * LDAP 远程方法调用
     */
    public static final String LOOKUP_LDAP = "ldap://";

    /**
     * 定时任务违规的字符
     */
    public static final String[] JOB_ERROR_STR = { "java.net.URL", "javax.naming.InitialContext", "org.yaml.snakeyaml",
            "org.springframework.jndi" };
    /**
     * 系统操作名
     */
    public static final String SYS_UPDATER = "system";

    /**
     * 系统数据状态 1 禁用 2 正常
     */
    public static final int STATUS_DISABLED  = 1;
    public static final int STATUS_OK  = 2;

    /**
     * 数组组装分隔符
     */
    public static final String DASH_COMMA = ",";

    /**
     * 数组组装斜杠
     */
    public static final String DASH_SLASH = "/";

    /** 查询/更新/删除标识
     *  S 查询 U 更新  D 删除 I插入
     *
     *
     * */
    public final static String DATA_FLAG_SEL = "S";
    public final static String DATA_FLAG_UP= "U";
    public final static String DATA_FLAG_DEL = "D";
    public final static String DATA_FLAG_INS = "I";

    /**
     * word后缀名
     */
    public static final String FILE_DOC_EXTENSION = ".docx";
    /**
     * excel后缀名
     */
    public static final String FILE_EXCEL_EXTENSION = ".xlsx";
    /**
     * excelwordzip存放路径
     */
    public static final String FILE_PATH = "/user/project/record/";
    /**
     * 默认一个浮动百分比 后续调整直接改这就行
     */
    public static final BigDecimal STANDARD_QTY_FLOAT = new BigDecimal("0.005");

}
