package com.jotime.web.service.base;

import com.jotime.common.core.domain.AjaxResult;
import com.jotime.web.domain.base.BaseDeviceType;
import com.jotime.web.domainVo.excel.BaseDeviceTypeExlVo;

import java.util.List;

/**
 * 设备类型Service接口
 *
 * @author ruoyi
 * @date 2022-03-02
 */
public interface IBaseDeviceTypeService
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
     * 批量删除设备类型
     *
     * @param ids 需要删除的设备类型主键集合
     * @return 结果
     */
    public int deleteBaseDeviceTypeByIds(Long[] ids);

    /**
     * 禁用设备类型
     *
     * @param ids 需要禁用的设备类型主键集合
     * @return 结果
     */
    public int disableBaseDeviceTypeByIds(Long[] ids);
    /**
     * 删除设备类型信息
     *
     * @param id 设备类型主键
     * @return 结果
     */
    public int deleteBaseDeviceTypeById(Long id);
    /**
     * 查询可用设备类型列表
     * @return 可用设备类型列表
     */
    public List<BaseDeviceType> selectBaseDeviceTypeAvailableList();

    /**
     * @Description: 设备类型导入
     */
    AjaxResult importData(List<BaseDeviceTypeExlVo> baseDeviceTypeExlVos, boolean updateSupport);
}
