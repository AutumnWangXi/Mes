package com.jotime.web.service.common;

import com.jotime.common.core.domain.AjaxResult;
import com.jotime.web.domain.file.FileManage;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 文件上传OSSService接口
 * 
 * @author ruoyi
 * @date 2022-03-02
 */
public interface IUploadOSSService
{
    /**
     * 上传文件至阿里云 oss
     *
     * @param file
     * @param busType 业务类型
     * @return
     * @throws Exception
     */
    public AjaxResult uploadOSSFile(MultipartFile file, String busType) throws Exception;

    /**
     * 上传文件至阿里云 oss
     *
     * @param file
     * @param busType 业务类型
     * @return
     * @throws Exception
     */
    public AjaxResult uploadLocalOSSFile(File file, String folder, String busType) throws Exception;

    /**
     * 删除OSS上的文件
     *
     * @param fileUrl 删除文件地址
     * @return
     * @throws Exception
     */
    public AjaxResult deleteOSSFile(String[] fileUrl);

    /**
     * 删除OSS上的文件
     *
     * @param fileManage 删除文件地址
     * @return
     */
    public AjaxResult removeOssFile(FileManage fileManage);
}
