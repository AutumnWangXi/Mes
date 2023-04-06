package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.constant.Constants;
import com.jotime.common.constant.StockConstants;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.StringUtils;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseWarehouseLocation;
import com.jotime.web.domainVo.base.BaseWarehouseLocationVo;
import com.jotime.web.service.base.IBaseWarehouseAreaService;
import com.jotime.web.service.base.IBaseWarehouseLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 库位列Controller
 *
 * @author ruoyi
 * @date 2022-01-16
 */
@RestController
@RequestMapping("/web/base/location")
public class BaseWarehouseLocationController extends BaseController {
    @Autowired
    private IBaseWarehouseLocationService baseWarehouseLocationService;
    @Autowired
    private IBaseWarehouseAreaService baseWarehouseAreaService;

    /**
     * 查询库位列列表
     */
    @PreAuthorize("@ss.hasPermi('web:location:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseWarehouseLocation baseWarehouseLocation) {
        startPage();
        List<BaseWarehouseLocationVo> list = baseWarehouseLocationService.selectBaseWarehouseLocationVoList(baseWarehouseLocation);
        return getDataTable(list);
    }

    /**
     * 查询库位列列表
     */
//    @PreAuthorize("@ss.hasPermi('web:location:lists')")
    @GetMapping("/lists")
    public TableDataInfo lists(BaseWarehouseLocation baseWarehouseLocation) {
        startPage();
        //启动状态
        baseWarehouseLocation.setStatus(StockConstants.DATA_TYPE_NOSTOP);
        List<BaseWarehouseLocationVo> list = baseWarehouseLocationService.selectBaseWarehouseLocationVoList(baseWarehouseLocation);
        return getDataTable(list);
    }


    /**改变库位所在仓库库区
     * @Description
     * @param
     * @return
     * @auther by 14812
     */
    @PreAuthorize("@ss.hasPermi('web:location:editWarehouse')")
    @Log(title = "修改库位列表", businessType = BusinessType.UPDATE)
    @PutMapping("/editWarehouse")
    public AjaxResult editWarehouse(@RequestBody BaseWarehouseLocation baseWarehouseLocation) {
        return baseWarehouseLocationService.updateBaseWarehouse(baseWarehouseLocation);
    }


    /**
     * 查询库位列列表
     */
//    @PreAuthorize("@ss.hasPermi('web:location:lists')")
    @GetMapping("/listsByareaType")
    public TableDataInfo listsByareaType(BaseWarehouseLocation baseWarehouseLocation) {
        startPage();
        //启动状态
        baseWarehouseLocation.setStatus(StockConstants.DATA_TYPE_NOSTOP);
        baseWarehouseLocation.setAreaType(StockConstants.AREA_TYPE_QD);
        List<BaseWarehouseLocationVo> list = baseWarehouseLocationService.selectBaseWarehouseLocationVoList(baseWarehouseLocation);
        return getDataTable(list);
    }

    /**
     * 导出库位列列表
     */
    @PreAuthorize("@ss.hasPermi('web:location:export')")
    @Log(title = "库位列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseWarehouseLocation baseWarehouseLocation) {
        List<BaseWarehouseLocation> list = baseWarehouseLocationService.selectBaseWarehouseLocationList(baseWarehouseLocation);
        ExcelUtil<BaseWarehouseLocation> util = new ExcelUtil<BaseWarehouseLocation>(BaseWarehouseLocation.class);
        util.exportExcel(response, list, "库位列数据");
    }

    /**
     * 获取库位列详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:location:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        BaseWarehouseLocation baseWarehouseLocation = baseWarehouseLocationService.selectBaseWarehouseLocationById(id);
//        获取仓库对应库区
        return baseWarehouseLocation.getWhId() == null ? AjaxResult.success(baseWarehouseLocation) : baseWarehouseAreaService.selectBaseWarehouseAreaByWarehouseId(baseWarehouseLocation.getWhId()).put(AjaxResult.DATA_TAG, baseWarehouseLocation);
    }

    /**
     * 新增库位列
     */
    @PreAuthorize("@ss.hasPermi('web:location:add')")
    @Log(title = "库位列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseWarehouseLocation baseWarehouseLocation) {
        return baseWarehouseLocationService.insertBaseWarehouseLocation(baseWarehouseLocation);
    }

    /**
     * 修改库位列
     */
    @PreAuthorize("@ss.hasPermi('web:location:edit')")
    @Log(title = "库位列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseWarehouseLocation baseWarehouseLocation) {
        return baseWarehouseLocationService.updateBaseWarehouseLocation(baseWarehouseLocation);
    }

    /**
     * 删除库位列
     */
    @PreAuthorize("@ss.hasPermi('web:location:remove')")
    @Log(title = "库位列", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(baseWarehouseLocationService.deleteBaseWarehouseLocationByIds(ids));
    }

    /**
     * 查询库位列(通过仓库id)
     */
//    @PreAuthorize("@ss.hasPermi('web:location:selectByArea')")
    @GetMapping("/selectByArea/{areaId}")
    public AjaxResult selectByArea(@PathVariable("areaId") String areaId) {
        List<BaseWarehouseLocation> baseWarehouseLocations = baseWarehouseLocationService.selectByArea(areaId);
        return AjaxResult.success(baseWarehouseLocations);
    }

    /**
     * 查询库位列(通过库区类型)
     */
//    @PreAuthorize("@ss.hasPermi('web:location:selectByArea')")
    @GetMapping("/selectByAreaType/{areaType}/{areaId}")
    public AjaxResult selectByAreaType(@PathVariable("areaType") String areaType, @PathVariable("areaId") Long areaId) {
        BaseWarehouseLocation selLoction = new BaseWarehouseLocation();
        selLoction.setAreaType(areaType);
        selLoction.setStatus(Constants.STATUS_OK);
        if (StringUtils.isNotNull(areaId) && areaId.longValue() > 0L) {
            selLoction.setAreaId(areaId);
        }

        List<BaseWarehouseLocation> baseWarehouseLocations = baseWarehouseLocationService.selectByAreaType(selLoction);
        return AjaxResult.success(baseWarehouseLocations);
    }

}
