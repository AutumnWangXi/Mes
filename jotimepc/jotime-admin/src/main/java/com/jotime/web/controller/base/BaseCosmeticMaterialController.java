package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.web.domain.base.BaseCosmeticMaterial;
import com.jotime.web.service.base.IBaseCosmeticMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: 已使用化妆品原料Controller
 * @Author: YunFei
 * @Date: 2022/4/20 17:43
 */
@RestController
@RequestMapping("/web/cosmeticMaterial")
public class BaseCosmeticMaterialController extends BaseController
{
    @Autowired
    private IBaseCosmeticMaterialService baseCosmeticMaterialService;

    /**
     * 查询已使用化妆品原料列表
     */
    @PreAuthorize("@ss.hasPermi('web:cosmeticMaterial:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseCosmeticMaterial baseCosmeticMaterial)
    {
        startPage();
        List<BaseCosmeticMaterial> list = baseCosmeticMaterialService.selectBaseCosmeticMaterialList(baseCosmeticMaterial);
        return getDataTable(list);
    }

    /**
     * 获取已使用化妆品原料详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:cosmeticMaterial:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseCosmeticMaterialService.selectBaseCosmeticMaterialById(id));
    }

    /**
     * 新增已使用化妆品原料
     */
    @PreAuthorize("@ss.hasPermi('web:cosmeticMaterial:add')")
    @Log(title = "已使用化妆品原料", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseCosmeticMaterial baseCosmeticMaterial)
    {
        return toAjax(baseCosmeticMaterialService.insertBaseCosmeticMaterial(baseCosmeticMaterial));
    }

    /**
     * 修改已使用化妆品原料
     */
    @PreAuthorize("@ss.hasPermi('web:cosmeticMaterial:edit')")
    @Log(title = "已使用化妆品原料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseCosmeticMaterial baseCosmeticMaterial)
    {
        return toAjax(baseCosmeticMaterialService.updateBaseCosmeticMaterial(baseCosmeticMaterial));
    }

    /**
     * 删除已使用化妆品原料
     */
    @PreAuthorize("@ss.hasPermi('web:cosmeticMaterial:remove')")
    @Log(title = "已使用化妆品原料", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseCosmeticMaterialService.deleteBaseCosmeticMaterialByIds(ids));
    }

}
