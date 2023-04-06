package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.common.constant.BrandConstants;
import com.jotime.common.constant.MfrsConstants;
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
import com.jotime.web.domain.base.BaseBrand;
import com.jotime.web.service.base.IBaseBrandService;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.common.core.page.TableDataInfo;

/**
 * 生产商品牌Controller
 * 
 * @author ruoyi
 * @date 2022-01-04
 */
@RestController
@RequestMapping("/web/base/brand")
public class BaseBrandController extends BaseController
{
    @Autowired
    private IBaseBrandService baseBrandService;

    /**
     * 查询品牌列表
     */
    @PreAuthorize("@ss.hasPermi('base:brand:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseBrand baseBrand)
    {
        startPage();
        List<BaseBrand> list = baseBrandService.selectBaseBrandVoList(baseBrand);
        return getDataTable(list);
    }

    /**
     * 导出品牌列表
     */
    @PreAuthorize("@ss.hasPermi('base:brand:export')")
    @Log(title = "生产商品牌", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseBrand baseBrand)
    {
        List<BaseBrand> list = baseBrandService.selectBaseBrandList(baseBrand);
        ExcelUtil<BaseBrand> util = new ExcelUtil<BaseBrand>(BaseBrand.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取生产商品牌详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:brand:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseBrandService.selectBaseBrandById(id));
    }

    /**
     * 新增生产商品牌
     */
    @PreAuthorize("@ss.hasPermi('base:brand:add')")
    @Log(title = "生产商品牌", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseBrand baseBrand)
    {

        if (BrandConstants.NOT_UNIQUE.equals(baseBrandService.checkBrandNameUnique(baseBrand))) {
            return AjaxResult.error("新增品牌'" + baseBrand.getBrandName() + "'失败，品牌已经存在");
        }

        return toAjax(baseBrandService.insertBaseBrand(baseBrand));
    }

    /**
     * 修改生产商品牌信息
     */
    @PreAuthorize("@ss.hasPermi('base:brand:edit')")
    @Log(title = "生产商品牌", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseBrand baseBrand)
    {
        if (BrandConstants.UNIQUE.equals(baseBrandService.checkUpBrandIdUnique(baseBrand))) {
            return AjaxResult.error("新增品牌'" + baseBrand.getBrandName() + "'失败，品牌已经被删除");
        }

        if (BrandConstants.NOT_UNIQUE.equals(baseBrandService.checkUpBrandNameUnique(baseBrand))) {
            return AjaxResult.error("新增品牌'" + baseBrand.getBrandName() + "'失败，品牌已经存在");
        }

        return toAjax(baseBrandService.updateBaseBrand(baseBrand));
    }

    /**
     * 删除生产商品牌
     */
    @PreAuthorize("@ss.hasPermi('base:brand:remove')")
    @Log(title = "生产商品牌", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseBrandService.deleteBaseBrandByIds(ids));
    }

}
