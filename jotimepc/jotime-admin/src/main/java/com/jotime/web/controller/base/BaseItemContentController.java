package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseItemContent;
import com.jotime.web.service.base.IBaseItemContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 描述：物料含量Controller
 *
 * @author yunmoqian
 * @date 2022-03-28
 */
@RestController
@RequestMapping("/web/itemContent")
public class BaseItemContentController extends BaseController
{
    @Autowired
    private IBaseItemContentService baseItemContentService;

    /**
     * 查询描述：物料含量列表
     */
//    @PreAuthorize("@ss.hasPermi('web:itemContent:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseItemContent baseItemContent)
    {
        startPage();
        List<BaseItemContent> list = baseItemContentService.selectBaseItemContentList(baseItemContent);
        return getDataTable(list);
    }

    /**
     * 导出描述：物料含量列表
     */
//    @PreAuthorize("@ss.hasPermi('web:itemContent:export')")
    @Log(title = "描述：物料含量", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseItemContent baseItemContent)
    {
        List<BaseItemContent> list = baseItemContentService.selectBaseItemContentList(baseItemContent);
        ExcelUtil<BaseItemContent> util = new ExcelUtil<BaseItemContent>(BaseItemContent.class);
        util.exportExcel(response, list, "描述：物料含量数据");
    }

    /**
     * 获取描述：物料含量详细信息
     */
//    @PreAuthorize("@ss.hasPermi('web:itemContent:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseItemContentService.selectBaseItemContentById(id));
    }

    /**
     * 新增描述：物料含量
     */
//    @PreAuthorize("@ss.hasPermi('web:itemContent:add')")
    @Log(title = "描述：物料含量", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseItemContent baseItemContent)
    {
        return toAjax(baseItemContentService.insertBaseItemContent(baseItemContent));
    }

    /**
     * 修改描述：物料含量
     */
//    @PreAuthorize("@ss.hasPermi('web:itemContent:edit')")
    @Log(title = "描述：物料含量", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseItemContent baseItemContent)
    {
        return toAjax(baseItemContentService.updateBaseItemContent(baseItemContent));
    }

    /**
     * 删除描述：物料含量
     */
//    @PreAuthorize("@ss.hasPermi('web:itemContent:remove')")
    @Log(title = "描述：物料含量", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseItemContentService.deleteBaseItemContentByIds(ids));
    }

    /**
     * @Description: 更新物料对应含量信息
     * @param baseItemContents 物料含量信息
     * @param itemId 物料id
     * @Author: YunFei
     * @Date: 2022/3/29 10:53
     */
//    @PreAuthorize("@ss.hasPermi('web:itemContent:edit')")
    @Log(title = "描述：物料含量", businessType = BusinessType.UPDATE)
    @PutMapping("/update/{itemId}")
    public void update(@RequestBody List<BaseItemContent> baseItemContents,@PathVariable Long itemId)
    {
        baseItemContentService.updateBaseItemContentList(baseItemContents,itemId);
    }

}
