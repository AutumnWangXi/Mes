package com.jotime.web.service.base;

import java.util.List;
import com.jotime.web.domain.base.BaseItemSupplier;
import com.jotime.web.domainVo.base.BaseItemSupplierVo;

/**
 * 物料供应商Service接口
 * 
 * @author yunmoqian
 * @date 2022-05-22
 */
public interface IBaseItemSupplierService 
{
    /**
     * 查询物料供应商
     * 
     * @param id 物料供应商主键
     * @return 物料供应商
     */
    public BaseItemSupplier selectBaseItemSupplierById(Long id);

    /**
     * 查询物料供应商列表
     * 
     * @param baseItemSupplier 物料供应商
     * @return 物料供应商集合
     */
    public List<BaseItemSupplier> selectBaseItemSupplierList(BaseItemSupplier baseItemSupplier);
    /**
     * 根据物料id查询供应商数据
     *
     * @param itemId 物料Id
     * @return 物料供应商集合
     */
    public List<BaseItemSupplierVo> selectBaseItemSupplierListByItemId(Long itemId);

    /**
     * 新增物料供应商
     * 
     * @param baseItemSupplier 物料供应商
     * @return 结果
     */
    public int insertBaseItemSupplier(BaseItemSupplier baseItemSupplier);

    /**
     * 修改物料供应商
     * 
     * @param baseItemSupplier 物料供应商
     * @return 结果
     */
    public int updateBaseItemSupplier(BaseItemSupplier baseItemSupplier);

    /**
     * 批量删除物料供应商
     * 
     * @param ids 需要删除的物料供应商主键集合
     * @return 结果
     */
    public int deleteBaseItemSupplierByIds(Long[] ids);

    /**
     * 删除物料供应商信息
     * 
     * @param id 物料供应商主键
     * @return 结果
     */
    public int deleteBaseItemSupplierById(Long id);
}
