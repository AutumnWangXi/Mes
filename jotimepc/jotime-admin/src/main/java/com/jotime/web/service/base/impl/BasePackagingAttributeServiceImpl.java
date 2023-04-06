package com.jotime.web.service.base.impl;

import com.jotime.web.domain.base.BasePackagingAttribute;
import com.jotime.web.mapper.base.BasePackagingAttributeMapper;
import com.jotime.web.service.base.IBasePackagingAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 包材属性Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
@Service
public class BasePackagingAttributeServiceImpl implements IBasePackagingAttributeService
{
    @Autowired
    private BasePackagingAttributeMapper basePackagingAttributeMapper;

    /**
     * 查询包材属性
     * 
     * @param id 包材属性主键
     * @return 包材属性
     */
    @Override
    public BasePackagingAttribute selectBasePackagingAttributeById(Long id)
    {
        return basePackagingAttributeMapper.selectBasePackagingAttributeById(id);
    }

    /**
     * 查询包材属性列表
     * 
     * @param basePackagingAttribute 包材属性
     * @return 包材属性
     */
    @Override
    public List<BasePackagingAttribute> selectBasePackagingAttributeList(BasePackagingAttribute basePackagingAttribute)
    {
        return basePackagingAttributeMapper.selectBasePackagingAttributeList(basePackagingAttribute);
    }

    /**
     * 新增包材属性
     * 
     * @param basePackagingAttribute 包材属性
     * @return 结果
     */
    @Override
    public int insertBasePackagingAttribute(BasePackagingAttribute basePackagingAttribute)
    {
        return basePackagingAttributeMapper.insertBasePackagingAttribute(basePackagingAttribute);
    }

    /**
     * 修改包材属性
     * 
     * @param basePackagingAttribute 包材属性
     * @return 结果
     */
    @Override
    public int updateBasePackagingAttribute(BasePackagingAttribute basePackagingAttribute)
    {
        return basePackagingAttributeMapper.updateBasePackagingAttribute(basePackagingAttribute);
    }

    /**
     * 批量删除包材属性
     * 
     * @param ids 需要删除的包材属性主键
     * @return 结果
     */
    @Override
    public int deleteBasePackagingAttributeByIds(Long[] ids)
    {
        return basePackagingAttributeMapper.deleteBasePackagingAttributeByIds(ids);
    }

    /**
     * 删除包材属性信息
     * 
     * @param id 包材属性主键
     * @return 结果
     */
    @Override
    public int deleteBasePackagingAttributeById(Long id)
    {
        return basePackagingAttributeMapper.deleteBasePackagingAttributeById(id);
    }
}
