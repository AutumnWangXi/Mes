package com.jotime.web.controller.file;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.file.FileManage;
import com.jotime.web.service.file.IFileManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 文件管理Controller
 *
 * @author ruoyi
 * @date 2021-12-23
 */
@RestController
@RequestMapping("/admin/manage")
public class FileManageController extends BaseController {
    @Autowired
    private IFileManageService fileManageService;

    /**
     * 查询文件管理列表
     */
//    @PreAuthorize("@ss.hasPermi('admin:manage:list')")
    @GetMapping("/list")
    public TableDataInfo list(FileManage fileManage) {
        startPage();
        List<FileManage> list = fileManageService.selectFileManageList(fileManage);
        return getDataTable(list);
    }

    /**
     * 导出文件管理列表
     */
    @PreAuthorize("@ss.hasPermi('admin:manage:export')")
    @Log(title = "文件管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FileManage fileManage) {
        List<FileManage> list = fileManageService.selectFileManageList(fileManage);
        ExcelUtil<FileManage> util = new ExcelUtil<FileManage>(FileManage.class);
        util.exportExcel(response, list, "文件管理数据");
    }

    /**
     * 获取文件管理详细信息
     */
//    @PreAuthorize("@ss.hasPermi('admin:manage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(fileManageService.selectFileManageById(id));
    }

    /**
     * 新增文件管理
     */
//    @PreAuthorize("@ss.hasPermi('admin:manage:add')")
    @Log(title = "文件管理", businessType = BusinessType.INSERT)
    @PostMapping("/saveFile")
    public AjaxResult add(@RequestBody FileManage fileManage) {
        return toAjax(fileManageService.insertFileManage(fileManage));
    }

    /**
     * 修改文件管理
     */
//    @PreAuthorize("@ss.hasPermi('admin:manage:edit')")
    @Log(title = "文件管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FileManage fileManage) {
        return toAjax(fileManageService.updateFileManage(fileManage));
    }

    /**
     * 删除文件管理
     */
//    @PreAuthorize("@ss.hasPermi('admin:manage:remove')")
    @Log(title = "文件管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(fileManageService.deleteFileManageByIds(ids));
    }

    /**
     * 删除文件管理
     */
//    @PreAuthorize("@ss.hasPermi('admin:manage:updateFileManage')")
    @Log(title = "根据url修改数据", businessType = BusinessType.UPDATE)
    @PostMapping("/updateFileManage")
    public AjaxResult updateFileManage(@RequestBody List<FileManage> fileManages) {
        fileManageService.updateFileManage(fileManages);
        return AjaxResult.success();
    }

    /**
     * 删除文件管理
     */
//    @PreAuthorize("@ss.hasPermi('admin:manage:updateFileManage')")
    @Log(title = "根据url修改数据", businessType = BusinessType.UPDATE)
    @PostMapping("/removeFileManageData")
    public AjaxResult removeFileData(@RequestBody FileManage fileManage) {
        fileManageService.removeFileData(fileManage);
        return AjaxResult.success();
    }

    /**
     * 删除文件管理
     */
//    @PreAuthorize("@ss.hasPermi('admin:manage:deleteFileByUrl')")
    @Log(title = "根据url修改数据", businessType = BusinessType.DELETE)
    @PostMapping("/deleteFileByUrl")
    public AjaxResult deleteFileByUrl(@RequestBody List<String> urlList) {
        if (!ObjectUtils.isEmpty(urlList)) {
            fileManageService.deleteFileByUrl(urlList);
        }
        return AjaxResult.success();
    }


}
