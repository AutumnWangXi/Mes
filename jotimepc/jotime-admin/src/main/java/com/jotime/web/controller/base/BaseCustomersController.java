package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.constant.CodeRuleConstants;
import com.jotime.common.constant.CustomerConstants;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseCustomers;
import com.jotime.web.domainVo.base.BaseCustomersVo;
import com.jotime.web.domainVo.excel.BaseCustomersExlVo;
import com.jotime.web.service.base.IBaseCodeRuleService;
import com.jotime.web.service.base.IBaseCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 客户集合Controller
 *
 * @author ruoyi
 * @date 2021-12-27
 */
@RestController
@RequestMapping("/web/base/customers")
public class BaseCustomersController extends BaseController {
    @Autowired
    private IBaseCustomersService baseCustomersService;
    @Autowired
    private IBaseCodeRuleService baseCodeRuleService;

    /**
     * 查询客户集合列表
     *
     * @param baseCustomers 客户集合
     * @param pageType          客户类型
     * @return 客户集合
     */
    @PreAuthorize("@ss.hasPermi('web:customers:list')")
    @GetMapping("/list/{pageType}")
    public TableDataInfo list(@PathVariable("pageType") String pageType, BaseCustomers baseCustomers) {
        startPage();
        List<BaseCustomers> list = baseCustomersService.selectBaseCustomersList(pageType, baseCustomers);
        return getDataTable(list);
    }

    /**
     *客户导入下载模板
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws Exception {
        ExcelUtil<BaseCustomersExlVo> util = new ExcelUtil(BaseCustomersExlVo.class);
        util.importTemplateExcel(response, "导入数据");
    }

    /**
     * 客户导入
     */
    @Log(title = "设备管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
//    @RepeatSubmit(interval = 30000, message = "5分钟内已导入过，请稍后再试")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<BaseCustomersExlVo> util = new ExcelUtil(BaseCustomersExlVo.class);
        List<BaseCustomersExlVo> baseCustomersExlVos = util.importExcel(file.getInputStream());
        int message = baseCustomersService.importData(baseCustomersExlVos, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 导出客户集合列表
     */
    @PreAuthorize("@ss.hasPermi('web:customers:export')")
    @Log(title = "客户集合", businessType = BusinessType.EXPORT)
    @PostMapping("/export/{type}")
    public void export(HttpServletResponse response, BaseCustomers baseCustomers, @PathVariable("type") String type) {
        List<BaseCustomers> list = baseCustomersService.selectBaseCustomersList(type, baseCustomers);
        ExcelUtil<BaseCustomers> util = new ExcelUtil<BaseCustomers>(BaseCustomers.class);
        util.exportExcel(response, list, "客户集合数据");
    }

    /**
     * 获取客户集合详细信息
     */
//    @PreAuthorize("@ss.hasPermi('web:customers:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(baseCustomersService.selectBaseCustomersById(id));
    }

    /**
     * 新增客户集合
     */
    @PreAuthorize("@ss.hasPermi('web:customers:add')")
    @Log(title = "客户集合", businessType = BusinessType.INSERT)
    @PostMapping(value = "/{pageType}")
    public AjaxResult add(@PathVariable("pageType") String pageType, @RequestBody BaseCustomers baseCustomers) {

        // 客户名称校验
        if (CustomerConstants.CHECK_NG.equals(baseCustomersService.checkCustomerNameUnique(baseCustomers))) {
            return AjaxResult.error("新增客户'" + baseCustomers.getCustomerName() + "'失败，客户已经存在");
        }

        // 取得供应商编码
        String[] arrCode = baseCodeRuleService.getCurRuleCode(CodeRuleConstants.RULE_CUSTOMER_CD, null);
        // 获取失败
        if (CodeRuleConstants.FAIL.equals(arrCode[0])) {
            return AjaxResult.error("新增客户" + baseCustomers.getCustomerName() + "'失败，" + arrCode[1]);
        }

        baseCustomers.setCustomerCode(arrCode[2]);
        return toAjax(baseCustomersService.insertBaseCustomers(pageType, baseCustomers));
    }

    /**
     * 修改客户集合
     */
    @PreAuthorize("@ss.hasPermi('web:customers:edit')")
    @Log(title = "客户集合", businessType = BusinessType.UPDATE)
    @PutMapping(value = "/{pageType}")
    public AjaxResult edit(@PathVariable("pageType") String pageType,@RequestBody BaseCustomers baseCustomers) {

        // 校验结果NG场合
        String[] arrCheckRtn = baseCustomersService.checkUpCustomerNameUnique(baseCustomers);
        if (CustomerConstants.CHECK_NG.equals(arrCheckRtn[0])) {
            return AjaxResult.error(arrCheckRtn[1]);
        }

        return toAjax(baseCustomersService.updateBaseCustomers(baseCustomers));
    }

    /**
     * 删除客户集合
     */
    @PreAuthorize("@ss.hasPermi('web:customers:remove')")
    @Log(title = "客户集合", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(baseCustomersService.deleteBaseCustomersByIds(ids));
    }

    /**
     * 查询客户名称列表
     *
     * @return 客户名称数据
     */
//    @PreAuthorize("@ss.hasAnyPermi('web:customers:select')")
    @GetMapping("/selectCustomerName")
    public AjaxResult selectCustomers() {
        return baseCustomersService.selectCustomerName();
    }

    /**
     * 根据客户名称查询客户
     *
     * @return 客户名称数据
     */
//    @PreAuthorize("@ss.hasAnyPermi('web:customers:select')")
    @GetMapping("/selectCustomer/{customersName}")
    public AjaxResult selectCustomerNo(@PathVariable("customersName") String customersName) {
        return baseCustomersService.selectCustomersNo(customersName);
    }

    @GetMapping("/selectAllCustomer")
    public AjaxResult selectAllCustomer() {
        List<BaseCustomers> baseCustomers = baseCustomersService.selectAllCustomer();
        return AjaxResult.success(baseCustomers);
    }

    /**
     * 根据客户列表信息
     *
     * @return 客户名称数据
     */
//    @PreAuthorize("@ss.hasPermi('web:customers:optionsList')")
    @GetMapping("/optionsList")
    public AjaxResult selectCusOption() {
        List<BaseCustomersVo> baseCustomers = baseCustomersService.selectCustomerOption();
        return AjaxResult.success(baseCustomers);
    }

}
