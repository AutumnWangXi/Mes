package com.jotime.web.service.base.impl;

import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.base.BaseRiskSubstances;
import com.jotime.web.mapper.base.BaseRiskSubstancesMapper;
import com.jotime.web.service.base.IBaseRiskSubstancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 安全性风险物质危害识别Service业务层处理
 *
 * @author yunmoqian
 * @date 2022-04-21
 */
@Service
public class BaseRiskSubstancesServiceImpl implements IBaseRiskSubstancesService
{
    @Autowired
    private BaseRiskSubstancesMapper baseRiskSubstancesMapper;

    /**
     * 查询安全性风险物质危害识别
     *
     * @param id 安全性风险物质危害识别主键
     * @return 安全性风险物质危害识别
     */
    @Override
    public BaseRiskSubstances selectBaseRiskSubstancesById(Long id)
    {
        return baseRiskSubstancesMapper.selectBaseRiskSubstancesById(id);
    }

    /**
     * 查询安全性风险物质危害识别列表
     *
     * @param baseRiskSubstances 安全性风险物质危害识别
     * @return 安全性风险物质危害识别
     */
    @Override
    public List<BaseRiskSubstances> selectBaseRiskSubstancesList(BaseRiskSubstances baseRiskSubstances)
    {
        return baseRiskSubstancesMapper.selectBaseRiskSubstancesList(baseRiskSubstances);
    }

    /**
     * 新增安全性风险物质危害识别
     *
     * @param baseRiskSubstances 安全性风险物质危害识别
     * @return 结果
     */
    @Override
    public int insertBaseRiskSubstances(BaseRiskSubstances baseRiskSubstances)
    {
        //      判断重复
        if (!ObjectUtils.isEmpty(baseRiskSubstancesMapper.selectBaseRiskSubstancesByNameCn(baseRiskSubstances.getInciNameCn()))){
            throw new RuntimeException("名称重复！");
        }
        baseRiskSubstances.setCreateTime(DateUtils.getNowDate());
        baseRiskSubstances.setCreateBy(SecurityUtils.getUsername());
        return baseRiskSubstancesMapper.insertBaseRiskSubstances(baseRiskSubstances);
    }

    /**
     * 修改安全性风险物质危害识别
     *
     * @param baseRiskSubstances 安全性风险物质危害识别
     * @return 结果
     */
    @Override
    public int updateBaseRiskSubstances(BaseRiskSubstances baseRiskSubstances)
    {
        BaseRiskSubstances baseRiskSubstances1 = baseRiskSubstancesMapper.selectBaseRiskSubstancesByNameCn(baseRiskSubstances.getInciNameCn());
        //      判断重复
        if (!ObjectUtils.isEmpty(baseRiskSubstances1)){
            if (!baseRiskSubstances1.getId().equals(baseRiskSubstances.getId())){
                throw new RuntimeException("名称重复！");
            }
        }
        baseRiskSubstances.setUpdateBy(SecurityUtils.getUsername());
        baseRiskSubstances.setUpdateTime(DateUtils.getNowDate());
        return baseRiskSubstancesMapper.updateBaseRiskSubstances(baseRiskSubstances);
    }

    /**
     * 批量删除安全性风险物质危害识别
     *
     * @param ids 需要删除的安全性风险物质危害识别主键
     * @return 结果
     */
    @Override
    public int deleteBaseRiskSubstancesByIds(Long[] ids)
    {
        return baseRiskSubstancesMapper.deleteBaseRiskSubstancesByIds(ids);
    }

    /**
     * 删除安全性风险物质危害识别信息
     *
     * @param id 安全性风险物质危害识别主键
     * @return 结果
     */
    @Override
    public int deleteBaseRiskSubstancesById(Long id)
    {
        return baseRiskSubstancesMapper.deleteBaseRiskSubstancesById(id);
    }

    /**
     * @param baseRiskSubstancesList     表格
     * @param isUpdateSupport 是否可更新
     * @Description: 导入
     * @Author: YunFei
     * @Date: 2022/4/15 16:47
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int importData(List<BaseRiskSubstances> baseRiskSubstancesList, Boolean isUpdateSupport) {
        int row = 0;
        for (BaseRiskSubstances baseRiskSubstances : baseRiskSubstancesList) {
            if (StringUtils.isNotEmpty(baseRiskSubstances.getInciNameCn())){
//                if (StringUtils.isEmpty(baseRiskSubstances.getRiskSubstances())){
//                    throw new RuntimeException("导入失败！"+baseRiskSubstances.getInciNameCn()+"的风险物质为空！");
//                }
//                查询数据库中是否有该名称的数据，有则更新，无则插入
                BaseRiskSubstances baseRiskSubstancesDataBase = baseRiskSubstancesMapper.selectBaseRiskSubstancesByNameCn(baseRiskSubstances.getInciNameCn());
//                更新操作
                if (!ObjectUtils.isEmpty(baseRiskSubstancesDataBase)){
                    baseRiskSubstances.setUpdateBy(SecurityUtils.getUsername());
                    baseRiskSubstances.setUpdateTime(DateUtils.getNowDate());
                    baseRiskSubstances.setId(baseRiskSubstancesDataBase.getId());
                    row+=baseRiskSubstancesMapper.updateBaseRiskSubstances(baseRiskSubstances);
                }else {
                    //插入操作
                    baseRiskSubstances.setCreateTime(DateUtils.getNowDate());
                    baseRiskSubstances.setCreateBy(SecurityUtils.getUsername());
                    row+=baseRiskSubstancesMapper.insertBaseRiskSubstances(baseRiskSubstances);
                }
            }
        }
        return row;
    }

}
