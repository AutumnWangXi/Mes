package com.jotime.web.controller.message;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.message.SysMessage;
import com.jotime.web.service.message.ISysMessageService;
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
 * 站内信消息内容Controller
 * 
 * @author yunmoqian
 * @date 2022-04-15
 */
@RestController
@RequestMapping("/web/message")
public class SysMessageController extends BaseController
{
    @Autowired
    private ISysMessageService sysMessageService;

    /**
     * 查询站内信消息内容列表
     */
    @PreAuthorize("@ss.hasPermi('web:message:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysMessage sysMessage)
    {
        startPage();
        List<SysMessage> list = sysMessageService.selectSysMessageList(sysMessage);
        return getDataTable(list);
    }
    /**
     * 查询站内信消息内容列表
     */
//    @PreAuthorize("@ss.hasPermi('web:message:list')")
    @GetMapping("/listCount")
    public AjaxResult listCount(SysMessage sysMessage)
    {
        return AjaxResult.success(sysMessageService.selectSysMessageListCount(sysMessage));
    }

    /**
     * 导出站内信消息内容列表
     */
    @PreAuthorize("@ss.hasPermi('web:message:export')")
    @Log(title = "站内信消息内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysMessage sysMessage)
    {
        List<SysMessage> list = sysMessageService.selectSysMessageList(sysMessage);
        ExcelUtil<SysMessage> util = new ExcelUtil<SysMessage>(SysMessage.class);
        util.exportExcel(response, list, "站内信消息内容数据");
    }

    /**
     * 获取站内信消息内容详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:message:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysMessageService.selectSysMessageById(id));
    }

    /**
     * 新增站内信消息内容
     */
    @PreAuthorize("@ss.hasPermi('web:message:add')")
    @Log(title = "站内信消息内容", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysMessage sysMessage)
    {
        return toAjax(sysMessageService.insertSysMessage(sysMessage));
    }

    /**
     * 修改站内信消息内容
     */
    @PreAuthorize("@ss.hasPermi('web:message:edit')")
    @Log(title = "站内信消息内容", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysMessage sysMessage)
    {
        return toAjax(sysMessageService.updateSysMessage(sysMessage));
    }

    /**
     * 删除站内信消息内容
     */
    @PreAuthorize("@ss.hasPermi('web:message:remove')")
    @Log(title = "站内信消息内容", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysMessageService.deleteSysMessageByIds(ids));
    }
}
