package com.jotime.web.domain.file;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 描述：文件清单管理对象 file_list_manage
 * 
 * @author yunmoqian
 * @date 2022-08-12
 */
public class FileListManage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Long id;

    /** 文件夹内码 */
    @Excel(name = "文件夹内码")
    private Long folderId;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private String fileType;

    /** 文件编号 */
    @Excel(name = "文件编号")
    private String fileNo;

    /** 版本号(01开始) */
    @Excel(name = "版本号(01开始)")
    private String version;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String fileName;

    /** 文件名称 */
    @Excel(name = "文件地址")
    private String fileUrl;

    /** 文件名称 */
    @Excel(name = "模板文件地址")
    private String templateFileUrl;

    /** 生效日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生效日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date effectiveDate;

    /** 作废日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "作废日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expiryDate;

    /** 状态 1 作废 2 现行(正常） */
    @Excel(name = "状态 1 作废 2 现行(正常）")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private Long deptId;

    /** 扩展名 */
    @Excel(name = "扩展名")
    private String originalFileName;

    /** 文件大小（单位M） */
    @Excel(name = "文件大小", readConverterExp = "单=位M")
    private BigDecimal fileSize;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operator;

    /** 操作人编码 */
    @Excel(name = "操作人编码")
    private String operatorCode;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date operateTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFolderId(Long folderId) 
    {
        this.folderId = folderId;
    }

    public Long getFolderId() 
    {
        return folderId;
    }
    public void setFileType(String fileType) 
    {
        this.fileType = fileType;
    }

    public String getFileType() 
    {
        return fileType;
    }
    public void setFileNo(String fileNo) 
    {
        this.fileNo = fileNo;
    }

    public String getFileNo() 
    {
        return fileNo;
    }
    public void setVersion(String version) 
    {
        this.version = version;
    }

    public String getVersion() 
    {
        return version;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setFileUrl(String fileUrl) 
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() 
    {
        return fileUrl;
    }
    public void setEffectiveDate(Date effectiveDate) 
    {
        this.effectiveDate = effectiveDate;
    }

    public Date getEffectiveDate() 
    {
        return effectiveDate;
    }
    public void setExpiryDate(Date expiryDate) 
    {
        this.expiryDate = expiryDate;
    }

    public Date getExpiryDate() 
    {
        return expiryDate;
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
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setOriginalFileName(String originalFileName) 
    {
        this.originalFileName = originalFileName;
    }

    public String getOriginalFileName() 
    {
        return originalFileName;
    }
    public void setFileSize(BigDecimal fileSize) 
    {
        this.fileSize = fileSize;
    }

    public BigDecimal getFileSize() 
    {
        return fileSize;
    }
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
    }
    public void setOperatorCode(String operatorCode) 
    {
        this.operatorCode = operatorCode;
    }

    public String getOperatorCode() 
    {
        return operatorCode;
    }
    public void setOperateTime(Date operateTime) 
    {
        this.operateTime = operateTime;
    }

    public Date getOperateTime() 
    {
        return operateTime;
    }

    public String getTemplateFileUrl() {
        return templateFileUrl;
    }

    public void setTemplateFileUrl(String templateFileUrl) {
        this.templateFileUrl = templateFileUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("folderId", getFolderId())
            .append("fileType", getFileType())
            .append("fileNo", getFileNo())
            .append("version", getVersion())
            .append("fileName", getFileName())
            .append("fileUrl", getFileUrl())
            .append("effectiveDate", getEffectiveDate())
            .append("expiryDate", getExpiryDate())
            .append("status", getStatus())
            .append("note", getNote())
            .append("deptId", getDeptId())
            .append("createBy", getCreateBy())
            .append("originalFileName", getOriginalFileName())
            .append("createTime", getCreateTime())
            .append("fileSize", getFileSize())
            .append("updateBy", getUpdateBy())
            .append("operator", getOperator())
            .append("operatorCode", getOperatorCode())
            .append("updateTime", getUpdateTime())
            .append("operateTime", getOperateTime())
            .toString();
    }
}
