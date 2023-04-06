package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseCategory;
import com.jotime.web.service.base.IBaseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 类别Controller
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
@RestController
@RequestMapping("/web/base/category")
public class BaseCategoryController extends BaseController
{
    @Autowired
    private IBaseCategoryService baseCategoryService;

    /**
     * 查询类别列表
     */
    @PreAuthorize("@ss.hasPermi('web:category:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseCategory baseCategory)
    {
        startPage();
        List<BaseCategory> list = baseCategoryService.selectBaseCategoryList(baseCategory);
        return getDataTable(list);
    }

    /**
     * 导出类别列表
     */
    @PreAuthorize("@ss.hasPermi('web:category:export')")
    @Log(title = "类别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseCategory baseCategory)
    {
        List<BaseCategory> list = baseCategoryService.selectBaseCategoryList(baseCategory);
        ExcelUtil<BaseCategory> util = new ExcelUtil<BaseCategory>(BaseCategory.class);
        util.exportExcel(response, list, "类别数据");
    }

    /**
     * 获取类别详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:category:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseCategoryService.selectBaseCategoryById(id));
    }

    /**
     * 新增类别
     */
    @PreAuthorize("@ss.hasPermi('web:category:add')")
    @Log(title = "类别", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseCategory baseCategory)
    {
        return toAjax(baseCategoryService.insertBaseCategory(baseCategory));
    }

    /**
     * 修改类别
     */
    @PreAuthorize("@ss.hasPermi('web:category:edit')")
    @Log(title = "类别", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseCategory baseCategory)
    {
        return toAjax(baseCategoryService.updateBaseCategory(baseCategory));
    }

    /**
     * 删除类别
     */
    @PreAuthorize("@ss.hasPermi('web:category:remove')")
    @Log(title = "类别", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseCategoryService.deleteBaseCategoryByIds(ids));
    }
}
