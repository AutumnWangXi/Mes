package com.jotime.web.controller.employee;

import com.jotime.common.annotation.Log;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.system.service.ISysPostService;
import com.jotime.web.domain.employee.EmployeeInfo;
import com.jotime.web.domainVo.employee.EmployeeInfoVo;
import com.jotime.web.domainVo.excel.EmployeeInfoExlVo;
import com.jotime.web.service.employee.IEmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 员工信息Controller
 *
 * @author ruoyi
 * @date 2021-12-26
 */
@RestController
@RequestMapping("/web/employee")
public class EmployeeInfoController extends BaseController {
    @Autowired
    private IEmployeeInfoService employeeInfoService;
    @Autowired
    private ISysPostService postService;

    /**
     * 查询员工信息列表
     */
    @PreAuthorize("@ss.hasPermi('web:employee:list')")
    @GetMapping("/list")
    public TableDataInfo list(EmployeeInfo employeeInfo) {
        startPage();
        List<EmployeeInfoVo> list = employeeInfoService.selectEmployeeInfoUnList(employeeInfo);
        return getDataTable(list);
    }

    /**
     * 导出员工信息列表
     */
    @PreAuthorize("@ss.hasPermi('web:employee:export')")
    @Log(title = "员工信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EmployeeInfo employeeInfo) {
        List<EmployeeInfoVo> list = employeeInfoService.selectEmployeeInfoList(employeeInfo);
        ExcelUtil<EmployeeInfoVo> util = new ExcelUtil<EmployeeInfoVo>(EmployeeInfoVo.class);
        util.exportExcel(response, list, "员工信息数据");
    }

    /**
     * 获取员工信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:employee:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(employeeInfoService.selectEmployeeInfoById(id));
    }

    /**
     * 新增员工信息
     */
    @PreAuthorize("@ss.hasPermi('web:employee:add')")
    @Log(title = "员工信息", businessType = BusinessType.INSERT)
    @PostMapping
    @Transactional
    public AjaxResult add(@RequestBody EmployeeInfo employeeInfo) {
        return toAjax(employeeInfoService.insertEmployeeInfo(employeeInfo));
    }

    /**
     * 修改员工信息
     */
    @PreAuthorize("@ss.hasPermi('web:employee:edit')")
    @Log(title = "员工信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EmployeeInfo employeeInfo) {
        return toAjax(employeeInfoService.updateEmployeeInfo(employeeInfo));
    }

    /**
     * 删除员工信息
     */
    @PreAuthorize("@ss.hasPermi('web:employee:remove')")
    @Log(title = "员工信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(employeeInfoService.deleteEmployeeInfoByIds(ids));
    }
    /**
     * 查询职务列表
     *
     * @param
     * @return 职务列表
     */
    @GetMapping("/selectPostList")
    public AjaxResult getPostList() {
        AjaxResult ajax = AjaxResult.success();
        return ajax.put("postListOptions", postService.selectPostList(null));
    }

    /**
     * 查询员工列表，下拉框
     *
     * @param
     * @return 员工列表
     */
    @GetMapping("/getInfoOptionsList")
    public AjaxResult getInfoOptionsList() {
        AjaxResult ajax = AjaxResult.success();
        return ajax.put("infoOptionsList", employeeInfoService.selectEmployeeInfoList(null));
    }

    /**
     * 查询员工当前部门下的员工列表
     *
     * @Author: YunFei
     * @return 员工列表
     * @Date: 2022/4/15 15:21
     */
    @PostMapping("/getInfoDeptList")
    public AjaxResult getInfoOptionsDeptList(EmployeeInfo employeeInfo) {
        AjaxResult ajax = AjaxResult.success();
        return ajax.put("infoOptionsList", employeeInfoService.selectEmployeeInfoDeptList(employeeInfo));
    }

    /**
     * @Description: 员工导入下载模板
     * @Author: YunFei
     * @Date: 2022/4/15 15:21
     */
    @PostMapping("/importTemplate")
    public void importConsumableTemplate(HttpServletResponse response) throws Exception {
        ExcelUtil<EmployeeInfoExlVo> util = new ExcelUtil(EmployeeInfoExlVo.class);
        util.importTemplateExcel(response, "员工导入数据");
    }

    /**
     * @Description: 员工导入
     * @Author: YunFei
     * @Date: 2022/4/19 11:21
     */
    @Log(title = "员工管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importConsumableData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<EmployeeInfoExlVo> util = new ExcelUtil(EmployeeInfoExlVo.class);
        List<EmployeeInfoExlVo> employeeInfoExlVos = util.importExcel(file.getInputStream());
        int message = employeeInfoService.importData(employeeInfoExlVos, updateSupport);
        return AjaxResult.success(message);
    }
}
