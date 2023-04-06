package com.jotime.web.service.common.impl;

import com.jotime.common.config.OSSConfig;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.enums.OSSBusTypeFolder;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.common.utils.joTime.OSSUtil;
import com.jotime.web.domain.file.FileManage;
import com.jotime.web.service.common.IUploadOSSService;
import com.jotime.web.service.file.IFileManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 文件上传OSSService接口
 *
 * @author ruoyi
 * @date 2022-03-02
 */
@Service
public class UploadOSSServiceImpl implements IUploadOSSService {
    @Autowired
    private OSSConfig ossConfig;
    @Autowired
    private IFileManageService iFileManageService;

    /**
     * 上传文件至阿里云 oss
     *
     * @param file
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public AjaxResult uploadOSSFile(MultipartFile file, String busType) throws Exception {

        long size = (file.getSize() / 1024) / 1024;
        //最大mb数
        int maxMb = 20;
        if (size > maxMb) {
            return AjaxResult.error("文件最大为20mb,超出限制请重新上传");
        }
        OSSBusTypeFolder ossBusTypeFolder = OSSBusTypeFolder.getEnum(busType);
        if (StringUtils.isNull(ossBusTypeFolder)) {
            return AjaxResult.error("对应的文件存在路径没有设置,请确认后再上传！");
        }

        String strFileDir = OSSBusTypeFolder.getEnum(busType).getOssFolder();

        String[] arrDate = DateUtils.getDate().split("-");
        strFileDir = strFileDir + "/" + arrDate[0] + "/" + arrDate[1] + arrDate[2];
        String ossUrl = OSSUtil.uploadFileToOSS(ossConfig, file, strFileDir);
        if (ossUrl == null) {
            return AjaxResult.error(0, "文件上传失败！");
        }

        AjaxResult rtnAjax = new AjaxResult();
        rtnAjax.put(AjaxResult.CODE_TAG, 1);
        rtnAjax.put("ossUrl", ossUrl);
        rtnAjax.put("filepath", ossUrl.replaceAll(ossConfig.getFileHost(), ""));
        rtnAjax.put(AjaxResult.MSG_TAG, "文件上传成功！");

        return rtnAjax;
    }

    /**
     * 上传文件至阿里云 oss
     *
     * @param file
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public AjaxResult uploadLocalOSSFile(File file, String folder, String busType) throws Exception {

        long size = (file.length() / 1024) / 1024;
        //最大mb数
        int maxMb = 50;
        if (size > maxMb) {
            return AjaxResult.error("文件最大为20mb,超出限制请重新上传");
        }
        OSSBusTypeFolder ossBusTypeFolder = OSSBusTypeFolder.getEnum(busType);
        if (StringUtils.isNull(ossBusTypeFolder)) {
            return AjaxResult.error("对应的文件存在路径没有设置,请确认后再上传！");
        }

        String strFileDir = OSSBusTypeFolder.getEnum(busType).getOssFolder();

        String[] arrDate = DateUtils.getDate().split("-");
        if (StringUtils.isNotEmpty(folder)) {
            strFileDir = strFileDir + "/" + folder + "/" + arrDate[0] + "/" + arrDate[1] + arrDate[2];
        } else {
            strFileDir = strFileDir + "/" + arrDate[0] + "/" + arrDate[1] + arrDate[2];
        }

        String ossUrl = OSSUtil.uploadLocalFileToOSS(ossConfig, file, strFileDir);
        if (ossUrl == null) {
            return AjaxResult.error(0, "文件上传失败！");
        }

        AjaxResult rtnAjax = new AjaxResult();
        rtnAjax.put(AjaxResult.CODE_TAG, 1);
        rtnAjax.put("ossUrl", ossUrl);
        rtnAjax.put("filepath", ossUrl.replaceAll(ossConfig.getFileHost(), ""));
        rtnAjax.put(AjaxResult.MSG_TAG, "文件上传成功！");

        return rtnAjax;
    }

    /**
     * 上传文件至阿里云 oss
     *
     * @param filePath 删除文件
     * @return
     * @throws Exception
     */
    @Override
    public AjaxResult deleteOSSFile(String[] filePath) {
        return OSSUtil.deleteFileFmOSS(ossConfig, filePath);
    }


    @Override
    public AjaxResult removeOssFile(FileManage fileManage) {
        if (StringUtils.isNotEmpty(fileManage.getUuidList())) {
            iFileManageService.removeFileDataByTableId(fileManage.getUuidList());
        }
        this.deleteOSSFile(fileManage.getFilePaths());
        return AjaxResult.success();
    }
}
