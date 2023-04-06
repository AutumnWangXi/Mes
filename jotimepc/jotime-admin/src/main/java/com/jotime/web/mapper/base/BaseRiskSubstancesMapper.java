package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BaseRiskSubstances;

import java.util.List;

/**
 * 安全性风险物质危害识别Mapper接口
 *
 * @author yunmoqian
 * @date 2022-04-21
 */
public interface BaseRiskSubstancesMapper
{
    /**
     * 查询安全性风险物质危害识别
     *
     * @param id 安全性风险物质危害识别主键
     * @return 安全性风险物质危害识别
     */
    public BaseRiskSubstances selectBaseRiskSubstancesById(Long id);
    /**
     * 查询安全性风险物质危害识别
     *
     * @param ByNameCn 安全性风险物质危害识别中文名
     * @return 安全性风险物质危害识别
     */
    public BaseRiskSubstances selectBaseRiskSubstancesByNameCn(String ByNameCn);

    /**
     * 查询安全性风险物质危害识别列表
     *
     * @param baseRiskSubstances 安全性风险物质危害识别
     * @return 安全性风险物质危害识别集合
     */
    public List<BaseRiskSubstances> selectBaseRiskSubstancesList(BaseRiskSubstances baseRiskSubstances);

    /**
     * 新增安全性风险物质危害识别
     *
     * @param baseRiskSubstances 安全性风险物质危害识别
     * @return 结果
     */
    public int insertBaseRiskSubstances(BaseRiskSubstances baseRiskSubstances);

    /**
     * 修改安全性风险物质危害识别
     *
     * @param baseRiskSubstances 安全性风险物质危害识别
     * @return 结果
     */
    public int updateBaseRiskSubstances(BaseRiskSubstances baseRiskSubstances);

    /**
     * 删除安全性风险物质危害识别
     *
     * @param id 安全性风险物质危害识别主键
     * @return 结果
     */
    public int deleteBaseRiskSubstancesById(Long id);

    /**
     * 批量删除安全性风险物质危害识别
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseRiskSubstancesByIds(Long[] ids);
}
