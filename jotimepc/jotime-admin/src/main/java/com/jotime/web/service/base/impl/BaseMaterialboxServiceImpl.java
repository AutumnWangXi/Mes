package com.jotime.web.service.base.impl;

import com.jotime.web.domain.base.BaseMaterialbox;
import com.jotime.web.mapper.base.BaseMaterialboxMapper;
import com.jotime.web.service.base.IBaseMaterialboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 物料箱基础Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
@Service
public class BaseMaterialboxServiceImpl implements IBaseMaterialboxService
{
    @Autowired
    private BaseMaterialboxMapper baseMaterialboxMapper;

    /**
     * 查询物料箱基础
     * 
     * @param id 物料箱基础主键
     * @return 物料箱基础
     */
    @Override
    public BaseMaterialbox selectBaseMaterialboxById(Long id)
    {
        return baseMaterialboxMapper.selectBaseMaterialboxById(id);
    }

    /**
     * 查询物料箱基础列表
     * 
     * @param baseMaterialbox 物料箱基础
     * @return 物料箱基础
     */
    @Override
    public List<BaseMaterialbox> selectBaseMaterialboxList(BaseMaterialbox baseMaterialbox)
    {
        return baseMaterialboxMapper.selectBaseMaterialboxList(baseMaterialbox);
    }

    /**
     * 新增物料箱基础
     * 
     * @param baseMaterialbox 物料箱基础
     * @return 结果
     */
    @Override
    public int insertBaseMaterialbox(BaseMaterialbox baseMaterialbox)
    {
        return baseMaterialboxMapper.insertBaseMaterialbox(baseMaterialbox);
    }

    /**
     * 修改物料箱基础
     * 
     * @param baseMaterialbox 物料箱基础
     * @return 结果
     */
    @Override
    public int updateBaseMaterialbox(BaseMaterialbox baseMaterialbox)
    {
        return baseMaterialboxMapper.updateBaseMaterialbox(baseMaterialbox);
    }

    /**
     * 批量删除物料箱基础
     * 
     * @param ids 需要删除的物料箱基础主键
     * @return 结果
     */
    @Override
    public int deleteBaseMaterialboxByIds(Long[] ids)
    {
        return baseMaterialboxMapper.deleteBaseMaterialboxByIds(ids);
    }

    /**
     * 删除物料箱基础信息
     * 
     * @param id 物料箱基础主键
     * @return 结果
     */
    @Override
    public int deleteBaseMaterialboxById(Long id)
    {
        return baseMaterialboxMapper.deleteBaseMaterialboxById(id);
    }
}
