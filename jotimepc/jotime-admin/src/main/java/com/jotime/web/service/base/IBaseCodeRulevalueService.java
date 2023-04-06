package com.jotime.web.service.base;

import java.util.List;
import com.jotime.web.domain.base.BaseCodeRulevalue;
import com.jotime.web.domainVo.base.BaseCodeRulevalueVo;

/**
 * 编码规则当前值Service接口
 * 
 * @author ruoyi
 * @date 2021-12-20
 */
public interface IBaseCodeRulevalueService 
{
    /**
     * 查询编码规则当前值
     * 
     * @param id 编码规则当前值主键
     * @return 编码规则当前值
     */
    public BaseCodeRulevalueVo selectBaseCodeRulevalueById(Integer id);

    /**
     * 查询编码规则当前值列表
     * 
     * @param baseCodeRulevalue 编码规则当前值
     * @return 编码规则当前值集合
     */
    public List<BaseCodeRulevalueVo> selectBaseCodeRulevalueList(BaseCodeRulevalue baseCodeRulevalue);

    /**
     * 新增编码规则当前值
     * 
     * @param baseCodeRulevalue 编码规则当前值
     * @return 结果
     */
    public int insertBaseCodeRulevalue(BaseCodeRulevalue baseCodeRulevalue);

    /**
     * 修改编码规则当前值
     * 
     * @param baseCodeRulevalue 编码规则当前值
     * @return 结果
     */
    public int updateBaseCodeRulevalue(BaseCodeRulevalue baseCodeRulevalue);

    /**
     * 批量删除编码规则当前值
     * 
     * @param ids 需要删除的编码规则当前值主键集合
     * @return 结果
     */
    public int deleteBaseCodeRulevalueByIds(Integer[] ids);

    /**
     * 删除编码规则当前值信息
     * 
     * @param id 编码规则当前值主键
     * @return 结果
     */
    public int deleteBaseCodeRulevalueById(Integer id);
}
