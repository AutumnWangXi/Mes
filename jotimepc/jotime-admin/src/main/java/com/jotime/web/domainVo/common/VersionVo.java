package com.jotime.web.domainVo.common;

import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 部门表 sys_dept
 * 
 * @author ruoyi
 */
public class VersionVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    /** 编号 */
    private String no;

    /** 版本 */
    private String version;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
