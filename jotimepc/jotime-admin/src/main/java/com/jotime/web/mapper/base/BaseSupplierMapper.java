package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BaseSupplier;

import java.util.List;

/**
 * 供应商Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
public interface BaseSupplierMapper 
{
    /**
     * 查询供应商
     * 
     * @param id 供应商主键
     * @return 供应商
     */
    public BaseSupplier selectBaseSupplierById(Long id);

    /**
     * 查询供应商列表
     * 
     * @param baseSupplier 供应商
     * @return 供应商集合
     */
    public List<BaseSupplier> selectBaseSupplierList(BaseSupplier baseSupplier);

    /**
     * 新增供应商
     * 
     * @param baseSupplier 供应商
     * @return 结果
     */
    public int insertBaseSupplier(BaseSupplier baseSupplier);

    /**
     * 修改供应商
     * 
     * @param baseSupplier 供应商
     * @return 结果
     */
    public int updateBaseSupplier(BaseSupplier baseSupplier);

    /**
     * 删除供应商
     * 
     * @param id 供应商主键
     * @return 结果
     */
    public int deleteBaseSupplierById(Long id);

    /**
     * 批量删除供应商
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseSupplierByIds(Long[] ids);

    /**
     * 查询供应商
     *
     * @param id 供应商主键
     * @return 供应商
     */
    public BaseSupplier checkSupplierNameUnique(String id);

    /**
     * 审核供应商
     *
     * @param baseSupplier 供应商
     * @return 结果
     */
    public int updateSupplierCheckSts(BaseSupplier baseSupplier);

    /**
     * 下拉供应商列表
     * @return
     */
    public  List<BaseSupplier> selectSupplierName(Integer status);

    /**
     * 通过供应商code查询供应商id和名字
     *
     * @return 客户信息
     */
    BaseSupplier selectBaseCustomersByCode(String code);

    /**
     * 通过供应商code查询供应商id和名字
     *
     * @return 客户信息
     */
    List<BaseSupplier> selectBaseSupplierByName(String supplierName);
}
