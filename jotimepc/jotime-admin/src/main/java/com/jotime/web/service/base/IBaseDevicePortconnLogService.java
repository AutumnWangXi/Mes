package com.jotime.web.service.base;


import com.jotime.web.domain.base.BaseDevicePortconnLog;

import java.util.List;

/**
 * 设备端口连接日志Service接口
 *
 * @author yunmoqian
 * @date 2022-11-25
 */
public interface IBaseDevicePortconnLogService
{
    /**
     * 查询设备端口连接日志
     *
     * @param id 设备端口连接日志主键
     * @return 设备端口连接日志
     */
    public BaseDevicePortconnLog selectBaseDevicePortconnLogById(Long id);

    /**
     * 查询设备端口连接日志列表
     *
     * @param baseDevicePortconnLog 设备端口连接日志
     * @return 设备端口连接日志集合
     */
    public List<BaseDevicePortconnLog> selectBaseDevicePortconnLogList(BaseDevicePortconnLog baseDevicePortconnLog);

    /**
     * 新增设备端口连接日志
     *
     * @param baseDevicePortconnLog 设备端口连接日志
     * @return 结果
     */
    public int insertBaseDevicePortconnLog(BaseDevicePortconnLog baseDevicePortconnLog);

    /**
     * 修改设备端口连接日志
     *
     * @param baseDevicePortconnLog 设备端口连接日志
     * @return 结果
     */
    public int updateBaseDevicePortconnLog(BaseDevicePortconnLog baseDevicePortconnLog);

    /**
     * 批量删除设备端口连接日志
     *
     * @param ids 需要删除的设备端口连接日志主键集合
     * @return 结果
     */
    public int deleteBaseDevicePortconnLogByIds(Long[] ids);

    /**
     * 删除设备端口连接日志信息
     *
     * @param id 设备端口连接日志主键
     * @return 结果
     */
    public int deleteBaseDevicePortconnLogById(Long id);
}
