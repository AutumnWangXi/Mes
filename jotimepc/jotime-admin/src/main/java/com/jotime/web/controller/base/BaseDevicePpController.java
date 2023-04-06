package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.common.annotation.RepeatSubmit;
import com.jotime.web.domain.base.BaseDevicePp;
import com.jotime.web.domainVo.base.BaseDevicePpVo;
import com.jotime.web.service.base.IBaseDevicePpService;
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

import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.common.core.page.TableDataInfo;

/**
 * 设备工艺参数Controller
 *
 * @author ruoyi
 * @date 2022-03-17
 */
@RestController
@RequestMapping("/web/devicepp")
public class BaseDevicePpController extends BaseController
{
    @Autowired
    private IBaseDevicePpService baseDevicePpService;

    /**
     * 查询设备工艺参数列表
     */
    @PreAuthorize("@ss.hasPermi('web:devicepp:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseDevicePp baseDevicePp)
    {
        startPage();
        List<BaseDevicePp> list = baseDevicePpService.selectBaseDevicePpList(baseDevicePp);
        return getDataTable(list);
    }
    /**
     * 查询设备工艺参数列表
     */
    @PreAuthorize("@ss.hasPermi('web:devicepp:list')")
    @GetMapping("/listVo")
    public TableDataInfo listVo(BaseDevicePp baseDevicePp)
    {
        startPage();
        List<BaseDevicePpVo> list = baseDevicePpService.selectBaseDevicePpVoList(baseDevicePp);
        return getDataTable(list);
    }
    /**
     * 导出设备工艺参数列表
     */
    @PreAuthorize("@ss.hasPermi('web:devicepp:export')")
    @Log(title = "设备工艺参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseDevicePp baseDevicePp)
    {
        List<BaseDevicePp> list = baseDevicePpService.selectBaseDevicePpList(baseDevicePp);
        ExcelUtil<BaseDevicePp> util = new ExcelUtil<BaseDevicePp>(BaseDevicePp.class);
        util.exportExcel(response, list, "设备工艺参数数据");
    }

    /**
     * 获取设备工艺参数详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:devicepp:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseDevicePpService.selectBaseDevicePpById(id));
    }

    /**
     * 新增设备工艺参数
     */
    @PreAuthorize("@ss.hasPermi('web:devicepp:add')")
    @Log(title = "设备工艺参数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseDevicePp baseDevicePp)
    {
        return toAjax(baseDevicePpService.insertBaseDevicePp(baseDevicePp));
    }

    /**
     * 修改设备工艺参数
     */
    @PreAuthorize("@ss.hasPermi('web:devicepp:edit')")
    @Log(title = "设备工艺参数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseDevicePp baseDevicePp)
    {
        return toAjax(baseDevicePpService.updateBaseDevicePp(baseDevicePp));
    }

    /**
     * 删除设备工艺参数
     */
    @PreAuthorize("@ss.hasPermi('web:devicepp:remove')")
    @Log(title = "设备工艺参数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseDevicePpService.deleteBaseDevicePpByIds(ids));
    }

    /**
     * 新增设备工艺参数和详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:devicepp:add')")
    @Log(title = "设备工艺参数", businessType = BusinessType.INSERT)
    @RepeatSubmit(interval = 3000, message = "请求过于频繁")
    @PostMapping("/addDeviceppAndDtl")
    public AjaxResult addAndDtl(@RequestBody BaseDevicePpVo baseDevicePp)
    {
        if (baseDevicePp.getBaseDevicePpdtls()==null||baseDevicePp.getBaseDevicePpdtls().size()==0)return AjaxResult.error("请选择工艺");
        int i = baseDevicePpService.insertBaseDevicePpdtl(baseDevicePp);
        if (i==-1){
            return AjaxResult.error("请输入工艺组名称");
        }
        return toAjax(i);
    }
}
