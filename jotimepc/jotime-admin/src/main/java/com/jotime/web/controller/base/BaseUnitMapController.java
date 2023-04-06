package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseUnitMap;
import com.jotime.web.service.base.IBaseUnitMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 单位转换Controller
 *
 * @author ruoyi
 * @date 2021-12-31
 */
@RestController
@RequestMapping("/web/base/unit")
public class BaseUnitMapController extends BaseController {
    @Autowired
    private IBaseUnitMapService baseUnitMapService;

    /**
     * 查询单位转换列表
     */
    @PreAuthorize("@ss.hasPermi('base:unit:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseUnitMap baseUnitMap) {
        startPage();
        List<BaseUnitMap> list = baseUnitMapService.selectBaseUnitMapList(baseUnitMap);
        return getDataTable(list);
    }

    /**
     * 查询单位转换列表
     */
    @PreAuthorize("@ss.hasPermi('base:unit:listNoLimit')")
    @GetMapping("/listNoLimit")
    public AjaxResult listNoLimit() {
        List<BaseUnitMap> list = baseUnitMapService.selectBaseUnitMapList(new BaseUnitMap());
        return AjaxResult.success(list);
    }

    /**
     * 查询单位转换列表
     */
    @PreAuthorize("@ss.hasPermi('base:unit:distinctlist')")
    @GetMapping("/distinctlist")
    public AjaxResult distinctlist() {
        List<BaseUnitMap> list = baseUnitMapService.selectBaseUnitMapdistinctlist(new BaseUnitMap());
        return AjaxResult.success(list);
    }

    /**
     * 导出单位转换列表
     */
    @PreAuthorize("@ss.hasPermi('base:unit:export')")
    @Log(title = "单位转换", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseUnitMap baseUnitMap) {
        List<BaseUnitMap> list = baseUnitMapService.selectBaseUnitMapList(baseUnitMap);
        ExcelUtil<BaseUnitMap> util = new ExcelUtil<BaseUnitMap>(BaseUnitMap.class);
        util.exportExcel(response, list, "单位转换数据");
    }

    /**
     * 获取单位转换详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:unit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(baseUnitMapService.selectBaseUnitMapById(id));
    }

    /**
     * 新增单位转换
     */
    @PreAuthorize("@ss.hasPermi('base:unit:add')")
    @Log(title = "单位转换", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseUnitMap baseUnitMap) {
        return toAjax(baseUnitMapService.insertBaseUnitMap(baseUnitMap));
    }

    /**
     * 修改单位转换
     */
    @PreAuthorize("@ss.hasPermi('base:unit:edit')")
    @Log(title = "单位转换", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseUnitMap baseUnitMap) {
        return toAjax(baseUnitMapService.updateBaseUnitMap(baseUnitMap));
    }

    /**
     * 删除单位转换
     */
    @PreAuthorize("@ss.hasPermi('base:unit:remove')")
    @Log(title = "单位转换", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(baseUnitMapService.deleteBaseUnitMapByIds(ids));
    }
}
