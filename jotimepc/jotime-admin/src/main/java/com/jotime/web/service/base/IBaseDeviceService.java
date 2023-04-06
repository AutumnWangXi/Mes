package com.jotime.web.service.base;

import com.jotime.web.domain.base.BaseDevice;
import com.jotime.web.domainVo.base.BaseDeviceVos;
import com.jotime.web.domainVo.excel.BaseDeviceExlVo;

import java.util.List;

/**
 * 设备信息Service接口
 *
 * @author ruoyi
 * @date 2021-12-30
 */
public interface IBaseDeviceService {
    /**
     * 查询设备信息
     *
     * @param id 设备信息主键
     * @return 设备信息
     */
    public BaseDevice selectBaseDeviceById(Long id);

    /**
     * 查询设备信息列表
     *
     * @param baseDevice 设备信息
     * @return 设备信息集合
     */
    public List<BaseDevice> selectBaseDeviceList(BaseDevice baseDevice);

    /**
     * 查询设备信息列表
     *
     * @param baseDevice 设备信息
     * @return 设备信息集合
     */
    public List<BaseDeviceVos> selectBaseDeviceVoList(BaseDevice baseDevice);

    /**
     * 查询设备信息列表
     *
     * @param id 设备组id
     * @return 设备信息集合
     */
    public List<BaseDevice> selectGroupDevice(Long id);

    /**
     * 新增设备信息
     *
     * @param baseDevice 设备信息
     * @return 结果
     */
    public int insertBaseDevice(BaseDevice baseDevice);

    /**
     * 修改设备信息
     *
     * @param baseDevice 设备信息
     * @return 结果
     */
    public int updateBaseDevice(BaseDevice baseDevice);

    /**
     * 批量删除设备信息
     *
     * @param ids 需要删除的设备信息主键集合
     * @return 结果
     */
    public int deleteBaseDeviceByIds(Long[] ids);

    /**
     * 删除设备信息信息
     *
     * @param id 设备信息主键
     * @return 结果
     */
    public int deleteBaseDeviceById(Long id);

    List<BaseDevice> selectAllByLineCode(String lineCode);

    int importData(List<BaseDeviceExlVo> baseDeviceExlVos, boolean updateSupport);
}
