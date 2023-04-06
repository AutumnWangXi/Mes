package com.jotime.web.service.base;

import com.jotime.web.domain.base.BaseItemNetcontent;

import java.util.List;

/**
 * 描述：成品净含量Service接口
 *
 * @author yunmoqian
 * @date 2022-05-07
 */
public interface IBaseItemNetcontentService
{
    /**
     * 查询描述：成品净含量
     *
     * @param id 描述：成品净含量主键
     * @return 描述：成品净含量
     */
    public BaseItemNetcontent selectBaseItemNetcontentById(Long id);

    /**
     * 查询描述：成品净含量列表
     *
     * @param baseItemNetcontent 描述：成品净含量
     * @return 描述：成品净含量集合
     */
    public List<BaseItemNetcontent> selectBaseItemNetcontentList(BaseItemNetcontent baseItemNetcontent);

    /**
     * 根据物料编号查询计算依据
     *
     * @param itemId 物料ID
     * @param innerItemId 套装内物料编号
     * @param bomNo bom编号
     * @param version 版本号
     * @return 描述：成品净含量集合
     */
    public BaseItemNetcontent selectBaseItemNetcontentData(Long itemId, Long innerItemId,String bomNo,String version);

    /**
     * 新增描述：成品净含量
     *
     * @param baseItemNetcontent 描述：成品净含量
     * @return 结果
     */
    public int insertBaseItemNetcontent(BaseItemNetcontent baseItemNetcontent);

    /**
     * 修改描述：成品净含量
     *
     * @param baseItemNetcontent 描述：成品净含量
     * @return 结果
     */
    public int updateBaseItemNetcontent(BaseItemNetcontent baseItemNetcontent);

    /**
     * 批量删除描述：成品净含量
     *
     * @param ids 需要删除的描述：成品净含量主键集合
     * @return 结果
     */
    public int deleteBaseItemNetcontentByIds(Long[] ids);

    /**
     * 删除描述：成品净含量信息
     *
     * @param id 描述：成品净含量主键
     * @return 结果
     */
    public int deleteBaseItemNetcontentById(Long id);
}
