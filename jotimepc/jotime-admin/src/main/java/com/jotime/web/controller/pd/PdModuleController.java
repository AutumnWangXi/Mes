package com.jotime.web.controller.pd;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.pd.PdModule;
import com.jotime.web.service.pd.IPdModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 描述：生产流程名称Controller
 * 
 * @author yunmoqian
 * @date 2022-05-06
 */
@RestController
@RequestMapping("/web/pd/module")
public class PdModuleController extends BaseController
{
    @Autowired
    private IPdModuleService pdModuleService;

    /**
     * 查询描述：生产流程名称列表
     */
    @PreAuthorize("@ss.hasPermi('web:module:list')")
    @GetMapping("/list")
    public TableDataInfo list(PdModule pdModule)
    {
        startPage();
        List<PdModule> list = pdModuleService.selectPdModuleList(pdModule);
        return getDataTable(list);
    }

    /**
     * 导出描述：生产流程名称列表
     */
    @PreAuthorize("@ss.hasPermi('web:module:export')")
    @Log(title = "描述：生产流程名称", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PdModule pdModule)
    {
        List<PdModule> list = pdModuleService.selectPdModuleList(pdModule);
        ExcelUtil<PdModule> util = new ExcelUtil<PdModule>(PdModule.class);
        util.exportExcel(response, list, "描述：生产流程名称数据");
    }

    /**
     * 获取描述：生产流程名称详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:module:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(pdModuleService.selectPdModuleById(id));
    }

    /**
     * 新增描述：生产流程名称
     */
    @PreAuthorize("@ss.hasPermi('web:module:add')")
    @Log(title = "描述：生产流程名称", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PdModule pdModule)
    {
        return toAjax(pdModuleService.insertPdModule(pdModule));
    }

    /**
     * 修改描述：生产流程名称
     */
    @PreAuthorize("@ss.hasPermi('web:module:edit')")
    @Log(title = "描述：生产流程名称", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PdModule pdModule)
    {
        return toAjax(pdModuleService.updatePdModule(pdModule));
    }

    /**
     * 删除描述：生产流程名称
     */
    @PreAuthorize("@ss.hasPermi('web:module:remove')")
    @Log(title = "描述：生产流程名称", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pdModuleService.deletePdModuleByIds(ids));
    }

    /**
     * 生产流程详情
     */
    @PreAuthorize("@ss.hasPermi('web:module:module')")
    @PostMapping("/moduleInfo")
    public AjaxResult moduleInfo(@RequestBody PdModule pdModule)
    {
        return pdModuleService.moduleInfo(pdModule);
    }
}
