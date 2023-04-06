package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseMicrobe;
import com.jotime.web.service.base.IBaseMicrobeService;
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
import com.jotime.common.core.page.TableDataInfo;

/**
 * 微生物检测Controller
 * 
 * @author yunmoqian
 * @date 2022-06-16
 */
@RestController
@RequestMapping("/web/basemicrobe")
public class BaseMicrobeController extends BaseController
{
    @Autowired
    private IBaseMicrobeService baseMicrobeService;

    /**
     * 查询微生物检测列表
     */
    @PreAuthorize("@ss.hasPermi('web:basemicrobe:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseMicrobe baseMicrobe)
    {
        startPage();
        List<BaseMicrobe> list = baseMicrobeService.selectBaseMicrobeList(baseMicrobe);
        return getDataTable(list);
    }

    /**
     * 导出微生物检测列表
     */
    @PreAuthorize("@ss.hasPermi('web:basemicrobe:export')")
    @Log(title = "微生物检测", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseMicrobe baseMicrobe)
    {
        List<BaseMicrobe> list = baseMicrobeService.selectBaseMicrobeList(baseMicrobe);
        ExcelUtil<BaseMicrobe> util = new ExcelUtil<BaseMicrobe>(BaseMicrobe.class);
        util.exportExcel(response, list, "微生物检测数据");
    }

    /**
     * 获取微生物检测详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:basemicrobe:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseMicrobeService.selectBaseMicrobeById(id));
    }

    /**
     * 新增微生物检测
     */
    @PreAuthorize("@ss.hasPermi('web:basemicrobe:add')")
    @Log(title = "微生物检测", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseMicrobe baseMicrobe)
    {
        return toAjax(baseMicrobeService.insertBaseMicrobe(baseMicrobe));
    }

    /**
     * 修改微生物检测
     */
    @PreAuthorize("@ss.hasPermi('web:basemicrobe:edit')")
    @Log(title = "微生物检测", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseMicrobe baseMicrobe)
    {
        return toAjax(baseMicrobeService.updateBaseMicrobe(baseMicrobe));
    }

    /**
     * 删除微生物检测
     */
    @PreAuthorize("@ss.hasPermi('web:basemicrobe:remove')")
    @Log(title = "微生物检测", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseMicrobeService.deleteBaseMicrobeByIds(ids));
    }
}
