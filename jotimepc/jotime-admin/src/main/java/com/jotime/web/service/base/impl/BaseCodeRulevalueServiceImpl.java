package com.jotime.web.service.base.impl;

import java.util.List;
import com.jotime.common.utils.DateUtils;
import com.jotime.web.domainVo.base.BaseCodeRulevalueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jotime.web.mapper.base.BaseCodeRulevalueMapper;
import com.jotime.web.domain.base.BaseCodeRulevalue;
import com.jotime.web.service.base.IBaseCodeRulevalueService;

/**
 * 编码规则当前值Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-20
 */
@Service
public class BaseCodeRulevalueServiceImpl implements IBaseCodeRulevalueService 
{
    @Autowired
    private BaseCodeRulevalueMapper baseCodeRulevalueMapper;

    /**
     * 查询编码规则当前值
     * 
     * @param id 编码规则当前值主键
     * @return 编码规则当前值
     */
    @Override
    public BaseCodeRulevalueVo selectBaseCodeRulevalueById(Integer id)
    {
        return baseCodeRulevalueMapper.selectBaseCodeRulevalueById(id);
    }

    /**
     * 查询编码规则当前值列表
     * 
     * @param baseCodeRulevalue 编码规则当前值
     * @return 编码规则当前值
     */
    @Override
    public List<BaseCodeRulevalueVo> selectBaseCodeRulevalueList(BaseCodeRulevalue baseCodeRulevalue)
    {
        return baseCodeRulevalueMapper.selectBaseCodeRulevalueList(baseCodeRulevalue);
    }

    /**
     * 新增编码规则当前值
     * 
     * @param baseCodeRulevalue 编码规则当前值
     * @return 结果
     */
    @Override
    public int insertBaseCodeRulevalue(BaseCodeRulevalue baseCodeRulevalue)
    {
        return baseCodeRulevalueMapper.insertBaseCodeRulevalue(baseCodeRulevalue);
    }

    /**
     * 修改编码规则当前值
     * 
     * @param baseCodeRulevalue 编码规则当前值
     * @return 结果
     */
    @Override
    public int updateBaseCodeRulevalue(BaseCodeRulevalue baseCodeRulevalue)
    {
        baseCodeRulevalue.setUpdateTime(DateUtils.getNowDate());
        return baseCodeRulevalueMapper.updateBaseCodeRulevalue(baseCodeRulevalue);
    }

    /**
     * 批量删除编码规则当前值
     * 
     * @param ids 需要删除的编码规则当前值主键
     * @return 结果
     */
    @Override
    public int deleteBaseCodeRulevalueByIds(Integer[] ids)
    {
        return baseCodeRulevalueMapper.deleteBaseCodeRulevalueByIds(ids);
    }

    /**
     * 删除编码规则当前值信息
     * 
     * @param id 编码规则当前值主键
     * @return 结果
     */
    @Override
    public int deleteBaseCodeRulevalueById(Integer id)
    {
        return baseCodeRulevalueMapper.deleteBaseCodeRulevalueById(id);
    }
}
