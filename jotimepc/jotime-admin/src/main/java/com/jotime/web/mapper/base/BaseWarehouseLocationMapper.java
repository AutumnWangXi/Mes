package com.jotime.web.mapper.base;

import com.jotime.web.domain.base.BaseWarehouseLocation;
import com.jotime.web.domainVo.base.BaseWarehouseLocationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 库位列Mapper接口
 *
 * @author ruoyi
 * @date 2022-01-16
 */
public interface BaseWarehouseLocationMapper
{
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
    public int insertBaseWarehouseLocation(BaseWarehouseLocation baseWarehouseLocation);

    /**
     * 修改库位列
     *
     * @param baseWarehouseLocation 库位列
     * @return 结果
     */
    public int updateBaseWarehouseLocation(BaseWarehouseLocation baseWarehouseLocation);

    /**
     * 删除库位列
     *
     * @param id 库位列主键
     * @return 结果
     */
    public int deleteBaseWarehouseLocationById(Long id);

    /**
     * 批量删除库位列
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseWarehouseLocationByIds(Long[] ids);

    /**
     * 根据库位展示名称查询对应库位信息
     *
     * @param baseWarehouseLocation 需要删除的数据主键集合
     * @return 结果
     */
    public List<BaseWarehouseLocation> selectLocationInfoByView(BaseWarehouseLocation baseWarehouseLocation);

    /**
     * 根据库位编码查询库位
     *
     * @param locationCode 库位编码
     * @return 库位
     */
    public BaseWarehouseLocation selectBaseWarehouseLocationBylc(String locationCode);

    /**
     * @return  List<BaseWarehouseLocation>
     * @author luoYang
     * 根据库区查询库位
     * @date 11:57 2022/3/3
     * @param areaId 库区id
     */
    List<BaseWarehouseLocation> selectByArea(String areaId);

    /**
     * @return  List<BaseWarehouseLocation>
     * @author luoYang
     * 根据库区查询库位
     * @date 11:57 2022/3/3
     * @param areaId 库区id
     */
    List<BaseWarehouseLocation> selectByAreaType(BaseWarehouseLocation baseWarehouseLocation);

    public BaseWarehouseLocation selectBaseWarehouseLocationByView(String locationNoView);

    /**
     * 根据库位展示名称查询对应库位信息
     *
     * @param baseWarehouseLocation 需要删除的数据主键集合
     * @return 结果
     */
    public List<BaseWarehouseLocation> selectLocationInfoByCode(BaseWarehouseLocation baseWarehouseLocation);


    /**
     * 根据locationCode 获取库位信息
     * @param locationCodeList
     * @return
     */
    List<BaseWarehouseLocation> selectBaseWarehouseLocationByLocationCodeS(@Param("locationCodeList") List<String> locationCodeList);

    void updateBaseWarehouse(BaseWarehouseLocation baseWarehouseLocation);
}
