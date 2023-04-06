package com.jotime.web.service.base;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.web.domain.base.BaseCustomers;
import com.jotime.web.domainVo.base.BaseCustomersVo;
import com.jotime.web.domainVo.excel.BaseCustomersExlVo;

import java.util.List;

/**
 * 客户集合Service接口
 *
 * @author ruoyi
 * @date 2021-12-27
 */
public interface IBaseCustomersService extends IService<BaseCustomers> {
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
     * @param type          客户类型
     * @return 客户集合
     */
    public List<BaseCustomers> selectBaseCustomersList(String type, BaseCustomers baseCustomers);

    /**
     * 新增客户集合
     *
     * @param baseCustomers 客户集合
     * @return 结果
     */
    public int insertBaseCustomers(String type, BaseCustomers baseCustomers);

    /**
     * 修改客户集合
     *
     * @param baseCustomers 客户集合
     * @return 结果
     */
    public int updateBaseCustomers(BaseCustomers baseCustomers);

    /**
     * 批量删除客户集合
     *
     * @param ids 需要删除的客户集合主键集合
     * @return 结果
     */
    public int deleteBaseCustomersByIds(Long[] ids);

    /**
     * 删除客户集合信息
     *
     * @param id 客户集合主键
     * @return 结果
     */
    public int deleteBaseCustomersById(Long id);

    /**
     * 查询所有客户名称
     *
     * @return 返回内容消息操作提醒
     */
    AjaxResult selectCustomerName();

    /**
     * 根据客户名称查询客户
     *
     * @param customerName 客户名称
     * @return 客户数据
     */
    public AjaxResult selectCustomersNo(String customerName);

    /**
     * 查询所有的客户数据
     *
     * @return 客户数据
     */
    List<BaseCustomers> selectAllCustomer();

    /**
     * 校验生产name是否唯一性
     *
     * @param baseCustomers 客户信息
     * @return 校验结果
     */

    public String checkCustomerNameUnique(BaseCustomers baseCustomers);

    /**
     * 校验生产name是否唯一性
     *
     * @param baseCustomers 客户信息
     * @return 校验结果
     */

    public String[] checkUpCustomerNameUnique(BaseCustomers baseCustomers);

    /**
     * 查询客户下拉信息
     *
     * @return 客户下拉信息
     */
    public List<BaseCustomersVo> selectCustomerOption();

    /**
     * 通过供应商code查询供应商id和名字
     *
     * @return 客户信息
     */
    BaseCustomers selectBaseCustomersByCode(String code);

    /**
     * 客户导入
     */
    int importData(List<BaseCustomersExlVo> baseCustomersExlVos, boolean updateSupport);
}
