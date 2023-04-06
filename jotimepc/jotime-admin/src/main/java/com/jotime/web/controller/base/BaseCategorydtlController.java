package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseCategorydtl;
import com.jotime.web.service.base.IBaseCategorydtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
@RestController
@RequestMapping("/web/base/categorydtl")
public class BaseCategorydtlController extends BaseController
{
    @Autowired
    private IBaseCategorydtlService baseCategorydtlService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('web:categorydtl:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseCategorydtl baseCategorydtl)
    {
        startPage();
        List<BaseCategorydtl> list = baseCategorydtlService.selectBaseCategorydtlList(baseCategorydtl);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('web:categorydtl:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseCategorydtl baseCategorydtl)
    {
        List<BaseCategorydtl> list = baseCategorydtlService.selectBaseCategorydtlList(baseCategorydtl);
        ExcelUtil<BaseCategorydtl> util = new ExcelUtil<BaseCategorydtl>(BaseCategorydtl.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:categorydtl:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseCategorydtlService.selectBaseCategorydtlById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('web:categorydtl:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseCategorydtl baseCategorydtl)
    {
        return toAjax(baseCategorydtlService.insertBaseCategorydtl(baseCategorydtl));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('web:categorydtl:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseCategorydtl baseCategorydtl)
    {
        return toAjax(baseCategorydtlService.updateBaseCategorydtl(baseCategorydtl));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('web:categorydtl:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseCategorydtlService.deleteBaseCategorydtlByIds(ids));
    }
}
