package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BaseMicrobedtl;

import java.util.List;


/**
 * 微生物检测内容Mapper接口
 * 
 * @author yunmoqian
 * @date 2022-06-16
 */
public interface BaseMicrobedtlMapper 
{
    /**
     * 查询微生物检测内容
     * 
     * @param id 微生物检测内容主键
     * @return 微生物检测内容
     */
    public BaseMicrobedtl selectBaseMicrobedtlById(Long id);

    /**
     * 查询微生物检测内容列表
     * 
     * @param baseMicrobedtl 微生物检测内容
     * @return 微生物检测内容集合
     */
    public List<BaseMicrobedtl> selectBaseMicrobedtlList(BaseMicrobedtl baseMicrobedtl);

    /**
     * 新增微生物检测内容
     * 
     * @param baseMicrobedtl 微生物检测内容
     * @return 结果
     */
    public int insertBaseMicrobedtl(BaseMicrobedtl baseMicrobedtl);

    /**
     * 修改微生物检测内容
     * 
     * @param baseMicrobedtl 微生物检测内容
     * @return 结果
     */
    public int updateBaseMicrobedtl(BaseMicrobedtl baseMicrobedtl);

    /**
     * 删除微生物检测内容
     * 
     * @param id 微生物检测内容主键
     * @return 结果
     */
    public int deleteBaseMicrobedtlById(Long id);

    /**
     * 批量删除微生物检测内容
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseMicrobedtlByIds(Long[] ids);
}
