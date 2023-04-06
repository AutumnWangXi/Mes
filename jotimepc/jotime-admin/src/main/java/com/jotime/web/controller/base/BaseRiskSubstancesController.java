package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseRiskSubstances;
import com.jotime.web.service.base.IBaseRiskSubstancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 安全性风险物质危害识别Controller
 *
 * @author yunmoqian
 * @date 2022-04-21
 */
@RestController
@RequestMapping("/web/substances")
public class BaseRiskSubstancesController extends BaseController
{
    @Autowired
    private IBaseRiskSubstancesService baseRiskSubstancesService;

    /**
     * 查询安全性风险物质危害识别列表
     */
    @PreAuthorize("@ss.hasPermi('web:substances:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseRiskSubstances baseRiskSubstances)
    {
        startPage();
        List<BaseRiskSubstances> list = baseRiskSubstancesService.selectBaseRiskSubstancesList(baseRiskSubstances);
        return getDataTable(list);
    }

    /**
     * 导出安全性风险物质危害识别列表
     */
    @PreAuthorize("@ss.hasPermi('web:substances:export')")
    @Log(title = "安全性风险物质危害识别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseRiskSubstances baseRiskSubstances)
    {
        List<BaseRiskSubstances> list = baseRiskSubstancesService.selectBaseRiskSubstancesList(baseRiskSubstances);
        ExcelUtil<BaseRiskSubstances> util = new ExcelUtil<BaseRiskSubstances>(BaseRiskSubstances.class);
        util.exportExcel(response, list, "安全性风险物质危害识别数据");
    }

    /**
     * 获取安全性风险物质危害识别详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:substances:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseRiskSubstancesService.selectBaseRiskSubstancesById(id));
    }

    /**
     * 新增安全性风险物质危害识别
     */
    @PreAuthorize("@ss.hasPermi('web:substances:add')")
    @Log(title = "安全性风险物质危害识别", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseRiskSubstances baseRiskSubstances)
    {
        return toAjax(baseRiskSubstancesService.insertBaseRiskSubstances(baseRiskSubstances));
    }

    /**
     * 修改安全性风险物质危害识别
     */
    @PreAuthorize("@ss.hasPermi('web:substances:edit')")
    @Log(title = "安全性风险物质危害识别", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseRiskSubstances baseRiskSubstances)
    {
        return toAjax(baseRiskSubstancesService.updateBaseRiskSubstances(baseRiskSubstances));
    }

    /**
     * 删除安全性风险物质危害识别
     */
    @PreAuthorize("@ss.hasPermi('web:substances:remove')")
    @Log(title = "安全性风险物质危害识别", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseRiskSubstancesService.deleteBaseRiskSubstancesByIds(ids));
    }
    /**
     * @Description: 导入下载模板
     * @Author: YunFei
     * @Date: 2022/4/15 15:21
     */
    @PostMapping("/importTemplate")
    public void importConsumableTemplate(HttpServletResponse response) throws Exception {
        ExcelUtil<BaseRiskSubstances> util = new ExcelUtil(BaseRiskSubstances.class);
        util.importTemplateExcel(response, "导入数据");
    }

    /**
     * @Description: 导入
     * @Author: YunFei
     * @Date: 2022/4/15 15:21
     */
    @Log(title = "安全风险物质识别", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<BaseRiskSubstances> util = new ExcelUtil(BaseRiskSubstances.class);
        List<BaseRiskSubstances> baseRiskSubstancesList = util.importExcel(file.getInputStream());
        int message = baseRiskSubstancesService.importData(baseRiskSubstancesList, updateSupport);
        return AjaxResult.success(message);
    }
}
