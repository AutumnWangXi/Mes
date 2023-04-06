package com.jotime.web.domain.statistics;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 研发人员工作信息对象 rd_ee_workinfo
 *
 * @author ruoyi
 * @date 2022-02-15
 */
public class FormulaStatistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Integer num;

    /** 配方名称 */
    private String formulaName;

    /** 状态 */
    private Integer status;

    /** 状态1 */
    private Integer status1;

    /** 状态2 */
    private Integer status2;

    /** 状态3 */
    private Integer status3;

    /** 状态4 */
    private Integer status4;

    /** 开始时间*/
    private String beginTime;

    /** 结束时间*/
    private String endTime;

    /** 状态数组*/
    private int[] arrStatus;

    /** 父部门ID */
    private Long parentId;

    /** 部门id */
    private Long deptId;

    public String getFormulaName() {
        return formulaName;
    }

    public void setFormulaName(String formulaName) {
        this.formulaName = formulaName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus1() {
        return status1;
    }

    public void setStatus1(Integer status1) {
        this.status1 = status1;
    }

    public Integer getStatus2() {
        return status2;
    }

    public void setStatus2(Integer status2) {
        this.status2 = status2;
    }

    public Integer getStatus3() {
        return status3;
    }

    public void setStatus3(Integer status3) {
        this.status3 = status3;
    }

    public Integer getStatus4() {
        return status4;
    }

    public void setStatus4(Integer status4) {
        this.status4 = status4;
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


    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public int[] getArrStatus() {
        return arrStatus;
    }

    public void setArrStatus(int[] arrStatus) {
        this.arrStatus = arrStatus;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}
