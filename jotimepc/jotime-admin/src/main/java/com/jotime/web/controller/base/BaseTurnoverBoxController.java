package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseTurnoverBox;
import com.jotime.web.service.base.IBaseTurnoverBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 周转箱Controller
 *
 * @author ruoyi
 * @date 2022-01-13
 */
@RestController
@RequestMapping("/web/base/turnoverbox")
public class BaseTurnoverBoxController extends BaseController
{
    @Autowired
    private IBaseTurnoverBoxService baseTurnoverBoxService;

    /**
     * 查询周转箱列表
     */
    @PreAuthorize("@ss.hasPermi('admin:turnoverbox:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseTurnoverBox baseTurnoverBox)
    {
        startPage();
        List<BaseTurnoverBox> list = baseTurnoverBoxService.selectBaseTurnoverBoxList(baseTurnoverBox);
        return getDataTable(list);
    }

    /**
     * 导出周转箱列表
     */
    @PreAuthorize("@ss.hasPermi('admin:turnoverbox:export')")
    @Log(title = "周转箱", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseTurnoverBox baseTurnoverBox)
    {
        List<BaseTurnoverBox> list = baseTurnoverBoxService.selectBaseTurnoverBoxList(baseTurnoverBox);
        ExcelUtil<BaseTurnoverBox> util = new ExcelUtil<BaseTurnoverBox>(BaseTurnoverBox.class);
        util.exportExcel(response, list, "周转箱数据");
    }

    /**
     * 获取周转箱详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:turnoverbox:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseTurnoverBoxService.selectBaseTurnoverBoxById(id));
    }

    /**
     * 新增周转箱
     */
    @PreAuthorize("@ss.hasPermi('admin:turnoverbox:add')")
    @Log(title = "周转箱", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseTurnoverBox baseTurnoverBox)
    {
        return baseTurnoverBoxService.insertBaseTurnoverBox(baseTurnoverBox);
    }

    /**
     * 修改周转箱
     */
    @PreAuthorize("@ss.hasPermi('admin:turnoverbox:edit')")
    @Log(title = "周转箱", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseTurnoverBox baseTurnoverBox)
    {

        return baseTurnoverBoxService.updateBaseTurnoverBox(baseTurnoverBox);
    }

    /**
     * 删除周转箱
     */
    @PreAuthorize("@ss.hasPermi('admin:turnoverbox:remove')")
    @Log(title = "周转箱", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseTurnoverBoxService.deleteBaseTurnoverBoxByIds(ids));
    }

    /**
     * 查询周转箱列表
     */
//    @PreAuthorize("@ss.hasPermi('admin:turnoverbox:listBox')")
    @GetMapping("/listBox")
    public AjaxResult listBox(BaseTurnoverBox baseTurnoverBox)
    {
        return baseTurnoverBoxService.selectBaseTurnoverBoxListBox(baseTurnoverBox);
    }
}
