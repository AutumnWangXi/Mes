package com.jotime.web.service.base.impl;

import com.jotime.common.constant.CodeRuleConstants;
import com.jotime.common.constant.Constants;
import com.jotime.common.constant.CustomerConstants;
import com.jotime.common.constant.SupplierConstants;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.base.BaseSupplier;
import com.jotime.web.domainVo.excel.BaseSupplierExlVo;
import com.jotime.web.mapper.base.BaseSupplierMapper;
import com.jotime.web.service.base.IBaseCodeRuleService;
import com.jotime.web.service.base.IBaseSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;

/**
 * 供应商Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-30
 */
@Service
public class BaseSupplierServiceImpl implements IBaseSupplierService
{
    @Autowired
    private BaseSupplierMapper baseSupplierMapper;
    @Autowired
    private IBaseCodeRuleService baseCodeRuleService;
    /**
     * 查询供应商
     *
     * @param id 供应商主键
     * @return 供应商
     */
    @Override
    public BaseSupplier selectBaseSupplierById(Long id)
    {
        return baseSupplierMapper.selectBaseSupplierById(id);
    }

    /**
     * 查询供应商列表
     *
     * @param baseSupplier 供应商
     * @return 供应商
     */
    @Override
    public List<BaseSupplier> selectBaseSupplierList(BaseSupplier baseSupplier)
    {
        return baseSupplierMapper.selectBaseSupplierList(baseSupplier);
    }

    /**
     * 新增供应商
     *
     * @param baseSupplier 供应商
     * @return 结果
     */
    @Override
    public int insertBaseSupplier(BaseSupplier baseSupplier)
    {
        // 插入数据设定
        baseSupplier.setSupplierName(StringUtils.trim(baseSupplier.getSupplierName()));
        baseSupplier.setCheckStatus(SupplierConstants.CHECK_STATUS_WAITING);
        baseSupplier.setStatus(Constants.STATUS_OK);
        baseSupplier.setCreateBy(SecurityUtils.getUsername());
        return baseSupplierMapper.insertBaseSupplier(baseSupplier);
    }

    /**
     * 修改供应商
     *
     * @param baseSupplier 供应商
     * @return 结果
     */
    @Override
    public int updateBaseSupplier(BaseSupplier baseSupplier)
    {
        // 有修改就需要重新审核
        baseSupplier.setCheckStatus(SupplierConstants.CHECK_STATUS_WAITING);
        baseSupplier.setUpdateBy(SecurityUtils.getUsername());
        return baseSupplierMapper.updateBaseSupplier(baseSupplier);
    }

    /**
     * 批量删除供应商
     *
     * @param ids 需要删除的供应商主键
     * @return 结果
     */
    @Override
    public int deleteBaseSupplierByIds(Long[] ids)
    {
        return baseSupplierMapper.deleteBaseSupplierByIds(ids);
    }

    /**
     * 删除供应商信息
     *
     * @param id 供应商主键
     * @return 结果
     */
    @Override
    public int deleteBaseSupplierById(Long id)
    {
        return baseSupplierMapper.deleteBaseSupplierById(id);
    }

    /**
     * 校验数据唯一性
     *
     * @param baseSupplier 供应商
     * @return 结果
     */
    @Override
    public String checkSupplierNameUnique(BaseSupplier baseSupplier) {

        Long supplierId = StringUtils.isNull(baseSupplier.getId()) ? -1L : baseSupplier.getId();

        BaseSupplier info = baseSupplierMapper.checkSupplierNameUnique(StringUtils.trim(baseSupplier.getSupplierName()));
        if (StringUtils.isNotNull(info) && info.getId().longValue() != supplierId.longValue())
        {
            return SupplierConstants.NOT_UNIQUE;
        }
        return SupplierConstants.UNIQUE;
    }

    /**
     * 校验数据唯一性
     *
     * @param baseSupplier 供应商
     * @return 结果
     */
    @Override
    public String checkSupplierUnique(BaseSupplier baseSupplier) {

        Long supplierId = StringUtils.isNull(baseSupplier.getId()) ? -1L : baseSupplier.getId();

        BaseSupplier info = baseSupplierMapper.selectBaseSupplierById(baseSupplier.getId());
        if (StringUtils.isNotNull(info) && info.getId().longValue() == supplierId.longValue())
        {
            return SupplierConstants.NOT_UNIQUE;
        }
        return SupplierConstants.UNIQUE;
    }

    /**
     * 审核供应商
     *
     * @param baseSupplier 供应商
     * @return 结果
     */
    @Override
    public int updateSupplierCheckSts(BaseSupplier baseSupplier)
    {
        // 有修改就需要重新审核
        BaseSupplier upSupplier = new BaseSupplier();
        upSupplier.setId(baseSupplier.getId());
        upSupplier.setCheckNote(baseSupplier.getCheckNote());
        upSupplier.setCheckStatus(baseSupplier.getCheckStatus());
        upSupplier.setCheckId(SecurityUtils.getUserId());
        upSupplier.setChecker(SecurityUtils.getUsername());
        upSupplier.setUpdateBy(SecurityUtils.getUsername());
        return baseSupplierMapper.updateSupplierCheckSts(upSupplier);
    }

    /**
     * 下拉供应商列表
     * @return
     */
    @Override
    public  List<BaseSupplier> selectSupplierName(){
        // 校验数据是否已经存在
        return baseSupplierMapper.selectSupplierName(CustomerConstants.STATUS_OK);
    }

    /**
     * 通过供应商code查询供应商id和名字
     *
     * @return 客户信息
     */
    @Override
    public BaseSupplier selectBaseCustomersByCode(String code) {
        return baseSupplierMapper.selectBaseCustomersByCode(code);
    }

    /**
     * @param baseSuppliers   表格对象
     * @Description: 表格导入
     * @Author: YunFei
     * @Date: 2022/4/15 16:47
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int importData(List<BaseSupplier> baseSuppliers) {
        int row = 0;
        for (BaseSupplier baseSupplier : baseSuppliers) {
//            编码不为空
            if (StringUtils.isNotEmpty(baseSupplier.getSupplierCode())){
                BaseSupplier baseSupplier1 = baseSupplierMapper.selectBaseCustomersByCode(baseSupplier.getSupplierCode());
                if (baseSupplier1==null){
                    baseSupplier.setCreateBy(SecurityUtils.getUserId().toString());
                    baseSupplier.setCheckStatus(SupplierConstants.CHECK_STATUS_WAITING);
                    baseSupplier.setStatus(Constants.STATUS_OK);
                    row +=baseSupplierMapper.insertBaseSupplier(baseSupplier);
                }else {
                    baseSupplier.setId(baseSupplier1.getId());
                    baseSupplier.setUpdateBy(SecurityUtils.getUserId().toString());
                    row +=baseSupplierMapper.updateBaseSupplier(baseSupplier);
                }
            }else {
//                编码为空,读取的编码可能为  空字符串，所以赋值为null
                baseSupplier.setSupplierCode(null);
                List<BaseSupplier> baseSuppliers1 = baseSupplierMapper.selectBaseSupplierByName(baseSupplier.getSupplierName());
                if (ObjectUtils.isEmpty(baseSuppliers1)){
                    baseSupplier.setCreateBy(SecurityUtils.getUserId().toString());
                    baseSupplier.setCheckStatus(SupplierConstants.CHECK_STATUS_WAITING);
                    baseSupplier.setStatus(Constants.STATUS_OK);
                    // 取得供应商编码
                    String[] arrCode = baseCodeRuleService.getCurRuleCode(CodeRuleConstants.RULE_PACKAGE_SUPPLIER_CD, null);
                    // 获取失败
                    if (CodeRuleConstants.FAIL.equals(arrCode[0])) {
                        throw new RuntimeException(baseSupplier.getSupplierName()+"的编码生成失败！");
                    }
                    baseSupplier.setSupplierCode(arrCode[2]);
                    row +=baseSupplierMapper.insertBaseSupplier(baseSupplier);
                }else {
                    BaseSupplier baseSupplier1 = baseSuppliers1.get(0);
                    baseSupplier.setUpdateBy(SecurityUtils.getUserId().toString());
                    baseSupplier.setId(baseSupplier1.getId());
                    row +=baseSupplierMapper.updateBaseSupplier(baseSupplier);
                }
            }
        }
        return row;
    }
}
