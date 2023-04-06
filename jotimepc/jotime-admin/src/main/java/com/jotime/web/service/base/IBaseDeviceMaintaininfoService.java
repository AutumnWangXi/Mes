package com.jotime.web.service.base;

import java.util.List;
import com.jotime.web.domain.base.BaseDeviceMaintaininfo;
import com.jotime.web.domain.base.BaseDeviceMaintaininfo;

/**
 * 设备保养信息Service接口
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
public interface IBaseDeviceMaintaininfoService 
{
    /**
     * 查询设备保养信息
     * 
     * @param baseDeviceMaintaininfo 设备保养信息主键
     * @return 设备保养信息
     */
    public BaseDeviceMaintaininfo selectBaseDeviceMaintaininfoByBaseDeviceMaintaininfo(Long baseDeviceMaintaininfo);

    /**
     * 查询设备保养信息列表
     * 
     * @param baseDeviceMaintaininfo 设备保养信息
     * @return 设备保养信息集合
     */
    public List<BaseDeviceMaintaininfo> selectBaseDeviceMaintaininfoList(BaseDeviceMaintaininfo baseDeviceMaintaininfo);

    /**
     * 新增设备保养信息
     * 
     * @param baseDeviceMaintaininfo 设备保养信息
     * @return 结果
     */
    public int insertBaseDeviceMaintaininfo(BaseDeviceMaintaininfo baseDeviceMaintaininfo);

    /**
     * 修改设备保养信息
     * 
     * @param baseDeviceMaintaininfo 设备保养信息
     * @return 结果
     */
    public int updateBaseDeviceMaintaininfo(BaseDeviceMaintaininfo baseDeviceMaintaininfo);

    /**
     * 批量删除设备保养信息
     * 
     * @param baseDeviceMaintaininfos 需要删除的设备保养信息主键集合
     * @return 结果
     */
    public int deleteBaseDeviceMaintaininfoByBaseDeviceMaintaininfos(Long[] baseDeviceMaintaininfos);

    /**
     * 删除设备保养信息信息
     * 
     * @param baseDeviceMaintaininfo 设备保养信息主键
     * @return 结果
     */
    public int deleteBaseDeviceMaintaininfoByBaseDeviceMaintaininfo(Long baseDeviceMaintaininfo);
}
