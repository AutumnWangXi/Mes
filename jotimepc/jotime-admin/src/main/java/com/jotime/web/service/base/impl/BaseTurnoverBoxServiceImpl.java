package com.jotime.web.service.base.impl;

import com.jotime.common.constant.CodeRuleConstants;
import com.jotime.common.core.controller.BaseController;
import com.jotime.common.core.domain.AjaxResult;
import com.jotime.common.utils.DateUtils;
import com.jotime.web.domain.base.BaseTurnoverBox;
import com.jotime.web.mapper.base.BaseTurnoverBoxMapper;
import com.jotime.web.service.base.IBaseCodeRuleService;
import com.jotime.web.service.base.IBaseTurnoverBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 周转箱Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-13
 */
@Service
public class BaseTurnoverBoxServiceImpl extends BaseController implements IBaseTurnoverBoxService
{
    @Autowired
    private BaseTurnoverBoxMapper baseTurnoverBoxMapper;
    @Autowired
    private IBaseCodeRuleService baseCodeRuleService;

    /**
     * 查询周转箱
     *
     * @param id 周转箱主键
     * @return 周转箱
     */
    @Override
    public BaseTurnoverBox selectBaseTurnoverBoxById(Long id)
    {
        return baseTurnoverBoxMapper.selectBaseTurnoverBoxById(id);
    }

    /**
     * 查询周转箱列表
     *
     * @param baseTurnoverBox 周转箱
     * @return 周转箱
     */
    @Override
    public List<BaseTurnoverBox> selectBaseTurnoverBoxList(BaseTurnoverBox baseTurnoverBox)
    {
        return baseTurnoverBoxMapper.selectBaseTurnoverBoxList(baseTurnoverBox);
    }

    /**
     * 新增周转箱
     *
     * @param baseTurnoverBox 周转箱
     * @return 结果
     */
    @Override
    public AjaxResult insertBaseTurnoverBox(BaseTurnoverBox baseTurnoverBox)
    {
        if (baseTurnoverBoxMapper.selectBaseTurnoverBoxNameOrCodeUnique(baseTurnoverBox)>0){
            return AjaxResult.error("新增失败！物料箱名称或者条形码已经存在！");
        }
        //box_no
        Map<String, Object> paramMap = new HashMap<>();
        baseTurnoverBox.setBoxNo(baseCodeRuleService.getCurRuleCode(CodeRuleConstants.RULE_TURNOVER_BOX_CD, paramMap)[2]);
        baseTurnoverBox.setCreateBy(getUsername());
        baseTurnoverBox.setCreateTime(DateUtils.getNowDate());
        return toAjax(baseTurnoverBoxMapper.insertBaseTurnoverBox(baseTurnoverBox));
    }

    /**
     * 修改周转箱
     *
     * @param baseTurnoverBox 周转箱
     * @return 结果
     */
    @Override
    public AjaxResult updateBaseTurnoverBox(BaseTurnoverBox baseTurnoverBox)
    {
        if (baseTurnoverBoxMapper.selectBaseTurnoverBoxNameOrCodeUnique(baseTurnoverBox)>0){
            return AjaxResult.error("修改失败！物料箱名称或者条形码已经存在！");
        }
        baseTurnoverBox.setUpdateTime(DateUtils.getNowDate());
        baseTurnoverBox.setUpdateBy(getUsername());
        return toAjax(baseTurnoverBoxMapper.updateBaseTurnoverBox(baseTurnoverBox));
    }

    /**
     * 批量删除周转箱
     *
     * @param ids 需要删除的周转箱主键
     * @return 结果
     */
    @Override
    public int deleteBaseTurnoverBoxByIds(Long[] ids)
    {
        return baseTurnoverBoxMapper.deleteBaseTurnoverBoxByIds(ids);
    }

    /**
     * 删除周转箱信息
     *
     * @param id 周转箱主键
     * @return 结果
     */
    @Override
    public int deleteBaseTurnoverBoxById(Long id)
    {
        return baseTurnoverBoxMapper.deleteBaseTurnoverBoxById(id);
    }

    /**
     * 查询周转箱
     *
     * @param barCode 周转箱条形码
     * @return 周转箱
     */
    @Override
    public BaseTurnoverBox selectBaseTurnoverBoxByBarCode(String barCode)
    {
        return baseTurnoverBoxMapper.selectBaseTurnoverBoxByBarCode(barCode);
    }

    /**
     * 模糊查询周转箱
     *
     * @param baseTurnoverBox 周转箱条形码
     * @return 周转箱
     */
    @Override
    public AjaxResult selectBaseTurnoverBoxListBox(BaseTurnoverBox baseTurnoverBox) {
        return AjaxResult.success(baseTurnoverBoxMapper.selectBaseTurnoverBoxListBox(baseTurnoverBox));
    }
}
