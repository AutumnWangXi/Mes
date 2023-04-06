package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BaseCategorydtl;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
public interface BaseCategorydtlMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteBaseCategorydtlById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseCategorydtlByIds(Long[] ids);
}
