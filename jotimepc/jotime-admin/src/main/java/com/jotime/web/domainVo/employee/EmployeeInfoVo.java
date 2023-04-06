package com.jotime.web.domainVo.employee;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jotime.web.domain.employee.EmployeeInfo;

import java.util.List;


/**
 * 员工信息对象 employee_info
 * 
 * @author ruoyi
 * @date 2021-11-24
 */
public class EmployeeInfoVo extends EmployeeInfo
{
    private static final long serialVersionUID = 1L;

    /** 部门名称 */
    private String deptName;

    /** 车间名称 */
//    @Excel(name = "车间名称")
    private String workshopName;

    /** 职务 */
//    @Excel(name = "职务")
    private String postName;

    /** 语言/技能 */
//    @Excel(name = "语言/技能")
    private String skills;

    @TableField(exist = false)
    private List<String> userIds;

    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @Override
    public String getSkills() {
        return skills;
    }

    @Override
    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public List<String> getUserIds() {
        return userIds;
    }

    @Override
    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }
}
