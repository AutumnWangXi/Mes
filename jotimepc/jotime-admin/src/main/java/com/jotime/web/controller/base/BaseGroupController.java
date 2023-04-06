package com.jotime.web.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.jotime.common.utils.SecurityUtils;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseGroup;
import com.jotime.web.domainVo.base.BaseGroupVo;
import com.jotime.web.service.base.IBaseGroupService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.core.page.TableDataInfo;

/**
 * 班组Controller
 *
 * @author ruoyi
 * @date 2022-03-01
 */
@RestController
@RequestMapping("/admin/group")
public class BaseGroupController extends BaseController
{
    @Autowired
    private IBaseGroupService baseGroupService;

    /**
     * 查询班组列表
     */
    @PreAuthorize("@ss.hasPermi('admin:group:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseGroup baseGroup)
    {
        startPage();
        List<BaseGroupVo> list = baseGroupService.selectBaseGroupList(baseGroup);
        return getDataTable(list);
    }

    /**
     * 导出班组列表
     */
    @PreAuthorize("@ss.hasPermi('admin:group:export')")
    @Log(title = "班组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseGroup baseGroup)
    {
        List<BaseGroupVo> list = baseGroupService.selectBaseGroupList(baseGroup);
        ExcelUtil<BaseGroupVo> util = new ExcelUtil<BaseGroupVo>(BaseGroupVo.class);
        util.exportExcel(response, list, "班组数据");
    }

    /**
     * 获取班组详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:group:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseGroupService.selectBaseGroupById(id));
    }

    /**
     * 新增班组
     */
    @PreAuthorize("@ss.hasPermi('admin:group:add')")
    @Log(title = "班组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseGroup baseGroup)
    {
        int i = baseGroupService.insertBaseGroup(baseGroup);
        if (i==-1){
            return AjaxResult.error("编码已经存在！");
        }
        return toAjax(i);
    }

    /**
     * 修改班组
     */
    @PreAuthorize("@ss.hasPermi('admin:group:edit')")
    @Log(title = "班组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseGroup baseGroup)
    {
        return toAjax(baseGroupService.updateBaseGroup(baseGroup));
    }

    /**
     * 修改班组和编辑班组人员
     */
    @PreAuthorize("@ss.hasPermi('admin:group:edit')")
    @Log(title = "班组", businessType = BusinessType.UPDATE)
    @PutMapping("/editAndGroupUser")
    public AjaxResult editAndGroupUser(@RequestBody BaseGroupVo baseGroupVo)
    {
        for (int i = 0; i < baseGroupVo.getBaseGroupusers().size(); i++) {
            if (baseGroupVo.getBaseGroupusers().get(i).getUserId()==null){
                return AjaxResult.error("请检查组员数据是否完整");
            }
        }
        int i = baseGroupService.updateBaseGroupVo(baseGroupVo);
        if (i==-1){
            return AjaxResult.error("班组人员已在工作中！");
        }
        return toAjax(i);
    }
    /**
     * 删除班组
     */
    @PreAuthorize("@ss.hasPermi('admin:group:remove')")
    @Log(title = "班组", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseGroupService.deleteBaseGroupByIds(ids));
    }
    /**
     * 获取车间对应班组列表
     */
//    @PreAuthorize("@ss.hasPermi('admin:group:list')")
    @GetMapping(value = "/getWorkGroupList/{workShopId}")
    public AjaxResult getWorkGroupList(@PathVariable("workShopId") Long workShopId)
    {
        return AjaxResult.success(baseGroupService.getWorkGroupList(workShopId));
    }
    /**
     * 获取该班组生产订单的班组的负责人
     */
//    @PreAuthorize("@ss.hasPermi('admin:group:query')")
    @GetMapping(value = "/selectGroupleader/{gpOrdertaskNo}")
    public AjaxResult getGroupleader(@PathVariable("gpOrdertaskNo") String gpOrdertaskNo)
    {
        return AjaxResult.success(baseGroupService.selectGroupleader(gpOrdertaskNo));
    }
    /**
     * 获取班组详细信息和对应组员
     */
    @GetMapping(value = "/getGroupVo/{id}")
    public AjaxResult getGroupVo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseGroupService.selectBaseGroupVoById(id));
    }

    /**
     * 获取用户部门对应班组列表
     */
    @PreAuthorize("@ss.hasPermi('admin:group:list')")
    @GetMapping(value = "/getDeptWorkGroupList")
    public AjaxResult getDeptWorkGroupList()
    {
        BaseGroup param = new BaseGroup();
        param.setDeptId(SecurityUtils.getDeptId());
        return AjaxResult.success(baseGroupService.selectBaseGroupList(param));
    }


    /**
     * 查询同部门班组数据
     *
     * @param depttaskNo 打样任务单号
     * @param deptId 部门Id
     *
     * @return 同部门班组数据
     */
    @GetMapping("/deptGroup")
    @PreAuthorize("@ss.hasAnyPermi('web:group:edit')")
    public AjaxResult selectDeptGroup(@RequestParam("depttaskNo") String depttaskNo, @RequestParam("deptId") Long deptId) {

        return baseGroupService.selectDeptGroup(depttaskNo, deptId);
    }


}
