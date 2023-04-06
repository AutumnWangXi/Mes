package com.jotime.web.service.employee;


import com.jotime.web.domain.employee.EmployeeInfo;
import com.jotime.web.domainVo.employee.EmployeeInfoVo;
import com.jotime.web.domainVo.excel.EmployeeInfoExlVo;

import java.util.List;

/**
 * 员工信息Service接口
 *
 * @author ruoyi
 * @date 2021-11-24
 */
public interface IEmployeeInfoService {
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
     * 查询当前员工部门下的全部员工列表
     *
     * @param employeeInfo 员工信息
     * @return 员工信息集合
     */
    public List<EmployeeInfoVo> selectEmployeeInfoDeptList(EmployeeInfo employeeInfo);

    /**
     * 查询员工信息列表
     *
     * @param employeeInfo 员工信息
     * @return 员工信息集合
     */
    public List<EmployeeInfoVo> selectEmployeeInfoUnList(EmployeeInfo employeeInfo);

    /**
     * 查询员工  员工附件
     *
     * @param employeeCode 员工 ID
     * @return 员工
     */
    public EmployeeInfoVo selectBaseByEmployeesCode(String employeeCode);

    /**
     * 新增员工信息
     *
     * @param employeeInfo 员工信息
     * @return 结果
     */
    public int insertEmployeeInfo(EmployeeInfo employeeInfo);

    /**
     * 修改员工信息
     *
     * @param employeeInfo 员工信息
     * @return 结果
     */
    public int updateEmployeeInfo(EmployeeInfo employeeInfo);

    /**
     * 批量删除员工信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEmployeeInfoByIds(Long[] ids);

    /**
     * 删除员工信息信息
     *
     * @param id 员工信息ID
     * @return 结果
     */
    public int deleteEmployeeInfoById(Long id);

    /**
     * 数组  查询员工
     */
    public List<EmployeeInfoVo> selectBaseEmployeesListById(String[] ids);

    /**
     * 校验员工编码是否唯一
     *
     * @param eeCode 用户信息
     * @return 结果
     */
    public String checkEeCodeUnique(String eeCode);

    /**
     *  获取本部门可安排工作的人员信息
     * @param deptId 部门Id
     * @return  本部门可安排工作的人员List
     */
    public List<EmployeeInfoVo> getDeptDoWorkEmployee(Long deptId);

    /**
     * 员工编码查询员工信息
     *
     * @param getEmployeeCode 员工信息ID
     * @return 员工信息
     */
    EmployeeInfo selectEmployeeInfoByEmployeeCode(String getEmployeeCode);

    /**
     * @Description: 员工导入
     * @param employeeInfoExlVos 耗材表格vo
     * @param isUpdateSupport 是否可更新
     * @Author: YunFei
     * @Date: 2022/4/15 16:47
     */
    public int importData(List<EmployeeInfoExlVo> employeeInfoExlVos, Boolean isUpdateSupport);

}
