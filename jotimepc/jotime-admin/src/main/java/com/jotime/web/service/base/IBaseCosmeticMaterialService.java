package com.jotime.web.service.base;

import com.jotime.web.domain.base.BaseCosmeticMaterial;

import java.util.List;

/**
 * 已使用化妆品原料Service接口
 *
 * @author yunmoqian
 * @date 2022-04-20
 */
public interface IBaseCosmeticMaterialService
{
    /**
     * 查询已使用化妆品原料
     *
     * @param id 已使用化妆品原料主键
     * @return 已使用化妆品原料
     */
    public BaseCosmeticMaterial selectBaseCosmeticMaterialById(Long id);

    /**
     * 查询已使用化妆品原料列表
     *
     * @param baseCosmeticMaterial 已使用化妆品原料
     * @return 已使用化妆品原料集合
     */
    public List<BaseCosmeticMaterial> selectBaseCosmeticMaterialList(BaseCosmeticMaterial baseCosmeticMaterial);

    /**
     * 新增已使用化妆品原料
     *
     * @param baseCosmeticMaterial 已使用化妆品原料
     * @return 结果
     */
    public int insertBaseCosmeticMaterial(BaseCosmeticMaterial baseCosmeticMaterial);

    /**
     * 修改已使用化妆品原料
     *
     * @param baseCosmeticMaterial 已使用化妆品原料
     * @return 结果
     */
    public int updateBaseCosmeticMaterial(BaseCosmeticMaterial baseCosmeticMaterial);

    /**
     * 批量删除已使用化妆品原料
     *
     * @param ids 需要删除的已使用化妆品原料主键集合
     * @return 结果
     */
    public int deleteBaseCosmeticMaterialByIds(Long[] ids);

    /**
     * 删除已使用化妆品原料信息
     *
     * @param id 已使用化妆品原料主键
     * @return 结果
     */
    public int deleteBaseCosmeticMaterialById(Long id);
}
