package com.jotime.web.mapper.base;

import java.util.List;
import com.jotime.web.domain.base.BaseBrand;

/**
 * 生产商品牌Mapper接口
 * 
 * @author ruoyi
 * @date 2022-01-04
 */
public interface BaseBrandMapper 
{
    /**
     * 查询生产商品牌信息
     * 
     * @param id 生产商品牌主键
     * @return 生产商品牌信息
     */
    public BaseBrand selectBaseBrandById(Long id);

    /**
     * 查询生产商品牌列表
     * 
     * @param baseBrand 生产商品牌信息
     * @return 生产商品牌列表
     */
    public List<BaseBrand> selectBaseBrandList(BaseBrand baseBrand);

    /**
     * 新增生产商品牌
     * 
     * @param baseBrand 生产商品牌
     * @return 结果
     */
    public int insertBaseBrand(BaseBrand baseBrand);

    /**
     * 修改生产商品牌信息
     * 
     * @param baseBrand 生产商品牌信息
     * @return 结果
     */
    public int updateBaseBrand(BaseBrand baseBrand);

    /**
     * 删除生产商品牌信息
     * 
     * @param id 生产商品牌主键
     * @return 结果
     */
    public int deleteBaseBrandById(Long id);

    /**
     * 批量删除生产商品牌信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseBrandByIds(Long[] ids);

    /**
     * 查询生产商品牌列表
     *
     * @param baseBrand 生产商品牌信息
     * @return 生产商品牌列表
     */
    public List<BaseBrand> selectBaseBrandVoList(BaseBrand baseBrand);

    /**
     * 查询生产商品牌列表
     *
     * @param baseBrand 生产商品牌信息
     * @return 生产商品牌列表
     */
    public List<BaseBrand> selectBaseBrandInfoByName(String brandName);
}
