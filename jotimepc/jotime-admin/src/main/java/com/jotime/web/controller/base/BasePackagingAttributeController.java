package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BasePackagingAttribute;
import com.jotime.web.service.base.IBasePackagingAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 包材属性Controller
 * 
 * @author ruoyi
 * @date 2021-12-27
 */
@RestController
@RequestMapping("/web/base/attribute")
public class BasePackagingAttributeController extends BaseController
{
    @Autowired
    private IBasePackagingAttributeService basePackagingAttributeService;

    /**
     * 查询包材属性列表
     */
    @PreAuthorize("@ss.hasPermi('admin:attribute:list')")
    @GetMapping("/list")
    public TableDataInfo list(BasePackagingAttribute basePackagingAttribute)
    {
        startPage();
        List<BasePackagingAttribute> list = basePackagingAttributeService.selectBasePackagingAttributeList(basePackagingAttribute);
        return getDataTable(list);
    }

    /**
     * 导出包材属性列表
     */
    @PreAuthorize("@ss.hasPermi('admin:attribute:export')")
    @Log(title = "包材属性", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BasePackagingAttribute basePackagingAttribute)
    {
        List<BasePackagingAttribute> list = basePackagingAttributeService.selectBasePackagingAttributeList(basePackagingAttribute);
        ExcelUtil<BasePackagingAttribute> util = new ExcelUtil<BasePackagingAttribute>(BasePackagingAttribute.class);
        util.exportExcel(response, list, "包材属性数据");
    }

    /**
     * 获取包材属性详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:attribute:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(basePackagingAttributeService.selectBasePackagingAttributeById(id));
    }

    /**
     * 新增包材属性
     */
    @PreAuthorize("@ss.hasPermi('admin:attribute:add')")
    @Log(title = "包材属性", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BasePackagingAttribute basePackagingAttribute)
    {
        return toAjax(basePackagingAttributeService.insertBasePackagingAttribute(basePackagingAttribute));
    }

    /**
     * 修改包材属性
     */
    @PreAuthorize("@ss.hasPermi('admin:attribute:edit')")
    @Log(title = "包材属性", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BasePackagingAttribute basePackagingAttribute)
    {
        return toAjax(basePackagingAttributeService.updateBasePackagingAttribute(basePackagingAttribute));
    }

    /**
     * 删除包材属性
     */
    @PreAuthorize("@ss.hasPermi('admin:attribute:remove')")
    @Log(title = "包材属性", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(basePackagingAttributeService.deleteBasePackagingAttributeByIds(ids));
    }
}
