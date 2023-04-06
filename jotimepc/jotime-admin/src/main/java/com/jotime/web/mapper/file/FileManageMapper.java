package com.jotime.web.mapper.file;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.web.domain.file.FileManage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件管理Mapper接口
 *
 * @author ruoyi
 * @date 2021-12-23
 */
public interface FileManageMapper extends BaseMapper<FileManage> {
    /**
     * 查询文件管理
     *
     * @param id 文件管理主键
     * @return 文件管理
     */
    public FileManage selectFileManageById(Long id);

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
     * 删除文件管理
     *
     * @param id 文件管理主键
     * @return 结果
     */
    public int deleteFileManageById(Long id);

    /**
     * 批量删除文件管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFileManageByIds(Long[] ids);

    /**
     * 根据回传UUID查询文件管理
     *
     * @param tableId UUID
     * @param type    附件类型
     * @return 文件管理
     */
    public FileManage selectFileManageByTableIdAndType(@Param("tableId") Long tableId, @Param("type") String type);

    List<String> selectFileManageByTableIds(@Param("id") Long id, @Param("pdGroupOrdertask") String pdGroupOrdertask);

    /**
     * 根据tableId批量删除
     *
     * @param tableIdList tableId
     */
    public void removeFileDataByTableId(@Param("tableIdList")List<Long> tableIdList);
    /**
     * 根根据文件路径更新数据
     * @param filePaths 文件路径
     */
    void updateFileManageByFileUrl(@Param("filePaths") List<String> filePaths);
}
