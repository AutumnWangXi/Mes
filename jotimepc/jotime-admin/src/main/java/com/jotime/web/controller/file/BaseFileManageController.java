package com.jotime.web.controller.file;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseFileManage;
import com.jotime.web.service.base.IBaseFileManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 描述  base文件管理Controller
 *
 * @author ruoyi
 * @date 2022-02-16
 */
@RestController
@RequestMapping("/web/base/manage")
public class BaseFileManageController extends BaseController
{
    @Autowired
    private IBaseFileManageService baseFileManageService;

    /**
     * 查询描述  base文件管理列表
     */
    @PreAuthorize("@ss.hasPermi('web:manage:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseFileManage baseFileManage)
    {
        startPage();
        List<BaseFileManage> list = baseFileManageService.selectBaseFileManageList(baseFileManage);
        return getDataTable(list);
    }

    /**
     * 导出描述  base文件管理列表
     */
    @PreAuthorize("@ss.hasPermi('web:manage:export')")
    @Log(title = "描述  base文件管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseFileManage baseFileManage)
    {
        List<BaseFileManage> list = baseFileManageService.selectBaseFileManageList(baseFileManage);
        ExcelUtil<BaseFileManage> util = new ExcelUtil<BaseFileManage>(BaseFileManage.class);
        util.exportExcel(response, list, "描述  base文件管理数据");
    }

    /**
     * 获取描述  base文件管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:manage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseFileManageService.selectBaseFileManageById(id));
    }

    /**
     * 新增描述  base文件管理
     */
    @PreAuthorize("@ss.hasPermi('web:manage:add')")
    @Log(title = "描述  base文件管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseFileManage baseFileManage)
    {
        return toAjax(baseFileManageService.insertBaseFileManage(baseFileManage));
    }

    /**
     * 修改描述  base文件管理
     */
    @PreAuthorize("@ss.hasPermi('web:manage:edit')")
    @Log(title = "描述  base文件管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseFileManage baseFileManage)
    {
        return toAjax(baseFileManageService.updateBaseFileManage(baseFileManage));
    }

    /**
     * 删除描述  base文件管理
     */
    @PreAuthorize("@ss.hasPermi('web:manage:remove')")
    @Log(title = "描述  base文件管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseFileManageService.deleteBaseFileManageByIds(ids));
    }
    /**
     * 删除文件管理
     */
    @Log(title = "根据url修改数据", businessType = BusinessType.UPDATE)
    @PostMapping("/updateFileManage")
    public AjaxResult updateFileManage(@RequestBody List<BaseFileManage> fileManages) {
        baseFileManageService.updateFileManage(fileManages);
        return AjaxResult.success();
    }
    /**
     * 删除文件管理
     */
    @Log(title = "根据url修改数据", businessType = BusinessType.DELETE)
    @PostMapping("/deleteFileByUrl")
    public AjaxResult deleteFileByUrl(@RequestBody List<String> urlList) {
        if(!ObjectUtils.isEmpty(urlList)){
            baseFileManageService.deleteFileByUrl(urlList);
        }
        return AjaxResult.success();
    }
}
