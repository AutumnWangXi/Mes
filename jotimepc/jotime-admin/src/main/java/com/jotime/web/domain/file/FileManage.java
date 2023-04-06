package com.jotime.web.domain.file;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 文件管理对象 file_manage
 *
 * @author ruoyi
 * @date 2021-12-23
 */
@TableName("file_manage")
public class FileManage extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 内码
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 关联的业务表名(建议使用表明驼峰作为标识，不遵守也可，但要保证其业务唯一性)
     */
    @Excel(name = "关联的业务表名(建议使用表明驼峰作为标识，不遵守也可，但要保证其业务唯一性)")
    private String tableName;

    /**
     * 关联表数据的id，查询时可通过表名 和 id拿到具体的文件数据
     */
    @Excel(name = "关联表数据的id，查询时可通过表名 和 id拿到具体的文件数据")
    private Long tableId;

    /**
     * 主题描述
     */
    @Excel(name = "主题描述")
    private String title;

    /**
     * 文件名
     */
    @Excel(name = "文件名")
    private String fileName;

    /**
     * 文件类型
     */
    @Excel(name = "文件类型")
    private String fileType;

    /**
     * 文件url地址
     */
    @Excel(name = "文件url地址")
    private String fileUrl;

    /**
     * 扩展名
     */
    @Excel(name = "扩展名")
    private String originalFileName;

    /**
     * 文件大小
     */
    @Excel(name = "文件大小")
    private String fileSize;

    /**
     * 操作人
     */
    @Excel(name = "操作人")
    private String operator;

    /**
     * 操作人编码
     */
    @Excel(name = "操作人编码")
    private String operatorCode;

    /**
     * 操作时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date operateTime;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;

    /**
     * 逻辑删除(1 否 2 是)
     */
    @Excel(name = "逻辑删除(1 否 2 是)")
    private Integer isDelete;

    /**
     * 状态(1 禁用 2 正常)
     */
    @Excel(name = "状态(1 禁用 2 正常)")
    private Integer status;

    /**
     * tableType 用于区分同属于一个大业务，但是小业务需要上传不同的文件，用与区分标识
     */
    @Excel(name = "用于区分同属于一个大业务，但是小业务需要上传不同的文件，用与区分标识")
    private Integer tableType;

    /**
     * 文件列表
     */
    @TableField(exist = false)
    private String deleteFileUrl;
    /**
     * 文件路径
     */
    @TableField(exist = false)
    private String[] filePaths;

    /**
     * tableId
     */
    @TableField(exist = false)
    private List<Long> uuidList;

    public String[] getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(String[] filePaths) {
        this.filePaths = filePaths;
    }

    public List<Long> getUuidList() {
        return uuidList;
    }

    public void setUuidList(List<Long> uuidList) {
        this.uuidList = uuidList;
    }

    public String getDeleteFileUrl() {
        return deleteFileUrl;
    }

    public void setDeleteFileUrl(String deleteFileUrl) {
        this.deleteFileUrl = deleteFileUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("tableName", getTableName())
                .append("tableId", getTableId())
                .append("title", getTitle())
                .append("fileName", getFileName())
                .append("fileType", getFileType())
                .append("fileUrl", getFileUrl())
                .append("originalFileName", getOriginalFileName())
                .append("fileSize", getFileSize())
                .append("operator", getOperator())
                .append("operatorCode", getOperatorCode())
                .append("operateTime", getOperateTime())
                .append("note", getNote())
                .append("isDelete", getIsDelete())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }

    public Integer getTableType() {
        return tableType;
    }

    public void setTableType(Integer tableType) {
        this.tableType = tableType;
    }
}
