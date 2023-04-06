package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.web.domain.base.BaseDevicePpdtl;
import com.jotime.web.domainVo.base.BaseDevicePpdtlVo;
import com.jotime.web.service.base.IBaseDevicePpdtlService;
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
 * @date 2022-03-17
 */
@RestController
@RequestMapping("/web/deviceppdtl")
public class BaseDevicePpdtlController extends BaseController
{
    @Autowired
    private IBaseDevicePpdtlService baseDevicePpdtlService;

    /**
     * 查询设备工艺参数列表
     */
    @PreAuthorize("@ss.hasPermi('web:deviceppdtl:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseDevicePpdtl baseDevicePpdtl)
    {
        startPage();
        List<BaseDevicePpdtl> list = baseDevicePpdtlService.selectBaseDevicePpdtlList(baseDevicePpdtl);
        return getDataTable(list);
    }

    /**
     * 查询全部工艺参数
     * @param baseDevicePpdtl
     * @return
     */
    @GetMapping("/listall")
    public TableDataInfo listAll(BaseDevicePpdtl baseDevicePpdtl)
    {
        List<BaseDevicePpdtlVo> list = baseDevicePpdtlService.selectBaseDevicePpdtlVoList(baseDevicePpdtl);
        return getDataTable(list);
    }

    /**
     * 导出设备工艺参数列表
     */
    @PreAuthorize("@ss.hasPermi('web:deviceppdtl:export')")
    @Log(title = "设备工艺参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseDevicePpdtl baseDevicePpdtl)
    {
        List<BaseDevicePpdtl> list = baseDevicePpdtlService.selectBaseDevicePpdtlList(baseDevicePpdtl);
        ExcelUtil<BaseDevicePpdtl> util = new ExcelUtil<BaseDevicePpdtl>(BaseDevicePpdtl.class);
        util.exportExcel(response, list, "设备工艺参数数据");
    }

    /**
     * 获取设备工艺参数详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:deviceppdtl:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseDevicePpdtlService.selectBaseDevicePpdtlById(id));
    }

    /**
     * 新增设备工艺参数
     */
    @PreAuthorize("@ss.hasPermi('web:deviceppdtl:add')")
    @Log(title = "设备工艺参数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseDevicePpdtl baseDevicePpdtl)
    {
        return toAjax(baseDevicePpdtlService.insertBaseDevicePpdtl(baseDevicePpdtl));
    }

    /**
     * 修改设备工艺参数
     */
    @PreAuthorize("@ss.hasPermi('web:deviceppdtl:edit')")
    @Log(title = "设备工艺参数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseDevicePpdtl baseDevicePpdtl)
    {
        return toAjax(baseDevicePpdtlService.updateBaseDevicePpdtl(baseDevicePpdtl));
    }

    /**
     * 删除设备工艺参数
     */
    @PreAuthorize("@ss.hasPermi('web:deviceppdtl:remove')")
    @Log(title = "设备工艺参数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseDevicePpdtlService.deleteBaseDevicePpdtlByIds(ids));
    }
    /**
     * 查询设备工艺参数列表
     */
    @PreAuthorize("@ss.hasPermi('web:deviceppdtl:list')")
    @GetMapping("/listVo")
    public TableDataInfo listVo(BaseDevicePpdtl baseDevicePpdtl)
    {
        startPage();
        List<BaseDevicePpdtlVo> list = baseDevicePpdtlService.selectBaseDevicePpdtlVoList(baseDevicePpdtl);
        return getDataTable(list);
    }
}
