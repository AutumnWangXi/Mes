package com.jotime.web.service.base.impl;

import java.util.List;
import com.jotime.common.utils.DateUtils;
import com.jotime.web.domain.base.BaseItemSupplier;
import com.jotime.web.domainVo.base.BaseItemSupplierVo;
import com.jotime.web.mapper.base.BaseItemSupplierMapper;
import com.jotime.web.service.base.IBaseItemSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 物料供应商Service业务层处理
 * 
 * @author yunmoqian
 * @date 2022-05-22
 */
@Service
public class BaseItemSupplierServiceImpl implements IBaseItemSupplierService
{
    @Autowired
    private BaseItemSupplierMapper baseItemSupplierMapper;

    /**
     * 查询物料供应商
     * 
     * @param id 物料供应商主键
     * @return 物料供应商
     */
    @Override
    public BaseItemSupplier selectBaseItemSupplierById(Long id)
    {
        return baseItemSupplierMapper.selectBaseItemSupplierById(id);
    }

    /**
     * 查询物料供应商列表
     * 
     * @param baseItemSupplier 物料供应商
     * @return 物料供应商
     */
    @Override
    public List<BaseItemSupplier> selectBaseItemSupplierList(BaseItemSupplier baseItemSupplier)
    {
        return baseItemSupplierMapper.selectBaseItemSupplierList(baseItemSupplier);
    }

    /**
     * 根据物料id查询供应商数据
     *
     * @param itemId 物料Id
     * @return 物料供应商集合
     */
    @Override
    public List<BaseItemSupplierVo> selectBaseItemSupplierListByItemId(Long itemId) {
        return baseItemSupplierMapper.selectBaseItemSupplierListByItemId(itemId);
    }

    /**
     * 新增物料供应商
     * 
     * @param baseItemSupplier 物料供应商
     * @return 结果
     */
    @Override
    public int insertBaseItemSupplier(BaseItemSupplier baseItemSupplier)
    {
        baseItemSupplier.setCreateTime(DateUtils.getNowDate());
        return baseItemSupplierMapper.insertBaseItemSupplier(baseItemSupplier);
    }

    /**
     * 修改物料供应商
     * 
     * @param baseItemSupplier 物料供应商
     * @return 结果
     */
    @Override
    public int updateBaseItemSupplier(BaseItemSupplier baseItemSupplier)
    {
        baseItemSupplier.setUpdateTime(DateUtils.getNowDate());
        return baseItemSupplierMapper.updateBaseItemSupplier(baseItemSupplier);
    }

    /**
     * 批量删除物料供应商
     * 
     * @param ids 需要删除的物料供应商主键
     * @return 结果
     */
    @Override
    public int deleteBaseItemSupplierByIds(Long[] ids)
    {
        return baseItemSupplierMapper.deleteBaseItemSupplierByIds(ids);
    }

    /**
     * 删除物料供应商信息
     * 
     * @param id 物料供应商主键
     * @return 结果
     */
    @Override
    public int deleteBaseItemSupplierById(Long id)
    {
        return baseItemSupplierMapper.deleteBaseItemSupplierById(id);
    }
}
