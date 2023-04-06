package com.jotime.web.controller.file;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.file.FileListManage;
import com.jotime.web.service.file.IFileListManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 描述：文件清单管理Controller
 *
 * @author yunmoqian
 * @date 2022-04-22
 */
@RestController
@RequestMapping("/web/fileListManage")
public class FileListManageController extends BaseController
{
    @Autowired
    private IFileListManageService fileListManageService;

    /**
     * 查询描述：文件清单管理列表
     */
    @PreAuthorize("@ss.hasPermi('web:fileListManage:list')")
    @GetMapping("/list")
    public TableDataInfo list(FileListManage fileListManage)
    {
        startPage();
        List<FileListManage> list = fileListManageService.selectFileListManageList(fileListManage);
        return getDataTable(list);
    }

    /**
     * 导出描述：文件清单管理列表
     */
    @PreAuthorize("@ss.hasPermi('web:fileListManage:export')")
    @Log(title = "描述：文件清单管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FileListManage fileListManage)
    {
        List<FileListManage> list = fileListManageService.selectFileListManageList(fileListManage);
        ExcelUtil<FileListManage> util = new ExcelUtil<FileListManage>(FileListManage.class);
        util.exportExcel(response, list, "描述：文件清单管理数据");
    }

    /**
     * 获取描述：文件清单管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:fileListManage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(fileListManageService.selectFileListManageById(id));
    }

    /**
     * 新增描述：文件清单管理
     */
    @PreAuthorize("@ss.hasPermi('web:fileListManage:add')")
    @Log(title = "描述：文件清单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FileListManage fileListManage)
    {
        return fileListManageService.insertFileListManage(fileListManage);
    }

    /**
     * 修改描述：文件清单管理
     */
    @PreAuthorize("@ss.hasPermi('web:fileListManage:edit')")
    @Log(title = "描述：文件清单管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FileListManage fileListManage)
    {
        return toAjax(fileListManageService.updateFileListManage(fileListManage));
    }

    /**
     * 删除描述：文件清单管理
     */
    @PreAuthorize("@ss.hasPermi('web:fileListManage:remove')")
    @Log(title = "描述：文件清单管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fileListManageService.deleteFileListManageByIds(ids));
    }

    /**
     * @Description: 文件清单导入下载模板
     * @Author: YunFei
     * @Date: 2022/4/15 15:21
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws Exception {
        ExcelUtil<FileListManage> util = new ExcelUtil(FileListManage.class);
        util.importTemplateExcel(response, "文件清单导入数据");
    }

    /**
     * @Description: 文件清单导入
     * @Author: YunFei
     * @Date: 2022/4/15 15:21
     */
    @Log(title = "文件清单管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<FileListManage> util = new ExcelUtil(FileListManage.class);
        List<FileListManage> fileListManages = util.importExcel(file.getInputStream());
        int message = fileListManageService.importData(fileListManages);
        return AjaxResult.success(message);
    }
}
