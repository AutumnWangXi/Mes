package com.jotime.web.service.base;


import com.jotime.web.domain.base.BaseMicrobe;

import java.util.List;

/**
 * 微生物检测Service接口
 * 
 * @author yunmoqian
 * @date 2022-06-16
 */
public interface IBaseMicrobeService 
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
     * 批量删除微生物检测
     * 
     * @param ids 需要删除的微生物检测主键集合
     * @return 结果
     */
    public int deleteBaseMicrobeByIds(Long[] ids);

    /**
     * 删除微生物检测信息
     * 
     * @param id 微生物检测主键
     * @return 结果
     */
    public int deleteBaseMicrobeById(Long id);
}
