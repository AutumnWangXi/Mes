package com.jotime.web.controller.base;

import javax.servlet.http.HttpServletResponse;

import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseItemNetcontent;
import com.jotime.web.service.base.IBaseItemNetcontentService;
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
import com.jotime.common.core.page.TableDataInfo;

import java.util.List;

/**
 * 描述：成品净含量Controller
 *
 * @author yunmoqian
 * @date 2022-05-07
 */
@RestController
@RequestMapping("/web/netcontent")
public class BaseItemNetcontentController extends BaseController
{
    @Autowired
    private IBaseItemNetcontentService baseItemNetcontentService;

    /**
     * 查询描述：成品净含量列表
     */
    @PreAuthorize("@ss.hasPermi('web:netcontent:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseItemNetcontent baseItemNetcontent)
    {
        startPage();
        List<BaseItemNetcontent> list = baseItemNetcontentService.selectBaseItemNetcontentList(baseItemNetcontent);
        return getDataTable(list);
    }

    /**
     * 导出描述：成品净含量列表
     */
    @PreAuthorize("@ss.hasPermi('web:netcontent:export')")
    @Log(title = "描述：成品净含量", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseItemNetcontent baseItemNetcontent)
    {
        List<BaseItemNetcontent> list = baseItemNetcontentService.selectBaseItemNetcontentList(baseItemNetcontent);
        ExcelUtil<BaseItemNetcontent> util = new ExcelUtil<BaseItemNetcontent>(BaseItemNetcontent.class);
        util.exportExcel(response, list, "描述：成品净含量数据");
    }

    /**
     * 获取描述：成品净含量详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:netcontent:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseItemNetcontentService.selectBaseItemNetcontentById(id));
    }

    /**
     * 新增描述：成品净含量
     */
    @PreAuthorize("@ss.hasPermi('web:netcontent:add')")
    @Log(title = "描述：成品净含量", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseItemNetcontent baseItemNetcontent)
    {
        return toAjax(baseItemNetcontentService.insertBaseItemNetcontent(baseItemNetcontent));
    }

    /**
     * 修改描述：成品净含量
     */
    @PreAuthorize("@ss.hasPermi('web:netcontent:edit')")
    @Log(title = "描述：成品净含量", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseItemNetcontent baseItemNetcontent)
    {
        return toAjax(baseItemNetcontentService.updateBaseItemNetcontent(baseItemNetcontent));
    }

    /**
     * 删除描述：成品净含量
     */
    @PreAuthorize("@ss.hasPermi('web:netcontent:remove')")
    @Log(title = "描述：成品净含量", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseItemNetcontentService.deleteBaseItemNetcontentByIds(ids));
    }
}
