package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseCloseline;
import com.jotime.web.domainVo.base.BaseCloselineVo;
import com.jotime.web.service.base.IBaseCloselineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 清线检查Controller
 *
 * @author ruoyi
 * @date 2022-03-04
 */
@RestController
@RequestMapping("/web/closeline")
public class BaseCloselineController extends BaseController
{
    @Autowired
    private IBaseCloselineService baseCloselineService;

    /**
     * 查询清线检查列表
     */
    @PreAuthorize("@ss.hasPermi('web:closeline:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseCloseline baseCloseline)
    {
        startPage();
        List<BaseCloseline> list = baseCloselineService.selectBaseCloselineList(baseCloseline);
        return getDataTable(list);
    }

    /**
     * 导出清线检查列表
     */
    @PreAuthorize("@ss.hasPermi('web:closeline:export')")
    @Log(title = "清线检查", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseCloseline baseCloseline)
    {
        List<BaseCloseline> list = baseCloselineService.selectBaseCloselineList(baseCloseline);
        ExcelUtil<BaseCloseline> util = new ExcelUtil<BaseCloseline>(BaseCloseline.class);
        util.exportExcel(response, list, "清线检查数据");
    }

    /**
     * 获取清线检查详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:closeline:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseCloselineService.selectBaseCloselineById(id));
    }

    /**
     * 新增清线检查
     */
    @PreAuthorize("@ss.hasPermi('web:closeline:add')")
    @Log(title = "清线检查", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseCloseline baseCloseline)
    {
        return toAjax(baseCloselineService.insertBaseCloseline(baseCloseline));
    }

    /**
     * 修改清线检查
     */
    @PreAuthorize("@ss.hasPermi('web:closeline:edit')")
    @Log(title = "清线检查", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseCloseline baseCloseline)
    {
        return toAjax(baseCloselineService.updateBaseCloseline(baseCloseline));
    }

    /**
     * 删除清线检查
     */
    @PreAuthorize("@ss.hasPermi('web:closeline:remove')")
    @Log(title = "清线检查", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseCloselineService.deleteBaseCloselineByIds(ids));
    }

    /**
     * 新增清线检查和详情
     */
    @PreAuthorize("@ss.hasPermi('web:closeline:add')")
    @Log(title = "清线检查", businessType = BusinessType.INSERT)
    @PostMapping("/addAnddtl")
    public AjaxResult addAnddtl(@RequestBody BaseCloselineVo baseCloselineVo)
    {
        return baseCloselineService.addAnddtl(baseCloselineVo);
    }

    /**
     * 查询清线检查列表和详情
     */
    @PreAuthorize("@ss.hasPermi('web:closeline:list')")
    @GetMapping("/listAndDtl")
    public TableDataInfo listAndDtl(BaseCloseline baseCloseline)
    {
        startPage();
        List<BaseCloselineVo> list = baseCloselineService.selectBaseCloselineVoList(baseCloseline);
        return getDataTable(list);
    }

    /**
     * 获取开线检查详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenline:query')")
    @GetMapping(value = "/closelineAndDtl/{id}")
    public AjaxResult getCloselineAndDtl(@PathVariable("id") Long id)
    {
        return baseCloselineService.getCloselineAndDtl(id);
    }
    /**
     * 新增清线检查
     */
    @PreAuthorize("@ss.hasPermi('web:closeline:add')")
    @Log(title = "清线检查", businessType = BusinessType.INSERT)
    @PostMapping("/addCloselineAndDtl")
    public AjaxResult addCloselineAndDtl(@RequestBody BaseCloselineVo baseCloselineVo)
    {
        return baseCloselineService.insertBaseCloselineAndDtl(baseCloselineVo);
    }
    /**
     * 修改清线检查和dtl
     */
    @PreAuthorize("@ss.hasPermi('web:closeline:edit')")
    @Log(title = "清线检查", businessType = BusinessType.UPDATE)
    @PutMapping("/editCloselineAndDtl")
    public AjaxResult editCloselineAndDtl(@RequestBody BaseCloselineVo baseCloselineVo)
    {
        return baseCloselineService.updateBaseCloselineAndDtl(baseCloselineVo);
    }

    /**
     * 删除清线检查
     */
    @PreAuthorize("@ss.hasPermi('web:closeline:remove')")
    @Log(title = "清线检查", businessType = BusinessType.DELETE)
    @DeleteMapping("/removeCloselineAndDtl/{ids}")
    public AjaxResult removeCloselineAndDtl(@PathVariable Long[] ids)
    {
        return toAjax(baseCloselineService.deleteBaseCloselineAndDtlByIds(ids));
    }
}
