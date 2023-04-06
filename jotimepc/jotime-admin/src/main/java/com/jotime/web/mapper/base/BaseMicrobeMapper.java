package com.jotime.web.mapper.base;


import com.jotime.web.domain.base.BaseMicrobe;

import java.util.List;

/**
 * 微生物检测Mapper接口
 * 
 * @author yunmoqian
 * @date 2022-06-16
 */
public interface BaseMicrobeMapper 
{
    /**
     * 查询微生物检测
     * 
     * @param id 微生物检测主键
     * @return 微生物检测
     */
    public BaseMicrobe selectBaseMicrobeById(Long id);

    /**
     * 查询微生物检测列表
     * 
     * @param baseMicrobe 微生物检测
     * @return 微生物检测集合
     */
    public List<BaseMicrobe> selectBaseMicrobeList(BaseMicrobe baseMicrobe);

    /**
     * 新增微生物检测
     * 
     * @param baseMicrobe 微生物检测
     * @return 结果
     */
    public int insertBaseMicrobe(BaseMicrobe baseMicrobe);

    /**
     * 修改微生物检测
     * 
     * @param baseMicrobe 微生物检测
     * @return 结果
     */
    public int updateBaseMicrobe(BaseMicrobe baseMicrobe);

    /**
     * 删除微生物检测
     * 
     * @param id 微生物检测主键
     * @return 结果
     */
    public int deleteBaseMicrobeById(Long id);

    /**
     * 批量删除微生物检测
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseMicrobeByIds(Long[] ids);
}
