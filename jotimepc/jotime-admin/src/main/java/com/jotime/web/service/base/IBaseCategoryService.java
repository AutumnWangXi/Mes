package com.jotime.web.service.base;


import com.jotime.web.domain.base.BaseCategory;

import java.util.List;

/**
 * 类别Service接口
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
public interface IBaseCategoryService 
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
     * 批量删除类别
     * 
     * @param ids 需要删除的类别主键集合
     * @return 结果
     */
    public int deleteBaseCategoryByIds(Long[] ids);

    /**
     * 删除类别信息
     * 
     * @param id 类别主键
     * @return 结果
     */
    public int deleteBaseCategoryById(Long id);
}
