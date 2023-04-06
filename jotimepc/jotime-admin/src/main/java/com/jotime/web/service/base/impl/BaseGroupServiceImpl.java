package com.jotime.web.service.base.impl;

import com.jotime.common.constant.CodeRuleConstants;
import com.jotime.common.constant.Constants;
import com.jotime.common.constant.RdConstants;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.domain.R;
import com.jotime.common.core.domain.entity.SysDept;
import com.jotime.common.core.domain.entity.SysUser;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.common.utils.joTime.ApplyStatus;
import com.jotime.system.mapper.SysUserMapper;
import com.jotime.system.service.ISysDeptService;
import com.jotime.web.domain.base.BaseGroup;
import com.jotime.web.domain.base.BaseGroupuser;
import com.jotime.web.domain.base.BaseWorkshop;
import com.jotime.web.domain.employee.EmployeeInfo;
import com.jotime.web.domainVo.base.BaseGroupVo;
import com.jotime.web.domainVo.base.BaseGroupuserVo;
import com.jotime.web.mapper.base.BaseGroupMapper;
import com.jotime.web.mapper.base.BaseWorkshopMapper;
import com.jotime.web.mapper.employee.EmployeeInfoMapper;
import com.jotime.web.service.base.IBaseGroupService;
import com.jotime.web.service.base.IBaseGroupuserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 班组Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-01
 */
@Service
public class BaseGroupServiceImpl implements IBaseGroupService {
    @Autowired
    private BaseGroupMapper baseGroupMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private BaseWorkshopMapper baseWorkshopMapper;
    @Autowired
    private IBaseGroupuserService iBaseGroupuserService;
    @Autowired
    private ISysDeptService iSysDeptService;
    @Autowired
    private EmployeeInfoMapper employeeInfoMapper;

    /**
     * 查询班组
     *
     * @param id 班组主键
     * @return 班组
     */
    @Override
    public BaseGroup selectBaseGroupById(Long id) {
        return baseGroupMapper.selectBaseGroupById(id);
    }

    @Override
    public BaseGroupVo selectBaseGroupVoById(Long id) {
        BaseGroup baseGroup = baseGroupMapper.selectBaseGroupById(id);
        BaseGroupVo baseGroupVo = new BaseGroupVo();
        BeanUtils.copyProperties(baseGroup, baseGroupVo);
        BaseGroupuser baseGroupuser = new BaseGroupuser();
        baseGroupuser.setGroupId(baseGroup.getId().toString());
        baseGroupVo.setBaseGroupusers(iBaseGroupuserService.selectBaseGroupuserVoList(baseGroupuser));
        return baseGroupVo;
    }

    /**
     * 查询班组列表
     *
     * @param baseGroup 班组
     * @return 班组
     */
    @Override
    public List<BaseGroupVo> selectBaseGroupList(BaseGroup baseGroup) {
        List<BaseGroupVo> baseGroupVos = baseGroupMapper.selectBaseGroupVoList(baseGroup);
        baseGroupVos.forEach(baseGroupVo -> {
            //获取负责人姓名
            EmployeeInfo employeeInfo = employeeInfoMapper.selectEmployeeInfoById(baseGroupVo.getGroupLeaderId());
            if (StringUtils.isNotNull(employeeInfo)){
                baseGroupVo.setGroupLeaderName(employeeInfo.getEmployeeName());
            }
            //获取车间名称
            BaseWorkshop baseWorkshop = baseWorkshopMapper.selectBaseWorkshopById(baseGroupVo.getWorkshopId());
            String workshopName;
            if (StringUtils.isNull(baseWorkshop)) {
                workshopName = "";
            } else {
                workshopName = baseWorkshop.getWorkshopName();
            }
            Long deptId = baseGroupVo.getDeptId();
            SysDept sysDept = iSysDeptService.selectDeptById(deptId);
            if (sysDept != null && sysDept.getDeptName() != null) {
                baseGroupVo.setDeptName(sysDept.getDeptName());
            }
//            获取班组人员详细信息
            BaseGroupuser baseGroupuser = new BaseGroupuser();
            baseGroupuser.setGroupId(baseGroupVo.getId().toString());
            List<BaseGroupuserVo> baseGroupuserVos = iBaseGroupuserService.selectBaseGroupuserVoList(baseGroupuser);
            baseGroupVo.setBaseGroupusers(baseGroupuserVos);
            baseGroupVo.setWorkshopName(workshopName);
        });
        return baseGroupVos;
    }

    /**
     * 新增班组
     *
     * @param baseGroup 班组
     * @return 结果
     */
    @Override
    public int insertBaseGroup(BaseGroup baseGroup) {
        baseGroup.setStatus(2);
        BaseGroup baseGroup1 = new BaseGroup();
        baseGroup1.setGroupCode(baseGroup.getGroupCode());
        List<BaseGroup> baseGroups = baseGroupMapper.selectBaseGroupList(baseGroup1);
        if (baseGroups.size()>0){
            return -1;
        }
        return baseGroupMapper.insertBaseGroup(baseGroup);
    }

    /**
     * 修改班组
     *
     * @param baseGroup 班组
     * @return 结果
     */
    @Override
    public int updateBaseGroup(BaseGroup baseGroup) {
        baseGroup.setUpdateTime(DateUtils.getNowDate());
        return baseGroupMapper.updateBaseGroup(baseGroup);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateBaseGroupVo(BaseGroupVo baseGroupVo) {
        int row = 0;

        //获取班组成员列表
        List<BaseGroupuserVo> baseGroupuserVos = baseGroupVo.getBaseGroupusers();
        BaseGroup baseGroup = new BaseGroup();
        baseGroup.setId(baseGroupVo.getId());
        baseGroup.setGroupCode(baseGroupVo.getGroupCode());
        baseGroup.setGroupName(baseGroupVo.getGroupName());
        baseGroup.setGroupLeaderId(baseGroupVo.getGroupLeaderId());
        baseGroup.setWorkshopId(baseGroupVo.getWorkshopId());
        baseGroup.setDeptId(baseGroupVo.getDeptId());
        baseGroup.setStatus(baseGroupVo.getStatus());
        baseGroup.setNote(baseGroupVo.getNote());
        baseGroup.setCreateBy(baseGroupVo.getCreateBy());
        baseGroup.setCreateTime(baseGroupVo.getCreateTime());
        baseGroup.setUpdateBy(SecurityUtils.getUserId().toString());
        baseGroup.setUpdateTime(DateUtils.getNowDate());
        //更新班组信息
        baseGroupMapper.updateBaseGroup(baseGroup);

        BaseGroupuser baseGroupuser = new BaseGroupuser();
        baseGroupuser.setGroupId(baseGroupVo.getId().toString());
//        老班组人员数据集合
        List<BaseGroupuser> baseGroupusers = iBaseGroupuserService.selectBaseGroupuserList(baseGroupuser);
        List<Integer> idsOld = new ArrayList<>();
        List<Integer> idsNew = new ArrayList<>();
        baseGroupusers.forEach(groupuserVo -> {
            idsOld.add(groupuserVo.getId());
        });
//        新班组人员数据集合
        baseGroupuserVos.forEach(groupuserVo -> {
            idsNew.add(groupuserVo.getId());
        });
//
        for (int i = 0; i < idsOld.size(); i++) {
//            判断这个老数据的id在新数据中是否有，如果没有，就是被删除了
            if (!idsNew.contains(idsOld.get(i))) {
                row+=iBaseGroupuserService.deleteBaseGroupuserById(Integer.valueOf(String.valueOf(idsOld.get(i))));
            }
        }
        for (int i = 0; i < idsNew.size(); i++) {
            baseGroupuser.setWorkshopId(String.valueOf(baseGroupVo.getWorkshopId()));
            baseGroupuser.setGroupCode(baseGroupVo.getGroupCode());
            baseGroupuser.setStatus(baseGroupuserVos.get(i).getStatus());
            baseGroupuser.setUserId(baseGroupuserVos.get(i).getUserId());
            baseGroupuser.setNote(baseGroupuserVos.get(i).getNote());
//                要添加的新数据
            if (!idsOld.contains(idsNew.get(i))) {
                baseGroupuser.setUpdateBy(null);
                baseGroupuser.setUpdateTime(null);
                baseGroupuser.setId(null);
                baseGroupuser.setCreateBy(SecurityUtils.getUserId().toString());
                baseGroupuser.setCreateTime(DateUtils.getNowDate());
                row=iBaseGroupuserService.insertBaseGroupuser(baseGroupuser);
            }else if (idsOld.contains(idsNew.get(i))){
//                要更新的数据
                baseGroupuser.setId(baseGroupuserVos.get(i).getId());
                baseGroupuser.setCreateTime(baseGroupuserVos.get(i).getCreateTime());
                baseGroupuser.setCreateBy(baseGroupuserVos.get(i).getCreateBy());
                baseGroupuser.setUpdateBy(SecurityUtils.getUserId().toString());
                baseGroupuser.setUpdateTime(DateUtils.getNowDate());
                row=iBaseGroupuserService.updateBaseGroupuser(baseGroupuser);
            }
        }
        if (row==-1){
            throw new RuntimeException("组员已经在工作中！");
        }
        return row;


    }

    /**
     * 批量删除班组
     *
     * @param ids 需要删除的班组主键
     * @return 结果
     */
    @Override
    public int deleteBaseGroupByIds(Long[] ids) {
        for (int i = 0; i < ids.length; i++) {
            deleteBaseGroupById(ids[i]);
        }
        return 1;
    }

    /**
     * 删除班组信息
     *
     * @param id 班组主键
     * @return 结果
     */
    @Override
    public int deleteBaseGroupById(Long id) {
        BaseGroup baseGroup = baseGroupMapper.selectBaseGroupById(id);
        baseGroup.setStatus(1);
        return baseGroupMapper.updateBaseGroup(baseGroup);
    }

    /**
     * 获取车间对应班组列表
     */
    @Override
    public List<BaseGroup> getWorkGroupList(Long workShopId) {
        BaseGroup baseGroup = new BaseGroup();
        if (workShopId != 0) {
            baseGroup.setWorkshopId(workShopId);
        }
        baseGroup.setStatus(CodeRuleConstants.STATUS_OK);
        return baseGroupMapper.selectBaseGroupList(baseGroup);
    }

    //    查询该班组生产订单的班组的负责人
    @Override
    public EmployeeInfo selectGroupleader(String gpOrdertaskNo) {
        return baseGroupMapper.selectGroupleader(gpOrdertaskNo);
    }

    @Override
    public BaseGroup selectBaseGroupuserBygroupName(String groupName) {
        return baseGroupMapper.selectBaseGroupuserBygroupName(groupName);
    }

    @Override
    public AjaxResult selectDeptGroup(String depttaskNo, Long deptId) {
        // 获取本部门的班组信息
        BaseGroup baseGroup = new BaseGroup();
        baseGroup.setDeptId(deptId);
        List<BaseGroupVo> groupList = baseGroupMapper.selectBaseGroupVoList(baseGroup);
        if (StringUtils.isEmpty(groupList)) {
            return AjaxResult.error(ApplyStatus.STATUS_404, "未查询到本部门班组");
        }
        return AjaxResult.success().put("formulationData", groupList);
    }
}
