package com.jotime.web.domainVo.basebom;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

/**
 * 打样一期配方工序对象 base_initformula_processstep
 *
 * @author ruoyi
 * @date 2022-01-16
 */
public class BaseInitformulaProcessstepVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 工序内码 */
    @Excel(name = "工序内码")
    private Long processId;

    /** 配方编码 */
    @Excel(name = "配方编码")
    private String formulaNo;

    /** 配方id */
    @Excel(name = "配方id")
    private Long formulaId;

    /** 工序顺序 */
    @Excel(name = "工序顺序")
    private Integer stepSort;

    /** 工序描述 */
    @Excel(name = "工序描述")
    private String processDescription;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 版本号 */
    @Excel(name = "版本号")
    private String version;

    /** 工序名称 */
    @Excel(name = "工序名称")
    private String processName;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setProcessId(Long processId)
    {
        this.processId = processId;
    }

    public Long getProcessId()
    {
        return processId;
    }
    public void setFormulaNo(String formulaNo)
    {
        this.formulaNo = formulaNo;
    }

    public String getFormulaNo()
    {
        return formulaNo;
    }
    public void setStepSort(Integer stepSort)
    {
        this.stepSort = stepSort;
    }

    public Integer getStepSort()
    {
        return stepSort;
    }
    public void setProcessDescription(String processDescription)
    {
        this.processDescription = processDescription;
    }

    public String getProcessDescription()
    {
        return processDescription;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }

    public Long getFormulaId() {
        return formulaId;
    }

    public void setFormulaId(Long formulaId) {
        this.formulaId = formulaId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }
}
