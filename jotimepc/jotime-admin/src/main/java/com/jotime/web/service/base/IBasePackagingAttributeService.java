package com.jotime.web.service.base;


import com.jotime.web.domain.base.BasePackagingAttribute;

import java.util.List;

/**
 * 包材属性Service接口
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
public interface IBasePackagingAttributeService 
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
     * 批量删除包材属性
     * 
     * @param ids 需要删除的包材属性主键集合
     * @return 结果
     */
    public int deleteBasePackagingAttributeByIds(Long[] ids);

    /**
     * 删除包材属性信息
     * 
     * @param id 包材属性主键
     * @return 结果
     */
    public int deleteBasePackagingAttributeById(Long id);
}
