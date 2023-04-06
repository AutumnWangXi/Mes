package com.jotime.web.service.base;

import com.jotime.web.domain.base.BaseDevicePpdtl;
import com.jotime.web.domainVo.base.BaseDevicePpdtlVo;

import java.util.List;

/**
 * 设备工艺参数Service接口
 *
 * @author ruoyi
 * @date 2022-03-17
 */
public interface IBaseDevicePpdtlService
{
    /**
     * 查询设备工艺参数
     *
     * @param id 设备工艺参数主键
     * @return 设备工艺参数
     */
    public BaseDevicePpdtl selectBaseDevicePpdtlById(Long id);

    /**
     * 查询设备工艺参数列表
     *
     * @param baseDevicePpdtl 设备工艺参数
     * @return 设备工艺参数集合
     */
    public List<BaseDevicePpdtl> selectBaseDevicePpdtlList(BaseDevicePpdtl baseDevicePpdtl);
    /**
     * 查询设备工艺参数列表
     *
     * @param baseDevicePpdtl 设备工艺参数
     * @return 设备工艺参数集合
     */
    public List<BaseDevicePpdtlVo> selectBaseDevicePpdtlVoList(BaseDevicePpdtl baseDevicePpdtl);

    /**
     * 新增设备工艺参数
     *
     * @param baseDevicePpdtl 设备工艺参数
     * @return 结果
     */
    public int insertBaseDevicePpdtl(BaseDevicePpdtl baseDevicePpdtl);

    /**
     * 修改设备工艺参数
     *
     * @param baseDevicePpdtl 设备工艺参数
     * @return 结果
     */
    public int updateBaseDevicePpdtl(BaseDevicePpdtl baseDevicePpdtl);

    /**
     * 批量删除设备工艺参数
     *
     * @param ids 需要删除的设备工艺参数主键集合
     * @return 结果
     */
    public int deleteBaseDevicePpdtlByIds(Long[] ids);

    /**
     * 删除设备工艺参数信息
     *
     * @param id 设备工艺参数主键
     * @return 结果
     */
    public int deleteBaseDevicePpdtlById(Long id);
}
