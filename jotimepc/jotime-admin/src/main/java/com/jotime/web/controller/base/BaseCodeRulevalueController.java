package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.web.domainVo.base.BaseCodeRulevalueVo;
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
import com.jotime.web.domain.base.BaseCodeRulevalue;
import com.jotime.web.service.base.IBaseCodeRulevalueService;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.common.core.page.TableDataInfo;

/**
 * 编码规则当前值Controller
 * 
 * @author ruoyi
 * @date 2021-12-20
 */
@RestController
@RequestMapping("/web/base/rulevalue")
public class BaseCodeRulevalueController extends BaseController
{
    @Autowired
    private IBaseCodeRulevalueService baseCodeRulevalueService;

    /**
     * 查询编码规则当前值列表
     */
    @PreAuthorize("@ss.hasPermi('base:rulevalue:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseCodeRulevalue baseCodeRulevalue)
    {
        startPage();
        List<BaseCodeRulevalueVo> list = baseCodeRulevalueService.selectBaseCodeRulevalueList(baseCodeRulevalue);
        return getDataTable(list);
    }

    /**
     * 导出编码规则当前值列表
     */
    @PreAuthorize("@ss.hasPermi('base:rulevalue:export')")
    @Log(title = "编码规则当前值", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseCodeRulevalue baseCodeRulevalue)
    {
        List<BaseCodeRulevalueVo> list = baseCodeRulevalueService.selectBaseCodeRulevalueList(baseCodeRulevalue);
        ExcelUtil<BaseCodeRulevalueVo> util = new ExcelUtil<BaseCodeRulevalueVo>(BaseCodeRulevalueVo.class);
        util.exportExcel(response, list, "编码规则当前值数据");
    }

    /**
     * 获取编码规则当前值详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:rulevalue:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(baseCodeRulevalueService.selectBaseCodeRulevalueById(id));
    }

    /**
     * 新增编码规则当前值
     */
    @PreAuthorize("@ss.hasPermi('base:rulevalue:add')")
    @Log(title = "编码规则当前值", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseCodeRulevalue baseCodeRulevalue)
    {
        return toAjax(baseCodeRulevalueService.insertBaseCodeRulevalue(baseCodeRulevalue));
    }

    /**
     * 修改编码规则当前值
     */
    @PreAuthorize("@ss.hasPermi('base:rulevalue:edit')")
    @Log(title = "编码规则当前值", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseCodeRulevalue baseCodeRulevalue)
    {
        return toAjax(baseCodeRulevalueService.updateBaseCodeRulevalue(baseCodeRulevalue));
    }

    /**
     * 删除编码规则当前值
     */
    @PreAuthorize("@ss.hasPermi('base:rulevalue:remove')")
    @Log(title = "编码规则当前值", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(baseCodeRulevalueService.deleteBaseCodeRulevalueByIds(ids));
    }
}
