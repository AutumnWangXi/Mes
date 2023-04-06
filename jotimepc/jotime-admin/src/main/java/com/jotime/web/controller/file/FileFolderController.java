package com.jotime.web.controller.file;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.file.FileFolder;
import com.jotime.web.service.file.IFileFolderService;
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
 * 文件夹名Controller
 * 
 * @author yunmoqian
 * @date 2022-08-11
 */
@RestController
@RequestMapping("/web/folder")
public class FileFolderController extends BaseController
{
    @Autowired
    private IFileFolderService fileFolderService;

    /**
     * 查询文件夹名列表
     */
    @PreAuthorize("@ss.hasPermi('web:folder:list')")
    @GetMapping("/list")
    public TableDataInfo list(FileFolder fileFolder)
    {
        startPage();
        List<FileFolder> list = fileFolderService.selectFileFolderList(fileFolder);
        return getDataTable(list);
    }

    /**
     * 导出文件夹名列表
     */
    @PreAuthorize("@ss.hasPermi('web:folder:export')")
    @Log(title = "文件夹名", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FileFolder fileFolder)
    {
        List<FileFolder> list = fileFolderService.selectFileFolderList(fileFolder);
        ExcelUtil<FileFolder> util = new ExcelUtil<FileFolder>(FileFolder.class);
        util.exportExcel(response, list, "文件夹名数据");
    }

    /**
     * 获取文件夹名详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:folder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(fileFolderService.selectFileFolderById(id));
    }

    /**
     * 新增文件夹名
     */
    @PreAuthorize("@ss.hasPermi('web:folder:add')")
    @Log(title = "文件夹名", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FileFolder fileFolder)
    {
        int i = fileFolderService.insertFileFolder(fileFolder);
        if(i>0){
            return AjaxResult.success(fileFolder);
        }else{
            return AjaxResult.error();
        }

    }

    /**
     * 修改文件夹名
     */
    @PreAuthorize("@ss.hasPermi('web:folder:edit')")
    @Log(title = "文件夹名", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FileFolder fileFolder)
    {
        return toAjax(fileFolderService.updateFileFolder(fileFolder));
    }

    /**
     * 删除文件夹名
     */
    @PreAuthorize("@ss.hasPermi('web:folder:remove')")
    @Log(title = "文件夹名", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fileFolderService.deleteFileFolderByIds(ids));
    }

    /**
     * 查询目录tree数据结构
     * @date 2022/8/11 15:29
     * @author zhengsijie
     * @param fileFolder
     * @return com.jotime.common.core.domain.AjaxResult
     */
    @PreAuthorize("@ss.hasPermi('web:folder:list')")
    @GetMapping("/getTree")
    public AjaxResult getTree(FileFolder fileFolder)
    {
        return  AjaxResult.success(fileFolderService.getTree(fileFolder));
    }

}
