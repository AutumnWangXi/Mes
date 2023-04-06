package com.jotime.web.mapper.base;


import com.jotime.web.domain.base.BaseDevicePort;

import java.util.List;

/**
 * 设备端口信息Mapper接口
 *
 * @author yunmoqian
 * @date 2022-11-25
 */
public interface BaseDevicePortMapper
{
    /**
     * 查询设备端口信息
     *
     * @param id 设备端口信息主键
     * @return 设备端口信息
     */
    public BaseDevicePort selectBaseDevicePortById(Long id);

    /**
     * 查询设备端口信息列表
     *
     * @param baseDevicePort 设备端口信息
     * @return 设备端口信息集合
     */
    public List<BaseDevicePort> selectBaseDevicePortList(BaseDevicePort baseDevicePort);

    /**
     * 新增设备端口信息
     *
     * @param baseDevicePort 设备端口信息
     * @return 结果
     */
    public int insertBaseDevicePort(BaseDevicePort baseDevicePort);

    /**
     * 修改设备端口信息
     *
     * @param baseDevicePort 设备端口信息
     * @return 结果
     */
    public int updateBaseDevicePort(BaseDevicePort baseDevicePort);

    /**
     * 删除设备端口信息
     *
     * @param id 设备端口信息主键
     * @return 结果
     */
    public int deleteBaseDevicePortById(Long id);

    /**
     * 批量删除设备端口信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseDevicePortByIds(Long[] ids);
}
