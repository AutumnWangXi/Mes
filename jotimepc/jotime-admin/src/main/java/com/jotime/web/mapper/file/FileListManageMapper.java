package com.jotime.web.mapper.file;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.web.domain.file.FileListManage;
import com.jotime.web.domain.file.FileManage;

import java.util.List;


/**
 * 描述：文件清单管理Mapper接口
 *
 * @author yunmoqian
 * @date 2022-04-22
 */
public interface FileListManageMapper extends BaseMapper<FileListManage>
{
    /**
     * 查询描述：文件清单管理
     *
     * @param id 描述：文件清单管理主键
     * @return 描述：文件清单管理
     */
    public FileListManage selectFileListManageById(Long id);

    /**
     * 查询描述：文件清单管理列表
     *
     * @param fileListManage 描述：文件清单管理
     * @return 描述：文件清单管理集合
     */
    public List<FileListManage> selectFileListManageList(FileListManage fileListManage);

    /**
     * 文件名称查重
     * @date 2022/8/23 17:17
     * @author zhengsijie
     * @param fileListManage
     * @return java.util.List<com.jotime.web.domain.file.FileListManage>
     */
    public List<FileListManage> selectFileName(FileListManage fileListManage);

    /**
     * 新增描述：文件清单管理
     *
     * @param fileListManage 描述：文件清单管理
     * @return 结果
     */
    public int insertFileListManage(FileListManage fileListManage);

    /**
     * 修改描述：文件清单管理
     *
     * @param fileListManage 描述：文件清单管理
     * @return 结果
     */
    public int updateFileListManage(FileListManage fileListManage);

    public int updateExpiry(String fileNo);

    /**
     * 删除描述：文件清单管理
     *
     * @param id 描述：文件清单管理主键
     * @return 结果
     */
    public int deleteFileListManageById(Long id);

    /**
     * 批量删除描述：文件清单管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFileListManageByIds(Long[] ids);
}
