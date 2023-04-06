package com.jotime.web.service.base.impl;


import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.web.domain.base.BaseMicrobe;
import com.jotime.web.mapper.base.BaseMicrobeMapper;
import com.jotime.web.service.base.IBaseMicrobeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 微生物检测Service业务层处理
 * 
 * @author yunmoqian
 * @date 2022-06-16
 */
@Service
public class BaseMicrobeServiceImpl implements IBaseMicrobeService
{
    @Autowired
    private BaseMicrobeMapper baseMicrobeMapper;

    /**
     * 查询微生物检测
     * 
     * @param id 微生物检测主键
     * @return 微生物检测
     */
    @Override
    public BaseMicrobe selectBaseMicrobeById(Long id)
    {
        return baseMicrobeMapper.selectBaseMicrobeById(id);
    }

    /**
     * 查询微生物检测列表
     * 
     * @param baseMicrobe 微生物检测
     * @return 微生物检测
     */
    @Override
    public List<BaseMicrobe> selectBaseMicrobeList(BaseMicrobe baseMicrobe)
    {
        return baseMicrobeMapper.selectBaseMicrobeList(baseMicrobe);
    }

    /**
     * 新增微生物检测
     * 
     * @param baseMicrobe 微生物检测
     * @return 结果
     */
    @Override
    public int insertBaseMicrobe(BaseMicrobe baseMicrobe)
    {
        baseMicrobe.setStatus(2);
        baseMicrobe.setCreateBy(SecurityUtils.getNickName());
        baseMicrobe.setCreateTime(DateUtils.getNowDate());
        return baseMicrobeMapper.insertBaseMicrobe(baseMicrobe);
    }

    /**
     * 修改微生物检测
     * 
     * @param baseMicrobe 微生物检测
     * @return 结果
     */
    @Override
    public int updateBaseMicrobe(BaseMicrobe baseMicrobe)
    {
        baseMicrobe.setUpdateBy(SecurityUtils.getNickName());
        baseMicrobe.setUpdateTime(DateUtils.getNowDate());
        return baseMicrobeMapper.updateBaseMicrobe(baseMicrobe);
    }

    /**
     * 批量删除微生物检测
     * 
     * @param ids 需要删除的微生物检测主键
     * @return 结果
     */
    @Override
    public int deleteBaseMicrobeByIds(Long[] ids)
    {
        return baseMicrobeMapper.deleteBaseMicrobeByIds(ids);
    }

    /**
     * 删除微生物检测信息
     * 
     * @param id 微生物检测主键
     * @return 结果
     */
    @Override
    public int deleteBaseMicrobeById(Long id)
    {
        return baseMicrobeMapper.deleteBaseMicrobeById(id);
    }
}
