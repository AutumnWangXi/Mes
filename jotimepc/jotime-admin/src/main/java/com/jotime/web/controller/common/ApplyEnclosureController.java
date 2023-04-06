package com.jotime.web.controller.common;

import com.jotime.common.config.RuoYiConfig;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.utils.joTime.JoTimeFileUploadUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chen.
 * 附件上传控制层
 */
@RestController
@RequestMapping("/web/apply/common")
public class ApplyEnclosureController extends BaseController {
    /**
     * 生成新文件路径并返回路径
     *
     * @param request 请求信息
     * @return 附件表更新
     */
    @PostMapping("/upload")
    @ResponseBody
    public Map<String, Object> addSave(HttpServletRequest request) {
        Map<String, Object> returnMap = new HashMap<>();
        //状态 0失败 1成功
        returnMap.put("code", 0);
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile mf = req.getFile("file");

        String fileName = mf.getOriginalFilename();
        fileName = JoTimeFileUploadUtil.renameToUUID(fileName);
        Calendar now = Calendar.getInstance();
        String filePath = RuoYiConfig.getUploadPath() + "/" +
                now.get(Calendar.YEAR) + "/" +
                (now.get(Calendar.MONTH) + 1) + "/" +
                now.get(Calendar.DAY_OF_MONTH) + "/";

        try {
            JoTimeFileUploadUtil.uploadFile(mf.getBytes(), filePath, fileName);
        } catch (Exception e) {
            e.printStackTrace();
            returnMap.put("msg", "图片上传失败！");
            return returnMap;
        }

        String ossUrl = filePath + fileName;
        returnMap.put("code", 1);
        returnMap.put("ossUrl", ossUrl);
        returnMap.put("msg", "图片上传成功！");
        return returnMap;
    }
}
