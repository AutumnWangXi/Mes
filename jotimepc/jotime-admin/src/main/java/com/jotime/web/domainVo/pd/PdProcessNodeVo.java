package com.jotime.web.domainVo.pd;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 描述：生产流程节点对象 pd_process_node
 *
 * @author yunmoqian
 * @date 2022-05-06
 */
public class PdProcessNodeVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 流程内码 */
    private Long id;

    /** 节点名称 */
    @Excel(name = "节点名称")
    private String nodeName;

    /** 流程内码 */
    @Excel(name = "流程内码")
    private Long moduleId;

    /** 流程名称 */
    @Excel(name = "流程名称")
    private String moduleName;

    /** 是否起点标识 1 不是 2 是 */
    @Excel(name = "是否起点标识 1 不是 2 是")
    private Integer isStart;

    /** 是否需要微生物检测*/
    @Excel(name = "是否需要微生物检测1 不是 2 是")
    private Integer isMicrobeTests;

    /** 状态 1 删除 2 正常 */
    @Excel(name = "状态 1 删除 2 正常")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    @TableField(exist = false)
    private Long workShopId;

    @TableField(exist = false)
    private String workShopName;

    @TableField(exist = false)
    private String deptName;

    /** 节点编码 */
    @Excel(name = "节点编码")
    private String nodeCode;

    /** 下一个节点id */
    private int nextNodeId;

    /** 配比（当前节点生产数量到下个节点能生产的比例）*/
    private BigDecimal mixture;


    public BigDecimal getMixture() {
        return mixture;
    }

    public void setMixture(BigDecimal mixture) {
        this.mixture = mixture;
    }

    public int getNextNodeId() {
        return nextNodeId;
    }

    public void setNextNodeId(int nextNodeId) {
        this.nextNodeId = nextNodeId;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getWorkShopName() {
        return workShopName;
    }

    public void setWorkShopName(String workShopName) {
        this.workShopName = workShopName;
    }

    public Long getWorkShopId() {
        return workShopId;
    }

    public void setWorkShopId(Long workShopId) {
        this.workShopId = workShopId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setNodeName(String nodeName)
    {
        this.nodeName = nodeName;
    }

    public String getNodeName()
    {
        return nodeName;
    }
    public void setModuleId(Long moduleId)
    {
        this.moduleId = moduleId;
    }

    public Long getModuleId()
    {
        return moduleId;
    }
    public void setIsStart(Integer isStart)
    {
        this.isStart = isStart;
    }

    public Integer getIsStart()
    {
        return isStart;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }

    public Integer getIsMicrobeTests() {
        return isMicrobeTests;
    }

    public void setIsMicrobeTests(Integer isMicrobeTests) {
        this.isMicrobeTests = isMicrobeTests;
    }

    @Override
    public String toString() {
        return "PdProcessNodeVo{" +
                "id=" + id +
                ", nodeName='" + nodeName + '\'' +
                ", moduleId=" + moduleId +
                ", moduleName='" + moduleName + '\'' +
                ", isStart=" + isStart +
                ", isMicrobeTests=" + isMicrobeTests +
                ", status=" + status +
                ", note='" + note + '\'' +
                '}';
    }
}
