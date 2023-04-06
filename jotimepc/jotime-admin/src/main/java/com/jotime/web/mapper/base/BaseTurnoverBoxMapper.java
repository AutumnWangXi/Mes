package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BaseTurnoverBox;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 周转箱Mapper接口
 *
 * @author ruoyi
 * @date 2022-01-13
 */
public interface BaseTurnoverBoxMapper
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
     * 查询周转箱名称或者条形码是否唯一
     *
     * @param baseTurnoverBox 周转箱
     * @return 周转箱集合
     */
    public int selectBaseTurnoverBoxNameOrCodeUnique(BaseTurnoverBox baseTurnoverBox);
    /**
     * 新增周转箱
     *
     * @param baseTurnoverBox 周转箱
     * @return 结果
     */
    public int insertBaseTurnoverBox(BaseTurnoverBox baseTurnoverBox);

    /**
     * 修改周转箱
     *
     * @param baseTurnoverBox 周转箱
     * @return 结果
     */
    public int updateBaseTurnoverBox(BaseTurnoverBox baseTurnoverBox);

    /**
     * 删除周转箱
     *
     * @param id 周转箱主键
     * @return 结果
     */
    public int deleteBaseTurnoverBoxById(Long id);

    /**
     * 批量删除周转箱
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseTurnoverBoxByIds(Long[] ids);
    /**
     * 查询周转箱列表
     *
     * @param barCode 周转箱条形码
     * @return 周转箱集合
     */
    public BaseTurnoverBox selectBaseTurnoverBoxByBarCode(String barCode);
    /**
     * 查询周转箱列表
     *
     * @param boxNo 周转箱编码
     * @return 周转箱集合
     */
    public BaseTurnoverBox selectBaseTurnoverBoxByBoxNo(Long boxNo);

    /**
     * 模糊查询周转箱
     *
     * @param baseTurnoverBox 周转箱条形码
     * @return 周转箱
     */
    List<BaseTurnoverBox> selectBaseTurnoverBoxListBox(BaseTurnoverBox baseTurnoverBox);

    /**
     * 获取周转箱
     * @param ids
     * @return
     */
    List<BaseTurnoverBox> selectBaseTurnoverBoxByIds(@Param("ids") List<Long> ids);
}
