package com.jotime.web.controller.base;

import com.jotime.common.annotation.Log;
import com.jotime.common.constant.CodeRuleConstants;
import com.jotime.common.constant.Constants;
import com.jotime.common.constant.SupplierConstants;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.core.page.TableDataInfo;
import com.jotime.common.enums.BusinessType;
import com.jotime.common.utils.poi.ExcelUtil;
import com.jotime.web.domain.base.BaseSupplier;
import com.jotime.web.service.base.IBaseCodeRuleService;
import com.jotime.web.service.base.IBaseSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 供应商Controller
 *
 * @author ruoyi
 * @date 2021-12-30
 */
@RestController
@RequestMapping("/web/base/supplier")
public class BaseSupplierController extends BaseController
{
    @Autowired
    private IBaseSupplierService baseSupplierService;
    @Autowired
    private IBaseCodeRuleService baseCodeRuleService;

    /**
     * 查询供应商列表
     */
    @PreAuthorize("@ss.hasPermi('base:supplier:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseSupplier baseSupplier)
    {
        startPage();
        List<BaseSupplier> list = baseSupplierService.selectBaseSupplierList(baseSupplier);
        return getDataTable(list);
    }

    /**
     * 获取供应商code
     */
    @PreAuthorize("@ss.hasPermi('base:supplier:query')")
    @GetMapping(value = "/code")
    public AjaxResult getCode(BaseSupplier baseSupplier)
    {
        List<BaseSupplier> baseSuppliers = baseSupplierService.selectBaseSupplierList(baseSupplier);
        if(Constants.ONE.equals(baseSuppliers.size())){
            BaseSupplier bs = new BaseSupplier();
            bs.setSupplierCode(baseSuppliers.get(0).getSupplierCode());
            return AjaxResult.success(bs);
        }else {
            return AjaxResult.error("供应商:"+baseSupplier.getSupplierName()+"数据重复/不存在，请联系管理员");
        }
    }

    /**
     * 查询待审核供应商列表
     */
    @PreAuthorize("@ss.hasPermi('base:supplier:listChk')")
    @GetMapping("/listChk")
    public TableDataInfo listChk(BaseSupplier baseSupplier)
    {
        startPage();
        List<BaseSupplier> list = baseSupplierService.selectBaseSupplierList(baseSupplier);
        return getDataTable(list);
    }


    /**
     * 导出供应商列表
     */
    @PreAuthorize("@ss.hasPermi('base:supplier:export')")
    @Log(title = "供应商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseSupplier baseSupplier)
    {
        List<BaseSupplier> list = baseSupplierService.selectBaseSupplierList(baseSupplier);
        ExcelUtil<BaseSupplier> util = new ExcelUtil<BaseSupplier>(BaseSupplier.class);
        util.exportExcel(response, list, "供应商数据");
    }

    /**
     * 获取供应商详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:supplier:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseSupplierService.selectBaseSupplierById(id));
    }

    /**
     * 新增供应商
     */
    @PreAuthorize("@ss.hasPermi('base:supplier:add')")
    @Log(title = "供应商", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseSupplier baseSupplier)
    {
        if (SupplierConstants.NOT_UNIQUE.equals(baseSupplierService.checkSupplierNameUnique(baseSupplier)))
        {
            return AjaxResult.error("新增供应商'" + baseSupplier.getSupplierName() + "'失败，供应商已经存在");
        }

        // 取得供应商编码
        String[] arrCode = baseCodeRuleService.getCurRuleCode(CodeRuleConstants.RULE_SUPPLIER_CD, null);
        // 获取失败
        if (CodeRuleConstants.FAIL.equals(arrCode[0])) {
            return AjaxResult.error("新增供应商'" + baseSupplier.getSupplierName() + "'失败，" + arrCode[1]);
        }

        baseSupplier.setSupplierCode(arrCode[2]);
        return toAjax(baseSupplierService.insertBaseSupplier(baseSupplier));
    }

    /**
     * 修改供应商
     */
    @PreAuthorize("@ss.hasPermi('base:supplier:edit')")
    @Log(title = "供应商", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseSupplier baseSupplier)
    {
        if (SupplierConstants.NOT_UNIQUE.equals(baseSupplierService.checkSupplierNameUnique(baseSupplier)))
        {
            return AjaxResult.error("修改供应商'" + baseSupplier.getSupplierName() + "'失败，供应商已经存在");
        }

        return toAjax(baseSupplierService.updateBaseSupplier(baseSupplier));
    }

    /**
     * 删除供应商
     */
    @PreAuthorize("@ss.hasPermi('base:supplier:remove')")
    @Log(title = "供应商", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseSupplierService.deleteBaseSupplierByIds(ids));
    }

    /**
     * 更新供应商审核状态
     */
    @PreAuthorize("@ss.hasPermi('base:supplier:check')")
    @Log(title = "供应商", businessType = BusinessType.UPDATE)
    @PutMapping("/updateCheckSts")
    public AjaxResult updateCheckSts(@RequestBody BaseSupplier baseSupplier)
    {
        if (SupplierConstants.UNIQUE.equals(baseSupplierService.checkSupplierUnique(baseSupplier)))
        {
            return AjaxResult.error("审核供应商'" + baseSupplier.getSupplierName() + "'失败，供应商不存在");
        }

        return toAjax(baseSupplierService.updateSupplierCheckSts(baseSupplier));
    }

    /**
     * 根据供应商列表信息
     *
     * @return 供应商名称数据
     */
    //@PreAuthorize("@ss.hasPermi('web:supplier:selectSupplierName')")
    @GetMapping("/selectSupplierName")
    public AjaxResult selectSupplierName() {
        List<BaseSupplier> baseSuppliers = baseSupplierService.selectSupplierName();
        return AjaxResult.success(baseSuppliers);
    }

    /**
     * @Description: 供应商导入下载模板
     * @Author: YunFei
     * @Date: 2022/4/15 15:21
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws Exception {
        ExcelUtil<BaseSupplier> util = new ExcelUtil(BaseSupplier.class);
        util.importTemplateExcel(response, "供应商导入数据");
    }

    /**
     * @Description: 供应商导入
     * @Author: YunFei
     * @Date: 2022/4/15 15:21
     */
    @Log(title = "供应商管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BaseSupplier> util = new ExcelUtil(BaseSupplier.class);
        List<BaseSupplier> baseSuppliers = util.importExcel(file.getInputStream());
        int message = baseSupplierService.importData(baseSuppliers);
        return AjaxResult.success(message);
    }
}
