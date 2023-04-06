package com.jotime.web.service.base;

import com.jotime.common.core.domain.AjaxResult;
import com.jotime.web.domain.base.BaseWarehouseLocation;
import com.jotime.web.domainVo.base.BaseWarehouseLocationVo;

import java.util.List;

/**
 * 库位列Service接口
 *
 * @author ruoyi
 * @date 2022-01-16
 */
public interface IBaseWarehouseLocationService {
    /**
     * 查询库位列
     *
     * @param id 库位列主键
     * @return 库位列
     */
    public BaseWarehouseLocation selectBaseWarehouseLocationById(Long id);

    /**
     * 查询库位列列表
     *
     * @param baseWarehouseLocation 库位列
     * @return 库位列集合
     */
    public List<BaseWarehouseLocation> selectBaseWarehouseLocationList(BaseWarehouseLocation baseWarehouseLocation);

    //    页面展示
    public List<BaseWarehouseLocationVo> selectBaseWarehouseLocationVoList(BaseWarehouseLocation baseWarehouseLocation);

    /**
     * 新增库位列
     *
     * @param baseWarehouseLocation 库位列
     * @return 结果
     */
    public AjaxResult insertBaseWarehouseLocation(BaseWarehouseLocation baseWarehouseLocation);

    /**
     * 修改库位列
     *
     * @param baseWarehouseLocation 库位列
     * @return 结果
     */
    public AjaxResult updateBaseWarehouseLocation(BaseWarehouseLocation baseWarehouseLocation);

    /**
     * 批量删除库位列
     *
     * @param ids 需要删除的库位列主键集合
     * @return 结果
     */
    public int deleteBaseWarehouseLocationByIds(Long[] ids);

    /**
     * 删除库位列信息
     *
     * @param id 库位列主键
     * @return 结果
     */
    public int deleteBaseWarehouseLocationById(Long id);

    /**
     * 查询库位列
     *
     * @param locationCode 库位列主键
     * @return 库位列
     */
    public BaseWarehouseLocation selectBaseWarehouseLocationBylc(String locationCode);

    /**
     * 查询库位列
     *
     * @param locationNoView 库位列主键
     * @return 库位列
     */
    public BaseWarehouseLocation selectBaseWarehouseLocationByView(String locationNoView);

    List<BaseWarehouseLocation> selectByArea(String areaId);
    /**
     * 查询库位列
     *
     * @param baseWarehouseLocation 库位列主键
     * @return 库位列
     */
    List<BaseWarehouseLocation> selectByAreaType(BaseWarehouseLocation baseWarehouseLocation);

    AjaxResult updateBaseWarehouse(BaseWarehouseLocation baseWarehouseLocation);
}
