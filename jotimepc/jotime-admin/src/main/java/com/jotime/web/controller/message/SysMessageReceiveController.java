package com.jotime.web.controller.message;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.message.SysMessageReceive;
import com.jotime.web.service.message.ISysMessageReceiveService;
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
 * 站内信消息状态Controller
 * 
 * @author yunmoqian
 * @date 2022-04-15
 */
@RestController
@RequestMapping("/web/msgreceive")
public class SysMessageReceiveController extends BaseController
{
    @Autowired
    private ISysMessageReceiveService sysMessageReceiveService;

    /**
     * 查询站内信消息状态列表
     */
    @PreAuthorize("@ss.hasPermi('web:magreceive:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysMessageReceive sysMessageReceive)
    {
        startPage();
        List<SysMessageReceive> list = sysMessageReceiveService.selectSysMessageReceiveList(sysMessageReceive);
        return getDataTable(list);
    }

    /**
     * 导出站内信消息状态列表
     */
    @PreAuthorize("@ss.hasPermi('web:magreceive:export')")
    @Log(title = "站内信消息状态", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysMessageReceive sysMessageReceive)
    {
        List<SysMessageReceive> list = sysMessageReceiveService.selectSysMessageReceiveList(sysMessageReceive);
        ExcelUtil<SysMessageReceive> util = new ExcelUtil<SysMessageReceive>(SysMessageReceive.class);
        util.exportExcel(response, list, "站内信消息状态数据");
    }

    /**
     * 获取站内信消息状态详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:magreceive:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysMessageReceiveService.selectSysMessageReceiveById(id));
    }

    /**
     * 新增站内信消息状态
     */
    @PreAuthorize("@ss.hasPermi('web:magreceive:add')")
    @Log(title = "站内信消息状态", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysMessageReceive sysMessageReceive)
    {
        return toAjax(sysMessageReceiveService.insertSysMessageReceive(sysMessageReceive));
    }

    /**
     * 修改站内信消息状态
     */
    @PreAuthorize("@ss.hasPermi('web:magreceive:edit')")
    @Log(title = "站内信消息状态", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysMessageReceive sysMessageReceive)
    {
        return toAjax(sysMessageReceiveService.updateSysMessageReceive(sysMessageReceive));
    }

    /**
     * 删除站内信消息状态
     */
    @PreAuthorize("@ss.hasPermi('web:magreceive:remove')")
    @Log(title = "站内信消息状态", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysMessageReceiveService.deleteSysMessageReceiveByIds(ids));
    }
}
