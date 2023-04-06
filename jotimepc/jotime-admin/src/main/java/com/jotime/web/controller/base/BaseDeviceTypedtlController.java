package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.web.domain.base.BaseDeviceTypedtl;
import com.jotime.web.service.base.IBaseDeviceTypedtlService;
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
 * 设备类型详细Controller
 *
 * @author ruoyi
 * @date 2022-03-02
 */
@RestController
@RequestMapping("/web/deviceTypedtl")
public class BaseDeviceTypedtlController extends BaseController
{
    @Autowired
    private IBaseDeviceTypedtlService baseDeviceTypedtlService;

    /**
     * 查询设备类型详细列表
     */
    @PreAuthorize("@ss.hasPermi('web:deviceTypedtl:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseDeviceTypedtl baseDeviceTypedtl)
    {
        startPage();
        List<BaseDeviceTypedtl> list = baseDeviceTypedtlService.selectBaseDeviceTypedtlList(baseDeviceTypedtl);
        return getDataTable(list);
    }

    /**
     * 导出设备类型详细列表
     */
    @PreAuthorize("@ss.hasPermi('web:deviceTypedtl:export')")
    @Log(title = "设备类型详细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseDeviceTypedtl baseDeviceTypedtl)
    {
        List<BaseDeviceTypedtl> list = baseDeviceTypedtlService.selectBaseDeviceTypedtlList(baseDeviceTypedtl);
        ExcelUtil<BaseDeviceTypedtl> util = new ExcelUtil<BaseDeviceTypedtl>(BaseDeviceTypedtl.class);
        util.exportExcel(response, list, "设备类型详细数据");
    }

    /**
     * 获取设备类型详细详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:deviceTypedtl:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(baseDeviceTypedtlService.selectBaseDeviceTypedtlById(id));
    }

    /**
     * 新增设备类型详细
     */
    @PreAuthorize("@ss.hasPermi('web:deviceTypedtl:add')")
    @Log(title = "设备类型详细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseDeviceTypedtl baseDeviceTypedtl)
    {
        int i = baseDeviceTypedtlService.insertBaseDeviceTypedtl(baseDeviceTypedtl);
        if (i==-1){
            return AjaxResult.error("该类型键值已经存在！");
        }
        return toAjax(i);
    }

    /**
     * 修改设备类型详细
     */
    @PreAuthorize("@ss.hasPermi('web:deviceTypedtl:edit')")
    @Log(title = "设备类型详细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseDeviceTypedtl baseDeviceTypedtl)
    {
        return toAjax(baseDeviceTypedtlService.updateBaseDeviceTypedtl(baseDeviceTypedtl));
    }

    /**
     * 删除设备类型详细
     */
    @PreAuthorize("@ss.hasPermi('web:deviceTypedtl:remove')")
    @Log(title = "设备类型详细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(baseDeviceTypedtlService.deleteBaseDeviceTypedtlByIds(ids));
    }

    /**
     * 查询设备大分类对应的可用设备详细列表
     */
    @PreAuthorize("@ss.hasPermi('web:deviceTypedtl:list')")
    @GetMapping("/detailedList/{deviceType}")
    public AjaxResult detailedList(@PathVariable String deviceType)
    {
        return AjaxResult.success(baseDeviceTypedtlService.selectBaseDeviceTypedtlDetailedListList(deviceType));
    }
}
