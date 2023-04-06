package com.jotime.web.service.base.impl;


import com.jotime.common.utils.DateUtils;
import com.jotime.web.domain.base.BaseDevicePortconnLog;
import com.jotime.web.mapper.base.BaseDevicePortconnLogMapper;
import com.jotime.web.service.base.IBaseDevicePortconnLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 设备端口连接日志Service业务层处理
 *
 * @author yunmoqian
 * @date 2022-11-25
 */
@Service
public class BaseDevicePortconnLogServiceImpl implements IBaseDevicePortconnLogService
{
    @Autowired
    private BaseDevicePortconnLogMapper baseDevicePortconnLogMapper;

    /**
     * 查询设备端口连接日志
     *
     * @param id 设备端口连接日志主键
     * @return 设备端口连接日志
     */
    @Override
    public BaseDevicePortconnLog selectBaseDevicePortconnLogById(Long id)
    {
        return baseDevicePortconnLogMapper.selectBaseDevicePortconnLogById(id);
    }

    /**
     * 查询设备端口连接日志列表
     *
     * @param baseDevicePortconnLog 设备端口连接日志
     * @return 设备端口连接日志
     */
    @Override
    public List<BaseDevicePortconnLog> selectBaseDevicePortconnLogList(BaseDevicePortconnLog baseDevicePortconnLog)
    {
        return baseDevicePortconnLogMapper.selectBaseDevicePortconnLogList(baseDevicePortconnLog);
    }

    /**
     * 新增设备端口连接日志
     *
     * @param baseDevicePortconnLog 设备端口连接日志
     * @return 结果
     */
    @Override
    public int insertBaseDevicePortconnLog(BaseDevicePortconnLog baseDevicePortconnLog)
    {
        baseDevicePortconnLog.setCreateTime(DateUtils.getNowDate());
        return baseDevicePortconnLogMapper.insertBaseDevicePortconnLog(baseDevicePortconnLog);
    }

    /**
     * 修改设备端口连接日志
     *
     * @param baseDevicePortconnLog 设备端口连接日志
     * @return 结果
     */
    @Override
    public int updateBaseDevicePortconnLog(BaseDevicePortconnLog baseDevicePortconnLog)
    {
        baseDevicePortconnLog.setUpdateTime(DateUtils.getNowDate());
        return baseDevicePortconnLogMapper.updateBaseDevicePortconnLog(baseDevicePortconnLog);
    }

    /**
     * 批量删除设备端口连接日志
     *
     * @param ids 需要删除的设备端口连接日志主键
     * @return 结果
     */
    @Override
    public int deleteBaseDevicePortconnLogByIds(Long[] ids)
    {
        return baseDevicePortconnLogMapper.deleteBaseDevicePortconnLogByIds(ids);
    }

    /**
     * 删除设备端口连接日志信息
     *
     * @param id 设备端口连接日志主键
     * @return 结果
     */
    @Override
    public int deleteBaseDevicePortconnLogById(Long id)
    {
        return baseDevicePortconnLogMapper.deleteBaseDevicePortconnLogById(id);
    }
}
