package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BasePackagingAttribute;

import java.util.List;

/**
 * 包材属性Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
public interface BasePackagingAttributeMapper 
{
    /**
     * 查询包材属性
     * 
     * @param id 包材属性主键
     * @return 包材属性
     */
    public BasePackagingAttribute selectBasePackagingAttributeById(Long id);

    /**
     * 查询包材属性列表
     * 
     * @param basePackagingAttribute 包材属性
     * @return 包材属性集合
     */
    public List<BasePackagingAttribute> selectBasePackagingAttributeList(BasePackagingAttribute basePackagingAttribute);

    /**
     * 新增包材属性
     * 
     * @param basePackagingAttribute 包材属性
     * @return 结果
     */
    public int insertBasePackagingAttribute(BasePackagingAttribute basePackagingAttribute);

    /**
     * 修改包材属性
     * 
     * @param basePackagingAttribute 包材属性
     * @return 结果
     */
    public int updateBasePackagingAttribute(BasePackagingAttribute basePackagingAttribute);

    /**
     * 删除包材属性
     * 
     * @param id 包材属性主键
     * @return 结果
     */
    public int deleteBasePackagingAttributeById(Long id);

    /**
     * 批量删除包材属性
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBasePackagingAttributeByIds(Long[] ids);
}
