package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.web.domain.base.BaseProcessparam;
import com.jotime.web.service.base.IBaseProcessparamService;
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
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.common.core.page.TableDataInfo;

/**
 * 设备工艺参数Controller
 *
 * @author ruoyi
 * @date 2022-03-18
 */
@RestController
@RequestMapping("/web/processparam")
public class BaseProcessparamController extends BaseController
{
    @Autowired
    private IBaseProcessparamService baseProcessparamService;

    /**
     * 查询设备工艺参数列表
     */
    @PreAuthorize("@ss.hasPermi('web:processparam:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseProcessparam baseProcessparam)
    {
        startPage();
        List<BaseProcessparam> list = baseProcessparamService.selectBaseProcessparamList(baseProcessparam);
        return getDataTable(list);
    }

    /**
     * 导出设备工艺参数列表
     */
    @PreAuthorize("@ss.hasPermi('web:processparam:export')")
    @Log(title = "设备工艺参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseProcessparam baseProcessparam)
    {
        List<BaseProcessparam> list = baseProcessparamService.selectBaseProcessparamList(baseProcessparam);
        ExcelUtil<BaseProcessparam> util = new ExcelUtil<BaseProcessparam>(BaseProcessparam.class);
        util.exportExcel(response, list, "设备工艺参数数据");
    }

    /**
     * 获取设备工艺参数详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:processparam:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(baseProcessparamService.selectBaseProcessparamById(id));
    }

    /**
     * 新增设备工艺参数
     */
    @PreAuthorize("@ss.hasPermi('web:processparam:add')")
    @Log(title = "设备工艺参数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseProcessparam baseProcessparam)
    {
        int i = baseProcessparamService.insertBaseProcessparam(baseProcessparam);
//        -1是值重复的情况
        if (i==-1){
          return   AjaxResult.error("工艺参数值重复，请重新填写");
        }
        return toAjax(i);
    }

    /**
     * 修改设备工艺参数
     */
    @PreAuthorize("@ss.hasPermi('web:processparam:edit')")
    @Log(title = "设备工艺参数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseProcessparam baseProcessparam)
    {
        int i = baseProcessparamService.updateBaseProcessparam(baseProcessparam);
//        -1是值重复的情况
        if (i==-1){
            return AjaxResult.error("工艺参数值重复，请重新填写");
        }
        return toAjax(i);
    }

    /**
     * 删除设备工艺参数
     */
    @PreAuthorize("@ss.hasPermi('web:processparam:remove')")
    @Log(title = "设备工艺参数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(baseProcessparamService.deleteBaseProcessparamByIds(ids));
    }
}
