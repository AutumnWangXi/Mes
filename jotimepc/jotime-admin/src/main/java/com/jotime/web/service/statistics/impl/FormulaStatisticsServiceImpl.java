package com.jotime.web.service.statistics.impl;

import com.jotime.common.constant.EmployeeConstants;
import com.jotime.common.constant.RdConstants;
import com.jotime.common.constant.UserConstants;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.domain.entity.SysDept;
import com.jotime.common.utils.StringUtils;
import com.jotime.system.mapper.SysDeptMapper;
import com.jotime.web.domain.statistics.FormulaStatistics;
import com.jotime.web.domainVo.statistics.FormulaStatisticsVo;
import com.jotime.web.mapper.statistics.FormulaStatisticsMapper;
import com.jotime.web.service.statistics.IFormulaStatisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配方统计关联Service业务层处理
 *
 * @author zhangjun
 * @date 2021-12-08
 */
@Service
public class FormulaStatisticsServiceImpl implements IFormulaStatisticsService
{

    @Resource
    private FormulaStatisticsMapper formulaStatisticsMapper;
    @Resource
    private SysDeptMapper sysDeptMapper;

    /**
     * 查询配方统计信息
     * @param  formulaStatisticsVo 查询条件信息
     * @retrun 查询结果
     */
    @Override
    public AjaxResult selectFormulaStatsData(FormulaStatisticsVo formulaStatisticsVo) {

        FormulaStatistics selFormula = new FormulaStatistics();
        selFormula.setStatus(RdConstants.STS_UNDISTRIBUTION);
        selFormula.setStatus1(RdConstants.STS_DISTRIBUTION);
        selFormula.setStatus2(RdConstants.STS_FORMULA);
        selFormula.setStatus3(RdConstants.STS_FORMULA_FINISH);
        selFormula.setParams(formulaStatisticsVo.getParams());
        List<FormulaStatisticsVo> formulaStatisticsVoList =  formulaStatisticsMapper.selectFormulaCount(selFormula);

        return AjaxResult.success().put("formulaData",formulaStatisticsVoList);
    }

    /**
     * 查询研发配方统计信息
     * @param  formulaStatisticsVo 查询条件信息
     * @retrun 查询结果
     */
    @Override
    public AjaxResult selectRdFormulaStatsData(FormulaStatisticsVo formulaStatisticsVo) {

        // 取得研发部的所有部门
        SysDept sysDept = new SysDept();
        sysDept.setDeptCode(RdConstants.RD_DEPT_CODE);
        sysDept.setStatus(UserConstants.DEPT_NORMAL);
        List<SysDept> sysRdList = sysDeptMapper.selectDeptInfoList(sysDept);
        if (StringUtils.isEmpty(sysRdList)) {
            AjaxResult ajaxRtn = AjaxResult.success();
            ajaxRtn.put("rdFormulaData", new ArrayList<FormulaStatisticsVo>());
            ajaxRtn.put("deptFormulaData", new ArrayList<FormulaStatisticsVo>());
            ajaxRtn.put("eeFormulaData", new ArrayList<FormulaStatisticsVo>());
            return ajaxRtn;
        }

        SysDept rdSysDept = sysRdList.get(0);
        // 获取研发部所有部门
        sysDept = new SysDept();
        sysDept.setParentId(rdSysDept.getDeptId());
        sysDept.setStatus(UserConstants.DEPT_NORMAL);
        List<SysDept> sysDeptList = sysDeptMapper.selectDeptInfoList(sysDept);
        // 研发部门初始设定
        List<FormulaStatisticsVo> deptFormulaSumList = new ArrayList<>();
        for (SysDept tmpDept : sysDeptList) {
            FormulaStatisticsVo addStatistics = new FormulaStatisticsVo();
            addStatistics.setDeptId(tmpDept.getDeptId());
            addStatistics.setDeptCode(tmpDept.getDeptCode());
            addStatistics.setDeptName(tmpDept.getDeptName());
            addStatistics.setAttackCount(0);
            addStatistics.setFormulaCount(0);
            addStatistics.setInnovativeCount(0);
            deptFormulaSumList.add(addStatistics);
        }

        // 获取研发部所有人员
        FormulaStatistics selFormulaStats = new FormulaStatistics();
        selFormulaStats.setParentId(rdSysDept.getDeptId());
        selFormulaStats.setParams(formulaStatisticsVo.getParams());
        List<FormulaStatisticsVo> rdEmpList = formulaStatisticsMapper.selectRdEmployee(selFormulaStats);
        
        // 研发人员研发数量
        FormulaStatistics selFormula = new FormulaStatistics();
        int[] arrStatus = new int[3];
        arrStatus[0] = RdConstants.EEWORK_STS_WATING;
        arrStatus[1] = RdConstants.EEWORK_STS_DOING;
        arrStatus[2] = RdConstants.EEWORK_STS_FINISH;
        selFormula.setArrStatus(arrStatus);
        // 日期范围
        selFormula.setParams(formulaStatisticsVo.getParams());

        // 研发人员研发数量统计
        List<FormulaStatisticsVo> eeFormulaSumList = new ArrayList<>();
        List<FormulaStatisticsVo> selEeFormulaSumList = formulaStatisticsMapper.selectRdEeFormulaSum(selFormula);
        for (FormulaStatisticsVo rdEmpVo : rdEmpList) {
            rdEmpVo.setAttackCount(0);
            rdEmpVo.setFormulaCount(0);
            rdEmpVo.setInnovativeCount(0);
            for (int i = selEeFormulaSumList.size() -1; i >= 0; i--) {
                FormulaStatisticsVo eeFormulaStats = selEeFormulaSumList.get(i);
                if (rdEmpVo.getEeId().longValue() == eeFormulaStats.getEeId().longValue()) {
                    rdEmpVo.setAttackCount(eeFormulaStats.getAttackCount());
                    rdEmpVo.setFormulaCount(eeFormulaStats.getFormulaCount());
                    rdEmpVo.setInnovativeCount(eeFormulaStats.getInnovativeCount());
                    selEeFormulaSumList.remove(i);
                    break;
                }
            }

            if (!(rdEmpVo.getJobStatus() == EmployeeConstants.EM_JOB_STS_OFF
                    && rdEmpVo.getAttackCount() == 0
                    && rdEmpVo.getFormulaCount() == 0
                    && rdEmpVo.getInnovativeCount() == 0)) {
                eeFormulaSumList.add(rdEmpVo);
            }
        }


        for (FormulaStatisticsVo rdEmpVo : rdEmpList) {
            if (rdEmpVo.getJobStatus() == EmployeeConstants.EM_JOB_STS_OFF
                && rdEmpVo.getAttackCount() == 0
                && rdEmpVo.getFormulaCount() == 0
                && rdEmpVo.getInnovativeCount() == 0) {

            }
        }

        // 部门研发数量统计
        List<FormulaStatisticsVo> deptFormulaList = formulaStatisticsMapper.selectRdDeptFormulaSum(selFormula);

        // 研发部数量
        int iRdAttackCount = 0;
        int iRdFormulaCount = 0;
        int iRdInnovativeCount = 0;

        if (StringUtils.isNotEmpty(deptFormulaList)
                && StringUtils.isNotNull(deptFormulaList.get(0).getDeptId())) {
            for (FormulaStatisticsVo editStatistics : deptFormulaSumList) {
                for (FormulaStatisticsVo tmpStatistics : deptFormulaList) {
                    if (editStatistics.getDeptId().longValue() == tmpStatistics.getDeptId().longValue()) {
                        iRdAttackCount = iRdAttackCount + tmpStatistics.getAttackCount();
                        iRdFormulaCount = iRdFormulaCount + tmpStatistics.getFormulaCount();
                        iRdInnovativeCount = iRdInnovativeCount + tmpStatistics.getInnovativeCount();
                        editStatistics.setAttackCount(tmpStatistics.getAttackCount());
                        editStatistics.setFormulaCount(tmpStatistics.getFormulaCount());
                        editStatistics.setInnovativeCount(tmpStatistics.getInnovativeCount());
                        break;
                    }
                }
            }
        }

        // 研发部统计
        FormulaStatisticsVo formulaStatisticsSumVo = new FormulaStatisticsVo();
        formulaStatisticsSumVo.setDeptId(rdSysDept.getDeptId());
        formulaStatisticsSumVo.setDeptCode(rdSysDept.getDeptCode());
        formulaStatisticsSumVo.setDeptName(rdSysDept.getDeptName());
        formulaStatisticsSumVo.setAttackCount(iRdAttackCount);
        formulaStatisticsSumVo.setFormulaCount(iRdFormulaCount);
        formulaStatisticsSumVo.setInnovativeCount(iRdInnovativeCount);

        AjaxResult ajaxRtn = AjaxResult.success();
        ajaxRtn.put("eeFormulaData", eeFormulaSumList);
        ajaxRtn.put("deptFormulaData", deptFormulaSumList);
        ajaxRtn.put("rdFormulaData", formulaStatisticsSumVo);
        return ajaxRtn;
    }

    /**
     /**
     * 查询研发部门研发人员统计信息
     * @param  formulaStatisticsVo 查询条件信息
     * @retrun 查询结果
     */
    @Override
    public AjaxResult selectRdEeFormulaStatsData(FormulaStatisticsVo formulaStatisticsVo) {

        // 取得研发部的部门信息
        SysDept sysDept = new SysDept();
        sysDept.setDeptCode(formulaStatisticsVo.getDeptCode());
        sysDept.setStatus(UserConstants.DEPT_NORMAL);
        List<SysDept> sysRdList = sysDeptMapper.selectDeptInfoList(sysDept);
        if (StringUtils.isEmpty(sysRdList)) {
            AjaxResult ajaxRtn = AjaxResult.success();
            ajaxRtn.put("eeFormulaData", new ArrayList<FormulaStatisticsVo>());
            return ajaxRtn;
        }

        SysDept deptInfo = sysRdList.get(0);
        FormulaStatistics selFormulaStats = new FormulaStatistics();
        // 研发部
        if (StringUtils.strEquals(formulaStatisticsVo.getDeptCode(), RdConstants.RD_DEPT_CODE)) {
            // 获取研发部所有人员
            selFormulaStats.setParentId(deptInfo.getDeptId());
        } else {
            selFormulaStats.setDeptId(deptInfo.getDeptId());
        }

        selFormulaStats.setParams(formulaStatisticsVo.getParams());
        List<FormulaStatisticsVo> rdEmpList = formulaStatisticsMapper.selectRdEmployee(selFormulaStats);

        // 研发人员研发数量
        FormulaStatistics selFormula = new FormulaStatistics();
        int[] arrStatus = new int[3];
        arrStatus[0] = RdConstants.EEWORK_STS_WATING;
        arrStatus[1] = RdConstants.EEWORK_STS_DOING;
        arrStatus[2] = RdConstants.EEWORK_STS_FINISH;
        selFormula.setArrStatus(arrStatus);
        // 日期范围
        selFormula.setParams(formulaStatisticsVo.getParams());
        if (!StringUtils.strEquals(formulaStatisticsVo.getDeptCode(), RdConstants.RD_DEPT_CODE)) {
            selFormula.setDeptId(deptInfo.getDeptId());
        }

        // 研发人员研发数量统计
        List<FormulaStatisticsVo> eeFormulaSumList = new ArrayList<>();
        List<FormulaStatisticsVo> selEeFormulaSumList = formulaStatisticsMapper.selectRdEeFormulaSum(selFormula);
        for (FormulaStatisticsVo rdEmpVo : rdEmpList) {
            rdEmpVo.setAttackCount(0);
            rdEmpVo.setFormulaCount(0);
            rdEmpVo.setInnovativeCount(0);
            for (int i = selEeFormulaSumList.size() -1; i >= 0; i--) {
                FormulaStatisticsVo eeFormulaStats = selEeFormulaSumList.get(i);
                if (rdEmpVo.getEeId().longValue() == eeFormulaStats.getEeId().longValue()) {
                    rdEmpVo.setAttackCount(eeFormulaStats.getAttackCount());
                    rdEmpVo.setFormulaCount(eeFormulaStats.getFormulaCount());
                    rdEmpVo.setInnovativeCount(eeFormulaStats.getInnovativeCount());
                    selEeFormulaSumList.remove(i);
                    break;
                }
            }

            if (!(rdEmpVo.getJobStatus() == EmployeeConstants.EM_JOB_STS_OFF
                    && rdEmpVo.getAttackCount() == 0
                    && rdEmpVo.getFormulaCount() == 0
                    && rdEmpVo.getInnovativeCount() == 0)) {
                eeFormulaSumList.add(rdEmpVo);
            }
        }

        AjaxResult ajaxRtn = AjaxResult.success();
        ajaxRtn.put("eeFormulaData", eeFormulaSumList);
        return ajaxRtn;
    }
}
