package com.jotime.web.controller.common;


import com.jotime.common.annotation.Log;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.file.FileManage;
import com.jotime.web.service.common.IUploadOSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yunmoqian
 */
@RestController
@RequestMapping("/oss")
public class UploadOSSController {

    @Autowired
    private IUploadOSSService uploadOSSService;

    /**
     * 上传文件至阿里云 oss
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/uploadFile")
    @Log(title = "上传文件至阿里云OSS", businessType = BusinessType.INSERT)
    @ResponseBody
    public AjaxResult uploadOSSFile(HttpServletRequest request) throws Exception {

        //状态 0失败 1成功
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        // 业务类型
        String strBusType = req.getParameter("busType");
        MultipartFile mf = req.getFile("file");
        if (ObjectUtils.isEmpty(mf)) {
            return AjaxResult.error(0, "文件无法识别，或者上传为空文件");
        }

        return uploadOSSService.uploadOSSFile(mf, strBusType);
    }

    /**
     * 删除OSS文件
     *
     * @param filePath 文件路径
     * @return 操作消息
     */
    @RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult deleteFile(@RequestBody String[] filePath) {
        if (StringUtils.isNull(filePath)) {
            return AjaxResult.error(0, "删除文件地址不能为空！");
        }

        return uploadOSSService.deleteOSSFile(filePath);
    }

    /**
     * 删除OSS文件
     *
     * @param fileManage 文件路径
     * @return 操作消息
     */
    @RequestMapping(value = "/removeOssFile", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult removeOssFile(@RequestBody FileManage fileManage) {
        if (StringUtils.isNull(fileManage.getFilePaths())) {
            return AjaxResult.error(0, "删除文件地址不能为空！");
        }
        return uploadOSSService.removeOssFile(fileManage);
    }
}
