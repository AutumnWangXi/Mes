package com.jotime.web.controller.apvl;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.Apvl.ApvlModule;
import com.jotime.web.service.Apvl.IApvlModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 审批流程名称Controller
 *
 * @author
 * @date 2021-12-26
 */
@RestController
@RequestMapping("/admin/module")
public class ApvlModuleController extends BaseController
{
    @Autowired
    private IApvlModuleService apvlModuleService;

    /**
     * 查询审批流程名称列表
     */
//    @PreAuthorize("@ss.hasPermi('admin:module:list')")
    @GetMapping("/list")
    public TableDataInfo list(ApvlModule apvlModule)
    {
        startPage();
        List<ApvlModule> list = apvlModuleService.selectApvlModuleList(apvlModule);
        return getDataTable(list);
    }

    /**
     * 导出审批流程名称列表
     */
    @PreAuthorize("@ss.hasPermi('admin:module:export')")
    @Log(title = "审批流程名称", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ApvlModule apvlModule)
    {
        List<ApvlModule> list = apvlModuleService.selectApvlModuleList(apvlModule);
        ExcelUtil<ApvlModule> util = new ExcelUtil<ApvlModule>(ApvlModule.class);
        util.exportExcel(response, list, "审批流程名称数据");
    }

    /**
     * 获取审批流程名称详细信息
     */
//    @PreAuthorize("@ss.hasPermi('admin:module:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(apvlModuleService.selectApvlModuleById(id));
    }

    /**
     * 新增审批流程名称
     */
    @PreAuthorize("@ss.hasPermi('admin:module:add')")
    @Log(title = "审批流程名称", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ApvlModule apvlModule)
    {
        if (apvlModuleService.insertApvlModule(apvlModule)>0){
            return toAjax(1);
        }
        return AjaxResult.error("修改失败！设备编码（"+apvlModule.getModuleNo()+"）已经存在");
    }

    /**
     * 修改审批流程名称
     */
    @PreAuthorize("@ss.hasPermi('admin:module:edit')")
    @Log(title = "审批流程名称", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ApvlModule apvlModule)
    {
        return toAjax(apvlModuleService.updateApvlModule(apvlModule));
    }

    /**
     * 删除审批流程名称
     */
    @PreAuthorize("@ss.hasPermi('admin:module:remove')")
    @Log(title = "审批流程名称", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(apvlModuleService.deleteApvlModuleByIds(ids));
    }

    /**
     * 获取流程列表
     */
    @GetMapping(value ={ "/getModuleList"})
    public AjaxResult getModuleList()
    {
        AjaxResult ajax = AjaxResult.success();
        ajax.put("moduleOptions",apvlModuleService.selectApvlModuleList(null));
        return ajax;
    }
}
