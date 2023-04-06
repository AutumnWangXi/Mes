package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.StringUtils;
import com.jotime.web.domain.base.BaseDevice;
import com.jotime.web.domain.base.BaseWorkshop;
import com.jotime.web.mapper.base.BaseWorkshopMapper;
import com.jotime.web.service.base.IBaseWorkshopService;
import com.jotime.web.service.employee.IEmployeeInfoService;
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
import com.jotime.web.domain.base.BaseDeviceMaintaininfo;
import com.jotime.web.service.base.IBaseDeviceMaintaininfoService;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.common.core.page.TableDataInfo;

/**
 * 设备保养信息Controller
 *
 * @author ruoyi
 * @date 2021-12-30
 */
@RestController
@RequestMapping("/web/base/maintain")
public class BaseDeviceMaintaininfoController extends BaseController
{
    @Autowired
    private IBaseDeviceMaintaininfoService baseDeviceMaintaininfoService;
    /**
     * 查询设备保养信息列表
     */
    @PreAuthorize("@ss.hasPermi('base:maintain:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseDeviceMaintaininfo baseDeviceMaintaininfo)
    {
        startPage();
        List<BaseDeviceMaintaininfo> list = baseDeviceMaintaininfoService.selectBaseDeviceMaintaininfoList(baseDeviceMaintaininfo);
        return getDataTable(list);
    }

    /**
     * 导出设备保养信息列表
     */
    @PreAuthorize("@ss.hasPermi('base:maintain:export')")
    @Log(title = "设备保养信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseDeviceMaintaininfo baseDeviceMaintaininfo)
    {
        List<BaseDeviceMaintaininfo> list = baseDeviceMaintaininfoService.selectBaseDeviceMaintaininfoList(baseDeviceMaintaininfo);
        ExcelUtil<BaseDeviceMaintaininfo> util = new ExcelUtil<BaseDeviceMaintaininfo>(BaseDeviceMaintaininfo.class);
        util.exportExcel(response, list, "设备保养信息数据");
    }

    /**
     * 获取设备保养信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:maintain:query')")
    @GetMapping( "/{baseDeviceMaintaininfo}" )
    public AjaxResult getInfo(@PathVariable(value = "baseDeviceMaintaininfo") Long baseDeviceMaintaininfo)
    {
        return AjaxResult.success(baseDeviceMaintaininfoService.selectBaseDeviceMaintaininfoByBaseDeviceMaintaininfo(baseDeviceMaintaininfo));
    }

    /**
     * 新增设备保养信息
     */
    @PreAuthorize("@ss.hasPermi('base:maintain:add')")
    @Log(title = "设备保养信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseDeviceMaintaininfo baseDeviceMaintaininfo)
    {
        baseDeviceMaintaininfo.setCreateBy(getUsername());
        return toAjax(baseDeviceMaintaininfoService.insertBaseDeviceMaintaininfo(baseDeviceMaintaininfo));
    }
    /**
     * 修改设备保养信息
     */
    @PreAuthorize("@ss.hasPermi('base:maintain:edit')")
    @Log(title = "设备保养信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseDeviceMaintaininfo baseDeviceMaintaininfo)
    {
        baseDeviceMaintaininfo.setUpdateBy(getUsername());
       return toAjax(baseDeviceMaintaininfoService.updateBaseDeviceMaintaininfo(baseDeviceMaintaininfo));
    }

    /**
     * 删除设备保养信息
     */
    @PreAuthorize("@ss.hasPermi('base:maintain:remove')")
    @Log(title = "设备保养信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{baseDeviceMaintaininfos}")
    public AjaxResult remove(@PathVariable Long[] baseDeviceMaintaininfos)
    {
        return toAjax(baseDeviceMaintaininfoService.deleteBaseDeviceMaintaininfoByBaseDeviceMaintaininfos(baseDeviceMaintaininfos));
    }
}
