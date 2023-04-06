package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BaseItemContent;

import java.util.List;


/**
 * 描述：物料含量Mapper接口
 *
 * @author yunmoqian
 * @date 2022-03-28
 */
public interface BaseItemContentMapper
{
    /**
     * 查询描述：物料含量
     *
     * @param id 描述：物料含量主键
     * @return 描述：物料含量
     */
    public BaseItemContent selectBaseItemContentById(Long id);

    /**
     * 查询描述：物料含量列表
     *
     * @param baseItemContent 描述：物料含量
     * @return 描述：物料含量集合
     */
    public List<BaseItemContent> selectBaseItemContentList(BaseItemContent baseItemContent);

    /**
     * 新增描述：物料含量
     *
     * @param baseItemContent 描述：物料含量
     * @return 结果
     */
    public int insertBaseItemContent(BaseItemContent baseItemContent);

    /**
     * 修改描述：物料含量
     *
     * @param baseItemContent 描述：物料含量
     * @return 结果
     */
    public int updateBaseItemContent(BaseItemContent baseItemContent);

    /**
     * 删除描述：物料含量
     *
     * @param id 描述：物料含量主键
     * @return 结果
     */
    public int deleteBaseItemContentById(Long id);

    /**
     * 批量删除描述：物料含量
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseItemContentByIds(Long[] ids);

    /**
     * 删除描述：物料含量
     *
     * @param itemId 描述：物料内码
     * @return 结果
     */
    public int deleteBaseItemContentByItemId(Long itemId);
}
