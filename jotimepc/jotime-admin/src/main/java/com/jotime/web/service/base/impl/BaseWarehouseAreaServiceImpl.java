package com.jotime.web.service.base.impl;

import java.util.List;

import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.web.domainVo.base.BaseWarehouseAreaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jotime.web.mapper.base.BaseWarehouseAreaMapper;
import com.jotime.web.domain.base.BaseWarehouseArea;
import com.jotime.web.service.base.IBaseWarehouseAreaService;

/**
 * 库区列Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-16
 */
@Service
public class BaseWarehouseAreaServiceImpl implements IBaseWarehouseAreaService
{
    @Autowired
    private BaseWarehouseAreaMapper baseWarehouseAreaMapper;

    /**
     * 查询库区列
     *
     * @param id 库区列主键
     * @return 库区列
     */
    @Override
    public BaseWarehouseArea selectBaseWarehouseAreaById(Long id)
    {
        return baseWarehouseAreaMapper.selectBaseWarehouseAreaById(id);
    }

    /**
     * 查询库区列列表
     *
     * @param baseWarehouseArea 库区列
     * @return 库区列
     */
    @Override
    public List<BaseWarehouseArea> selectBaseWarehouseAreaList(BaseWarehouseArea baseWarehouseArea)
    {
        return baseWarehouseAreaMapper.selectBaseWarehouseAreaList(baseWarehouseArea);
    }
//    页面展示列表
    @Override
    public List<BaseWarehouseAreaVo> selectBaseWarehouseAreaVoList(BaseWarehouseArea baseWarehouseArea) {
        return baseWarehouseAreaMapper.selectBaseWarehouseAreaVoList(baseWarehouseArea);
    }
    /**
     * 新增库区列
     *
     * @param baseWarehouseArea 库区列
     * @return 结果
     */
    @Override
    public AjaxResult insertBaseWarehouseArea(BaseWarehouseArea baseWarehouseArea)
    {
        BaseWarehouseArea baseWarehouseArea1 = new BaseWarehouseArea();
        baseWarehouseArea1.setAreaCode(baseWarehouseArea.getAreaCode());
        List<BaseWarehouseArea> baseWarehouseAreas = baseWarehouseAreaMapper.selectBaseWarehouseAreaList(baseWarehouseArea1);
        if (baseWarehouseAreas.size()==0){
            baseWarehouseArea.setCreateBy(SecurityUtils.getUsername());
            baseWarehouseArea.setCreateTime(DateUtils.getNowDate());
            return AjaxResult.success(baseWarehouseAreaMapper.insertBaseWarehouseArea(baseWarehouseArea));
        }
        return AjaxResult.error("插入失败！该库区编码已存在！");
    }

    /**
     * 修改库区列
     *
     * @param baseWarehouseArea 库区列
     * @return 结果
     */
    @Override
    public AjaxResult updateBaseWarehouseArea(BaseWarehouseArea baseWarehouseArea)
    {
//        拷贝编码
        BaseWarehouseArea baseWarehouseArea1 = new BaseWarehouseArea();
        baseWarehouseArea1.setAreaCode(baseWarehouseArea.getAreaCode());
//        根据编码查询是否有返回数据
        List<BaseWarehouseArea> baseWarehouseAreas = baseWarehouseAreaMapper.selectBaseWarehouseAreaList(baseWarehouseArea1);
//        判断查询出的数据是不是要修改的那条数据
        if (baseWarehouseAreas.size()>0&&!baseWarehouseArea.getId().equals(baseWarehouseAreas.get(0).getId())){
//            修改失败，编码已存在
            return AjaxResult.error("修改失败！该库区编码已存在！");
        }
        baseWarehouseArea.setCreateBy(SecurityUtils.getUsername());
        baseWarehouseArea.setCreateTime(DateUtils.getNowDate());
        return AjaxResult.success(baseWarehouseAreaMapper.updateBaseWarehouseArea(baseWarehouseArea));
    }

    /**
     * 批量删除库区列
     *
     * @param ids 需要删除的库区列主键
     * @return 结果
     */
    @Override
    public int deleteBaseWarehouseAreaByIds(Long[] ids)
    {
        return baseWarehouseAreaMapper.deleteBaseWarehouseAreaByIds(ids);
    }

    /**
     * 删除库区列信息
     *
     * @param id 库区列主键
     * @return 结果
     */
    @Override
    public int deleteBaseWarehouseAreaById(Long id)
    {
        return baseWarehouseAreaMapper.deleteBaseWarehouseAreaById(id);
    }

    /**
     * 查询库区列表
     *
     * @param warehouseId 仓库列主键
     * @return 结果
     */
    @Override
    public AjaxResult selectBaseWarehouseAreaByWarehouseId(Long warehouseId) {
        BaseWarehouseArea baseWarehouseArea = new BaseWarehouseArea();
        baseWarehouseArea.setWhId(warehouseId);
        baseWarehouseArea.setStatus("2");
        List<BaseWarehouseArea> baseWarehouseAreas = baseWarehouseAreaMapper.selectBaseWarehouseAreaList(baseWarehouseArea);
        return AjaxResult.success().put("areaOptions",baseWarehouseAreas);
    }
}
