package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.web.domainVo.base.BaseCodeRuleVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.enums.BusinessType;
import com.jotime.web.domain.base.BaseCodeRule;
import com.jotime.web.service.base.IBaseCodeRuleService;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.common.core.page.TableDataInfo;

/**
 * 编码规则Controller
 * 
 * @author ruoyi
 * @date 2021-12-20
 */
@RestController
@RequestMapping("/web/base/rule")
public class BaseCodeRuleController extends BaseController
{
    @Autowired
    private IBaseCodeRuleService baseCodeRuleService;

    /**
     * 查询编码规则列表
     */
    @PreAuthorize("@ss.hasPermi('base:rule:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseCodeRule baseCodeRule) throws Exception
    {
        startPage();
        List<BaseCodeRuleVo> list = baseCodeRuleService.selectBaseCodeRuleList(baseCodeRule);
        return getDataTable(list);
    }

    /**
     * 导出编码规则列表
     */
    @PreAuthorize("@ss.hasPermi('base:rule:export')")
    @Log(title = "编码规则", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseCodeRule baseCodeRule)
    {
        List<BaseCodeRuleVo> list = baseCodeRuleService.selectBaseCodeRuleList(baseCodeRule);
        ExcelUtil<BaseCodeRuleVo> util = new ExcelUtil(BaseCodeRuleVo.class);
        util.exportExcel(response, list, "编码规则数据");
    }

    /**
     * 获取编码规则详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:rule:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(baseCodeRuleService.selectBaseCodeRuleById(id));
    }

    /**
     * 新增编码规则
     */
    @PreAuthorize("@ss.hasPermi('base:rule:add')")
    @Log(title = "编码规则", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseCodeRule baseCodeRule)
    {
        return toAjax(baseCodeRuleService.insertBaseCodeRule(baseCodeRule));
    }

    /**
     * 修改编码规则
     */
    @PreAuthorize("@ss.hasPermi('base:rule:edit')")
    @Log(title = "编码规则", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseCodeRule baseCodeRule)
    {
        return toAjax(baseCodeRuleService.updateBaseCodeRule(baseCodeRule));
    }

    /**
     * 删除编码规则
     */
    @PreAuthorize("@ss.hasPermi('base:rule:remove')")
    @Log(title = "编码规则", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(baseCodeRuleService.deleteBaseCodeRuleByIds(ids));
    }
}
