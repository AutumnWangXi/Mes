package com.jotime.web.controller.apvl;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.Apvl.ApvlProcessNode;
import com.jotime.web.service.Apvl.IApvlProcessNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 审批流程节点Controller
 *
 * @author ruoyi
 * @date 2021-12-26
 */
@RestController
@RequestMapping("/admin/node")
public class ApvlProcessNodeController extends BaseController
{
    @Autowired
    private IApvlProcessNodeService apvlProcessNodeService;

    /**
     * 查询审批流程节点列表
     */
//    @PreAuthorize("@ss.hasPermi('admin:node:list')")
    @GetMapping("/list")
    public TableDataInfo list(ApvlProcessNode apvlProcessNode)
    {
        startPage();
        return getDataTable(apvlProcessNodeService.selectApvlProcessNodeVoList(apvlProcessNode));
    }

    /**
     * 导出审批流程节点列表
     */
    @PreAuthorize("@ss.hasPermi('admin:node:export')")
    @Log(title = "审批流程节点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ApvlProcessNode apvlProcessNode)
    {
        List<ApvlProcessNode> list = apvlProcessNodeService.selectApvlProcessNodeList(apvlProcessNode);
        ExcelUtil<ApvlProcessNode> util = new ExcelUtil<ApvlProcessNode>(ApvlProcessNode.class);
        util.exportExcel(response, list, "审批流程节点数据");
    }

    /**
     * 获取审批流程节点详细信息
     */
//    @PreAuthorize("@ss.hasPermi('admin:node:query')")
    @GetMapping("/{id}" )
    public AjaxResult getInfo(@PathVariable(value = "id") Long id)
    {
        return AjaxResult.success(apvlProcessNodeService.selectApvlProcessNodeById(id));
    }

    /**
     * 新增审批流程节点
     */
    @PreAuthorize("@ss.hasPermi('admin:node:add')")
    @Log(title = "审批流程节点", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ApvlProcessNode apvlProcessNode)
    {
        return toAjax(apvlProcessNodeService.insertApvlProcessNode(apvlProcessNode));
    }

    /**
     * 修改审批流程节点
     */
    @PreAuthorize("@ss.hasPermi('admin:node:edit')")
    @Log(title = "审批流程节点", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ApvlProcessNode apvlProcessNode)
    {
        apvlProcessNode.setUpdateBy(getUsername());
        return toAjax(apvlProcessNodeService.updateApvlProcessNode(apvlProcessNode));
    }

    /**
     * 删除审批流程节点
     */
    @PreAuthorize("@ss.hasPermi('admin:node:remove')")
    @Log(title = "审批流程节点", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(apvlProcessNodeService.deleteApvlProcessNodeByIds(ids));
    }

    /**
     * 获取流程对应节点列表
     * @param isProposer 是否申请人，1，不是，2，是
     */
    @GetMapping(value = "/getNodeList/{moduleId}/{isProposer}")
    public AjaxResult getNodeList(@PathVariable("moduleId") Long moduleId,@PathVariable("isProposer")Integer isProposer)
    {
        AjaxResult ajax = AjaxResult.success();
        return ajax.put("nodeOptions",apvlProcessNodeService.getNodeList(moduleId,isProposer));
    }
}
