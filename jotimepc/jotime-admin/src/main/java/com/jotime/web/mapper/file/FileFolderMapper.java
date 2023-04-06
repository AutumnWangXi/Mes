package com.jotime.web.mapper.file;


import com.jotime.web.domain.file.FileFolder;

import java.util.List;

/**
 * 文件夹名Mapper接口
 * 
 * @author yunmoqian
 * @date 2022-08-11
 */
public interface FileFolderMapper 
{
    /**
     * 查询文件夹名
     * 
     * @param id 文件夹名主键
     * @return 文件夹名
     */
    public FileFolder selectFileFolderById(Long id);

    /**
     * 查询文件夹名列表
     * 
     * @param fileFolder 文件夹名
     * @return 文件夹名集合
     */
    public List<FileFolder> selectFileFolderList(FileFolder fileFolder);

    /**
     * 新增文件夹名
     * 
     * @param fileFolder 文件夹名
     * @return 结果
     */
    public int insertFileFolder(FileFolder fileFolder);

    /**
     * 修改文件夹名
     * 
     * @param fileFolder 文件夹名
     * @return 结果
     */
    public int updateFileFolder(FileFolder fileFolder);

    /**
     * 删除文件夹名
     * 
     * @param id 文件夹名主键
     * @return 结果
     */
    public int deleteFileFolderById(Long id);

    /**
     * 批量删除文件夹名
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFileFolderByIds(Long[] ids);
}
