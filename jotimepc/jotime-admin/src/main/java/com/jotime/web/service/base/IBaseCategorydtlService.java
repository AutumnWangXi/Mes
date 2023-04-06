package com.jotime.web.service.base;


import com.jotime.web.domain.base.BaseCategorydtl;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
public interface IBaseCategorydtlService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public BaseCategorydtl selectBaseCategorydtlById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param baseCategorydtl 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<BaseCategorydtl> selectBaseCategorydtlList(BaseCategorydtl baseCategorydtl);

    /**
     * 新增【请填写功能名称】
     * 
     * @param baseCategorydtl 【请填写功能名称】
     * @return 结果
     */
    public int insertBaseCategorydtl(BaseCategorydtl baseCategorydtl);

    /**
     * 修改【请填写功能名称】
     * 
     * @param baseCategorydtl 【请填写功能名称】
     * @return 结果
     */
    public int updateBaseCategorydtl(BaseCategorydtl baseCategorydtl);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteBaseCategorydtlByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteBaseCategorydtlById(Long id);
}
