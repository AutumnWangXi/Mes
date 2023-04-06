package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseGroupuser;
import com.jotime.web.domainVo.base.BaseGroupuserVo;
import com.jotime.web.service.base.IBaseGroupuserService;
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
 * 班组人员管理Controller
 *
 * @author ruoyi
 * @date 2022-03-01
 */
@RestController
@RequestMapping("/admin/groupuser")
public class BaseGroupuserController extends BaseController
{
    @Autowired
    private IBaseGroupuserService baseGroupuserService;

    /**
     * 查询班组人员管理列表
     */
    @PreAuthorize("@ss.hasPermi('admin:groupuser:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseGroupuser baseGroupuser)
    {
        startPage();
        List<BaseGroupuser> list = baseGroupuserService.selectBaseGroupuserList(baseGroupuser);
        return getDataTable(list);
    }
    /**
     * 查询班组人员管理列表
     */
    @PreAuthorize("@ss.hasPermi('admin:groupuser:list')")
    @GetMapping("/listVo")
    public TableDataInfo listVo(BaseGroupuser baseGroupuser)
    {
        startPage();
        List<BaseGroupuserVo> list = baseGroupuserService.selectBaseGroupuserVoList(baseGroupuser);
        return getDataTable(list);
    }
    /**
     * 导出班组人员管理列表
     */
    @PreAuthorize("@ss.hasPermi('admin:groupuser:export')")
    @Log(title = "班组人员管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseGroupuser baseGroupuser)
    {
        List<BaseGroupuser> list = baseGroupuserService.selectBaseGroupuserList(baseGroupuser);
        ExcelUtil<BaseGroupuser> util = new ExcelUtil<BaseGroupuser>(BaseGroupuser.class);
        util.exportExcel(response, list, "班组人员管理数据");
    }

    /**
     * 获取班组人员管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:groupuser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(baseGroupuserService.selectBaseGroupuserById(id));
    }

    /**
     * 新增班组人员管理
     */
    @PreAuthorize("@ss.hasPermi('admin:groupuser:add')")
    @Log(title = "班组人员管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseGroupuser baseGroupuser)
    {
        int i = baseGroupuserService.insertBaseGroupuser(baseGroupuser);
        if (i==-1){
            return AjaxResult.error("该班组人员正在工作中");
        }
        return toAjax(i);
    }

    /**
     * 修改班组人员管理
     */
    @PreAuthorize("@ss.hasPermi('admin:groupuser:edit')")
    @Log(title = "班组人员管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseGroupuser baseGroupuser)
    {
        int i = baseGroupuserService.updateBaseGroupuser(baseGroupuser);
        if (i==-1){
            return AjaxResult.error("该班组人员正在工作中");
        }
        return toAjax(i);
    }

    /**
     * 删除班组人员管理
     */
    @PreAuthorize("@ss.hasPermi('admin:groupuser:remove')")
    @Log(title = "班组人员管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(baseGroupuserService.deleteBaseGroupuserByIds(ids));
    }
}
