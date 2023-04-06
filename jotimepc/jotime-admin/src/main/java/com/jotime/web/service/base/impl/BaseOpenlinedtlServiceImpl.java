package com.jotime.web.service.base.impl;

import java.util.List;
import com.jotime.common.utils.DateUtils;
import com.jotime.web.domain.base.BaseOpenlinedtl;
import com.jotime.web.domainVo.base.BaseOpenlinedtlVo;
import com.jotime.web.mapper.base.BaseOpenlinedtlMapper;
import com.jotime.web.service.base.IBaseOpenlinedtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 开线检查内容Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-04
 */
@Service
public class BaseOpenlinedtlServiceImpl implements IBaseOpenlinedtlService
{
    @Autowired
    private BaseOpenlinedtlMapper baseOpenlinedtlMapper;

    /**
     * 查询开线检查内容
     *
     * @param id 开线检查内容主键
     * @return 开线检查内容
     */
    @Override
    public BaseOpenlinedtl selectBaseOpenlinedtlById(Long id)
    {
        return baseOpenlinedtlMapper.selectBaseOpenlinedtlById(id);
    }

    /**
     * 查询开线检查内容列表
     *
     * @param baseOpenlinedtl 开线检查内容
     * @return 开线检查内容
     */
    @Override
    public List<BaseOpenlinedtl> selectBaseOpenlinedtlList(BaseOpenlinedtl baseOpenlinedtl)
    {
        return baseOpenlinedtlMapper.selectBaseOpenlinedtlList(baseOpenlinedtl);
    }

    @Override
    public List<BaseOpenlinedtlVo> selectBaseOpenlinedtlVoList(BaseOpenlinedtl baseOpenlinedtl) {
        return baseOpenlinedtlMapper.selectBaseOpenlinedtlVoList(baseOpenlinedtl);
    }

    /**
     * 新增开线检查内容
     *
     * @param baseOpenlinedtl 开线检查内容
     * @return 结果
     */
    @Override
    public int insertBaseOpenlinedtl(BaseOpenlinedtl baseOpenlinedtl)
    {
        baseOpenlinedtl.setCreateTime(DateUtils.getNowDate());
        return baseOpenlinedtlMapper.insertBaseOpenlinedtl(baseOpenlinedtl);
    }

    /**
     * 修改开线检查内容
     *
     * @param baseOpenlinedtl 开线检查内容
     * @return 结果
     */
    @Override
    public int updateBaseOpenlinedtl(BaseOpenlinedtl baseOpenlinedtl)
    {
        baseOpenlinedtl.setUpdateTime(DateUtils.getNowDate());
        return baseOpenlinedtlMapper.updateBaseOpenlinedtl(baseOpenlinedtl);
    }

    /**
     * 批量删除开线检查内容
     *
     * @param ids 需要删除的开线检查内容主键
     * @return 结果
     */
    @Override
    public int deleteBaseOpenlinedtlByIds(Long[] ids)
    {
        return baseOpenlinedtlMapper.deleteBaseOpenlinedtlByIds(ids);
    }

    /**
     * 删除开线检查内容信息
     *
     * @param id 开线检查内容主键
     * @return 结果
     */
    @Override
    public int deleteBaseOpenlinedtlById(Long id)
    {
        return baseOpenlinedtlMapper.deleteBaseOpenlinedtlById(id);
    }
}
