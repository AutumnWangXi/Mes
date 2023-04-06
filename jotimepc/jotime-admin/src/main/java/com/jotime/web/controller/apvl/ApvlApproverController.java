package com.jotime.web.controller.apvl;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.Apvl.ApvlApprover;
import com.jotime.web.domain.Apvl.ApvlProcessNode;
import com.jotime.web.domainVo.apvl.ApvlApproverVo;
import com.jotime.web.service.Apvl.IApvlApproverService;
import com.jotime.web.service.Apvl.IApvlProcessNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 审批人员Controller
 *
 * @author ruoyi
 * @date 2021-12-26
 */
@RestController
@RequestMapping("/web/apvl/approver")
public class ApvlApproverController extends BaseController
{
    @Autowired
    private IApvlApproverService apvlApproverService;

    @Autowired
    private IApvlProcessNodeService apvlProcessNodeService;
    /**
     * 查询审批人员列表
     */
    @PreAuthorize("@ss.hasPermi('admin:approver:list')")
    @GetMapping("/list")
    public TableDataInfo list(ApvlApprover apvlApprover)
    {
        startPage();
        return getDataTable(apvlApproverService.selectApvlApproverVoList(apvlApprover));
    }

    /**
     * 导出审批人员列表
     */
    @PreAuthorize("@ss.hasPermi('admin:approver:export')")
    @Log(title = "审批人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ApvlApprover apvlApprover)
    {
        List<ApvlApprover> list = apvlApproverService.selectApvlApproverList(apvlApprover);
        ExcelUtil<ApvlApprover> util = new ExcelUtil<ApvlApprover>(ApvlApprover.class);
        util.exportExcel(response, list, "审批人员数据");
    }

    /**
     * 获取审批人员详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:approver:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        AjaxResult success = AjaxResult.success();
        ApvlApprover apvlApprover = apvlApproverService.selectApvlApproverById(id);
        success.put(AjaxResult.DATA_TAG,apvlApprover);
        ApvlProcessNode apvlProcessNode = new ApvlProcessNode();
        apvlProcessNode.setModuleId(apvlApprover.getModuleId());
        apvlProcessNode.setIsProposer(1L);
        apvlProcessNode.setStatus(2);
        success.put("nodeOption",apvlProcessNodeService.selectApvlProcessNodeList(apvlProcessNode));
        return success ;
    }




    /**
     * 新增审批人员
     */
    @PreAuthorize("@ss.hasPermi('admin:approver:add')")
    @Log(title = "审批人员", businessType = BusinessType.INSERT)
    @PostMapping
    @Transactional
    public AjaxResult add(@RequestBody ApvlApproverVo apvlApprover)
    {
        return toAjax(apvlApproverService.insertApvlApproverVo(apvlApprover,getUsername()));
    }

    /**
     * 修改审批人员
     */
    @PreAuthorize("@ss.hasPermi('admin:approver:edit')")
    @Log(title = "审批人员", businessType = BusinessType.UPDATE)
    @PutMapping
    @Transactional
    public AjaxResult edit(@RequestBody ApvlApproverVo apvlApprover)
    {
        return toAjax(apvlApproverService.updateApvlApproverVo(apvlApprover,getUsername()));
    }

    /**
     * 删除审批人员
     */
    @PreAuthorize("@ss.hasPermi('admin:approver:remove')")
    @Log(title = "审批人员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(apvlApproverService.deleteApvlApproverByIds(ids));
    }
}
