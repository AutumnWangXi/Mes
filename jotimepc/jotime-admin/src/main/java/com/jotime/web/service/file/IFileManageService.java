package com.jotime.web.service.file;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.web.domain.file.FileManage;

import java.util.List;

/**
 * 文件管理Service接口
 *
 * @author ruoyi
 * @date 2021-12-23
 */
public interface IFileManageService extends IService<FileManage> {
    /**
     * 查询文件管理
     *
     * @param id 文件管理主键
     * @return 文件管理
     */
    public FileManage selectFileManageById(Long id);

    /**
     * 根据回传UUID查询文件管理
     *
     * @param tableId UUID
     * @return 文件管理
     */
    public FileManage selectFileManageByTableId(Long tableId, String tableName);

    /**
     * 根据回传UUID查询文件管理
     *
     * @param tableId UUID
     * @param type    附件类型
     * @return 文件管理
     */
    public FileManage selectFileManageByTableIdAndType(Long tableId, String type);

    /**
     * 查询文件管理列表
     *
     * @param fileManage 文件管理
     * @return 文件管理集合
     */
    public List<FileManage> selectFileManageList(FileManage fileManage);

    /**
     * 新增文件管理
     *
     * @param fileManage 文件管理
     * @return 结果
     */
    public int insertFileManage(FileManage fileManage);

    /**
     * 修改文件管理
     *
     * @param fileManage 文件管理
     * @return 结果
     */
    public int updateFileManage(FileManage fileManage);

    /**
     * 批量删除文件管理
     *
     * @param ids 需要删除的文件管理主键集合
     * @return 结果
     */
    public int deleteFileManageByIds(Long[] ids);

    /**
     * 删除文件管理信息
     *
     * @param id 文件管理主键
     * @return 结果
     */
    public int deleteFileManageById(Long id);

    /**
     * 根据url去修改数据
     *
     * @param fileManages 修改修改的文件
     */
    void updateFileManage(List<FileManage> fileManages);

    /**
     * 根据url去删除数据
     *
     * @param urlList 删除文件的url
     */
    void deleteFileByUrl(List<String> urlList);

    List<String> selectFileManageByTableIds(Long id, String pdGroupOrdertask);

    /**
     * 移除上传文件
     * @param fileManage 文件列表
     * @return 结果
     */
    AjaxResult removeFileData(FileManage fileManage);



    /**
     * 根据tableId批量删除
     * @param tableIdList tableId
     * @return 结果
     */
    void removeFileDataByTableId(List<Long> tableIdList);

    /**
     * 根根据文件路径更新数据
     * @param filePaths 文件路径
     */
    void updateFileManageByFileUrl(List<String> filePaths);
}
