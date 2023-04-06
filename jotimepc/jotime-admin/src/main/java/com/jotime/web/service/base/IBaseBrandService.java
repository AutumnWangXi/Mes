package com.jotime.web.service.base;

import java.util.List;
import com.jotime.web.domain.base.BaseBrand;
import com.jotime.web.domain.base.BaseMfrs;

/**
 *  生产商品牌Service接口
 * 
 * @author ruoyi
 * @date 2022-01-04
 */
public interface IBaseBrandService 
{
    /**
     * 查询生产商品牌列表信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public BaseBrand selectBaseBrandById(Long id);

    /**
     * 查询生产商品牌列表
     * 
     * @param baseBrand 生产商品牌信息
     * @return 【请填写功能名称】集合
     */
    public List<BaseBrand> selectBaseBrandList(BaseBrand baseBrand);

    /**
     * 新增【请填写功能名称】
     * 
     * @param baseBrand 生产商品牌信息
     * @return 结果
     */
    public int insertBaseBrand(BaseBrand baseBrand);

    /**
     * 修改【请填写功能名称】
     * 
     * @param baseBrand 生产商品牌信息
     * @return 结果
     */
    public int updateBaseBrand(BaseBrand baseBrand);

    /**
     * 批量删除生产商品牌信息
     * 
     * @param ids 需要删除的生产商品牌主键集合
     * @return 结果
     */
    public int deleteBaseBrandByIds(Long[] ids);

    /**
     * 删除生产商品牌信息
     * 
     * @param id 生产商品牌主键
     * @return 结果
     */
    public int deleteBaseBrandById(Long id);

    /**
     * 查询生产商品牌列表
     *
     * @param baseBrand 生产商品牌信息
     * @return 【请填写功能名称】集合
     */
    public List<BaseBrand> selectBaseBrandVoList(BaseBrand baseBrand);

    /**
     * 校验生产name是否唯一性(登录)
     *
     * @param baseBrand 品牌
     * @return 品牌
     */
    public String checkBrandNameUnique(BaseBrand baseBrand);

    /**
     * 校验生产name是否唯一性(更新)
     *
     * @param baseBrand 品牌
     * @return 品牌
     */
    public String checkUpBrandNameUnique(BaseBrand baseBrand);

    /**
     * 校验生产Code是否唯一性
     *
     * @param baseBrand 品牌
     * @return 制造商
     */
    public String checkUpBrandIdUnique(BaseBrand baseBrand);

}
