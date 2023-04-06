package com.jotime.web.service.base;

import java.util.List;

import com.jotime.common.core.domain.AjaxResult;
import com.jotime.web.domain.base.BaseWarehouseArea;
import com.jotime.web.domainVo.base.BaseWarehouseAreaVo;

/**
 * 库区列Service接口
 *
 * @author ruoyi
 * @date 2022-01-16
 */
public interface IBaseWarehouseAreaService
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
//    页面展示列表
    public List<BaseWarehouseAreaVo> selectBaseWarehouseAreaVoList(BaseWarehouseArea baseWarehouseArea);

    /**
     * 新增库区列
     *
     * @param baseWarehouseArea 库区列
     * @return 结果
     */
    public AjaxResult insertBaseWarehouseArea(BaseWarehouseArea baseWarehouseArea);

    /**
     * 修改库区列
     *
     * @param baseWarehouseArea 库区列
     * @return 结果
     */
    public AjaxResult updateBaseWarehouseArea(BaseWarehouseArea baseWarehouseArea);

    /**
     * 批量删除库区列
     *
     * @param ids 需要删除的库区列主键集合
     * @return 结果
     */
    public int deleteBaseWarehouseAreaByIds(Long[] ids);

    /**
     * 删除库区列信息
     *
     * @param id 库区列主键
     * @return 结果
     */
    public int deleteBaseWarehouseAreaById(Long id);

    /**
     * 查询库区列表
     *
     * @param warehouseId 仓库列主键
     * @return
     */
    public AjaxResult selectBaseWarehouseAreaByWarehouseId(Long warehouseId);

}
