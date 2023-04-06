package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BaseMaterialbox;

import java.util.List;

/**
 * 物料箱基础Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
public interface BaseMaterialboxMapper 
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
     * 删除物料箱基础
     * 
     * @param id 物料箱基础主键
     * @return 结果
     */
    public int deleteBaseMaterialboxById(Long id);

    /**
     * 批量删除物料箱基础
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseMaterialboxByIds(Long[] ids);
}
