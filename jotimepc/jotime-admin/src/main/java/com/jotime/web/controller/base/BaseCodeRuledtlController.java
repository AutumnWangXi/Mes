package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.common.constant.CodeRuleConstants;
import com.jotime.web.domainVo.base.BaseCodeRuledtlVo;
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
import com.jotime.web.domain.base.BaseCodeRuledtl;
import com.jotime.web.service.base.IBaseCodeRuledtlService;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.common.core.page.TableDataInfo;

/**
 * 编码规则明细Controller
 * 
 * @author ruoyi
 * @date 2021-12-20
 */
@RestController
@RequestMapping("/web/base/ruledtl")
public class BaseCodeRuledtlController extends BaseController
{
    @Autowired
    private IBaseCodeRuledtlService baseCodeRuledtlService;

    /**
     * 查询编码规则明细列表
     */
    @PreAuthorize("@ss.hasPermi('base:ruledtl:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseCodeRuledtl baseCodeRuledtl)
    {
        startPage();
        List<BaseCodeRuledtlVo> list = baseCodeRuledtlService.selectBaseCodeRuledtlVoList(baseCodeRuledtl);
        return getDataTable(list);
    }

    /**
     * 查询编码规则明细列表
     */
    @PreAuthorize("@ss.hasPermi('base:ruledtl:listRuleCode')")
    @GetMapping("/listRuleCode")
    public AjaxResult listRuleCodeInfo(BaseCodeRuledtl baseCodeRuledtl)
    {
        return AjaxResult.success(baseCodeRuledtlService.selectBaseCodeRuledtlVoList(baseCodeRuledtl));
    }

    /**
     * 导出编码规则明细列表
     */
    @PreAuthorize("@ss.hasPermi('base:ruledtl:export')")
    @Log(title = "编码规则明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseCodeRuledtl baseCodeRuledtl)
    {
        List<BaseCodeRuledtlVo> list = baseCodeRuledtlService.selectBaseCodeRuledtlList(baseCodeRuledtl);
        ExcelUtil<BaseCodeRuledtlVo> util = new ExcelUtil(BaseCodeRuledtlVo.class);
        util.exportExcel(response, list, "编码规则明细数据");
    }

    /**
     * 获取编码规则明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:ruledtl:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(baseCodeRuledtlService.selectBaseCodeRuledtlById(id));
    }

    /**
     * 新增编码规则明细
     */
    @PreAuthorize("@ss.hasPermi('base:ruledtl:add')")
    @Log(title = "编码规则明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseCodeRuledtl baseCodeRuledtl)
    {
        return toAjax(baseCodeRuledtlService.insertBaseCodeRuledtl(baseCodeRuledtl));
    }

    /**
     * 修改编码规则明细
     */
    @PreAuthorize("@ss.hasPermi('base:ruledtl:edit')")
    @Log(title = "编码规则明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseCodeRuledtl baseCodeRuledtl)
    {
        return toAjax(baseCodeRuledtlService.updateBaseCodeRuledtl(baseCodeRuledtl));
    }

    /**
     * 删除编码规则明细
     */
    @PreAuthorize("@ss.hasPermi('base:ruledtl:remove')")
    @Log(title = "编码规则明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(baseCodeRuledtlService.deleteBaseCodeRuledtlByIds(ids));
    }
}
