package com.jotime.web.service.base;


import com.jotime.web.domain.base.BaseMaterialbox;

import java.util.List;

/**
 * 物料箱基础Service接口
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
public interface IBaseMaterialboxService 
{
    /**
     * 查询物料箱基础
     * 
     * @param id 物料箱基础主键
     * @return 物料箱基础
     */
    public BaseMaterialbox selectBaseMaterialboxById(Long id);

    /**
     * 查询物料箱基础列表
     * 
     * @param baseMaterialbox 物料箱基础
     * @return 物料箱基础集合
     */
    public List<BaseMaterialbox> selectBaseMaterialboxList(BaseMaterialbox baseMaterialbox);

    /**
     * 新增物料箱基础
     * 
     * @param baseMaterialbox 物料箱基础
     * @return 结果
     */
    public int insertBaseMaterialbox(BaseMaterialbox baseMaterialbox);

    /**
     * 修改物料箱基础
     * 
     * @param baseMaterialbox 物料箱基础
     * @return 结果
     */
    public int updateBaseMaterialbox(BaseMaterialbox baseMaterialbox);

    /**
     * 批量删除物料箱基础
     * 
     * @param ids 需要删除的物料箱基础主键集合
     * @return 结果
     */
    public int deleteBaseMaterialboxByIds(Long[] ids);

    /**
     * 删除物料箱基础信息
     * 
     * @param id 物料箱基础主键
     * @return 结果
     */
    public int deleteBaseMaterialboxById(Long id);
}
