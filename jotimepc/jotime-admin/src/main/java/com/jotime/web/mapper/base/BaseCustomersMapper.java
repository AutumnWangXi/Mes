package com.jotime.web.mapper.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.web.domain.base.BaseCustomers;
import com.jotime.web.domainVo.base.BaseCustomersVo;

import java.util.List;

/**
 * 客户集合Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
public interface BaseCustomersMapper extends BaseMapper<BaseCustomers>
{
    /**
     * 查询客户集合
     * 
     * @param id 客户集合主键
     * @return 客户集合
     */
    public BaseCustomers selectBaseCustomersById(Long id);

    /**
     * 查询客户集合列表
     * 
     * @param baseCustomers 客户集合
     * @return 客户集合集合
     */
    public List<BaseCustomers> selectBaseCustomersList(BaseCustomers baseCustomers);

    /**
     * 查询客户集合列表
     *
     * @param baseCustomers 客户集合
     * @return 客户集合集合
     */
    public List<BaseCustomers> selectBaseCustomersDataList(BaseCustomers baseCustomers);

    /**
     * 新增客户集合
     * 
     * @param baseCustomers 客户集合
     * @return 结果
     */
    public int insertBaseCustomers(BaseCustomers baseCustomers);

    /**
     * 修改客户集合
     * 
     * @param baseCustomers 客户集合
     * @return 结果
     */
    public int updateBaseCustomers(BaseCustomers baseCustomers);

    /**
     * 删除客户集合
     * 
     * @param id 客户集合主键
     * @return 结果
     */
    public int deleteBaseCustomersById(Long id);

    /**
     * 批量删除客户集合
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseCustomersByIds(Long[] ids);

    /**
     * 查询客户列表
     *
     * @param customerName 客户名称
     * @return 客户信息列表
     */
    public List<BaseCustomers> selectCustomerNameUnique(String customerName);

    /**
     * 查询客户列表
     *
     * @param status 状态
     * @return 客户信息列表
     */
    public List<BaseCustomersVo> selectCustomerOption(Integer status);

    /**
     * 通过供应商code查询供应商id和名字
     *
     * @return 客户信息
     */
    BaseCustomers selectBaseCustomersByCode(String code);
}
