package com.jotime.web.service.base;

import com.jotime.common.core.domain.AjaxResult;
import com.jotime.web.domain.base.BaseTurnoverBox;

import java.util.List;


/**
 * 周转箱Service接口
 *
 * @author ruoyi
 * @date 2022-01-13
 */
public interface IBaseTurnoverBoxService
{
    /**
     * 查询周转箱
     *
     * @param id 周转箱主键
     * @return 周转箱
     */
    public BaseTurnoverBox selectBaseTurnoverBoxById(Long id);

    /**
     * 查询周转箱列表
     *
     * @param baseTurnoverBox 周转箱
     * @return 周转箱集合
     */
    public List<BaseTurnoverBox> selectBaseTurnoverBoxList(BaseTurnoverBox baseTurnoverBox);

    /**
     * 新增周转箱
     *
     * @param baseTurnoverBox 周转箱
     * @return 结果
     */
    public AjaxResult insertBaseTurnoverBox(BaseTurnoverBox baseTurnoverBox);

    /**
     * 修改周转箱
     *
     * @param baseTurnoverBox 周转箱
     * @return 结果
     */
    public AjaxResult updateBaseTurnoverBox(BaseTurnoverBox baseTurnoverBox);

    /**
     * 批量删除周转箱
     *
     * @param ids 需要删除的周转箱主键集合
     * @return 结果
     */
    public int deleteBaseTurnoverBoxByIds(Long[] ids);

    /**
     * 删除周转箱信息
     *
     * @param id 周转箱主键
     * @return 结果
     */
    public int deleteBaseTurnoverBoxById(Long id);

    /**
     * 查询周转箱
     *
     * @param barCode 周转箱条形码
     * @return 周转箱
     */
    public BaseTurnoverBox selectBaseTurnoverBoxByBarCode(String barCode);

    /**
     * 模糊查询周转箱
     *
     * @param baseTurnoverBox 周转箱条形码
     * @return 周转箱
     */
    AjaxResult selectBaseTurnoverBoxListBox(BaseTurnoverBox baseTurnoverBox);
}
