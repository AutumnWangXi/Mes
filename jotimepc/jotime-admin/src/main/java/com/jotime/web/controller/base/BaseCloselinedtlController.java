package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseCloselinedtl;
import com.jotime.web.service.base.IBaseCloselinedtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 清线检查内容Controller
 * 
 * @author ruoyi
 * @date 2022-03-04
 */
@RestController
@RequestMapping("/web/closelinedtl")
public class BaseCloselinedtlController extends BaseController
{
    @Autowired
    private IBaseCloselinedtlService baseCloselinedtlService;

    /**
     * 查询清线检查内容列表
     */
    @PreAuthorize("@ss.hasPermi('web:closelinedtl:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseCloselinedtl baseCloselinedtl)
    {
        startPage();
        List<BaseCloselinedtl> list = baseCloselinedtlService.selectBaseCloselinedtlList(baseCloselinedtl);
        return getDataTable(list);
    }

    /**
     * 导出清线检查内容列表
     */
    @PreAuthorize("@ss.hasPermi('web:closelinedtl:export')")
    @Log(title = "清线检查内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseCloselinedtl baseCloselinedtl)
    {
        List<BaseCloselinedtl> list = baseCloselinedtlService.selectBaseCloselinedtlList(baseCloselinedtl);
        ExcelUtil<BaseCloselinedtl> util = new ExcelUtil<BaseCloselinedtl>(BaseCloselinedtl.class);
        util.exportExcel(response, list, "清线检查内容数据");
    }

    /**
     * 获取清线检查内容详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:closelinedtl:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseCloselinedtlService.selectBaseCloselinedtlById(id));
    }

    /**
     * 新增清线检查内容
     */
    @PreAuthorize("@ss.hasPermi('web:closelinedtl:add')")
    @Log(title = "清线检查内容", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseCloselinedtl baseCloselinedtl)
    {
        return toAjax(baseCloselinedtlService.insertBaseCloselinedtl(baseCloselinedtl));
    }

    /**
     * 修改清线检查内容
     */
    @PreAuthorize("@ss.hasPermi('web:closelinedtl:edit')")
    @Log(title = "清线检查内容", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseCloselinedtl baseCloselinedtl)
    {
        return toAjax(baseCloselinedtlService.updateBaseCloselinedtl(baseCloselinedtl));
    }

    /**
     * 删除清线检查内容
     */
    @PreAuthorize("@ss.hasPermi('web:closelinedtl:remove')")
    @Log(title = "清线检查内容", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseCloselinedtlService.deleteBaseCloselinedtlByIds(ids));
    }
}
