package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseDeviceType;
import com.jotime.web.domainVo.excel.BaseDeviceTypeExlVo;
import com.jotime.web.service.base.IBaseDeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 设备类型Controller
 *
 * @author ruoyi
 * @date 2022-03-02
 */
@RestController
@RequestMapping("/web/deviceType")
public class BaseDeviceTypeController extends BaseController
{
    @Autowired
    private IBaseDeviceTypeService baseDeviceTypeService;

    /**
     * 查询设备类型列表
     */
    @PreAuthorize("@ss.hasPermi('web:deviceType:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseDeviceType baseDeviceType)
    {
        startPage();
        List<BaseDeviceType> list = baseDeviceTypeService.selectBaseDeviceTypeList(baseDeviceType);
        return getDataTable(list);
    }

    /**
     * @Description: 设备类型导入下载模板
     */
    @PostMapping("/import")
    public void importMaterialTemplate(HttpServletResponse response) throws Exception {
        ExcelUtil<BaseDeviceTypeExlVo> util = new ExcelUtil(BaseDeviceTypeExlVo.class);
        util.importTemplateExcel(response, "设备类型导入数据");
    }

    /**
     * @Description: 设备类型导入
     */
    @Log(title = "原料管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importMaterialData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<BaseDeviceTypeExlVo> util = new ExcelUtil(BaseDeviceTypeExlVo.class);
        List<BaseDeviceTypeExlVo> baseDeviceTypeExlVos = util.importExcelMerged("",file.getInputStream(),0,1);
        return baseDeviceTypeService.importData(baseDeviceTypeExlVos, updateSupport);
    }

    /**
     * 导出设备类型列表
     */
    @PreAuthorize("@ss.hasPermi('web:deviceType:export')")
    @Log(title = "设备类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseDeviceType baseDeviceType)
    {
        List<BaseDeviceType> list = baseDeviceTypeService.selectBaseDeviceTypeList(baseDeviceType);
        ExcelUtil<BaseDeviceType> util = new ExcelUtil<BaseDeviceType>(BaseDeviceType.class);
        util.exportExcel(response, list, "设备类型数据");
    }

    /**
     * 获取设备类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:deviceType:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseDeviceTypeService.selectBaseDeviceTypeById(id));
    }

    /**
     * 新增设备类型
     */
    @PreAuthorize("@ss.hasPermi('web:deviceType:add')")
    @Log(title = "设备类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseDeviceType baseDeviceType)
    {
        int i = baseDeviceTypeService.insertBaseDeviceType(baseDeviceType);
        if(i==-1){
            return AjaxResult.error("该设备类型已经存在！");
        }
        return toAjax(i);
    }

    /**
     * 修改设备类型
     */
    @PreAuthorize("@ss.hasPermi('web:deviceType:edit')")
    @Log(title = "设备类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseDeviceType baseDeviceType)
    {
        int i = baseDeviceTypeService.updateBaseDeviceType(baseDeviceType);
        if(i==-1){
            return AjaxResult.error("该设备类型已经存在！");
        }
        return toAjax(i);
    }

    /**
     * 删除设备类型
     */
    @PreAuthorize("@ss.hasPermi('web:deviceType:remove')")
    @Log(title = "设备类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseDeviceTypeService.deleteBaseDeviceTypeByIds(ids));
    }
    /**
     * 禁用设备类型
     */
    @PreAuthorize("@ss.hasPermi('web:deviceType:disable')")
    @PutMapping("/disable/{ids}")
    public AjaxResult disable(@PathVariable Long[] ids)
    {
        return toAjax(baseDeviceTypeService.disableBaseDeviceTypeByIds(ids));
    }
    /**
     * 查询可用设备类型列表
     */
    @PreAuthorize("@ss.hasPermi('web:deviceType:list')")
    @GetMapping("/availableList")
    public AjaxResult availableList()
    {
        return AjaxResult.success(baseDeviceTypeService.selectBaseDeviceTypeAvailableList());
    }
}
