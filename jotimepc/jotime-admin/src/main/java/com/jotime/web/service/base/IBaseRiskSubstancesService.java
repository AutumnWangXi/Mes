package com.jotime.web.service.base;

import com.jotime.web.domain.base.BaseRiskSubstances;

import java.util.List;

/**
 * 安全性风险物质危害识别Service接口
 *
 * @author yunmoqian
 * @date 2022-04-21
 */
public interface IBaseRiskSubstancesService
{
    /**
     * 查询安全性风险物质危害识别
     *
     * @param id 安全性风险物质危害识别主键
     * @return 安全性风险物质危害识别
     */
    public BaseRiskSubstances selectBaseRiskSubstancesById(Long id);

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
     * 批量删除安全性风险物质危害识别
     *
     * @param ids 需要删除的安全性风险物质危害识别主键集合
     * @return 结果
     */
    public int deleteBaseRiskSubstancesByIds(Long[] ids);

    /**
     * 删除安全性风险物质危害识别信息
     *
     * @param id 安全性风险物质危害识别主键
     * @return 结果
     */
    public int deleteBaseRiskSubstancesById(Long id);
    /**
     * @param baseRiskSubstancesList     表格
     * @param isUpdateSupport 是否可更新
     * @Description: 导入
     * @Author: YunFei
     * @Date: 2022/4/15 16:47
     */
    public int importData(List<BaseRiskSubstances> baseRiskSubstancesList, Boolean isUpdateSupport);
}
