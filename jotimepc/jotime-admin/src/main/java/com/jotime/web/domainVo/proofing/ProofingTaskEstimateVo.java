package com.jotime.web.domainVo.proofing;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 打样评估对象 proofing_task_estimate
 * 
 * @author ruoyi
 * @date 2021-10-08
 */
public class ProofingTaskEstimateVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 评估ID */
    @Excel(name = "评估ID")
    private String estimateId;

    /** 类型  0：打样任务 1：打样一期 2：打样2期  */
    @Excel(name = "类型  0：打样任务 1：打样一期 2：打样2期 ")
    private String type;

    /** 状态：0 评估通过 1  评估驳回  */
    @Excel(name = "状态：0 评估通过 1  评估驳回 ")
    private String status;

    /** 打样前 */
    @Excel(name = "打样前")
    private String proofingFront;

    /** 打样编号 */
    @Excel(name = "打样编号")
    private String proofingOrder;

    /** 打样一期 */
    @Excel(name = "打样一期")
    private String proofingFirst;

    /** 打样一期前评估 */
    @Excel(name = "打样一期前评估")
    private String proofingId;

    /** 打样二期 */
    @Excel(name = "打样二期")
    private String proofingSecond;

    /** 创建者 */
    @Excel(name = "创建者")
    private String creatorId;

    /** 创建者名称 */
    @Excel(name = "创建者名称")
    private String creatorName;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date gmtModified;

    /** 更新者 */
    @Excel(name = "更新者")
    private String modifiedUser;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setEstimateId(String estimateId) 
    {
        this.estimateId = estimateId;
    }

    public String getEstimateId() 
    {
        return estimateId;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setProofingFront(String proofingFront) 
    {
        this.proofingFront = proofingFront;
    }

    public String getProofingFront() 
    {
        return proofingFront;
    }
    public void setProofingFirst(String proofingFirst) 
    {
        this.proofingFirst = proofingFirst;
    }

    public String getProofingFirst() 
    {
        return proofingFirst;
    }
    public void setProofingSecond(String proofingSecond) 
    {
        this.proofingSecond = proofingSecond;
    }

    public String getProofingSecond() 
    {
        return proofingSecond;
    }
    public void setCreatorId(String creatorId) 
    {
        this.creatorId = creatorId;
    }

    public String getCreatorId() 
    {
        return creatorId;
    }
    public void setCreatorName(String creatorName) 
    {
        this.creatorName = creatorName;
    }

    public String getCreatorName() 
    {
        return creatorName;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public String getProofingOrder() {
        return proofingOrder;
    }

    public void setProofingOrder(String proofingOrder) {
        this.proofingOrder = proofingOrder;
    }

    public String getProofingId() {
        return proofingId;
    }

    public void setProofingId(String proofingId) {
        this.proofingId = proofingId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("estimateId", getEstimateId())
            .append("type", getType())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("proofingFront", getProofingFront())
                .append("proofingOrder", getProofingOrder())
            .append("proofingFirst", getProofingFirst())
                .append("proofingId", getProofingId())
            .append("proofingSecond", getProofingSecond())
            .append("creatorId", getCreatorId())
            .append("creatorName", getCreatorName())
            .append("createDate", getCreateDate())
                .append("modifiedUser", getModifiedUser())
                .append("gmtModified", getGmtModified())
            .toString();
    }
}
