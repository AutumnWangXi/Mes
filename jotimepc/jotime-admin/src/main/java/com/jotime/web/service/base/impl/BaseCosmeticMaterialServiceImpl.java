package com.jotime.web.service.base.impl;

import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.base.BaseCosmeticMaterial;
import com.jotime.web.mapper.base.BaseCosmeticMaterialMapper;
import com.jotime.web.service.base.IBaseCosmeticMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 已使用化妆品原料Service业务层处理
 *
 * @author yunmoqian
 * @date 2022-04-20
 */
@Service
public class BaseCosmeticMaterialServiceImpl implements IBaseCosmeticMaterialService
{
    @Autowired
    private BaseCosmeticMaterialMapper baseCosmeticMaterialMapper;

    /**
     * 查询已使用化妆品原料
     *
     * @param id 已使用化妆品原料主键
     * @return 已使用化妆品原料
     */
    @Override
    public BaseCosmeticMaterial selectBaseCosmeticMaterialById(Long id)
    {
        return baseCosmeticMaterialMapper.selectBaseCosmeticMaterialById(id);
    }

    /**
     * 查询已使用化妆品原料列表
     *
     * @param baseCosmeticMaterial 已使用化妆品原料
     * @return 已使用化妆品原料
     */
    @Override
    public List<BaseCosmeticMaterial> selectBaseCosmeticMaterialList(BaseCosmeticMaterial baseCosmeticMaterial)
    {
        return baseCosmeticMaterialMapper.selectBaseCosmeticMaterialList(baseCosmeticMaterial);
    }


    /**
     * 新增已使用化妆品原料
     *
     * @param baseCosmeticMaterial 已使用化妆品原料
     * @return 结果
     */
    @Override
    public int insertBaseCosmeticMaterial(BaseCosmeticMaterial baseCosmeticMaterial)
    {
        baseCosmeticMaterial.setCreateBy(SecurityUtils.getUsername());
        baseCosmeticMaterial.setCreateTime(DateUtils.getNowDate());
        if (!ObjectUtils.isEmpty(baseCosmeticMaterialMapper.selectBaseCosmeticMaterialBySerialNumber(StringUtils.leftPad(baseCosmeticMaterial.getSerialNumber(),5,"0")))){
            throw new RuntimeException("序号重复，请重新填写");
        }
        return baseCosmeticMaterialMapper.insertBaseCosmeticMaterial(baseCosmeticMaterial);
    }
    /**
     * 修改已使用化妆品原料
     *
     * @param baseCosmeticMaterial 已使用化妆品原料
     * @return 结果
     */
    @Override
    public int updateBaseCosmeticMaterial(BaseCosmeticMaterial baseCosmeticMaterial)
    {
        BaseCosmeticMaterial baseCosmeticMaterial1 = baseCosmeticMaterialMapper.selectBaseCosmeticMaterialBySerialNumber(StringUtils.leftPad(baseCosmeticMaterial.getSerialNumber(),5,"0"));
        if (!ObjectUtils.isEmpty(baseCosmeticMaterial1)){
            if (!baseCosmeticMaterial1.getId().equals(baseCosmeticMaterial.getId())){
                throw new RuntimeException("序号重复，请重新填写");
            }
        }
        baseCosmeticMaterial.setCreateBy(SecurityUtils.getUsername());
        baseCosmeticMaterial.setUpdateTime(DateUtils.getNowDate());
        return baseCosmeticMaterialMapper.updateBaseCosmeticMaterial(baseCosmeticMaterial);
    }

    /**
     * 批量删除已使用化妆品原料
     *
     * @param ids 需要删除的已使用化妆品原料主键
     * @return 结果
     */
    @Override
    public int deleteBaseCosmeticMaterialByIds(Long[] ids)
    {
        return baseCosmeticMaterialMapper.deleteBaseCosmeticMaterialByIds(ids);
    }

    /**
     * 删除已使用化妆品原料信息
     *
     * @param id 已使用化妆品原料主键
     * @return 结果
     */
    @Override
    public int deleteBaseCosmeticMaterialById(Long id)
    {
        return baseCosmeticMaterialMapper.deleteBaseCosmeticMaterialById(id);
    }

}
