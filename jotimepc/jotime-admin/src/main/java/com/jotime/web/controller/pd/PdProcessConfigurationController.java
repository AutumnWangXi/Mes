package com.jotime.web.controller.pd;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.pd.PdProcessConfiguration;
import com.jotime.web.domainVo.pd.PdProcessConfigurationVo;
import com.jotime.web.service.pd.IPdProcessConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 描述：生产流程配置Controller
 *
 * @author yunmoqian
 * @date 2022-05-06
 */
@RestController
@RequestMapping("/web/pd/configuration")
public class PdProcessConfigurationController extends BaseController {
    @Autowired
    private IPdProcessConfigurationService pdProcessConfigurationService;

    /**
     * 查询描述：生产流程配置列表
     */
    @PreAuthorize("@ss.hasPermi('web:configuration:list')")
    @GetMapping("/list")
    public TableDataInfo list(PdProcessConfiguration pdProcessConfiguration) {
        startPage();
        List<PdProcessConfiguration> list = pdProcessConfigurationService.selectPdProcessConfigurationList(pdProcessConfiguration);
        return getDataTable(list);
    }

    /**
     * 查询描述：生产流程配置列表
     */
    @PreAuthorize("@ss.hasPermi('web:configuration:list')")
    @GetMapping("/dataList")
    public TableDataInfo list(PdProcessConfigurationVo pdProcessConfigurationVo) {
        startPage();
        List<PdProcessConfigurationVo> list = pdProcessConfigurationService.selectPdProcessConfigurationVoList(pdProcessConfigurationVo);
        return getDataTable(list);
    }

    /**
     * 导出描述：生产流程配置列表
     */
    @PreAuthorize("@ss.hasPermi('web:configuration:export')")
    @Log(title = "描述：生产流程配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PdProcessConfiguration pdProcessConfiguration) {
        List<PdProcessConfiguration> list = pdProcessConfigurationService.selectPdProcessConfigurationList(pdProcessConfiguration);
        ExcelUtil<PdProcessConfiguration> util = new ExcelUtil<PdProcessConfiguration>(PdProcessConfiguration.class);
        util.exportExcel(response, list, "描述：生产流程配置数据");
    }

    /**
     * 获取描述：生产流程配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:configuration:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(pdProcessConfigurationService.selectPdProcessConfigurationById(id));
    }

    /**
     * 新增描述：生产流程配置
     */
    @PreAuthorize("@ss.hasPermi('web:configuration:add')")
    @Log(title = "描述：生产流程配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody @Validated PdProcessConfiguration pdProcessConfiguration) {
        return toAjax(pdProcessConfigurationService.addToPdProcessConfiguration(pdProcessConfiguration));
    }

    /**
     * 修改描述：生产流程配置
     */
    @PreAuthorize("@ss.hasPermi('web:configuration:edit')")
    @Log(title = "描述：生产流程配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PdProcessConfiguration pdProcessConfiguration) {
        return toAjax(pdProcessConfigurationService.updatePdProcessConfiguration(pdProcessConfiguration));
    }

    /**
     * 删除描述：生产流程配置
     */
    @PreAuthorize("@ss.hasPermi('web:configuration:remove')")
    @Log(title = "描述：生产流程配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(pdProcessConfigurationService.deletePdProcessConfigurationByIds(ids));
    }
}
