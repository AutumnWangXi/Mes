package com.jotime.web.domainVo.base;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

/**
 * 包入库第三阶段质检对象 base_checkpacking_third
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public class BaseCheckpackingThirdVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 检测项目 */
    @Excel(name = "检测项目")
    private String testItems;

    /** 检测标准 */
    @Excel(name = "检测标准")
    private String testingStandard;

    /** 检验数量 */
    @Excel(name = "检验数量")
    private String inspectionQuantity;

    /** 检测结果 */
    @Excel(name = "检测结果")
    private String testResults;

    /** 备注 */
    @Excel(name = "备注")
    private String remarkEscription;

    /** 结论 */
    @Excel(name = "结论")
    private String inConclusion;

    /** 检验日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "检验日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date inspectionDate;

    /** 检验员 */
    @Excel(name = "检验员")
    private String inspector;

    /** 复核人 */
    @Excel(name = "复核人")
    private String reviewer;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 创建人id */
    @Excel(name = "创建人id")
    private String creatorId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date gmtModified;

    /** 更新人 */
    @Excel(name = "更新人")
    private String modifiedUser;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTestItems(String testItems)
    {
        this.testItems = testItems;
    }

    public String getTestItems()
    {
        return testItems;
    }
    public void setTestingStandard(String testingStandard)
    {
        this.testingStandard = testingStandard;
    }

    public String getTestingStandard()
    {
        return testingStandard;
    }
    public void setInspectionQuantity(String inspectionQuantity)
    {
        this.inspectionQuantity = inspectionQuantity;
    }

    public String getInspectionQuantity()
    {
        return inspectionQuantity;
    }
    public void setTestResults(String testResults)
    {
        this.testResults = testResults;
    }

    public String getTestResults()
    {
        return testResults;
    }
    public void setRemarkEscription(String remarkEscription)
    {
        this.remarkEscription = remarkEscription;
    }

    public String getRemarkEscription()
    {
        return remarkEscription;
    }
    public void setInConclusion(String inConclusion)
    {
        this.inConclusion = inConclusion;
    }

    public String getInConclusion()
    {
        return inConclusion;
    }
    public void setInspectionDate(Date inspectionDate)
    {
        this.inspectionDate = inspectionDate;
    }

    public Date getInspectionDate()
    {
        return inspectionDate;
    }
    public void setInspector(String inspector)
    {
        this.inspector = inspector;
    }

    public String getInspector()
    {
        return inspector;
    }
    public void setReviewer(String reviewer)
    {
        this.reviewer = reviewer;
    }

    public String getReviewer()
    {
        return reviewer;
    }
    public void setCreator(String creator)
    {
        this.creator = creator;
    }

    public String getCreator()
    {
        return creator;
    }
    public void setCreatorId(String creatorId)
    {
        this.creatorId = creatorId;
    }

    public String getCreatorId()
    {
        return creatorId;
    }
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public Date getCreateDate()
    {
        return createDate;
    }
    public void setGmtModified(Date gmtModified)
    {
        this.gmtModified = gmtModified;
    }

    public Date getGmtModified()
    {
        return gmtModified;
    }
    public void setModifiedUser(String modifiedUser)
    {
        this.modifiedUser = modifiedUser;
    }

    public String getModifiedUser()
    {
        return modifiedUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("testItems", getTestItems())
                .append("testingStandard", getTestingStandard())
                .append("inspectionQuantity", getInspectionQuantity())
                .append("testResults", getTestResults())
                .append("remarkEscription", getRemarkEscription())
                .append("inConclusion", getInConclusion())
                .append("inspectionDate", getInspectionDate())
                .append("inspector", getInspector())
                .append("reviewer", getReviewer())
                .append("creator", getCreator())
                .append("creatorId", getCreatorId())
                .append("createDate", getCreateDate())
                .append("gmtModified", getGmtModified())
                .append("modifiedUser", getModifiedUser())
                .toString();
    }
}
