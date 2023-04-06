package com.jotime.web.service.employee.impl;

import com.jotime.common.constant.CodeRuleConstants;
import com.jotime.common.constant.Constants;
import com.jotime.common.constant.EmployeeConstants;
import com.jotime.common.constant.UserConstants;
import com.jotime.common.core.domain.entity.SysDept;
import com.jotime.common.enums.EmployeeInfoExlVoEnum;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.system.domain.SysPost;
import com.jotime.system.mapper.SysDeptMapper;
import com.jotime.system.mapper.SysPostMapper;
import com.jotime.web.domain.base.BaseWorkshop;
import com.jotime.web.domain.employee.EmployeeInfo;
import com.jotime.web.domainVo.employee.EmployeeInfoVo;
import com.jotime.web.domainVo.excel.EmployeeInfoExlVo;
import com.jotime.web.mapper.base.BaseWorkshopMapper;
import com.jotime.web.mapper.employee.EmployeeInfoMapper;
import com.jotime.web.service.base.IBaseCodeRuleService;
import com.jotime.web.service.employee.IEmployeeInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 员工信息Service业务层处理
 *
 * @author ruoyi
 * @date 2021-11-24
 */
@Service
public class EmployeeInfoServiceImpl implements IEmployeeInfoService {
    @Resource
    private IBaseCodeRuleService baseCodeRuleService;

    @Resource
    private EmployeeInfoMapper employeeInfoMapper;
    @Resource
    private SysDeptMapper sysDeptMapper;
    @Resource
    private SysPostMapper sysPostMapper;
    @Resource
    private BaseWorkshopMapper baseWorkshopMapper;

    /**
     * 查询员工信息
     *
     * @param id 员工信息ID
     * @return 员工信息
     */
    @Override
    public EmployeeInfoVo selectEmployeeInfoById(Long id) {
        return employeeInfoMapper.selectEmployeeInfoById(id);
    }

    /**
     * 查询员工信息列表
     *
     * @param employeeInfo 员工信息
     * @return 员工信息
     */
    @Override
    public List<EmployeeInfoVo> selectEmployeeInfoList(EmployeeInfo employeeInfo) {
        return employeeInfoMapper.selectEmployeeInfoList(employeeInfo);
    }

    @Override
    public List<EmployeeInfoVo> selectEmployeeInfoDeptList(EmployeeInfo employeeInfo) {
        if (employeeInfo == null) {
            employeeInfo = new EmployeeInfo();
        }
        employeeInfo.setDeptId(SecurityUtils.getDeptId());
        String eeCode = SecurityUtils.getEeCode();
        //员工列表
        List<EmployeeInfoVo> employeeInfoVos = employeeInfoMapper.selectEmployeeInfoByDept(employeeInfo);

        employeeInfoVos = employeeInfoVos.stream().filter(obj -> {
            return !eeCode.equals(obj.getEmployeeCode());
        }).collect(Collectors.toList());

        return employeeInfoVos;
    }

    /**
     * 查询员工信息列表
     *
     * @param employeeInfo 员工信息
     * @return 员工信息
     */
    @Override
    public List<EmployeeInfoVo> selectEmployeeInfoUnList(EmployeeInfo employeeInfo) {
        return employeeInfoMapper.selectEmployeeInfoUnList(employeeInfo);
    }

    /**
     * 查询员工  员工附件
     *
     * @param employeeCode 员工 ID
     * @return 员工
     */
    @Override
    public EmployeeInfoVo selectBaseByEmployeesCode(String employeeCode) {
        return employeeInfoMapper.selectBaseByEmployeesCode(employeeCode);
    }

    /**
     * 新增员工信息
     *
     * @param employeeInfo 员工信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertEmployeeInfo(EmployeeInfo employeeInfo) {
        // 获取员工编码
        String[] arrEmpRuleCode = baseCodeRuleService.getCurRuleCode(CodeRuleConstants.RULE_EMPLOYEE_CD, null);
        // 获取失败
        if (CodeRuleConstants.FAIL.equals(arrEmpRuleCode[0])) {
            throw new RuntimeException("员工编码获取失败！");
        }
        employeeInfo.setCreateBy(SecurityUtils.getUsername());
        employeeInfo.setCreateTime(DateUtils.getNowDate());
        employeeInfo.setEmployeeCode(arrEmpRuleCode[2]);
        return employeeInfoMapper.insertEmployeeInfo(employeeInfo);
    }

    /**
     * 修改员工信息
     *
     * @param employeeInfo 员工信息
     * @return 结果
     */
    @Override
    public int updateEmployeeInfo(EmployeeInfo employeeInfo) {
        return employeeInfoMapper.updateEmployeeInfo(employeeInfo);
    }

    /**
     * 删除员工信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEmployeeInfoByIds(Long[] ids) {
        return employeeInfoMapper.deleteEmployeeInfoByIds(ids);
    }

    /**
     * 删除员工信息信息
     *
     * @param id 员工信息ID
     * @return 结果
     */
    @Override
    public int deleteEmployeeInfoById(Long id) {
        return employeeInfoMapper.deleteEmployeeInfoById(id);
    }


    /**
     * 数组  查询员工
     */
    @Override
    public List<EmployeeInfoVo> selectBaseEmployeesListById(String[] ids) {
        return employeeInfoMapper.selectBaseEmployeesListById(ids);
    }

    /**
     * 校验员工编码是否唯一
     *
     * @param eeCode 用户信息
     * @return 结果
     */
    @Override
    public String checkEeCodeUnique(String eeCode) {

        EmployeeInfoVo info = employeeInfoMapper.checkEeCodeUnique(eeCode);
        if (StringUtils.isNotNull(info) && StringUtils.isNotEmpty(info.getEmployeeCode())) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 获取本部门可安排工作的人员信息
     *
     * @param deptId 部门Id
     * @return AjaxResult 转让人员以及转让配方任务信息
     */
    @Override
    public List<EmployeeInfoVo> getDeptDoWorkEmployee(Long deptId) {

        // 获取部门人员信息
        EmployeeInfoVo selEmInfoVo = new EmployeeInfoVo();
        selEmInfoVo.setDeptId(deptId);
        selEmInfoVo.setStatus(Constants.STATUS_OK);
        List<EmployeeInfoVo> deptEmployeeList = employeeInfoMapper.selectEmployeeInfoByDept(selEmInfoVo);

        if (StringUtils.isEmpty(deptEmployeeList)) {
            return deptEmployeeList;
        }

        // 去除离职人员、产假人员
        Iterator<EmployeeInfoVo> delEmIterator = deptEmployeeList.iterator();
        while (delEmIterator.hasNext()) {
            EmployeeInfoVo employeeInfoVo = delEmIterator.next();
            int iSts = employeeInfoVo.getStatus().intValue();
            int iJobSts = employeeInfoVo.getJobStatus().intValue();
            // 去除离职、产假数据
            if (iSts == Constants.STATUS_DISABLED
                    || iJobSts == EmployeeConstants.EM_JOB_STS_OFF
                    || iJobSts == EmployeeConstants.EM_JOB_STS_OML) {
                delEmIterator.remove();
            }
        }

        return deptEmployeeList;
    }

    /**
     * 员工编码查询员工信息
     *
     * @param getEmployeeCode 员工信息ID
     * @return 员工信息
     */
    @Override
    public EmployeeInfo selectEmployeeInfoByEmployeeCode(String getEmployeeCode) {
        return employeeInfoMapper.selectEmployeeInfoByEmployeeCode(getEmployeeCode);
    }

    /**
     * @param employeeInfoExlVos 员工表格vo
     * @param isUpdateSupport    是否可更新
     * @Description: 表格导入
     * @Author: YunFei
     * @Date: 2022/4/19 15:18
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int importData(List<EmployeeInfoExlVo> employeeInfoExlVos, Boolean isUpdateSupport) {
        int row = 0;
        //可更新操作
        if (isUpdateSupport) {
            for (EmployeeInfoExlVo employeeInfoExlVo : employeeInfoExlVos) {
                EmployeeInfo employeeInfo = new EmployeeInfo();
                if (StringUtils.isNotEmpty(employeeInfoExlVo.getEmployeeCode())) {
                    //查看是否有对应员工，有则更新，没有则插入
                    EmployeeInfoVo employeeInfoVo = employeeInfoMapper.selectBaseByEmployeesCode(employeeInfoExlVo.getEmployeeCode());
                    if (!ObjectUtils.isEmpty(employeeInfoVo)) {
                        employeeInfo.setId(employeeInfoVo.getId());
                        exlVoTransitionClass(employeeInfoExlVo, employeeInfo);
                        row += employeeInfoMapper.updateEmployeeInfo(employeeInfo);
                    } else {
                        employeeInfo.setCreateBy(SecurityUtils.getUsername());
                        employeeInfo.setCreateTime(DateUtils.getNowDate());
                        exlVoTransitionClass(employeeInfoExlVo, employeeInfo);
                        employeeInfo.setEmployeeCode(employeeInfoExlVo.getEmployeeCode());
                        row += employeeInfoMapper.insertEmployeeInfo(employeeInfo);
                    }
                } else {
                    // 获取员工编码
                    String[] arrEmpRuleCode = baseCodeRuleService.getCurRuleCode(CodeRuleConstants.RULE_EMPLOYEE_CD, null);
                    // 获取失败
                    if (CodeRuleConstants.FAIL.equals(arrEmpRuleCode[0])) {
                        throw new RuntimeException("员工编码获取失败！");
                    }
                    exlVoTransitionClass(employeeInfoExlVo, employeeInfo);
                    employeeInfo.setCreateTime(DateUtils.getNowDate());
                    employeeInfo.setCreateBy(SecurityUtils.getUsername());
                    employeeInfo.setEmployeeCode(arrEmpRuleCode[2]);
                    row += employeeInfoMapper.insertEmployeeInfo(employeeInfo);
                }
            }
            //不更新操作
        } else {
            for (EmployeeInfoExlVo employeeInfoExlVo : employeeInfoExlVos) {
                EmployeeInfo employeeInfo = new EmployeeInfo();
                if (StringUtils.isNotEmpty(employeeInfoExlVo.getEmployeeCode())) {
                    EmployeeInfoVo employeeInfoVo = employeeInfoMapper.selectBaseByEmployeesCode(employeeInfoExlVo.getEmployeeCode());
                    //查看是否有对应员工，有则跳过，没有则插入
                    if (!ObjectUtils.isEmpty(employeeInfoVo)) {
                        continue;
                    }
                    employeeInfo.setCreateBy(SecurityUtils.getUsername());
                    employeeInfo.setCreateTime(DateUtils.getNowDate());
                    exlVoTransitionClass(employeeInfoExlVo, employeeInfo);
                    employeeInfo.setEmployeeCode(employeeInfoExlVo.getEmployeeCode());
                    row += employeeInfoMapper.insertEmployeeInfo(employeeInfo);
                } else {
                    // 获取员工编码
                    String[] arrEmpRuleCode = baseCodeRuleService.getCurRuleCode(CodeRuleConstants.RULE_EMPLOYEE_CD, null);
                    // 获取失败
                    if (CodeRuleConstants.FAIL.equals(arrEmpRuleCode[0])) {
                        throw new RuntimeException("员工编码获取失败！");
                    }
                    exlVoTransitionClass(employeeInfoExlVo, employeeInfo);
                    employeeInfo.setCreateTime(DateUtils.getNowDate());
                    employeeInfo.setCreateBy(SecurityUtils.getUsername());
                    employeeInfo.setEmployeeCode(arrEmpRuleCode[2]);
                    row += employeeInfoMapper.insertEmployeeInfo(employeeInfo);
                }
            }
        }
        return row;
    }

    //员工表格Vo转换成可持久化操作的员工对象
    private void exlVoTransitionClass(EmployeeInfoExlVo employeeInfoExlVo, EmployeeInfo employeeInfo) {
        employeeInfo.setEmployeeName(employeeInfoExlVo.getEmployeeName());
        //员工姓名不能为空！
        if (StringUtils.isEmpty(employeeInfoExlVo.getEmployeeName())) {
            throw new RuntimeException("员工姓名不能为空！");
        }
        //员工部门编号不能为空
        if (StringUtils.isEmpty(employeeInfoExlVo.getDeptName())) {
            throw new RuntimeException("工号:" + employeeInfoExlVo.getEmployeeCode() + "，姓名" + employeeInfoExlVo.getEmployeeName() + "的员工部门编号不能为空！");
        }
        //设置部门编号
        SysDept sysDept = sysDeptMapper.selectDeptByDeptName(employeeInfoExlVo.getDeptName());
        if (!ObjectUtils.isEmpty(sysDept)) {
            employeeInfo.setDeptId(sysDept.getDeptId());
        }

        //根据职位名称获取职位对象
        if (StringUtils.isNotEmpty(employeeInfoExlVo.getPositionCode())) {
            SysPost sysPost = sysPostMapper.checkPostCodeUnique(employeeInfoExlVo.getPositionCode());
            if (!ObjectUtils.isEmpty(sysPost)) {
                employeeInfo.setPositionId(sysPost.getPostId());
                //职称
                if (StringUtils.isNotEmpty(employeeInfoExlVo.getPostName())) {
                    if (!sysPost.getPostName().equals(employeeInfoExlVo.getPostName())) {
                        throw new RuntimeException("员工职称不正确！");
                    }
                }
            }
        }
        //性别
        if (StringUtils.isNotNull(employeeInfoExlVo.getSex())) {
            if (EmployeeConstants.EM_SEX_NAN == employeeInfoExlVo.getSex()) {
                employeeInfo.setSex(EmployeeConstants.EM_SEX_N);
            } else if (EmployeeConstants.EM_SEX_NV == employeeInfoExlVo.getSex()) {
                employeeInfo.setSex(EmployeeConstants.EM_SEX_L);
            } else {
                employeeInfo.setSex(EmployeeConstants.EM_SEX_W);
            }
        }

        //婚姻
        if (StringUtils.isNotNull(employeeInfoExlVo.getMarriage())) {
            if (EmployeeConstants.EM_MARRIAGE_WH.equals(employeeInfoExlVo.getMarriage())) {
                employeeInfo.setMarriage(EmployeeConstants.EM_MARRIAGE_N);
            } else if (EmployeeConstants.EM_MARRIAGE_YH.equals(employeeInfoExlVo.getMarriage())) {
                employeeInfo.setMarriage(EmployeeConstants.EM_MARRIAGE_Y);
            } else {
                employeeInfo.setMarriage(EmployeeConstants.EM_MARRIAGE_W);
            }
        }

        //政治面貌
        if (StringUtils.isNotNull(employeeInfoExlVo.getPoliticalStatus())) {
            if (EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_ZGGCD.getMsg().equals(employeeInfoExlVo.getPoliticalStatus())) {
                employeeInfo.setPoliticalStatus(EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_ZGGCD.getCode());
            } else if (EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_ZGYBDY.getMsg().equals(employeeInfoExlVo.getPoliticalStatus())) {
                employeeInfo.setPoliticalStatus(EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_ZGYBDY.getCode());
            } else if (EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_GQTY.getMsg().equals(employeeInfoExlVo.getPoliticalStatus())) {
                employeeInfo.setPoliticalStatus(EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_GQTY.getCode());
            } else if (EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_MGDY.getMsg().equals(employeeInfoExlVo.getPoliticalStatus())) {
                employeeInfo.setPoliticalStatus(EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_MGDY.getCode());
            } else if (EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_MMMY.getMsg().equals(employeeInfoExlVo.getPoliticalStatus())) {
                employeeInfo.setPoliticalStatus(EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_MMMY.getCode());
            } else if (EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_MJHY.getMsg().equals(employeeInfoExlVo.getPoliticalStatus())) {
                employeeInfo.setPoliticalStatus(EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_MJHY.getCode());
            } else if (EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_MJHY2.getMsg().equals(employeeInfoExlVo.getPoliticalStatus())) {
                employeeInfo.setPoliticalStatus(EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_MJHY2.getCode());
            } else if (EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_NGDDY.getMsg().equals(employeeInfoExlVo.getPoliticalStatus())) {
                employeeInfo.setPoliticalStatus(EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_NGDDY.getCode());
            } else if (EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_ZGDDY.getMsg().equals(employeeInfoExlVo.getPoliticalStatus())) {
                employeeInfo.setPoliticalStatus(EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_ZGDDY.getCode());
            } else if (EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_JSXSSY.getMsg().equals(employeeInfoExlVo.getPoliticalStatus())) {
                employeeInfo.setPoliticalStatus(EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_JSXSSY.getCode());
            } else if (EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_TMMY.getMsg().equals(employeeInfoExlVo.getPoliticalStatus())) {
                employeeInfo.setPoliticalStatus(EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_TMMY.getCode());
            } else if (EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_WDPRS.getMsg().equals(employeeInfoExlVo.getPoliticalStatus())) {
                employeeInfo.setPoliticalStatus(EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_WDPRS.getCode());
            } else {
                employeeInfo.setPoliticalStatus(EmployeeInfoExlVoEnum.EM_POLITICALSTATUS_QZ.getCode());
            }
        }

        //根据车间名称获取车间对象
        if (StringUtils.isNotEmpty(employeeInfoExlVo.getWorkshopCode())){
            BaseWorkshop baseWorkshop = baseWorkshopMapper.selectBaseWorkshopByCode(employeeInfoExlVo.getWorkshopCode());
            if (!ObjectUtils.isEmpty(baseWorkshop)){
                employeeInfo.setWorkshopId(baseWorkshop.getId());
            }
        }

        //查询班组表 插入班组人员表
//        BaseGroup baseGroup=iBaseGroupService.selectBaseGroupuserBygroupName(employeeInfoExlVo.getGroupName());
//        if(StringUtils.isNull(baseGroup)){
//            throw new RuntimeException("工作小组不正确！");
//        }


        //学历
        if(EmployeeInfoExlVoEnum.EM_EDUCATION_SHIXI.getMsg().equals(employeeInfoExlVo.getEducation())){
            employeeInfo.setEducation(EmployeeInfoExlVoEnum.EM_EDUCATION_SHIXI.getCode());
        }else if(EmployeeInfoExlVoEnum.EM_EDUCATION_XIAOXUE.getMsg().equals(employeeInfoExlVo.getEducation())){
            employeeInfo.setEducation(EmployeeInfoExlVoEnum.EM_EDUCATION_XIAOXUE.getCode());
        }else if(EmployeeInfoExlVoEnum.EM_EDUCATION_CHUZHONG.getMsg().equals(employeeInfoExlVo.getEducation())){
            employeeInfo.setEducation(EmployeeInfoExlVoEnum.EM_EDUCATION_CHUZHONG.getCode());
        }else if(EmployeeInfoExlVoEnum.EM_EDUCATION_GAOZHONG.getMsg().equals(employeeInfoExlVo.getEducation())){
            employeeInfo.setEducation(EmployeeInfoExlVoEnum.EM_EDUCATION_GAOZHONG.getCode());
        }else if(EmployeeInfoExlVoEnum.EM_EDUCATION_DAZHUAN.getMsg().equals(employeeInfoExlVo.getEducation())){
            employeeInfo.setEducation(EmployeeInfoExlVoEnum.EM_EDUCATION_DAZHUAN.getCode());
        }else if(EmployeeInfoExlVoEnum.EM_EDUCATION_BENKE.getMsg().equals(employeeInfoExlVo.getEducation())){
            employeeInfo.setEducation(EmployeeInfoExlVoEnum.EM_EDUCATION_BENKE.getCode());
        }else if(EmployeeInfoExlVoEnum.EM_EDUCATION_SUOSHI.getMsg().equals(employeeInfoExlVo.getEducation())){
            employeeInfo.setEducation(EmployeeInfoExlVoEnum.EM_EDUCATION_SUOSHI.getCode());
        }else if(EmployeeInfoExlVoEnum.EM_EDUCATION_BOSHI.getMsg().equals(employeeInfoExlVo.getEducation())){
            employeeInfo.setEducation(EmployeeInfoExlVoEnum.EM_EDUCATION_BOSHI.getCode());
        }else if(EmployeeInfoExlVoEnum.EM_EDUCATION_ZHONGZHUAN.getMsg().equals(employeeInfoExlVo.getEducation())){
            employeeInfo.setEducation(EmployeeInfoExlVoEnum.EM_EDUCATION_ZHONGZHUAN.getCode());
        }

        if(EmployeeConstants.EM_EDUCATION_Y.equals(employeeInfoExlVo.getLetterCommitment())){
            employeeInfo.setLetterCommitment(EmployeeConstants.EM_LETTERCOMMITMENT_Y);
        }else if(EmployeeConstants.EM_EDUCATION_N.equals(employeeInfoExlVo.getLetterCommitment())){
            employeeInfo.setLetterCommitment(EmployeeConstants.EM_LETTERCOMMITMENT_N);
        }

        if(EmployeeConstants.EM_EDUCATION_Y.equals(employeeInfoExlVo.getConfidentialityAgreement())){
            employeeInfo.setLetterCommitment(EmployeeConstants.EM_LETTERCOMMITMENT_Y);
        }else if(EmployeeConstants.EM_EDUCATION_N.equals(employeeInfoExlVo.getConfidentialityAgreement())){
            employeeInfo.setLetterCommitment(EmployeeConstants.EM_LETTERCOMMITMENT_Y);
        }

        if(EmployeeConstants.EM_JOB_STS_ZZ.equals(employeeInfoExlVo.getJobStatus())){
            employeeInfo.setJobStatus(EmployeeConstants.EM_JOB_STS_Z);
        }else if(EmployeeConstants.EM_JOB_STS_CJ.equals(employeeInfoExlVo.getJobStatus())){
            employeeInfo.setJobStatus(EmployeeConstants.EM_JOB_STS_C);
        }else if(EmployeeConstants.EM_JOB_STS_NJ.equals(employeeInfoExlVo.getJobStatus())){
            employeeInfo.setJobStatus(EmployeeConstants.EM_JOB_STS_N);
        }else if(EmployeeConstants.EM_JOB_STS_SJ.equals(employeeInfoExlVo.getJobStatus())){
            employeeInfo.setJobStatus(EmployeeConstants.EM_JOB_STS_S);
        }else if(EmployeeConstants.EM_JOB_STS_BJ.equals(employeeInfoExlVo.getJobStatus())){
            employeeInfo.setJobStatus(EmployeeConstants.EM_JOB_STS_B);
        }else if(EmployeeConstants.EM_JOB_STS_LZ.equals(employeeInfoExlVo.getJobStatus())){
            employeeInfo.setJobStatus(EmployeeConstants.EM_JOB_STS_L);
        }

        employeeInfo.setNationality(employeeInfoExlVo.getNationality());
        employeeInfo.setLengthService(employeeInfoExlVo.getLengthService());
        employeeInfo.setAge(employeeInfoExlVo.getAge());
        employeeInfo.setNativePlace(employeeInfoExlVo.getNativePlace());
        employeeInfo.setIdCard(employeeInfoExlVo.getIdCard());
        employeeInfo.setBirthday(employeeInfoExlVo.getBirthday());
        employeeInfo.setHomePlace(employeeInfoExlVo.getHomePlace());
        employeeInfo.setAddress(employeeInfoExlVo.getAddress());
        employeeInfo.setMailingAddress(employeeInfoExlVo.getMailingAddress());
        employeeInfo.setGraduateSchool(employeeInfoExlVo.getGraduateSchool());
        employeeInfo.setSpecialty(employeeInfoExlVo.getSpecialty());
        employeeInfo.setGraduationDate(employeeInfoExlVo.getGraduationDate());
        employeeInfo.setProfessional(employeeInfoExlVo.getProfessional());
        employeeInfo.setNote(employeeInfoExlVo.getNote());
        employeeInfo.setDimissionDate(employeeInfoExlVo.getDimissionDate());
        employeeInfo.setLeaveReason(employeeInfoExlVo.getLeaveReason());
        employeeInfo.setReasonDec(employeeInfoExlVo.getReasonDec());
        employeeInfo.setSkills(employeeInfoExlVo.getSkills());
        employeeInfo.setContractEffective(employeeInfoExlVo.getContractEffective());
        employeeInfo.setContractExpiration(employeeInfoExlVo.getContractExpiration());
        employeeInfo.setMobileNumber(employeeInfoExlVo.getMobileNumber());
        employeeInfo.setEmail(employeeInfoExlVo.getEmail());
        employeeInfo.setJoinDate(employeeInfoExlVo.getJoinDate());
        employeeInfo.setStatus(Constants.STATUS_OK);
        employeeInfo.setUpdateBy(SecurityUtils.getUsername());
        employeeInfo.setUpdateTime(DateUtils.getNowDate());
    }
}
