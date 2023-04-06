package com.jotime.web.mapper.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jotime.web.domain.base.BaseItemNetcontent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：成品净含量Mapper接口
 *
 * @author yunmoqian
 * @date 2022-05-07
 */
public interface BaseItemNetcontentMapper extends BaseMapper<BaseItemNetcontent>
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
     * @return 描述：成品净含量集合
     */
    public BaseItemNetcontent selectBaseItemNetcontentData(@Param("itemId") Long itemId, @Param("innerItemId") Long innerItemId,@Param("bomNo") String bomNo, @Param("version") String version);

    /**
     * 根据物料编号查询计算依据
     *
     * @param itemId 物料ID
     * @return 描述：成品净含量集合
     */
    public BaseItemNetcontent selectBaseItemNetcontentDataByItemId(@Param("itemId") Long itemId,@Param("bomNo") String bomNo, @Param("version") String version);

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
     * 删除描述：成品净含量
     *
     * @param id 描述：成品净含量主键
     * @return 结果
     */
    public int deleteBaseItemNetcontentById(Long id);

    /**
     * 批量删除描述：成品净含量
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseItemNetcontentByIds(Long[] ids);

    int deleteBaseItemNetcontentByItemId(Long id);
}
