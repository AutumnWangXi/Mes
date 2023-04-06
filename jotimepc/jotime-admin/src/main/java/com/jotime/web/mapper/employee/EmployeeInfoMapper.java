package com.jotime.web.mapper.employee;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.web.domain.employee.EmployeeInfo;
import com.jotime.web.domainVo.employee.EmployeeInfoVo;

import java.util.List;

/**
 * 员工信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-11-24
 */
public interface EmployeeInfoMapper extends BaseMapper<EmployeeInfo>
{
    /**
     * 查询员工信息
     * 
     * @param id 员工信息ID
     * @return 员工信息
     */
    public EmployeeInfoVo selectEmployeeInfoById(Long id);

    /**
     * 查询员工信息列表
     * 
     * @param employeeInfo 员工信息
     * @return 员工信息集合
     */
    public List<EmployeeInfoVo> selectEmployeeInfoList(EmployeeInfo employeeInfo);

    /**
     * 查询员工信息列表
     *
     * @param employeeInfo 员工信息
     * @return 员工信息集合
     */
    public List<EmployeeInfoVo> selectEmployeeInfoUnList(EmployeeInfo employeeInfo);

    /**
     * 新增员工信息
     * 
     * @param employeeInfo 员工信息
     * @return 结果
     */
    public int insertEmployeeInfo(EmployeeInfo employeeInfo);

    /**
     * 查询员工
     *
     * @param employeesCode 员工编码
     * @return 员工
     */
    public EmployeeInfoVo selectBaseByEmployeesCode(String employeesCode);

    /**
     * 修改员工信息
     * 
     * @param employeeInfo 员工信息
     * @return 结果
     */
    public int updateEmployeeInfo(EmployeeInfo employeeInfo);

    /**
     * 删除员工信息
     * 
     * @param id 员工信息ID
     * @return 结果
     */
    public int deleteEmployeeInfoById(Long id);

    /**
     * 批量删除员工信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEmployeeInfoByIds(Long[] ids);

    /**
     * 数组  查询员工
     */
    public List<EmployeeInfoVo> selectBaseEmployeesListById(String[] ids);

    /**
     * 数组  查询员工
     */
    public EmployeeInfoVo checkEeCodeUnique(String eeCode);

    /**
     * 查询员工信息列表
     *
     * @param employeeInfo 员工信息
     * @return 员工信息集合
     */
    public List<EmployeeInfoVo> selectEmployeeInfoByDept(EmployeeInfo employeeInfo);

    /**
     * 员工编码查询员工信息
     *
     * @param getEmployeeCode 员工信息ID
     * @return 员工信息
     */
    public EmployeeInfo selectEmployeeInfoByEmployeeCode(String getEmployeeCode);
}
