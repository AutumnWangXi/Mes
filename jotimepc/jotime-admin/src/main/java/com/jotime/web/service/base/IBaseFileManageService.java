package com.jotime.web.service.base;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jotime.web.domain.base.BaseFileManage;

import java.util.List;

/**
 * 描述  base文件管理Service接口
 *
 * @author ruoyi
 * @date 2022-02-16
 */
public interface IBaseFileManageService extends IService<BaseFileManage>
{
    /**
     * 查询描述  base文件管理
     *
     * @param id 描述  base文件管理主键
     * @return 描述  base文件管理
     */
    public BaseFileManage selectBaseFileManageById(Long id);

    /**
     * 查询描述  base文件管理列表
     *
     * @param baseFileManage 描述  base文件管理
     * @return 描述  base文件管理集合
     */
    public List<BaseFileManage> selectBaseFileManageList(BaseFileManage baseFileManage);

    /**
     * 新增描述  base文件管理
     *
     * @param baseFileManage 描述  base文件管理
     * @return 结果
     */
    public int insertBaseFileManage(BaseFileManage baseFileManage);

    /**
     * 修改描述  base文件管理
     *
     * @param baseFileManage 描述  base文件管理
     * @return 结果
     */
    public int updateBaseFileManage(BaseFileManage baseFileManage);

    /**
     * 批量删除描述  base文件管理
     *
     * @param ids 需要删除的描述  base文件管理主键集合
     * @return 结果
     */
    public int deleteBaseFileManageByIds(Long[] ids);

    /**
     * 删除描述  base文件管理信息
     *
     * @param id 描述  base文件管理主键
     * @return 结果
     */
    public int deleteBaseFileManageById(Long id);
    /**
     * 根据url去修改数据
     *
     * @param baseFileManages 修改修改的文件
     */
    void updateFileManage(List<BaseFileManage> baseFileManages);

    /**
     * 根据url去删除数据
     *
     * @param urlList 删除文件的url
     */
    void deleteFileByUrl(List<String> urlList);

}
