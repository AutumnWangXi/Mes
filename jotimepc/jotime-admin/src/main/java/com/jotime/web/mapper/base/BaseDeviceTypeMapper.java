package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BaseDeviceType;

import java.util.List;

/**
 * 设备类型Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-02
 */
public interface BaseDeviceTypeMapper
{
    /**
     * 查询设备类型
     *
     * @param id 设备类型主键
     * @return 设备类型
     */
    public BaseDeviceType selectBaseDeviceTypeById(Long id);

    /**
     * 查询设备类型列表
     *
     * @param baseDeviceType 设备类型
     * @return 设备类型集合
     */
    public List<BaseDeviceType> selectBaseDeviceTypeList(BaseDeviceType baseDeviceType);

    /**
     * 新增设备类型
     *
     * @param baseDeviceType 设备类型
     * @return 结果
     */
    public int insertBaseDeviceType(BaseDeviceType baseDeviceType);

    /**
     * 修改设备类型
     *
     * @param baseDeviceType 设备类型
     * @return 结果
     */
    public int updateBaseDeviceType(BaseDeviceType baseDeviceType);

    /**
     * 删除设备类型
     *
     * @param id 设备类型主键
     * @return 结果
     */
    public int deleteBaseDeviceTypeById(Long id);

    /**
     * 批量删除设备类型
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseDeviceTypeByIds(Long[] ids);

    /**
     * 设备类型
     */
    public BaseDeviceType selectBaseDeviceTypeByDeviceType(String deviceType);
}
