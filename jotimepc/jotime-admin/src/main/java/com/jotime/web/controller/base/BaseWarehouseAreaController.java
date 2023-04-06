package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.common.utils.DateUtils;
import com.jotime.web.domainVo.base.BaseWarehouseAreaVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.enums.BusinessType;
import com.jotime.web.domain.base.BaseWarehouseArea;
import com.jotime.web.service.base.IBaseWarehouseAreaService;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.common.core.page.TableDataInfo;

/**
 * 库区列Controller
 *
 * @author ruoyi
 * @date 2022-01-16
 */
@RestController
@RequestMapping("/web/base/area")
public class BaseWarehouseAreaController extends BaseController
{
    @Autowired
    private IBaseWarehouseAreaService baseWarehouseAreaService;

    /**
     * 查询库区列列表
     */
    @PreAuthorize("@ss.hasPermi('admin:area:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseWarehouseArea baseWarehouseArea)
    {
        startPage();
        List<BaseWarehouseAreaVo> list = baseWarehouseAreaService.selectBaseWarehouseAreaVoList(baseWarehouseArea);
        return getDataTable(list);
    }

    /**
     * 导出库区列列表
     */
    @PreAuthorize("@ss.hasPermi('admin:area:export')")
    @Log(title = "库区列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseWarehouseArea baseWarehouseArea)
    {
        List<BaseWarehouseArea> list = baseWarehouseAreaService.selectBaseWarehouseAreaList(baseWarehouseArea);
        ExcelUtil<BaseWarehouseArea> util = new ExcelUtil<BaseWarehouseArea>(BaseWarehouseArea.class);
        util.exportExcel(response, list, "库区列数据");
    }

    /**
     * 获取库区列详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:area:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseWarehouseAreaService.selectBaseWarehouseAreaById(id));
    }

    /**
     * 新增库区列
     */
    @PreAuthorize("@ss.hasPermi('admin:area:add')")
    @Log(title = "库区列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseWarehouseArea baseWarehouseArea)
    {

        return baseWarehouseAreaService.insertBaseWarehouseArea(baseWarehouseArea);
    }

    /**
     * 修改库区列
     */
    @PreAuthorize("@ss.hasPermi('admin:area:edit')")
    @Log(title = "库区列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseWarehouseArea baseWarehouseArea)
    {
        return baseWarehouseAreaService.updateBaseWarehouseArea(baseWarehouseArea);
    }

    /**
     * 删除库区列
     */
    @PreAuthorize("@ss.hasPermi('admin:area:remove')")
    @Log(title = "库区列", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseWarehouseAreaService.deleteBaseWarehouseAreaByIds(ids));
    }
    /**
     * 获取库区列表
     */
//    @PreAuthorize("@ss.hasPermi('admin:area:query')")
    @GetMapping(value = "/getAreaList/{warehouseId}")
    public AjaxResult getAreaList(@PathVariable("warehouseId") Long warehouseId)
    {
        return baseWarehouseAreaService.selectBaseWarehouseAreaByWarehouseId(warehouseId);
    }
}
