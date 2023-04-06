package com.jotime.web.controller.apvl;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.domain.entity.SysUser;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.system.service.ISysUserService;
import com.jotime.web.domain.Apvl.ApvlCommon;
import com.jotime.web.domainVo.apvl.ApvlCommonVo;
import com.jotime.web.service.Apvl.IApvlCommonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 审批共通Controller
 *
 * @author ruoyi
 * @date 2021-12-13
 */
@RestController
@RequestMapping("/web/apvl/common")
public class ApvlCommonController extends BaseController {

    @Autowired
    private IApvlCommonService apvlCommonService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private IApvlCommonService iApvlCommonService;

    /**
     * 查询审批共通列表
     */
//    @PreAuthorize("@ss.hasPermi('web:common:list')")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(ApvlCommon apvlCommon) {
        startPage();
        List<ApvlCommon> list = apvlCommonService.selectApvlCommonList(apvlCommon);
        return getDataTable(list);
    }

    /**
     * 导出审批共通列表
     */
//    @PreAuthorize("@ss.hasPermi('web:common:export')")
    @Log(title = "审批共通", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ApvlCommon apvlCommon) {
        List<ApvlCommon> list = apvlCommonService.selectApvlCommonList(apvlCommon);
        ExcelUtil<ApvlCommon> util = new ExcelUtil<ApvlCommon>(ApvlCommon.class);
        return util.exportExcel(list, "审批共通数据");
    }


    /**
     * 新增保存审批共通
     */
    @PreAuthorize("@ss.hasPermi('web:common:add')")
    @Log(title = "审批共通", businessType = BusinessType.INSERT)
    @PostMapping
    @ResponseBody
    public AjaxResult addSave(@RequestBody ApvlCommon apvlCommon) {
        return toAjax(apvlCommonService.insertApvlCommon(apvlCommon));
    }


    /**
     * 修改保存审批共通
     */
    @PreAuthorize("@ss.hasPermi('web:common:edit')")
    @Log(title = "审批共通", businessType = BusinessType.UPDATE)
    @PutMapping
    @ResponseBody
    public AjaxResult editSave(@RequestBody ApvlCommonVo apvlCommonVo) {
        //Vo转换实体类
        ApvlCommon apvlCommon = new ApvlCommon();
        BeanUtils.copyProperties(apvlCommonVo, apvlCommon);
        return toAjax(apvlCommonService.updateApvlCommon(apvlCommon));
    }

    /**
     * 删除审批共通
     */
    @PreAuthorize("@ss.hasPermi('web:common:remove')")
    @Log(title = "审批共通", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    @ResponseBody
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(apvlCommonService.deleteApvlCommonByIds(ids));
    }

    /**
     * 获取用户列表
     */
    @GetMapping("/sysUserList")
    @ResponseBody
    public TableDataInfo list(SysUser user) {
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

}

