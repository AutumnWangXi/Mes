package com.jotime.web.service.base.impl;

import java.util.List;
import com.jotime.common.utils.DateUtils;
import com.jotime.common.utils.SecurityUtils;
import com.jotime.web.domainVo.base.BaseCodeRuledtlVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jotime.web.mapper.base.BaseCodeRuledtlMapper;
import com.jotime.web.domain.base.BaseCodeRuledtl;
import com.jotime.web.service.base.IBaseCodeRuledtlService;

/**
 * 编码规则明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-20
 */
@Service
public class BaseCodeRuledtlServiceImpl implements IBaseCodeRuledtlService 
{
    @Autowired
    private BaseCodeRuledtlMapper baseCodeRuledtlMapper;

    /**
     * 查询编码规则明细
     * 
     * @param id 编码规则明细主键
     * @return 编码规则明细
     */
    @Override
    public BaseCodeRuledtlVo selectBaseCodeRuledtlById(Integer id)
    {
        return baseCodeRuledtlMapper.selectBaseCodeRuledtlById(id);
    }

    /**
     * 查询编码规则明细列表
     * 
     * @param baseCodeRuledtl 编码规则明细
     * @return 编码规则明细
     */
    @Override
    public List<BaseCodeRuledtlVo> selectBaseCodeRuledtlList(BaseCodeRuledtl baseCodeRuledtl)
    {
        return baseCodeRuledtlMapper.selectBaseCodeRuledtlList(baseCodeRuledtl);
    }

    /**
     * 查询编码规则明细列表(关联主体)
     *
     * @param baseCodeRuledtl 编码规则明细
     * @return 编码规则明细
     */
    @Override
    public List<BaseCodeRuledtlVo> selectBaseCodeRuledtlVoList(BaseCodeRuledtl baseCodeRuledtl)
    {
        return baseCodeRuledtlMapper.selectBaseCodeRuledtVolList(baseCodeRuledtl);
    }

    /**
     * 新增编码规则明细
     * 
     * @param baseCodeRuledtl 编码规则明细
     * @return 结果
     */
    @Override
    public int insertBaseCodeRuledtl(BaseCodeRuledtl baseCodeRuledtl)
    {
        baseCodeRuledtl.setCreateTime(DateUtils.getNowDate());
        baseCodeRuledtl.setCreateBy(SecurityUtils.getUsername());
        if (baseCodeRuledtl.getRuleType().equals("numbering")){
            return baseCodeRuledtlMapper.insertBaseCodeRuledtl(baseCodeRuledtl);
        }
        baseCodeRuledtl.setPaddingSide(null);
        return baseCodeRuledtlMapper.insertBaseCodeRuledtl(baseCodeRuledtl);
    }

    /**
     * 修改编码规则明细
     * 
     * @param baseCodeRuledtl 编码规则明细
     * @return 结果
     */
    @Override
    public int updateBaseCodeRuledtl(BaseCodeRuledtl baseCodeRuledtl)
    {
        baseCodeRuledtl.setUpdateTime(DateUtils.getNowDate());
        if (baseCodeRuledtl.getRuleType().equals("numbering")){
            return baseCodeRuledtlMapper.updateBaseCodeRuledtl(baseCodeRuledtl);
        }
       baseCodeRuledtl.setPaddingLength(null);
       baseCodeRuledtl.setPaddingChar(null);
       baseCodeRuledtl.setInitValue(0);
       baseCodeRuledtl.setStep(null);
       baseCodeRuledtl.setPaddingSide(null);
       return baseCodeRuledtlMapper.updateBaseCodeRuledtlType(baseCodeRuledtl);
    }

    /**
     * 批量删除编码规则明细
     * 
     * @param ids 需要删除的编码规则明细主键
     * @return 结果
     */
    @Override
    public int deleteBaseCodeRuledtlByIds(Integer[] ids)
    {
        return baseCodeRuledtlMapper.deleteBaseCodeRuledtlByIds(ids);
    }

    /**
     * 删除编码规则明细信息
     * 
     * @param id 编码规则明细主键
     * @return 结果
     */
    @Override
    public int deleteBaseCodeRuledtlById(Integer id)
    {
        return baseCodeRuledtlMapper.deleteBaseCodeRuledtlById(id);
    }
}
