package com.jotime.web.service.base.impl;

import com.jotime.common.utils.DateUtils;
import com.jotime.web.domain.base.BaseCategorydtl;
import com.jotime.web.mapper.base.BaseCategorydtlMapper;
import com.jotime.web.service.base.IBaseCategorydtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
@Service
public class BaseCategorydtlServiceImpl implements IBaseCategorydtlService
{
    @Autowired
    private BaseCategorydtlMapper baseCategorydtlMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public BaseCategorydtl selectBaseCategorydtlById(Long id)
    {
        return baseCategorydtlMapper.selectBaseCategorydtlById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param baseCategorydtl 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<BaseCategorydtl> selectBaseCategorydtlList(BaseCategorydtl baseCategorydtl)
    {
        return baseCategorydtlMapper.selectBaseCategorydtlList(baseCategorydtl);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param baseCategorydtl 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertBaseCategorydtl(BaseCategorydtl baseCategorydtl)
    {
        baseCategorydtl.setCreateTime(DateUtils.getNowDate());
        return baseCategorydtlMapper.insertBaseCategorydtl(baseCategorydtl);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param baseCategorydtl 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateBaseCategorydtl(BaseCategorydtl baseCategorydtl)
    {
        baseCategorydtl.setUpdateTime(DateUtils.getNowDate());
        return baseCategorydtlMapper.updateBaseCategorydtl(baseCategorydtl);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBaseCategorydtlByIds(Long[] ids)
    {
        return baseCategorydtlMapper.deleteBaseCategorydtlByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBaseCategorydtlById(Long id)
    {
        return baseCategorydtlMapper.deleteBaseCategorydtlById(id);
    }
}
