package com.jotime.web.service.base.impl;

import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.base.BaseDeviceMaintaininfo;
import com.jotime.web.domainVo.employee.EmployeeInfoVo;
import com.jotime.web.mapper.base.BaseDeviceMaintaininfoMapper;
import com.jotime.web.service.base.IBaseDeviceMaintaininfoService;
import com.jotime.web.service.employee.IEmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 设备保养信息Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-30
 */
@Service
public class BaseDeviceMaintaininfoServiceImpl implements IBaseDeviceMaintaininfoService
{
    @Autowired
    private BaseDeviceMaintaininfoMapper baseDeviceMaintaininfoMapper;
    @Autowired
    private IEmployeeInfoService iEmployeeInfoService;
    /**
     * 查询设备保养信息
     *
     * @param id 设备保养信息主键
     * @return 设备保养信息
     */
    @Override
    public BaseDeviceMaintaininfo selectBaseDeviceMaintaininfoByBaseDeviceMaintaininfo(Long id)
    {
        return baseDeviceMaintaininfoMapper.selectBaseDeviceMaintaininfoById(id);
    }

    /**
     * 查询设备保养信息列表
     *
     * @param baseDeviceMaintaininfo 设备保养信息
     * @return 设备保养信息
     */
    @Override
    public List<BaseDeviceMaintaininfo> selectBaseDeviceMaintaininfoList(BaseDeviceMaintaininfo baseDeviceMaintaininfo)
    {
        return baseDeviceMaintaininfoMapper.selectBaseDeviceMaintaininfoList(baseDeviceMaintaininfo);
    }

    /**
     * 新增设备保养信息
     *
     * @param baseDeviceMaintaininfo 设备保养信息
     * @return 结果
     */
    @Override
    public int insertBaseDeviceMaintaininfo(BaseDeviceMaintaininfo baseDeviceMaintaininfo)
    {
//        判断是否公司员工，和暂存在保养人字段里的保养人id是否为空
        if (baseDeviceMaintaininfo.getIsEeInfo()==2&&baseDeviceMaintaininfo.getMaintenanceId()==null){
            EmployeeInfoVo employeeInfoVo = iEmployeeInfoService.selectEmployeeInfoById(Long.valueOf(baseDeviceMaintaininfo.getMaintainer()));
            if (StringUtils.isNotEmpty(employeeInfoVo.getEmployeeName())){
                baseDeviceMaintaininfo.setMaintenanceId(Long.valueOf(baseDeviceMaintaininfo.getMaintainer()));
                baseDeviceMaintaininfo.setMaintainer(employeeInfoVo.getEmployeeName());
            }
        }else {
            baseDeviceMaintaininfo.setMaintenanceId(0l);
        }
        baseDeviceMaintaininfo.setCreateTime(DateUtils.getNowDate());
        return baseDeviceMaintaininfoMapper.insertBaseDeviceMaintaininfo(baseDeviceMaintaininfo);
    }
    /**
     * 修改设备保养信息
     *
     * @param baseDeviceMaintaininfo 设备保养信息
     * @return 结果
     */
    @Override
    public int updateBaseDeviceMaintaininfo(BaseDeviceMaintaininfo baseDeviceMaintaininfo)
    {
//                判断是否公司员工，和暂存在保养人字段里的保养人id是否为空
        if (baseDeviceMaintaininfo.getIsEeInfo()==2&&baseDeviceMaintaininfo.getMaintenanceId()==null&&baseDeviceMaintaininfo.getMaintainer()!=null){
            EmployeeInfoVo employeeInfoVo = iEmployeeInfoService.selectEmployeeInfoById(Long.valueOf(baseDeviceMaintaininfo.getMaintainer()));
            if (StringUtils.isNotEmpty(employeeInfoVo.getEmployeeName())){
                baseDeviceMaintaininfo.setMaintenanceId(Long.valueOf(baseDeviceMaintaininfo.getMaintainer()));
                baseDeviceMaintaininfo.setMaintainer(employeeInfoVo.getEmployeeName());
            }
        }else {
            baseDeviceMaintaininfo.setMaintenanceId(0l);
        }
        return baseDeviceMaintaininfoMapper.updateBaseDeviceMaintaininfo(baseDeviceMaintaininfo);
    }

    /**
     * 批量删除设备保养信息
     *
     * @param baseDeviceMaintaininfos 需要删除的设备保养信息主键
     * @return 结果
     */
    @Override
    public int deleteBaseDeviceMaintaininfoByBaseDeviceMaintaininfos(Long[] baseDeviceMaintaininfos)
    {
        return baseDeviceMaintaininfoMapper.deleteBaseDeviceMaintaininfoByBaseDeviceMaintaininfos(baseDeviceMaintaininfos);
    }

    /**
     * 删除设备保养信息信息
     *
     * @param baseDeviceMaintaininfo 设备保养信息主键
     * @return 结果
     */
    @Override
    public int deleteBaseDeviceMaintaininfoByBaseDeviceMaintaininfo(Long baseDeviceMaintaininfo)
    {
        return baseDeviceMaintaininfoMapper.deleteBaseDeviceMaintaininfoByBaseDeviceMaintaininfo(baseDeviceMaintaininfo);
    }
}
