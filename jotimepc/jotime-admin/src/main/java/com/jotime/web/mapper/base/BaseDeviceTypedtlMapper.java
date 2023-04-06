package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BaseDeviceTypedtl;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 设备类型详细Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-02
 */
public interface BaseDeviceTypedtlMapper
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
     * 删除设备类型详细
     *
     * @param id 设备类型详细主键
     * @return 结果
     */
    public int deleteBaseDeviceTypedtlById(Integer id);

    /**
     * 批量删除设备类型详细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseDeviceTypedtlByIds(Integer[] ids);

    /**
     * 查询要插入的对应设备类型的typeValue是否已有数据
     * @param deviceType 设备类型
     * @param typeValue 值
     * @return
     */
    @Select("SELECT count(d.id) from base_device_typedtl d,base_device_type t " +
            "where t.device_type=d.device_type and t.device_type = #{deviceType}\n" +
            "AND d.type_value = #{typeValue}")
    public int selectTypeValueWhetherRepetition(@Param("deviceType")String deviceType,@Param("typeValue") String typeValue);

    /**
     * 查询要插入的对应设备类型的typeValue是否已有数据
     * @param deviceType 设备类型
     * @param typeLabel 值
     * @return
     */
    @Select("SELECT count(d.id) from base_device_typedtl d,base_device_type t " +
            "where t.device_type=d.device_type and t.device_type = #{deviceType}\n" +
            "AND d.type_label = #{typeLabel}")
    public int selectTypeValues(@Param("deviceType")String deviceType,@Param("typeLabel") String typeLabel);

    /**
     * 查询设备类型是否已有数据
     * @param deviceType 设备类型
     * @return
     */
    @Select("SELECT count(*) from base_device_typedtl t where t.device_type = #{deviceType}")
    public int selectTypeValueByDeviceType(String deviceType);

    /**
     * 设备类型详细
     */
    public BaseDeviceTypedtl deleteBaseDeviceTypedtlByTypeAndValue(BaseDeviceTypedtl baseDeviceTypedtl);
}
