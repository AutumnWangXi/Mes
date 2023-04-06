package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseProductionLine;
import com.jotime.web.service.base.IBaseProductionLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 生产线Controller
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
@RestController
@RequestMapping("/web/base/line")
public class BaseProductionLineController extends BaseController
{
    @Autowired
    private IBaseProductionLineService baseProductionLineService;

    /**
     * 查询生产线列表
     */
    @PreAuthorize("@ss.hasPermi('admin:line:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseProductionLine baseProductionLine)
    {
        startPage();
        List<BaseProductionLine> list = baseProductionLineService.selectBaseProductionLineList(baseProductionLine);
        return getDataTable(list);
    }

    /**
     * 导出生产线列表
     */
    @PreAuthorize("@ss.hasPermi('admin:line:export')")
    @Log(title = "生产线", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseProductionLine baseProductionLine)
    {
        List<BaseProductionLine> list = baseProductionLineService.selectBaseProductionLineList(baseProductionLine);
        ExcelUtil<BaseProductionLine> util = new ExcelUtil<BaseProductionLine>(BaseProductionLine.class);
        util.exportExcel(response, list, "生产线数据");
    }

    /**
     * 获取生产线详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:line:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseProductionLineService.selectBaseProductionLineById(id));
    }

    /**
     * 新增生产线
     */
    @PreAuthorize("@ss.hasPermi('admin:line:add')")
    @Log(title = "生产线", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseProductionLine baseProductionLine)
    {
        return toAjax(baseProductionLineService.insertBaseProductionLine(baseProductionLine));
    }

    /**
     * 修改生产线
     */
    @PreAuthorize("@ss.hasPermi('admin:line:edit')")
    @Log(title = "生产线", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseProductionLine baseProductionLine)
    {
        return toAjax(baseProductionLineService.updateBaseProductionLine(baseProductionLine));
    }

    /**
     * 删除生产线
     */
    @PreAuthorize("@ss.hasPermi('admin:line:remove')")
    @Log(title = "生产线", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseProductionLineService.deleteBaseProductionLineByIds(ids));
    }
}
