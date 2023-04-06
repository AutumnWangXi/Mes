package com.jotime.web.controller.pd;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.pd.PdProcessNode;
import com.jotime.web.domainVo.pd.PdProcessNodeVo;
import com.jotime.web.service.pd.IPdProcessNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 描述：生产流程节点Controller
 * 
 * @author yunmoqian
 * @date 2022-05-06
 */
@RestController
@RequestMapping("/web/pd/node")
public class PdProcessNodeController extends BaseController
{
    @Autowired
    private IPdProcessNodeService pdProcessNodeService;

    /**
     * 查询描述：生产流程节点列表
     */
    @PreAuthorize("@ss.hasPermi('web:node:list')")
    @GetMapping("/list")
    public TableDataInfo list(PdProcessNode pdProcessNode)
    {
        startPage();
        List<PdProcessNode> list = pdProcessNodeService.selectPdProcessNodeList(pdProcessNode);
        return getDataTable(list);
    }

    /**
     * 查询描述：生产流程节点列表
     */
    @PreAuthorize("@ss.hasPermi('web:node:list')")
    @GetMapping("/dataList")
    public TableDataInfo list(PdProcessNodeVo pdProcessNodeVo)
    {
        startPage();
        List<PdProcessNodeVo> list = pdProcessNodeService.selectPdProcessNodeVoList(pdProcessNodeVo);
        return getDataTable(list);
    }

    /**
     * 导出描述：生产流程节点列表
     */
    @PreAuthorize("@ss.hasPermi('web:node:export')")
    @Log(title = "描述：生产流程节点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PdProcessNode pdProcessNode)
    {
        List<PdProcessNode> list = pdProcessNodeService.selectPdProcessNodeList(pdProcessNode);
        ExcelUtil<PdProcessNode> util = new ExcelUtil<PdProcessNode>(PdProcessNode.class);
        util.exportExcel(response, list, "描述：生产流程节点数据");
    }

    /**
     * 获取描述：生产流程节点详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:node:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(pdProcessNodeService.selectPdProcessNodeById(id));
    }

    /**
     * 新增描述：生产流程节点
     */
    @PreAuthorize("@ss.hasPermi('web:node:add')")
    @Log(title = "描述：生产流程节点", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PdProcessNode pdProcessNode)
    {
        return toAjax(pdProcessNodeService.insertPdProcessNode(pdProcessNode));
    }

    /**
     * 修改描述：生产流程节点
     */
    @PreAuthorize("@ss.hasPermi('web:node:edit')")
    @Log(title = "描述：生产流程节点", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PdProcessNode pdProcessNode)
    {
        return toAjax(pdProcessNodeService.updatePdProcessNode(pdProcessNode));
    }

    /**
     * 删除描述：生产流程节点
     */
    @PreAuthorize("@ss.hasPermi('web:node:remove')")
    @Log(title = "描述：生产流程节点", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pdProcessNodeService.deletePdProcessNodeByIds(ids));
    }
}
