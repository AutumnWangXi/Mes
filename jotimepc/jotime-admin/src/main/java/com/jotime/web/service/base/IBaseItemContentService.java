package com.jotime.web.service.base;

import com.jotime.web.domain.base.BaseItemContent;

import java.util.List;

/**
 * 描述：物料含量Service接口
 *
 * @author yunmoqian
 * @date 2022-03-28
 */
public interface IBaseItemContentService
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
     * 批量删除描述：物料含量
     *
     * @param ids 需要删除的描述：物料含量主键集合
     * @return 结果
     */
    public int deleteBaseItemContentByIds(Long[] ids);

    /**
     * 删除描述：物料含量信息
     *
     * @param id 描述：物料含量主键
     * @return 结果
     */
    public int deleteBaseItemContentById(Long id);

    /**
     * @Description: 更新物料对应含量信息
     * @param baseItemContents 物料含量信息
     * @param itemId 物料id
     * @Author: YunFei
     * @Date: 2022/3/29 10:53
     */
    public void updateBaseItemContentList(List<BaseItemContent> baseItemContents,Long itemId);

}
