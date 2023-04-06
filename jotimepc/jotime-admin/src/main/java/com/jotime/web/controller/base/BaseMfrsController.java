package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;


import com.jotime.common.constant.MfrsConstants;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.enums.BusinessType;
import com.jotime.web.domain.base.BaseMfrs;
import com.jotime.web.service.base.IBaseMfrsService;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.common.core.page.TableDataInfo;

/**
 * 制造商Controller
 *
 * @author ruoyi
 * @date 2021-12-30
 */
@RestController
@RequestMapping("/web/base/mfrs")
public class BaseMfrsController extends BaseController {

    @Autowired
    private IBaseMfrsService baseMfrsService;

    /**
     * 查询制造商列表
     */
    @PreAuthorize("@ss.hasPermi('base:mfrs:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseMfrs baseMfrs) {
        startPage();
        List<BaseMfrs> list = baseMfrsService.selectBaseMfrsList(baseMfrs);
        return getDataTable(list);
    }

    /**
     * 导出制造商列表
     */
    @PreAuthorize("@ss.hasPermi('base:mfrs:export')")
    @Log(title = "制造商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseMfrs baseMfrs) {
        List<BaseMfrs> list = baseMfrsService.selectBaseMfrsList(baseMfrs);
        ExcelUtil<BaseMfrs> util = new ExcelUtil<BaseMfrs>(BaseMfrs.class);
        util.exportExcel(response, list, "制造商数据");
    }

    /**
     * 获取制造商详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:mfrs:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(baseMfrsService.selectBaseMfrsById(id));
    }

    /**
     * 新增制造商
     */
    @PreAuthorize("@ss.hasPermi('base:mfrs:add')")
    @Log(title = "制造商", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseMfrs baseMfrs) {
        if (MfrsConstants.NOT_UNIQUE.equals(baseMfrsService.checkMfrsCodeUnique(baseMfrs))) {
            return AjaxResult.error("新增供应商'" + baseMfrs.getMfrsCode() + "'失败，生产商编码已经存在");
        }

        if (MfrsConstants.NOT_UNIQUE.equals(baseMfrsService.checkMfrsNameUnique(baseMfrs))) {
            return AjaxResult.error("新增供应商'" + baseMfrs.getMfrsName() + "'失败，生产商已经存在");
        }

        return toAjax(baseMfrsService.insertBaseMfrs(baseMfrs));
    }

    /**
     * 修改制造商
     */
    @PreAuthorize("@ss.hasPermi('base:mfrs:edit')")
    @Log(title = "制造商", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseMfrs baseMfrs) {
        if (MfrsConstants.UNIQUE.equals(baseMfrsService.checkUpMfrsIdUnique(baseMfrs))) {
            return AjaxResult.error("生产商'" + baseMfrs.getMfrsName() + "'失败，生产商已经被删除");
        }

        if (MfrsConstants.NOT_UNIQUE.equals(baseMfrsService.checkUpMfrsCodeUnique(baseMfrs))) {
            return AjaxResult.error("生产商'" + baseMfrs.getMfrsCode() + "'失败，生产商编号已经存在");
        }

        if (MfrsConstants.NOT_UNIQUE.equals(baseMfrsService.checkUpMfrsNameUnique(baseMfrs))) {
            return AjaxResult.error("生产商'" + baseMfrs.getMfrsName() + "'失败，生产商已经存在");
        }

        return toAjax(baseMfrsService.updateBaseMfrs(baseMfrs));
    }

    /**
     * 删除制造商
     */
    @PreAuthorize("@ss.hasPermi('base:mfrs:remove')")
    @Log(title = "制造商", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(baseMfrsService.deleteBaseMfrsByIds(ids));
    }

    /**
     * 获取制造商下拉框信息
     */
    @PreAuthorize("@ss.hasPermi('base:mfrs:optionsList')")
    @GetMapping(value = "/optionsList/{status}")
    public AjaxResult optionsList(@PathVariable("status") Long status) {
        BaseMfrs baseMfrs = new BaseMfrs();
        baseMfrs.setStatus(status.intValue());
        return AjaxResult.success(baseMfrsService.getMfrsOptionsList(baseMfrs));
    }

    /**
     * 查询所有制造商信息
     * @return 制造商信息
     */
    @GetMapping("/selectMfrsName")
    @ResponseBody
    public AjaxResult selectMfrsName() {
        List<BaseMfrs> baseMfrsList = baseMfrsService.selectMfrsName();
        return AjaxResult.success().put("value", baseMfrsList);
    }
}
