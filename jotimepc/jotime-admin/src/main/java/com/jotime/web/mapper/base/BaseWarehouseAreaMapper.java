package com.jotime.web.mapper.base;

import java.util.List;
import com.jotime.web.domain.base.BaseWarehouseArea;
import com.jotime.web.domainVo.base.BaseWarehouseAreaVo;

/**
 * 库区列Mapper接口
 *
 * @author ruoyi
 * @date 2022-01-16
 */
public interface BaseWarehouseAreaMapper
{
    /**
     * 查询库区列
     *
     * @param id 库区列主键
     * @return 库区列
     */
    public BaseWarehouseArea selectBaseWarehouseAreaById(Long id);

    /**
     * 查询库区列列表
     *
     * @param baseWarehouseArea 库区列
     * @return 库区列集合
     */
    public List<BaseWarehouseArea> selectBaseWarehouseAreaList(BaseWarehouseArea baseWarehouseArea);
    public List<BaseWarehouseAreaVo> selectBaseWarehouseAreaVoList(BaseWarehouseArea baseWarehouseArea);
    /**
     * 新增库区列
     *
     * @param baseWarehouseArea 库区列
     * @return 结果
     */
    public int insertBaseWarehouseArea(BaseWarehouseArea baseWarehouseArea);

    /**
     * 修改库区列
     *
     * @param baseWarehouseArea 库区列
     * @return 结果
     */
    public int updateBaseWarehouseArea(BaseWarehouseArea baseWarehouseArea);

    /**
     * 删除库区列
     *
     * @param id 库区列主键
     * @return 结果
     */
    public int deleteBaseWarehouseAreaById(Long id);

    /**
     * 批量删除库区列
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseWarehouseAreaByIds(Long[] ids);
}
