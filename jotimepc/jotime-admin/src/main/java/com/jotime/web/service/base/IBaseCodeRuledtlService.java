package com.jotime.web.service.base;

import java.util.List;
import com.jotime.web.domain.base.BaseCodeRuledtl;
import com.jotime.web.domainVo.base.BaseCodeRuledtlVo;

/**
 * 编码规则明细Service接口
 * 
 * @author ruoyi
 * @date 2021-12-20
 */
public interface IBaseCodeRuledtlService 
{
    /**
     * 查询编码规则明细
     * 
     * @param id 编码规则明细主键
     * @return 编码规则明细
     */
    public BaseCodeRuledtlVo selectBaseCodeRuledtlById(Integer id);

    /**
     * 查询编码规则明细列表
     * 
     * @param baseCodeRuledtl 编码规则明细
     * @return 编码规则明细集合
     */
    public List<BaseCodeRuledtlVo> selectBaseCodeRuledtlList(BaseCodeRuledtl baseCodeRuledtl);

    /**
     * 查询编码规则明细列表（关联主体）
     *
     * @param baseCodeRuledtl 编码规则明细
     * @return 编码规则明细集合
     */
    public List<BaseCodeRuledtlVo> selectBaseCodeRuledtlVoList(BaseCodeRuledtl baseCodeRuledtl);

    /**
     * 新增编码规则明细
     * 
     * @param baseCodeRuledtl 编码规则明细
     * @return 结果
     */
    public int insertBaseCodeRuledtl(BaseCodeRuledtl baseCodeRuledtl);

    /**
     * 修改编码规则明细
     * 
     * @param baseCodeRuledtl 编码规则明细
     * @return 结果
     */
    public int updateBaseCodeRuledtl(BaseCodeRuledtl baseCodeRuledtl);

    /**
     * 批量删除编码规则明细
     * 
     * @param ids 需要删除的编码规则明细主键集合
     * @return 结果
     */
    public int deleteBaseCodeRuledtlByIds(Integer[] ids);

    /**
     * 删除编码规则明细信息
     * 
     * @param id 编码规则明细主键
     * @return 结果
     */
    public int deleteBaseCodeRuledtlById(Integer id);
}
