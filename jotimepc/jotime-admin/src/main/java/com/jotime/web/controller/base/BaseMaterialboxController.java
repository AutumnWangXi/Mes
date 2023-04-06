package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseMaterialbox;
import com.jotime.web.service.base.IBaseMaterialboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 物料箱基础Controller
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
@RestController
@RequestMapping("/web/base/materialbox")
public class BaseMaterialboxController extends BaseController
{
    @Autowired
    private IBaseMaterialboxService baseMaterialboxService;

    /**
     * 查询物料箱基础列表
     */
    @PreAuthorize("@ss.hasPermi('admin:materialbox:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseMaterialbox baseMaterialbox)
    {
        startPage();
        List<BaseMaterialbox> list = baseMaterialboxService.selectBaseMaterialboxList(baseMaterialbox);
        return getDataTable(list);
    }

    /**
     * 导出物料箱基础列表
     */
    @PreAuthorize("@ss.hasPermi('admin:materialbox:export')")
    @Log(title = "物料箱基础", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseMaterialbox baseMaterialbox)
    {
        List<BaseMaterialbox> list = baseMaterialboxService.selectBaseMaterialboxList(baseMaterialbox);
        ExcelUtil<BaseMaterialbox> util = new ExcelUtil<BaseMaterialbox>(BaseMaterialbox.class);
        util.exportExcel(response, list, "物料箱基础数据");
    }

    /**
     * 获取物料箱基础详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:materialbox:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseMaterialboxService.selectBaseMaterialboxById(id));
    }

    /**
     * 新增物料箱基础
     */
    @PreAuthorize("@ss.hasPermi('admin:materialbox:add')")
    @Log(title = "物料箱基础", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseMaterialbox baseMaterialbox)
    {
        return toAjax(baseMaterialboxService.insertBaseMaterialbox(baseMaterialbox));
    }

    /**
     * 修改物料箱基础
     */
    @PreAuthorize("@ss.hasPermi('admin:materialbox:edit')")
    @Log(title = "物料箱基础", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseMaterialbox baseMaterialbox)
    {
        return toAjax(baseMaterialboxService.updateBaseMaterialbox(baseMaterialbox));
    }

    /**
     * 删除物料箱基础
     */
    @PreAuthorize("@ss.hasPermi('admin:materialbox:remove')")
    @Log(title = "物料箱基础", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseMaterialboxService.deleteBaseMaterialboxByIds(ids));
    }
}
