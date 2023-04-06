package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseLine;
import com.jotime.web.domainVo.base.BaseLineVo;
import com.jotime.web.service.base.IBaseLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 流水线信息Controller
 *
 * @author ruoyi
 * @date 2022-03-16
 */
@RestController
@RequestMapping("/web/line")
public class BaseLineController extends BaseController
{
    @Autowired
    private IBaseLineService baseLineService;

    /**
     * 查询流水线信息列表
     */
    @PreAuthorize("@ss.hasPermi('web:line:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseLine baseLine)
    {
        startPage();
        List<BaseLine> list = baseLineService.selectBaseLineList(baseLine);
        return getDataTable(list);
    }

    /**
     * 导出流水线信息列表
     */
    @PreAuthorize("@ss.hasPermi('web:line:export')")
    @Log(title = "流水线信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseLine baseLine)
    {
        List<BaseLine> list = baseLineService.selectBaseLineList(baseLine);
        ExcelUtil<BaseLine> util = new ExcelUtil<BaseLine>(BaseLine.class);
        util.exportExcel(response, list, "流水线信息数据");
    }

    /**
     * 获取流水线信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:line:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseLineService.selectBaseLineById(id));
    }

    /**
     * 新增流水线信息
     */
    @PreAuthorize("@ss.hasPermi('web:line:add')")
    @Log(title = "流水线信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseLine baseLine)
    {
        int i = baseLineService.insertBaseLine(baseLine);
        if (i==0){
            return AjaxResult.error("该编码已经存在！");
        }
        return toAjax(i);
    }

    /**
     * 修改流水线信息
     */
    @PreAuthorize("@ss.hasPermi('web:line:edit')")
    @Log(title = "流水线信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseLine baseLine)
    {
        return toAjax(baseLineService.updateBaseLine(baseLine));
    }

    /**
     * 删除流水线信息
     */
    @PreAuthorize("@ss.hasPermi('web:line:remove')")
    @Log(title = "流水线信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseLineService.deleteBaseLineByIds(ids));
    }
    /**
     * 查询流水线信息列表
     */
    @PreAuthorize("@ss.hasPermi('web:line:listVo')")
    @GetMapping("/listVo")
    public TableDataInfo listVo(BaseLine baseLine)
    {
        startPage();
        List<BaseLineVo> list = baseLineService.selectBaseLineVoList(baseLine);
        return getDataTable(list);
    }


    /**
     * 流水线下拉框
     */
//    @PreAuthorize("@ss.hasPermi('web:line:list')")
    @GetMapping("/lineList")
    public AjaxResult lineList()
    {
        return AjaxResult.success(baseLineService.lineList());
    }
}
