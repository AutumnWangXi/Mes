package com.jotime.web.domain.file;

import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import com.jotime.common.core.domain.entity.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件夹名对象 file_folder
 * 
 * @author yunmoqian
 * @date 2022-08-11
 */
public class FileFolder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内码 */
    private Long id;

    /** 父文件夹内码 */
    @Excel(name = "父文件夹内码")
    private Long parentId;

    /** 祖级列表 */
    @Excel(name = "祖级列表")
    private String ancestors;

    /** 文件夹名 */
    @Excel(name = "文件夹名")
    private String fileFolder;

    /** 显示序号 */
    @Excel(name = "显示序号")
    private String displaySort;

    /** 状态(1 禁用 2 正常) */
    @Excel(name = "状态(1 禁用 2 正常)")
    private Integer status;

    /** 类别 */
    @Excel(name = "类别 ")
    private String category;

    /** 子文件夹 */
    private List<FileFolder> children = new ArrayList<FileFolder>();


    public List<FileFolder> getChildren() {
        return children;
    }

    public void setChildren(List<FileFolder> children) {
        this.children = children;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public Long getParentId()
    {
        return parentId;
    }
    public void setAncestors(String ancestors) 
    {
        this.ancestors = ancestors;
    }

    public String getAncestors() 
    {
        return ancestors;
    }
    public void setFileFolder(String fileFolder) 
    {
        this.fileFolder = fileFolder;
    }

    public String getFileFolder() 
    {
        return fileFolder;
    }
    public void setDisplaySort(String displaySort) 
    {
        this.displaySort = displaySort;
    }

    public String getDisplaySort() 
    {
        return displaySort;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .append("fileFolder", getFileFolder())
            .append("displaySort", getDisplaySort())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
