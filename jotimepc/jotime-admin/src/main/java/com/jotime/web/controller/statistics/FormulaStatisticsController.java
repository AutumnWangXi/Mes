package com.jotime.web.controller.statistics;

import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.system.domain.SysOperLog;
import com.jotime.web.domainVo.statistics.FormulaStatisticsVo;
import com.jotime.web.service.statistics.IFormulaStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 配方统计关联Controller
 *
 * @author ruoyi
 * @date 2021-12-08
 */
@RestController
@RequestMapping("/web/formulastatistics")
public class FormulaStatisticsController extends BaseController {
    @Autowired
    private IFormulaStatisticsService formulaStatisticsService;

    /**
     * 查询配方统计信息
     *
     */
    @PreAuthorize("@ss.hasPermi('web:formulastatistics:list')")
    @PostMapping("/formulastats")
    public AjaxResult selectFormulastats(@RequestBody FormulaStatisticsVo formulaStatisticsVo) {
        return formulaStatisticsService.selectFormulaStatsData(formulaStatisticsVo);
    }

    /**
     * 查询研发配方统计信息
     *
     */
    @PreAuthorize("@ss.hasPermi('web:formulastatistics:list')")
    @PostMapping("/rdformulastats")
    public AjaxResult selectRdFormulastats(@RequestBody FormulaStatisticsVo formulaStatisticsVo) {
        return formulaStatisticsService.selectRdFormulaStatsData(formulaStatisticsVo);
    }

    /**
     * 查询研发部门研发人员统计信息
     *
     */
    @PreAuthorize("@ss.hasPermi('web:formulastatistics:list')")
    @PostMapping("/rdEeformulastats")
    public AjaxResult selectRdEeFormulastats(@RequestBody FormulaStatisticsVo formulaStatisticsVo) {
        return formulaStatisticsService.selectRdEeFormulaStatsData(formulaStatisticsVo);
    }
}
