package com.jotime.web.service.file.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jotime.common.config.OSSConfig;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.joTime.OSSUtil;
import com.jotime.web.domain.file.FileManage;
import com.jotime.web.mapper.file.FileManageMapper;
import com.jotime.web.service.file.IFileManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


/**
 * 文件管理Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-23
 */
@Service
public class FileManageServiceImpl extends ServiceImpl<FileManageMapper, FileManage> implements IFileManageService {
    @Resource
    private FileManageMapper fileManageMapper;
    @Autowired
    private OSSConfig ossConfig;

    /**
     * 查询文件管理
     *
     * @param id 文件管理主键
     * @return 文件管理
     */
    @Override
    public FileManage selectFileManageById(Long id) {
        return fileManageMapper.selectFileManageById(id);
    }

    /**
     * 查询文件管理
     *
     * @param tableId 表ID
     * @return 文件管理
     */
    @Override
    public FileManage selectFileManageByTableId(Long tableId, String tableName) {
        QueryWrapper<FileManage> fileManageQueryWrapper = new QueryWrapper<>();
        fileManageQueryWrapper.eq("table_id", tableId);
        fileManageQueryWrapper.eq("table_name", tableName);
        return fileManageMapper.selectOne(fileManageQueryWrapper);
    }

    /**
     * 根据回传UUID查询文件管理
     *
     * @param tableId UUID
     * @param type    附件类型
     * @return 文件管理
     */
    @Override
    public FileManage selectFileManageByTableIdAndType(Long tableId, String type) {
        return fileManageMapper.selectFileManageByTableIdAndType(tableId, type);
    }

    /**
     * 查询文件管理列表
     *
     * @param fileManage 文件管理
     * @return 文件管理
     */
    @Override
    public List<FileManage> selectFileManageList(FileManage fileManage) {
        return fileManageMapper.selectFileManageList(fileManage);
    }

    /**
     * 新增文件管理
     *
     * @param fileManage 文件管理
     * @return 结果
     */
    @Override
    public int insertFileManage(FileManage fileManage) {

        fileManage.setCreateTime(DateUtils.getNowDate());
        this.save(fileManage);
        return 1;
    }

    /**
     * 修改文件管理
     *
     * @param fileManage 文件管理
     * @return 结果
     */
    @Override
    public int updateFileManage(FileManage fileManage) {
        fileManage.setUpdateTime(DateUtils.getNowDate());
        return fileManageMapper.updateFileManage(fileManage);
    }

    /**
     * 批量删除文件管理
     *
     * @param ids 需要删除的文件管理主键
     * @return 结果
     */
    @Override
    public int deleteFileManageByIds(Long[] ids) {
        return fileManageMapper.deleteFileManageByIds(ids);
    }

    /**
     * 删除文件管理信息
     *
     * @param id 文件管理主键
     * @return 结果
     */
    @Override
    public int deleteFileManageById(Long id) {
        return fileManageMapper.deleteFileManageById(id);
    }

    @Override
    public void updateFileManage(List<FileManage> fileManages) {
        this.updateBatchById(fileManages);
    }

    @Override
    public void deleteFileByUrl(List<String> urlList) {
        QueryWrapper<FileManage> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(urlList)) {
            queryWrapper.in("file_url", urlList);
        }
        this.remove(queryWrapper);
    }

    @Override
    public List<String> selectFileManageByTableIds(Long id, String pdGroupOrdertask) {
        return fileManageMapper.selectFileManageByTableIds(id, pdGroupOrdertask);
    }


    /**
     * 移除上传文件数据
     *
     * @param fileManage 文件列表
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult removeFileData(FileManage fileManage) {
        this.updateFileManageByFileUrl(Arrays.asList(fileManage.getFileUrl()));
        OSSUtil.deleteFileFmOSS(ossConfig, new String[]{fileManage.getDeleteFileUrl()});
        return AjaxResult.success();
    }

    /**
     * 根据tableId批量删除
     *
     * @param tableIdList tableId
     * @return 结果
     */
    @Override
    public void removeFileDataByTableId(List<Long> tableIdList) {
        fileManageMapper.removeFileDataByTableId(tableIdList);
    }

    /**
     * 根根据文件路径更新数据
     *
     * @param filePaths 文件路径
     */
    @Override
    public void updateFileManageByFileUrl(List<String> filePaths) {
        fileManageMapper.updateFileManageByFileUrl(filePaths);
    }
}
