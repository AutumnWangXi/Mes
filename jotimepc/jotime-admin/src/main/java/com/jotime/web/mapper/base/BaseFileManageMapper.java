package com.jotime.web.mapper.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.web.domain.base.BaseFileManage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述  base文件管理Mapper接口
 *
 * @author ruoyi
 * @date 2022-02-16
 */
public interface BaseFileManageMapper  extends BaseMapper<BaseFileManage>
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
     * 根据tableId和tableType查询文件list
     * @return 描述  base文件管理集合
     */
    public List<String> selectBaseFileManageListBytableIdAndtableType(@Param("tableId") Long tableId, @Param("tableType") Long tableType);

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
     * 删除描述  base文件管理
     *
     * @param id 描述  base文件管理主键
     * @return 结果
     */
    public int deleteBaseFileManageById(Long id);

    /**
     * 批量删除描述  base文件管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseFileManageByIds(Long[] ids);
}
