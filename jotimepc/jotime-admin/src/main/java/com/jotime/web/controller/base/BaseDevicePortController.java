package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseDevicePort;
import com.jotime.web.service.base.IBaseDevicePortService;
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

/**
 * 设备端口信息Controller
 *
 * @author yunmoqian
 * @date 2022-11-25
 */
@RestController
@RequestMapping("/web/deviceport")
public class BaseDevicePortController extends BaseController
{
    @Autowired
    private IBaseDevicePortService baseDevicePortService;

    /**
     * 查询设备端口信息列表
     */
    @PreAuthorize("@ss.hasPermi('web:port:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseDevicePort baseDevicePort)
    {
        startPage();
        List<BaseDevicePort> list = baseDevicePortService.selectBaseDevicePortList(baseDevicePort);
        return getDataTable(list);
    }

    /**
     * 导出设备端口信息列表
     */
    @PreAuthorize("@ss.hasPermi('web:port:export')")
    @Log(title = "设备端口信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseDevicePort baseDevicePort)
    {
        List<BaseDevicePort> list = baseDevicePortService.selectBaseDevicePortList(baseDevicePort);
        ExcelUtil<BaseDevicePort> util = new ExcelUtil<BaseDevicePort>(BaseDevicePort.class);
        util.exportExcel(response, list, "设备端口信息数据");
    }

    /**
     * 获取设备端口信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:port:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseDevicePortService.selectBaseDevicePortById(id));
    }

    /**
     * 新增设备端口信息
     */
    @PreAuthorize("@ss.hasPermi('web:port:add')")
    @Log(title = "设备端口信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseDevicePort baseDevicePort)
    {
        int rows = baseDevicePortService.insertBaseDevicePort(baseDevicePort);
        if(rows == -1){
            return AjaxResult.error("设备编码重复");
        }
        return toAjax(rows);
    }

    /**
     * 修改设备端口信息
     */
    @PreAuthorize("@ss.hasPermi('web:port:edit')")
    @Log(title = "设备端口信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseDevicePort baseDevicePort)
    {
        int rows = baseDevicePortService.updateBaseDevicePort(baseDevicePort);
        if(rows == -1){
            return AjaxResult.error("设备编码重复");
        }
        return toAjax(rows);
    }

    /**
     * 删除设备端口信息
     */
    @PreAuthorize("@ss.hasPermi('web:port:remove')")
    @Log(title = "设备端口信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseDevicePortService.deleteBaseDevicePortByIds(ids));
    }
}
