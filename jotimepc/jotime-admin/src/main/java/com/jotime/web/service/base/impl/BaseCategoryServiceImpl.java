package com.jotime.web.service.base.impl;

import com.jotime.common.utils.DateUtils;
import com.jotime.web.domain.base.BaseCategory;
import com.jotime.web.mapper.base.BaseCategoryMapper;
import com.jotime.web.service.base.IBaseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类别Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
@Service
public class BaseCategoryServiceImpl implements IBaseCategoryService
{
    @Autowired
    private BaseCategoryMapper baseCategoryMapper;

    /**
     * 查询类别
     * 
     * @param id 类别主键
     * @return 类别
     */
    @Override
    public BaseCategory selectBaseCategoryById(Long id)
    {
        return baseCategoryMapper.selectBaseCategoryById(id);
    }

    /**
     * 查询类别列表
     * 
     * @param baseCategory 类别
     * @return 类别
     */
    @Override
    public List<BaseCategory> selectBaseCategoryList(BaseCategory baseCategory)
    {
        return baseCategoryMapper.selectBaseCategoryList(baseCategory);
    }

    /**
     * 新增类别
     * 
     * @param baseCategory 类别
     * @return 结果
     */
    @Override
    public int insertBaseCategory(BaseCategory baseCategory)
    {
        baseCategory.setCreateTime(DateUtils.getNowDate());
        return baseCategoryMapper.insertBaseCategory(baseCategory);
    }

    /**
     * 修改类别
     * 
     * @param baseCategory 类别
     * @return 结果
     */
    @Override
    public int updateBaseCategory(BaseCategory baseCategory)
    {
        baseCategory.setUpdateTime(DateUtils.getNowDate());
        return baseCategoryMapper.updateBaseCategory(baseCategory);
    }

    /**
     * 批量删除类别
     * 
     * @param ids 需要删除的类别主键
     * @return 结果
     */
    @Override
    public int deleteBaseCategoryByIds(Long[] ids)
    {
        return baseCategoryMapper.deleteBaseCategoryByIds(ids);
    }

    /**
     * 删除类别信息
     * 
     * @param id 类别主键
     * @return 结果
     */
    @Override
    public int deleteBaseCategoryById(Long id)
    {
        return baseCategoryMapper.deleteBaseCategoryById(id);
    }
}
