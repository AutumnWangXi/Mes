package com.jotime.web.service.base;

import java.util.List;
import java.util.Map;

import com.jotime.web.domain.base.BaseCodeRule;
import com.jotime.web.domainVo.base.BaseCodeRuleVo;

/**
 * 编码规则Service接口
 *
 * @author ruoyi
 * @date 2021-12-20
 */
public interface IBaseCodeRuleService
{
    /**
     * 查询编码规则
     *
     * @param id 编码规则主键
     * @return 编码规则
     */
    public BaseCodeRuleVo selectBaseCodeRuleById(Integer id);

    /**
     * 查询编码规则列表
     *
     * @param baseCodeRule 编码规则
     * @return 编码规则集合
     */
    public List<BaseCodeRuleVo> selectBaseCodeRuleList(BaseCodeRule baseCodeRule);

    /**
     * 新增编码规则
     *
     * @param baseCodeRule 编码规则
     * @return 结果
     */
    public int insertBaseCodeRule(BaseCodeRule baseCodeRule);

    /**
     * 修改编码规则
     *
     * @param baseCodeRule 编码规则
     * @return 结果
     */
    public int updateBaseCodeRule(BaseCodeRule baseCodeRule);

    /**
     * 批量删除编码规则
     *
     * @param ids 需要删除的编码规则主键集合
     * @return 结果
     */
    public int deleteBaseCodeRuleByIds(Integer[] ids);

    /**
     * 删除编码规则信息
     *
     * @param id 编码规则主键
     * @return 结果
     */
    public int deleteBaseCodeRuleById(Integer id);

    /**
     * 获取当前最新编码
     *
     * @param ruleNo 需要删除的编码规则编号
     * @param paramMap 参数
     * @return 结果
     */
    public String[] getCurRuleCode(String ruleNo, Map<String, Object> paramMap);
}
