package com.jotime.web.service.base.impl;


import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.base.BaseDevicePort;
import com.jotime.web.mapper.base.BaseDevicePortMapper;
import com.jotime.web.service.base.IBaseDevicePortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 设备端口信息Service业务层处理
 *
 * @author yunmoqian
 * @date 2022-11-25
 */
@Service
public class BaseDevicePortServiceImpl implements IBaseDevicePortService
{
    @Autowired
    private BaseDevicePortMapper baseDevicePortMapper;

    /**
     * 查询设备端口信息
     *
     * @param id 设备端口信息主键
     * @return 设备端口信息
     */
    @Override
    public BaseDevicePort selectBaseDevicePortById(Long id)
    {
        return baseDevicePortMapper.selectBaseDevicePortById(id);
    }

    /**
     * 查询设备端口信息列表
     *
     * @param baseDevicePort 设备端口信息
     * @return 设备端口信息
     */
    @Override
    public List<BaseDevicePort> selectBaseDevicePortList(BaseDevicePort baseDevicePort)
    {
        return baseDevicePortMapper.selectBaseDevicePortList(baseDevicePort);
    }

    /**
     * 新增设备端口信息
     *
     * @param baseDevicePort 设备端口信息
     * @return 结果
     */
    @Override
    public int insertBaseDevicePort(BaseDevicePort baseDevicePort)
    {
        //根据设备编号查询
        BaseDevicePort queryBaseDevicePort = new BaseDevicePort();
        queryBaseDevicePort.setDeviceCode(baseDevicePort.getDeviceCode());
        List<BaseDevicePort> baseDevicePorts = baseDevicePortMapper.selectBaseDevicePortList(queryBaseDevicePort);
        if(StringUtils.isNotEmpty(baseDevicePorts)){
            return -1;
        }
        baseDevicePort.setStatus(2);
        baseDevicePort.setCreateTime(DateUtils.getNowDate());
        baseDevicePort.setCreateBy(SecurityUtils.getNickName());
        return baseDevicePortMapper.insertBaseDevicePort(baseDevicePort);
    }

    /**
     * 修改设备端口信息
     *
     * @param baseDevicePort 设备端口信息
     * @return 结果
     */
    @Override
    public int updateBaseDevicePort(BaseDevicePort baseDevicePort)
    {
        if(StringUtils.isNotEmpty(baseDevicePort.getDeviceCode())){
            //根据设备编号查询
            BaseDevicePort queryBaseDevicePort = new BaseDevicePort();
            queryBaseDevicePort.setDeviceCode(baseDevicePort.getDeviceCode());
            List<BaseDevicePort> baseDevicePorts = baseDevicePortMapper.selectBaseDevicePortList(queryBaseDevicePort);
            if(StringUtils.isNotEmpty(baseDevicePorts)){
                //过滤出不是当前修改的数据
                List<BaseDevicePort> collect = baseDevicePorts.stream().filter(e -> {
                    return e.getId() != baseDevicePort.getId();
                }).collect(Collectors.toList());
                if(StringUtils.isNotEmpty(collect)){
                    return -1;
                }
            }
        }
        baseDevicePort.setUpdateTime(DateUtils.getNowDate());
        baseDevicePort.setUpdateBy(SecurityUtils.getNickName());
        return baseDevicePortMapper.updateBaseDevicePort(baseDevicePort);
    }

    /**
     * 批量删除设备端口信息
     *
     * @param ids 需要删除的设备端口信息主键
     * @return 结果
     */
    @Override
    public int deleteBaseDevicePortByIds(Long[] ids)
    {
        return baseDevicePortMapper.deleteBaseDevicePortByIds(ids);
    }

    /**
     * 删除设备端口信息信息
     *
     * @param id 设备端口信息主键
     * @return 结果
     */
    @Override
    public int deleteBaseDevicePortById(Long id)
    {
        return baseDevicePortMapper.deleteBaseDevicePortById(id);
    }
}
