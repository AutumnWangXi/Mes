package com.jotime.web.service.base.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jotime.common.constant.CodeRuleConstants;
import com.jotime.common.constant.Constants;
import com.jotime.common.constant.CustomerConstants;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.common.utils.joTime.ApplyStatus;
import com.jotime.common.utils.joTime.CommonUtil;
import com.jotime.web.domain.base.BaseCustomers;
import com.jotime.web.domainVo.base.BaseCustomersVo;
import com.jotime.web.domainVo.excel.BaseCustomersExlVo;
import com.jotime.web.mapper.base.BaseCustomersMapper;
import com.jotime.web.service.base.IBaseCodeRuleService;
import com.jotime.web.service.base.IBaseCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户集合Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-27
 */
@Service
public class BaseCustomersServiceImpl extends ServiceImpl<BaseCustomersMapper, BaseCustomers> implements IBaseCustomersService {
    @Autowired
    private BaseCustomersMapper baseCustomersMapper;
    @Autowired
    private IBaseCodeRuleService baseCodeRuleService;

    /**
     * 查询客户集合
     *
     * @param id 客户集合主键
     * @return 客户集合
     */
    @Override
    public BaseCustomers selectBaseCustomersById(Long id) {
        return baseCustomersMapper.selectBaseCustomersById(id);
    }

    /**
     * 查询客户集合列表
     *
     * @param baseCustomers 客户集合
     * @param type          客户类型
     * @return 客户集合
     */
    @Override
    public List<BaseCustomers> selectBaseCustomersList(String type, BaseCustomers baseCustomers) {
        //返回不同类型客户
        switch (type) {
            case CustomerConstants.CUSTOMER_PAGE_HOME:
                baseCustomers.setCustomerType(CustomerConstants.CUSTOMER_HOME_VAL);
                return baseCustomersMapper.selectBaseCustomersList(baseCustomers);
            case CustomerConstants.CUSTOMER_PAGE_ABROAD:
                baseCustomers.setCustomerType(CustomerConstants.CUSTOMER_ABROAD_VAL);
                return baseCustomersMapper.selectBaseCustomersList(baseCustomers);
            default:
                return baseCustomersMapper.selectBaseCustomersList(baseCustomers);
        }
    }

    /**
     * 新增客户集合
     *
     * @param baseCustomers 客户集合
     * @param type          客户类型
     * @return 结果
     */
    @Override
    public int insertBaseCustomers(String type, BaseCustomers baseCustomers) {

        //返回不同类型客户
        switch (type) {
            case CustomerConstants.CUSTOMER_PAGE_HOME:
                baseCustomers.setCustomerType(CustomerConstants.CUSTOMER_HOME_VAL);

            case CustomerConstants.CUSTOMER_PAGE_ABROAD:
                baseCustomers.setCustomerType(CustomerConstants.CUSTOMER_ABROAD_VAL);
            default:
                baseCustomers.setCustomerType(CustomerConstants.CUSTOMER_HOME_VAL);
        }

        // 默认禁用
        if (StringUtils.isNull(baseCustomers.getStatus())) {
            baseCustomers.setStatus(Constants.STATUS_DISABLED);
        }

        baseCustomers.setCreateBy(SecurityUtils.getUsername());
        return baseCustomersMapper.insertBaseCustomers(baseCustomers);
    }

    /**
     * 修改客户集合
     *
     * @param baseCustomers 客户集合
     * @return 结果
     */
    @Override
    public int updateBaseCustomers(BaseCustomers baseCustomers) {

        baseCustomers.setUpdateBy(SecurityUtils.getUsername());
        return baseCustomersMapper.updateBaseCustomers(baseCustomers);
    }

    /**
     * 批量删除客户集合
     *
     * @param ids 需要删除的客户集合主键
     * @return 结果
     */
    @Override
    public int deleteBaseCustomersByIds(Long[] ids) {
        return baseCustomersMapper.deleteBaseCustomersByIds(ids);
    }

    /**
     * 删除客户集合信息
     *
     * @param id 客户集合主键
     * @return 结果
     */
    @Override
    public int deleteBaseCustomersById(Long id) {
        return baseCustomersMapper.deleteBaseCustomersById(id);
    }


    /**
     * 查询所有客户名称
     *
     * @return 返回内容消息操作提醒
     */
    @Override
    public AjaxResult selectCustomerName() {
        List<BaseCustomers> list = baseCustomersMapper.selectBaseCustomersDataList(new BaseCustomers());
        if (StringUtils.isNotEmpty(list)) {
            return AjaxResult.success().put("value", list);
        } else {
            return AjaxResult.error("未查询到客户，请联系管理员处理");
        }
    }


    /**
     * 根据客户名称查询客户
     *
     * @param customerName 客户名称
     * @return 客户数据
     */
    @Override
    public AjaxResult selectCustomersNo(String customerName) {
        String name = "";
        if (!"".equals(customerName) && StringUtils.isNotNull(customerName)) {
            //url转码
            name = CommonUtil.URLDecoder(customerName);
        }else {
            return AjaxResult.error("客户名称不可为空!");
        }
        QueryWrapper<BaseCustomers> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_name", name);
        BaseCustomers baseCustomers = baseCustomersMapper.selectOne(queryWrapper);
        if (StringUtils.isNotNull(baseCustomers)) {
            return AjaxResult.success().put("customerCode", baseCustomers.getCustomerCode()).put("customerId", baseCustomers.getId());
        } else {
            return AjaxResult.error(ApplyStatus.STATUS_501, "未查询到此客户，先添加客户");
        }
    }

    @Override
    public List<BaseCustomers> selectAllCustomer() {
        QueryWrapper<BaseCustomers> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("status", "0");
        return this.list(queryWrapper);
    }

    /**
     * 校验生产name是否唯一性(登录)
     *
     * @param baseCustomers 客户
     * @return 校验结果
     */
    @Override
    public String checkCustomerNameUnique(BaseCustomers baseCustomers) {
        // 校验数据是否已经存在
        List<BaseCustomers> lstChkCusInfo = baseCustomersMapper.selectCustomerNameUnique(StringUtils.trim(baseCustomers.getCustomerName()));
        if (lstChkCusInfo != null && lstChkCusInfo.size() > 0) {
            return CustomerConstants.CHECK_NG;
        }

        return CustomerConstants.CHECK_OK;
    }

    /**
     * 校验生产name是否唯一性(更新)
     *
     * @param baseCustomers 客户信息
     * @return 校验结果
     */
    @Override
    public String[] checkUpCustomerNameUnique(BaseCustomers baseCustomers) {
        String[] arrCheckRtn = new String[]{CustomerConstants.CHECK_OK, ""};
        BaseCustomers chkCusInfo = baseCustomersMapper.selectBaseCustomersById(baseCustomers.getId());
        // 数据查询不存在
        if (StringUtils.isNull(chkCusInfo) || StringUtils.isNull(chkCusInfo.getCustomerCode())) {
            arrCheckRtn[0] = CustomerConstants.CHECK_NG;
            arrCheckRtn[1] = "客户：" + baseCustomers.getCustomerName() + "'更新失败，客户已经被删除";
            return arrCheckRtn;
        }

        // 校验客户名称是否存在
        List<BaseCustomers> lstChkCusInfo = baseCustomersMapper.selectCustomerNameUnique(StringUtils.trim(baseCustomers.getCustomerName()));
        if (StringUtils.isNotNull(lstChkCusInfo) && lstChkCusInfo.size() > 0) {
            int iListSize = lstChkCusInfo.size();
            // 存在多条场合
            if (iListSize > 1) {
                arrCheckRtn[0] = CustomerConstants.CHECK_NG;
                arrCheckRtn[1] = "客户：" + baseCustomers.getCustomerName() + "'更新失败，客户已经存在";
                return arrCheckRtn;
            } else if (iListSize == 1) {
                // 存在，但是被别的人员优先更新了
                Long customerId = StringUtils.isNull(baseCustomers.getId()) ? -1L : baseCustomers.getId();
                BaseCustomers info = lstChkCusInfo.get(0);
                // 本身更新数据
                if (StringUtils.isNull(info) || info.getId().longValue() != customerId.longValue()) {
                    arrCheckRtn[0] = CustomerConstants.CHECK_NG;
                    arrCheckRtn[1] = "客户：" + baseCustomers.getCustomerName() + "'更新失败，客户已经存在";
                    return arrCheckRtn;
                }
            }
        }

        return arrCheckRtn;
    }

    /**
     * 查询客户下拉信息
     *
     * @return 客户下拉信息
     */
    @Override
    public List<BaseCustomersVo> selectCustomerOption() {
        // 校验数据是否已经存在
        return baseCustomersMapper.selectCustomerOption(CustomerConstants.STATUS_OK);
    }

    /**
     * 通过供应商code查询供应商id和名字
     *
     * @return 客户信息
     */
    @Override
    public BaseCustomers selectBaseCustomersByCode(String code) {
        return baseCustomersMapper.selectBaseCustomersByCode(code);
    }

    /**
     * 客户导入
     */
    @Override
    public int importData(List<BaseCustomersExlVo> baseCustomersExlVos, boolean updateSupport) {
        int row = 0;
        if (updateSupport) {
            for (BaseCustomersExlVo baseCustomersExlVo: baseCustomersExlVos) {
                judge(baseCustomersExlVo);
                BaseCustomers baseCustomers = new BaseCustomers();
                if(StringUtils.isNotNull(baseCustomersExlVo.getCustomerCode())) {
                    BaseCustomers bc= baseCustomersMapper.selectBaseCustomersByCode(baseCustomersExlVo.getCustomerCode());
                    if (StringUtils.isNotNull(bc)) {
                        conversion(baseCustomersExlVo,baseCustomers);
                        baseCustomers.setId(bc.getId());
                        baseCustomers.setUpdateBy(SecurityUtils.getUsername());
                        baseCustomers.setUpdateTime(DateUtils.getNowDate());
                        baseCustomersMapper.updateBaseCustomers(baseCustomers);
                    }else {
                        conversion(baseCustomersExlVo,baseCustomers);
                        row+=insertExlVo(baseCustomers,row);
                    }
                }else {
                    throw new RuntimeException("客户编码不能为空");
                }
            }
        }else {
            for (BaseCustomersExlVo baseCustomersExlVo: baseCustomersExlVos) {
                judge(baseCustomersExlVo);
                BaseCustomers baseCustomers = new BaseCustomers();
                //编码不为空
                if(StringUtils.isNotNull(baseCustomersExlVo.getCustomerCode())) {
                    BaseCustomers bc= baseCustomersMapper.selectBaseCustomersByCode(baseCustomersExlVo.getCustomerCode());
                    if (StringUtils.isNotNull(bc)) {
                        continue;
                    }else {
                        conversion(baseCustomersExlVo,baseCustomers);
                        row+=insertExlVo(baseCustomers,row);
                    }
                }else {
                    throw new RuntimeException("客户编码不能为空");
                }
            }
        }
        return row;
    }

    /**
     * 判断
     */
    private void judge(BaseCustomersExlVo baseCustomer) {
        BaseCustomers baseCustomers = new BaseCustomers();
        baseCustomers.setCustomerName(baseCustomer.getCustomerName());
        // 客户名称校验
        if (CustomerConstants.CHECK_NG.equals(checkCustomerNameUnique(baseCustomers))) {
            throw new RuntimeException("导入客户'" + baseCustomer.getCustomerName() + "'失败，客户已经存在");
        }
        // 取得供应商编码
        String[] arrCode = baseCodeRuleService.getCurRuleCode(CodeRuleConstants.RULE_CUSTOMER_CD, null);
        // 获取失败
        if (CodeRuleConstants.FAIL.equals(arrCode[0])) {
            throw new RuntimeException("导入客户" + baseCustomer.getCustomerName() + "'失败，" + arrCode[1]);
        }
    }

    //转换dao对象
    private void conversion(BaseCustomersExlVo baseCustomersExlVo,BaseCustomers baseCustomer) {
        //部分属性转换
        baseCustomer.setCustomerCode(baseCustomersExlVo.getCustomerCode());
        baseCustomer.setCustomerName(baseCustomersExlVo.getCustomerName());
        baseCustomer.setAddress(baseCustomersExlVo.getAddress());
        baseCustomer.setCompanyTelephone(baseCustomersExlVo.getCompanyTelephone());
        baseCustomer.setTin(baseCustomersExlVo.getTin());
        baseCustomer.setBankName(baseCustomersExlVo.getBankName());
        baseCustomer.setCaccountNumber(baseCustomersExlVo.getCaccountNumber());
        baseCustomer.setRecipientAddress(baseCustomersExlVo.getRecipientAddress());
        baseCustomer.setConsignee(baseCustomersExlVo.getConsignee());
        baseCustomer.setConsigneeTelephone(baseCustomersExlVo.getConsigneeTelephone());
        baseCustomer.setDeliveryAddress(baseCustomersExlVo.getDeliveryAddress());
        baseCustomer.setContactPerson(baseCustomersExlVo.getContactPerson());
        baseCustomer.setContactTelephone(baseCustomersExlVo.getContactTelephone());
        baseCustomer.setEmail(baseCustomersExlVo.getEmail());
        //预付款
        if(CustomerConstants.CUSTOMER_ADVANCE.equals(baseCustomersExlVo.getPayType())){
            baseCustomer.setPayType(CustomerConstants.PAYTYPE_0);
            //先款后付
        }else if (CustomerConstants.CUSTOMER_FIRSTPARAGRAPH.equals(baseCustomersExlVo.getPayType())){
            baseCustomer.setPayType(CustomerConstants.PAYTYPE_1);
            //先货后款
        }else if(CustomerConstants.CUSTOMER_GOODSFIRST.equals(baseCustomersExlVo.getPayType())){
            baseCustomer.setPayType(CustomerConstants.PAYTYPE_2);
        }
        baseCustomer.setCooperationDepth(baseCustomersExlVo.getCooperationDepth());
        baseCustomer.setCustomerBrand(baseCustomersExlVo.getCustomerBrand());
        baseCustomer.setBrandStatus(baseCustomersExlVo.getBrandStatus());
        baseCustomer.setCategoryStatus(baseCustomersExlVo.getCategoryStatus());
        baseCustomer.setCustomerLevel(baseCustomersExlVo.getCustomerLevel());
        baseCustomer.setSalesModel(baseCustomersExlVo.getSalesModel());
        baseCustomer.setOnlineShopAddress(baseCustomersExlVo.getOnlineShopAddress());
        baseCustomer.setOnlineMonthlySales(baseCustomersExlVo.getOnlineMonthlySales());
        baseCustomer.setStaffSize(baseCustomersExlVo.getStaffSize());
        baseCustomer.setSalesScale(baseCustomersExlVo.getSalesScale());
        //是
        if(CustomerConstants.CHECK_Y.equals(baseCustomersExlVo.getPackagingSupplier())){
            baseCustomer.setPackagingSupplier(CustomerConstants.CHECK_1);
            //不是
        }else if(CustomerConstants.CHECK_N.equals(baseCustomersExlVo.getPackagingSupplier())){
            baseCustomer.setPackagingSupplier(CustomerConstants.CHECK_0);
        }
        //是
        if(CustomerConstants.CHECK_Y.equals(baseCustomersExlVo.getCompleteSuppliers())){
            baseCustomer.setCompleteSuppliers(CustomerConstants.CHECK_1);
            //不是
        }else if(CustomerConstants.CHECK_N.equals(baseCustomersExlVo.getCompleteSuppliers())){
            baseCustomer.setCompleteSuppliers(CustomerConstants.CHECK_0);
        }
        baseCustomer.setCustomerDemand(baseCustomersExlVo.getCustomerDemand());
        baseCustomer.setBusinessContactOutline(baseCustomersExlVo.getBusinessContactOutline());
        baseCustomer.setBusinessType(baseCustomersExlVo.getBusinessType());
        baseCustomer.setMainProduct(baseCustomersExlVo.getMainProduct());
        baseCustomer.setDistributionChannel(baseCustomersExlVo.getDistributionChannel());
        baseCustomer.setMajorCountryMarkets(baseCustomersExlVo.getMajorCountryMarkets());
        baseCustomer.setSalesYear(baseCustomersExlVo.getSalesYear());
        baseCustomer.setCustomerStarLevel(baseCustomersExlVo.getCustomerStarLevel());
        //新客户
        if(CustomerConstants.CUSTOMER_REGULAR.equals(baseCustomersExlVo.getCustomerCategory())){
            baseCustomer.setCustomerCategory(CustomerConstants.CUSTOMER_REGULAR_1);
            //重点老客户
        }else if(CustomerConstants.CUSTOMER_KEYOLDCUSTOMERS.equals(baseCustomersExlVo.getCustomerCategory())){
            baseCustomer.setCustomerCategory(CustomerConstants.CUSTOMER_KEYOLDCUSTOMERS_2);
            //非重点老客户
        }else if(CustomerConstants.CUSTOMER_NONKEYACCOUNT.equals(baseCustomersExlVo.getCustomerCategory())){
            baseCustomer.setCustomerCategory(CustomerConstants.CUSTOMER_NONKEYACCOUNT_3);
        }
        //国内客户
        if(CustomerConstants.CUSTOMER_IMPORT_HOME.equals(baseCustomersExlVo.getCustomerType())||StringUtils.isNull(baseCustomersExlVo.getCustomerType())){
            baseCustomer.setCustomerType(CustomerConstants.CUSTOMER_HOME_VAL);
            //国内客户
        }else if(CustomerConstants.CUSTOMER_IMPORT_ABROAD.equals(baseCustomersExlVo.getCustomerType())){
            baseCustomer.setCustomerType(CustomerConstants.CUSTOMER_ABROAD_VAL);
            //不清楚
        }else if(CustomerConstants.CUSTOMER_PAGE_ELSE.equals(baseCustomersExlVo.getCustomerType())){
            baseCustomer.setCustomerType(CustomerConstants.CUSTOMER_ELSE_VAL);
        }
        //禁用
        if(CustomerConstants.CUSTOMER_IMPORT_N.equals(baseCustomersExlVo.getStatus())||StringUtils.isNull(baseCustomersExlVo.getStatus())||"".equals(baseCustomersExlVo.getStatus())){
            baseCustomer.setStatus(CustomerConstants.STATUS_DISABLED);
            //正常
        }else if(CustomerConstants.CUSTOMER_IMPORT_ABROAD.equals(baseCustomersExlVo.getStatus())) {
            baseCustomer.setStatus(CustomerConstants.STATUS_OK);
        }
        baseCustomer.setNote(baseCustomersExlVo.getNote());
    }

    /**
     * 新建对象
     */
    private int insertExlVo(BaseCustomers baseCustomer,int row) {
        baseCustomer.setCreator(SecurityUtils.getUsername());
        baseCustomer.setCreateBy(String.valueOf(SecurityUtils.getUserId()));
        baseCustomer.setCreateTime(DateUtils.getNowDate());
        return row+baseCustomersMapper.insertBaseCustomers(baseCustomer);
    }
}
