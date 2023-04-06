package com.jotime.web.controller.pd;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.pd.PdNodeWorkshop;
import com.jotime.web.domainVo.pd.PdNodeWorkshopVo;
import com.jotime.web.service.pd.IPdNodeWorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 描述：生产节点所属车间Controller
 * 
 * @author yunmoqian
 * @date 2022-05-06
 */
@RestController
@RequestMapping("/web/pd/workshop")
public class PdNodeWorkshopController extends BaseController
{
    @Autowired
    private IPdNodeWorkshopService pdNodeWorkshopService;

    /**
     * 查询描述：生产节点所属车间列表
     */
    @PreAuthorize("@ss.hasPermi('web:workshop:list')")
    @GetMapping("/list")
    public TableDataInfo list(PdNodeWorkshop pdNodeWorkshop)
    {
        startPage();
        List<PdNodeWorkshop> list = pdNodeWorkshopService.selectPdNodeWorkshopList(pdNodeWorkshop);
        return getDataTable(list);
    }

    /**
     * 查询描述：生产节点所属车间列表
     */
    @PreAuthorize("@ss.hasPermi('web:workshop:list')")
    @GetMapping("/dataList")
    public TableDataInfo list(PdNodeWorkshopVo pdNodeWorkshopVo)
    {
        startPage();
        List<PdNodeWorkshopVo> list = pdNodeWorkshopService.selectPdNodeWorkshopVoList(pdNodeWorkshopVo);
        return getDataTable(list);
    }

    /**
     * 导出描述：生产节点所属车间列表
     */
    @PreAuthorize("@ss.hasPermi('web:workshop:export')")
    @Log(title = "描述：生产节点所属车间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PdNodeWorkshop pdNodeWorkshop)
    {
        List<PdNodeWorkshop> list = pdNodeWorkshopService.selectPdNodeWorkshopList(pdNodeWorkshop);
        ExcelUtil<PdNodeWorkshop> util = new ExcelUtil<PdNodeWorkshop>(PdNodeWorkshop.class);
        util.exportExcel(response, list, "描述：生产节点所属车间数据");
    }

    /**
     * 获取描述：生产节点所属车间详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:workshop:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(pdNodeWorkshopService.selectPdNodeWorkshopById(id));
    }

    /**
     * 新增描述：生产节点所属车间
     */
    @PreAuthorize("@ss.hasPermi('web:workshop:add')")
    @Log(title = "描述：生产节点所属车间", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PdNodeWorkshop pdNodeWorkshop)
    {
        return toAjax(pdNodeWorkshopService.insertPdNodeWorkshop(pdNodeWorkshop));
    }

    /**
     * 修改描述：生产节点所属车间
     */
    @PreAuthorize("@ss.hasPermi('web:workshop:edit')")
    @Log(title = "描述：生产节点所属车间", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PdNodeWorkshop pdNodeWorkshop)
    {
        return toAjax(pdNodeWorkshopService.updatePdNodeWorkshop(pdNodeWorkshop));
    }

    /**
     * 删除描述：生产节点所属车间
     */
    @PreAuthorize("@ss.hasPermi('web:workshop:remove')")
    @Log(title = "描述：生产节点所属车间", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pdNodeWorkshopService.deletePdNodeWorkshopByIds(ids));
    }
}
