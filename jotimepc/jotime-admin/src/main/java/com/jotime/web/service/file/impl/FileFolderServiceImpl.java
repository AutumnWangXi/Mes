package com.jotime.web.service.file.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.web.domain.file.FileFolder;
import com.jotime.web.mapper.file.FileFolderMapper;
import com.jotime.web.service.file.IFileFolderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文件夹名Service业务层处理
 * 
 * @author yunmoqian
 * @date 2022-08-11
 */
@Service
public class FileFolderServiceImpl implements IFileFolderService
{
    @Autowired
    private FileFolderMapper fileFolderMapper;

    /**
     * 查询文件夹名
     * 
     * @param id 文件夹名主键
     * @return 文件夹名
     */
    @Override
    public FileFolder selectFileFolderById(Long id)
    {
        return fileFolderMapper.selectFileFolderById(id);
    }

    /**
     * 查询文件夹名列表
     * 
     * @param fileFolder 文件夹名
     * @return 文件夹名
     */
    @Override
    public List<FileFolder> selectFileFolderList(FileFolder fileFolder)
    {
        return fileFolderMapper.selectFileFolderList(fileFolder);
    }

    /**
     * 新增文件夹名
     * 
     * @param fileFolder 文件夹名
     * @return 结果
     */
    @Override
    public int insertFileFolder(FileFolder fileFolder)
    {
        fileFolder.setCreateTime(DateUtils.getNowDate());
        fileFolder.setCreateBy(SecurityUtils.getNickName());
        fileFolder.setStatus(2);
        return fileFolderMapper.insertFileFolder(fileFolder);
    }

    /**
     * 修改文件夹名
     * 
     * @param fileFolder 文件夹名
     * @return 结果
     */
    @Override
    public int updateFileFolder(FileFolder fileFolder)
    {
        fileFolder.setUpdateTime(DateUtils.getNowDate());
        return fileFolderMapper.updateFileFolder(fileFolder);
    }

    /**
     * 批量删除文件夹名
     * 
     * @param ids 需要删除的文件夹名主键
     * @return 结果
     */
    @Override
    public int deleteFileFolderByIds(Long[] ids)
    {
        return fileFolderMapper.deleteFileFolderByIds(ids);
    }

    /**
     * 删除文件夹名信息
     * 
     * @param id 文件夹名主键
     * @return 结果
     */
    @Override
    public int deleteFileFolderById(Long id)
    {
        return fileFolderMapper.deleteFileFolderById(id);
    }

    @Override
    public List<FileFolder> getTree(FileFolder fileFolder) {
        //查询全部文件夹列表
        List<FileFolder> fileFolders = fileFolderMapper.selectFileFolderList(fileFolder);
        //放回的文件夹
        List<FileFolder> collect = new ArrayList<>();
        if(fileFolders != null && fileFolders.size() > 0){
            //筛选根文件夹
            collect = fileFolders.stream().filter(item -> item.getParentId() == null||item.getParentId() == 0).collect(Collectors.toList());
            //筛选子文件夹并根据父文件夹分组
            Map<Long, List<FileFolder>> collect1 = fileFolders.stream().filter(item -> item.getParentId() != null).collect(Collectors.groupingBy(FileFolder::getParentId));
            fileFolders.forEach(item ->{
                item.setChildren(collect1.get(item.getId()));
            });

        }
        return collect;
    }
}
