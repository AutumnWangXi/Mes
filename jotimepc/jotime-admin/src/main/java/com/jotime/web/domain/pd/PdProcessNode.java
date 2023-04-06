package com.jotime.web.domain.pd;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

/**
 * 描述：生产流程节点对象 pd_process_node
 * 
 * @author yunmoqian
 * @date 2022-05-06
 */
public class PdProcessNode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 流程内码 */
    private Long id;

    /** 节点编码 */
    @Excel(name = "节点编码")
    private String nodeCode;

    /** 节点名称 */
    @Excel(name = "节点名称")
    private String nodeName;

    /** 流程内码 */
    @Excel(name = "流程内码")
    private Long moduleId;

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

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
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
        return "PdProcessNode{" +
                "id=" + id +
                ", nodeName='" + nodeName + '\'' +
                ", moduleId=" + moduleId +
                ", isStart=" + isStart +
                ", isMicrobeTests=" + isMicrobeTests +
                ", status=" + status +
                ", note='" + note + '\'' +
                '}';
    }
}
