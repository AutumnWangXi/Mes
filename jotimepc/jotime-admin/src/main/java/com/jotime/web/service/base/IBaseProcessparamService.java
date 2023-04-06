package com.jotime.web.service.base;

import com.jotime.web.domain.base.BaseProcessparam;

import java.util.List;


/**
 * 设备工艺参数Service接口
 *
 * @author ruoyi
 * @date 2022-03-18
 */
public interface IBaseProcessparamService
{
    /**
     * 查询设备工艺参数
     *
     * @param id 设备工艺参数主键
     * @return 设备工艺参数
     */
    public BaseProcessparam selectBaseProcessparamById(Integer id);

    /**
     * 查询设备工艺参数列表
     *
     * @param baseProcessparam 设备工艺参数
     * @return 设备工艺参数集合
     */
    public List<BaseProcessparam> selectBaseProcessparamList(BaseProcessparam baseProcessparam);

    /**
     * 新增设备工艺参数
     *
     * @param baseProcessparam 设备工艺参数
     * @return 结果
     */
    public int insertBaseProcessparam(BaseProcessparam baseProcessparam);

    /**
     * 修改设备工艺参数
     *
     * @param baseProcessparam 设备工艺参数
     * @return 结果
     */
    public int updateBaseProcessparam(BaseProcessparam baseProcessparam);

    /**
     * 批量删除设备工艺参数
     *
     * @param ids 需要删除的设备工艺参数主键集合
     * @return 结果
     */
    public int deleteBaseProcessparamByIds(Integer[] ids);

    /**
     * 删除设备工艺参数信息
     *
     * @param id 设备工艺参数主键
     * @return 结果
     */
    public int deleteBaseProcessparamById(Integer id);
}
