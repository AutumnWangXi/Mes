package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseDevicePortconnLog;
import com.jotime.web.service.base.IBaseDevicePortconnLogService;
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
 * 设备端口连接日志Controller
 *
 * @author yunmoqian
 * @date 2022-11-25
 */
@RestController
@RequestMapping("/web/deviceportlog")
public class BaseDevicePortconnLogController extends BaseController
{
    @Autowired
    private IBaseDevicePortconnLogService baseDevicePortconnLogService;

    /**
     * 查询设备端口连接日志列表
     */
    @PreAuthorize("@ss.hasPermi('web:log:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseDevicePortconnLog baseDevicePortconnLog)
    {
        startPage();
        List<BaseDevicePortconnLog> list = baseDevicePortconnLogService.selectBaseDevicePortconnLogList(baseDevicePortconnLog);
        return getDataTable(list);
    }

    /**
     * 导出设备端口连接日志列表
     */
    @PreAuthorize("@ss.hasPermi('web:log:export')")
    @Log(title = "设备端口连接日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseDevicePortconnLog baseDevicePortconnLog)
    {
        List<BaseDevicePortconnLog> list = baseDevicePortconnLogService.selectBaseDevicePortconnLogList(baseDevicePortconnLog);
        ExcelUtil<BaseDevicePortconnLog> util = new ExcelUtil<BaseDevicePortconnLog>(BaseDevicePortconnLog.class);
        util.exportExcel(response, list, "设备端口连接日志数据");
    }

    /**
     * 获取设备端口连接日志详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:log:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseDevicePortconnLogService.selectBaseDevicePortconnLogById(id));
    }

    /**
     * 新增设备端口连接日志
     */
    @PreAuthorize("@ss.hasPermi('web:log:add')")
    @Log(title = "设备端口连接日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseDevicePortconnLog baseDevicePortconnLog)
    {
        return toAjax(baseDevicePortconnLogService.insertBaseDevicePortconnLog(baseDevicePortconnLog));
    }

    /**
     * 修改设备端口连接日志
     */
    @PreAuthorize("@ss.hasPermi('web:log:edit')")
    @Log(title = "设备端口连接日志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseDevicePortconnLog baseDevicePortconnLog)
    {
        return toAjax(baseDevicePortconnLogService.updateBaseDevicePortconnLog(baseDevicePortconnLog));
    }

    /**
     * 删除设备端口连接日志
     */
    @PreAuthorize("@ss.hasPermi('web:log:remove')")
    @Log(title = "设备端口连接日志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseDevicePortconnLogService.deleteBaseDevicePortconnLogByIds(ids));
    }
}
