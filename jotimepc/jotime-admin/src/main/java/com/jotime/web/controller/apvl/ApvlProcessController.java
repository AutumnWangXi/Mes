package com.jotime.web.controller.apvl;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.Apvl.ApvlProcess;
import com.jotime.web.domainVo.apvl.ApvlProcessVo;
import com.jotime.web.service.Apvl.IApvlProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 审批流程配置Controller
 *
 * @author ruoyi
 * @date 2021-12-13
 */
@RestController
@RequestMapping("/web/apvl/process")
public class ApvlProcessController extends BaseController {


    @Autowired
    private IApvlProcessService apvlProcessService;
    /**
     * 查询审批流程记录列表
     */
//    @PreAuthorize("@ss.hasPermi('admin:process:list')")
    @GetMapping("/list")
    public TableDataInfo list(ApvlProcess apvlProces) {
        startPage();
        List<ApvlProcessVo> apvlProcesses = apvlProcessService.selectApvlProcessVoList(apvlProces);
        return getDataTable(apvlProcesses);
    }
    /**
     * 导出审批流程记录列表
     */
    @PreAuthorize("@ss.hasPermi('admin:process:export')")
    @Log(title = "审批流程记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ApvlProcess apvlProcess) {
        List<ApvlProcess> list = apvlProcessService.selectApvlProcessList(apvlProcess);
        ExcelUtil<ApvlProcess> util = new ExcelUtil<ApvlProcess>(ApvlProcess.class);
        util.exportExcel(response, list, "审批流程记录数据");
    }

    /**
     * 获取审批流程记录详细信息
     */
//    @PreAuthorize("@ss.hasPermi('admin:process:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(apvlProcessService.selectApvlProcessById(id));
    }

    /**
     * 新增审批流程记录
     */
    @PreAuthorize("@ss.hasPermi('admin:process:add')")
    @Log(title = "审批流程记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ApvlProcess apvlProcess) {
        apvlProcess.setCreateBy(getUsername());
        return toAjax(apvlProcessService.insertApvlProcess(apvlProcess));
    }

    /**
     * 修改审批流程记录
     */
    @PreAuthorize("@ss.hasPermi('admin:process:edit')")
    @Log(title = "审批流程记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ApvlProcess apvlProcess) {
        apvlProcess.setUpdateBy(getUsername());
        return toAjax(apvlProcessService.updateApvlProcess(apvlProcess));
    }

    /**
     * 删除审批流程记录
     */
    @PreAuthorize("@ss.hasPermi('admin:process:remove')")
    @Log(title = "审批流程记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        return toAjax(apvlProcessService.deleteApvlProcessByIds(ids));
    }

    /**
     * 根据审批编号查询记录和审批人
     *
     * @param apvlNo 审批编号
     * @return 审批人列表
     */
    @GetMapping("/getApvlProcessList/{apvlNo}")
    @ResponseBody
    public AjaxResult getApvlProcessList(@PathVariable("apvlNo") String apvlNo) {
        return apvlProcessService.getApvlProcessList(apvlNo);
    }
}
