package com.jotime.web.domainVo.statistics;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

/**
 * 配方统计
 *
 * @author zhangjun
 * @date 2022-02-15
 */
public class FormulaStatisticsVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 配方名称 */
    private String formulaName;

    /** 配方数量 */
    private Integer formulaCount;

    /** 状态 */
    private Integer status;

    /** 开始时间*/
    private String endTime;

    /** 结束时间*/
    private String beginTime;

    /** 部门id */
    @Excel(name = "部门id")
    private Long deptId;
    /** 部门编码 */
    @Excel(name = "部门编码")
    private String deptCode;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String deptName;

    /** 员工id */
    @Excel(name = "员工id")
    private Long eeId;

    /** 员工编号 */
    @Excel(name = "员工编号")
    private String eeCode;

    /** 员工名字 */
    @Excel(name = "员工名字")
    private String eeName;

    /** 攻关配方数量 */
    private Integer attackCount;

    /** 创新配方数量 */
    private Integer innovativeCount;

    /** 父部门ID */
    private Long parentId;

    private Integer jobStatus;

    public String getFormulaName() {
        return formulaName;
    }

    public void setFormulaName(String formulaName) {
        this.formulaName = formulaName;
    }

    public Integer getFormulaCount() {
        return formulaCount;
    }

    public void setFormulaCount(Integer formulaCount) {
        this.formulaCount = formulaCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setEeId(Long eeId) {
        this.eeId = eeId;
    }

    public Long getEeId() {
        return eeId;
    }

    public String getEeCode() {
        return eeCode;
    }

    public void setEeCode(String eeCode) {
        this.eeCode = eeCode;
    }

    public void setEeName(String eeName) {
        this.eeName = eeName;
    }

    public String getEeName() {
        return eeName;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public Integer getAttackCount() {
        return attackCount;
    }

    public void setAttackCount(Integer attackCount) {
        this.attackCount = attackCount;
    }

    public Integer getInnovativeCount() {
        return innovativeCount;
    }

    public void setInnovativeCount(Integer innovativeCount) {
        this.innovativeCount = innovativeCount;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }
}
