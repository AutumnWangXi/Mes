package com.jotime.web.mapper.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.web.domain.base.BaseDevicePp;
import com.jotime.web.domain.base.BaseWarehouse;
import com.jotime.web.domainVo.base.BaseDevicePpVo;

import java.util.List;

/**
 * 设备工艺参数Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-17
 */
public interface BaseDevicePpMapper extends BaseMapper<BaseDevicePp>
{
    /**
     * 查询设备工艺参数
     *
     * @param id 设备工艺参数主键
     * @return 设备工艺参数
     */
    public BaseDevicePp selectBaseDevicePpById(Long id);

    /**
     * 查询设备工艺参数列表
     *
     * @param baseDevicePp 设备工艺参数
     * @return 设备工艺参数集合
     */
    public List<BaseDevicePp> selectBaseDevicePpList(BaseDevicePp baseDevicePp);
    /**
     * 查询设备工艺参数列表
     *
     * @param baseDevicePp 设备工艺参数
     * @return 设备工艺参数集合
     */
    public List<BaseDevicePpVo> selectBaseDevicePpVoList(BaseDevicePp baseDevicePp);

    /**
     * 新增设备工艺参数
     *
     * @param baseDevicePp 设备工艺参数
     * @return 结果
     */
    public int insertBaseDevicePp(BaseDevicePp baseDevicePp);

    /**
     * 修改设备工艺参数
     *
     * @param baseDevicePp 设备工艺参数
     * @return 结果
     */
    public int updateBaseDevicePp(BaseDevicePp baseDevicePp);

    /**
     * 删除设备工艺参数
     *
     * @param id 设备工艺参数主键
     * @return 结果
     */
    public int deleteBaseDevicePpById(Long id);

    /**
     * 批量删除设备工艺参数
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseDevicePpByIds(Long[] ids);
}
