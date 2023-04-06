package com.jotime.web.service.base.impl;

import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.web.domain.base.BaseGroupuser;
import com.jotime.web.domainVo.base.BaseGroupuserVo;
import com.jotime.web.mapper.base.BaseGroupuserMapper;
import com.jotime.web.service.base.IBaseGroupService;
import com.jotime.web.service.base.IBaseGroupuserService;
import com.jotime.web.service.employee.IEmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 班组人员管理Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-01
 */
@Service
public class BaseGroupuserServiceImpl implements IBaseGroupuserService {
    @Autowired
    private BaseGroupuserMapper baseGroupuserMapper;
    @Autowired
    private IBaseGroupService iBaseGroupService;
    @Autowired
    public IEmployeeInfoService iEmployeeInfoService;
    @Autowired
    private IBaseGroupuserService iBaseGroupuserService;


    /**
     * 查询班组人员管理
     *
     * @param id 班组人员管理主键
     * @return 班组人员管理
     */
    @Override
    public BaseGroupuser selectBaseGroupuserById(Integer id) {
        return baseGroupuserMapper.selectBaseGroupuserById(id);
    }

    /**
     * 查询班组人员管理列表
     *
     * @param baseGroupuser 班组人员管理
     * @return 班组人员管理
     */
    @Override
    public List<BaseGroupuser> selectBaseGroupuserList(BaseGroupuser baseGroupuser) {
        return baseGroupuserMapper.selectBaseGroupuserList(baseGroupuser);
    }

    /**
     * 查询班组人员管理列表
     *
     * @param baseGroupuser 班组人员管理
     * @return 班组人员管理
     */
    @Override
    public List<BaseGroupuserVo> selectBaseGroupuserVoList(BaseGroupuser baseGroupuser) {
        return baseGroupuserMapper.selectBaseGroupuserVoList(baseGroupuser);
    }

    /**
     * 新增班组人员管理
     *
     * @param baseGroupuser 班组人员管理
     * @return 结果
     */
    @Override
    public int insertBaseGroupuser(BaseGroupuser baseGroupuser) {
//        判断是否在工作中
        BaseGroupuser baseGroupuser1 = new BaseGroupuser();
        baseGroupuser1.setUserId(baseGroupuser.getUserId());
        baseGroupuser1.setStatus(2);
        List<BaseGroupuser> baseGroupusers = baseGroupuserMapper.selectBaseGroupuserList(baseGroupuser1);
        if (baseGroupusers.size() > 0 && baseGroupuser.getStatus() != 1) {
            if (baseGroupusers.get(0).getUserId().equals(baseGroupuser.getUserId())) {
                return -1;
            }
        }
        baseGroupuser.setCreateBy(String.valueOf(SecurityUtils.getUserId()));
        baseGroupuser.setCreateTime(DateUtils.getNowDate());
        String groupCode = iBaseGroupService.selectBaseGroupById(Long.valueOf(baseGroupuser.getGroupId())).getGroupCode();
        baseGroupuser.setGroupCode(groupCode);
        return baseGroupuserMapper.insertBaseGroupuser(baseGroupuser);
    }

    /**
     * 修改班组人员管理
     *
     * @param baseGroupuser 班组人员管理
     * @return 结果
     */
    @Override
    public int updateBaseGroupuser(BaseGroupuser baseGroupuser) {
//                判断是否在工作中
        BaseGroupuser baseGroupuser1 = new BaseGroupuser();
        baseGroupuser1.setUserId(baseGroupuser.getUserId());
        baseGroupuser1.setStatus(2);
        List<BaseGroupuser> baseGroupusers = baseGroupuserMapper.selectBaseGroupuserList(baseGroupuser1);
        if (baseGroupusers.size() > 0 && baseGroupuser.getStatus() != 1) {
            if (!baseGroupuser.getId().equals(baseGroupusers.get(0).getId()) && !baseGroupuser.getUserId().equals(baseGroupusers.get(0).getUserId())) {
                return -1;
            }
        }
        baseGroupuser.setUpdateTime(DateUtils.getNowDate());
        baseGroupuser.setUpdateBy(String.valueOf(SecurityUtils.getUserId()));
        return baseGroupuserMapper.updateBaseGroupuser(baseGroupuser);
    }

    /**
     * 批量删除班组人员管理
     *
     * @param ids 需要删除的班组人员管理主键
     * @return 结果
     */
    @Override
    public int deleteBaseGroupuserByIds(Integer[] ids) {
        return baseGroupuserMapper.deleteBaseGroupuserByIds(ids);
    }

    /**
     * 删除班组人员管理信息
     *
     * @param id 班组人员管理主键
     * @return 结果
     */
    @Override
    public int deleteBaseGroupuserById(Integer id) {
        return baseGroupuserMapper.deleteBaseGroupuserById(id);
    }

    /**
     * 查询该班组下是否有该人员信息
     *
     * @param groupId 班组
     * @param getId   用户id
     * @return 结果
     */
    @Override
    public BaseGroupuser selelctByGroupId(Long groupId, Long getId) {
        return baseGroupuserMapper.selelctByGroupId(groupId, getId);
    }

    /**
     * 查询该班组下有几个员工
     *
     * @param groupId 班组
     * @param groupId 用户id
     * @return 结果
     */
    @Override
    public int selelctByGroupIds(Long groupId) {
        return baseGroupuserMapper.selelctByGroupIds(groupId);
    }

    /**
     * @Description 判断是否在别的班组工作
     * @auther by 14812
     */
    @Override
    public BaseGroupuserVo selelctByUserId(Long groupId, Long id) {
        return baseGroupuserMapper.selelctByUserId(groupId, id);
    }

    /**
     * @Description 修改班组人员状态
     * @auther by 14812
     */
    @Override
    public int updateBaseGroupuserByGroupId(Long groupId, Long id) {
        return baseGroupuserMapper.updateBaseGroupuserByGroupId(groupId, id);
    }
}
