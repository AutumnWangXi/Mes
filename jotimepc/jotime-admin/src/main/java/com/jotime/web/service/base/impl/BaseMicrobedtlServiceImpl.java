package com.jotime.web.service.base.impl;


import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.web.domain.base.BaseMicrobedtl;
import com.jotime.web.mapper.base.BaseMicrobedtlMapper;
import com.jotime.web.service.base.IBaseMicrobedtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 微生物检测内容Service业务层处理
 * 
 * @author yunmoqian
 * @date 2022-06-16
 */
@Service
public class BaseMicrobedtlServiceImpl implements IBaseMicrobedtlService
{
    @Autowired
    private BaseMicrobedtlMapper baseMicrobedtlMapper;

    /**
     * 查询微生物检测内容
     * 
     * @param id 微生物检测内容主键
     * @return 微生物检测内容
     */
    @Override
    public BaseMicrobedtl selectBaseMicrobedtlById(Long id)
    {
        return baseMicrobedtlMapper.selectBaseMicrobedtlById(id);
    }

    /**
     * 查询微生物检测内容列表
     * 
     * @param baseMicrobedtl 微生物检测内容
     * @return 微生物检测内容
     */
    @Override
    public List<BaseMicrobedtl> selectBaseMicrobedtlList(BaseMicrobedtl baseMicrobedtl)
    {
        return baseMicrobedtlMapper.selectBaseMicrobedtlList(baseMicrobedtl);
    }

    /**
     * 新增微生物检测内容
     * 
     * @param baseMicrobedtl 微生物检测内容
     * @return 结果
     */
    @Override
    public int insertBaseMicrobedtl(BaseMicrobedtl baseMicrobedtl)
    {
        baseMicrobedtl.setCreateBy(SecurityUtils.getNickName());
        baseMicrobedtl.setCreateTime(DateUtils.getNowDate());
        return baseMicrobedtlMapper.insertBaseMicrobedtl(baseMicrobedtl);
    }

    /**
     * 修改微生物检测内容
     * 
     * @param baseMicrobedtl 微生物检测内容
     * @return 结果
     */
    @Override
    public int updateBaseMicrobedtl(BaseMicrobedtl baseMicrobedtl)
    {
        baseMicrobedtl.setUpdateBy(SecurityUtils.getNickName());
        baseMicrobedtl.setUpdateTime(DateUtils.getNowDate());
        return baseMicrobedtlMapper.updateBaseMicrobedtl(baseMicrobedtl);
    }

    /**
     * 批量删除微生物检测内容
     * 
     * @param ids 需要删除的微生物检测内容主键
     * @return 结果
     */
    @Override
    public int deleteBaseMicrobedtlByIds(Long[] ids)
    {
        return baseMicrobedtlMapper.deleteBaseMicrobedtlByIds(ids);
    }

    /**
     * 删除微生物检测内容信息
     * 
     * @param id 微生物检测内容主键
     * @return 结果
     */
    @Override
    public int deleteBaseMicrobedtlById(Long id)
    {
        return baseMicrobedtlMapper.deleteBaseMicrobedtlById(id);
    }
}
