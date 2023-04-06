package com.jotime.web.service.base.impl;

import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.web.domain.base.BaseWarehouseLocation;
import com.jotime.web.domainVo.base.BaseWarehouseLocationVo;
import com.jotime.web.mapper.base.BaseItemMapper;
import com.jotime.web.mapper.base.BaseWarehouseLocationMapper;
import com.jotime.web.service.base.IBaseWarehouseLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 库位列Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-16
 */
@Service
public class BaseWarehouseLocationServiceImpl implements IBaseWarehouseLocationService
{
    @Autowired
    private BaseWarehouseLocationMapper baseWarehouseLocationMapper;
    @Autowired
    private BaseItemMapper baseItemMapper;
    /**
     * 查询库位列
     *
     * @param id 库位列主键
     * @return 库位列
     */
    @Override
    public BaseWarehouseLocation selectBaseWarehouseLocationById(Long id)
    {
        return baseWarehouseLocationMapper.selectBaseWarehouseLocationById(id);
    }

    /**
     * 查询库位列列表
     *
     * @param baseWarehouseLocation 库位列
     * @return 库位列
     */
    @Override
    public List<BaseWarehouseLocation> selectBaseWarehouseLocationList(BaseWarehouseLocation baseWarehouseLocation)
    {
        return baseWarehouseLocationMapper.selectBaseWarehouseLocationList(baseWarehouseLocation);
    }
    @Override
    public List<BaseWarehouseLocationVo> selectBaseWarehouseLocationVoList(BaseWarehouseLocation baseWarehouseLocation)
    {
        return baseWarehouseLocationMapper.selectBaseWarehouseLocationVoList(baseWarehouseLocation);
    }

    /**
     * 新增库位列
     *
     * @param baseWarehouseLocation 库位列
     * @return 结果
     */
    @Override
    public AjaxResult insertBaseWarehouseLocation(BaseWarehouseLocation baseWarehouseLocation)
    {

        //        拷贝编码
        BaseWarehouseLocation baseWarehouseLocation1 = new BaseWarehouseLocation();
        baseWarehouseLocation1.setLocationCode(baseWarehouseLocation.getLocationCode());
//        根据编码查询是否有返回数据
        List<BaseWarehouseLocation> baseWarehouseLocations = baseWarehouseLocationMapper.selectBaseWarehouseLocationList(baseWarehouseLocation1);
        if (baseWarehouseLocations.size()>0){
//            添加失败，编码已存在
            return AjaxResult.error("添加失败！该库区编码已存在！");
        }
        baseWarehouseLocation.setCreateBy(SecurityUtils.getUsername());
        baseWarehouseLocation.setCreateTime(DateUtils.getNowDate());
        return AjaxResult.success(baseWarehouseLocationMapper.insertBaseWarehouseLocation(baseWarehouseLocation));
    }

    /**
     * 修改库位列
     *
     * @param baseWarehouseLocation 库位列
     * @return 结果
     */
    @Override
    public AjaxResult updateBaseWarehouseLocation(BaseWarehouseLocation baseWarehouseLocation)
    {
//        拷贝编码
        BaseWarehouseLocation baseWarehouseLocation1 = new BaseWarehouseLocation();
        baseWarehouseLocation1.setLocationCode(baseWarehouseLocation.getLocationCode());
//        根据编码查询是否有返回数据
        List<BaseWarehouseLocation> baseWarehouseLocations = baseWarehouseLocationMapper.selectBaseWarehouseLocationList(baseWarehouseLocation1);
//        判断查询出的数据是不是要修改的那条数据
        if (baseWarehouseLocations.size()>0&&!baseWarehouseLocation.getId().equals(baseWarehouseLocations.get(0).getId())){
//            修改失败，编码已存在
            return AjaxResult.error("修改失败！该库区编码已存在！");
        }
        baseWarehouseLocation.setUpdateBy(SecurityUtils.getUsername());
        baseWarehouseLocation.setUpdateTime(DateUtils.getNowDate());
        return AjaxResult.success(baseWarehouseLocationMapper.updateBaseWarehouseLocation(baseWarehouseLocation));
    }

    /**
     * 批量删除库位列
     *
     * @param ids 需要删除的库位列主键
     * @return 结果
     */
    @Override
    public int deleteBaseWarehouseLocationByIds(Long[] ids)
    {
        return baseWarehouseLocationMapper.deleteBaseWarehouseLocationByIds(ids);
    }

    /**
     * 删除库位列信息
     *
     * @param id 库位列主键
     * @return 结果
     */
    @Override
    public int deleteBaseWarehouseLocationById(Long id)
    {
        return baseWarehouseLocationMapper.deleteBaseWarehouseLocationById(id);
    }

    /**
     * 根据库位编码查询库位
     *
     * @param locationCode 库位编码
     * @return 库位
     */
    @Override
    public BaseWarehouseLocation selectBaseWarehouseLocationBylc(String locationCode)
    {
        return baseWarehouseLocationMapper.selectBaseWarehouseLocationBylc(locationCode);
    }

    @Override
    public BaseWarehouseLocation selectBaseWarehouseLocationByView(String locationNoView) {
        return baseWarehouseLocationMapper.selectBaseWarehouseLocationByView(locationNoView);
    }

    @Override
    public List<BaseWarehouseLocation> selectByArea(String areaId) {
        return baseWarehouseLocationMapper.selectByArea(areaId);
    }

    /**
     * 查询库位列
     *
     * @param baseWarehouseLocation 库位列主键
     * @return 库位列
     */
    @Override
    public List<BaseWarehouseLocation> selectByAreaType(BaseWarehouseLocation baseWarehouseLocation) {
        return baseWarehouseLocationMapper.selectByAreaType(baseWarehouseLocation);
    }

    @Override
    public AjaxResult updateBaseWarehouse(BaseWarehouseLocation baseWarehouseLocation)
    {
         baseWarehouseLocationMapper.updateBaseWarehouse(baseWarehouseLocation);
         return AjaxResult.success("改仓库库区成功");
    }
}
