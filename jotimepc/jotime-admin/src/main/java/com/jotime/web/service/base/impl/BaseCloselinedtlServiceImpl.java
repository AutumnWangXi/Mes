package com.jotime.web.service.base.impl;

import com.jotime.common.utils.DateUtils;
import com.jotime.web.domain.base.BaseCloselinedtl;
import com.jotime.web.mapper.base.BaseCloselinedtlMapper;
import com.jotime.web.service.base.IBaseCloselinedtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 清线检查内容Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-04
 */
@Service
public class BaseCloselinedtlServiceImpl implements IBaseCloselinedtlService
{
    @Autowired
    private BaseCloselinedtlMapper baseCloselinedtlMapper;

    /**
     * 查询清线检查内容
     * 
     * @param id 清线检查内容主键
     * @return 清线检查内容
     */
    @Override
    public BaseCloselinedtl selectBaseCloselinedtlById(Long id)
    {
        return baseCloselinedtlMapper.selectBaseCloselinedtlById(id);
    }

    /**
     * 查询清线检查内容列表
     * 
     * @param baseCloselinedtl 清线检查内容
     * @return 清线检查内容
     */
    @Override
    public List<BaseCloselinedtl> selectBaseCloselinedtlList(BaseCloselinedtl baseCloselinedtl)
    {
        return baseCloselinedtlMapper.selectBaseCloselinedtlList(baseCloselinedtl);
    }

    /**
     * 新增清线检查内容
     * 
     * @param baseCloselinedtl 清线检查内容
     * @return 结果
     */
    @Override
    public int insertBaseCloselinedtl(BaseCloselinedtl baseCloselinedtl)
    {
        baseCloselinedtl.setCreateTime(DateUtils.getNowDate());
        return baseCloselinedtlMapper.insertBaseCloselinedtl(baseCloselinedtl);
    }

    /**
     * 修改清线检查内容
     * 
     * @param baseCloselinedtl 清线检查内容
     * @return 结果
     */
    @Override
    public int updateBaseCloselinedtl(BaseCloselinedtl baseCloselinedtl)
    {
        baseCloselinedtl.setUpdateTime(DateUtils.getNowDate());
        return baseCloselinedtlMapper.updateBaseCloselinedtl(baseCloselinedtl);
    }

    /**
     * 批量删除清线检查内容
     * 
     * @param ids 需要删除的清线检查内容主键
     * @return 结果
     */
    @Override
    public int deleteBaseCloselinedtlByIds(Long[] ids)
    {
        return baseCloselinedtlMapper.deleteBaseCloselinedtlByIds(ids);
    }

    /**
     * 删除清线检查内容信息
     * 
     * @param id 清线检查内容主键
     * @return 结果
     */
    @Override
    public int deleteBaseCloselinedtlById(Long id)
    {
        return baseCloselinedtlMapper.deleteBaseCloselinedtlById(id);
    }
}
