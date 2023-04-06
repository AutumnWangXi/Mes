package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseDevice;
import com.jotime.web.domainVo.base.BaseDeviceVos;
import com.jotime.web.domainVo.excel.BaseDeviceExlVo;
import com.jotime.web.service.base.IBaseDeviceService;
import com.jotime.web.service.base.IBaseLineService;
import com.jotime.web.service.base.IBaseWorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 设备信息Controller
 *
 * @author ruoyi
 * @date 2021-12-30
 */
@RestController
@RequestMapping("/web/base/device")
public class BaseDeviceController extends BaseController {
    @Autowired
    private IBaseDeviceService baseDeviceService;
    @Autowired
    private IBaseWorkshopService iBaseWorkshopService;
    @Autowired
    private IBaseLineService iBaseLineService;

    /**
     * 查询设备信息列表
     */
    @PreAuthorize("@ss.hasPermi('base:device:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseDevice baseDevice) {
        startPage();
        List<BaseDevice> list = baseDeviceService.selectBaseDeviceList(baseDevice);
        return getDataTable(list);
    }

    /**
     * 查询设备信息列表
     */
    @PreAuthorize("@ss.hasPermi('base:device:list')")
    @GetMapping("/listVo")
    public TableDataInfo listVo(BaseDevice baseDevice) {
        startPage();
        List<BaseDeviceVos> list = baseDeviceService.selectBaseDeviceVoList(baseDevice);
        return getDataTable(list);
    }

    //设备导入下载模板
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws Exception {
        ExcelUtil<BaseDeviceExlVo> util = new ExcelUtil(BaseDeviceExlVo.class);
        util.importTemplateExcel(response, "导入数据");
    }

   //设备导入
    @Log(title = "设备管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
//    @RepeatSubmit(interval = 30000, message = "5分钟内已导入过，请稍后再试")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<BaseDeviceExlVo> util = new ExcelUtil(BaseDeviceExlVo.class);
        List<BaseDeviceExlVo> baseDeviceExlVos = util.importExcel(file.getInputStream());
        int message = baseDeviceService.importData(baseDeviceExlVos, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 查询所有设备信息列表
     */
//    @PreAuthorize("@ss.hasPermi('base:device:list')")
    @GetMapping("/listAll")
    public AjaxResult listAll(BaseDevice baseDevice) {
        List<BaseDevice> list = baseDeviceService.selectBaseDeviceList(baseDevice);
        return AjaxResult.success(list);
    }


    /**
     * 导出设备信息列表
     */
    @PreAuthorize("@ss.hasPermi('base:device:export')")
    @Log(title = "设备信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseDevice baseDevice) {
        List<BaseDevice> list = baseDeviceService.selectBaseDeviceList(baseDevice);
        ExcelUtil<BaseDevice> util = new ExcelUtil<BaseDevice>(BaseDevice.class);
        util.exportExcel(response, list, "设备信息数据");
    }

    /**
     * 获取设备信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:device:query')")
    @GetMapping(value = {"/", "/{id}"})
    public AjaxResult getInfo(@PathVariable(value = "id", required = false) Long id) {
        return AjaxResult.success(AjaxResult.DATA_TAG, baseDeviceService.selectBaseDeviceById(id));
    }

    /**
     * 新增设备信息
     */
    @PreAuthorize("@ss.hasPermi('base:device:add')")
    @Log(title = "设备信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseDevice baseDevice) {
        baseDevice.setCreateBy(getUsername());
        if (baseDeviceService.insertBaseDevice(baseDevice) > 0) {
            return toAjax(1);
        }
        return AjaxResult.error("新增失败！设备编码（" + baseDevice.getDeviceCode() + "）已经存在");
    }

    /**
     * 修改设备信息
     */
    @PreAuthorize("@ss.hasPermi('base:device:edit')")
    @Log(title = "设备信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseDevice baseDevice) {
        if (baseDeviceService.updateBaseDevice(baseDevice) == 0)
            return AjaxResult.error("修改失败！设备编码（" + baseDevice.getDeviceCode() + "）已经存在");
        return toAjax(1);
    }

    /**
     * 删除设备信息
     */
    @PreAuthorize("@ss.hasPermi('base:device:remove')")
    @Log(title = "设备信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(baseDeviceService.deleteBaseDeviceByIds(ids));
    }

    /**
     * id 设备组id
     * 查询设备组设备信息列表
     */
    @PreAuthorize("@ss.hasPermi('base:device:list')")
    @GetMapping("/selectGroupDevice/{id}")
    public AjaxResult selectGroupDevice(@PathVariable Long id) {
        List<BaseDevice> list = baseDeviceService.selectGroupDevice(id);
        return AjaxResult.success(list);
    }

    /**
     * 根据流水线号查询对应的所有设备
     */
//    @PreAuthorize("@ss.hasPermi('base:device:selectAllByLineCode')")
    @GetMapping("/selectAllByLineCode")
    public AjaxResult selectAllByLineCode(@RequestParam(required = false) String lineCode) {
        List<BaseDevice> list = baseDeviceService.selectAllByLineCode(lineCode);
        return AjaxResult.success(list);
    }


}
