package com.jotime.web.service.file.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.enums.MsgErr;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.common.utils.file.FileUtils;
import com.jotime.common.utils.joTime.OSSUtil;
import com.jotime.web.domain.file.FileFolder;
import com.jotime.web.domain.file.FileListManage;
import com.jotime.web.mapper.file.FileFolderMapper;
import com.jotime.web.mapper.file.FileListManageMapper;
import com.jotime.web.service.common.IUploadOSSService;
import com.jotime.web.service.file.IFileListManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * 描述：文件清单管理Service业务层处理
 *
 * @author yunmoqian
 * @date 2022-04-22
 */
@Service
public class FileListManageServiceImpl extends ServiceImpl<FileListManageMapper, FileListManage> implements IFileListManageService
{
    @Autowired
    private FileListManageMapper fileListManageMapper;
    @Autowired
    private FileFolderMapper fileFolderMapper;

    @Autowired
    private IUploadOSSService iUploadOSSService;

    /**
     * 查询描述：文件清单管理
     *
     * @param id 描述：文件清单管理主键
     * @return 描述：文件清单管理
     */
    @Override
    public FileListManage selectFileListManageById(Long id)
    {
        return fileListManageMapper.selectFileListManageById(id);
    }

    /**
     * 查询描述：文件清单管理列表
     *
     * @param fileListManage 描述：文件清单管理
     * @return 描述：文件清单管理
     */
    @Override
    public List<FileListManage> selectFileListManageList(FileListManage fileListManage) {

        return fileListManageMapper.selectFileListManageList(fileListManage);
    }

    /**
     * 新增描述：文件清单管理
     *
     * @param fileListManage 描述：文件清单管理
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult insertFileListManage(FileListManage fileListManage)
    {
        //校验文件编号和版本号是否重复
        FileListManage queryParam = new FileListManage();
        queryParam.setFileNo(fileListManage.getFileNo());
        queryParam.setVersion(fileListManage.getVersion());
        List<FileListManage> fileListManages = fileListManageMapper.selectFileListManageList(queryParam);
        if(fileListManages != null && fileListManages.size() > 0){
            return AjaxResult.error(MsgErr.file_err1.getMsg());
        }
        //校验同文件夹下 文件名称是否重复
        queryParam = new FileListManage();
        queryParam.setFileName(fileListManage.getFileName());
        queryParam.setFolderId(fileListManage.getFolderId());
        List<FileListManage> fileListManages1 = fileListManageMapper.selectFileName(queryParam);
        if(fileListManages1 != null && fileListManages1.size() > 0){
            return AjaxResult.error(MsgErr.file_err2.getMsg());
        }

        //现行时 同文件编号数据作废
        fileListManageMapper.updateExpiry(fileListManage.getFileNo());
        //处理文件
        fileListManage.setOperator(SecurityUtils.getUsername());
        fileListManage.setOperatorCode(SecurityUtils.getEeCode());
        fileListManage.setOperateTime(DateUtils.getNowDate());
        fileListManage.setCreateBy(SecurityUtils.getUsername());
        fileListManage.setCreateTime(DateUtils.getNowDate());
        int i = fileListManageMapper.insertFileListManage(fileListManage);
        return AjaxResult.success();
    }

    /**
     * 修改描述：文件清单管理
     *
     * @param fileListManage 描述：文件清单管理
     * @return 结果
     */
    @Override
    public int updateFileListManage(FileListManage fileListManage)
    {
        if(fileListManage.getStatus() == 2){
            fileListManage.setExpiryDate(null);
            fileListManage.setEffectiveDate(DateUtils.getNowDate());

            //现行时 同文件编号数据作废
            fileListManageMapper.updateExpiry(fileListManage.getFileNo());

        }else{
            fileListManage.setExpiryDate(DateUtils.getNowDate());
        }
        fileListManage.setOperateTime(DateUtils.getNowDate());
        fileListManage.setOperator(SecurityUtils.getNickName());
        fileListManage.setOperatorCode(SecurityUtils.getEeCode());
        //处理文件
        fileListManage.setUpdateBy(SecurityUtils.getNickName());
        fileListManage.setUpdateTime(DateUtils.getNowDate());
        return fileListManageMapper.updateFileListManage(fileListManage);
    }

    /**
     * 批量删除描述：文件清单管理
     *
     * @param ids 需要删除的描述：文件清单管理主键
     * @return 结果
     */
    @Override
    public int deleteFileListManageByIds(Long[] ids)
    {
        return fileListManageMapper.deleteFileListManageByIds(ids);
    }

    /**
     * 删除描述：文件清单管理信息
     *
     * @param id 描述：文件清单管理主键
     * @return 结果
     */
    @Override
    public int deleteFileListManageById(Long id)
    {
        return fileListManageMapper.deleteFileListManageById(id);
    }

    /**
     * @param fileListManages 表格对象
     * @Description: 表格导入
     * @Author: YunFei
     * @Date: 2022/4/15 16:47
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int importData(List<FileListManage> fileListManages) {
        int row = 0;
        FileListManage fileListManage = new FileListManage();
        try {
            fileListManage.setCreateBy(SecurityUtils.getUserId().toString());
            fileListManage.setCreateTime(DateUtils.getNowDate());
            fileListManage.setUpdateBy(SecurityUtils.getUserId().toString());
            fileListManage.setUpdateTime(DateUtils.getNowDate());
            row+=fileListManageMapper.insertFileListManage(fileListManage);
        }catch (Exception e){
            throw new RuntimeException("请检查文件名为：（"+fileListManage.getFileName()+"）的信息是否完整");
        }

        return row;
    }
//
//    private void doFileList() {
//        List<String> unDofileList = new ArrayList<>();
//        try {
//            String basePath = "D:\\clouderwork\\项目\\COS-MES\\资料\\文件\\文件";
//
//            File dir = new File(basePath);
//
//            List<File> allFileList = new ArrayList<>();
//            List<FileFolder> allFolderList = new ArrayList<>();
//            List<FileListManage> allFileManageList = new ArrayList<>();
//
//
//
//            // 判断文件夹是否存在
//            if (!dir.exists()) {
//                System.out.println("目录不存在");
//                return;
//            }
//
//            getAllFile(dir, allFileList, allFolderList);
//    //        FileFolder selFileFolder = new FileFolder();
//    //        selFileFolder.setParentId(0L);
//    //        selFileFolder.setAncestors("0");
//    //        selFileFolder.setFileFolder("文件");
//    //        List<FileFolder> fileFolderList = fileFolderMapper.selectFileFolderList(selFileFolder);
//    //        Long lParentId = fileFolderList.get(0).getId();
//    //        String strAncestors = fileFolderList.get(0).getAncestors();
//    //        for (FileFolder folder: allFolderList) {
//    //            folder.setParentId(lParentId);
//    //            folder.setAncestors(strAncestors + "," + lParentId);
//    //            folder.setCreateBy(SecurityUtils.getUsername());
//    //            fileFolderMapper.insertFileFolder(folder);
//    //        }
//
//            FileFolder selFileFolder = new FileFolder();
//            selFileFolder.setParentId(73L);
//            List<FileFolder> fileFolderList = fileFolderMapper.selectFileFolderList(selFileFolder);
////            List<FileListManage> fileListManageList = fileListManageMapper.selectFileListManageByTmp();
//            for (File file : allFileList) {
//                String fileName = file.getName();
//                int preIndexof = fileName.indexOf("(");
//
//                if (preIndexof == -1) {
//                    preIndexof = fileName.indexOf("（");
//                }
//
//                if (preIndexof == -1) {
//                    unDofileList.add(file.getPath());
//                    continue;
//                }
//
//                int afeIndexof = fileName.indexOf(")");
//
//                if (afeIndexof == -1) {
//                    afeIndexof = fileName.indexOf("）");
//                }
//
//                if (afeIndexof == -1) {
//                    unDofileList.add(file.getPath());
//                    continue;
//                }
//
//                String originalFileName = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
//                if (!StringUtils.strEquals(originalFileName.toLowerCase(Locale.ROOT), "pdf")) {
//                    continue;
//                }
//
//
//                String strParentFile = file.getParentFile().toString();
//                String strParentFolder = strParentFile.substring(strParentFile.lastIndexOf("\\") + 1, strParentFile.length());
//                String strFileNo = StringUtils.trim(fileName.substring(0, preIndexof));
//                String strVersion = StringUtils.leftPad(StringUtils.trim(fileName.substring(preIndexof + 1, afeIndexof)), 2, "0");
//                String strFileName = StringUtils.trim(fileName.substring(afeIndexof + 1, fileName.lastIndexOf(".")));
//
//                FileListManage selManage = new FileListManage();
//                selManage.setFileNo(strFileNo);
//                selManage.setVersion(strVersion);
//                selManage.setFileName(strFileName);
//                List<FileListManage> fileListManageList = fileListManageMapper.selectFileListManageList(selManage);
//                if (StringUtils.isEmpty(fileListManageList) || fileListManageList.size() > 1) {
//                    unDofileList.add(file.getPath());
//                    continue;
//                }
//
//                FileListManage upManage = new FileListManage();
//                AjaxResult ajaxResult = iUploadOSSService.uploadLocalOSSFile(file, strParentFolder,"J03");
//                String ossUrl = (String)ajaxResult.get("ossUrl");
//                upManage.setFileUrl(ossUrl);
//                upManage.setId(fileListManageList.get(0).getId());
//                upManage.setUpdateBy(SecurityUtils.getUsername());
//                fileListManageMapper.updateFileListManage(upManage);
//                allFileManageList.add(upManage);
////                FileListManage insManage = new FileListManage();
////
////                for (FileFolder tmpFolder : fileFolderList) {
////                    if (StringUtils.strEquals(strParentFolder, tmpFolder.getFileFolder())) {
////
////                        insManage.setFolderId(tmpFolder.getId());
////                        break;
////                    }
////                }
////                insManag  e.setFileName(strFileName);
////                insManage.setFileNo(strFileNo);
////                insManage.setVersion(strVersion);
////                insManage.setOriginalFileName(originalFileName);
////                insManage.setFileSize(new BigDecimal(file.length()).divide(new BigDecimal("1048576")));
////                insManage.setOperator(SecurityUtils.getUsername());
////                insManage.setOperatorCode(SecurityUtils.getEeCode());
////                insManage.setOperateTime(new Date());
////                insManage.setStatus(2);
////                for (FileListManage tmpManage : fileListManageList) {
////                    if (StringUtils.strEquals(insManage.getFileNo(), tmpManage.getFileNo())
////                            && StringUtils.strEquals(insManage.getVersion(), tmpManage.getVersion())) {
////
////                        insManage.setFileType(tmpManage.getFileType());
////                        insManage.setEffectiveDate(tmpManage.getEffectiveDate());
////                        break;
////                    }
////                }
////                insManage.setCreateBy(SecurityUtils.getUsername());
//
////                AjaxResult ajaxResult = iUploadOSSService.uploadLocalOSSFile(file, strParentFolder,"J04");
////                String ossUrl = (String)ajaxResult.get("ossUrl");
////                insManage.setTemplateFileUrl(ossUrl);
////                fileListManageMapper.insertFileListManage(insManage);
////                allFileManageList.add(insManage);
//            }
//        } catch (Exception e) {
//            unDofileList.add(e.getMessage());
//            System.out.println(e.getMessage());
//        }
//
//        String filePath = "D:\\clouderwork\\项目\\COS-MES\\资料\\文件\\out.txt";
//        FileWriter fw = null;
//        try
//        {
//            File file = new File(filePath);
//            if (!file.exists())
//            {
//                file.createNewFile();
//            }
//            fw = new FileWriter(filePath);
//
//            for (String content  : unDofileList) {
//                fw.write(content + "\r\n");
//            }
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        finally
//        {
//            try
//            {
//                fw.close();
//            }
//            catch (Exception e)
//            {
//                e.printStackTrace();
//            }
//
//        }
//
//    }
//    private static void getAllFile(File fileInput, List<File> allFileList,List<FileFolder> allFolderList) {
//        // 获取文件列表
//        File[] fileList = fileInput.listFiles();
//        assert fileList != null;
//        for (File file : fileList) {
//            if (file.isDirectory()) {
//                // 递归处理文件夹
//                // 如果不想统计子文件夹则可以将下一行注释掉
//                FileFolder fileFolder = new FileFolder();
//                fileFolder.setFileFolder(file.getName());
//                fileFolder.setStatus(2);
//                fileFolder.setDisplaySort(String.valueOf(allFolderList.size() + 1));
//                allFolderList.add(fileFolder);
////                allFolderList.add();
//                getAllFile(file, allFileList, allFolderList);
//            } else {
//                // 如果是文件则将其加入到文件数组中
//                allFileList.add(file);
//            }
//        }
//    }
}
