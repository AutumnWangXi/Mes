package com.jotime.web.service.base;

import com.jotime.web.domain.base.BaseSupplier;
import com.jotime.web.domainVo.excel.BaseItemConsumableExlVo;

import java.util.List;

/**
 * 供应商Service接口
 *
 * @author ruoyi
 * @date 2021-12-30
 */
public interface IBaseSupplierService
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
     * 批量删除供应商
     *
     * @param ids 需要删除的供应商主键集合
     * @return 结果
     */
    public int deleteBaseSupplierByIds(Long[] ids);

    /**
     * 删除供应商信息
     *
     * @param id 供应商主键
     * @return 结果
     */
    public int deleteBaseSupplierById(Long id);

    /**
     * 校验数据唯一性
     *
     * @param baseSupplier 供应商
     * @return 结果
     */
    public String checkSupplierNameUnique(BaseSupplier baseSupplier);

    /**
     * 校验数据唯一性
     *
     * @param baseSupplier 供应商
     * @return 结果
     */
    public String checkSupplierUnique(BaseSupplier baseSupplier);

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
    public  List<BaseSupplier> selectSupplierName();

    /**
     * 通过供应商code查询供应商id和名字
     *
     * @return 客户信息
     */
    BaseSupplier selectBaseCustomersByCode(String supplierCode);

    /**
     * @Description: 表格导入
     * @param baseSuppliers 表格对象
     * @Author: YunFei
     * @Date: 2022/4/15 16:47
     */
    public int importData(List<BaseSupplier> baseSuppliers);

}
