package com.jotime.common.utils.joTime;

import com.jotime.common.config.RuoYiConfig;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author yunmoqian
 * 文件类型转换
 */
public class MultipartFileToFile {
    /**
     * MultipartFile 转 File
     *
     * @param file
     * @throws Exception
     */
    public static File multipartFileToFile(MultipartFile file) throws Exception {

        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = file.getInputStream();
            ;
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            // 本地资源路径
            String localPath = RuoYiConfig.getProfile();
            File directory = new File(localPath);
            //本地测试文件存放路径
            OutputStream os = new FileOutputStream(localPath + "/" + file);
            //服务器资源路径
            final String path = "/root/joTime/D:/ruoyi/uploadPath";
//            File directory = new File(path);
            //服务器文件路径
//            OutputStream os = new FileOutputStream(path + "/" + file);

            //如果文件夹不存在则创建
            if (!directory.exists() && !directory.isDirectory()) {
                directory.mkdir();
            }
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.flush();
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除本地临时文件
     *
     * @param file
     */
    public static void delteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            del.delete();
        }
    }

}
