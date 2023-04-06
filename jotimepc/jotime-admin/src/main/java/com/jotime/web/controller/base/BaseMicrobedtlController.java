package com.jotime.web.controller.base;


import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseMicrobedtl;
import com.jotime.web.service.base.IBaseMicrobedtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 微生物检测内容Controller
 * 
 * @author yunmoqian
 * @date 2022-06-16
 */
@RestController
@RequestMapping("/web/basemicrobedtl")
public class BaseMicrobedtlController extends BaseController
{
    @Autowired
    private IBaseMicrobedtlService baseMicrobedtlService;

    /**
     * 查询微生物检测内容列表
     */
    @PreAuthorize("@ss.hasPermi('web:basemicrobedtl:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseMicrobedtl baseMicrobedtl)
    {
        startPage();
        List<BaseMicrobedtl> list = baseMicrobedtlService.selectBaseMicrobedtlList(baseMicrobedtl);
        return getDataTable(list);
    }

    /**
     * 导出微生物检测内容列表
     */
    @PreAuthorize("@ss.hasPermi('web:basemicrobedtl:export')")
    @Log(title = "微生物检测内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseMicrobedtl baseMicrobedtl)
    {
        List<BaseMicrobedtl> list = baseMicrobedtlService.selectBaseMicrobedtlList(baseMicrobedtl);
        ExcelUtil<BaseMicrobedtl> util = new ExcelUtil<BaseMicrobedtl>(BaseMicrobedtl.class);
        util.exportExcel(response, list, "微生物检测内容数据");
    }

    /**
     * 获取微生物检测内容详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:basemicrobedtl:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseMicrobedtlService.selectBaseMicrobedtlById(id));
    }

    /**
     * 新增微生物检测内容
     */
    @PreAuthorize("@ss.hasPermi('web:basemicrobedtl:add')")
    @Log(title = "微生物检测内容", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseMicrobedtl baseMicrobedtl)
    {
        return toAjax(baseMicrobedtlService.insertBaseMicrobedtl(baseMicrobedtl));
    }

    /**
     * 修改微生物检测内容
     */
    @PreAuthorize("@ss.hasPermi('web:basemicrobedtl:edit')")
    @Log(title = "微生物检测内容", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseMicrobedtl baseMicrobedtl)
    {
        return toAjax(baseMicrobedtlService.updateBaseMicrobedtl(baseMicrobedtl));
    }

    /**
     * 删除微生物检测内容
     */
    @PreAuthorize("@ss.hasPermi('web:basemicrobedtl:remove')")
    @Log(title = "微生物检测内容", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseMicrobedtlService.deleteBaseMicrobedtlByIds(ids));
    }
}
