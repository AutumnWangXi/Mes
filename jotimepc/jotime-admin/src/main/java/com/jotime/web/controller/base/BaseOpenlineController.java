package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseOpenline;
import com.jotime.web.domainVo.base.BaseOpenlineVo;
import com.jotime.web.service.base.IBaseOpenlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 开线检查Controller
 *
 * @author YunFei
 * @date 2022-03-04
 */
@RestController
@RequestMapping("/web/baseopenline")
public class BaseOpenlineController extends BaseController
{
    @Autowired
    private IBaseOpenlineService baseOpenlineService;

    /**
     * 查询开线检查列表
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenline:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseOpenline baseOpenline)
    {
        startPage();
        List<BaseOpenline> list = baseOpenlineService.selectBaseOpenlineList(baseOpenline);
        return getDataTable(list);
    }

    /**
     * 导出开线检查列表
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenline:export')")
    @Log(title = "开线检查", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseOpenline baseOpenline)
    {
        List<BaseOpenline> list = baseOpenlineService.selectBaseOpenlineList(baseOpenline);
        ExcelUtil<BaseOpenline> util = new ExcelUtil<BaseOpenline>(BaseOpenline.class);
        util.exportExcel(response, list, "开线检查数据");
    }

    /**
     * 获取开线检查详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenline:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseOpenlineService.selectBaseOpenlineById(id));
    }

    /**
     * 新增开线检查
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenline:add')")
    @Log(title = "开线检查", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseOpenline baseOpenline)
    {
        return toAjax(baseOpenlineService.insertBaseOpenline(baseOpenline));
    }

    /**
     * 修改开线检查
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenline:edit')")
    @Log(title = "开线检查", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseOpenline baseOpenline)
    {
        return toAjax(baseOpenlineService.updateBaseOpenline(baseOpenline));
    }

    /**
     * 删除开线检查
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenline:remove')")
    @Log(title = "开线检查", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseOpenlineService.deleteBaseOpenlineByIds(ids));
    }

    /**
     * 新增开线检查
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenline:add')")
    @Log(title = "开线检查", businessType = BusinessType.INSERT)
    @PostMapping("/addOpenlineVo")
    public AjaxResult addOpenlineVo(@RequestBody BaseOpenlineVo baseOpenline)
    {
        return baseOpenlineService.addOpenline(baseOpenline);
    }

    /**
     * 获取开线检查详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenline:query')")
    @GetMapping(value = "/getOpenline/{id}")
    public AjaxResult getOpenline(@PathVariable("id") Long id)
    {
        return baseOpenlineService.getOpenline(id);
    }
    /**
     * 修改开线检查和dtl
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenline:edit')")
    @Log(title = "开线检查", businessType = BusinessType.UPDATE)
    @PutMapping("/updateOpenline")
    public AjaxResult UpdateOpenline(@RequestBody BaseOpenlineVo baseOpenline)
    {
        return baseOpenlineService.UpdateOpenline(baseOpenline);
    }
    /**
     * 查询开线检查列表和dtl
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenline:list')")
    @GetMapping("/listOpenline")
    public TableDataInfo listOpenline(BaseOpenline baseOpenline)
    {
        startPage();
        List<BaseOpenlineVo> list = baseOpenlineService.selectBaseOpenlineVoList(baseOpenline);
        return getDataTable(list);
    }

    /**
     * 删除开线检查和对应的dtl
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenline:remove')")
    @Log(title = "开线检查", businessType = BusinessType.DELETE)
    @DeleteMapping("/removeAndDtl/{ids}")
    public AjaxResult removeAndDtl(@PathVariable Long[] ids)
    {
        return baseOpenlineService.deleteBaseOpenlineAndDtlByIds(ids);
    }
}
