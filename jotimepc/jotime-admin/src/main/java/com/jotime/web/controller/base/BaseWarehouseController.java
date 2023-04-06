package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.constant.StockConstants;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseWarehouse;
import com.jotime.web.service.base.IBaseWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 仓库列Controller
 *
 * @author ruoyi
 * @date 2022-01-16
 */
@RestController
@RequestMapping("/web/base/warehouse")
public class BaseWarehouseController extends BaseController {
    @Autowired
    private IBaseWarehouseService baseWarehouseService;

    /**
     * 查询仓库列列表
     */
    @PreAuthorize("@ss.hasPermi('admin:warehouse:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseWarehouse baseWarehouse) {
        startPage();
        List<BaseWarehouse> list = baseWarehouseService.selectBaseWarehouseList(baseWarehouse);
        return getDataTable(list);
    }

    /**
     * 查询仓库列列表
     */
    @PreAuthorize("@ss.hasPermi('admin:warehouse:lists')")
    @GetMapping("/lists")
    public TableDataInfo lists(BaseWarehouse baseWarehouse) {
        startPage();
        //启动状态
        baseWarehouse.setStatus(StockConstants.DATA_TYPE_NOSTOP);
        List<BaseWarehouse> list = baseWarehouseService.selectBaseWarehouseList(baseWarehouse);
        return getDataTable(list);
    }

    /**
     * 导出仓库列列表
     */
    @PreAuthorize("@ss.hasPermi('admin:warehouse:export')")
    @Log(title = "仓库列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseWarehouse baseWarehouse) {
        List<BaseWarehouse> list = baseWarehouseService.selectBaseWarehouseList(baseWarehouse);
        ExcelUtil<BaseWarehouse> util = new ExcelUtil<BaseWarehouse>(BaseWarehouse.class);
        util.exportExcel(response, list, "仓库列数据");
    }

    /**
     * 获取仓库列详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:warehouse:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(baseWarehouseService.selectBaseWarehouseById(id));
    }

    /**
     * 新增仓库列
     */
    @PreAuthorize("@ss.hasPermi('admin:warehouse:add')")
    @Log(title = "仓库列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseWarehouse baseWarehouse) {
            //添加影响的条数
        int i = baseWarehouseService.insertBaseWarehouse(baseWarehouse);
        return i > 0 ? toAjax(i) : AjaxResult.error("添加失败！编码已存在！");
    }

    /**
     * 修改仓库列
     */
    @PreAuthorize("@ss.hasPermi('admin:warehouse:edit')")
    @Log(title = "仓库列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseWarehouse baseWarehouse) {
//        修改影响的条数
        int i = baseWarehouseService.updateBaseWarehouse(baseWarehouse);
        return i > 0 ? toAjax(i) : AjaxResult.error("修改失败！编码已存在！");
    }

    /**
     * 删除仓库列
     */
    @PreAuthorize("@ss.hasPermi('admin:warehouse:remove')")
    @Log(title = "仓库列", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(baseWarehouseService.deleteBaseWarehouseByIds(ids));
    }

    /**
     * 获取仓库列表
     */
//    @PreAuthorize("@ss.hasPermi('admin:warehouse:query')")
    @GetMapping(value = "/getWarehouseList")
    public AjaxResult getWarehouseList() {
        return AjaxResult.success().put("warehouseOptions", baseWarehouseService.selectBaseWarehouseList(null));
    }

}
