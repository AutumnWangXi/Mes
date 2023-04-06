package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseCir;
import com.jotime.web.service.base.IBaseCirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 美国CIR审查安全使用的化妆品原料Controller
 *
 * @author yunmoqian
 * @date 2022-04-21
 */
@RestController
@RequestMapping("/web/cir")
public class BaseCirController extends BaseController
{
    @Autowired
    private IBaseCirService baseCirService;

    /**
     * 查询美国CIR审查安全使用的化妆品原料列表
     */
    @PreAuthorize("@ss.hasPermi('web:cir:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseCir baseCir)
    {
        startPage();
        List<BaseCir> list = baseCirService.selectBaseCirList(baseCir);
        return getDataTable(list);
    }

    /**
     * 导出美国CIR审查安全使用的化妆品原料列表
     */
    @PreAuthorize("@ss.hasPermi('web:cir:export')")
    @Log(title = "美国CIR审查安全使用的化妆品原料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseCir baseCir)
    {
        List<BaseCir> list = baseCirService.selectBaseCirList(baseCir);
        ExcelUtil<BaseCir> util = new ExcelUtil<BaseCir>(BaseCir.class);
        util.exportExcel(response, list, "美国CIR审查安全使用的化妆品原料数据");
    }

    /**
     * 获取美国CIR审查安全使用的化妆品原料详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:cir:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseCirService.selectBaseCirById(id));
    }

    /**
     * 新增美国CIR审查安全使用的化妆品原料
     */
    @PreAuthorize("@ss.hasPermi('web:cir:add')")
    @Log(title = "美国CIR审查安全使用的化妆品原料", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseCir baseCir)
    {
        return toAjax(baseCirService.insertBaseCir(baseCir));
    }

    /**
     * 修改美国CIR审查安全使用的化妆品原料
     */
    @PreAuthorize("@ss.hasPermi('web:cir:edit')")
    @Log(title = "美国CIR审查安全使用的化妆品原料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseCir baseCir)
    {
        return toAjax(baseCirService.updateBaseCir(baseCir));
    }

    /**
     * 删除美国CIR审查安全使用的化妆品原料
     */
    @PreAuthorize("@ss.hasPermi('web:cir:remove')")
    @Log(title = "美国CIR审查安全使用的化妆品原料", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseCirService.deleteBaseCirByIds(ids));
    }

    /**
     * @Description: 导入下载模板
     * @Author: YunFei
     * @Date: 2022/4/15 15:21
     */
    @PostMapping("/importTemplate")
    public void importConsumableTemplate(HttpServletResponse response) throws Exception {
        ExcelUtil<BaseCir> util = new ExcelUtil(BaseCir.class);
        util.importTemplateExcel(response, "导入数据");
    }

    /**
     * @Description: 导入
     * @Author: YunFei
     * @Date: 2022/4/15 15:21
     */
    @Log(title = "cir管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<BaseCir> util = new ExcelUtil(BaseCir.class);
        List<BaseCir> baseCirList = util.importExcel(file.getInputStream());
        int message = baseCirService.importData(baseCirList, updateSupport);
        return AjaxResult.success(message);
    }
}
