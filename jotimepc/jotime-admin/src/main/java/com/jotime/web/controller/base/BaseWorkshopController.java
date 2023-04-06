package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.constant.ApvlStatusConstants;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.domain.entity.SysRole;
import com.jotime.common.core.domain.entity.SysUser;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.system.service.ISysRoleService;
import com.jotime.web.domain.base.BaseWorkshop;
import com.jotime.web.domainVo.base.BaseWorkshopVo;
import com.jotime.web.service.base.IBaseWorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 车间Controller
 *
 * @author ruoyi
 * @date 2021-12-31
 */
@RestController
@RequestMapping("/web/base/workshop")
public class BaseWorkshopController extends BaseController {
    @Autowired
    private IBaseWorkshopService baseWorkshopService;
    @Autowired
    private ISysRoleService roleService;

    /**
     * 查询车间列表
     */
//    @PreAuthorize("@ss.hasPermi('base:workshop:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseWorkshop baseWorkshop) {
        startPage();
        List<BaseWorkshopVo> list = baseWorkshopService.selectBaseWorkshopVoList(baseWorkshop);
        return getDataTable(list);
    }

    /**
     * 查询车间列表
     */
//    @PreAuthorize("@ss.hasPermi('base:workshop:list')")
    @GetMapping("/dataList")
    public TableDataInfo dataList(BaseWorkshop baseWorkshop) {
        startPage();
        //查询状态正常的车间
        baseWorkshop.setStatus(ApvlStatusConstants.WHETHER_TO_DISABLE_YES);
        List<BaseWorkshopVo> list = baseWorkshopService.selectBaseWorkshopVoList(baseWorkshop);
        return getDataTable(list);
    }

    /**
     * 查询车间列表
     */
    @PreAuthorize("@ss.hasPermi('base:workshop:selectAllByDeptId')")
    @GetMapping("/selectAllByDeptId/{deptId}")
    public AjaxResult selectAllByDeptId(@PathVariable("deptId") String deptId) {
        List<BaseWorkshop> list = baseWorkshopService.selectAllByDeptId(deptId);
        return AjaxResult.success(list);
    }

    /**
     * 导出车间列表
     */
    @PreAuthorize("@ss.hasPermi('base:workshop:export')")
    @Log(title = "车间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseWorkshop baseWorkshop) {
        List<BaseWorkshop> list = baseWorkshopService.selectBaseWorkshopList(baseWorkshop);
        ExcelUtil<BaseWorkshop> util = new ExcelUtil<BaseWorkshop>(BaseWorkshop.class);
        util.exportExcel(response, list, "车间数据");
    }

    /**
     * 获取车间详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:workshop:query')")
    @GetMapping( "/{id}")
    public AjaxResult getInfo(@PathVariable(value = "id") Long id) {
        BaseWorkshop baseWorkshop = baseWorkshopService.selectBaseWorkshopById(id);
        baseWorkshop.setRoleId(null);
        AjaxResult ajax = AjaxResult.success();
        List<SysRole> roles = roleService.selectRoleAll();
        ajax.put("roles", SysUser.isAdmin(baseWorkshop.getLeaderId()) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        ajax.put(AjaxResult.DATA_TAG, baseWorkshop);
        ajax.put("roleIds", baseWorkshop.getCdids());
        return ajax;
    }
    /**
     * 新增车间
     */
    @PreAuthorize("@ss.hasPermi('base:workshop:add')")
    @Log(title = "车间", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseWorkshop baseWorkshop) {
        if (baseWorkshopService.insertBaseWorkshop(baseWorkshop)>0) return toAjax(1);
        return AjaxResult.error("新增失败！车间编码（" + baseWorkshop.getWorkshopCode() + "）已经存在");
    }

    /**
     * 修改车间
     */
    @PreAuthorize("@ss.hasPermi('base:workshop:edit')")
    @Log(title = "车间", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseWorkshop baseWorkshop) {
        if (baseWorkshopService.updateBaseWorkshop(baseWorkshop)>0) return toAjax(1);
        return AjaxResult.error("修改失败！车间编码（" + baseWorkshop.getWorkshopCode() + "）已经存在");
    }
    /**
     * 删除车间
     */
    @PreAuthorize("@ss.hasPermi('base:workshop:remove')")
    @Log(title = "车间", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(baseWorkshopService.deleteBaseWorkshopByIds(ids));
    }

    /**
     * 下拉框，获取车间列表
     */
    @GetMapping("/getWorkShopList")
    public AjaxResult getWorkShopList() {
        return AjaxResult.success().put("workshopOptions",baseWorkshopService.selectBaseWorkshopList(new BaseWorkshop()));
    }

}
