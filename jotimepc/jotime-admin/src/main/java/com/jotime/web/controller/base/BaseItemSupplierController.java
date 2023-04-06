package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.web.domainVo.base.BaseItemSupplierVo;
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
import com.jotime.web.domain.base.BaseItemSupplier;
import com.jotime.web.service.base.IBaseItemSupplierService;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.common.core.page.TableDataInfo;

/**
 * 物料供应商Controller
 *
 * @author yunmoqian
 * @date 2022-05-22
 */
@RestController
@RequestMapping("/web/base/itemsupplier")
public class BaseItemSupplierController extends BaseController {
    @Autowired
    private IBaseItemSupplierService baseItemSupplierService;

    /**
     * 查询物料供应商列表
     */
    @PreAuthorize("@ss.hasPermi('web:supplier:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseItemSupplier baseItemSupplier) {
        startPage();
        List<BaseItemSupplier> list = baseItemSupplierService.selectBaseItemSupplierList(baseItemSupplier);
        return getDataTable(list);
    }

    /**
     * 查询物料供应商列表
     */
    @GetMapping("/getSupplierData/{itemId}")
    public AjaxResult list(@PathVariable("itemId") Long itemId) {
        List<BaseItemSupplierVo> list = baseItemSupplierService.selectBaseItemSupplierListByItemId(itemId);
        return AjaxResult.success(list);
    }

    /**
     * 导出物料供应商列表
     */
    @PreAuthorize("@ss.hasPermi('web:supplier:export')")
    @Log(title = "物料供应商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseItemSupplier baseItemSupplier) {
        List<BaseItemSupplier> list = baseItemSupplierService.selectBaseItemSupplierList(baseItemSupplier);
        ExcelUtil<BaseItemSupplier> util = new ExcelUtil<BaseItemSupplier>(BaseItemSupplier.class);
        util.exportExcel(response, list, "物料供应商数据");
    }

    /**
     * 获取物料供应商详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:supplier:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(baseItemSupplierService.selectBaseItemSupplierById(id));
    }

    /**
     * 新增物料供应商
     */
    @PreAuthorize("@ss.hasPermi('web:supplier:add')")
    @Log(title = "物料供应商", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseItemSupplier baseItemSupplier) {
        return toAjax(baseItemSupplierService.insertBaseItemSupplier(baseItemSupplier));
    }

    /**
     * 修改物料供应商
     */
    @PreAuthorize("@ss.hasPermi('web:supplier:edit')")
    @Log(title = "物料供应商", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseItemSupplier baseItemSupplier) {
        return toAjax(baseItemSupplierService.updateBaseItemSupplier(baseItemSupplier));
    }

    /**
     * 删除物料供应商
     */
    @PreAuthorize("@ss.hasPermi('web:supplier:remove')")
    @Log(title = "物料供应商", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(baseItemSupplierService.deleteBaseItemSupplierByIds(ids));
    }
}
