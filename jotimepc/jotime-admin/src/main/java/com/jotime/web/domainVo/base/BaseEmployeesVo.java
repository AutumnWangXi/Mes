package com.jotime.web.domainVo.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 员工 -  sys_e_attachments 员工附件对象 base_employees
 * 
 * @author ruoyi
 * @date 2021-10-08
 */
public class BaseEmployeesVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 员工id */
    private String employeeId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String employeeName;

    /**  手机号码 */
    @Excel(name = " 手机号码")
    private String employeePhone;

    /** $column.columnComment */
    @Excel(name = " 手机号码")
    private String employeeEmail;

    /** 车间名字 */
    @Excel(name = "车间名字")
    private String employeeWorkshop;

    /** 车间 id */
    @Excel(name = "车间 id")
    private String workshopId;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String department;

    /** 部门id */
    @Excel(name = "部门id")
    private String departmentId;

    /** 职务 */
    @Excel(name = "职务")
    private String job;

    /** 入职时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入职时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date hireDate;

    /** 合同到期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同到期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date departureDate;

    /** 员工状态 （在职，休假，离职） */
    @Excel(name = "员工状态 ", readConverterExp = "在=职，休假，离职")
    private String jobStatus;

    /** 是否有签字模板（0：没有 ，1：有） */
    @Excel(name = "是否有签字模板", readConverterExp = "0=：没有,，=1：有")
    private String autograph;

    /** 数据生成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "数据生成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEmployeeId(String employeeId) 
    {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() 
    {
        return employeeId;
    }
    public void setEmployeeName(String employeeName) 
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() 
    {
        return employeeName;
    }
    public void setEmployeePhone(String employeePhone) 
    {
        this.employeePhone = employeePhone;
    }

    public String getEmployeePhone() 
    {
        return employeePhone;
    }
    public void setEmployeeEmail(String employeeEmail) 
    {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeEmail() 
    {
        return employeeEmail;
    }
    public void setEmployeeWorkshop(String employeeWorkshop) 
    {
        this.employeeWorkshop = employeeWorkshop;
    }

    public String getEmployeeWorkshop() 
    {
        return employeeWorkshop;
    }
    public void setWorkshopId(String workshopId) 
    {
        this.workshopId = workshopId;
    }

    public String getWorkshopId() 
    {
        return workshopId;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setDepartmentId(String departmentId) 
    {
        this.departmentId = departmentId;
    }

    public String getDepartmentId() 
    {
        return departmentId;
    }
    public void setJob(String job) 
    {
        this.job = job;
    }

    public String getJob() 
    {
        return job;
    }
    public void setHireDate(Date hireDate) 
    {
        this.hireDate = hireDate;
    }

    public Date getHireDate() 
    {
        return hireDate;
    }
    public void setDepartureDate(Date departureDate) 
    {
        this.departureDate = departureDate;
    }

    public Date getDepartureDate() 
    {
        return departureDate;
    }
    public void setJobStatus(String jobStatus) 
    {
        this.jobStatus = jobStatus;
    }

    public String getJobStatus() 
    {
        return jobStatus;
    }
    public void setAutograph(String autograph) 
    {
        this.autograph = autograph;
    }

    public String getAutograph() 
    {
        return autograph;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("employeeId", getEmployeeId())
            .append("employeeName", getEmployeeName())
            .append("employeePhone", getEmployeePhone())
            .append("employeeEmail", getEmployeeEmail())
            .append("employeeWorkshop", getEmployeeWorkshop())
            .append("workshopId", getWorkshopId())
            .append("department", getDepartment())
            .append("departmentId", getDepartmentId())
            .append("job", getJob())
            .append("hireDate", getHireDate())
            .append("departureDate", getDepartureDate())
            .append("jobStatus", getJobStatus())
            .append("autograph", getAutograph())
            .append("createDate", getCreateDate())
            .toString();
    }
}
