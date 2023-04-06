package com.jotime.web.service.statistics;

import com.jotime.common.core.domain.AjaxResult;
import com.jotime.web.domainVo.statistics.FormulaStatisticsVo;

import java.util.Map;

/**
 * 配方统计关联Service接口
 *
 * @author ruoyi
 * @date 2021-12-08
 */
public interface IFormulaStatisticsService {

    /**
     * 查询配方统计
     * @param  formulaStatisticsVo 查询条件信息
     * @retrun 查询结果
     */
    public AjaxResult selectFormulaStatsData(FormulaStatisticsVo formulaStatisticsVo);

    /**
     * 查询配方统计
     * @param  formulaStatisticsVo 查询条件信息
     * @retrun 查询结果
     * @return
     */
    public AjaxResult selectRdFormulaStatsData(FormulaStatisticsVo formulaStatisticsVo);
    /**
     /**
     * 查询研发部门研发人员统计信息
     * @param  formulaStatisticsVo 查询条件信息
     * @retrun 查询结果
     * @return
     */
    public AjaxResult selectRdEeFormulaStatsData(FormulaStatisticsVo formulaStatisticsVo);
}
