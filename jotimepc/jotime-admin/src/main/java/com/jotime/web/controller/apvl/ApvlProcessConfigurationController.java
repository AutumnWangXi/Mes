package com.jotime.web.controller.apvl;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.Apvl.ApvlProcessConfiguration;
import com.jotime.web.domainVo.apvl.ApvlProcessConfigurationVo;
import com.jotime.web.service.Apvl.IApvlProcessConfigurationService;
import com.jotime.web.service.Apvl.IApvlProcessNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 审批流程配置Controller
 *
 * @author ruoyi
 * @date 2021-12-26
 */
@RestController
@RequestMapping("/admin/configuration")
public class
ApvlProcessConfigurationController extends BaseController
{
    @Autowired
    private IApvlProcessConfigurationService apvlProcessConfigurationService;

    @Autowired
    private IApvlProcessNodeService iApvlProcessNodeService;

    /**
     * 查询审批流程配置列表
     */
//    @PreAuthorize("@ss.hasPermi('admin:configuration:list')")
    @GetMapping("/list")
    public TableDataInfo list(ApvlProcessConfiguration apvlProcessConfiguration)
    {
        startPage();
        List<ApvlProcessConfigurationVo> list = apvlProcessConfigurationService.selectApvlProcessConfigurationVoList(apvlProcessConfiguration);
        return getDataTable(list);
    }

    /**
     * 导出审批流程配置列表
     */
    @PreAuthorize("@ss.hasPermi('admin:configuration:export')")
    @Log(title = "审批流程配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ApvlProcessConfiguration apvlProcessConfiguration)
    {
        List<ApvlProcessConfiguration> list = apvlProcessConfigurationService.selectApvlProcessConfigurationList(apvlProcessConfiguration);
        ExcelUtil<ApvlProcessConfiguration> util = new ExcelUtil<ApvlProcessConfiguration>(ApvlProcessConfiguration.class);
        util.exportExcel(response, list, "审批流程配置数据");
    }

    /**
     * 获取审批流程配置详细信息
     */
//    @PreAuthorize("@ss.hasPermi('admin:configuration:query')")
    @GetMapping( "/{id}")
    public AjaxResult getInfo(@PathVariable(value = "id" ) Long id)
    {
        AjaxResult ajax = AjaxResult.success();
        ApvlProcessConfiguration apvlProcessConfiguration = apvlProcessConfigurationService.selectApvlProcessConfigurationById(id);
        ajax.put(AjaxResult.DATA_TAG, apvlProcessConfiguration);
        if (apvlProcessConfiguration.getModuleId()!=null){
            ajax.put("nodeOption",iApvlProcessNodeService.getNodeList(apvlProcessConfiguration.getModuleId(),0));
        }
        return ajax;
    }

    /**
     * 新增审批流程配置
     */
    @PreAuthorize("@ss.hasPermi('admin:configuration:add')")
    @Log(title = "审批流程配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ApvlProcessConfigurationVo apvlProcessConfigurationVo)
    {
        return toAjax(apvlProcessConfigurationService.insertApvlProcessConfiguration(apvlProcessConfigurationVo));
    }

    /**
     * 修改审批流程配置
     */
    @PreAuthorize("@ss.hasPermi('admin:configuration:edit')")
    @Log(title = "审批流程配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ApvlProcessConfiguration apvlProcessConfiguration)
    {
        apvlProcessConfiguration.setUpdateBy(getUsername());
        apvlProcessConfiguration.setUpdateTime(DateUtils.getNowDate());
        return toAjax(apvlProcessConfigurationService.updateApvlProcessConfiguration(apvlProcessConfiguration));
    }

    /**
     * 删除审批流程配置
     */
    @PreAuthorize("@ss.hasPermi('admin:configuration:remove')")
    @Log(title = "审批流程配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(apvlProcessConfigurationService.deleteApvlProcessConfigurationByIds(ids));
    }
}
