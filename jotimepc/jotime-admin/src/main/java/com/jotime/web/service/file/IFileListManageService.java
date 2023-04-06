package com.jotime.web.service.file;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.web.domain.base.BaseSupplier;
import com.jotime.web.domain.file.FileListManage;
import com.jotime.web.domain.file.FileManage;

import java.util.List;

/**
 * 描述：文件清单管理Service接口
 *
 * @author yunmoqian
 * @date 2022-04-22
 */
public interface IFileListManageService extends IService<FileListManage>
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
     * 新增描述：文件清单管理
     *
     * @param fileListManage 描述：文件清单管理
     * @return 结果
     */
    public AjaxResult insertFileListManage(FileListManage fileListManage);

    /**
     * 修改描述：文件清单管理
     *
     * @param fileListManage 描述：文件清单管理
     * @return 结果
     */
    public int updateFileListManage(FileListManage fileListManage);

    /**
     * 批量删除描述：文件清单管理
     *
     * @param ids 需要删除的描述：文件清单管理主键集合
     * @return 结果
     */
    public int deleteFileListManageByIds(Long[] ids);

    /**
     * 删除描述：文件清单管理信息
     *
     * @param id 描述：文件清单管理主键
     * @return 结果
     */
    public int deleteFileListManageById(Long id);


    /**
     * @Description: 表格导入
     * @param fileListManages 表格对象
     * @Author: YunFei
     * @Date: 2022/4/15 16:47
     */
    public int importData(List<FileListManage> fileListManages);
}
