package com.jotime.web.mapper.statistics;

import com.jotime.web.domain.statistics.FormulaStatistics;
import com.jotime.web.domainVo.statistics.FormulaStatisticsVo;

import java.util.List;
import java.util.Map;

/**
 * 配方关联统计Mapper接口
 *
 * @author zhangjun
 * @date 2021-12-08
 */
public interface FormulaStatisticsMapper {

    /**
     * 查询临时配方数量
     *
     * @param formulaStatistics 查询条件信息
     * @return List<FormulaStatisticsVo> 临时配方结果列表
     */
    public List<FormulaStatisticsVo> selectFormulaCount(FormulaStatistics formulaStatistics);
    /**
     * 查询研发人员各配方数量
     *
     * @param formulaStatistics 查询条件信息
     * @return List<FormulaStatisticsVo> 研发人员各配方结果列表
     */
    public List<FormulaStatisticsVo> selectRdEeFormulaSum(FormulaStatistics formulaStatistics);

    /**
     * 查询研发部门各配方数量
     *
     * @param formulaStatistics 查询条件信息
     * @return List<FormulaStatisticsVo> 研发人员各配方结果列表
     */
    public List<FormulaStatisticsVo> selectRdDeptFormulaSum(FormulaStatistics formulaStatistics);

    /**
     * 查询研发部人员信息
     *
     * @param formulaStatistics 查询条件信息
     * @return List<FormulaStatisticsVo> 研发人员各配方结果列表
     */
    public List<FormulaStatisticsVo> selectRdEmployee(FormulaStatistics formulaStatistics);
}
