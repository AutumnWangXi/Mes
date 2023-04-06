package com.jotime.web.service.base;

import com.jotime.web.domain.base.BaseDeviceTypedtl;

import java.util.List;

/**
 * 设备类型详细Service接口
 *
 * @author ruoyi
 * @date 2022-03-02
 */
public interface IBaseDeviceTypedtlService
{
    /**
     * 查询设备类型详细
     *
     * @param id 设备类型详细主键
     * @return 设备类型详细
     */
    public BaseDeviceTypedtl selectBaseDeviceTypedtlById(Integer id);

    /**
     * 查询设备类型详细列表
     *
     * @param baseDeviceTypedtl 设备类型详细
     * @return 设备类型详细集合
     */
    public List<BaseDeviceTypedtl> selectBaseDeviceTypedtlList(BaseDeviceTypedtl baseDeviceTypedtl);

    /**
     * 新增设备类型详细
     *
     * @param baseDeviceTypedtl 设备类型详细
     * @return 结果
     */
    public int insertBaseDeviceTypedtl(BaseDeviceTypedtl baseDeviceTypedtl);

    /**
     * 修改设备类型详细
     *
     * @param baseDeviceTypedtl 设备类型详细
     * @return 结果
     */
    public int updateBaseDeviceTypedtl(BaseDeviceTypedtl baseDeviceTypedtl);

    /**
     * 批量删除设备类型详细
     *
     * @param ids 需要删除的设备类型详细主键集合
     * @return 结果
     */
    public int deleteBaseDeviceTypedtlByIds(Integer[] ids);

    /**
     * 删除设备类型详细信息
     *
     * @param id 设备类型详细主键
     * @return 结果
     */
    public int deleteBaseDeviceTypedtlById(Integer id);
    /**
     * 查询设备大分类对应的可用设备详细列表
     *
     * @param deviceType 设备类型
     * @return 设备大分类对应的可用设备详细列表
     */
    public List<BaseDeviceTypedtl> selectBaseDeviceTypedtlDetailedListList(String deviceType);

}
