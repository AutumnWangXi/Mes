package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BaseCategory;

import java.util.List;

/**
 * 类别Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
public interface BaseCategoryMapper 
{
    /**
     * 查询类别
     * 
     * @param id 类别主键
     * @return 类别
     */
    public BaseCategory selectBaseCategoryById(Long id);

    /**
     * 查询类别列表
     * 
     * @param baseCategory 类别
     * @return 类别集合
     */
    public List<BaseCategory> selectBaseCategoryList(BaseCategory baseCategory);

    /**
     * 新增类别
     * 
     * @param baseCategory 类别
     * @return 结果
     */
    public int insertBaseCategory(BaseCategory baseCategory);

    /**
     * 修改类别
     * 
     * @param baseCategory 类别
     * @return 结果
     */
    public int updateBaseCategory(BaseCategory baseCategory);

    /**
     * 删除类别
     * 
     * @param id 类别主键
     * @return 结果
     */
    public int deleteBaseCategoryById(Long id);

    /**
     * 批量删除类别
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseCategoryByIds(Long[] ids);
}
