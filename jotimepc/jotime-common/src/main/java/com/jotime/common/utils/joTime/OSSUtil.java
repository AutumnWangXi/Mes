package com.jotime.common.utils.joTime;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.jotime.common.config.OSSConfig;
import com.jotime.common.constant.Constants;
import com.jotime.common.core.domain.AjaxResult;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.UUID;

/**
 * @author yunmoqian
 */
public class OSSUtil {
    private static final Logger log = Logger.getLogger(OSSUtil.class);
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OSSUtil.class);

    private static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    private static String accessKeyId = "LTAI5tPLnJqATFC9ArrNrNtG";
    private static String secretAccessKey = "UcHLp5J2TLP4RhEhpuLIFT724TVzAs";
    private static String ossUrl = "http://jotime-rd.oss-cn-hangzhou.aliyuncs.com/";
//    private static String ossBucket = "jotim-test";
    private static String ossBucket = "jotim-cosmes";

    private OSSUtil() {
    }

    /**
     * 上传文件至阿里云 OSS
     * 文件上传成功,返回文件完整访问路径
     * 文件上传失败,返回 null
     *
     * @param ossConfig oss 配置信息
     * @param file      待上传文件
     * @param fileDir   文件保存目录
     * @return oss 中的相对文件路径
     * @author zhangjun
     */

    public static String uploadFileToOSS(OSSConfig ossConfig, MultipartFile file, String fileDir) {

        // 初始实例化
        OSSClient ossClient = new OSSClient(ossConfig.getEndpoint(),
                new DefaultCredentialProvider(ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret()),
                new ClientConfiguration());
        // 创建存储空间
        String strBucketNm = createBucketName(ossClient, ossConfig.getBucketName());
        StringBuilder fileUrl = new StringBuilder();
        try {

            String fileName = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 18)
                    + "-" + file.getOriginalFilename();
            if (!fileDir.endsWith(Constants.DASH_SLASH)) {
                fileDir = fileDir.concat(Constants.DASH_SLASH);
            }

            fileUrl = fileUrl.append(fileDir + fileName);
            InputStream is = file.getInputStream();
            ObjectMetadata metadata = new ObjectMetadata();
            //上传的文件的长度
            metadata.setContentLength(is.available());
            //指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            //指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
            //指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
            //文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            //如果没有扩展名则填默认值application/octet-stream
            metadata.setContentType(getContentType(fileName));
            //指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            metadata.setContentDisposition("filename/filesize=" + fileName + Constants.DASH_SLASH + file.getSize() + "Byte.");

            ossClient.putObject(strBucketNm, fileUrl.toString(), is, metadata);
//            PutObjectResult putResult = ossClient.putObject(strBucketNm, fileUrl.toString(), is,metadata);
            // 解析结果
//            String resultStr = putResult.getETag();
        } catch (Exception e) {
            if (ossClient != null) {
                ossClient.shutdown();
            }
            return null;
        }

        if (ossClient != null) {
            ossClient.shutdown();
        }

        fileUrl = fileUrl.insert(0, ossConfig.getFileHost());
        return fileUrl.toString();
    }

    /**
     * 上传文件至阿里云 OSS
     * 文件上传成功,返回文件完整访问路径
     * 文件上传失败,返回 null
     *
     * @param ossConfig oss 配置信息
     * @param file      待上传文件
     * @param fileDir   文件保存目录
     * @return oss 中的相对文件路径
     * @author zhangjun
     */

    public static String uploadLocalFileToOSS(OSSConfig ossConfig, File file, String fileDir) {

        // 初始实例化
        OSSClient ossClient = new OSSClient(ossConfig.getEndpoint(),
                new DefaultCredentialProvider(ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret()),
                new ClientConfiguration());
        // 创建存储空间
        String strBucketNm = createBucketName(ossClient, ossConfig.getBucketName());
        StringBuilder fileUrl = new StringBuilder();
        try {

            String strFileNm = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 18)
                    + "-" + file.getName();
            if (!fileDir.endsWith(Constants.DASH_SLASH)) {
                fileDir = fileDir.concat(Constants.DASH_SLASH);
            }

            fileUrl = fileUrl.append(fileDir + strFileNm);
            InputStream is = new FileInputStream(file);
            ObjectMetadata metadata = new ObjectMetadata();
            //上传的文件的长度
            metadata.setContentLength(is.available());
            //指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            //指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
            //指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
            //文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            //如果没有扩展名则填默认值application/octet-stream
            metadata.setContentType(getContentType(strFileNm));
            //指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            metadata.setContentDisposition("filename/filesize=" + strFileNm + Constants.DASH_SLASH + file.length()/1024/1024 + "Byte.");

            ossClient.putObject(strBucketNm, fileUrl.toString(), is, metadata);
//            PutObjectResult putResult = ossClient.putObject(strBucketNm, fileUrl.toString(), is,metadata);
            // 解析结果
//            String resultStr = putResult.getETag();
        } catch (Exception e) {
            if (ossClient != null) {
                ossClient.shutdown();
            }
            return null;
        }

        if (ossClient != null) {
            ossClient.shutdown();
        }

        fileUrl = fileUrl.insert(0, ossConfig.getFileHost());
        return fileUrl.toString();
    }

    public static String uploadImg(MultipartFile mf) {
        try {
            log.info("文件开始上传！！！");
            //获取文件格式
            int begin = mf.getOriginalFilename().indexOf(".");
            int last = mf.getOriginalFilename().length();
            String format = mf.getOriginalFilename().substring(begin, last);
            Calendar now = Calendar.getInstance();
            //路径为当前日期
            String picOsskey = "image/" +
                    now.get(Calendar.YEAR) + "/" +
                    (now.get(Calendar.MONTH) + 1) + "/" +
                    now.get(Calendar.DAY_OF_MONTH) + "/" + UUID.randomUUID().toString() + format;
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, secretAccessKey);
            ossClient.putObject(ossBucket, picOsskey, mf.getInputStream());//上传图片
            ossClient.shutdown();
            log.info("oss生成文件====" + ossUrl + picOsskey);
            return ossUrl + picOsskey;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Logo上传
    public static String uploadLogo(MultipartFile mf) {
        try {
            log.info("logo开始上传！！！");
            //获取文件格式
            int begin = mf.getOriginalFilename().indexOf(".");
            int last = mf.getOriginalFilename().length();
            String format = mf.getOriginalFilename().substring(begin, last);
            //logo路径为image下logo
            String picOsskey = "image/" + "Excel/" + UUID.randomUUID().toString() + format;
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, secretAccessKey);
            ossClient.putObject(ossBucket, picOsskey, mf.getInputStream());//上传logo
            ossClient.shutdown();
            log.info("oss生成文件====" + ossUrl + picOsskey);
            return ossUrl + picOsskey;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 删除OSS 文件
     *
     * @param fileUrl 文件路径
     * @return 操作消息
     */
    public static AjaxResult deleteFileFmOSS(OSSConfig ossConfig, String[] fileUrl) {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(ossConfig.getEndpoint(),
                new DefaultCredentialProvider(ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret()),
                new ClientConfiguration());

        // 判断当前文件url 是否存在
        boolean exist = false;
        for (String filePath : fileUrl) {
            if (ossClient.doesObjectExist(ossConfig.getBucketName(), filePath)) {
                // 删除文件。
                ossClient.deleteObject(ossConfig.getBucketName(), filePath);
                exist = true;
            }
        }

        if (!exist) {
            return AjaxResult.error("文件不存在或者已经删除改文件!");
        }

        if (ossClient != null) {
            ossClient.shutdown();
        }

        return AjaxResult.success("删除文件成功");
    }

    public static String uploadPdf(InputStream inputStream, String pdfName) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClient(endpoint, accessKeyId, secretAccessKey);
        try {
            String picOssKey = "pdf/" + UUID.randomUUID().toString() + "/" + pdfName;
            // 创建PutObject请求。
            ossClient.putObject(ossBucket, picOssKey, inputStream);
            return ossUrl + picOssKey;
        } catch (Exception oe) {
            LOGGER.error("上传文件流失败：", oe);
        } finally {
            ossClient.shutdown();
        }
        return "";
    }

    /**
     * oss上传文件
     *
     * @param mf       文件
     * @param fileName 文件名
     * @param direName 目录名
     * @return
     */
    public static String uploadFlie(MultipartFile mf, String fileName, String direName) {
        try {
            log.info("文件开始上传！！！");
            //获取文件格式
            int begin = mf.getOriginalFilename().indexOf(".");
            int last = mf.getOriginalFilename().length();
            String format = mf.getOriginalFilename().substring(begin, last);
            //路径为当前日期
            String picOsskey = direName + "/" + fileName + "_" + UUID.randomUUID().toString() + format;
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, secretAccessKey);
            ossClient.putObject(ossBucket, picOsskey, mf.getInputStream());//上传图片
            ossClient.shutdown();
            return ossUrl + picOsskey;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 创建存储空间
     *
     * @param ossClient  OSS连接
     * @param bucketName 存储空间
     * @return
     */
    public static String createBucketName(OSSClient ossClient, String bucketName) {
        //存储空间
        final String bucketNames = bucketName;
        if (!ossClient.doesBucketExist(bucketName)) {
            //创建存储空间
            Bucket bucket = ossClient.createBucket(bucketName);
            return bucket.getName();
        }
        return bucketNames;
    }

    /**
     * 删除存储空间buckName
     *
     * @param ossClient  oss对象
     * @param bucketName 存储空间
     */
    public static void deleteBucket(OSSClient ossClient, String bucketName) {
        ossClient.deleteBucket(bucketName);
    }

    /**
     * 创建模拟文件夹
     *
     * @param ossClient  oss连接
     * @param bucketName 存储空间
     * @param folder     模拟文件夹名如"qj_nanjing/"
     * @return 文件夹名
     */
    public static String createFolder(OSSClient ossClient, String bucketName, String folder) {
        //文件夹名
        final String keySuffixWithSlash = folder;
        //判断文件夹是否存在，不存在则创建
        if (!ossClient.doesObjectExist(bucketName, keySuffixWithSlash)) {
            //创建文件夹
            ossClient.putObject(bucketName, keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));
            //得到文件夹名
            OSSObject object = ossClient.getObject(bucketName, keySuffixWithSlash);
            String fileDir = object.getKey();
            return fileDir;
        }

        return keySuffixWithSlash;
    }

    /**
     * 根据key删除OSS服务器上的文件
     *
     * @param ossClient  oss连接
     * @param bucketName 存储空间
     * @param folder     模拟文件夹名 如"qj_nanjing/"
     * @param key        Bucket下的文件的路径名+文件名 如："upload/cake.jpg"
     */
    public static void deleteFile(OSSClient ossClient, String bucketName, String folder, String key) {
        ossClient.deleteObject(bucketName, folder + key);
    }

//    /**
//     * 上传图片至OSS
//     * @param ossClient  oss连接
//     * @param file 上传文件（文件全路径如：D:\\image\\cake.jpg）
//     * @param bucketName  存储空间
//     * @param folder 模拟文件夹名 如"qj_nanjing/"
//     * @return String 返回的唯一MD5数字签名
//     * */
//    public static String uploadObject2OSS(OSSClient ossClient, File file, String bucketName, String folder) {
//        String resultStr = null;
//        try {
//            //以输入流的形式上传文件
//            InputStream is = new FileInputStream(file);
//            //文件名
//            String fileName = file.getName();
//            //文件大小
//            Long fileSize = file.length();
//            //创建上传Object的Metadata
//            ObjectMetadata metadata = new ObjectMetadata();
//            //上传的文件的长度
//            metadata.setContentLength(is.available());
//            //指定该Object被下载时的网页的缓存行为
//            metadata.setCacheControl("no-cache");
//            //指定该Object下设置Header
//            metadata.setHeader("Pragma", "no-cache");
//            //指定该Object被下载时的内容编码格式
//            metadata.setContentEncoding("utf-8");
//            //文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
//            //如果没有扩展名则填默认值application/octet-stream
//            metadata.setContentType(getContentType(fileName));
//            //指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
//            metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
//            //上传文件   (上传文件流的形式)
//            PutObjectResult putResult = ossClient.putObject(bucketName, folder + fileName, is, metadata);
//            //解析结果
//            resultStr = putResult.getETag();
//        } catch (Exception e) {
//            e.printStackTrace();
//            AjaxResult.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
//        }
//        return resultStr;
//    }

    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     *
     * @param fileName 文件名
     * @return 文件的contentType
     */
    public static String getContentType(String fileName) {
        int iLength = fileName.lastIndexOf(".");
        if (iLength == -1) {
            //默认返回类型
            return "image/jpeg";
        }
        //文件的后缀名
        String fileExtension = fileName.substring(iLength);
        if (".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if (".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension) || ".png".equalsIgnoreCase(fileExtension)) {
            return "image/jpeg";
        }
        if (".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if (".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if (".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if (".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if (".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        //默认返回类型
        return "image/jpeg";
    }
}
