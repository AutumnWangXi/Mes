package com.jotime.web.service.base.impl;

import com.jotime.common.constant.ApvlStatusConstants;
import com.jotime.common.constant.Constants;
import com.jotime.common.constant.PdConstants;
import com.jotime.common.core.domain.entity.SysRole;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.joTime.CommonUtil;
import com.jotime.system.mapper.SysRoleMapper;
import com.jotime.system.mapper.SysUserPostMapper;
import com.jotime.system.mapper.SysUserRoleMapper;
import com.jotime.web.domain.base.BaseWorkshop;
import com.jotime.web.domainVo.base.BaseWorkshopVo;
import com.jotime.web.mapper.base.BaseWorkshopMapper;
import com.jotime.web.service.base.IBaseWorkshopService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 车间Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-31
 */
@Service
public class BaseWorkshopServiceImpl implements IBaseWorkshopService
{
    @Autowired
    private BaseWorkshopMapper baseWorkshopMapper;
    @Autowired
    private SysUserRoleMapper userRoleMapper;
    @Autowired
    private SysUserPostMapper userPostMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 查询车间
     *
     * @param id 车间主键
     * @return 车间
     */
    @Override
    public BaseWorkshop selectBaseWorkshopById(Long id)
    {
        BaseWorkshop baseWorkshop = baseWorkshopMapper.selectBaseWorkshopById(id);
        List<String> idList = new ArrayList<>();
        if (StringUtils.isNotBlank(baseWorkshop.getRoleId())) {
            idList = Arrays.asList(baseWorkshop.getRoleId().split(","));
        }

        List<Long> cdids = idList.stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        List<SysRole> SysRoles=new ArrayList<>();
        cdids.forEach(item->{
            SysRole sysRole = sysRoleMapper.selectRoleById(item);
            SysRoles.add(sysRole);
        });
        baseWorkshop.setRoles(SysRoles);
        baseWorkshop.setCdids(cdids);
        return baseWorkshop;
    }

    /**
     * 查询车间列表
     *
     * @param baseWorkshop 车间
     * @return 车间
     */
    @Override
    public List<BaseWorkshop> selectBaseWorkshopList(BaseWorkshop baseWorkshop)

    {
        List<BaseWorkshop> baseWorkshops = baseWorkshopMapper.selectBaseWorkshopList(baseWorkshop);
        return baseWorkshops;
    }
    @Override
    public List<BaseWorkshopVo> selectBaseWorkshopVoList(BaseWorkshop baseWorkshop)
    {
        List<BaseWorkshopVo> baseWorkshops = baseWorkshopMapper.selectBaseWorkshopVoList(baseWorkshop);
        return baseWorkshops;
    }

    /**
     * 新增车间
     *
     * @param baseWorkshop 车间
     * @return 结果
     */
    @Override
    public int insertBaseWorkshop(BaseWorkshop baseWorkshop)
    {
        baseWorkshop.setCreateBy(SecurityUtils.getUsername());
        BaseWorkshop baseWorkshop1 = new BaseWorkshop();
        baseWorkshop1.setWorkshopCode(baseWorkshop.getWorkshopCode());
        baseWorkshop.setRoleId(StringUtils.join(baseWorkshop.getRoleIds(), Constants.DASH_COMMA));
        List<BaseWorkshop> baseWorkshops = baseWorkshopMapper.selectBaseWorkshopList(baseWorkshop1);
        if (baseWorkshops.size() == 0) {
            return baseWorkshopMapper.insertBaseWorkshop(baseWorkshop);
        }
        return 0;
    }

    /**
     * 修改车间
     *
     * @param baseWorkshop 车间
     * @return 结果
     */
    @Override
    public int updateBaseWorkshop(BaseWorkshop baseWorkshop)
    {
        baseWorkshop.setUpdateBy(SecurityUtils.getUsername());
        BaseWorkshop baseWorkshop1 = new BaseWorkshop();
        baseWorkshop1.setWorkshopCode(baseWorkshop.getWorkshopCode());
        List<BaseWorkshop> baseWorkshops = baseWorkshopMapper.selectBaseWorkshopList(baseWorkshop1);
        if (baseWorkshops.size() > 0 && !baseWorkshop.getId().equals(baseWorkshops.get(0).getId())) {
            return 0;
        }
        baseWorkshop.setRoleId(StringUtils.join(baseWorkshop.getRoleIds(), Constants.DASH_COMMA));
        return baseWorkshopMapper.updateBaseWorkshop(baseWorkshop);
    }

    /**
     * 批量删除车间
     *
     * @param ids 需要删除的车间主键
     * @return 结果
     */
    @Override
    public int deleteBaseWorkshopByIds(Long[] ids)
    {
        return baseWorkshopMapper.deleteBaseWorkshopByIds(ids);
    }

    /**
     * 删除车间信息
     *
     * @param id 车间主键
     * @return 结果
     */
    @Override
    public int deleteBaseWorkshopById(Long id)
    {
        return baseWorkshopMapper.deleteBaseWorkshopById(id);
    }

    @Override
    public List<BaseWorkshop> selectAllByDeptId(String deptId) {
        return baseWorkshopMapper.selectAllByDeptId(deptId);
    }


    /**
     * 查询车间
     *
     * @param id 车间主键
     * @return 车间
     */
    @Override
    public BaseWorkshopVo selectBaseWorkshopByIdData(Long id) {
        return baseWorkshopMapper.selectBaseWorkshopByIdData(id);
    }
}
