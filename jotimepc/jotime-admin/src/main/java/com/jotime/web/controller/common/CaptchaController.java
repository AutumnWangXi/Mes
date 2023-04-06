package com.jotime.web.controller.common;

import com.jotime.common.constant.Constants;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.redis.RedisCache;
import com.jotime.common.utils.uuid.IdUtils;
import com.jotime.system.service.ISysConfigService;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.base.Captcha;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 验证码操作处理
 * 
 * @author ruoyi
 */
@RestController
public class CaptchaController
{
    private static final Logger log = LoggerFactory.getLogger(CaptchaController.class);
//    @Resource(name = "captchaProducer")
//    private Producer captchaProducer;
//
//    @Resource(name = "captchaProducerMath")
//    private Producer captchaProducerMath;

    @Autowired
    private RedisCache redisCache;
    
    @Autowired
    private ISysConfigService configService;
    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    public AjaxResult getCode(HttpServletResponse response) throws IOException
    {
        AjaxResult ajax = AjaxResult.success();
        boolean captchaOnOff = configService.selectCaptchaOnOff();
        ajax.put("captchaOnOff", captchaOnOff);
        if (!captchaOnOff)
        {
            return ajax;
        }

        // 保存验证码信息
        String uuid = IdUtils.simpleUUID();
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;

//        String capStr = null, code = null;
//        BufferedImage image = null;
//
//        // 生成验证码
//        String captchaType = RuoYiConfig.getCaptchaType();
//        if ("math".equals(captchaType))
//        {
//            String capText = captchaProducerMath.createText();
//            capStr = capText.substring(0, capText.lastIndexOf("@"));
//            code = capText.substring(capText.lastIndexOf("@") + 1);
//            image = captchaProducerMath.createImage(capStr);
//            log.info("验证码:{}",code);
//        }
//        else if ("char".equals(captchaType))
//        {
//            capStr = code = captchaProducer.createText();
//            image = captchaProducer.createImage(capStr);
//        }
//
//        redisCache.setCacheObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
//        // 转换流信息写出
//        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
//        try
//        {
//            ImageIO.write(image, "jpg", os);
//        }
//        catch (IOException e)
//        {
//            return AjaxResult.error(e.getMessage());
//        }
//
//        ajax.put("uuid", uuid);
//        ajax.put("img", Base64.encode(os.toByteArray()));
//        return ajax;
        //创建算术验证码
        Captcha captcha = new ArithmeticCaptcha(115, 42);
        //得到算术验证码的计算值
        String code = captcha.text();
        redisCache.setCacheObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);//存入redis
        log.info("验证码:{}",code);
        ajax.put("uuid", uuid);
        //获得图片的base64编码
        ajax.put("img", captcha.toBase64());
        return ajax;
    }
}
