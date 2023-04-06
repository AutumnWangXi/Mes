package com.jotime.web.service.file;


import com.jotime.web.domain.file.FileFolder;

import java.util.List;

/**
 * 文件夹名Service接口
 * 
 * @author yunmoqian
 * @date 2022-08-11
 */
public interface IFileFolderService 
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
     * 批量删除文件夹名
     * 
     * @param ids 需要删除的文件夹名主键集合
     * @return 结果
     */
    public int deleteFileFolderByIds(Long[] ids);

    /**
     * 删除文件夹名信息
     * 
     * @param id 文件夹名主键
     * @return 结果
     */
    public int deleteFileFolderById(Long id);

    public List<FileFolder> getTree(FileFolder fileFolder);

}
