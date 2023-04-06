package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.web.domain.base.BaseOpenlinedtl;
import com.jotime.web.service.base.IBaseOpenlinedtlService;
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

import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.common.core.page.TableDataInfo;

/**
 * 开线检查内容Controller
 *
 * @author ruoyi
 * @date 2022-03-04
 */
@RestController
@RequestMapping("/web/baseopenlinedtl")
public class BaseOpenlinedtlController extends BaseController
{
    @Autowired
    private IBaseOpenlinedtlService baseOpenlinedtlService;

    /**
     * 查询开线检查内容列表
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenlinedtl:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseOpenlinedtl baseOpenlinedtl)
    {
        startPage();
        List<BaseOpenlinedtl> list = baseOpenlinedtlService.selectBaseOpenlinedtlList(baseOpenlinedtl);
        return getDataTable(list);
    }

    /**
     * 导出开线检查内容列表
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenlinedtl:export')")
    @Log(title = "开线检查内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseOpenlinedtl baseOpenlinedtl)
    {
        List<BaseOpenlinedtl> list = baseOpenlinedtlService.selectBaseOpenlinedtlList(baseOpenlinedtl);
        ExcelUtil<BaseOpenlinedtl> util = new ExcelUtil<BaseOpenlinedtl>(BaseOpenlinedtl.class);
        util.exportExcel(response, list, "开线检查内容数据");
    }

    /**
     * 获取开线检查内容详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenlinedtl:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseOpenlinedtlService.selectBaseOpenlinedtlById(id));
    }

    /**
     * 新增开线检查内容
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenlinedtl:add')")
    @Log(title = "开线检查内容", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseOpenlinedtl baseOpenlinedtl)
    {
        return toAjax(baseOpenlinedtlService.insertBaseOpenlinedtl(baseOpenlinedtl));
    }

    /**
     * 修改开线检查内容
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenlinedtl:edit')")
    @Log(title = "开线检查内容", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseOpenlinedtl baseOpenlinedtl)
    {
        return toAjax(baseOpenlinedtlService.updateBaseOpenlinedtl(baseOpenlinedtl));
    }

    /**
     * 删除开线检查内容
     */
    @PreAuthorize("@ss.hasPermi('web:baseopenlinedtl:remove')")
    @Log(title = "开线检查内容", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseOpenlinedtlService.deleteBaseOpenlinedtlByIds(ids));
    }
}
